package ws;

import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dao.ProductDAO;
import model.Product;
import util.MyWS;

@Path("/v1/products")
public class ProductREST extends MyWS{

    private  ProductDAO productDAO;

    public ProductREST(){
        productDAO = new ProductDAO();
    }


    @GET
    @Path("/getAll/{token}")
    @Produces("application/json")
    public Response getAll(@PathParam("token") String token) {
        List<Product> products = productDAO.getAll();
        return Response.status(200).entity(gson.toJson(products)).build();
    }

    @GET
    @Path("/categories/{token}")
    @Produces("application/json")
    public Response getAllCategories(@PathParam("token") String token) {
        System.out.println("getAllCategories");
        List<Product> products = productDAO.getAll();

        List<String> categories = products.stream().map(Product::getCategory)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        return Response.status(200).entity(gson.toJson(categories)).build();
    }

    @POST
    @Path("/update")
    @Produces("application/json")
    @Consumes("application/json;charset=UTF-8")
    public Response update(@FormParam("token") String token, @FormParam("product") String model) {
        System.out.println("update");
        System.out.println(model);


        try {
            Product product = gson.fromJson(model, Product.class);
            boolean result = productDAO.update(product);
            System.out.println("result: " + result);
            String output = result ? "OK" : "FAIL";

            return Response.status(200).entity(gson.toJson(output)).build();
        } catch (NullPointerException e) {
            return Response.status(400).entity("please, review the fields").build();
        } catch (JsonSyntaxException e) {
            return Response.status(400).entity("please, review the product json").build();
        }
    }

    @POST
    @Path("/add")
    @Consumes("application/json;charset=UTF-8")
    @Produces("application/json")
    public Response add(@FormParam("token") String token, @FormParam("product") String model) {
        System.out.println("add");
        System.out.println(model);

        try {
            Product product = new Gson().fromJson(model, Product.class);
            boolean result = productDAO.add(product);
            System.out.println("result: " + result);
            String output = result ? "OK" : "FAIL";

            return Response.status(200).entity(gson.toJson(output)).build();
        } catch (NullPointerException e) {
            return Response.status(400).entity("please, review the fields").build();
        } catch (JsonSyntaxException e) {
            return Response.status(400).entity("please, review the product json").build();
        }
    }

    @POST
    @Path("/changeStatus")
    @Consumes("application/json;charset=UTF-8")
    @Produces("application/json")
    public Response changeStatus(@FormParam("token") String token,
                                 @FormParam("enable") Boolean isEnable,
                                 @FormParam("uid") String uid) {

        System.out.println("changeStatus");
        System.out.println(uid);
        System.out.println(isEnable);
        System.out.println(token);

        try {
            Product product = productDAO.get(uid);
            product.setEnable(isEnable);
            boolean result = productDAO.update(product);
            System.out.println("result: " + result);
            String output = result ? "OK" : "FAIL";
            return Response.status(200).entity(gson.toJson(output)).build();
        } catch (NullPointerException e) {
            return Response.status(400).entity("please, review the fields").build();
        } catch (JsonSyntaxException e) {
            return Response.status(400).entity("please, review the  product uid").build();
        }
    }


    @GET
    @Path("/mobile/getAll")
    @Produces("application/json")
    public Response mobileGetAll() {
        List<Product> products = productDAO.mobileGetAll();
        return Response.status(200).entity(gson.toJson(products)).build();
    }
}

package mikroYazilim.com.apiTasks.stepDefs;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.*;
import mikroYazilim.com.apiTasks.postPOJO.Category;
import mikroYazilim.com.apiTasks.postPOJO.Example;
import mikroYazilim.com.apiTasks.postPOJO.Tag;
import org.junit.Assert;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;


public class apiTasksStepDef {
    Random random= new Random();


    @When("send GET request to api and verify status code")
    public void send_the_request_to_api_and_verify_status_code() {

        Response response= given().queryParam("status", "pending")
                        .when().get("https://petstore.swagger.io/v2/pet/findByStatus");
        response.prettyPrint();
        System.out.println("response.statusCode() = " + response.statusCode());
        Assert.assertEquals(200,response.statusCode());
    }


    @When("send POST request to api and verify status code")
    public void send_POST_Request_To_Api_And_Verify_Status_Code() {

        Category category= new Category();
        category.setId(25);
        category.setName("love");

        Tag tag= new Tag();
        tag.setId(25);
        tag.setName("love");

        Example example = new Example();
        example.setId(25);
        example.setStatus("available");
        example.setPhotoUrls(null);


        Response response= given().contentType("application/json")
                .and().body(example).and().body(category).and().body(tag).when()
                .post("https://petstore.swagger.io/v2/pet");

        System.out.println("response.statusCode() = " + response.statusCode());
        response.prettyPrint();
        Assert.assertEquals(200,response.statusCode());

    }

    @When("send PUT request to api and verify status code and updatedID {string}")
    public void sendPUTRequestToApiAndVerifyStatusCodeAndUpdatedID(String updatedID) {

        Map<String, Object> updateBody= new HashMap<>();
        updateBody.put("id",updatedID);
        updateBody.put("username","Johnathanxdt");
        updateBody.put("firstName","Johnathan");
        updateBody.put("lastName","xd");
        updateBody.put("email","Johnathan@gmail.com");
        updateBody.put("password","Johnathan12345");
        updateBody.put("phone","6767767676");
        updateBody.put("userStatus",5);

        Response response= given().pathParam("username", "johnBerk").accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and().body(updateBody).put("https://petstore.swagger.io/v2/user/{username}");
        response.prettyPrint();
        Assert.assertEquals(response.body().jsonPath().getString("message"), updatedID);
        Assert.assertEquals(200,response.statusCode());

    }


    @Given("create user {string} via api and send DELETE request to api verify status code")
    public void create_user_via_api(String username) {
        Map<String, Object> createUser= new HashMap<>();
        createUser.put("id",random.nextInt(50));
        createUser.put("username", username);
        createUser.put("firstName","lily");
        createUser.put("lastName","william");
        createUser.put("email","williamlily@gmail.com");
        createUser.put("password","william12345");
        createUser.put("phone","909090909");
        createUser.put("userStatus",9);

        Response response= given().accept(ContentType.JSON).and().contentType(ContentType.JSON)
                .body(createUser).post("https://petstore.swagger.io/v2/user");
        response.prettyPrint();
        Assert.assertEquals("the user didn't created",200,response.statusCode());

        Response response1= given().pathParam("username", username).delete("https://petstore.swagger.io/v2/user/{username}");
        response1.prettyPrint();
        Assert.assertEquals("the user didn't deleted", 200, response1.statusCode());

    }


    @When("send wrong GET request to api and verify status code")
    public void send_wrong_GET_request_to_api_and_verify_status_code() {
        Response response= given().queryParam("statustatat", "loading")
                .when().get("https://petstore.swagger.io/v2/pet/findByStatus");
        response.prettyPrint();
        System.out.println("response.statusCode() = " + response.statusCode());
        Assert.assertTrue(response.prettyPrint().contains(" "));
    }

    @When("send wrong POST request to api and verify status code")
    public void send_wrong_POST_request_to_api_and_verify_status_code() {

        Category category= new Category();
        category.setId(25);
        category.setName("love");

        Tag tag= new Tag();
        tag.setId(25);
        tag.setName("love");

        Example example = new Example();
        example.setId(25);
        example.setStatus("available");
        example.setPhotoUrls(null);


        Response response= given().contentType("application/json")
                .when().post("https://petstore.swagger.io/v2/pet");

        System.out.println("response.statusCode() = " + response.statusCode());
        response.prettyPrint();
        Assert.assertEquals(405,response.statusCode());
        Assert.assertEquals("unknown",response.body().jsonPath().getString("type"));
    }

    @When("send wrong PUT request to api and verify status code and updatedID {string}")
    public void send_wrong_PUT_request_to_api_and_verify_status_code_and_updatedID(String updatedID) {
        Map<String, Object> updateBody= new HashMap<>();
        updateBody.put("id",updatedID);
        updateBody.put("username","Johnathanxdt");
        updateBody.put("firstName","Johnathan");
        updateBody.put("lastName","xd");
        updateBody.put("email","Johnathan@gmail.com");
        updateBody.put("password","Johnathan12345");
        updateBody.put("phone","6767767676");
        updateBody.put("userStatus",5);

        Response response= given().pathParam("username", "Semih").accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and().body(updateBody).put("https://petstore.swagger.io/v2/user/{username}");
        response.prettyPrint();
        Assert.assertEquals("unknown",response.body().jsonPath().getString("type"));
    }

    @Given("create user {string} via api and send wrong DELETE request to api verify status code")
    public void create_user_via_api_and_send_wrong_DELETE_request_to_api_verify_status_code(String username) {
        Map<String, Object> createUser= new HashMap<>();
        createUser.put("id",random.nextInt(50));
        createUser.put("username", username);
        createUser.put("firstName","loves");
        createUser.put("lastName","william");
        createUser.put("email","williamlily@gmail.com");
        createUser.put("password","william12345");
        createUser.put("phone","909090909");
        createUser.put("userStatus",9);

        Response response= given().accept(ContentType.JSON).and().contentType(ContentType.JSON)
                .body(createUser).post("https://petstore.swagger.io/v2/user");
        response.prettyPrint();
        Assert.assertEquals("the user didn't created",200,response.statusCode());

        Response response1= given().pathParam("username", "Semih").delete("https://petstore.swagger.io/v2/user/{username}");
        response1.prettyPrint();
        System.out.println("response1.statusCode() = " + response1.statusCode());
        Assert.assertEquals("the user didn't deleted", 404, response1.statusCode());
    }


}

package step_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import post.PetPojo;

import java.util.Map;

public class PetStepDefs {
    Response response;
    Response response2;
    @Given("i have a valid url to create a pet")
    public void i_have_a_valid_url_to_create_a_pet() {
        RestAssured.baseURI="https://petstore.swagger.io";
        RestAssured.basePath="v2/pet";
    }
    @When("i send POST request to create a pet")
    public void i_send_post_request_to_create_a_pet() {
        PetPojo pet = new PetPojo();
        pet.setStatus("available");
        pet.setName("buzzy");
        pet.setId(223344);
   response=RestAssured.given().accept("application/json")
        .contentType("application/json")
        .body(pet)
          .when().post();

    }
    @Then("status code should be {int}")
    public void status_code_should_be(int expectedStatusCode) {
int actualstatusCode=response.statusCode();
        Assert.assertEquals(expectedStatusCode,actualstatusCode);
    }
    @Then("response should be json format")
    public void response_should_be_json_format() {
        String actualContentType= response.getContentType();
        Assert.assertEquals("application/json",actualContentType);
    }

    @Given("i have a valid url to get a pet")
    public void i_have_a_valid_url_to_get_a_pet() {
        RestAssured.baseURI="https://petstore.swagger.io";
RestAssured.basePath="v2/pet";
    }
    @When("i send a GET request to retireive a pet with {int} id")
    public void i_send_a_get_request_to_retireive_a_pet_with_id(Integer petID) {
       response2=RestAssured.given().accept("application/json")
               .when().get(String.valueOf(petID))
               .then().extract().response();

    }
    @Then("status code {int}")
    public void status_code(int stC) {
        RestAssured.given().then().statusCode(stC);

    }
    @Then("response body should cpntain {int} id")
    public void response_body_should_cpntain_id(int id) {
        Map<String,Object> petIDValidation= (Map<String, Object>) response2.as(new TypeRef<Object>() {
        });
Assert.assertEquals(id,petIDValidation.get("id"));
    }

    @Given("i have a valid url to update a pet")
    public void i_have_a_valid_url_to_update_a_pet() {

    }
    @When("I send PUT request to update a pet")
    public void i_send_put_request_to_update_a_pet() {

    }
    @Then("the status code should {int}")
    public void the_status_code_should(Integer int1) {

    }
    @Then("response should be application_json")
    public void response_should_be_application_json() {

    }


















}

package put;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import post.PetPojo;
import post.Slack;

import java.util.Map;

public class Pet {

    @Before
    public void setup(){
        RestAssured.baseURI="https://petstore.swagger.io";
                RestAssured.basePath="v2/pet";
    }

    @Test
    public void updatePetTest(){

        PetPojo pet= new PetPojo();
        pet.setName("pet from java");
        pet.setId(12345);
        pet.setStatus("foughali");
        Response response = RestAssured.given()
                .accept(Slack.APPLICAAATION_JSON)
                .contentType(Slack.APPLICAAATION_JSON)
                .body(pet)
                .when().put()
                .then().statusCode(200).extract().response();
      Map<String,Object> deserilization=  response.as(new TypeRef<Map<String,Object>>() {
        });
     String name=String.valueOf(deserilization.get("name"));
        Assert.assertEquals("pet from java",name);
        int id= (int) deserilization.get("id");
        Assert.assertEquals(12345,id);

    }
}

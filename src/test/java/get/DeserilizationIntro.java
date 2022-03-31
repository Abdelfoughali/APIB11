package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class DeserilizationIntro {
//https://petstore.swagger.io/v2/pet/775
//    @Test
//    public void testPet(){
//      Response response= RestAssured.given().header("Accept","application/json")
//                .when()
//                .get("https://petstore.swagger.io/v2/pet/1")
//                .then().statusCode(200).extract().response();
//        Map<String,Object>deserializedResponse=response.as(new TypeRef<Map<String, Object>>() {});
//        System.out.println(deserializedResponse);
//        Assert.assertEquals(1,deserializedResponse.get("id"));
//    }


    @Test
    public void practice1(){
        Response response = RestAssured.given().header("Accept", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/12")
                .then().statusCode(200).extract().response();
        Map<String,Object> deserilizationResponse= response.as(new TypeRef<Map<String, Object>>() {
        });
        Assert.assertEquals(deserilizationResponse.get("id"),12);
        Map<String,Object> response111= (Map<String, Object>) deserilizationResponse.get("category");
       Assert.assertEquals(response111.get("id"),0);

    }

}

package post;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import utilis.PayLoadUtil;

public class Pet {
    String petName="foughali";
    int id=34982;
    String Status="oullache";
    @Test
    public void createPetTest(){

        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(PayLoadUtil.getPetPayLoad(id,petName,Status))

                .when().post("https://petstore.swagger.io/v2/pet")
                .then().statusCode(200).extract().response();
        PetPojo parseRespone = response.as(PetPojo.class);
        Assert.assertEquals(id,parseRespone.getId());
        Assert.assertEquals(petName,parseRespone.getName());
        Assert.assertEquals(Status,parseRespone.getStatus());

        /*
        add get Https://petstore.swagger.io/v2/pet/{yourPetID}
        validate name ,is status are still same
         */

       RestAssured.given()
              .header("Accept","application/json")
               .when()
                .get("https://petstore.swagger.io/v2/pet/"+id)
                .then().statusCode(200)
               .and()
               .body("id", Matchers.is(id))
               .and()
               .body("name",Matchers.equalTo(petName))
               .body("status",Matchers.equalTo(Status))
               .body("category.id",Matchers.is(0));





    }



}

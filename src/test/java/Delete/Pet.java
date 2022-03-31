package Delete;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import utilis.PayLoadUtil;

public class Pet {
    int id= 22222;
    String name ="chat";
    String status="eating";


    @Test
    public void deletePetTest(){
        RestAssured.given().accept("application/json")
                .when().delete(String.valueOf(id)).then().statusCode(200);
    }


    @Before
    public void setup(){
        RestAssured.baseURI="https://petstore.swagger.io";
        RestAssured.basePath="v2/pet";
        RestAssured.given().contentType("application/json")
                .accept("application/json")
                .body(PayLoadUtil.getPetPayLoad(id,name,status))
                .when().post()
                .then().statusCode(200);


    }

// DELETE : https

}

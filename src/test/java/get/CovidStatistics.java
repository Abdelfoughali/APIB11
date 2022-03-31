package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class CovidStatistics {
    //send the get request to the endpoint
    //https://corona.lmao.ninja/v2/all
    //validate status the code=200
    //Deserialize the response
    // validate affectedCountries=227
    @Test
    public void affectedcontry(){
       Response response= RestAssured.given().header("Accept","application/json")
                .when()
                .get("https://corona.lmao.ninja/v2/all")
                .then()
                .statusCode(502).extract().response();
        Map<String,Object> deserializedResponse= response.as(new TypeRef<Map<String, Object>>() {
        });
       int affecteddCountries=(int) deserializedResponse.get("affectedCountries");
        Assert.assertEquals(227,affecteddCountries);

    }


}

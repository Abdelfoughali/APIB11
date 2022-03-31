package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class CatFacts {
    /*Get https://cat-fact.herokuapp.com/facts
    print out only facts
     */

@Test
    public void catFactsTests(){
   Response response= RestAssured.given().header("Accept","application/json")
            .when()
            .get("https://cat-fact.herokuapp.com/facts")
            .then()
            .statusCode(503).extract().response();
    List<Map<String,Object>> catFactsList=response.as(new TypeRef<List<Map<String, Object>>>() {
    });
    //list <string>

    for (int i = 0; i < catFactsList.size(); i++) {
       Map<String,Object> catFactMap= catFactsList.get(i);
        System.out.println(catFactMap.get("text"));


    }

}

@Test
    public void lastCatFact(){
/*
Get https://cat-fact.herokuapp.com/facts
validate the last cat fact equals to:
Cats are the most popular pet in the United States: There are 88 million pet cats and 74 million dogs.
 */


    Response response= RestAssured.given().header("Accept","application/json")
            .when()
            .get("https://cat-fact.herokuapp.com/facts")
            .then()
            .statusCode(200).extract().response();
    List<Map<String,Object>> parseRESPONSE=response.as(new TypeRef<List<Map<String, Object>>>() {
    });
    //list <string>
int count=0;
for(Map<String,Object> validatecount:parseRESPONSE) {
    Map<String, Object> lastFact = parseRESPONSE.get(parseRESPONSE.size() - 1);
    String actualLastFact = lastFact.get("text").toString();
    String expectedFact = "Cats are the most popular pet in the United States: There are 88 million pet cats and 74 million dogs.";
    Assert.assertEquals(expectedFact, actualLastFact);
   count++;
}
Assert.assertTrue(count>4);
}

}

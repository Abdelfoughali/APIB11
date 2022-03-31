package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.StarsWarsCharactersPojo;
import pojo.StarsWarsPojo;


import java.util.List;
import java.util.Map;

public class StarsWars {


    @Test
    public void femalecarcters(){


        Response response = RestAssured.given().header("Accepted", "application/json")
                .when()
                .get("https://swapi.dev/api/people")
                .then()
                .statusCode(200).extract().response();
        Map<String,Object> parseResponse=response.as(new TypeRef<Map<String, Object>>() {
        });

      List<Map<String,Object>> ListOfCharcters=(List<Map<String,Object>>) parseResponse.get("results");
int count=0;
        for (int i = 0; i <ListOfCharcters.size() ; i++) {

                Map<String,Object> charMap=ListOfCharcters.get(i);
                if (charMap.get("gender").equals("female")){
                    ++count;
                }

        }
        Assert.assertTrue(count>0);
        System.out.println(count);
    }

    @Test
    public void validation2(){
        Response response = RestAssured.given().header("Accepted", "application/json")
                .when()
                .get("https://swapi.dev/api/people")
                .then()
                .statusCode(200).extract().response();
        Map<String,Object> parseResponse=response.as(new TypeRef<Map<String, Object>>() {
        });



        List<Map<String,Object>> ListOfCharcters=(List<Map<String,Object>>) parseResponse.get("results");

        for (int i = 0; i <ListOfCharcters.size() ; i++) {

            Map<String,Object> charMap=ListOfCharcters.get(2);

            Assert.assertEquals(charMap.get("name"),"R2-D2");
            Assert.assertEquals(charMap.get("height"),"96");

        }





    }


    @Test
    public void deserilizationWithPojo(){
        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .when().get("https://swapi.dev/api/people")
                .then().statusCode(200).extract().response();

        StarsWarsPojo deserializedResp = response.as(StarsWarsPojo.class);
        Assert.assertEquals(82, deserializedResp.getCount());


//        List<Map<String, Object>> results = deserializedResp.getResults();
//
//        for (Map<String, Object> map : results) {
//            System.out.println(map.get("name"));
//        }


        List<StarsWarsCharactersPojo> results = deserializedResp.getResults();

        System.out.println(results.get(0).getName());

        for (StarsWarsCharactersPojo character : results) {
            System.out.println(character.getName());
        }

    }
}

package get;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import  static  io.restassured.RestAssured.*;
public class DeserilizationPokemon {



    @Test
    public void pokemonGet(){

        Response response = given().when().get("https://pokeapi.co/api/v2/pokemon")
                .then().extract().response();
        Assert.assertTrue(response.statusCode()==200);
        Map<String,Object> pokemResponse= response.as(new TypeRef<Map<String, Object>>() {
        });
        //System.out.println(pokemResponse);
        List<Map<String,Object>> results= (List<Map<String, Object>>) pokemResponse.get("results");
        boolean isThereBulbasauar=false;
        for (Map<String,Object> info:results){
            if (info.get("name").equals("bulbasaur")){
                isThereBulbasauar=true;
                break;
            }
        }
Assert.assertTrue("there is bulbasaur",isThereBulbasauar);

    }



}

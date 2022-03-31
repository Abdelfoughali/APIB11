package get;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pojo.PokemonPojo;

import java.util.List;
import java.util.Map;

public class Pokemon {
    /*
    Get https://https://pokeapi.co/api/v2/pokemon
    deserialize response with Pojo
    validate the count=1126
    Construct a new map of pokemon name(Key), url(value)
     */


    @Before //hook
    public void steup() {
        RestAssured.baseURI = "https://pokeapi.co";

        RestAssured.basePath = "api/v2/pokemon";
    }

    @Test
    public void deserilizationPokemonWithPojo() {

        Response response = RestAssured.given().header("Accept", "application/json")
                .when().get()
                .then().statusCode(200).extract().response();
        PokemonPojo parsedResponse = response.as(PokemonPojo.class);
        Assert.assertEquals(1126, parsedResponse.getCount());
    }

    @Test
    public void deserlizitionPokemonPojo1() {
        Response response = RestAssured.given().header("Accept", "application/json")
                .when().get()
                .then().statusCode(200).extract().response();
        JsonPath jsonPath = response.jsonPath();
        String nextUrl = jsonPath.getString("next");
        System.out.println(nextUrl);
        String pokemonOneName = jsonPath.getString("results[0].name");
        // System.out.println(pokemonOneName);

        List<Map<String, String>> resultsname = jsonPath.getList("results");
        for (Map<String, String> pokemon : resultsname) {
            System.out.println(pokemon.get("name"));
        }


    }

    @Test
    public void deserlizitionPokemonPojo2() {
         RestAssured.given().header("Accept", "application/json").log().all()// print only the request
                .when().get()
                .then().statusCode(200).body("count", Matchers.equalTo(1126))
                 .and()
                 .body("next",Matchers.is("https://pokeapi.co/api/v2/pokemon?offset=20&limit=20"))
                // .log().all();  // i can print whatever  i want
                 .log().body();


    }
}
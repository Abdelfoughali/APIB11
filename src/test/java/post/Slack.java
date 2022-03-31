package post;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import pojo.SlackPojoClass;
import utilis.PayLoadUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Slack {

    public static  final String APPLICAAATION_JSON="application/json";


    @Before // hook
    public void setup(){
        RestAssured.baseURI="https://slack.com";
        RestAssured.basePath="api/chat.postMessage";
    }

    @Test
    public void slackMeassageTest(){


        RestAssured.given()
                .accept("application/json")// instead of . header("Accept","application/json)
                .contentType("application/json")
                .header("Authorization","Bearer xoxb-2694972852931-3301004561938-5HbvEoX49duFra8t1Gmd8iyj")
                .body(PayLoadUtil.getSlackMeassagePayLoad("hello from java"))
                .when().post()
                .then().statusCode(200)
                .body("ok", Matchers.is(true));
    }

    @Test
    public void sendMessageText(){
       // Map<String,String> slcakMessageMap= new HashMap<>();
        Map<String,String> slcakMessageMap= new HashMap<>();
        slcakMessageMap.put("channel","C0397J4JY3T");
        slcakMessageMap.put("text","ggggg:hello API");

        RestAssured.given()
                .accept(APPLICAAATION_JSON)
                .contentType(APPLICAAATION_JSON)
                .auth().oauth2("xoxb-2694972852931-3301004561938-5HbvEoX49duFra8t1Gmd8iyj")
                .body(slcakMessageMap)
                .when().post()
                .then().statusCode(200)
                .and()
                .body("ok",Matchers.equalTo(true));


    }
    @Test
    public void sendmessagejson(){
//src/test/resources/SlackMessage.json // location of the json file copy content root
        File slackMessageFile= new File("src/test/resources/SlackMessage.json");

        RestAssured.given()
                .accept(APPLICAAATION_JSON)
                .contentType(APPLICAAATION_JSON)
                .auth().oauth2("xoxb-2694972852931-3301004561938-5HbvEoX49duFra8t1Gmd8iyj")
                .body(slackMessageFile)
                .when().post()
                .then().statusCode(200)
                .and().body("ok",Matchers.is(true));



    }


    @Test
    public void sendMessageWithPojoTest(){
        SlackPojoClass slackPojoClass= new SlackPojoClass();
        slackPojoClass.setText("Dinnnnnnnnnnnnnooooooooooooo");
        slackPojoClass.setChannel("C0397J4JY3T");
        RestAssured.given()
                .accept(APPLICAAATION_JSON)
                .contentType(APPLICAAATION_JSON)
                .auth().oauth2("xoxb-2694972852931-3301004561938-aacdTvY8jFOXXe6YvdGZ7efn")
                .body(slackPojoClass)
                .when().post()
                .then().statusCode(200);





    }
}

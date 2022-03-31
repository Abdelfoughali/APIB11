package utilis;

public class PayLoadUtil {

    public static  String getPetPayLoad(int id,String petName,String petStatus){

        String petPayLoad="{\n" +
                "  \"id\":"+id+",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \""+petName+"\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"ajou\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \""+petStatus+"\"\n" +
                "}";
        return petPayLoad;
    }


    public static String getSlackMeassagePayLoad(String message){
        String payload="{\n" +
                "    \"channel\":\"C0397J4JY3T\",\n" +
                "    \"text\":\"foughali:"+message+"\"\n" +
                "}";


return payload;

    }


}

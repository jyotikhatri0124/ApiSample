package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.example.Utils.FoodServiceUtils;
import org.example.models.FoodOutletResponse;
import org.testng.annotations.Test;
import java.util.HashMap;


// Example for fetching values from response. you can use object mapper and map values with response or can use readTree method as well.

//this method will print all food outlet name with high rating.
public class FoodOutletResponseVerification {


    Response response;
    ObjectMapper objectMapper;
    HashMap<String,HashMap<String,Float>> responseMap= new HashMap<>();
    HashMap<String,Float> data= new HashMap<>();

    @Test
    public void getFoodOutletResponse(){
        response= FoodServiceUtils.getFoodOutletResponse(1);
        objectMapper=new ObjectMapper();

        try {

             FoodOutletResponse foodOutletResponse= objectMapper.readValue(response.asString(), FoodOutletResponse.class);
             int totalPage=foodOutletResponse.getTotal_pages();
             float maxRating=Integer.MIN_VALUE;


             for(int i=1;i<=totalPage;i++) {
                 response  = FoodServiceUtils.getFoodOutletResponse(i);
                 foodOutletResponse= objectMapper.readValue(response.asString(), FoodOutletResponse.class);

               for(int j=0;j<foodOutletResponse.getData().size();j++) {
                   float rating = foodOutletResponse.getData().get(j).getUser_rating().getAverage_rating();
                   if(maxRating<rating){
                       maxRating=rating;
                   }
                   if(rating==maxRating) {
                       String city = foodOutletResponse.getData().get(j).getCity();
                       String name = foodOutletResponse.getData().get(j).getName();

                       data.put(city,rating);
                       responseMap.put(name, data);
                   }

               }

           }
            System.out.println(responseMap);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
//            JsonNode jsonNode=objectMapper.readTree(response.asString());
//            int total=jsonNode.get("total").intValue();
//            System.out.println(total);
//            System.out.println(jsonNode.get("data"));
//            System.out.println(jsonNode.get("data").get(0).get("city").asText());

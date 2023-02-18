package org.example.Utils;

import io.restassured.response.Response;
import org.example.contants.DataConstants;
import org.example.contants.URIConstants;
import java.util.HashMap;

public class FoodServiceUtils {
    static String FOOD_OUTLET_END_POINT;

    static {
        FOOD_OUTLET_END_POINT = URIConstants.FOOD_OUTLET_END_POINT;
    }


    public static Response getFoodOutletResponse(int page){
        HashMap<String,Integer> params= new HashMap<>();
        params.put(DataConstants.PAGE_PARAM,page);
        Response response= RestUtil.getResponse(FOOD_OUTLET_END_POINT,params);
        return response;
    }
}

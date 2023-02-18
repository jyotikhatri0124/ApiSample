package org.example.Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;

public class RestUtil {

    public static Response getResponse(String url, HashMap<String,Integer> params){
        Response response=RestAssured.given().params(params).log().everything().get(url);
        return response;
    }
}

package org.example.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class FoodOutletResponse {

    int page;
    int per_page;
    int total;
    int total_pages;
    ArrayList<FoodOutletData> data;


}

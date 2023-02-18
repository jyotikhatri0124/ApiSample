package org.example.models;

import lombok.Data;

@Data
public class FoodOutletData {

    String city;
    String name;
    int estimated_cost;
    UserRating user_rating;
    int id;
}

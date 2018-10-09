package com.example.myplaces;

public interface IPlace {

    Place get(int id); //get element by ID

    void add(Place place); //add Place

    int add(); //add empty Place and returns its ID

    void delete(int id); //delete by ID

    int size(); //returns number of elements

    void update(int id, Place place); //update Place
}

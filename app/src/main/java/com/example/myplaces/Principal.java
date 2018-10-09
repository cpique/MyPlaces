package com.example.myplaces;

public class Principal {

    public static void main(String[] main)
    {
        PlacesCollection places = new PlacesCollection();

        for (int i = 0; i < places.size(); i++)
        {
            System.out.println(places.get(i).toString());
        }
    }
}

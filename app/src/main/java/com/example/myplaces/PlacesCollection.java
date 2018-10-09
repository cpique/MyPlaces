package com.example.myplaces;

import java.util.ArrayList;
import java.util.List;

public class PlacesCollection implements IPlace {

    protected List<Place> listPlaces = mockPlaces();

    public PlacesCollection() {
        this.listPlaces = mockPlaces();
    }

    public Place get(int id)
    {
        return this.listPlaces.get(id);
    }

    public void add(Place place)
    {
        this.listPlaces.add(place);
    }

    public int add()
    {
        Place place = new Place();
        this.listPlaces.add(place);
        return this.listPlaces.size() - 1;
    }

    public void delete(int id)
    {
        this.listPlaces.remove(id);
    }

    public int size()
    {
        return this.listPlaces.size();
    }

    public void update(int id, Place place)
    {
        this.listPlaces.set(id,place);
    }





    public static ArrayList<Place> mockPlaces()
    {
        ArrayList<Place> places = new ArrayList<Place>();

        Place p1 = new Place("Tivoli Gardens", "Vesterbrogade 3, 1630 København V, Dinamarca",
                55.673611, 12.568333, TypePlace.NATURE, 4533151001L, "tivoli.dk",
                "19th century amusement park (open from Apr. to Sept.) with old roller coaster and live shows.\n",
                5);

        Place p2 = new Place("Københavns Lufthavn", "Lufthavnsboulevarden 6, 2770 Kastrup, Dinamarca",
                55.628611, 12.649167, TypePlace.OTHERS, 4532313231L, "www.cph.dk",
                "Copenhagen Airport and southern Sweden for regional and international flights and train links.\n",
                5);

        Place p3 = new Place("Parken Stadion", "Per Henrik Lings Allé 2, 2100 København, Dinamarca",
                55.702469, 12.572203, TypePlace.SPORTS, 4535433131L, "teliaparken.dk",
                "Football stadium in the Indre Østerbro district of Copenhagen, Denmark, built from 1990–1992\n",
                4);

        Place p4 = new Place("Freetown Christiania", "Pusher Street, 1440, København, Dinamarca",
                55.673589, 12.599711, TypePlace.NATURE, 0L, "www.christiania.org/",
                "Partially self-governed neighbourhood of about 1000 residents. It covers an area of 34 hectares in the Christianshavn district in Denmark's capital, Copenhagen.\n",
                5);

        places.add(p1);
        places.add(p2);
        places.add(p3);
        places.add(p4);

        return places;
    }
}

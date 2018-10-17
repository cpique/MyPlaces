package com.example.myplaces;

public enum TypePlace {

    OTHERS("Others", R.drawable.otros),
    RESTAURANT("Restaurant", R.drawable.restaurante),
    BAR("Bar", R.drawable.bar),
    DRINKS("Drinks", R.drawable.copas),
    SHOWS("Shows", R.drawable.espectaculos),
    HOTEL("Hotel", R.drawable.hotel),
    SHOPPING("Shopping", R.drawable.compras),
    EDUCATION("Education", R.drawable.educacion),
    SPORTS("Sports", R.drawable.deporte),
    NATURE("Nature", R.drawable.naturaleza),
    GASSTATION("Gas station", R.drawable.gasolinera);

    private final String text;
    private final int resource;

    TypePlace(String text, int resource) {
        this.text = text;
        this.resource = resource;
    }

    public static String[] getNames() {
        String[] result = new String[TypePlace.values().length];
        for(TypePlace type: TypePlace.values()) {
            result[type.ordinal()] = type.text;
        }
        return result;
    }

    public String getText() {
        return text;
    }

    public int getResource() {
        return resource;
    }
}

package com.example.myplaces;

public class Place {
    private String name;
    private String address;
    private String photo;
    private String url;
    private String comment;
    private long phone;
    private long date;
    private float ranking;
    private GeoPoint position;
    private TypePlace type;

    public Place()
    {
        this.date = System.currentTimeMillis();
        this.position = new GeoPoint(0,0);
        this.type = TypePlace.OTHERS;
    }

    public Place(String name, String address, double latitude, double longitude, TypePlace type, long phone, String url, String comment, int ranking) {
        this.date = System.currentTimeMillis();
        this.position = new GeoPoint(latitude, longitude);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.url = url;
        this.comment = comment;
        this.ranking = ranking;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public float getRanking() {
        return ranking;
    }

    public void setRanking(float ranking) {
        this.ranking = ranking;
    }

    public GeoPoint getPosition() {
        return position;
    }

    public void setPosition(GeoPoint position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", photo='" + photo + '\'' +
                ", url='" + url + '\'' +
                ", comment='" + comment + '\'' +
                ", phone=" + phone +
                ", date=" + date +
                ", ranking=" + ranking +
                ", position=" + position +
                ", type=" + type +
                '}';
    }

    public TypePlace getType() {
        return type;
    }

    public void setType(TypePlace type) {
        this.type = type;
    }
}

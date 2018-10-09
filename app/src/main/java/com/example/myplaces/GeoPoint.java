package com.example.myplaces;

public class GeoPoint {
    private double longitude, latitude;

    public GeoPoint(double latitude, double longitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "GeoPoint{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    public double getDistance(GeoPoint point)
    {
        final double RADIUS_EARTH = 6371000; //meters
        double dLat = Math.toRadians(latitude - point.latitude);
        double dLon = Math.toRadians(longitude - point.longitude);
        double lat1 = Math.toRadians(point.latitude);
        double lat2 = Math.toRadians(latitude);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.sin(dLon/2) * Math.sin(dLon/2)
                * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return c * RADIUS_EARTH;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}

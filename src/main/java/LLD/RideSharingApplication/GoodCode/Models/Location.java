package main.java.LLD.RideSharingApplication.GoodCode.Models;

public class Location {

    private double longitude;
    private double latitude;
    private static final double EARTH_RADIUS = 6371.0;

    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
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

    public double distanceTo(Location l) {
        double lat1Rad = Math.toRadians(latitude);
        double lon1Rad = Math.toRadians(longitude);
        double lat2Rad = Math.toRadians(l.getLatitude());
        double lon2Rad = Math.toRadians(l.getLongitude());

        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }
}

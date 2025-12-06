package main.java.DesignPatterns.CreationalPatterns.BuilderPattern;

public class Flat {

    private String owner;
    private String area;
    private String street;
    private String locality;
    private String city;
    private String state;
    private boolean hasBalcony;
    private boolean hasParking;
    private boolean hasStoreRoom;
    private String landmark;
    private String facing;

    private Flat(FlatBuilder flatBuilder) {
        this.owner = flatBuilder.owner;
        this.area = flatBuilder.area;
        this.street = flatBuilder.street;
        this.locality = flatBuilder.locality;
        this.city = flatBuilder.city;
        this.state = flatBuilder.state;
        this.hasBalcony = flatBuilder.hasBalcony;
        this.hasParking = flatBuilder.hasParking;
        this.hasStoreRoom = flatBuilder.hasStoreRoom;
        this.landmark = flatBuilder.landmark;
        this.facing = flatBuilder.facing;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public boolean isHasParking() {
        return hasParking;
    }

    public void setHasParking(boolean hasParking) {
        this.hasParking = hasParking;
    }

    public boolean isHasStoreRoom() {
        return hasStoreRoom;
    }

    public void setHasStoreRoom(boolean hasStoreRoom) {
        this.hasStoreRoom = hasStoreRoom;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getFacing() {
        return facing;
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "owner='" + owner + '\'' +
                ", area='" + area + '\'' +
                ", street='" + street + '\'' +
                ", locality='" + locality + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", hasBalcony=" + hasBalcony +
                ", hasParking=" + hasParking +
                ", hasStoreRoom=" + hasStoreRoom +
                ", landmark='" + landmark + '\'' +
                ", facing='" + facing + '\'' +
                '}';
    }

    public static class FlatBuilder{
        private String owner;
        private String area;
        private String street;
        private String locality;
        private String city;
        private String state;
        private boolean hasBalcony;
        private boolean hasParking;
        private boolean hasStoreRoom;
        private String landmark;
        private String facing;


        //for all the madatory fields
        public FlatBuilder(String owner,String area,String street,String locality,String city,String state){
            this.owner=owner;
            this.area=area;
            this.street=street;
            this.locality=locality;
            this.city=city;
            this.state=state;
        }

        public FlatBuilder setHasBalcony(boolean hasBalcony){
            this.hasBalcony=hasBalcony;
            return this;
        }
        public FlatBuilder setHasParking(boolean hasParking){
            this.hasParking=hasParking;
            return this;
        }

        public FlatBuilder setHasStoreRoom(boolean hasStoreRoom){
            this.hasStoreRoom=hasStoreRoom;
            return this;
        }
        public FlatBuilder setLandmark(String landmark){
            this.landmark=landmark;
            return this;
        }
        public FlatBuilder setFacing(String facing){
            this.facing=facing;
            return this;
        }

        public Flat build(){
            return new Flat(this);
        }

    }
}

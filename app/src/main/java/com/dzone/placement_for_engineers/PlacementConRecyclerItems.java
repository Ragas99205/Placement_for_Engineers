package com.dzone.placement_for_engineers;

public class PlacementConRecyclerItems
{
    String name;
    String address;
    String locality;
    String url;

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

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PlacementConRecyclerItems(String name, String address, String locality, String url) {
        this.name = name;
        this.address = address;
        this.locality = locality;
        this.url = url;
    }


}

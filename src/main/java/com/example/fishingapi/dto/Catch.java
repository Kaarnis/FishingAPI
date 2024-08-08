package com.example.fishingapi.dto;

public class Catch {
    private String fish;
    private String weight;
    private String location;

    public Catch(String fish, String weight, String location) {
        this.fish = fish;
        this.weight = weight;
        this.location = location;
    }

    public String getFish() {
        return fish;
    }

    public void setFish(String fish) {
        this.fish = fish;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

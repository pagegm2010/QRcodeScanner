package com.example.nitro5.myqrcodescanner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("ingredient")
    @Expose
    private String ingredient;
    @SerializedName("properties")
    @Expose
    private String properties;
    @SerializedName("howtoeat")
    @Expose
    private String howtoeat;
    @SerializedName("warning")
    @Expose
    private String warning;
    @SerializedName("keeping")
    @Expose
    private String keeping;
    public Product(int id, String name, String ingredient,String properties, String warning,String keeping ) {
        this.id = id ;
        this.name = name;
        this.ingredient = ingredient;
        this.properties = properties;
        this.howtoeat = howtoeat;
        this.warning = warning;
        this.keeping = keeping;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIngredient() {
        return ingredient;
    }
    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
    public String getProperties() {
        return properties;
    }
    public void setProperties(String properties) {
        this.properties = properties;
    }
    public String getHowtoeat() {
        return howtoeat;
    }
    public void setHowtoeat(String howtoeat) {
        this.howtoeat = howtoeat;
    }
    public String getKeeping() {
        return keeping;
    }
    public void setKeeping(String keeping) {
        this.keeping = keeping;
    }
    public String getWarning() {
        return warning;
    }
    public void setWarning(String warning) {
        this.warning = warning;
    }

}

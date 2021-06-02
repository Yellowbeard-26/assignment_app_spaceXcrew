//package com.example.assignment;
//
//import androidx.room.Entity;
//import androidx.room.PrimaryKey;
//
//@Entity(tableName = "Crew_table")
//public class Crew {
//
//    @PrimaryKey(autoGenerate = true)
//    private int id;
//
//    private String name;
//    private String agency;
//    private String imageurl;
//    private String wikipedia;
//    private String status;
//
//    public Crew(String name, String agency, String imageurl, String wikipedia, String status) {
//        this.name = name;
//        this.agency = agency;
//        this.imageurl = imageurl;
//        this.wikipedia = wikipedia;
//        this.status = status;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAgency() {
//        return agency;
//    }
//
//    public void setAgency(String agency) {
//        this.agency = agency;
//    }
//
//    public String getImageurl() {
//        return imageurl;
//    }
//
//    public void setImageurl(String imageurl) {
//        this.imageurl = imageurl;
//    }
//
//    public String getWikipedia() {
//        return wikipedia;
//    }
//
//    public void setWikipedia(String wikipedia) {
//        this.wikipedia = wikipedia;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//}package com.example.assignment;
//
//import androidx.annotation.NonNull;
//
//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;
//
//import java.util.List;
//
//public class CrewData {
//
//    @SerializedName("name")
//    @Expose
//    private String name;
//    @SerializedName("agency")
//    @Expose
//    private String agency;
//    @SerializedName("image")
//    @Expose
//    private String image;
//    @SerializedName("wikipedia")
//    @Expose
//    private String wikipedia;
//    @SerializedName("launches")
//    @Expose
//    private List<String> launches = null;
//    @SerializedName("status")
//    @Expose
//    private String status;
//    @SerializedName("id")
//    @Expose
//    private String id;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAgency() {
//        return agency;
//    }
//
//    public void setAgency(String agency) {
//        this.agency = agency;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public String getWikipedia() {
//        return wikipedia;
//    }
//
//    public void setWikipedia(String wikipedia) {
//        this.wikipedia = wikipedia;
//    }
//
//    public List<String> getLaunches() {
//        return launches;
//    }
//
//    public void setLaunches(List<String> launches) {
//        this.launches = launches;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    @NonNull
//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ",Agency=" + agency +
//                ",Image" + image+ '\'' +
//                ", Wikipedia='" + wikipedia + '\'' +
//                ", Status'" + status;
//
//    }
//
package com.example.assignment;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Crew_table",indices = @Index(value = {"name"},unique = true))
public class Crew {

    @PrimaryKey(autoGenerate = true)
    private int crewid;

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("agency")
    @Expose
    private String agency;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("wikipedia")
    @Expose
    private String wikipedia;
    @SerializedName("status")
    @Expose
    private String status;

    public Crew(String name, String agency, String image, String wikipedia, String status) {
        this.name = name;
        this.agency = agency;
        this.image = image;
        this.wikipedia = wikipedia;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCrewid() {
        return crewid;
    }

    public void setCrewid(int id) {
        this.crewid = id;
    }
}



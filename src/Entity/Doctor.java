package Entity;

import utility.Designation;

public class Doctor {
    String name;
    Designation designation;
    Float rating;
    Integer id;

    public Doctor(String name, Designation designation,Integer id) {
        this.name = name;
        this.designation = designation;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}

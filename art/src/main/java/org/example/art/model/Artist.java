package org.example.art.model;

import java.util.Objects;

public class Artist {
    private int id;
    private String name;
    private String surname;
    private int birthYear;
    private String country;

    public Artist() {}

    public Artist(int id, String name, String surname, String country, int birthYear) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.birthYear = birthYear;
    }

    public Artist(String name, String surname, String country, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.birthYear = birthYear;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void displayInfo() {
        System.out.println("Artist: " + this.name + " " + this.surname + ", Country: " + this.country + ", Birth Year: " + this.birthYear);
    }

    public String toString() {
        return this.name + " " + this.surname + " (" + this.country + ", " + this.birthYear + ")";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Artist artist = (Artist)obj;
            return this.birthYear == artist.birthYear && Objects.equals(this.name, artist.name) && Objects.equals(this.surname, artist.surname) && Objects.equals(this.country, artist.country);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(this.name, this.surname, this.birthYear, this.country);
    }
}

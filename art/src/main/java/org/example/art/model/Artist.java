package org.example.art.model;

import java.util.Objects;

public class Artist {
    private int id;
    private String name;
    private String surname;
    private int birthYear;
    private String country;

    public Artist() {}

    private Artist(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.birthYear = builder.birthYear;
        this.country = builder.country;
    }

    public static class Builder {
        private int id;
        private String name;
        private String surname;
        private int birthYear;
        private String country;

        public Builder id(int id) { this.id = id; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder surname(String surname) { this.surname = surname; return this; }
        public Builder birthYear(int birthYear) { this.birthYear = birthYear; return this; }
        public Builder country(String country) { this.country = country; return this; }

        public Artist build() {
            return new Artist(this);
        }
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

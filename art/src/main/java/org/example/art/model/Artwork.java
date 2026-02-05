package org.example.art.model;

import java.util.Objects;

public class Artwork {
    private int id;
    private String title;
    private int yearCreated;
    private int cost;
    private Artist artist;
    private Integer galleryId;
    private String medium;
    private boolean isAvailable;

    public Artwork() {}

    private Artwork(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.yearCreated = builder.yearCreated;
        this.cost = builder.cost;
        this.artist = builder.artist;
        this.galleryId = builder.galleryId;
        this.medium = builder.medium;
        this.isAvailable = builder.isAvailable;
    }

    public static class Builder {
        private int id;
        private String title;
        private int yearCreated;
        private int cost;
        private Artist artist;
        private Integer galleryId;
        private String medium;
        private boolean isAvailable;

        public Builder id(int id) { this.id = id; return this; }
        public Builder title(String title) { this.title = title; return this; }
        public Builder yearCreated(int yearCreated) { this.yearCreated = yearCreated; return this; }
        public Builder cost(int cost) { this.cost = cost; return this; }
        public Builder artist(Artist artist) { this.artist = artist; return this; }
        public Builder galleryId(Integer galleryId) { this.galleryId = galleryId; return this; }
        public Builder medium(String medium) { this.medium = medium; return this; }
        public Builder isAvailable(boolean isAvailable) { this.isAvailable = isAvailable; return this; }

        public Artwork build() {
            return new Artwork(this);
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearCreated() {
        return this.yearCreated;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Artist getArtist() {
        return this.artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Integer getGalleryId() {
        return this.galleryId;
    }

    public void setGalleryId(Integer galleryId) {
        this.galleryId = galleryId;
    }

    public String getMedium() {
        return this.medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public void displayInfo() {
        System.out.println("Artwork: " + this.title + ", Year: " + this.yearCreated + ", Cost: " + this.cost);
        if (this.artist != null) {
            this.artist.displayInfo();
        }

        if (this.galleryId != null) {
            System.out.println("Gallery ID: " + this.galleryId);
        }

        System.out.println("Medium: " + this.medium + ", Available: " + this.isAvailable);
    }

    @Override
    public String toString() {
        return this.title + " (" + this.yearCreated + "), Cost: " + this.cost + ", Artist: " + String.valueOf(this.artist) + ", Available: " + this.isAvailable;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Artwork artwork = (Artwork)obj;
            return this.yearCreated == artwork.yearCreated && this.cost == artwork.cost && Objects.equals(this.title, artwork.title) && Objects.equals(this.artist, artwork.artist);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.yearCreated, this.cost, this.artist);
    }
}

package org.example.art.model;

public class Gallery {
    private int id;
    private String galleryName;
    private String location;

    public Gallery() {}

    public Gallery(String galleryName, String location) {
        this.galleryName = galleryName;
        this.location = location;
    }

    public Gallery(int id, String galleryName, String location) {
        this.id = id;
        this.galleryName = galleryName;
        this.location = location;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGalleryName() {
        return this.galleryName;
    }

    public void setGalleryName(String galleryName) {
        this.galleryName = galleryName;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void displayInfo() {
        System.out.println("Gallery: " + this.galleryName + ", Location: " + this.location);
    }

    public String toString() {
        return this.galleryName + " (" + this.location + ")";
    }
}

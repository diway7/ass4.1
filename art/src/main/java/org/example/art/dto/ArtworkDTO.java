package org.example.art.dto;

public class ArtworkDTO {
    private int id;
    private String title;
    private int year;
    private int price;
    private String artistFullName;
    private String medium;
    private boolean available;

    public ArtworkDTO() {}

    public ArtworkDTO(int id, String title, int year, int price, String artistFullName, String medium, boolean available) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.price = price;
        this.artistFullName = artistFullName;
        this.medium = medium;
        this.available = available;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public String getArtistFullName() { return artistFullName; }
    public void setArtistFullName(String artistFullName) { this.artistFullName = artistFullName; }
    public String getMedium() { return medium; }
    public void setMedium(String medium) { this.medium = medium; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}

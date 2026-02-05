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

    public Artwork(String title, int yearCreated, String medium, int cost, boolean isAvailable, Artist artist, Integer galleryId) {
        this.title = title;
        this.yearCreated = yearCreated;
        this.medium = medium;
        this.cost = cost;
        this.isAvailable = isAvailable;
        this.artist = artist;
        this.galleryId = galleryId;
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

    public String toString() {
        String var10000 = this.title;
        return var10000 + " (" + this.yearCreated + "), Cost: " + this.cost + ", Artist: " + String.valueOf(this.artist) + ", Available: " + this.isAvailable;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Artwork artwork = (Artwork)obj;
            return this.yearCreated == artwork.yearCreated && this.cost == artwork.cost && this.title.equals(artwork.title) && this.artist.equals(artwork.artist);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.title, this.yearCreated, this.cost, this.artist});
    }
}


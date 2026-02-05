
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/OOP.ASS.3";
        String user = "postgres";
        String password = "0000";
        return DriverManager.getConnection(url, user, password);

    }
    static void main(String[] args) {
        Artist artist1 = new Artist("Pablo", "Picasso", "Spain", 1881);
        Artist artist2 = new Artist("Vincent", "van Gogh", "Netherlands", 1853);
        Sculptor sculptor1 = new Sculptor("Michelangelo", "Buonarroti", "Italy", 1475, "Marble");
        new Artwork("Guernica", 1937, "Oil on canvas", 1000000, true, artist1, (Integer)null);
        new Artwork("Starry Night", 1889, "Oil on canvas", 500000, true, artist2, (Integer)null);
        new Artwork("David", 1504, "Marble", 20000000, false, sculptor1, (Integer)null);
        new Gallery("Louvre", "Paris");
        new Gallery("MoMA", "New York");
        ArtistDAO artistDAO = new ArtistDAO();
        ArtworkDAO artworkDAO = new ArtworkDAO();
        GalleryDAO galleryDAO = new GalleryDAO();
        Scanner scanner = new Scanner(System.in);

        try {
            while(true) {
                System.out.println("\n=== Menu ===");
                System.out.println("1. Display all artists");
                System.out.println("2. Display all artworks");
                System.out.println("3. Display all galleries");
                System.out.println("4. Add a new artist");
                System.out.println("5. Add a new artwork");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("\nAll Artists:");

                        for(Artist artist : artistDAO.getAllArtists()) {
                            artist.displayInfo();
                        }
                        break;
                    case 2:
                        System.out.println("\nAll Artworks:");

                        for(Artwork artwork : artworkDAO.getAllArtworks()) {
                            artwork.displayInfo();
                        }
                        break;
                    case 3:
                        System.out.println("\nAll Galleries:");

                        for(Gallery gallery : galleryDAO.getAllGalleries()) {
                            gallery.displayInfo();
                        }
                        break;
                    case 4:
                        System.out.println("\nAdding a new artist...");
                        System.out.print("Enter artist name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter artist surname: ");
                        String surname = scanner.nextLine();
                        System.out.print("Enter artist country: ");
                        String country = scanner.nextLine();
                        System.out.print("Enter artist birth year: ");
                        int birthYear = Integer.parseInt(scanner.nextLine());
                        Artist newArtist = new Artist(name, surname, country, birthYear);
                        artistDAO.addArtist(newArtist);
                        System.out.println("Created: " + String.valueOf(newArtist));
                        break;
                    case 5:
                        System.out.println("\nAdding a new artwork...");
                        System.out.print("Enter artwork title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter artwork year: ");
                        int year = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter artwork cost: ");
                        int cost = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter artist ID (use 1 or 2 for sample artists): ");
                        int artistId = Integer.parseInt(scanner.nextLine());
                        Artist artworkArtist = artistId == 1 ? artist1 : artist2;
                        Artwork newArtwork = new Artwork(title, year, "Oil on canvas", cost, true, artworkArtist, (Integer)null);
                        artworkDAO.addArtwork(newArtwork);
                        System.out.println("Created: " + String.valueOf(newArtwork));
                        break;
                    case 6:
                        System.out.println("Exiting program...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 6.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}

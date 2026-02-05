import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GalleryDAO {
    public void addGallery(Gallery gallery) {
        String sql = "INSERT INTO gallery (gallery_name, location) VALUES (?, ?)";

        try (Connection conn = Main.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, gallery.getGalleryName());
            pstmt.setString(2, gallery.getLocation());
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        gallery.setId(generatedKeys.getInt(1));
                    }
                }
                System.out.println("Gallery added successfully with ID: " + gallery.getId());
            }
        } catch (SQLException e) {
            System.err.println("Error adding gallery: " + e.getMessage());
        }
    }

    public List<Gallery> getAllGalleries() {
        List<Gallery> galleries = new ArrayList<>();
        String sql = "SELECT * FROM gallery ORDER BY gallery_id";

        try (Connection conn = Main.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Gallery gallery = new Gallery(rs.getInt("gallery_id"), rs.getString("gallery_name"), rs.getString("location"));
                galleries.add(gallery);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching galleries: " + e.getMessage());
        }

        return galleries;
    }

    public Gallery getGalleryById(int id) {
        String sql = "SELECT * FROM gallery WHERE gallery_id = ?";

        try (Connection conn = Main.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Gallery(rs.getInt("gallery_id"), rs.getString("gallery_name"), rs.getString("location"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching gallery by ID: " + e.getMessage());
        }

        return null;
    }

    public void updateGallery(Gallery gallery) {
        String sql = "UPDATE gallery SET gallery_name = ?, location = ? WHERE gallery_id = ?";

        try (Connection conn = Main.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, gallery.getGalleryName());
            pstmt.setString(2, gallery.getLocation());
            pstmt.setInt(3, gallery.getId());
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Gallery updated successfully");
            } else {
                System.out.println("No gallery found with ID: " + gallery.getId());
            }
        } catch (SQLException e) {
            System.err.println("Error updating gallery: " + e.getMessage());
        }
    }

    public void deleteGallery(int id) {
        String sql = "DELETE FROM gallery WHERE gallery_id = ?";

        try (Connection conn = Main.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Gallery deleted successfully");
            } else {
                System.out.println("No gallery found with ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error deleting gallery: " + e.getMessage());
        }
    }
}
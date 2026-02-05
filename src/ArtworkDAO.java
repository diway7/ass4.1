import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArtworkDAO {
    public void addArtwork(Artwork artwork) throws SQLException {
        // В этом запросе 7 знаков вопроса
        String sql = "INSERT INTO artwork (title, year, medium, price, is_for_sale, artist_id, gallery_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection conn = Main.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            pstmt.setString(1, artwork.getTitle());
            pstmt.setInt(2, artwork.getYearCreated());
            pstmt.setString(3, artwork.getMedium());
            pstmt.setInt(4, artwork.getCost());
            pstmt.setBoolean(5, artwork.isAvailable());

            // ВОТ ТУТ ОШИБКА: убедитесь, что artist.getId() не равен 0
            if (artwork.getArtist() != null) {
                pstmt.setInt(6, artwork.getArtist().getId());
            } else {
                throw new SQLException("Artist cannot be null!");
            }

            if (artwork.getGalleryId() != null) {
                pstmt.setInt(7, artwork.getGalleryId());
            } else {
                pstmt.setNull(7, java.sql.Types.INTEGER);
            }

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        artwork.setId(generatedKeys.getInt(1));
                    }
                }

                System.out.println("Artwork added successfully with ID: " + artwork.getId());
            }
        }
    }

    public List<Artwork> getAllArtworks() throws SQLException {
        List<Artwork> artworks = new ArrayList<>();
        // Исправлено: ORDER BY artwork_id
        String sql = "SELECT * FROM artwork ORDER BY artwork_id";

        try (
                Connection conn = Main.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                int artistId = rs.getInt("artist_id");
                String title = rs.getString("title");
                // Исправлено: имя колонки в БД 'year', а не 'year_created'
                int yearCreated = rs.getInt("year");
                String medium = rs.getString("medium");
                int price = rs.getInt("price");
                // Исправлено: имя колонки в БД 'is_for_sale', а не 'is_available'
                boolean isAvailable = rs.getBoolean("is_for_sale");

                Integer galleryId = (Integer) rs.getObject("gallery_id");

                // Внимание: проверьте, есть ли в таблице Artwork колонки first_name, last_name и т.д.
                // Если их нет (они в таблице Artist), вам нужен SQL JOIN.
                Artist artist = new Artist(artistId, "Unknown", "Artist", "Unknown", 0);

                Artwork artwork = new Artwork(title, yearCreated, medium, price, isAvailable, artist, galleryId);
                artwork.setId(rs.getInt("artwork_id"));
                artworks.add(artwork);
            }
        }
        return artworks;
    }
}

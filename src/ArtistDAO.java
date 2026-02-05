import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {
    public void addArtist(Artist artist) throws SQLException {
        String sql = "INSERT INTO artist (first_name, last_name, country, birth_year) VALUES (?, ?, ?, ?)";

        try (
                Connection conn = Main.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql, 1);
        ) {
            pstmt.setString(1, artist.getName());
            pstmt.setString(2, artist.getSurname());
            pstmt.setString(3, artist.getCountry()); // Третий параметр - страна
            pstmt.setInt(4, artist.getBirthYear());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        artist.setId(generatedKeys.getInt(1));
                    }
                }

                System.out.println("Artist added: " + artist.getName());
            }
        }

    }

    public List<Artist> getAllArtists() throws SQLException {
        List<Artist> artists = new ArrayList();
        String sql = "SELECT * FROM artist ORDER BY artist_id";

        try (
                Connection conn = Main.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            while(rs.next()) {
                Artist artist = new Artist(rs.getInt("artist_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("country"), rs.getInt("birth_year"));
                artists.add(artist);
            }
        }

        return artists;
    }
}

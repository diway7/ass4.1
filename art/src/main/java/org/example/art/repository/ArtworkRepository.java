package org.example.art.repository;

import org.example.art.model.Artist;
import org.example.art.model.Artwork;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtworkRepository {
    private final JdbcTemplate jdbcTemplate;

    public ArtworkRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Artwork> artworkRowMapper = (rs, rowNum) -> {
        Artist artist = new Artist.Builder()
                .id(rs.getInt("artist_id"))
                .name(rs.getString("first_name"))
                .surname(rs.getString("last_name"))
                .country(rs.getString("country"))
                .birthYear(rs.getInt("birth_year"))
                .build();
        return new Artwork.Builder()
                .id(rs.getInt("artwork_id"))
                .title(rs.getString("title"))
                .yearCreated(rs.getInt("year"))
                .medium(rs.getString("medium"))
                .cost(rs.getInt("price"))
                .isAvailable(rs.getBoolean("is_for_sale"))
                .artist(artist)
                .galleryId((Integer) rs.getObject("gallery_id"))
                .build();
    };

    public List<Artwork> findAll() {
        String sql = "SELECT aw.*, ar.first_name, ar.last_name, ar.country, ar.birth_year " +
                     "FROM artwork aw " +
                     "JOIN artist ar ON aw.artist_id = ar.artist_id " +
                     "ORDER BY aw.artwork_id";
        return jdbcTemplate.query(sql, artworkRowMapper);
    }
}

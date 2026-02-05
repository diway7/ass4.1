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
        Artist artist = new Artist(
                rs.getInt("artist_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("country"),
                rs.getInt("birth_year")
        );
        Artwork artwork = new Artwork(
                rs.getString("title"),
                rs.getInt("year"),
                rs.getString("medium"),
                rs.getInt("price"),
                rs.getBoolean("is_for_sale"),
                artist,
                (Integer) rs.getObject("gallery_id")
        );
        artwork.setId(rs.getInt("artwork_id"));
        return artwork;
    };

    public List<Artwork> findAll() {
        String sql = "SELECT aw.*, ar.first_name, ar.last_name, ar.country, ar.birth_year " +
                     "FROM artwork aw " +
                     "JOIN artist ar ON aw.artist_id = ar.artist_id " +
                     "ORDER BY aw.artwork_id";
        return jdbcTemplate.query(sql, artworkRowMapper);
    }
}

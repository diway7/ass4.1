package org.example.art.repository;

import org.example.art.model.Artist;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtistRepository {
    private final JdbcTemplate jdbcTemplate;

    public ArtistRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Artist> artistRowMapper = (rs, rowNum) -> new Artist(
            rs.getInt("artist_id"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("country"),
            rs.getInt("birth_year")
    );

    public List<Artist> findAll() {
        return jdbcTemplate.query("SELECT * FROM artist ORDER BY artist_id", artistRowMapper);
    }

    public Artist findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM artist WHERE artist_id = ?", artistRowMapper, id);
    }
}

package org.example.art.controller;

import org.example.art.model.Artwork;
import org.example.art.repository.ArtworkRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/artworks")
public class ArtworkController {

    private final ArtworkRepository artworkRepository;

    public ArtworkController(ArtworkRepository artworkRepository) {
        this.artworkRepository = artworkRepository;
    }

    @GetMapping
    public List<Artwork> getAllArtworks() {
        return artworkRepository.findAll();
    }
}

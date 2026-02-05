package org.example.art.controller;

import org.example.art.dto.ArtworkDTO;
import org.example.art.service.ArtworkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/artworks")
public class ArtworkController {

    private final ArtworkService artworkService;

    public ArtworkController(ArtworkService artworkService) {
        this.artworkService = artworkService;
    }

    @GetMapping
    public List<ArtworkDTO> getAllArtworks() {
        return artworkService.getAllArtworks();
    }
}

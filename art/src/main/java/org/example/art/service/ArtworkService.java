package org.example.art.service;

import org.example.art.dto.ArtworkDTO;
import org.example.art.model.Artwork;
import org.example.art.repository.ArtworkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtworkService {

    private final ArtworkRepository artworkRepository;

    public ArtworkService(ArtworkRepository artworkRepository) {
        this.artworkRepository = artworkRepository;
    }

    public List<ArtworkDTO> getAllArtworks() {
        return artworkRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ArtworkDTO convertToDTO(Artwork artwork) {
        String artistName = (artwork.getArtist() != null) 
            ? artwork.getArtist().getName() + " " + artwork.getArtist().getSurname() 
            : "Unknown";
            
        return new ArtworkDTO(
                artwork.getId(),
                artwork.getTitle(),
                artwork.getYearCreated(),
                artwork.getCost(),
                artistName,
                artwork.getMedium(),
                artwork.isAvailable()
        );
    }
}

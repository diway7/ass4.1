package org.example.art.factory;

import org.example.art.model.Artist;

public class ArtistFactory {
    public static Artist createArtist(String name, String surname, String country, int birthYear) {
        return new Artist.Builder()
                .name(name)
                .surname(surname)
                .country(country)
                .birthYear(birthYear)
                .build();
    }
}

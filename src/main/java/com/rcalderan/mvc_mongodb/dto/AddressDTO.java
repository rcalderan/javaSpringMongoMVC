package com.rcalderan.mvc_mongodb.dto;

import com.rcalderan.mvc_mongodb.model.Address;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Getter
public class AddressDTO {

    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String service;
    private Location location;

    public Address toAddress() {
        GeoJsonPoint geoJsonPoint = new GeoJsonPoint(
                this.location.getCoordinates().getLongitude(),
                this.location.getCoordinates().getLatitude()
        );

        return new Address(
                this.cep,
                this.state,
                this.city,
                this.neighborhood,
                this.street,
                this.service,
                geoJsonPoint
        );
    }
    @Getter
    @Setter
    public static class Location {
        private String type;
        private Coordinates coordinates;

        @Getter
        @Setter
        public static class Coordinates {
            private double longitude;
            private double latitude;
        }
    }
}


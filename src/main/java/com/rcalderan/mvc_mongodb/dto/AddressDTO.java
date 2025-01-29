package com.rcalderan.mvc_mongodb.dto;

import com.rcalderan.mvc_mongodb.model.Address;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

public class AddressDTO {

    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String service;
    private Location location;

    public String getCep() {
        return cep;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public String getService() {
        return service;
    }

    public Location getLocation() {
        return location;
    }

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

    public static class Location {
        private String type;
        private Coordinates coordinates;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Coordinates getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
        }
        public static class Coordinates {
            private double longitude;
            private double latitude;

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }
        }
    }
}


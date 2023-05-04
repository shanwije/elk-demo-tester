package com.example.demotester;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RandomUser {
    private Long id;
    private String uid;
    private String password;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String avatar;
    private String gender;
    private String phoneNumber;
    private String socialInsuranceNumber;
    private LocalDate dateOfBirth;
    private Employment employment;
    private Address address;
    private CreditCard creditCard;
    private Subscription subscription;

    @Data
    public static class Employment {
        private String title;
        private String keySkill;
    }

    @Data
    public static class Address {
        private String city;
        private String streetName;
        private String streetAddress;
        private String zipCode;
        private String state;
        private String country;
        private Coordinates coordinates;

        @Data
        public static class Coordinates {
            private Double lat;
            private Double lng;
        }
    }

    @Data
    public static class CreditCard {
        private String ccNumber;
    }

    @Data
    public static class Subscription {
        private String plan;
        private String status;
        private String paymentMethod;
        private String term;
    }
}

    package com.nikhil.automation.pojo;

    public class BillingAddress {

        private String firstName;
        private String lastName;
        private String email;
        private String country;
        private String city;
        private String address;
        private String zipCode;
        private String phoneNumber;

        public BillingAddress(String firstName, String lastName, String email, String country, String city, String address,String zipCode, String phoneNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.country = country;
            this.city = city;
            this.address = address;
            this.zipCode = zipCode;
            this.phoneNumber = phoneNumber;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getCountry() {
            return country;
        }

        public String getCity() {
            return city;
        }

        public String getAddress() {
            return address;
        }

        public String getZipCode() {
            return zipCode;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    }

    package com.nikhil.automation.pojo;

    import java.util.Objects;

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

        @Override
        public boolean equals(Object obj){
            if(this == obj){
                return true;
            }
            if(obj==null || getClass()!=obj.getClass()){
                return false;
            }
            BillingAddress other = (BillingAddress) obj;
            return Objects.equals(firstName, other.firstName)
                    && Objects.equals(lastName, other.lastName)
                    && Objects.equals(email, other.email)
                    && Objects.equals(country, other.country)
                    && Objects.equals(city, other.city)
                    && Objects.equals(address, other.address)
                    && Objects.equals(zipCode, other.zipCode)
                    && Objects.equals(phoneNumber, other.phoneNumber);
        }

        @Override
        public int hashCode(){
            return Objects.hash(
                    firstName,
                    lastName,
                    email,
                    country,
                    city,
                    address,
                    zipCode,
                    phoneNumber
            );
        }
    }

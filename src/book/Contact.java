package book;

public class Contact {
    private String firstName, lastName, address, city, state, zip, phone, email;

    public Contact(String firstName, String lastName, String address, String city,
                   String state, String zip, String phone, String email) {
        this.firstName = firstName; this.lastName = lastName; this.address = address;
        this.city = city; this.state = state; this.zip = zip; this.phone = phone; this.email = email;
    }

    // Getters & setters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public void setAddress(String address) { this.address = address; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZip(String zip) { this.zip = zip; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }

    public String fullName() { return firstName + " " + lastName; }

    @Override
    public String toString() {
        return fullName()+" | "+address+", "+city+", "+state+" "+zip+" | "+phone+" | "+email;
    }
}


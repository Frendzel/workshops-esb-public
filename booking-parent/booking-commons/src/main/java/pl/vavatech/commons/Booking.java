package pl.vavatech.commons;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD) // TODO check scope on fields
@XmlRootElement(name = "booking")
@XmlType(name = "", propOrder = {
        "firstName",
        "lastName"
})
//TODO add support for CSV maybe?
//TODO check if jaxb.index file is not needed for unmarhaller utilities versions?
public class Booking implements Serializable {
    private static final long serialVersionUID = 7593349011208666446L;

    @XmlElement(required = true)
    private String firstName;

    @XmlElement(required = true)
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return firstName.equals(booking.firstName) && lastName.equals(booking.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
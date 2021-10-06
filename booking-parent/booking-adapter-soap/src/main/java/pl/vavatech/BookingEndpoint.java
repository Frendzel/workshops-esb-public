package pl.vavatech;

import pl.vavatech.commons.Booking;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface BookingEndpoint {
    String booking(Booking booking);
}

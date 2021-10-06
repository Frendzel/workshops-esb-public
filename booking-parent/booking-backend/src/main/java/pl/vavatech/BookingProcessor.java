package pl.vavatech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.vavatech.commons.Booking;

public class BookingProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingProcessor.class);

    //TODO consider usage of map to persist data
    public void process(Booking booking) {
        LOGGER.info("Booking will be saved: {}", booking);
    }
}

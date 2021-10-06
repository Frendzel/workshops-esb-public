package pl.vavatech;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookingHelper {

    private static final Logger LOG = LoggerFactory.getLogger(BookingHelper.class);

    public void process(Exchange exchange) {
        LOG.info("Exchange: {}", exchange);
    }
}
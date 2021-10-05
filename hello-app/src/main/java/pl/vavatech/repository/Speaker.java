package pl.vavatech.repository;

import pl.vavatech.services.Hello;

import java.util.logging.Logger;

public class Speaker implements Hello {
    private static final Logger LOG = Logger.getLogger("Speaker");

    @Override
    public void sayHi() {
        LOG.info("Hello");
    }

    @Override
    public void sayBye() {
        LOG.info("BYE");
    }
}

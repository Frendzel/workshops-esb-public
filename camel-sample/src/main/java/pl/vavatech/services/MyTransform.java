package pl.vavatech.services;

import java.util.logging.Logger;

public class MyTransform {

    private static final Logger LOG = Logger.getLogger(MyTransform.class.getName());
    private String header;

    public void transform(Object body) {
        LOG.info("Message: " + body);
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}

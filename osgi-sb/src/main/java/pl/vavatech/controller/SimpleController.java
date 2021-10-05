package pl.vavatech.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    private final Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @GetMapping("/simple")
    public String index() {
        return "some text. Means that scan works. Finally.";
    }

    @GetMapping("/example")
    public String ok() {
        logger.info("INFO OK");
        logger.debug("DEBUG OK");
        logger.trace("TRACE OK");
        return "OK";
    }
}

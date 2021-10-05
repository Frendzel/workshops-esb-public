package pl.vavatech.app;

import java.util.logging.Logger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import pl.vavatech.repository.Speaker;
import pl.vavatech.services.Hello;


public class App implements BundleActivator {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    private Hello speaker = null;
    private ServiceRegistration registration;

    @Override
    public void start(BundleContext bundleContext) {
        speaker = new Speaker();
        registration = bundleContext.registerService(Speaker.class.getName(), speaker, null);
        LOGGER.info("State: "+bundleContext.getBundle().getState());
        LOGGER.info("SymbolicName: "+bundleContext.getBundle().getSymbolicName());
        LOGGER.info("Headers: "+bundleContext.getBundle().getHeaders().keys());
        speaker.sayHi();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        speaker.sayBye();
        registration.unregister();
    }
}

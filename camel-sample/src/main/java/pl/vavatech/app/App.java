package pl.vavatech.app;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.logging.Logger;


public class App implements BundleActivator {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    private ServiceRegistration registration;

    @Override
    public void start(BundleContext bundleContext) {
//        registration = bundleContext.registerService(Speaker.class.getName(), speaker, null);
    }

    @Override
    public void stop(BundleContext bundleContext) {
//        registration.unregister();
    }
}

package pl.vavatech;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.osgi.io.OsgiBundleResourcePatternResolver;


@SpringBootApplication
public class SpringBootBundleActivator implements BundleActivator {

    ConfigurableApplicationContext appContext;

    @Override
    public void start(BundleContext bundleContext) {
        // Set context classloader
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        // trick to enable scan: get osgi resource pattern resolver
        OsgiBundleResourcePatternResolver resourceResolver = new OsgiBundleResourcePatternResolver(bundleContext.getBundle());
        // and provide it to spring application
        appContext = new SpringApplication(resourceResolver, SpringBootBundleActivator.class).run();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        SpringApplication.exit(appContext, new ExitCodeGenerator() {
            @Override
            public int getExitCode() {
                return 0;
            }
        });
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBundleActivator.class);
    }
}


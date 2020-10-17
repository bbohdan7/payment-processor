package ua.gov.bank.services;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class ApplicationConfig extends Application {

    private final Set<Class<?>> classes;

    public ApplicationConfig() {
        HashSet<Class<?>> conf = new HashSet<>();
        conf.add(AccountService.class);
        conf.add(PaymentService.class);
        conf.add(UserService.class);

        classes = Collections.unmodifiableSet(conf);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
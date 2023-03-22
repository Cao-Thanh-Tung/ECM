package mta.otherAnnotations.qualifier;

import mta.otherAnnotations.primary.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("mta.otherAnnotations.qualifier");
        context.refresh();
        Mobile mobile  = context.getBean(Mobile.class);
        mobile.getMessageService().sendMsg(); //Send message by email
        // close the spring context
        context.close();
    }
}

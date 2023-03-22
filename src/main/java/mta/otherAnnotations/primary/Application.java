package mta.otherAnnotations.primary;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.scan("mta.otherAnnotations.primary");
        context.refresh();
        MessageService messageService = context.getBean(MessageService.class);
        messageService.sendMsg();// Facebook
        // close the spring context
        context.close();
    }
}

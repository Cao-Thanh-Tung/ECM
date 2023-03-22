package mta.otherAnnotations.qualifier;

import org.springframework.stereotype.Component;

@Component
public class FacebookMessageService1 implements MessageService1 {

    @Override
    public void sendMsg() {
        System.out.println("Send message by Facebook");
    }
}

package mta.otherAnnotations.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class FacebookMessageService implements MessageService {

    @Override
    public void sendMsg() {
        System.out.println("Send message by Facebook");
    }
}

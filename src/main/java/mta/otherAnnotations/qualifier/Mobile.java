package mta.otherAnnotations.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class Mobile {

    @Autowired
    @Qualifier("emailMessageService1")
    private MessageService1 messageService;

    public MessageService1 getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService1 messageService) {

        this.messageService = messageService;
    }
}

package eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;

public class TalkwheelServer {
    
    private final EventBus eventBus;
    private final AsyncEventBus asyncEventBus;

    @Inject
    public TalkwheelServer(EventBus eventBus, AsyncEventBus asyncEventBus) {
        this.eventBus = eventBus;
        this.asyncEventBus = asyncEventBus;
    }
   
    public void actionGroupVisited(String group, String user) {
        GroupVisitedEvent theEvent = new GroupVisitedEvent(group, user);
        
        sendThroght(eventBus, theEvent);
        sendThroght(asyncEventBus, theEvent);
    }

    private void sendThroght(EventBus eventBus, GroupVisitedEvent theEvent) {
        System.out.println("Sending event...");
        eventBus.post(theEvent);
        System.out.println("Event sended.");
    }
    
}

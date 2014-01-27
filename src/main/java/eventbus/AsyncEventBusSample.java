package eventbus;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class AsyncEventBusSample  {
    public static void main( String[] args ) {
        Injector injector = Guice.createInjector(new EventBusModule());
        
        TalkwheelServer twServer = injector.getInstance(TalkwheelServer.class);
        
        // only when an instance is created throught guice the listener is registered
        // within the event bus
        injector.getInstance(HubListener.class);
        
        twServer.actionGroupVisited("facebook group", "alfredo");
    }
}

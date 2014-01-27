package eventbus;

import com.google.common.eventbus.Subscribe;

public class HubListener {

    @Subscribe
    public void groupVisited(GroupVisitedEvent groupVisited) {
        System.out.println("received event group visited" + groupVisited);
        sleep();  // simulate process time
        System.out.println("event processed");
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}
    }
}

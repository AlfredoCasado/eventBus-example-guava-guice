package eventbus;


import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import java.util.concurrent.Executors;


public class EventBusModule extends AbstractModule {
    
    private final EventBus eventBus = new EventBus("Default EventBus");
    private final AsyncEventBus asyncEventBus = new AsyncEventBus(Executors.newFixedThreadPool(10));
 
    @Override
    protected void configure() {
        bind(EventBus.class).toInstance(eventBus);
        bind(AsyncEventBus.class).toInstance(asyncEventBus);
        
        bindListener(Matchers.any(), new TypeListener() {
            public <I> void hear(TypeLiteral<I> typeLiteral, TypeEncounter<I> typeEncounter) {
                typeEncounter.register(new InjectionListener<I>() {
                    public void afterInjection(I i) {
                        eventBus.register(i);
                        asyncEventBus.register(i);
                    }
                });
            }
        });
    }
    
}

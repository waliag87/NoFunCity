import java.util.ArrayList;
import java.util.List;

/**
 * Created by gwalia on 2017-08-02.
 *
 */

/**
 * EventHandler maintains a single  list of all events parsed from the site
 */
public class EventHandler {
    private static EventHandler eventHandler = new EventHandler();
    private List<Event> eventList = new ArrayList<Event>();

    // Constructor for  Event Handler
    private EventHandler(){
        this.eventList = new ArrayList();
    }

    public static EventHandler getEventHandler(){
        return eventHandler;
    }

    public static void addEvent(Event event){
    eventHandler.eventList.add(event);
    }


}

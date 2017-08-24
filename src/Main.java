import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by gwalia on 2017-08-21.
 */
public class Main {
    //goal of this main test is to take a single article, and add all of the information to the EventHandler;
    public static void main(String [] args){
        Elements eventNames;
        Elements eventInformation;

        String articleURL = "http://dailyhive.com/vancouver/vancouver-events-things-to-do-august-21-2017";
        // Create the parser and create it's doc
        ArticleParser testParser = new ArticleParser(articleURL);
        try{
            testParser.getArticleText();
        }catch (IOException e){
            System.out.println("IO exception was thrown");
        }

        // Get the event names from article <h3> tags then get event information from article <ul> tags
        eventNames = testParser.getEventNames();
        eventInformation = testParser.getEventInformation();

        // Create event using the names from <h3> tags
        for (Element eventName: eventNames) {
            Event event = new Event(eventName.text());
            EventHandler.getEventHandler().addEvent(event);
        }
        //Updates each corresponding event with proper information
        int eventCount = 0;
        for (Element singleEventInformation: eventInformation){
            // Only updates event if it isn't a see also
            if (!singleEventInformation.hasClass("see-also-list")) {
                InformationParser tempParser = new InformationParser(singleEventInformation);
                Event eventToUpdate = EventHandler.getEventHandler().getEvent(eventCount);

                String When = tempParser.findDate();
                eventToUpdate.setDate(When);

                String Where = tempParser.findLocation();
                eventToUpdate.setLocation(Where);

                String Time = tempParser.findTime();
                eventToUpdate.setTime(Time);

                String What = tempParser.findDescription();
                eventToUpdate.setDescription(What);
                //Make sure you update next Event
                eventCount++;
            }
        }
        // Adds events to the database
        for (int i = 0; i < EventHandler.getEventCount(); i++){
            Event event = EventHandler.getEvent(i);
            try {
                SQLAdder.runAdder(event.getName(), event.getDate(), event.getDescription(),
                        event.getLocation(), event.getTime());
            }
            catch (SQLException e){
                System.out.println("SQLException was thrown");
            }
        }


        //TODO: figure out how to parse many articles automatically.

    }
}

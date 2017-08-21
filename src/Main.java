import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by gwalia on 2017-08-21.
 */
public class Main {
    //goal of this main test is to take a single article, and add all of the information to the EventHandler;
    public static void main(String [] args){
        Elements eventNames;
        Elements eventInformation;

        String articleURL = "http://dailyhive.com/vancouver/vancouver-events-things-to-do-august-20-2017";
        // Create the parser and create it's doc
        ArticleParser testParser = new ArticleParser(articleURL);
        try{
            testParser.getArticleText();
        }catch (IOException e){
            System.out.println("IO exception was thrown");
        }

        // Get the event Names from article <h3> tags then get event information from article <ul> tags
        eventNames = testParser.getEventNames();
        eventInformation = testParser.getEventInformation();

        // Create event using the names from <h3> tags
        for (Element eventName: eventNames) {
            Event event = new Event(eventName.text());
            EventHandler.getEventHandler().addEvent(event);
        }

        //add corresponding information to the events of the event handler



//        System.out.println(eventNames.text());
//        System.out.println(eventInformation.text());
//        System.out.println(testParser.getArticleTitle());

        //TODO: iterate through event information to create Event Objects then add them to the Event Manager;
        //TODO: figure out how to parse many articles automatically. (static list of URL's??)

    }
}

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Objects of this Class will take in a string of Event "Information" and be able to split it into the
 * date/location/description/cost of an event
 * Created by gwalia on 2017-08-21.
 */
public class InformationParser {
    // This holds all the event information for the event
    private Element wholeString;
    // This splits event information into separate elements
    private Elements allElements;

    public InformationParser(Element wholeString){
        this.wholeString = wholeString;
        Elements allElements = wholeString.getElementsByTag("ul");
        for (Element e: allElements)
            this.allElements = e.getElementsByTag("li");
    }

    /**
     * Searches WholeString for the Date and returns the info as a string
     * @return a string which contains the date information for an event
     */
    public String findDate(){
        for (Element e: this.allElements) {
            String checkHeading = e.text();
            checkHeading = checkHeading.substring(0, 5);
            if (checkHeading.equals("When:"))
                return e.text();
        }
        return null;
    }

    public String findLocation(){
        for (Element e: this.allElements) {
            String checkHeading = e.text();
            checkHeading = checkHeading.substring(0, 6);
            if (checkHeading.equals("Where:"))
                return e.text();
        }
        return null;
    }

    public String findDescription(){
        for (Element e: this.allElements) {
            String checkHeading = e.text();
            checkHeading = checkHeading.substring(0, 5);
            if (checkHeading.equals("What:"))
                return e.text();
        }
        return null;
    }

    public String findTime(){
        for (Element e: this.allElements) {
            String checkHeading = e.text();
            checkHeading = checkHeading.substring(0, 5);
            if (checkHeading.equals("Time:"))
                return e.text();
        }
        return null;
    }
}

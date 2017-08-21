import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class ArticleParser {
    /**
     * Attempting to parse a single article from site
     */
    private String articleURL;
    private Document doc;

    /**
     * Creates a parser for your article, on which functions can be called. The first thing that must be done is the doc
     * must be created, other functions can be called once the doc is made
     * @param articleURL the url of the article you wish to parse
     */
    public ArticleParser(String articleURL) {
        this.articleURL = articleURL;
    }

    /**
     * create a jsoup Document, essential to do before calling other methods.
     *
     * @return jsoup Document created from article's URL
     */
    public void getArticleText() throws java.io.IOException {
        this.doc = Jsoup.connect(this.articleURL).get();
        //TODO: update this class such that this method is performed in the constructor
    }

    /**
     * Method to get title of the article
     *
     * @return title of the article
     */
    public String getArticleTitle() {
        return doc.title();

    }

    /**
     * Get the titles of the events from the article
     *
     * @return the titles of all the events as an Elements type
     */
    public Elements getEventNames() {
        Elements content = doc.getElementsByClass("post content vancouver");
        Elements listOfEventNames = null;
        for (Element event : content) {
            listOfEventNames = event.getElementsByTag("h3");
        }
        return listOfEventNames;
    }

    /**
     * Get all the event information from the article
     *
     * @return A list of Element with all event info
     */
    public Elements getEventInformation() {
        Elements content = doc.getElementsByClass("post content vancouver");
        Elements eventInfo = null;
        for (Element event : content) {
            eventInfo = event.getElementsByTag("ul");
        }
        return eventInfo;
    }

    /**
     * Allows user to change the url of the article, the doc is immediately updated as well.
     * Throws an IO exception if the URL does not allow for successful creation of a Document.
     * @param newURL
     *
     * */
    public void changeURL(String newURL) throws IOException{
        this.articleURL = newURL;
        this.doc = Jsoup.connect(this.articleURL).get();
    }

}

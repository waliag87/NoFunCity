import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ArticleParser{
    /**
     *  Attempting to parse a single article from site
     *
     */
    public static void main(String [] args){

        // Get's html from site and makes a "Document"
       try{
           Document doc =  Jsoup.connect("https://jsoup.org/cookbook/input/load-document-from-url").get();
           String title = doc.title();
       }catch(IOException e){
           System.out.println("IO Exception Thrown from creating Document");
       }




    }

}

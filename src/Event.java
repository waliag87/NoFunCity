import java.util.Date;
import java.util.LinkedList;

// Model for all Vancouver Events. Events have a name, date, and description
public class Event {
private String name;
private Date eventDate;
private LinkedList<String> description;
private String location;
private String cost;

/**
Constructor for an Event
**/
  public Event(String name){
    this.name = name;
  }

  public String getName(){
    return this.name;
  }

  public void setName(String name){
    this.name = name;
  }

  public Date getDate(){
    return this.eventDate;
  }

  public void setDate(Date date){
    this.eventDate = date;
  }

  public LinkedList<String> getDescription(){
    return this.description;
  }

  public void setDescription(LinkedList<String> description){
    this.description = description;
  }

  public void setLocation(String location){
    this.location = location;
  }
  public String getLocation(){
      return this.location;
    }
  public void setCost(String cost){
    this.cost = cost;
  }

  public String getCost(){
    return this.cost;
  }




}

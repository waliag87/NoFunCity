import java.util.Date;
import java.util.LinkedList;

// Model for all Vancouver Events. Events have a name, date, and description
public class Event {
private String name;
private Date eventDate;
private LinkedList<String> description;

/**
Constructor for an Event
**/
public Event(String name, Date date, LinkedList<String> description){
  this.name = name;
  eventDate = date;
  this.description = description;
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

public LinkedList<String> getDescription(){
  return this.description;
}

public void setDescription(LinkedList<String> description){
  this.description = description;
}

}

import java.util.LinkedList;

// Model for all Vancouver Events. Events have a name, date, and description
public class Event {
private String name;
private String eventDate;
private String description;
private String location;
private String time;


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

  public String getDate(){
    return this.eventDate;
  }

  public void setDate(String date){
    this.eventDate = date;
  }

  public String getDescription(){
    return this.description;
  }

  public void setDescription(String description){
    this.description = description;
  }

  public void setLocation(String location){
    this.location = location;
  }
  public String getLocation(){
      return this.location;
    }

  public String getTime(){
    return this.time;
  }

  public void setTime(String time){
    this.time = time;
  }





}

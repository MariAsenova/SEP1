import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing methods and variables for the ScheduledClass objects
 * @author Ionut, Claudiu, Maria, Cezary
 * @version 1.0
 */

public class ScheduledClass implements Serializable
{
  private ArrayList<Member> members;
  private Instructor instructor;
  private Class classItem;
  private DateTime dateTime;
  private int duration;

  /**
   * Five-argument constructor initializing data for all the variables of the scheduled class
   * @param classItem the class object used for the scheduled class
   * @param instructor the instructor teaching the scheduled class
   * @param dateTime the date and time of the scheduled class
   * @param members the membets attending the scheduled class
   * @param duration the duration of the scheduled class
   */
  public ScheduledClass(Class classItem, Instructor instructor, DateTime dateTime, ArrayList<Member> members, int duration)
  {
    this.members = members;
    this.classItem = classItem;
    this.dateTime = dateTime;
    if (instructor.hasClass(classItem.getName()))
    {
      this.instructor = instructor;
    }
    this.duration = duration;
  }

  /**
   * Four-argument constructor initializing the scheduled class without a list of attending members
   * @param classItem the class object used for the scheduled class
   * @param instructor the instructor teaching the scheduled class
   * @param dateTime the date and time of the scheduled class
   * @param duration the dration of the scheduled class
   */
  public ScheduledClass(Class classItem, Instructor instructor, DateTime dateTime, int duration)
  {
    this.members = new ArrayList<Member>();
    this.classItem = classItem;
    this.dateTime = dateTime;
    if (instructor.hasClass(classItem.getName()))
    {
      this.instructor = instructor;
    }
    this.duration = duration;
  }

  /**
   * Gets a list of attending members
   * @return an array list of members
   */
  public ArrayList<Member> getMembers()
  {
    return members;
  }

  /**
   * Sets the members
   * @param members an array list of members
   */
  public void setMembers(ArrayList<Member> members)
  {
    this.members = members;
  }

  /**
   * Gets the instructor teaching the scheduled class
   * @return the instructor teaching the scheduled class
   */
  public Instructor getInstructor()
  {
    return instructor;
  }

  /**
   * Sets the instructor teaching the class
   * @param instructor the instructor which will be teaching the class
   */
  public void setInstructor(Instructor instructor)
  {
    if (instructor.hasClass(classItem.getName()))
    {
      this.instructor = instructor;
    }
  }

  /**
   * Gets the class taught
   * @return the class taught
   */
  public Class getClassItem()
  {
    return classItem;
  }

  /**
   * Sets the class taught
   * @param classItem the class which will be taught
   */
  public void setClassItem(Class classItem)
  {
    this.classItem = classItem;
  }

  /**
   * Gets the date and time of the scheduled class
   * @return the date and time of the scheduled class
   */
  public DateTime getDateTime()
  {
    return dateTime;
  }

  /**
   * Sets the date and time of the scheduled class
   * @param dateTime the date and time at which the scheduled class will take place
   */
  public void setDateTime(DateTime dateTime)
  {
    this.dateTime = dateTime;
  }

  /**
   * Adds a member to the attending members list
   * @param member the member which will attend the scheduled class
   */
  public void addMember(Member member)
  {
    if (member.hasPremiumMembership())
    {
      members.add(member);
    }
  }

  /**
   * Sets the duration of the scheduled class
   * @param duration the duration for which the class will be taught
   */
  public void setDuration(int duration)
  {
    this.duration = duration;
  }

  /**
   *Gets the duration of the scheduled class
   * @return the duration of the scheduled class
   */
  public int getDuration()
  {
    return duration;
  }

  /**
   * Removes a member from the attending members list
   * @param member the member which will be removed from the attending members list
   */
  public void removeMember(Member member)
  {
    members.remove(member);
  }

  /**
   * Gets a string representation of the scheduled class's information
   * @return the string representaion of the scheduled class
   */
  public String toString()
  {
    String stringToReturn = "";
    stringToReturn += "ScheduledClass: " + classItem + " on " + dateTime;
    if (instructor != null)
    {
      stringToReturn += "\n\tInstructor: " + instructor;
    }
    else
    {
      stringToReturn += "\n\tNo instructor assigned yet.";
    }
    if (members.size() == 0)
    {
      stringToReturn += "\n\tNo members attending the class yet.";
    }
    else
    {
      stringToReturn += "\n\tMembers: ";
      for (int i = 0; i < members.size(); i++)
      {
        stringToReturn += "\n\t\t" + members.get(i);
      }
    }
    return stringToReturn;
  }

  /**
   * Compares this scheduled class to another one
   * @param obj the other scheduled class with which the current one will be compared
   * @return true if the two ScheduledClass objects are identical, false otherwise
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof ScheduledClass))
    {
      return false;
    }
    ScheduledClass other = (ScheduledClass) obj;
    return classItem.equals(other.classItem) && instructor
        .equals(other.instructor) && dateTime.equals(other.dateTime) && members
        .equals(other.members) && duration == other.duration;
  }
}

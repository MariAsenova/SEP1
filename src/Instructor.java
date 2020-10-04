import java.io.Serializable;
import java.util.ArrayList;
/**
 * A class that extends Person.java and includes all the information about instructor
 * @author Ionut, Claudiu, Maria, Cezary
 * @version 1.0
 */
public class Instructor extends Person implements Serializable
{

  private ArrayList<String> classes;

  /**
   * A six-argument constructor with first name, last name, address, email, phone number and all the classes
   * @param firstName first name of instructor
   * @param lastName last name of instructor
   * @param address address of instructor
   * @param email email of instructor
   * @param phoneNumber phone number of instructor
   * @param classes all the classes instructor can teach
   */
  public Instructor(String firstName, String lastName, String address,
      String email, String phoneNumber, ArrayList<String> classes)
  {
    super(firstName, lastName, address, email, phoneNumber);
    this.classes = classes;
  }

  /**
   * A method that returns all classes taught by instructor
   * @return all the classes
   */
  public ArrayList<String> getClasses()
  {
    return classes;
  }

  /**
   * A method that adds instructor's class to an arrayList if that class doesn't exist yet
   * @param className name of the class
   */
  public void addClass(String className)
  {
    boolean exists = false;
    for (String classItem : classes)
    {
      if (classItem.equals(className))
        exists = true;
    }
    if (exists == false)
    {
      classes.add(className);
    }
  }

  /**
   * A method that removes the class if it exists in the arrayList
   * @param className name of the class
   */
  public void removeClass(String className)
  {
    for (String classItem : classes)
    {
      if (classItem.equals(className))
      {
        classes.remove(className);
      }
    }
  }

  /**
   * A method that checks if the given class exists
   * @param className name of the class
   * @return true if the class exists
   */
  public boolean hasClass(String className)
  {
    for (String classItem : classes)
    {
      if (classItem.equals(className))
      {
        return true;
      }
    }
    return false;
  }

  /**
   * A class that return number of current classes
   * @return number of classes
   */
  public int getNumberOfClasses()
  {
    return classes.size();
  }

  /**
   * A method that returns a String of all the information of instructor
   * @return all the information of instructor
   */
  public String toString()
  {
    String stringToReturn = "";
    stringToReturn += super.toString() + ", can teach: ";
    for (int i = 0; i < classes.size(); i++)
    {
      if (i == classes.size() - 1)
      {
        stringToReturn += classes.get(i) + ".";
      }
      else
      {
        stringToReturn += classes.get(i) + ", ";
      }
    }
    return stringToReturn;
  }

  /**
   * A method that returns a copy of instructor
   * @return copy of instructor
   */
  public Instructor copy()
  {
    return new Instructor(super.getFirstName(), super.getLastName(),
        super.getAddress(), super.getEmail(), super.getPhoneNumber(), classes);
  }

  /**
   * A method that checks if the object equals this instructor
   * @param obj object that will be compared to instructor
   * @return true if the object equals instructor
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Instructor))
    {
      return false;
    }
    Instructor other = (Instructor) obj;
    return super.equals(other) && classes.equals(other.classes);
  }

}

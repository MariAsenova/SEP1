import java.util.ArrayList;
/**
 * A class that includes all the instructors, members, classes and scheduled classes in the fitness center
 * @author Ionut, Claudiu, Maria, Cezary
 * @version 1.0
 */
public class FitnessCenter
{
  private ArrayList<Instructor> instructors;
  private ArrayList<Class> classes;
  private ArrayList<Member> members;
  private ArrayList<ScheduledClass> scheduledClasses;

  /**
   * A no-argument constructor that creates all the arrayLists
   */
  public FitnessCenter()
  {
    instructors = new ArrayList<Instructor>();
    classes = new ArrayList<Class>();
    members = new ArrayList<Member>();
    scheduledClasses = new ArrayList<ScheduledClass>();
  }

  /**
   * A method that adds the class to the fitness center
   * @param classItem class that needs to be added
   */
  public void addClass(Class classItem)
  {
    classes.add(classItem);
  }

  /**
   * A method that removes the class from fitness center, and then from the schedule if it was scheduled
   * @param classItem the class to be removed
   */
  public void removeClass(Class classItem)
  {
    //Removing the Class object from the classes array
    classes.remove(classItem);

    //Removing the ScheduledClass object from the scheduledClasses array
    int indexToRemove = -1;
    for (int i = 0; i < scheduledClasses.size(); i++)
    {
      if (scheduledClasses.get(i).getClassItem().equals(classItem))
        indexToRemove = i;
    }
    scheduledClasses.remove(indexToRemove);

  }

  /**
   * A method that removes the class of selected name from fitness center, and then from the schedule if it was scheduled
   * @param className name of the class
   */
  public void removeClass(String className)
  {
    //Removing the Class object from the classes array
    int indexToRemove = -1;
    for (int i = 0; i < classes.size(); i++)
    {
      if (classes.get(i).getName().equals(className))
        indexToRemove = i;
    }
    classes.remove(indexToRemove);

    //Removing the scheduledClass object from the scheduledClasses array
    indexToRemove = -1;
    for (int i = 0; i < scheduledClasses.size(); i++)
    {
      if (scheduledClasses.get(i).getClassItem().getName().equals(className))
      {
        indexToRemove = i;
        scheduledClasses.remove(indexToRemove);
      }
    }

  }

  /**
   * A method that returns a class if it exists in the fitness center
   * @param className class to be returned
   * @return class if it exists
   */
  public Class getClassItem(String className)
  {
    for (Class classItem : classes)
    {
      if (classItem.getName().equals(className))
      {
        return classItem;
      }
    }
    return null;
  }

  /**
   * A method that adds instructor to the fintess center
   * @param instructor instructor to be added
   */
  public void addInstructor(Instructor instructor)
  {
    instructors.add(instructor);
  }

  /**
   * A method that removes the instructor if it exists in the fitness center, and from all the scheduled classes
   * @param phoneNumber phone number of instructor
   */
  public void removeInstructor(String phoneNumber)
  {
    //Removing the Instructor object from the instructors array
    int indexToRemove = -1;
    for (int i = 0; i < instructors.size(); i++)
    {
      if (instructors.get(i).getPhoneNumber().equals(phoneNumber))
      {
        indexToRemove = i;
      }
    }
    instructors.remove(indexToRemove);

    //Setting the Instructor to null in all the scheduled classes he teaches
    System.out.println(scheduledClasses.size());
    for (ScheduledClass scheduledClass : scheduledClasses)
    {
      if (scheduledClass.getInstructor().getPhoneNumber().equals(phoneNumber))
      {
        scheduledClass.setInstructor(null);
        break;
      }
    }
  }

  /**
   * A method that returns instructor of selected phone number
   * @param phoneNumber phone number of the instructor
   * @return instructor if it exists in the fitness center
   */
  public Instructor getInstructor(String phoneNumber)
  {
    for (Instructor instructor : instructors)
    {
      if (instructor.getPhoneNumber().equals(phoneNumber))
      {
        return instructor;
      }
    }
    return null;
  }

  /**
   * A method that adds the member if it doesn't exist in fitness center
   * @param member member to be added
   */
  public void addMember(Member member)
  {
    if (getMember(member.getPhoneNumber()) == null)
      members.add(member);
  }

  /**
   * A method that removes the member if it exists in the fitness center
   * @param phoneNumber phone number of the member
   */
  public void removeMember(String phoneNumber)
  {
    for (Member member : members)
    {
      if (member.getPhoneNumber().equals(phoneNumber))
      {
        members.remove(member);
      }
    }
  }

  /**
   * A method that returns a member if it exists in the fitness center
   * @param phoneNumber phone number of the member
   * @return return the member
   */
  public Member getMember(String phoneNumber)
  {
    for (Member member : members)
    {
      if (member.getPhoneNumber().equals(phoneNumber))
      {
        return member;
      }
    }
    return null;
  }

  /**
   * A method that add a class that is scheduled
   * @param scheduledClass scheduled class
   */
  public void addScheduledClass(ScheduledClass scheduledClass)
  {
    boolean classAlreadyExists = false;
    for (ScheduledClass scheduledClassItem : scheduledClasses)
    {
      if (scheduledClassItem.equals(scheduledClass))
      {
        classAlreadyExists = true;
      }
    }
    if (!classAlreadyExists)
    {
      scheduledClasses.add(scheduledClass);
    }
  }

  /**
   * A method that removes a scheduled class
   * @param scheduledClass scheduled class
   */
  public void removeScheduledClass(ScheduledClass scheduledClass)
  {
    scheduledClasses.remove(scheduledClass);
  }

  public ScheduledClass getScheduledClass(DateTime dateTime, String className)
  {
    for (ScheduledClass scheduledClass : scheduledClasses)
    {
      if (scheduledClass.getDateTime().equals(dateTime) && scheduledClass
          .getClassItem().getName().equals(className))
      {
        return scheduledClass;
      }
    }
    return null;
  }

  /**
   * A method that returns all the instructors in fitness center
   * @return arrayList of all the instructors
   */
  public ArrayList<Instructor> getInstructors()
  {
    return instructors;
  }

  /**
   * A method that returns all the class in fitness center
   * @return arrayList if all the classes
   */
  public ArrayList<Class> getClasses()
  {
    return classes;
  }

  /**
   * A method that returns all the members in fitness center
   * @return ArrayList of all the members
   */
  public ArrayList<Member> getMembers()
  {
    return members;
  }

  /**
   * A method that returns all the scheduled classes in fitness center
   * @return ArrayList of all the scheduled classes
   */
  public ArrayList<ScheduledClass> getScheduledClasses()
  {
    return scheduledClasses;
  }

  /**
   * A method that returns String with all the information of fitness center
   * @return instructors, classes, members and scheduled classes of the fitness center
   */
  public String toString()
  {
    return "FitnessCenter{" + "instructors=" + instructors + ", classes="
        + classes + ", members=" + members + ", scheduledClasses="
        + scheduledClasses + '}';
  }

  /**
   * A method that checks if the object is fitness center
   * @param obj object to be compared
   * @return true if the object is a fitness center
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof ScheduledClass))
    {
      return false;
    }
    FitnessCenter other = (FitnessCenter) obj;
    return members.equals(other.members) && instructors
        .equals(other.instructors) && classes.equals(other.classes)
        && scheduledClasses.equals(other.scheduledClasses);
  }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * An adapter to the FitnessCenter file to retrieve, store, edit and remove data about members, instructors, classes and scheduledClasses.
 * @author Ionut, Claudiu, Maria, Cezary
 * @version 1.0
 */
public class FitnessFileAdapter
{
  private MyFileIO myFileIO;
  private String membersFileName;
  private String instructorsFilename;
  private String classesFilename;
  private String scheduledClassesFilename;

  /**
   * 4-argument constructor setting the file name.
   * @param membersFileName the name and path of the file where members will be saved, retrieved, removed and edited
   * @param instructorsFilename the name and path of the file where instructors will be saved, retrieved, removed and edited
   * @param classesFilename the name and path of the file where classes will be saved, retrieved, removed and edited
   * @param scheduledClassesFilename the name and path of the file where scheduledClasses will be saved, retrieved, removed and edited
   */
  public FitnessFileAdapter(String membersFileName,
      String instructorsFilename, String classesFilename,
      String scheduledClassesFilename)
  {
    myFileIO = new MyFileIO();
    this.membersFileName = membersFileName;
    this.instructorsFilename = instructorsFilename;
    this.classesFilename = classesFilename;
    this.scheduledClassesFilename = scheduledClassesFilename;
  }

  /**
   * Uses the MyFileIO class to retrieve a MemberList object with all members.
   * @return a MemberList object with all stored members
   */
  public ArrayList<Member> getAllMembers()
  {
    ArrayList<Member> members = new ArrayList<Member>();
    try
    {
      members = (ArrayList<Member>) myFileIO
          .readObjectFromFile(membersFileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading a file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class not found");
    }
    return members;
  }

  /**
   * Uses the MyFileIO class to retrieve a MemberList object with all members.
   * @param phoneNumber the phone number of a member used to retrieve a specific member
   * @return a Member object with the phone number passed as argument
   */
  public Member getMember(String phoneNumber)
  {
    ArrayList<Member> members = getAllMembers();
    Member member = null;

    for (int i = 0; i < members.size(); i++)
    {
      if (members.get(i).getPhoneNumber().equals(phoneNumber))
      {
        member = members.get(i);
        break;
      }
    }
    return member;
  }

  /**
   * Use the MyFileIO class to save the member object passed as a parameter.
   * @param membersFileName the name and path of the file where members will be saved
   * @param object the object saved to members
   */
  public void saveMembers(String membersFileName, Object object)
  {
    ArrayList<Member> oldMembers = getAllMembers();
    oldMembers.add((Member) object);

    try
    {
      myFileIO.writeObjectToFile(membersFileName, oldMembers);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }
  }

  /**
   * Use the MyFileIO class to save the member object passed as a parameter.
   * @param membersFileName the name and path of the file where members are saved
   * @param index the position of the edited object in the members array list
   * @param object the member object edited
   */
  public void editMember(String membersFileName, int index, Object object)
  {
    ArrayList<Member> oldMembers = getAllMembers();
    oldMembers.set(index, (Member) object);
    try
    {
      myFileIO.writeObjectToFile(membersFileName, oldMembers);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }
  }

  /**
   * Uses the MyFileIO class to retrieve a MemberList object with all members.
   * @param membersFileName the name and path of the file where members will be saved
   * @param member the object removed from members
   */
  public void removeMember(String membersFileName, Member member)
  {
    ArrayList<Member> oldMembers = getAllMembers();
    for (int i = 0; i < oldMembers.size(); i++)
    {
      if (oldMembers.get(i).equals(member))
      {
        oldMembers.remove(oldMembers.get(i));
      }
    }

    try
    {
      myFileIO.writeObjectToFile(membersFileName, oldMembers);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }
  }

  /**
   * Uses the MyFileIO class to retrieve a InstructorsList object with all instructors.
   * @return a InstructorList object with all stored instructors.
   */
  public ArrayList<Instructor> getAllInstructors()
  {
    ArrayList<Instructor> instructors = new ArrayList<Instructor>();

    try
    {
      instructors = (ArrayList<Instructor>) myFileIO
          .readObjectFromFile(instructorsFilename);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class not found");
    }
    return instructors;
  }

  /**
   * Uses the MyFileIO class to retrieve a InstructorList object with all instructors.
   * @param phoneNumber the phone number of an instructor used to retrieve a specific instructor
   * @return a Instructor object with the phone number passed as argument
   */
  public Instructor getInstructor(String phoneNumber)
  {
    ArrayList<Instructor> instructors = getAllInstructors();
    Instructor instructor = null;

    for (int i = 0; i < instructors.size(); i++)
    {
      if (instructors.get(i).getPhoneNumber().equals(phoneNumber))
      {
        instructor = instructors.get(i);
        break;
      }
    }
    return instructor;
  }

  /**
   * Use the MyFileIO class to save the instructor object passed as a parameter.
   * @param instructorsFilename the name and path of the file where instructors will be saved
   * @param object the object saved to instructors
   */
  public void saveInstructors(String instructorsFilename, Object object)
  {
    ArrayList<Instructor> oldInstructors = getAllInstructors();
    oldInstructors.add((Instructor) object);

    try
    {
      myFileIO.writeObjectToFile(instructorsFilename, oldInstructors);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }
  }

  /**
   * Use the MyFileIO class to save the instructor object passed as a parameter.
   * @param instructorsFilename the name and path of the file where instructors are saved
   * @param index the position of the edited object in the instructors array list
   * @param object the instructor object edited
   */
  public void editInstructor(String instructorsFilename, int index, Object object)
  {
    ArrayList<Instructor> oldInstructors = getAllInstructors();
    oldInstructors.set(index, (Instructor) object);

    try
    {
      myFileIO.writeObjectToFile(instructorsFilename, oldInstructors);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }
  }

  /**
   * Uses the MyFileIO class to retrieve a InstructorList object with all instructors.
   * @param instructorsFilename the name and path of the file where instructors will be saved
   * @param instructor the object removed from instructors
   */
  public void removeInstructor(String instructorsFilename,
      Instructor instructor)
  {
    ArrayList<Instructor> oldInstructors = getAllInstructors();
    for (int i = 0; i < oldInstructors.size(); i++)
    {
      if (oldInstructors.get(i).equals(instructor))
      {
        oldInstructors.remove(oldInstructors.get(i));
      }
    }

    try
    {
      myFileIO.writeObjectToFile(instructorsFilename, oldInstructors);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }
  }

  /**
   * Uses the MyFileIO class to retrieve a ClassList object with all classes.
   * @return a ClassList object with all stored classes.
   */
  public ArrayList<Class> getAllClasses()
  {
    ArrayList<Class> classes = new ArrayList<Class>();

    try
    {
      classes = (ArrayList<Class>) myFileIO.readObjectFromFile(classesFilename);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class not found");
    }
    return classes;
  }

  /**
   * Use the MyFileIO class to save the class object passed as a parameter.
   * @param classesFilename the name and path of the file where classes are saved
   * @param index the position of the edited object in the classes array list
   * @param object the class object edited
   */
  public void editClass(String classesFilename, int index, Object object)
  {
    ArrayList<Class> oldClasses = getAllClasses();
    oldClasses.set(index, (Class) object);

    try
    {
      myFileIO.writeObjectToFile(classesFilename, oldClasses);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }
  }

  /**
   * Uses the MyFileIO class to retrieve a ClassList object with all classes.
   * @param name the name of an class used to retrieve a specific class
   * @return a Class object with the name passed as argument
   */
  public Class getClassByName(String name)
  {
    ArrayList<Class> classes = getAllClasses();
    Class classByName = null;

    for (int i = 0; i < classes.size(); i++)
    {
      if (classes.get(i).getName().equals(name))
      {
        classByName = classes.get(i);
      }
    }
    return classByName;
  }

  /**
   * Use the MyFileIO class to save the class object passed as a parameter.
   * @param classesFilename the name and path of the file where classes will be saved
   * @param object the object saved to classes
   */
  public void saveClasses(String classesFilename, Object object)
  {
    ArrayList<Class> oldClasses = getAllClasses();
    oldClasses.add((Class) object);

    try
    {
      myFileIO.writeObjectToFile(classesFilename, oldClasses);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }
  }

  /**
   * Uses the MyFileIO class to retrieve a ClassList object with all classes.
   * @param classesFilename the name and path of the file where classes will be saved
   * @param oldClass the object removed from classes
   */
  public void removeClass(String classesFilename, Class oldClass)
  {
    ArrayList<Class> oldClasses = getAllClasses();
    for (int i = 0; i < oldClasses.size(); i++)
    {
      if (oldClasses.get(i).equals(oldClass))
      {
        oldClasses.remove(oldClasses.get(i));
      }
    }

    try
    {
      myFileIO.writeObjectToFile(classesFilename, oldClasses);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }
  }

  /**
   * Uses the MyFileIO class to retrieve a ScheduledClassList object with all scheduled classes.
   * @return a ScheduledClassList object with all stored scheduled classes.
   */
  public ArrayList<ScheduledClass> getAllScheduledClasses()
  {
    ArrayList<ScheduledClass> scheduledClasses = new ArrayList<ScheduledClass>();

    try
    {
      scheduledClasses = (ArrayList<ScheduledClass>) myFileIO
          .readObjectFromFile(scheduledClassesFilename);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found from adapter");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file from adapter");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class not found");
    }

    return scheduledClasses;
  }

  /**
   * Uses the MyFileIO class to retrieve a ScheduledClass object with all scheduled classes.
   * @param dateTime the DateTime object used to retrieve a specific scheduled class on specific date
   * @param className the class name used to retrieve a specific scheduled class with specific name
   * @return a ScheduledClass object with the phone number passed as argument
   */
  public ScheduledClass getScheduledClass(DateTime dateTime, String className)
  {
    ArrayList<ScheduledClass> scheduledClasses = getAllScheduledClasses();
    ScheduledClass scheduledClass = null;

    for (int i = 0; i < scheduledClasses.size(); i++)
    {
      if (scheduledClasses.get(i).getDateTime().equals(dateTime)
          && scheduledClasses.get(i).getClassItem().getName().equals(className))
      {
        scheduledClass = scheduledClasses.get(i);
        break;
      }
    }
    return scheduledClass;
  }


  /**
   * Uses the MyFileIO class to retrieve a ScheduledClass object with all scheduled classes.
   * @param from the DateTime object used to define a start point for time interval within which ScheduledClass objects are retrieved
   * @param to the DateTime object used to define an end point for time interval within which ScheduledClass objects are retrieved
   * @return a ScheduledClass object with scheduled classes between specified time interval
   */
  public ArrayList<ScheduledClass> getScheduledClassesInTimeInterval(
      DateTime from, DateTime to)
  {
    ArrayList<ScheduledClass> scheduledClasses = getAllScheduledClasses();
    ArrayList<ScheduledClass> scheduledClassesFromTo = new ArrayList<ScheduledClass>();

    for (int i = 0; i < scheduledClasses.size(); i++)
    {
      if ((scheduledClasses.get(i).getDateTime().isAfter(from))
          && (scheduledClasses.get(i).getDateTime().isBefore(to)))
      {
        scheduledClassesFromTo.add(scheduledClasses.get(i));
        System.out.println("it works");
      }
    }
    return scheduledClassesFromTo;
  }

  /**
   * Use the MyFileIO class to save the ScheduledClass object passed as a parameter.
   * @param scheduledClassesFilename the name and path of the file where scheduled classes will be saved
   * @param object the object saved to classes
   */
  public void saveScheduleClasses(String scheduledClassesFilename,
      Object object)
  {
    ArrayList<ScheduledClass> oldScheduleClasses = getAllScheduledClasses();
    oldScheduleClasses.add((ScheduledClass) object);

    try
    {
      myFileIO.writeObjectToFile(scheduledClassesFilename, oldScheduleClasses);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }
  }

  /**
   * Use the MyFileIO class to save the ScheduledClass object passed as a parameter.
   * @param scheduledClassesFilename the name and path of the file where scheduled classes are saved
   * @param index the position of the edited object in the ScheduledClass array list
   * @param object the ScheduledClass object edited
   */
  public void editScheduledClasses(String scheduledClassesFilename, int index,
      Object object)
  {
    ArrayList<ScheduledClass> oldScheduleClasses = getAllScheduledClasses();
    oldScheduleClasses.set(index, (ScheduledClass) object);

    try
    {
      myFileIO.writeObjectToFile(scheduledClassesFilename, oldScheduleClasses);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }
  }

  /**
   * Uses the MyFileIO class to retrieve a ScheduledClass object with all scheduled classes.
   * @param scheduledClassesFilename the name and path of the file where scheduled classes will be saved
   * @param scheduledClass the object removed from classes
   */
  public void removeScheduledClass(String scheduledClassesFilename,
      ScheduledClass scheduledClass)
  {
    ArrayList<ScheduledClass> oldScheduledCLasses = getAllScheduledClasses();
    for (int i = 0; i < oldScheduledCLasses.size(); i++)
    {
      if (oldScheduledCLasses.get(i).equals(scheduledClass))
      {
        oldScheduledCLasses.remove(oldScheduledCLasses.get(i));
      }
    }

    try
    {
      myFileIO.writeObjectToFile(scheduledClassesFilename, oldScheduledCLasses);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }
  }

  /**
   * Uses the MyFileIO class to retrieve a ScheduledClass object with all scheduled classes.
   * @param from the DateTime object used to define a start point for time interval within which ScheduledClass objects are retrieved
   * @param to the DateTime object used to define an end point for time interval within which ScheduledClass objects are retrieved
   * @return a String object with scheduled classes between specified time interval
   */
  public String displayScheduledClassesInTimeInterval(DateTime from,
      DateTime to)
  {
    ArrayList<ScheduledClass> scheduledClassesFromTo = getScheduledClassesInTimeInterval(
        from, to);

    String stringToReturn = "";
    for (int i = 0; i < scheduledClassesFromTo.size(); i++)
    {
      String tempStringToReturn = "";
      tempStringToReturn +=
          "ScheduledClass: " + scheduledClassesFromTo.get(i).getClassItem()
              + " on " + scheduledClassesFromTo.get(i).getDateTime();
      if (scheduledClassesFromTo.get(i).getInstructor() != null)
      {
        tempStringToReturn +=
            "\n\tInstructor: " + scheduledClassesFromTo.get(i).getInstructor();
      }
      else
      {
        tempStringToReturn += "\n\tNo instructor assigned yet.";
      }
      if (scheduledClassesFromTo.get(i).getMembers().size() == 0)
      {
        tempStringToReturn += "\n\tNo members attending the class yet.";
      }
      else
      {
        tempStringToReturn += "\n\tMembers: ";
        for (int j = 0;
             j < scheduledClassesFromTo.get(j).getMembers().size(); j++)
        {
          tempStringToReturn +=
              "\n\t\t" + scheduledClassesFromTo.get(i).getMembers().get(j);
        }
      }
      stringToReturn += tempStringToReturn + "\n";
    }

    return stringToReturn;
  }

  /**
   * Uses the GregorianCalendar class to retrieve the current day, month and year.
   * @return a String object with the current date
   */
  public static String today()
  {
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentDay = currentDate.get(GregorianCalendar.DATE);
    int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
    int currentYear = currentDate.get(GregorianCalendar.YEAR);

    String info = "";

    if (currentDay < 10)
    {
      info += "0" + String.valueOf(currentDay) + "/";
    }
    else
    {
      info += String.valueOf(currentDay) + "/";
    }

    if (currentMonth < 10)
    {
      info += "0" + String.valueOf(currentMonth) + "/";
    }
    else
    {
      info += String.valueOf(currentMonth) + "/";
    }

    info += String.valueOf(currentYear);

    return info;
  }
}

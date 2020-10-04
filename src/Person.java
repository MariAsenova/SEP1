import java.io.Serializable;
/**
 * An abstract class being a superclass for Instructor.java and Member.java
 * @author Ionut, Claudiu, Maria, Cezary
 * @version 1.0
 */


public abstract class Person implements Serializable
{
  private String firstName;
  private String lastName;
  private String address;
  private String email;
  private String phoneNumber;

  /**
   * Five-argument constructor which initializes five strings
   * @param firstName First name of the person
   * @param lastName Last name of the person
   * @param address The current address
   * @param email The current email address
   * @param phoneNumber Phone number of the person
   */

  public Person(String firstName, String lastName, String address, String email,
      String phoneNumber)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  /**
   *A method that returns first name of the person
   * @return first name
   */
  public String getFirstName()
  {
    return firstName;
  }
  /**
   *A method that sets first name of the person
   * @param firstName first name of the person
   */

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }
  /**
   *A method that returns last name of the person
   * @return last name
   */
  public String getLastName()
  {
    return lastName;
  }
  /**
   *A method that return full name of the person
   * @return full name
   */
  public String getFullName()
  {
    return firstName + " " + lastName;
  }
  /**
   *A method that sets last name of the person
   * @param lastName last name of the person
   */
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }
  /**
   *A method that returns address of the person
   * @return address
   */
  public String getAddress()
  {
    return address;
  }
  /**
   *A method that sets address of the person
   * @param address address of the person
   */
  public void setAddress(String address)
  {
    this.address = address;
  }
  /**
   *A method that return email of the person
   * @return email
   */
  public String getEmail()
  {
    return email;
  }
  /**
   *A method that sets email of the person
   * @param email email of the person
   */
  public void setEmail(String email)
  {
    this.email = email;
  }
  /**
   *A method that return phone number of the person
   * @return phone number
   */
  public String getPhoneNumber()
  {
    return phoneNumber;
  }
  /**
   *A method that sets phone number of the person
   * @param phoneNumber phone number of the person
   */
  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }
  /**
   *A method that returns a String of first name, last name and phone number of the person
   * @return String of first name, last name and phone number
   */
  public String toString()
  {
    return firstName + " " + lastName + ", Phone number: " + phoneNumber;
  }

  /**
   * A method that returns true if the object equals person
   * @param obj object that will be compared to person
   * @return true if the person equals object
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Person))
    {
      return false;
    }
    Person other = (Person) obj;
    return firstName.equals(other.firstName) && lastName.equals(other.lastName)
        && address.equals(other.address) && email.equals(other.email)
        && phoneNumber.equals(other.phoneNumber);
  }
}

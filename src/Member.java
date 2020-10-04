import java.io.Serializable;
/**
 * A class that extends Person.java and includes all the information about the member
 * @author Ionut, Claudiu, Maria, Cezary
 * @version 1.0
 */
public class Member extends Person implements Serializable
{
  private boolean premiumMembership;

  /**
   * A five-constructor that sets first name, last name, address, email and phone number of the member
   * @param firstName first name of the member
   * @param lastName last name of the member
   * @param address address of the member
   * @param email email of the member
   * @param phoneNumber phone number of the member
   */
  public Member(String firstName, String lastName, String address, String email,
      String phoneNumber)
  {
    super(firstName, lastName, address, email, phoneNumber);
    premiumMembership = false;
  }

  /**
   * A method that sets the membership to premium
   */
  public void upgradeMembership()
  {
    premiumMembership = true;
  }

  /**
   * A method that sets the membership to standard
   */
  public void downgradeMembership()
  {
    premiumMembership = false;
  }

  /**
   * A method that checks if the premium membership is true
   * @return true if the membership is premium
   */
  public boolean hasPremiumMembership()
  {
    return premiumMembership;
  }

  /**
   * A method that return a String of all the information of the member
   * @return a String of first name, last name, address, email and phone number of the member
   */
  public String toString()
  {
    return super.toString();
  }

  /**
   * A method that copies the member
   * @return new member with the same information
   */
  public Member copy()
  {
    return new Member(super.getFirstName(), super.getLastName(), super.getAddress(), super.getEmail(), super.getPhoneNumber());
  }

  /**
   * A method that checks if the object equals the member
   * @param obj object that will be compared to member
   * @return true if the object equals member
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Member))
    {
      return false;
    }
    Member other = (Member) obj;
    return super.equals(other) && premiumMembership == other.premiumMembership;
  }
}

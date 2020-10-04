import java.io.Serializable;

/**
 * A class containing methods and variables for the Class objects
 * @author Ionut, Claudiu, Maria, Cezary
 * @version 1.0
 */

public class Class implements Serializable
{
  private String name;
  private int maxCapacity;

  /**
   * Two-argument constructor which initializes the two class variables
   * @param name the name of the created class
   * @param maxCapacity the maximum member capacity for the class
   */
  public Class(String name, int maxCapacity)
  {
    this.name = name;
    this.maxCapacity = maxCapacity;
  }

  /**
   * Sets the name of the class
   * @param name the name which will be set
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * Sets the maximum member capacity of the class
   * @param maxCapacity the maximum member capacity which will be set
   */
  public void setMaxCapacity(int maxCapacity)
  {
    this.maxCapacity = maxCapacity;
  }

  /**
   * Gets the name of the class
   * @return the name of the class
   */
  public String getName()
  {
    return name;
  }

  /**
   * Gets the maximum member capacity of the class
   * @return the maximum member capacity of the class
   */
  public int getMaxCapacity()
  {
    return maxCapacity;
  }

  /**
   * Gets a string representation of the class's data
   * @return the string representation of the class's data
   */
  public String toString()
  {
    return name + " with a max capacity of " + maxCapacity + " members";
  }

  public boolean equals(Object  obj)
  {
    if (!(obj instanceof Class))
    {
      return false;
    }
    Class other = (Class) obj;
    return name.equals(other.name) && maxCapacity == other.maxCapacity;
  }
}

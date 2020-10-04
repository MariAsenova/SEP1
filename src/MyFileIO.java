import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Class used for writing and reading binary files
 * @author Ionut, Claudiu, Maria, Cezary
 * @version 1.0
 */

public class MyFileIO
{

  /**
   * Writes an object to a binary file
   * @param fileName the name of the file in which the object will be written
   * @param object the object that will be written in the specified file
   * @throws FileNotFoundException exception thrown if the file could not be found
   * @throws IOException exception thrown if an IO error occurs
   */
  public void writeObjectToFile(String fileName, Object object)
      throws FileNotFoundException, IOException
  {
    ObjectOutputStream objectOutputStream = null;

    try
    {
      FileOutputStream fileOutputStream = new FileOutputStream(fileName);
      objectOutputStream = new ObjectOutputStream(fileOutputStream);

      objectOutputStream.writeObject(object);
    }
    finally
    {
      if (objectOutputStream != null)
      {
        try
        {
          objectOutputStream.close();
        }
        catch (IOException e)
        {
          System.out.println("IO error when closing the file: " + fileName);
        }
      }
    }
  }

  /**
   * Reads an object from a binary file
   * @param fileName the name of the file from which the object will be read
   * @return the object read from the specified file
   * @throws FileNotFoundException exception thrown if the file could not be found
   * @throws IOException exception thrown if an IO error occurs
   * @throws ClassNotFoundException exception thrown when no definition for the specified class could be found
   */
  // When reading from a file the object type needs to be casted
  public Object readObjectFromFile(String fileName)
      throws FileNotFoundException, IOException, ClassNotFoundException
  {
    Object object = null;
    ObjectInputStream objectInputStream = null;

    try
    {
      FileInputStream fileInputStream = new FileInputStream(fileName);
      objectInputStream = new ObjectInputStream(fileInputStream);

      try
      {
        object = objectInputStream.readObject();
      }
      catch (EOFException e)
      {
        System.out.println("Done reading");
      }
    }
    finally
    {
      if (objectInputStream != null)
      {
        try
        {
          objectInputStream.close();
        }
        catch (IOException e)
        {
          System.out.println("IO error when closing file: " + fileName);
        }
      }
    }
    return object;
  }
}

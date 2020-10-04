import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class used for reading and writing data to and from a text file
 * @author Ionut, Claudiu, Maria, Cezary
 * @version 1.0
 */

public class MyTextFileIO
{

  /**
   * Writes a string to a text file
   * @param fileName the name of the file in which the string will be written
   * @param str the string that will be written in the specified file
   * @throws FileNotFoundException exception thrown if the file could not be found
   */
  public void writeToFile(String fileName, String str)
      throws FileNotFoundException
  {
    FileOutputStream fileOut = new FileOutputStream(fileName);
    PrintWriter write = new PrintWriter(fileOut);
    write.println(str);
    write.close();
    System.out.println("Done writing to file.");
  }

  /**
   * Appends a string to a text file
   * @param fileName the name of the file in which the string will be appended
   * @param str the string that will be appended to the specified file
   * @throws FileNotFoundException exception thrown if the file could not be found
   */
  public void appendToFile(String fileName, String str)
      throws FileNotFoundException
  {
    FileOutputStream fileOut = new FileOutputStream(fileName, true);
    PrintWriter write = new PrintWriter(fileOut);
    write.println(str);
    write.close();
    System.out.println("Done appending to file.");
  }

  /**
   * Writes an array of strings to a text file
   * @param fileName the name of the file in which the strings will be written
   * @param str the array of strings that will be written in the specified file
   * @throws FileNotFoundException exception thrown if the file could not be found
   */
  public void writeToFile(String fileName, String[] str)
      throws FileNotFoundException
  {
    FileOutputStream fileOut = new FileOutputStream(fileName);
    PrintWriter write = new PrintWriter(fileOut);
    for (String string : str)
    {
      write.println(string);
    }
    write.close();
    System.out.println("Done writing to file.");
  }

  /**
   * Appends an array of strings to a text file
   * @param fileName the name of the file to which the strings will be appended
   * @param str the array of strings that will be appended
   * @throws FileNotFoundException exception thrown if the file could not be found
   */
  public void appendToFile(String fileName, String[] str)
      throws FileNotFoundException

  {
    FileOutputStream fileOut = new FileOutputStream(fileName, true);
    PrintWriter write = new PrintWriter(fileOut);
    for (String string : str)
    {
      write.println(string);
    }
    write.close();
    System.out.println("Done appending to file.");
  }

  /**
   * Reads a string from a text file
   * @param fileName the name of the file from which the string will be read
   * @return the read string
   * @throws FileNotFoundException exception thrown if the file could not be found
   */
  public String readStringFromFile(String fileName) throws FileNotFoundException
  {
    FileInputStream fileIn = new FileInputStream(fileName);
    Scanner read = new Scanner(fileIn);
    read.close();
    System.out.println("Done reading to file.");
    return read.nextLine();
  }

  /**
   * Reads an array of string from a text file
   * @param fileName the name of the file from which the strings will be read
   * @return the array of strings read from the specified file
   * @throws FileNotFoundException exception thrown if the file could not be found
   */
  public String[] readArrayFromFile(String fileName)
      throws FileNotFoundException
  {
    FileInputStream fileIn = new FileInputStream(fileName);
    Scanner read = new Scanner(fileIn);
    ArrayList<String> tempArray = new ArrayList<String>();
    while (read.hasNext())
    {
      tempArray.add(read.nextLine());
    }
    read.close();
    String[] temp = new String[tempArray.size()];
    temp = tempArray.toArray(temp);
    System.out.println("Done reading to file.");
    return temp;
  }
}

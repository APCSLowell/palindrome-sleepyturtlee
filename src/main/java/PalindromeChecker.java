import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word)
{
  //your code here
  // checks if the reverse of the word is the same as the word
  if(reverse(noSpacesNoPunct(word)).equals(noSpacesNoPunct(word))) {
    return true;
  }
  return false;
}
public String reverse(String str)
{
    String sNew = new String();
    //your code here
    // reverses the string
    for(int i = str.length()-1; i >= 0; i--) {
      sNew = sNew + str.substring(i, i+1);
    }
    return sNew;
}
  // helper function I made
  public String noSpacesNoPunct(String str) {
  String coolWord = new String();
  // rid the string of spaces
  for(int i = 0; i < str.length(); i++) {
    // if the letter is not a space and if it is a letter (not punctuation)
    if(!str.substring(i, i+1).equals(" ") && Character.isLetter(str.charAt(i))) {
      coolWord = coolWord + str.substring(i, i+1).toLowerCase();
    }
  }
  return coolWord;
}
}

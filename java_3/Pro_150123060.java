//Purpose of this program is to create a simple string analyzer that can count the number of a determined chars, print 
//the words in a sentence, delete or replace substring, sort characters and create a hash code.
// Arda Can Ergin StudentID:150123060
import java.util.Scanner;
public class Pro_150123060 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		while (true) {
			System.out.println("\nWelcome to our String Analyzer Porgram."
					+ "\n\t1. Count number of chars"
					+ "\n\t2. Print the words in a sentence"
					+ "\n\t3. Delete substring"
					+ "\n\t4. Replace substring"
					+ "\n\t5. Sort characters"
					+ "\n\t6. Hash code of a string"
					+ "\nPlease enter your menu choise: ");
			
			String choise = input.nextLine();
			
			if (choise.equalsIgnoreCase("1")) {
				System.out.println("Enter an input string: ");
				String str= input.nextLine();
				System.out.println("Enter an input char: ");
				String ch_in= input.nextLine();
				char ch= ch_in.charAt(0);
				System.out.println("The number of " + ch + " in " + str + " is " + numOfChars(str,ch));
			}
			if (choise.equalsIgnoreCase("2")) {
				System.out.println("Enter an input string: ");
				String str= input.nextLine();
				printWords(str);
			}
			if (choise.equalsIgnoreCase("3")) {
				System.out.println("Enter an input string: ");
				String str= input.nextLine();
				System.out.println("Enter a substring: ");
				String substr= input.nextLine();
				System.out.println("Enter a type (0-first occurrence 1-all occurences): ");
				int type = input.nextInt();
				input.nextLine(); //fix the scanner error
				System.out.println(delete(str,substr,type));
			}
			if (choise.equalsIgnoreCase("4")) {
				System.out.println("Enter an input string: ");
				String str= input.nextLine();
				System.out.println("Enter the first substring: ");
				String substr1 = input.nextLine();
				System.out.println("Enter the second substring: ");
				String substr2 = input.nextLine();
				System.out.println(replace(str,substr1,substr2));
			}
			if (choise.equalsIgnoreCase("5")) {
				System.out.println("Enter an input string: ");
				String str= input.nextLine();
				System.out.println("Enter a type(0-ASCII low to high 1-special order):  ");
				int type = input.nextInt();
				input.nextLine(); //to fix the scanner error
				System.out.println(sortChars(str,type));
			}
			if (choise.equalsIgnoreCase("6")) {
				System.out.println("Enter an input string: ");
				String str= input.nextLine();
				System.out.println("Enter a value for b:  ");
				int b = input.nextInt();
				input.nextLine();
				System.out.println("The hash code for " + str + " is " + hashCode(str,b));
			}
			if (choise.equalsIgnoreCase("exit") || choise.equalsIgnoreCase("quit")) {
				System.out.println("Program ends. Bye!");
				System.exit(0);
			}
		}
	}
	
	//method option 1
	public static int numOfChars(String string, char ch) {
		int count =0; //char counter
		for (int i=0;i<string.length();i++) {
			if (string.charAt(i)==ch) {
				count++;
			}
		}
		return count;
	}
	
	//method option 2
	public static void printWords (String string) {
		System.out.println("The output is: ");
		System.out.println();
		for (int i=0;i<string.length();i++) {
			if (string.charAt(i)== ',' || string.charAt(i)== '!' || string.charAt(i)== '_' || 
				string.charAt(i)== '(' || string.charAt(i)== ')' || string.charAt(i)== '.' ||
				string.charAt(i)== '?' || string.charAt(i)== '-' || string.charAt(i)== ' ' ) {
				System.out.println();
			} else {
				System.out.print(string.charAt(i));
			}
		}
	}
	
	//method option 3
	public static String delete(String string, String substring, int type) {
		if (string.indexOf(substring)==-1) { //Error if string doesn't contain the substring
			string = "Substring is not in the main string!";
			return string;
		}
		if (!(type ==1 || type ==0)) { //Error if invalid type has been entered
			System.out.println("Please enter a valid type");
			return string;
		}
		if (type ==0) { //Subtracting the first occurrence of substring
				String str1= string.substring(0,string.indexOf(substring));
				String str2= string.substring(string.indexOf(substring)+substring.length());
				string= str1 + str2;
			}
		if (type==1) {
				while (!(string.indexOf(substring)==-1)) { //Subtracting the every occurrence of substring, using a loop.
					String str1= string.substring(0,string.indexOf(substring));
					String str2= string.substring(string.indexOf(substring)+substring.length());
					string= str1 + str2;
				}
			} 
		return string;
	}
	
	//method option 4
	public static String replace(String string, String substring1,String substring2) {
		do { //find substring1, don't include it, instead add substring2, add rest of the string 
			string= string.substring(0,string.indexOf(substring1)) + substring2 + 
					string.substring(string.indexOf(substring1)+substring1.length());
		} while(!(string.indexOf(substring1)==-1)); //repeat the process until substring1 can't be found
		return string;
	}
	
	//method option 5
	public static String sortChars(String string, int type) {
		if (!(type == 0 || type == 1)) {
			string = "Plese enter a valid type!";
			return string;
		}
		String output = "";
		char[] str = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == ' ') {
				continue;
			}
			str[i] = string.charAt(i);
		}
		if (type == 0) {
			for (int i = 0; i < str.length; i++) { //sorting made according to ascii value lower to higher
				for (int k = i + 1; k < str.length; k++) {
					if (str[i] > str[k]) {
						char temp = str[i];
						str[i] = str[k];
						str[k] = temp;
					}
				}
			}
		}
		if (type == 1) {//sorting should be lower case -> upper case -> digit -> others
			for (int i = 0; i < str.length; i++) {
				for (int k = i + 1; k < str.length; k++) { //sorting the characters based on their group
					if ('A' <= str[i] && 'Z' >= str[i]) {
						char temp = str[i];
						str[i] = str[k];
						str[k] = temp;
					}
					if ('a' <= str[i] && 'z' >= str[i]) {
						char temp = str[i];
						str[i] = str[k];
						str[k] = temp;
					}
					if ('0' <= str[i] && '9' >= str[i]) {
						char temp = str[i];
						str[i] = str[k];
						str[k] = temp;
					} else {
						char temp = str[i];
						str[i] = str[k];
						str[k] = temp;
					}
				}
			}
		}
		for (int i = 0; i < str.length; i++) {
			for (int k = i + 1; k < str.length; k++) { //sorting the characters based on their ascii value in a certain group
				if ('a' <= str[k] && 'z' >= str[k] && 'a' <= str[i] && 'z' >= str[i]) {
					if (str[i] > str[k]) {
						char temp = str[i];
						str[i] = str[k];
						str[k] = temp;
					}
				}
				if ('A' <= str[k] && 'Z' >= str[k] && 'A' <= str[i] && 'Z' >= str[i]) {
					if (str[i] > str[k]) {
						char temp = str[i];
						str[i] = str[k];
						str[k] = temp;
					}
				}
				if ('0' <= str[k] && '9' >= str[k] && '0' <= str[i] && '9' >= str[i]) {
					if (str[i] > str[k]) {
						char temp = str[i];
						str[i] = str[k];
						str[k] = temp;
					}
				}
			}
		}

		for (int i = 0; i < str.length; i++) {
			output = output + str[i];
		}
		return output;
	}
	
	//method option 6
	public static int hashCode(String string,int b) {
		int hashcode = 0;
		for (int i=0;i<string.length();i++) {
			hashcode = (int) (hashcode + string.charAt(i)*Math.pow(b, string.length()-1-i));
		}
		return hashcode;
	}
}

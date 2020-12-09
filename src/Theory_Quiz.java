import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is a program to test the users knowledge on object-orientated programming
 * @author William Nash
 *
 */
@SuppressWarnings("unused")
public class Theory_Quiz
{
	/**
	 * welcome simply prints the header in a pretty way
	 */
	public static void welcome()
	{
		System.out.println("*          What could possibly be more fun than this?           *");
		System.out.println("*****************************************************************");
		System.out.println("*               OOP Theory and Concept Questions                *");
		System.out.println("*****************************************************************");
		System.out.println("*          Nothing. Nothing at all. Nope. Nada. Nunca.          *\n");
	}
	
	/**
	 * main contains everything
	 */
	public static void main(String[] args)
	{
		welcome();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the path to the file containing the questions: ");
		String path = sc.nextLine();
		//String path = "C:/Users/rsasw/Desktop/Code/oop_Quiz/questions_without_answers.json"; //used for testing
		int choice = 0;
		QuestionPrinter qp = new QuestionPrinter();
		int amountOfQuestions = 0;
		QuestionReader qr = new QuestionReader();
		ArrayList<Question> quiz = new ArrayList<Question>();
		quiz = qr.readFromJSON(path);
		Quizzer qu = new Quizzer();
		do
		{
			try
			{
				choice = showMenu(sc);
				if(choice == 1)
				{
					System.out.print("How many questions would you like? ");
					amountOfQuestions = sc.nextInt();
					System.out.println(String.format("You got %d out of %d correct", qu.quiz(amountOfQuestions, quiz, sc),amountOfQuestions));
				}
				else if(choice == 2)
				{
					qp.printQuestions(quiz);
				}
			}catch(InputMismatchException ex) {
				System.out.println("Only number 1-3 are accepted");
				choice = 0;
				sc.next();
			}
		}while(choice != 3);
		System.out.println("Goodbye, have a good day!");
		sc.close();
	}//main
	
	/**
	 * showMenu prints the menu then asks the user what action they want to take
	 * @param sc Used to see where the user wants to go
	 * @return result contains what the user wants to do
	 */
	public static int showMenu(Scanner sc)
	{
		System.out.println("\nHere are your options");
		System.out.println("1. Take quiz");
		System.out.println("2. See questions and answers");
		System.out.println("3: Exit");
		System.out.print("Enter the number of your choice: ");
		int result = sc.nextInt();
		sc.nextLine();
		return result;
	}
	
}

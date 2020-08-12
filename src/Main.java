import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	private static final String INTRO =
			"You are in a land full of dragons. In front of you,\n" +
			"you see two caves. In one cave, the dragon is friendly\n" +
			"and will share his treasure with you. The other dragon\n" +
			"is greedy and hungry and will eat you on sight.\n" +
			"Which cave will you go into? (1 or 2)\n";
	private static final String WIN_MESSAGE =
			"You approach the cave...\n" +
			"It is dark and spooky...\n" +
			"A large dragon approaches you! He turns to his side and...\n" +
			"Reveals his treasure for you to take!\n";
	private static final String LOSE_MESSAGE =
			"You approach the cave...\n" +
			"It is dark and spooky...\n" +
			"A large dragon jumps out in front of you! He opens his jaws and...\n" +
			"Gobbles you down in one bite!\n";

	public static void main(String[] args) {
		showMessage(INTRO);
		boolean chose1 = (getChoice() == 1);
		if(choseCorrectly(chose1))
			showMessage(WIN_MESSAGE);
		else
			showMessage(LOSE_MESSAGE);
	}

	private static int getChoice() {
		var scanner = new Scanner(System.in);
		while(true) {
			try {
				int choice = scanner.nextInt();
				if(choice == 1 || choice == 2)
					return choice;
			}
			catch(InputMismatchException ignored) {
				scanner.next();
			}
			System.out.println("Please enter 1 or 2.\n");
		}
	}

	private static boolean choseCorrectly(boolean chose1) {
		boolean good2 = twoIsGood();
		return chose1 ^ good2;
	}

	private static boolean twoIsGood() {
		var random = new Random();
		return random.nextBoolean();
	}

	private static void showMessage(String message) {
		System.out.println(message);
	}
}
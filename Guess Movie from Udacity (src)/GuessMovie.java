import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class GuessMovie {
    public static void main(String [] args) {
        File movieFile = new File("C:\\Users\\Gia\\IdeaProjects\\GuessMovie\\movies.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(movieFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> movieList = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            movieList.add(line);
        }
        Game newGame = new Game(movieList);
        ArrayList<String> guesses = new ArrayList<String>();
        String guess = "";
        while (newGame.getWrongGuessCounter() < 10 && !newGame.getMovieTarget().equals(newGame.getGuessMovie())) {
            newGame.printYouAreGuessing();
            System.out.println("You have " + newGame.getWrongGuessCounter() + " wrong guesses.");
            System.out.print("Guess a letter:  ");
            Scanner s = new Scanner(System.in);
            guess = s.next();
            if (guess.length() > 1) {
                System.out.println("Please enter only one letter.");
            } else if (guesses.contains(guess)) {
                System.out.println("That guess has been made.");
            } else {
                guesses.add(guess);
                newGame.checkGuess(guess);
            }
        }
    }
}

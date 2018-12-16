import java.util.ArrayList;

public class Game {

    private ArrayList<String> movieList;
    private String movieTarget;
    private int movieTargetLength;
    private String guessMovie;
    private int wrongGuessCounter = 0;

    public Game(ArrayList<String> movieList) {
        this.movieList = movieList;
        this.setMovieTarget();
        this.initGuessMovie();
    }
    public ArrayList<String> getMovieList() {
        return movieList;
    }
    public void setMovieList(ArrayList<String> movieList) {
        this.movieList = movieList;
    }
    public String getMovieTarget() {
        return movieTarget;
    }
    public int getMovieTargetLength() {
        return movieTargetLength;
    }
    public void setMovieTarget() {
        int random = (int) (Math.random() * 6);
        this.movieTarget = movieList.get(random);
        this.movieTargetLength = this.movieTarget.length();
    }
    public String getGuessMovie() {
        return guessMovie;
    }
    public void initGuessMovie() {
        guessMovie="";
        for (int i=-0; i<movieTargetLength; i++) {
            if (movieTarget.charAt(i) != ' ') {
                guessMovie = guessMovie+"-";
            }
            else {
                guessMovie = guessMovie+" ";
            }
        }
    }
    public boolean setGuessMovie(char c) {
        String newGuessMovie = "";
        boolean wrongGuess = true;
/*        System.out.println(movieTarget.indexOf(c));
        int x = 0;
        while (movieTarget.indexOf(c, x) != -1) {
            int next = movieTarget.indexOf(c, x);
            guessMovie.(next);

        } */
        for (int i=0; i<movieTargetLength; i++) {
            char m = movieTarget.charAt(i);
            if ((m == c) || m == Character.toUpperCase(c) || m == Character.toLowerCase(c)) {
                newGuessMovie = newGuessMovie + m;
                wrongGuess = false;
            }
            else if (m == ' ') {
                newGuessMovie = newGuessMovie + " ";
            }
            else if (guessMovie.charAt(i) == m) {
                newGuessMovie = newGuessMovie + guessMovie.charAt(i);
            }
            else {
                newGuessMovie = newGuessMovie + ("-");
            }
        }
        guessMovie = newGuessMovie;
        return wrongGuess;
    }

    public int getWrongGuessCounter() {
        return wrongGuessCounter;
    }

    public void checkGuess(String g) {
        if (setGuessMovie(g.charAt(0))) {
            wrongGuessCounter += 1;
        }
        if (guessMovie.equals(movieTarget)) {
            System.out.println(movieTarget);
            System.out.println("You win!");
        }
    }
    public void printYouAreGuessing() {
        System.out.println("You are guessing:  "+guessMovie);
    }

}

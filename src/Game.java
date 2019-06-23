import java.io.File;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) throws Exception {


        File file = new File("movie.txt");
        Scanner scanner = new Scanner(file);



        int count = 0;//to count total numbers of movies in the file
        String [] list = new String[100];//list of the movies
        for (int i = 0; scanner.hasNextLine(); i++){
            String line = scanner.nextLine();
            list[i] = line;//storing the name of the movies to an array of strings
            count++;
        }



        int randomIndex = (int)(Math.random()*count);//for showing a random movie from of the array of strings
        String randomMovie;
        randomMovie = list[randomIndex];
        char [] charArrMovie = list[randomIndex].toCharArray();//storing the selected movie to an array of chars
        char [] chArrMv = list[randomIndex].toCharArray();
        int lnthOfRandMovie = list[randomIndex].length();



        System.out.print("You are guessing : ");
        for (int j = 0 ; j < lnthOfRandMovie ; j++){
            charArrMovie[j] = '-';//showing '-' in place of the chars of the movie
        }
        System.out.println(charArrMovie);



        int wrongGuess = 0;//for tracking wrong guesses
        int rightGuess = 0;//for tracking right guesses
        System.out.println("You have guessed " + wrongGuess + " wrong letters.");
        Scanner keybordInput = new Scanner(System.in);
        while (!((wrongGuess == 10) || (rightGuess == randomMovie.length()))){
            char userGuess = keybordInput.next().charAt(0);

            int found = 0;
            for (int i = 0 ; i < lnthOfRandMovie ; i++) {
                found = randomMovie.indexOf(userGuess);//returns an int greater than or equal to 0 i.e the positionp
                if (chArrMv[i] == userGuess){
                    charArrMovie[i] = userGuess;
                    rightGuess++;
                }
            }
            if (found < 0) {                           //of the char if found, int less than 0 if not found
                wrongGuess++;
                System.out.println(charArrMovie);
                System.out.println("You have guessed " + wrongGuess + " wrong letters.");
            }
            else{
                System.out.println(charArrMovie);
                System.out.println("You have guessed " + wrongGuess + " wrong letters.");
            }
        }
        if (wrongGuess == 10){//condition for loosing
            System.out.println("OOPS! YOU ARE OUT OF GUESSES...GAME OVER." + "\nYOUR MOVIE: " + randomMovie.toUpperCase());
        }
        else if (rightGuess == randomMovie.length()){//condition for wining
            System.out.println("VOILA! THAT'S CORRECT...YOU HAVE WON.");
        }
    }
}

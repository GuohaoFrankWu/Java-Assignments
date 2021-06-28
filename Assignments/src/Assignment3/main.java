package Assignment3;
import javax.imageio.ImageTranscoder;
import java.util.*;


public class main {
    public static void main(String[] args){
        //initialize a dictionary
        String[] library = {"cat", "model", "leftover", "star", "lobster", "lollipop",
                "female", "jealous", "glorious", "acknowledge"};
        Random rd = new Random();//making the random functionality
        Scanner input = new Scanner(System.in);//making the scanner
        System.out.println("H A N G M A N".toUpperCase(Locale.ROOT));
        String YN = "";//initialize the input value

        //start execute the guessing game, make sure it shows the "_" at the beginning of guessing
        do{
            //makes the random picked word to character array
            String pick = library[rd.nextInt(library.length)];
            //System.out.println(pick);

            char[] Broken_word = pick.toCharArray();//making character array of a pick
            ArrayList<Character> answer = new ArrayList<>();//using ArrayList to simplify the process
            for(int i = 0; i < Broken_word.length; i++){
                answer.add(Broken_word[i]);
            }
            //System.out.println(Arrays.toString(answer));
            char[] guess = new char[Broken_word.length];
            //initialize each character as '_'
            Arrays.fill(guess, '_');
            String process = new String(guess);//make it print out the dash bottom lines
            //System.out.println(Arrays.toString(guess) + " " +process);
            StringBuilder missing_Letter = new StringBuilder();//initialize the identifier of missing letters

            //inner process to guess the words
            //initialize the match string value
            String match;
            do{
                System.out.println("+---+");//print out the available fail times sheet

                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");

                System.out.println("  ===");
                System.out.println("Missing letters: " + missing_Letter.toString());
                System.out.println(new String(guess));
                System.out.println("Guess a letter");
                char guess_letter = input.next().charAt(0);
                System.out.println(guess_letter);
                //after enter a letter, let's recorded in the process
                if(answer.contains(guess_letter) == false){// the letter was not founded
                    missing_Letter.append(guess_letter);
                }else{
                    for(int i = 0; i < guess.length; i++){//search this letter, binary search?
                        if(guess[i] == guess_letter){
                            System.out.println("You have already guessed that letter. Choose again.");
                            break;
                        }else{
                            guess[answer.indexOf(guess_letter)] = guess_letter;
                            if(new String(guess) == pick){
                                break;
                            }

                        }
                    }

                }
                //match = new String(guess);





            }while(new String(guess) != pick);





            System.out.println("Do you want to play again? (yes or no)");//ask user if you want to play again
            YN = input.nextLine();


        }while(YN.equals("yes"));//pass

    }
}

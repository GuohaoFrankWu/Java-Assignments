package Assignment1;
import java.util.*;

public class main {
    public static void main(String[] args){
        System.out.println("You are in a land full of dragons. In front of you,\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "and will share his treasure with you. The other dragon\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "Which cave will you go into? (1 or 2)");//opening theme
        Scanner input = new Scanner(System.in);
        int enter = 0;

        do{
            enter = input.nextInt();
            if(enter == 1){
                System.out.println("You approach the cave...\n" +
                        "It is dark and spooky...\n" +
                        "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                        "Gobbles you down in one bite!");
            }else if(enter == 2){
                System.out.println("You approach the cave...\n" +
                        "It is bright and lively...\n" +
                        "A large dragon craws out in front of you! He lifts his jaws and...\n" +
                        "shake you hand!");
            }else{
                System.out.println("again");
                continue;
            }
        }while (enter != 1 && enter != 2);


    }
}

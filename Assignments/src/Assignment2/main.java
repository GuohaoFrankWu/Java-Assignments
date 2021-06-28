package Assignment2;
import java.util.*;

public class main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random gen = new Random();
        int res = gen.nextInt(20) + 1;
        int guess = 0;
        int times = 0;
        System.out.println("Enter the number to guess: ");
        do{
            guess = input.nextInt();
            times += 1;
            if(guess > res){
                System.out.println("Too high");
            }else if(guess < res){
                System.out.println("Too low");
            }else{
                System.out.println(guess + " is correct number");
                System.out.println("Guessed " + times +" times.");
            }
        }while(guess != res);
    }
}

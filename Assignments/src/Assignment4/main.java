package Assignment4;
import java.util.*;


public class main {
    static ArrayList<Integer> playerPos = new ArrayList<Integer>();
    static ArrayList<Integer> computerPos = new ArrayList<Integer>();

    public static void main(String[] args){
        //this program is tic tac toe game program, the player will play with computer
        Scanner play = new Scanner(System.in);//set up the functionality of input
        Random computerPlay = new Random();//make a class of computer player
        char UserSymbol = ' ';//initialize the symbol of user and computer
        char ComputerSymbol = ' ';

        char [][] gameboard = {{' ', '|', ' ', '|', ' '},//0 0-4
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                {' ', '|', ' ', '|', ' '},//2 0-4
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                {' ', '|', ' ', '|', ' '}};//4 0-4
        System.out.println("Here’s what the user sees when they run the Tic-Tac-Toe program. The text the player enters is in bold.\n" +
                "Welcome to Tic-Tac-Toe!");
        String X_O, Yes_NO;
        Yes_NO = "";


        //this is the start of game
        do{//decide the symbol
            System.out.println("Do you want to be X or O?");
            X_O = play.nextLine();
            //please choose 'X' and 'O' first, if you choose X, Computer will choose O
            if(X_O.equals("X")){
                UserSymbol = 'X';
                ComputerSymbol = 'O';
            }else if(X_O.equals("O")){
                UserSymbol = 'O';
                ComputerSymbol = 'X';
            }else{
                System.out.println("Please enter only X and O");
            }
        }while (!X_O.equals("X") && !X_O.equals("O"));
        System.out.println("The computer will go first");
        while(true){//making loop forever to play
            //let player play first before printing game board
            int ComputerPositionNum = computerPlay.nextInt(9) + 1;
            while (playerPos.contains(ComputerPositionNum) || computerPos.contains(ComputerPositionNum)) {
                //System.out.println("Position taken, enter another");
                ComputerPositionNum = computerPlay.nextInt(9) + 1;
            }

            placement(gameboard, ComputerPositionNum,false, ComputerSymbol);
            printGameBoard(gameboard);

            if(checkWinner().length() > 0){
                System.out.println(checkWinner());
                playerPos.clear();
                computerPos.clear();
                System.out.println("Do you want to play again? (yes or no)");
                Yes_NO = play.nextLine();
                if(Yes_NO.equals("no")){
                    break;
                }else{
                    gameboard = new char[][]{{' ', '|', ' ', '|', ' '},//0 0-4
                            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
                            {' ', '|', ' ', '|', ' '},//2 0-4
                            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
                            {' ', '|', ' ', '|', ' '}};//4 0-4

                    System.out.println("The computer will go first");
                }
            }
            System.out.println("What is your next move? (1-9)");
            int Player_position = play.nextInt();
            //these check the position taken
            while (playerPos.contains(Player_position) || computerPos.contains(Player_position)) {
                System.out.println("Position taken, enter another");
                Player_position = play.nextInt();
            }
            placement(gameboard, Player_position, true, UserSymbol);
            //printGameBoard(gameboard);
            //System.out.println(checkWinner());
            if(checkWinner().length() > 0){
                System.out.println(checkWinner());
                playerPos.clear();
                computerPos.clear();
                System.out.println("Do you want to play again? (yes or no)");
                Yes_NO = play.nextLine();
                if(Yes_NO.equals("no")){
                    break;
                }else{
                    gameboard = new char[][]{{' ', '|', ' ', '|', ' '},//0 0-4
                            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
                            {' ', '|', ' ', '|', ' '},//2 0-4
                            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
                            {' ', '|', ' ', '|', ' '}};//4 0-4

                    System.out.println("The computer will go first");
                }
            }
        }//end of game


    }

    public static void printGameBoard(char[][] board){
        for(char[] row: board){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println();
        }
    }//pass
    
    public static void placement(char[][] board, int position, boolean player, char symbol){
        //true is player, false is computer
        if(player){
            playerPos.add(position);
        }else{
            computerPos.add(position);
        }

        switch(position){
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][2] = symbol;
                break;
            case 3:
                board[0][4] = symbol;
                break;
            case 4:
                board[2][0] = symbol;
                break;
            case 5:
                board[2][2] = symbol;
                break;
            case 6:
                board[2][4] = symbol;
                break;
            case 7:
                board[4][0] = symbol;
                break;
            case 8:
                board[4][2] = symbol;
                break;
            case 9:
                board[4][4] = symbol;
                break;
            default:
                System.out.println("invalid position, please  enter 1 through 9");
        }
    }//pass

    public static String checkWinner(){
        //all rows, all columns, 2 diagnose
        List Row123 = Arrays.asList(1, 2, 3);
        List Row456 = Arrays.asList(4, 5, 6);
        List Row789 = Arrays.asList(7, 8, 9);
        List Col147 = Arrays.asList(1, 4, 7);
        List Col258 = Arrays.asList(2, 5, 8);
        List Col369 = Arrays.asList(3, 6, 9);
        List Cross159 = Arrays.asList(1, 5, 9);
        List Cross753 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(Row123);
        winning.add(Row456);
        winning.add(Row789);
        winning.add(Col147);
        winning.add(Col258);
        winning.add(Col369);
        winning.add(Cross159);
        winning.add(Cross753);
        for(List ind: winning){
            if(playerPos.containsAll(ind)){
                return "Congratulations, You win!";
            }else if(computerPos.containsAll(ind)){
                return "The computer has beaten you! You lose.";
            }else if(playerPos.size() + computerPos.size() == 9){
                return "TIE!!!";
            }
        }
        return "";
    }//pass
}

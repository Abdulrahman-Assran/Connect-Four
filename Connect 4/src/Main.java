import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int win = 0;
        System.out.print("Enter your symbol player 1: ");
        String player1 =input.next();
        System.out.print("Enter your symbol player 2: ");
        String player2 =input.next();
        String player = player1;
        int move ;
        String[][] table = new String[8][8];
        for (int i=0 ; i< table.length ; i++){
            for (int j=0 ; j< table[i].length ; j++){
                table[i][j]=" ";
            }
        }
        tableDisplay(table);
        while(win==0){
            System.out.print("\nEnter your move player "+player+": ");
            move = input.nextInt()-1;
            while(move<0 || move>7) {
                System.out.println("Invalid number try again");
                move = input.nextInt()-1;
            }
            while (tableCheck(table,move)==false){
                System.out.println("Invalid choice try again");
                move = input.nextInt()-1;
            }
            table = tableChange(table,move,player);
            tableDisplay(table);
            win = checkWinner(table);
            if (win==0){
                if (player.equals(player1)){
                    player = player2;
                }
                else if (player.equals(player2)){
                    player = player1;
                }
            }
        }
        if (win == 1){
            System.out.println("\nPlayer "+player+" wins!");
        }
        else if (win == 2){
            System.out.println("\nEnded in a draw");
        }
    }
    public static void tableDisplay (String[][] table){
            for (int i=0; i<table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    System.out.print("|");
                    System.out.print(" "+""+table[i][j]+"\t");
                }
                System.out.print("|");
                System.out.println("\n---------------------------------");
                if(i==7){
                    System.out.println("  1\t  2\t  3\t  4\t  5\t  6\t  7\t  8");
                }
            }
    }
    public static boolean tableCheck (String[][] table , int num){
        int counter =0;
        while (counter< table.length && !table[counter][num].equals(" ")){
             counter++;
        }
        if (counter == table.length){
            return false;
        }
        else {
            return true;
        }
    }
    public static String[][] tableChange(String[][] table, int num , String player){
        int counter =1;
        while (counter< table.length && !table[table.length-counter][num].equals(" ")){
            counter++;
        }
        table[table.length-counter][num]=player;
        return table;
    }
    public static int checkWinner(String [][] table){
        int result = 2;
        for (int i=0 ; i< table.length ; i++){
            for (int j=0 ; j< table[i].length ; j++){
                if(table[i][j] .equals(" ")){
                    result =0;
                }
            }
        }
        for(int i=0 ; i<= table.length-4 ; i++){
            for (int j=0 ; j< table[i].length ; j++){
                if (!table[i][j].equals(" ") && table[i][j].equals(table[i][j+1]) && table[i][j].equals(table[i][j+2]) && table[i][j].equals(table[i][j+3])){
                    result =1;
                }
            }
        }
        for(int i=0 ; i<= table.length-4 ; i++){
            for (int j=0 ; j< table[i].length ; j++){
                if (!table[j][i].equals(" ") && table[j][i].equals(table[j][i+1]) && table[j][i].equals(table[j][i+2]) && table[j][i].equals(table[j][i+3])){
                    result =1;
                }
            }
        }
        for(int limit=0; limit<= table.length-4 ; limit++){
            int j=limit;
            for(int i=0 ; i< table.length-(3+limit); i++){
                if(!table[i][j].equals(" ") && table[i][j].equals(table[i+1][j+1]) && table[i][j].equals(table[i+2][j+2]) && table[i][j].equals(table[i+3][j+3])){
                    result =1;
                }
                j++;
            }
        }
        for(int limit=0; limit<= table.length-4 ; limit++){
            int j=limit;
            for(int i=0 ; i< table.length-(3+limit); i++){
                if(!table[j][i].equals(" ") && table[j][i].equals(table[j+1][i+1]) && table[j][i].equals(table[j+2][i+2]) && table[j][i].equals(table[j+3][i+3])){
                    result =1;
                }
                j++;
            }
        }
        for(int limit=0; limit<= table.length-4 ; limit++){
            int j=limit;
            for(int i= table.length-1; i>= (3+limit); i--){
                if(!table[i][j].equals(" ") && table[i][j].equals(table[i-1][j+1]) && table[i][j].equals(table[i-2][j+2]) && table[i][j].equals(table[i-3][j+3])){
                    result =1;
                }
                j++;
            }
        }
        for(int limit= table.length-1; limit>= table.length-5 ; limit--){
            int i=limit;
            for(int j=0 ; j<= (limit-2); j++){
                if(!table[i][j].equals(" ") && table[i][j].equals(table[i-1][j+1]) && table[i][j].equals(table[i-2][j+2]) && table[i][j].equals(table[i-3][j+3])){
                    result =1;
                }
                i--;
            }
        }
        return result;
    }
}
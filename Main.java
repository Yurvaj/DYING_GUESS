package com.company;
import java.util.*;

class game_Attributes{
    Random random_number = new Random();
    Scanner scanner_One = new Scanner(System.in);
    String player_Guess;
    String choose_Difficulty;
    int player_Strength = 3;

    String[] wordsEasy = {"hello","moon","swimming","basketball","lawn","venus","sunny","physics","building","city","country"
            ,"africa","asia","earth","plant","road","train","biology","chicken","turkey","desert","antarctica","ocean","river","animal"};

    String[] wordMedium = {"construction", "latitude"};

    String[] words_Meaning = {"greetings","space","activity","game","maintenance","space","felt","learning","shelter","landmass","landmass"
    ,"landmass","landmass","space","grows","built","built","learning","mmm hunger","mmm hunger","hot","cold","deep","natural","lives"};

    int real_Random_Number = random_number.nextInt(wordsEasy.length-1);
    String Real_word = wordsEasy[real_Random_Number];
    boolean flag = true;
}

class assigned_Values extends game_Attributes{
    char[] character_Of_Jumbled_Word = Real_word.toCharArray();
    String swapped_String;
}

class game_logic extends assigned_Values{


    public void jumbled_Word(){
        for (int i=0;i<Real_word.length();i++) {
            if (i == 1){
                char temp = character_Of_Jumbled_Word[0];
                character_Of_Jumbled_Word[0] = character_Of_Jumbled_Word[1];
                character_Of_Jumbled_Word[1] = temp;
            } if (i == 3) {
                char temp = character_Of_Jumbled_Word[2];
                character_Of_Jumbled_Word[2] = character_Of_Jumbled_Word[3];
                character_Of_Jumbled_Word[3] = temp;
            }
            if (i == 5) {
                char temp = character_Of_Jumbled_Word[4];
                character_Of_Jumbled_Word[4] = character_Of_Jumbled_Word[5];
                character_Of_Jumbled_Word[5] = temp;
            }
            if (i == 7) {
                char temp = character_Of_Jumbled_Word[6];
                character_Of_Jumbled_Word[6] = character_Of_Jumbled_Word[7];
                character_Of_Jumbled_Word[7] = temp;
            }
        }
        swapped_String = new String(character_Of_Jumbled_Word);
    }

    public void game_Start(){
        System.out.println("A jumbled word will be displayed on your screen & you must guess the correct word in order to win !\n");
        System.out.println("HINT -> " + words_Meaning[real_Random_Number]);
        System.out.println("JUMBLED WORD: " + swapped_String);

        while(flag){
            player_Strength--;
            System.out.println("STRENGTH: " + player_Strength);
            System.out.println("\nGUESS: ");
            player_Guess = scanner_One.next();

            if (player_Guess.equalsIgnoreCase(Real_word)) {
                player_Strength++;
            }
            if (player_Strength==0){
                System.out.println("-------------");
                System.out.println("- GAME OVER -");
                System.out.println("-------------");
                System.exit(0);
            }

            if (player_Guess.equalsIgnoreCase(Real_word)){
                System.out.println("--------------------------------------");
                System.out.println("YOU GUESSED RIGHT! THE WORD WAS '" + Real_word + "'" );
                System.out.println("--------------------------------------");
            } else {
                System.out.println("WRONG GUESS! GUESS AGAIN ...");
            }
            real_Random_Number = random_number.nextInt(wordsEasy.length-1);
            Real_word = wordsEasy[real_Random_Number];
            character_Of_Jumbled_Word = Real_word.toCharArray();
            jumbled_Word();
            game_Start();
        }
    }

}

public class Main {

    public static void main(String[] args) {
        game_logic GL = new game_logic();
        GL.jumbled_Word();
        GL.game_Start();
    }
}
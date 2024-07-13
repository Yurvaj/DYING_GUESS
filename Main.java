package com.company;
import java.util.*;

class game_Attributes{
    Random random_number = new Random();
    Scanner scanner_One = new Scanner(System.in);
    int special_Number = 0;
    String player_Guess;
    String player_Guess_Medium;
    int medium_Gameplay_Threshold = 7;
    int player_Strength = 3;

    String[] wordsEasy = {"hello","moon","swimming","basketball","lawn","venus","sunny","physics","building","city","country"
            ,"africa","asia","earth","plant","road","train","biology","chicken","turkey","desert","antarctica","ocean","river","animal"};

    String[] words_Medium = {"construction", "latitude","longitude","microorganism","amoeba","centrifuge","mathematics","greenland",
    "iceland","terminator","abandoned","selfish","maintenance","landmass","greetings","galaxy","neptune","saturn","curtains"};

    String[] words_Meaning = {"greetings","space","activity","game","maintenance","space","felt","learning","shelter","landmass","landmass"
    ,"landmass","landmass","space","grows","built","built","learning","mmm hunger","mmm hunger","hot","cold","deep","natural","lives"};

    int real_Random_Number = random_number.nextInt(wordsEasy.length-1);
    int real_Random_Number_Medium = random_number.nextInt(words_Medium.length-1);
    String real_Word = wordsEasy[real_Random_Number];
    String real_Word_Medium = words_Medium[real_Random_Number_Medium];
    boolean flag = true;

}

class assigned_Values extends game_Attributes{
    char[] character_Of_Jumbled_Word = real_Word.toCharArray();
    char[] character_Of_Jumbled_Word_Medium = real_Word_Medium.toCharArray();
    String swapped_String;
    String swapped_String_Medium;


    public void generate_New_Random_Number(){
        real_Random_Number_Medium = random_number.nextInt(words_Medium.length-1);
        real_Word_Medium = words_Medium[real_Random_Number_Medium];
        character_Of_Jumbled_Word_Medium = real_Word_Medium.toCharArray();
    }

}

class game_logic extends assigned_Values {


    public void jumbled_Word() {
        for (int i = 0; i < real_Word.length(); i++) {
            if (i == 1) {
                char temp = character_Of_Jumbled_Word[0];
                character_Of_Jumbled_Word[0] = character_Of_Jumbled_Word[1];
                character_Of_Jumbled_Word[1] = temp;
            }
            if (i == 3) {
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
            swapped_String = new String(character_Of_Jumbled_Word);
        }
    }

    public void jumbled_Word_Medium() {
        for (int x = 0; x < real_Word_Medium.length(); x++) {
            if (x == 1) {
                char temp = character_Of_Jumbled_Word_Medium[0];
                character_Of_Jumbled_Word_Medium[0] = character_Of_Jumbled_Word_Medium[1];
                character_Of_Jumbled_Word_Medium[1] = temp;
            }
            if (x == 3) {
                char temp = character_Of_Jumbled_Word_Medium[2];
                character_Of_Jumbled_Word_Medium[2] = character_Of_Jumbled_Word_Medium[3];
                character_Of_Jumbled_Word_Medium[3] = temp;
            }
            if (x == 5) {
                char temp = character_Of_Jumbled_Word_Medium[4];
                character_Of_Jumbled_Word_Medium[4] = character_Of_Jumbled_Word_Medium[5];
                character_Of_Jumbled_Word_Medium[5] = temp;
            }
            if (x == 7) {
                char temp = character_Of_Jumbled_Word_Medium[6];
                character_Of_Jumbled_Word_Medium[6] = character_Of_Jumbled_Word_Medium[7];
                character_Of_Jumbled_Word_Medium[7] = temp;
            }
        }
        swapped_String_Medium = new String(character_Of_Jumbled_Word_Medium);
    }

    public void game_Repeat_Display(){
        System.out.println("HINT -> " + words_Meaning[real_Random_Number]);
        System.out.println("JUMBLED WORD: " + swapped_String);
    }

    public void game_Start_Display(){
        System.out.println("A jumbled word will be displayed on your screen & you must guess the correct word in order to win !\n");
        System.out.println("HINT -> " + words_Meaning[real_Random_Number]);
        System.out.println("JUMBLED WORD: " + swapped_String);

        while(flag){
            System.out.println("STRENGTH: " + player_Strength);
            System.out.println("\nGUESS: ");
            player_Guess = scanner_One.next();

            if (player_Guess.equalsIgnoreCase(real_Word)) {

                player_Strength++;

            } else {
                player_Strength--;
            }

            if (player_Strength>=medium_Gameplay_Threshold){
                System.out.println("\n--------------------------");
                System.out.println("-- DIFFICULTY INCREASED --");
                System.out.println("--------------------------");
                while (flag){

                    if (special_Number==0){
                        jumbled_Word_Medium();
                        special_Number++;
                    }
                    System.out.println("STRENGTH: " + player_Strength + "\n");
                    System.out.println("NO HINTS WILL BE GIVEN");
                    System.out.println("JUMBLED WORD: " + swapped_String_Medium + "\n");
                    System.out.println("GUESS: ");
                    player_Guess_Medium = scanner_One.next();

                    if (player_Strength<medium_Gameplay_Threshold){
                        System.out.println("\n----------------------------------------");
                        System.out.println("- YOU COULD NOT SURVIVE THE DIFFICULTY -");
                        System.out.println("----------------------------------------");
                        System.exit(0);
                    }

                    if (player_Guess_Medium.equalsIgnoreCase(real_Word_Medium)){
                        player_Strength++;
                        System.out.println("--------------------------------------");
                        System.out.println("YOU GUESSED RIGHT! THE WORD WAS '" + real_Word_Medium + "'" );
                        System.out.println("--------------------------------------");
                        generate_New_Random_Number();
                        jumbled_Word_Medium();
                    } else {
                        player_Strength--;
                        System.out.println("--------------------------------------");
                        System.out.println("WRONG GUESS! GUESS AGAIN ...");
                        System.out.println("--------------------------------------");
                    }

                }
            }

            if (player_Strength==0){
                System.out.println("-------------");
                System.out.println("- GAME OVER -");
                System.out.println("-------------");
                System.exit(0);
            }

            if (player_Guess.equalsIgnoreCase(real_Word)){
                System.out.println("--------------------------------------");
                System.out.println("YOU GUESSED RIGHT! THE WORD WAS '" + real_Word + "'" );
                System.out.println("--------------------------------------");
            } else {
                System.out.println("--------------------------------------");
                System.out.println("WRONG GUESS! GUESS AGAIN ...");
                System.out.println("--------------------------------------");
            }
            real_Random_Number = random_number.nextInt(wordsEasy.length-1);
            real_Word = wordsEasy[real_Random_Number];
            character_Of_Jumbled_Word = real_Word.toCharArray();
            jumbled_Word();
            game_Repeat_Display();
        }
    }

}

public class Main {

    public static void main(String[] args) {
        game_logic GL = new game_logic();
        GL.jumbled_Word();
        GL.game_Start_Display();
    }
}
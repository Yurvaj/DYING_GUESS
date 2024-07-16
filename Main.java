package com.company;
import javax.sound.midi.SysexMessage;
import java.util.*;


class game_Attributes{

    // THIS CLASS IS ONLY FOR GAME ATTRIBUTES AND INITIALIZING THE IMPORTED PACKAGES //

    Random random_number = new Random();
    Scanner scanner_One = new Scanner(System.in);


    // THE SPECIAL NUMBER IS USED LATER IN THE NESTED WHILE LOOP AT THE 'game_Start_Display()' METHOD

    int special_Number = 0;
    int special_Number_Two = 0;

    // TWO DIFFERENT VARIABLES FOR TWO DIFFERENT DIFFICULTIES TO STORE THE INPUT OF THE PLAYER'S GUESS

    String player_Guess;
    String player_Guess_Medium;
    String player_Guess_Hard;

    // USED LATER IN tHE HARD GAMEPLAY LOOP

    int use_Times_Power = 1;

    // 'MEDIUM_GAMEPLAY_THRESHOLD' VARIABLE IS USED AS A REFERENCE POINT IN RESPECT TO THE STRENGTH OF THE PLAYER, AS THE PLAYER STRENGTH EXCEEDS THIS
    // NUMBER THE PLAYER ENTERS A NEW INCREASED DIFFICULTY

    int medium_Gameplay_Threshold = 7;
    int hard_Gameplay_Threshold = 14;

    //THIS IS THE WHAT PLAYER STRENGTH IS AT THE START OF THE GAME

    int player_Strength = 3;

    // THREE DIFFERENT ARRAYS
    // ARRAY (1) -> EASY DIFFICULT WORD GENERATOR
    // ARRAY (2) -> MEDIUM DIFFICULTY WORD GENERATOR
    // ARRAY (3) -> WORD MEANING USED AS HINTS FOR ARRAY 'words_Easy'
    // ARRAY (4) -> HARD DIFFICULTY WORD GENERATOR

    String[] words_Easy = {"hello","moon","swimming","basketball","lawn","venus","sunny","physics","building","city","country"
            ,"africa","asia","earth","plant","road","train","biology","chicken","turkey","desert","antarctica","ocean","river","animal"};

    String[] words_Medium = {"construction", "latitude","longitude","microorganism","amoeba","centrifuge","mathematics","greenland",
            "iceland","terminator","abandoned","selfish","maintenance","landmass","greetings","galaxy","neptune","saturn","curtains","accelerate","advocate","banish"
            ,"baffled","cliche","doorknob","shower","laundry","stove","television","airplane","tank","missile","bombard","airstrip","kingdom"};

    String[] words_Hard = {"adamant","backbite","ballad","benefactor","charisma","dauntless","discrepancy","dismantle","endeavour","extinction","fathom"
    ,"fragile","futile","gamble","garment","gibberish","hostile","Imperative","indigenous","inevitable","Knight","leverage","mundane","oblivious","perplex"
    ,"preamble","pinnacle","quadrilateral","utopian","Whimsical","Zeal","Zippy","Patriarchy","Valediction","validation","Incarnate"};

    String[] words_Meaning = {"greetings","space","activity","game","maintenance","space","felt","learning","shelter","landmass","landmass"
            ,"landmass","landmass","space","grows","built","built","learning","mmm hunger","mmm hunger","hot","cold","deep","natural","lives"};

    // RANDOM WORD AND REAL WORD GENERATION PROCESS FOR BOTH EASY AND MEDIUM LEVEL

    int real_Random_Number = random_number.nextInt(words_Easy.length-1);
    int real_Random_Number_Medium = random_number.nextInt(words_Medium.length-1);
    int real_Random_Number_Hard = random_number.nextInt(words_Hard.length-1);
    String real_Word = words_Easy[real_Random_Number];
    String real_Word_Medium = words_Medium[real_Random_Number_Medium];
    String real_Word_Hard = words_Hard[real_Random_Number_Hard];

    // the boolean below maybe useful in the future, but as of now it has no real use.

    boolean flag = true;

    // ACCURACY

    float number_Of_Correct_Answers;
    float number_Of_All_Answers;

}

class assigned_Values extends game_Attributes{

    // TO CONVERT THE LETTERS OF THE CHOSEN REAL WORD TO AN ARRAY OF CHARACTERS [CONFUSING PART]

    char[] character_Of_Jumbled_Word = real_Word.toCharArray();
    char[] character_Of_Jumbled_Word_Medium = real_Word_Medium.toCharArray();
    char[] character_Of_Jumbled_Word_Hard = real_Word_Hard.toCharArray();
    String swapped_String;
    String swapped_String_Medium;
    String swapped_String_Hard;

    // USED LATER IN THE NESTED WHILE LOOP.

    public void generate_New_Random_Number(){
        real_Random_Number_Medium = random_number.nextInt(words_Medium.length-1);
        real_Word_Medium = words_Medium[real_Random_Number_Medium];
        character_Of_Jumbled_Word_Medium = real_Word_Medium.toCharArray();
    }

    // USED LATER IN THE NESTED WHILE LOOP.

    public void generate_New_Random_Number_Hard(){
        real_Random_Number_Hard = random_number.nextInt(words_Hard.length-1);
        real_Word_Hard = words_Hard[real_Random_Number_Hard];
        character_Of_Jumbled_Word_Hard = real_Word_Hard.toCharArray();
    }

}

class game_logic extends assigned_Values {

    // MAIN LOGIC TO SWAP THE LETTER'S OF THE EASY REAL WORD

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

        // MAIN LOGIC TO SWAP THE LETTER'S OF THE MEDIUM REAL WORD

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

    public void jumbled_Word_Hard() {

        // MAIN LOGIC TO SWAP THE LETTER'S OF THE HARD REAL WORD

        for (int z = 0; z < real_Word_Hard.length(); z++) {
            if (z == 1) {
                char temp = character_Of_Jumbled_Word_Hard[0];
                character_Of_Jumbled_Word_Hard[0] = character_Of_Jumbled_Word_Hard[1];
                character_Of_Jumbled_Word_Hard[1] = temp;
            }
            if (z == 3) {
                char temp = character_Of_Jumbled_Word_Hard[2];
                character_Of_Jumbled_Word_Hard[2] = character_Of_Jumbled_Word_Hard[3];
                character_Of_Jumbled_Word_Hard[3] = temp;
            }
            if (z == 5) {
                char temp = character_Of_Jumbled_Word_Hard[4];
                character_Of_Jumbled_Word_Hard[4] = character_Of_Jumbled_Word_Hard[5];
                character_Of_Jumbled_Word_Hard[5] = temp;
            }
            if (z == 7) {
                char temp = character_Of_Jumbled_Word_Hard[6];
                character_Of_Jumbled_Word_Hard[6] = character_Of_Jumbled_Word_Hard[7];
                character_Of_Jumbled_Word_Hard[7] = temp;
            }
        }
        swapped_String_Hard = new String(character_Of_Jumbled_Word_Hard);
    }

    public void game_Repeat_Display(){

        // THIS METHOD IMPROVES THE VISUALS OF THE GAME, IF WE DO NOT CALL THIS THEN [LINE - 145] WILL KEEP REPEATING IN OUR CODE WHICH IS PRETTY ANNOYING LOL.

        System.out.println("STRENGTH: " + player_Strength + "\n");
        System.out.println("HINT -> " + words_Meaning[real_Random_Number]);
        System.out.println("JUMBLED WORD: " + swapped_String);
    }

    // CAN'T REALLY EXPLAIN WHAT IS GOING ON DOWN BELOW YOU WILL HAVE TO READ IT OR USE DEBUGGER

    public void game_Start_Display() {
        System.out.println("A jumbled word will be displayed on your screen & you must guess the correct word in order to win !\n");
        System.out.println("STRENGTH: " + player_Strength + "\n");
        System.out.println("HINT -> " + words_Meaning[real_Random_Number]);
        System.out.println("JUMBLED WORD: " + swapped_String);

        while (flag) {
            System.out.println("\nGUESS: ");
            player_Guess = scanner_One.next();

            if (player_Guess.equalsIgnoreCase(real_Word)) {
                number_Of_Correct_Answers++;
                number_Of_All_Answers++;
                player_Strength++;

            } else {
                number_Of_All_Answers++;
                player_Strength--;

            }

            if (player_Strength >= medium_Gameplay_Threshold) {
                System.out.println("\n--------------------------");
                System.out.println("-- DIFFICULTY INCREASED --");
                System.out.println("--------------------------");

                while (flag) {


                    if (player_Strength>=hard_Gameplay_Threshold){

                        System.out.println("\n--------------------------");
                        System.out.println("--- INSANE DIFFICULTY ---");
                        System.out.println("--------------------------");

                        while (flag){

                            if (player_Strength>=25){
                                System.out.println("----------------------------------------");
                                System.out.println("YOU WON THE GAME, WELL DONE!");
                                System.out.println("\t\t  ACCURACY: " + (number_Of_Correct_Answers/number_Of_All_Answers) * 100 + "%");
                                System.out.println("----------------------------------------");
                                System.exit(0);
                            }

                            if (special_Number_Two==0){
                                use_Times_Power = player_Strength/4;
                                special_Number_Two++;
                                jumbled_Word_Hard();
                            }

                            if (player_Strength>=hard_Gameplay_Threshold){
                                System.out.println("To use special power enter: [power]  ||  you can use 'power': " + use_Times_Power + " times");
                                System.out.println("STRENGTH: " + player_Strength + "\n");
                                System.out.println("NO HINTS WILL BE GIVEN");
                                System.out.println("JUMBLED WORD: " + swapped_String_Hard + "\n");
                                System.out.println("GUESS: ");
                                player_Guess_Hard = scanner_One.next();
                                if (use_Times_Power>0) {
                                    if (player_Guess_Hard.equalsIgnoreCase("power")) {
                                        use_Times_Power--;
                                        player_Guess_Hard = real_Word_Hard;
                                        System.out.println("\nPOWER USED!");
                                    }
                                }
                            }
                            if (player_Strength < hard_Gameplay_Threshold) {
                                System.out.println("\n----------------------------------------");
                                System.out.println("- YOU COULD NOT SURVIVE THE DIFFICULTY -");
                                System.out.println("\t\tTHE WORD WAS '" + real_Word_Hard + "'");
                                System.out.println("\t\t  ACCURACY: " + (number_Of_Correct_Answers/number_Of_All_Answers) * 100 + "%");
                                System.out.println("----------------------------------------");
                                System.exit(0);
                            }
                            if (player_Guess_Hard.equalsIgnoreCase(real_Word_Hard)) {
                                number_Of_Correct_Answers++;
                                number_Of_All_Answers++;
                                player_Strength++;
                                System.out.println("--------------------------------------");
                                System.out.println("YOU GUESSED RIGHT! THE WORD WAS '" + real_Word_Hard + "'");
                                System.out.println("--------------------------------------");
                                generate_New_Random_Number_Hard();
                                jumbled_Word_Hard();
                            } else {
                                number_Of_All_Answers++;
                                player_Strength--;
                                System.out.println("----------------------------------");
                                System.out.println("WRONG GUESS! GUESS AGAIN ...");
                                System.out.println("----------------------------------");
                            }
                        }
                    }

                    if (special_Number == 0) {
                        jumbled_Word_Medium();
                        special_Number++;
                    }
                    if (player_Strength >= medium_Gameplay_Threshold) {

                        System.out.println("STRENGTH: " + player_Strength + "\n");
                        System.out.println("NO HINTS WILL BE GIVEN");
                        System.out.println("JUMBLED WORD: " + swapped_String_Medium + "\n");
                        System.out.println("GUESS: ");
                        player_Guess_Medium = scanner_One.next();
                    }

                    if (player_Strength < medium_Gameplay_Threshold) {
                        System.out.println("\n----------------------------------------");
                        System.out.println("- YOU COULD NOT SURVIVE THE DIFFICULTY -");
                        System.out.println("\t\tTHE WORD WAS '" +real_Word_Medium+"'");
                        System.out.println("\t\t  ACCURACY: " + (number_Of_Correct_Answers/number_Of_All_Answers) * 100 + "%");
                        System.out.println("----------------------------------------");
                        System.exit(0);
                    }

                    if (player_Guess_Medium.equalsIgnoreCase(real_Word_Medium)) {
                        number_Of_Correct_Answers++;
                        number_Of_All_Answers++;
                        player_Strength++;
                        System.out.println("--------------------------------------");
                        System.out.println("YOU GUESSED RIGHT! THE WORD WAS '" + real_Word_Medium + "'");
                        System.out.println("--------------------------------------");
                        generate_New_Random_Number();
                        jumbled_Word_Medium();
                    } else {
                        number_Of_All_Answers++;
                        player_Strength--;
                        System.out.println("----------------------------------");
                        System.out.println("WRONG GUESS! GUESS AGAIN ...");
                        System.out.println("----------------------------------");
                    }
                }
            }

            if (player_Strength==0){
                System.out.println("\n-----------------------");
                System.out.println("GAME OVER");
                System.out.println("ACCURACY: " + (number_Of_Correct_Answers/number_Of_All_Answers)*100 + "%");
                System.out.println("-----------------------");
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
            real_Random_Number = random_number.nextInt(words_Easy.length-1);
            real_Word = words_Easy[real_Random_Number];
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
//  this is a comment from UV
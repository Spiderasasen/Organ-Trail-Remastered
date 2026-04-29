import components.MainComponents;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

import static components.Colors.*;

class Main{
    public static void main(String[] args) {
        //getting the scanner
        Scanner scan = new Scanner(System.in);

        //importing other files
        MainComponents components = new MainComponents();
        Game game = new Game();

        //main vars
        boolean flag = false;
        String[] options = {"1. Play", "2. How to Play", "3. Exit"};
        ArrayList<String> howToPLay = components.fileReader("data/how_to_play.txt");

        //main game section
        while (!flag){
            System.out.println("-- Organ Trail Remastered --\n" +
                    "Please select an option:");
            for (String option : options){
                System.out.println(option);
            }

            //checking the user entered the right input
            try{
                int choice = scan.nextInt();
                scan.nextLine();

                //seeing what the user has chosen
                switch (choice){
                    case 1:
                        //once the user plays the game, the game will end when its done. not making the user to mainly leave the game they finished the game
                        System.out.println("");
                        game.mainGameArea(scan);
                        flag = true;
                        scan.close();
                        break;
                    case 2:
                        System.out.println(CYAN + "How to play\n" + RESET);
                        for (String lines : howToPLay){
                            System.out.println(lines);
                        }
                        components.pressEnter(scan);
                        break;
                    case 3:
                        System.out.println(RED + "Exiting the game...\n" + RESET);
                        flag = true;
                        scan.close();
                        break;
                    default:
                        System.out.println(RED + "Invalid choice.\n" + RESET);
                        break;
                }
            }
            catch (InputMismatchException e){
                System.out.println(RED + "Please enter a number\n" + RESET);
                scan.nextLine();
            }
        }
    }
}
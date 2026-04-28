import game_components.MakingFamily;
import game_components.SelectionMenu;
import java.util.Scanner;

public class Game {
    //private vars
    private String charcter_class;

    //getting game components
    SelectionMenu selectionMenu = new SelectionMenu();
    MakingFamily makingFamily = new MakingFamily();

    public void mainGameArea(Scanner scan){
        //selecting a class
        selectionMenu.menu(scan);
        charcter_class = selectionMenu.getCharcater();

        //making a family
        makingFamily.makeFamily(scan);
    }
}

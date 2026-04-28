import game_components.SelectionMenu;
import java.util.Scanner;

public class Game {
    //getting game components
    SelectionMenu selectionMenu = new SelectionMenu();

    public void mainGameArea(Scanner scan){
        selectionMenu.menu(scan);
    }
}

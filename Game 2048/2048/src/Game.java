/**
 * @author Jaskaran Singh
 * @date 10 April 2021
 * @file Game.java
 * @details Main Class for running the game.
 */

public class Game {
    public static void main(String[] args) {
        GUI view=new GUI();
        GameCal calc=new GameCal();
        view.startgame(calc);
        calc.spawn();
        calc.spawn();
    }
}


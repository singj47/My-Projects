/**
 * @author Jaskaran Singh
 * @date 10 April 2021
 * @file GameCal.java
 *  @details It has all important methods for game calculations
 */
import java.awt.Color;

public class GameCal {
    public static int boundry;
    public static int result;

    /**
     * @brief Default Constructor.
     * @details It is used to initialize boundry and result .
     */
    GameCal() {
        boundry=0;
        result=0;
    }
    /**
     * @brief Return the result of the game.
     */
    int getResult()
        {
           return(result); 
        }
    /**
     * @brief used to generate the random number on tile in 10 % and 90% ratio.
     * @details spawns a two or a four on an empty tile whenever a move is initiated.
     */
    public void spawn() {
        boolean empty = true;
        while ( empty ) {
            int row = (int)( Math.random() * 4 );
            int col = (int)( Math.random() * 4 );
            double x = Math.random();
            if ( GUI.b[row][col].getText() == "" ) {
                if ( x < 0.1 ) {
               GUI.TextOnSquare("4", row, col);
                    empty = false;
                }
                else {
                   GUI.TextOnSquare("2", row, col);
                    empty = false;
                }
            }
            if(allSquareFull())
                empty = false;
                    }
                }
    /**
     * @brief It returns max value on the board.
     */
    public int getMaxOnSquare() {
        int high=0;
        for ( int i = 0; i < 4; i++ ) {
            for ( int j = 0; j < 4; j++ ) {
                if (GUI.b[i][j].getText().trim()!=""){
                if ( Integer.parseInt(GUI.b[i][j].getText().trim()) > high ) {
                    high = Integer.parseInt(GUI.b[i][j].getText().trim());
                }
                }
            }
        }
        return(high);
    }
    /**
     * @brief It makes all tiles gray on starting of new game.
     */

    public void newGameStart() {
        int high=0;
        for ( int i = 0; i < 4; i++ ) {
            for ( int j = 0; j < 4; j++ ) {
                GUI.b[i][j].setText("");
                GUI.b[i][j].setBackground(Color.lightGray);
                }
            }
        }



    /**
     * @brief checks if all the tiles are filled and if there are any further moves possible once filled.
     * @details returns true if the tiles are full and false otherwise.
     */
    public boolean allSquareFull() {
        int count = 0;
        for ( int i = 0; i < 4; i++ ) {
            for ( int j = 0; j < 4; j++ ) {
                if (GUI.b[i][j].getText().trim()!=""){
                if ( Integer.parseInt(GUI.b[i][j].getText().trim()) > 0 ) {
                    count++;
                }
                }
            }
        }
        
        if ( count == 16 ) {
            return true;
        }
        return false;
    }
    /**
     * @brief It checks the value on all tiles and compare to declare the game is over.
     * @details compares the value with its neighbours and returns true or false.
     */
    public static boolean gameCompleted() {
        int count = 0;
        for ( int i = 0; i < 4; i++ ) {
            for ( int j = 0; j < 4; j++ ) {
                 if (!GUI.b[i][j].getText().trim().equals("")){ {
                    if ( i == 0 && j == 0 ) {
                        if (!GUI.b[i + 1][j].getText().trim().equals("")&&!GUI.b[i][j+1].getText().trim().equals(""))
                        if ( Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i + 1][j].getText().trim())
                            && Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i][j + 1].getText().trim()) ) {
                            count++;
                        }
                    }
                    else if ( i == 0 && j == 3 ) {
                        if (!GUI.b[i + 1][j].getText().trim().equals("")&&!GUI.b[i][j-1].getText().trim().equals(""))
                        if ( Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i + 1][j].getText().trim())
                            && Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i][j - 1].getText().trim()) ) {
                            count++;
                        }
                    }
                    else if ( i == 3 && j == 3 ) {
                        if (!GUI.b[i - 1][j].getText().trim().equals("")&&!GUI.b[i][j-1].getText().trim().equals(""))
                        if ( Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i - 1][j].getText().trim())
                            && Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i][j - 1].getText().trim()) ) {
                            count++;
                        }
                    }
                    else if ( i == 3 && j == 0 ) {
                        if (!GUI.b[i - 1][j].getText().trim().equals("")&&!GUI.b[i][j+1].getText().trim().equals(""))
                        if ( Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i - 1][j].getText().trim())
                            && Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i][j + 1].getText().trim()) ) {
                            count++;
                        }
                    }
                    else if ( i == 0 && ( j == 1 || j == 2 ) ) {
                        if (!GUI.b[i + 1][j].getText().trim().equals("")&&!GUI.b[i][j+1].getText().trim().equals("")&&!GUI.b[i][j-1].getText().trim().equals(""))
                        if ( Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i + 1][j].getText().trim())
                            && Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i][j + 1].getText().trim())
                            && Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i][j - 1].getText().trim()) ) {
                            count++;
                        }
                    }
                    else if ( i == 3 && ( j == 1 || j == 2 ) ) {
                        if (!GUI.b[i - 1][j].getText().trim().equals("")&&!GUI.b[i][j+1].getText().trim().equals("")&&!GUI.b[i][j-1].getText().trim().equals(""))
                        if ( Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i - 1][j].getText().trim())
                            && Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i][j + 1].getText().trim())
                            && Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i][j - 1].getText().trim()) ) {
                            count++;
                        }
                    }
                    else if ( j == 0 && ( i == 1 || i == 2 ) ) {
                         if (!GUI.b[i + 1][j].getText().trim().equals("")&&!GUI.b[i-1][j].getText().trim().equals("")&&!GUI.b[i][j+1].getText().trim().equals(""))
                        if ( Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i][j + 1].getText().trim())
                            && Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i - 1][j].getText().trim())
                            && Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i + 1][j].getText().trim()) ) {
                            count++;
                        }
                    }
                    else if ( j == 3 && ( i == 1 || i == 2 ) ) {
                        if (!GUI.b[i][j-1].getText().trim().equals("")&&!GUI.b[i-1][j].getText().trim().equals("")&&!GUI.b[i+1][j].getText().trim().equals(""))
                        if ( Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i][j - 1].getText().trim())
                            && Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i - 1][j].getText().trim())
                            && Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i + 1][j].getText().trim()) ) {
                            count++;
                        }
                    }
                    else {
                        if (!GUI.b[i][j-1].getText().trim().equals("")&&!GUI.b[i][j+1].getText().trim().equals("")&&!GUI.b[i-1][j].getText().trim().equals("")&&!GUI.b[i+1][j].getText().trim().equals(""))
                      
                        if ( Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i][j - 1].getText().trim())
                            && Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i][j + 1].getText().trim())
                            && Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i - 1][j].getText().trim())
                            && Integer.parseInt(GUI.b[i][j].getText().trim()) != Integer.parseInt(GUI.b[i + 1][j].getText().trim()) ) {
                            count++;
                        }
                    }
                }
            }
        }
        }
        if ( count == 16 ) {
            return true;
        }
        return false;
    }
    /**
     * @brief method to move up in board tiles.
     */
     public void up() {
        for ( int i = 0; i < 4; i++ ) {
           boundry = 0;
            for ( int j = 0; j < 4; j++ ) {
                if ( GUI.b[j][i].getText().trim() != "") {
                    if ( boundry <= j ) {
                        verticalMove( j, i, "up" );
                    }
                }
            }
        }
    }
    /**
     * @brief method to move down in board tiles.
     */
     public void down() {
        for ( int i = 0; i < 4; i++ ) {
            boundry = 3;
            for ( int j = 3; j >= 0; j-- ) {
                if ( GUI.b[j][i].getText().trim() != "" ) {
                    if ( boundry >= j ) {
                        verticalMove( j, i, "down" );
                    }
                }
            }
        }
    }
    /**
     * @brief method to move left in board tiles.
     */
     public void left() {
        for ( int i = 0; i < 4; i++ ) {
            boundry = 0;
            for ( int j = 0; j < 4; j++ ) {
                if ( GUI.b[i][j].getText().trim() != "" ) {
                    if ( boundry <= j ) {
                        horizontalMove( i, j, "left" );
                    }
                }
            }
        }
    }
    /**
     * @brief method to move right in board tiles.
     */
    public void right() {
        for ( int i = 0; i < 4; i++ ) {
            boundry = 3;
            for ( int j = 3; j >= 0; j-- ) {
                if ( GUI.b[i][j].getText().trim() != "" ) {
                    if ( boundry>= j ) {
                        horizontalMove( i, j, "right" );
                    }
                }
            }
        }
    }
    /**
     * @brief method called in up and down methods to move up/down in board tiles.
     * @details Compares two tile's values together and if they are the same or if one
     * is equal to 0 (plain tile) - their values are added (provided that the tiles we are
     * comparing are two different tiles and they are moving towards the appropriate
     * direction),this is done through the entire column.
     */
    private void verticalMove( int row, int col, String direction ) {
        int present,next;
        if(GUI.b[boundry][col].getText().trim()=="")
            present=0;
            else
        present = Integer.parseInt(GUI.b[boundry][col].getText().trim());
         if(GUI.b[row][col].getText().trim()=="")
             next=0;
         else
        next = Integer.parseInt(GUI.b[row][col].getText().trim());
        if ( present == 0 || present == next ) {
            if ( row > boundry || ( direction.equals( "down" ) && ( row < boundry ) ) ) {
                int addScore = present + next;
                if ( present != 0 ) {
                    result+= addScore;
                }
               GUI.TextOnSquare(addScore+"", boundry, col);
                   GUI.TextOnSquare("BLANKBOX", row, col);
            }
        }
        else {
            if ( direction.equals( "down" ) ) {
                boundry--;
            }
            else {
               boundry++;
            }
            verticalMove( row, col, direction );
        }
    }
    /**
     * @brief method called in left and right methods to move left/right in board tiles.
     * @details Compares two tile's values together and if they are the same or if one
     * is equal to 0 (plain tile) - their values are added (provided that the tiles we are
     * comparing are two different tiles and they are moving towards the appropriate
     * direction),this is done through the entire row.
     */
    private void horizontalMove( int row, int col, String direction ) {
         int present,next;
        if(GUI.b[row][boundry].getText().trim()=="")
            present=0;
            else
        present = Integer.parseInt(GUI.b[row][boundry].getText().trim());
         if(GUI.b[row][col].getText().trim()=="")
             next=0;
         else
        next = Integer.parseInt(GUI.b[row][col].getText().trim());
        
        
       
        if ( present == 0 || present== next){
            if ( col > boundry || ( direction.equals( "right" ) && ( col < boundry) ) ) {
                int addScore = present + next;
                if ( present != 0 ) {
                    result += addScore;
                }
                 GUI.TextOnSquare(addScore+"", row, boundry);
                   GUI.TextOnSquare("BLANKBOX", row, col);
            }
        }
        else {
            if ( direction.equals( "right" ) ) {
                boundry--;
            }
            else {
                boundry++;
            }
            horizontalMove( row, col, direction );
        }
    }
}


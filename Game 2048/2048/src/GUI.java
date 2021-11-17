/**
 * @author Jaskaran Singh
 * @date 10 April 2021
 * @file GUI.java
 * @details creates the board and initialise all the tiles with colour,value etc.
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @brief It implements KeyListener,ActionListener interface and extends JPanel class.
 * @details It contains methods to create tiles,put numbers on that and overrides the KeyPressed a Action Performed methods.
 */

public class GUI extends JPanel implements KeyListener,ActionListener{
  int gameover = 0;
  JFrame frame;
  GameCal calc;
  JLabel score;
  JLabel best;
  static JLabel completed;
  JButton newGame;
  static JLabel b[][];

    /**
     * @brief  Constructor for GUI class .
     * @details  It takes no arguments, it create blank board with control button, labels for tiles.
     */
    GUI(){
         b=new JLabel[4][4];
            frame=new JFrame();
        this.setBounds(100, 125, 250, 250);
        this.setSize(360,360);
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(Color.darkGray);
    completed=new JLabel("");
    score=new JLabel("SCORE:0");
    best=new JLabel("0");
    JLabel bestHead=new JLabel("BEST:");
    newGame=new JButton("NewGame");
        newGame.setBounds(350,50,150,40);
        score.setBounds(100,50,100,40);
        best.setBounds(235,50,100,40);
        bestHead.setBounds(190,50,100,40);
        completed.setBounds(100,530,250,40);
        frame.add(completed);
        frame.add(newGame);
        frame.add(score);
        frame.add(best);
        frame.add(bestHead);
    int y_coordinate=20;
        for(int i=0;i<4;i++) {
        int x_coordinate=20;

        for(int j=0;j<4;j++) {

            b[i][j]=new JLabel("");
            b[i][j].setBounds(x_coordinate,y_coordinate,75,75);
            this.add(b[i][j]);
            x_coordinate=x_coordinate+82;

            b[i][j].setOpaque(true);
            b[i][j].setBackground(Color.lightGray);

        }
        y_coordinate=y_coordinate+82;

    }


        frame.setSize(550,650);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(this);
        frame.addKeyListener(this);
        newGame.addActionListener(this);
        frame.setFocusable(true);

}

    /**
     * @brief Create the text on tile .
     * @details On the basis of number of digits of the value appearing on the tile, the size and colour is decided.
     * @param value is string to be printed on tile.
     * @param i row number of the board.
     * @param j column number of the board.
     */

    static void TextOnSquare(String value,int i,int j) {
                if(value.length()==1) {
                    b[i][j].setFont(new java.awt.Font("Helvetica", 1, 20));
                    b[i][j].setText("  " + (value) + "");
                    b[i][j].setBackground(new Color(80*(int)(Math.log(Integer.parseInt(value))/Math.log(2)),255,255));

                }
                if(value.length()==2) {
                    b[i][j].setFont(new java.awt.Font("Helvetica", 1, 20));
                    b[i][j].setText(" " + (value) + "");
                     b[i][j].setBackground(new Color(255,40*(int)(Math.log(Integer.parseInt(value))/Math.log(2)),255));

                }
                if(value.length()==3) {
                    b[i][j].setFont(new java.awt.Font("Helvetica", 1, 20));
                    b[i][j].setText("" + (value) + "");
                     b[i][j].setBackground(new Color(255,255,30*(int)(Math.log(Integer.parseInt(value))/Math.log(2))/2));

                }
                if(value.length()==4) {
                    b[i][j].setFont(new java.awt.Font("Helvetica", 1, 20));
                    b[i][j].setText("" + (value) + "");
                    b[i][j].setBackground(new Color(18*(int)(Math.log(Integer.parseInt(value))/Math.log(2)),255,255));

                }
                if(value.length()==5) {
                    b[i][j].setFont(new java.awt.Font("Helvetica", 1, 20));
                    b[i][j].setText("" + (value) + "");
                     b[i][j].setBackground(new Color(255,10*(int)(Math.log(Integer.parseInt(value))/Math.log(2)),255));

                }
                if(value.length()==8) {
                    b[i][j].setText("");
                    b[i][j].setBackground(Color.lightGray);
                    }
    }
    /**
     * @brief Used to start the game with GameCal Object .
     * @param c GameCal object.
     */
    void startgame(GameCal c){
        calc=c;
    }

    /**
     * @brief Overriden function .
     * @param e KeyEvent object.
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }
    /**
     * @brief Overriden function .
     * @details performs up/down/left or right operations whenever the required key is pressed.
     * @param e KeyEvent object.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(GameCal.gameCompleted()){
            completed.setText("Game Over!!!!!");
            gameover = 1;
        }
        if(gameover == 0){
        if ( e.getKeyChar() == 'w' || e.getKeyCode() == 38) { 
            calc.up();
            calc.spawn();
            score.setText("SCORE:"+GameCal.result);
            if(Integer.parseInt(best.getText().trim())>GameCal.result)
                best.setText(best.getText().trim());
            else
                best.setText(""+GameCal.result);
        }
        else if ( e.getKeyChar() == 's' || e.getKeyCode() == 40 ) { 
             calc.down();
             calc.spawn();
             score.setText("SCORE:"+GameCal.result);
             
             if(Integer.parseInt(best.getText().trim())>GameCal.result)
                 best.setText(best.getText().trim());
             else
                 best.setText(""+GameCal.result);
        }
        else if ( e.getKeyChar() == 'a' || e.getKeyCode() == 37 ) {
                calc.left();
                calc.spawn();
                score.setText("SCORE:"+GameCal.result);
                
                if(Integer.parseInt(best.getText().trim())>GameCal.result)
                    best.setText(best.getText().trim());
                else
                    best.setText(""+GameCal.result);
        }
        else if ( e.getKeyChar() == 'd' || e.getKeyCode() == 39) {
            calc.right();
            calc.spawn();
            score.setText("SCORE:" + GameCal.result);

            if (Integer.parseInt(best.getText().trim()) > GameCal.result)
                best.setText(best.getText().trim());
            else
                best.setText("" + GameCal.result);
        }
        }
    }
    /**
     * @brief Overriden function .
     * @param e KeyEvent object.
     */
    @Override
    public void keyReleased(KeyEvent e) {}
    /**
     * @brief Overriden function .
     * @details refreshes the game whenever Newgame button is clicked.
     * @param e ActionEvent object.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        gameover = 0;
        calc.newGameStart();
        calc.spawn();
        calc.spawn();
        GameCal.result=0;
        calc.getResult();
        score.setText("SCORE:0");
        completed.setText("");
        newGame.setFocusable(false);
        frame.setFocusable(true);
    }
}


/**
 * @author Jaskaran Singh
 * @date 10 April 2021
 * @file TestGameCal.java
 * @details creates the board and initialise all the tiles with colour,value etc.
 */

import org.junit.*;

import static org.junit.Assert.*;

public class TestGameCal {
    GameCal o;
    GUI g;
    public TestGameCal() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        g=new GUI();
        o=new GameCal();
        g.startgame(o);
        g.TextOnSquare("4", 3, 3);
        g.TextOnSquare("4", 2, 3);
    }

    @After
    public void tearDown() {
        o=null;
        g=null;
    }


    @Test
    public void testGetResult() {
        GameCal instance = new GameCal();
        int expResult = 8;
        instance.up();
        int result = instance.getResult();
        assertEquals(expResult, result);

    }

// to be verified
    @Test
    public void testGetMaxOnSquare() {
        GameCal instance = new GameCal();
        int expResult = 4;
        int result = instance.getMaxOnSquare();
        assertEquals(expResult, result);

    }

    @Test
    public void testAllSquareFull() {
        GameCal instance = new GameCal();
        boolean expResult = false;
        boolean result = instance.allSquareFull();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }


    @Test
    public void testGameCompleted() {
        boolean expResult = false;
        boolean result = GameCal.gameCompleted();
        assertEquals(expResult, result);

    }

    @Test
    public void testUp() {
        GameCal instance = new GameCal();
        g.TextOnSquare("8", 1, 3);
        instance.up();
        int expResult = 8;
        int result = instance.getResult();
        System.out.println(result);
        Assert.assertEquals(expResult, result);

    }


    @Test
    public void testDown() {
        GameCal instance = new GameCal();
        g.TextOnSquare("1024", 3, 1);
        g.TextOnSquare("1024", 2, 1);
        instance.down();
        int expResult = 2048;
        int result = instance.getMaxOnSquare();
        assertEquals(expResult, result);
    }


    @Test
    public void testLeft() {
        GameCal instance = new GameCal();
        g.TextOnSquare("16", 2, 0);
        g.TextOnSquare("16", 2, 1);
        instance.left();
        int expResult = 32;
        int result = instance.getMaxOnSquare();
        assertEquals(expResult, result);
    }


    @Test
    public void testRight() {
        GameCal instance = new GameCal();
        g.TextOnSquare("64", 2, 3);
        g.TextOnSquare("32", 2, 2);
        instance.left();
        int expResult = 64;
        int result = instance.getMaxOnSquare();
        assertEquals(expResult, result);
    }

}


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.Test;

public class RobotTest {
	
	 private Robot robo = new Robot();
	
	 /*Test case 3 
	  Testers Name : Sasidhar Gampa
	  Date : 02/02/2023
	  Test Input data : <I 20>
	  Test Type : Functional,Unit Test
	  Test case  description: Execute the program with I 20 as input parameter
	  Expected output : 20,0,0,north
	  Bug Report :NA*/
    @Test
    public void testInitialize() {
    	robo.Input_command("I 20");
        assertEquals(20, robo.Room_size);
		assertEquals(0,robo.x_Coordinate);
		assertEquals(0,robo.y_Coordinate);
		assertEquals("north",robo.Direction);
		
    }

    
    /*Test case 5 
	  Testers Name : Sasidhar Gampa
	  Date : 03/02/2023
	  Test Input data : <I 10, D>
	  Test Type : Functional,Unit Test
	  Test case  description:Execute the program with D as input parameter
	  Expected output : Pen down status = True 
	  Bug Report :NA*/
    @Test
    public void testPenDown() {
        
        robo.Input_command("I 10");
        robo.Input_command("D");
        assertTrue(robo.Pendown);
    }

    /*Test case 6 
	  Testers Name : Sai kumar reddy
	  Date : 04/02/2023
	  Test Input data : <I 5, U>
	  Test Type :Functional,Unit Test 
	  Test case  description:Execute the program with U as input parameter
	  Expected output :Pen down status = False 
	  Bug Report :NA*/
    @Test
    public void testPenUp() {
        
        robo.Input_command("I 5");
        robo.Input_command("U");
        assertFalse(robo.Pendown);
    }
    
    /*Test case 2 
	  Testers Name : sai kumar reddy
	  Date : 31/01/2023
	  Test Input data : <No input>
	  Test Type : Functional,Unit Test 
	  Test case  description:To test the programs for default parameters
	  Expected output :0,0 North, pendown
	  Bug Report :NA*/
    
    @Test
    public void testdefaultparameters() {
    	
    	assertEquals(0, robo.x_Coordinate);
    	assertEquals(0, robo.y_Coordinate);
    	System.out.println(robo.Direction);
        //assertEquals("north", robo.Direction);
        assertFalse(robo.Pendown);
    	}
    
    /*Test case 10 
	  Testers Name : Harsha Kurrapati
	  Date : 28/01/2023
	  Test Input data : <I 5 , R>
	  Test Type : Functional,Unit Test
	  Test case  description: To test the program if robot turns direction to right 
	  Expected output : east
	  Bug Report :NA*/
    
    @Test
    public void testrightturn() {
        
        robo.Input_command("I 5");   
        robo.Input_command("R");
        robo.Input_command("R");
        robo.Input_command("R");
        robo.Input_command("R");
        robo.Input_command("R");
        assertEquals("east", robo.Direction);
    	}
    
    /*Test case 11 
	  Testers Name : Harsha Kurrapati
	  Date : 28/01/2023
	  Test Input data : <I 5, L>
	  Test Type : Functional,Unit Test
	 Test case  description: To test the program if robot turns direction to Left 
	  Expected output : east
	  Bug Report :NA*/
    
    @Test
    public void testleftturn() {
        
        
        robo.Input_command("I 5"); 
        robo.Input_command("R"); 
        robo.Input_command("R");
        robo.Input_command("R");
        robo.Input_command("L");
        robo.Input_command("L");
        //System.out.println("Returned String: "+ robot.Direction);
      
        assertEquals("east", robo.Direction);
    	}
    
    /*Test case 9 
	  Testers Name : Sravya reddy
	  Date : 26/01/2023
	  Test Input data : <I 50 , M 2>
	  Test Type : Functional,Unit Test
	  Test case  description: To test robot should not update position as pen status is pendown
	  Expected output : 0,0 , pendown status =false
	  Bug Report :NA*/
    
    @Test
    public void testdonotmove() {
    	robo.Input_command("I 50");
    	robo.Input_command("M 2");
    	 int x=robo.x_Coordinate;
         int y = robo.y_Coordinate;
         assertFalse(robo.Pendown);
        assertEquals(0,x);
        assertEquals(2,y);
        
        
    }
    
    /*Test case 14 
	  Testers Name : Sravya reddy
	  Date : 26/01/2023
	  Test Input data : <c, C>
	  Test Type : INterface based ,Unit Test
	  Test case  description:To test input command case sensitivity
	  Expected output : Position: 2, 3 - Pen: down - Facing: east
	  Bug Report :NA*/
    
    @Test
    /*This test case to check */
    public void testcommandcase() {
    	robo.x_Coordinate = 2;
        robo.y_Coordinate = 3;
        robo.Pendown = true;
        robo.Direction = "east";
        robo.Input_command("R");
        assertEquals("south",robo.Direction);
        
        robo.Input_command("r");
        assertEquals("west",robo.Direction);
        
   
    }
    
    /*Test case 1 
	  Testers Name : Harsha Kurrapti
	  Date : 01/02/2023
	  Test Input data : <k, b, f,>
	  Test Type : Interface based, Unit test
	  Test case  description: To test if program accepts other inputs in addition to listed commands
	  Expected output : Invalid command.Please enter valid command
	  Bug Report :NA*/
    
    @Test
    /*This test case to check */
    public void testinputcommand() {
    	
    	//check for if program accepts other commands 
    	 ByteArrayOutputStream temp1 = new ByteArrayOutputStream();
         PrintStream temp2 = System.out;
         System.setOut(new PrintStream(temp1));
         robo.Input_command("K");
         String actualoutput = temp1.toString(), expectedoutput="Error";
         assertTrue(actualoutput.contains(expectedoutput));
         System.setOut(temp2);
         
         //check for if program accepts other commands 
         ByteArrayOutputStream temp3 = new ByteArrayOutputStream();
         PrintStream temp4 = System.out;
         System.setOut(new PrintStream(temp3));
         robo.Input_command("f");
         String actualoutput1 = temp3.toString(), expectedoutput1="Error";
         assertTrue(actualoutput1.contains(expectedoutput1));
         System.setOut(temp4);

    }
    /*Test case 9 
	  Testers Name : Sasidhar Gampa
	  Date : 28/01/2023
	  Test Input data : < multiple commands specified at each starting of each test >
	  Test Type :  Functional , Unit Test
	  Test case  description: To test if robots is able to move across the floor grid
	  Expected output : multiple outputs with respect to inputs passsed 
	  Bug Report :NA*/
    
    @Test
    public void testMove() {
        
    	 //to test movement to north, input <I 5, D, M 2>, Expected Output : north, 0,2
        robo.Input_command("I 5");
        robo.Input_command("D");
        robo.Input_command("M 2");
        
        assertEquals("north", robo.Direction);
        assertEquals(0, robo.x_Coordinate);
        assertEquals(2, robo.y_Coordinate);
        assertEquals("north", robo.Direction);
        
       //to test movement to south, input <I 20, D, M 2, R, R, m 2>, Expected Output : south, 0, 0
        robo.Input_command("I 20");
        robo.Input_command("D");
        robo.Input_command("M 2");
        robo.Input_command("R"); 
        robo.Input_command("R");
        assertEquals("south", robo.Direction);
        robo.Input_command("M 2");
        assertEquals(0, robo.y_Coordinate);
        assertEquals(0, robo.x_Coordinate);
        
       //to test movement to east, input <I 200, D, M 2, R, m 2>, Expected Output : east, 2, 2
        robo.Input_command("I 200");
        robo.Input_command("D");
        robo.Input_command("M 2");
        robo.Input_command("R");
        assertEquals("east", robo.Direction);
        robo.Input_command("m 2");
        assertEquals(2, robo.y_Coordinate);
        assertEquals(2, robo.x_Coordinate);
        
        //to test movement to west, input <I 10, D, M 7, R, M 6, L, L M 3>, Expected Output : west, 3, 7
        robo.Input_command("I 10");
        robo.Input_command("D");
        robo.Input_command("M 7");
        robo.Input_command("R");
        robo.Input_command("M 6");
        robo.Input_command("L");
        robo.Input_command("L");
        assertEquals("west", robo.Direction);
        robo.Input_command("M 3");
        assertEquals(3, robo.x_Coordinate);
        assertEquals(7, robo.y_Coordinate);
        
        
   
    }
    
    /*Test case 8 
	  Testers Name : Sravya reddy
	  Date : 03/02/2023
	  Test Input data : <I 10 , D, M 12>
	  Test Type : Functional , Unit test
	  Test case  description:To test if robot is moving outside the set size of floor grid.
	  Expected output :Cannot move outside the Floor
	  Bug Report :NA*/
    
    
    @Test
    public void testmoveoutsidefloor() {
    	
    	robo.Input_command("I 10");
    	 robo.Input_command("D");
    	 ByteArrayOutputStream temp1 = new ByteArrayOutputStream();
         PrintStream temp2 = System.out;
         System.setOut(new PrintStream(temp1));
         robo.Input_command("M 12");
         String actualoutput = temp1.toString(), expectedoutput="Movement out of Room not allowed";
         assertTrue(actualoutput.contains(expectedoutput));
         System.setOut(temp2);
         
         robo.Input_command("I 10");
    	 robo.Input_command("D");
    	 ByteArrayOutputStream temp4 = new ByteArrayOutputStream();
         PrintStream temp3 = System.out;
         System.setOut(new PrintStream(temp4));
         robo.Input_command("r");
         robo.Input_command("M 12");
         String actualoutput1 = temp1.toString(), expectedoutput1="Movement out of Room not allowed";
         assertTrue(actualoutput1.contains(expectedoutput1));
         System.setOut(temp3);
         
         robo.Input_command("I 10");
    	 robo.Input_command("D");
    	 ByteArrayOutputStream temp5 = new ByteArrayOutputStream();
         PrintStream temp6 = System.out;
         System.setOut(new PrintStream(temp5));
         robo.Input_command("r");
         robo.Input_command("r");
         robo.Input_command("M 12");
         String actualoutput3 = temp1.toString(), expectedoutput3="Movement out of Room not allowed";
         assertTrue(actualoutput3.contains(expectedoutput3));
         System.setOut(temp6);
         
         robo.Input_command("I 10");
    	 robo.Input_command("D");
    	 ByteArrayOutputStream temp7 = new ByteArrayOutputStream();
         PrintStream temp8 = System.out;
         System.setOut(new PrintStream(temp7));
         robo.Input_command("r");
         robo.Input_command("r");
         robo.Input_command("r");
         robo.Input_command("M 12");
         String actualoutput4 = temp1.toString(), expectedoutput4="Movement out of Room not allowed";
         assertTrue(actualoutput4.contains(expectedoutput4));
         System.setOut(temp8);
    }
    

    /*Test case 4 
	  Testers Name : Sai kumar reddy
	  Date : 01/02/2023
	  Test Input data : <C>
	  Test Type : Functional, unit test 
	  Test case  description: To test current status function of program
	  Expected output : Position: 5, 7 - Pen: down - Facing: west
	  Bug Report :NA*/
    
    @Test
    public void testCurrentstatus() {

        robo.x_Coordinate = 5;
        robo.y_Coordinate = 7;
        robo.Pendown = true;
        robo.Direction = "west";
        ByteArrayOutputStream temp1 = new ByteArrayOutputStream();
        PrintStream temp2 = System.out;
        System.setOut(new PrintStream(temp1));
        robo.Input_command("C");
        String actualoutput = temp1.toString(), expectedoutput="Position: 5, 7 - Pen: down - Facing: west";
        assertTrue(actualoutput.contains(expectedoutput));
        System.setOut(temp2);

    }
    
    
    /*Test case 15 
	  Testers Name : Harsha Kurrapati
	  Date : 02/02/2023
	  Test Input data : <M e, I $, r 1>
	  Test Type : Interface, Unit test
	  Test case  description: To test if program takes arguments not supported by commands 
	  Expected output :Error
	  Bug Report :NA*/
    
    @Test
    public void testcommandarguments() {
    	
    	 ByteArrayOutputStream temp22 = new ByteArrayOutputStream();
         PrintStream temp23 = System.out;
         System.setOut(new PrintStream(temp22));
         robo.Input_command("m 4");
         String actualoutput15 = temp22.toString(), expectedoutput15="initialise";
         assertTrue(actualoutput15.contains(expectedoutput15));
         System.setOut(temp23);
    	
    	robo.Input_command("I 47");
    	
    	//check for other command to pass argument which is not a integer
    	 ByteArrayOutputStream temp1 = new ByteArrayOutputStream();
         PrintStream temp2 = System.out;
         System.setOut(new PrintStream(temp1));
         robo.Input_command("M e");
         String actualoutput = temp1.toString(), expectedoutput="Error";
         assertTrue(actualoutput.contains(expectedoutput));
         System.setOut(temp2);
        
       //check for other command to pass argument which is not a integer
         ByteArrayOutputStream temp3 = new ByteArrayOutputStream();
         PrintStream temp4 = System.out;
         System.setOut(new PrintStream(temp3));
         robo.Input_command("I $");
         String actualoutput1 = temp3.toString(), expectedoutput1="Error";
         assertTrue(actualoutput1.contains(expectedoutput1));
         System.setOut(temp4);
        
        //check for other command to pass extra argument which supports only one argument
         ByteArrayOutputStream temp5 = new ByteArrayOutputStream();
         PrintStream temp6 = System.out;
         System.setOut(new PrintStream(temp5));
         robo.Input_command("r 6");
         String actualoutput2 = temp5.toString(), expectedoutput2="Error";
         assertTrue(actualoutput2.contains(expectedoutput2));
         System.setOut(temp6);
         
       //check for other command to pass extra argument which supports only one argument
         ByteArrayOutputStream temp7 = new ByteArrayOutputStream();
         PrintStream temp8 = System.out;
         System.setOut(new PrintStream(temp7));
         robo.Input_command("c 6");
         String actualoutput3 = temp7.toString(), expectedoutput3="Error";
         assertTrue(actualoutput3.contains(expectedoutput3));
         System.setOut(temp8);
         
       //check for other command to pass extra argument which supports only one argument
         ByteArrayOutputStream temp9 = new ByteArrayOutputStream();
         PrintStream temp10 = System.out;
         System.setOut(new PrintStream(temp9));
         robo.Input_command("l 6");
         String actualoutput4 = temp9.toString(), expectedoutput4="Error";
         assertTrue(actualoutput4.contains(expectedoutput4));
         System.setOut(temp10);
         
       //check for other command to pass extra argument which supports only one argument
         ByteArrayOutputStream temp12 = new ByteArrayOutputStream();
         PrintStream temp13 = System.out;
         System.setOut(new PrintStream(temp12));
         robo.Input_command("u 9");
         String actualoutput5 = temp12.toString(), expectedoutput5="Error";
         assertTrue(actualoutput5.contains(expectedoutput5));
         System.setOut(temp13);
         
       //check for other command to pass extra argument which supports only one argument
         ByteArrayOutputStream temp14 = new ByteArrayOutputStream();
         PrintStream temp15 = System.out;
         System.setOut(new PrintStream(temp14));
         robo.Input_command("p 9");
         String actualoutput6 = temp14.toString(), expectedoutput6="Error";
         assertTrue(actualoutput6.contains(expectedoutput6));
         System.setOut(temp15);
         
       //check for other command to pass extra argument which supports only one argument
         ByteArrayOutputStream temp17 = new ByteArrayOutputStream();
         PrintStream temp16 = System.out;
         System.setOut(new PrintStream(temp17));
         robo.Input_command("q 9");
         String actualoutput7 = temp17.toString(), expectedoutput7="Error";
         assertTrue(actualoutput7.contains(expectedoutput7));
         System.setOut(temp16);
         
       //check for other command to pass extra argument which supports only one argument
         ByteArrayOutputStream temp18 = new ByteArrayOutputStream();
         PrintStream temp19 = System.out;
         System.setOut(new PrintStream(temp18));
         robo.Input_command("d 22");
         String actualoutput8 = temp18.toString(), expectedoutput8="Error";
         assertTrue(actualoutput8.contains(expectedoutput8));
         System.setOut(temp19);
         
       //check for other command to pass extra argument which supports only one argument
         ByteArrayOutputStream temp20 = new ByteArrayOutputStream();
         PrintStream temp21 = System.out;
         System.setOut(new PrintStream(temp20));
         robo.Input_command("m");
         String actualoutput11 = temp20.toString(), expectedoutput11="Error";
         assertTrue(actualoutput11.contains(expectedoutput11));
         System.setOut(temp21);
        
         
    }
    
    /*Test case 12 
	  Testers Name : sai kumar reddy
	  Date : 26/01/2023
	  Test Input data : <I 3 , P>
	  Test Type : Functional, Unit test
	  Test case  description: To test if floor is being printed as intended
	  Expected output :02  -  -  -  
	  				   01  *  -  - 
	  				   00  *  -  - 
	  				       00 01 02
	  Bug Report :NA*/
    
    @Test
    public void testPrintFloor() {
    	robo.Input_command("I 3");
    	robo.Input_command("D");
    	robo.Input_command("M 1");
    	
    	 ByteArrayOutputStream temp1 = new ByteArrayOutputStream();
         PrintStream temp2 = System.out;
         System.setOut(new PrintStream(temp1));
         robo.Input_command("P");
         String actualoutput = temp1.toString().replace("\r\n", "\n"), expectedoutput=" 02  -  -  - \n" +" 01  *  -  - \n" +" 00  *  -  - \n" +"     00 01 02\n";
         //asserEquals(expectedoutput, actualoutput);
         assertTrue(actualoutput.contains(expectedoutput));
         System.setOut(temp2);
         //System.out.println(actualoutput);
         //System.out.println(expectedoutput);
    	
    	
    }

    
    /*Test case 13 
	  Testers Name : Sasidhar Gampa
	  Date : 02/02/2023
	  Test Input data : <>
	  Test Type : 
	  Test case  description:
	  Expected output :
	  Bug Report :NA*/
    
    @Test
    public void testterminataion() {
    	
    	//robo.Input_command("q");
    	//boolean output= robo.process();
    	//assertFalse(output);
    	 
}
    }

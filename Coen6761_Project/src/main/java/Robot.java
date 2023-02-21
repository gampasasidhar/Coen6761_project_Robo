
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Robot {
List<int[]> way = new ArrayList<>();
int x_Coordinate, y_Coordinate;
   boolean Pendown;
   int[][] Room;
   int Room_size;
   
   
   final String NORTH = "north", EAST = "east", SOUTH = "south",WEST = "west" ;
   String Direction = NORTH;
   
   Scanner Temp = new Scanner(System.in);


public static void main(String[] args) {
       Robot Robo = new Robot();
       System.out.println("\t\t\t\t\t Welcome");
       System.out.println("--------------------------------------------------------------------------------------------------");
       System.out.println("Inital Conditions : Position(0,0), Robo is facing North, Pen is up");
       System.out.println("--------------------------------------------------------------------------------------------------");
       System.out.println("Please enter a command to process");
       Robo.Start();
   }

   public void Start() {
       while (true) {
           System.out.print("> ");
           String Input = Temp.nextLine();
           Input_command(Input);
       }
   }

   public boolean process() {
	   return process;
   }
   
   boolean process = true ;
   public void Input_command(String command){
       String[] Value = command.split(" ");
       String k = Value[0].toUpperCase();
       int Positions = 0;


       switch (k) {

           case "I":
               if (!(Value[1].matches("\\d+"))){
                   System.out.println("Error, I can only accept Integer values");
                   break;
               }
               Room_size = Integer.parseInt(Value[1]);
               Room = new int[Room_size][Room_size];
               for (int i = 0; i < Room_size; i++) {
                   for (int j = 0; j < Room_size; j++) {
                       Room[i][j] = 0;
                   }
               }
               x_Coordinate = 0;
               y_Coordinate = 0;
               Pendown = false;
               Direction = NORTH;
               System.out.println("Room is set to " + Room_size + " x " + Room_size + " array.");
               break;

           case "C":
               if (Value.length > 1) {
                   System.out.println("Error, C cant accept any additional values");
                   break;
               }
               System.out.println("Position: " + x_Coordinate + ", " + y_Coordinate + " - Pen: "
                       + (Pendown ? "down" : "up") + " - Facing: " + Direction);
               break;
               
           case "D":
               if (Value.length > 1) {
                   System.out.println("Error, D cant accept any additional values");
                   break;
               }
               Pendown = true;
               System.out.println("Pen is down.");
               updateRoom();
               break;
           case "U":
               if (Value.length > 1) {
                   System.out.println("Error, U cant accept any additional values");
                   break;
               }
               Pendown = false;
               System.out.println("Pen is up.");
               updateRoom();
               break;
           case "M":
               if(Room_size==0){
                System.out.println("initialise Room to move");
                break;
               }
               if (Value.length < 2){
                System.out.println("Error, M need two values to process");
                break;
            }
               if (!(Value[1].matches("\\d+"))){
                   System.out.println("Error, M can only accept Integer values");
                   break;
               }
               Positions = Integer.parseInt(Value[1]);
               move(Positions);
               break;
               case "L":
               if (Value.length > 1) {
               System.out.println("Error, L cant accept any additional values");
               break;
               }
               Move_Left();
               break;
               case "R":
               if (Value.length > 1) {
               System.out.println("Error, R cant accept any additional values");
               break;
               }
               Move_Right();
               break;
               case "P":
               if (Value.length > 1) {
                   System.out.println("Error, P cant accept any additional values");
                    break;
                  }
               updateRoom();
               Room_Map();
               break;
               case "Q":
               if (Value.length > 1) {
               System.out.println("Error, Q cant accept any additional values");
               break;
               }
               System.out.println("Terminating Robot");
                process = false;
               System.exit(0);
               break;
               default:
               System.out.println("Error,Command not supported");
               break;
               }
               }
               public void move(int Positions) {
                   updateRoom();
                   int Temp_X = x_Coordinate;
                   int Temp_Y = y_Coordinate;
                   switch (Direction) {
                       case NORTH:
                       Temp_Y = y_Coordinate + Positions;
                       if (Temp_Y >= Room_size) {System.out.println("Movement out of Room not allowed");
                       
                   }
                           
                           break;
                       case EAST:
                       Temp_X = x_Coordinate + Positions;
                       if (Temp_X >= Room_size) {
                           System.out.println("Movement out of Room not allowed");
                         
                       }
                           break;
                       case SOUTH:
                       Temp_Y = y_Coordinate - Positions;
                       if (Temp_Y < 0) {
                           System.out.println("Movement out of Room not allowed");
                           
                       }
                           break;
                       case WEST:
                       Temp_X = x_Coordinate - Positions;
                       if (Temp_X < 0) {
                           System.out.println("Movement out of Room not allowed");
                       
                       }
                           break;
                   }
                   if (Temp_X >= 0 && Temp_X < Room_size && Temp_Y >= 0 && Temp_Y < Room_size) {
                       int xDiff = Temp_X - x_Coordinate;
                       int yDiff = Temp_Y - y_Coordinate;
           
                       for (int i = 0; i <= Positions; i++) {
                           way.add(new int[] { x_Coordinate + i * xDiff / Positions, y_Coordinate + i * yDiff / Positions });
                       }
                       if (Pendown) {
                           x_Coordinate = Temp_X;
                           y_Coordinate = Temp_Y;
                           System.out.println("Moved to position: " + x_Coordinate + ", " + y_Coordinate + "\n");
                           way.add(new int[] { x_Coordinate, y_Coordinate });
                           updateRoom();
                       } else {
                           System.out.println("Robot is moving freely as pen is up, the new coordinates are: " + Temp_X + ", "
                                   + Temp_Y + " (not updated to print in Room map)\n");
                       }
                       //return true;
                   } else {
                       //System.out.println("Movement out of Room not allowed");
                       //return false;
                   }
               }
               
               public void Move_Right() {
                   switch (Direction) {
                       case NORTH:
                           Direction = EAST;
                           break;
                       case EAST:
                           Direction = SOUTH;
                           break;
                       case SOUTH:
                           Direction = WEST;
                           break;
                       case WEST:
                           Direction = NORTH;
                           break;
                   }
                   System.out.println("Rotated right.Robo is currently Facing: " + Direction);
               }
               
               public void Move_Left() {
                   switch (Direction) {
                       case NORTH:
                           Direction = WEST;
                           break;
                       case WEST:
                           Direction = SOUTH;
                           break;
                       case SOUTH:
                           Direction = EAST;
                           break;
                       case EAST:
                           Direction = NORTH;
                           break;
                   }
                   System.out.println("Rotated Left.Robo is currently Facing: " + Direction);
                   }
               public void updateRoom() {
                   if (Pendown) {
                       Room[x_Coordinate][y_Coordinate] = 1;
                   }
               }
               public void Room_Map() {
                   System.out.println("");
                   for (int j = Room_size - 1; j >= 0; j--) {
                       System.out.print(" " + String.format("%02d", j) + " ");
                       for (int i = 0; i < Room_size; i++) {
                           boolean hold = false;
                           for (int[] pos : way) {
                               if (i == pos[0] && j == pos[1]) {
                                   System.out.print(" * ");
                                   hold = true;
                                   break;
                               }
                           }
                           if (!hold) {
                               if (Room[i][j] == 1) {
                                   System.out.print(" x ");
                               } else {
                                   System.out.print(" - ");
                               }
                           }
                       }
                       System.out.println("");
                   }
                   System.out.print("    ");
                   for (int i = 0; i < Room_size; i++) {
                       System.out.print(String.format(" %02d", i));
                   }
                   System.out.println("");
               }
               
           }                





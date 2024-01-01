//add imports
import java.util.*;
import java.io.*;

//Note* csv files are the data files and txt files are the output file
class Main {//start main class
  public static void main(String[] args) {//start main method
    //declare variables
    int choice, total;
    double libPer,consPer,NDPPer,greenPer;
    String district,replay;
    Scanner in = new Scanner(System.in); //get scanner class
//get
    System.out.println("░█████╗░██╗░░░░░██████╗░███████╗██████╗░████████╗░█████╗░  ██╗░░░██╗░█████╗░████████╗███████╗\n██╔══██╗██║░░░░░██╔══██╗██╔════╝██╔══██╗╚══██╔══╝██╔══██╗  ██║░░░██║██╔══██╗╚══██╔══╝██╔════╝\n███████║██║░░░░░██████╦╝█████╗░░██████╔╝░░░██║░░░███████║  ╚██╗░██╔╝██║░░██║░░░██║░░░█████╗░░\n██╔══██║██║░░░░░██╔══██╗██╔══╝░░██╔══██╗░░░██║░░░██╔══██║  ░╚████╔╝░██║░░██║░░░██║░░░██╔══╝░░\n██║░░██║███████╗██████╦╝███████╗██║░░██║░░░██║░░░██║░░██║  ░░╚██╔╝░░╚█████╔╝░░░██║░░░███████╗\n╚═╝░░╚═╝╚══════╝╚═════╝░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝  ░░░╚═╝░░░░╚════╝░░░░╚═╝░░░╚══════╝\n\n░██████╗██╗███╗░░░███╗██╗░░░██╗██╗░░░░░░█████╗░████████╗░█████╗░██████╗░\n██╔════╝██║████╗░████║██║░░░██║██║░░░░░██╔══██╗╚══██╔══╝██╔══██╗██╔══██╗\n╚█████╗░██║██╔████╔██║██║░░░██║██║░░░░░███████║░░░██║░░░██║░░██║██████╔╝\n░╚═══██╗██║██║╚██╔╝██║██║░░░██║██║░░░░░██╔══██║░░░██║░░░██║░░██║██╔══██╗\n██████╔╝██║██║░╚═╝░██║╚██████╔╝███████╗██║░░██║░░░██║░░░╚█████╔╝██║░░██║\n╚═════╝░╚═╝╚═╝░░░░░╚═╝░╚═════╝░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░░╚════╝░╚═╝░░╚═╝");
   
  do{//asks user if they want to replay
    do{
      //asks user what riding they want to simulate
    System.out.println("\nWhich riding do you want to simulate\n1.Lakeland\n2.Lethbridge\n3.Yellowhead\n4.Customize your own riding");
    System.out.println("Enter your choice");
    choice = in.nextInt();
      }while(choice<1||choice>4);//if user inputs invalid data
    
    if(choice ==1){
      //the data file name is given because it will be used in the try and catch in the voting class
      Voting Lakeland = new Voting("Lakeland.csv");//if user wants lakeland riding data
    }
    else if(choice ==2){
      Voting Lethbridge = new Voting("Lethbridge.csv");//if user wants lethbridge Data
    }
    else if(choice ==3){
      Voting Yellowhead= new Voting("Yellowhead.csv");//if user wants yellowhead riding data
    }
    else{//customized version
      do{
        in.nextLine();//clears the buffer
        System.out.println("Enter riding district");
        district = in.nextLine();
        do{
          System.out.println("Enter total votes:");
          total = in.nextInt();
        }while(total<1);//must be atleast 1 vote
        do{
          System.out.println("Enter Liberal percentage");
          libPer= in.nextDouble(); 
        }while(libPer<0);//must be positive
        do{
          System.out.println("Enter Conservative percentage");
          consPer= in.nextDouble(); 
        }while(consPer<0);//must be positive
        do{
          System.out.println("Enter NDP percentage");
          NDPPer= in.nextDouble();
        }while(NDPPer<0);//must be positive
        do{
          System.out.println("Enter Green percentage");
          greenPer= in.nextDouble();
        }while(greenPer<0);//must be positive
        
        if(greenPer+NDPPer+consPer+libPer>100){
          System.out.println("the party percentage you gave is too much");
        }
      }while(greenPer+NDPPer+consPer+libPer>100);//the total vote percentage of all the parties can not be more than 100%
      Simulation Riding = new Simulation(district,total,libPer,consPer,NDPPer,greenPer);//puts this into simulation object to simulate the code
      System.out.println(Riding);//prints the toString
      
    }
    in.nextLine();//clears the buffer
      do{
        System.out.println("\nDo you want to simulate again");//asks user if they want to replay
        replay = in.nextLine();
        replay = replay.toLowerCase();
      }while(!replay.equals("yes")&& !replay.equals("no"));//if user inputs invalid values
    
    }while(replay.equals("yes"));//if user wants to replay
    
    System.out.println("\nThanks For Simulating!");
  }//end main method
}//end main class
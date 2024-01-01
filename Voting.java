import java.util.*;
import java.io.*;
public class Voting{
  private String fileName;
  private ArrayList<Integer> totalVotes = new ArrayList<Integer>();
  private String district;
  private double percentageLib;
  private double percentageCons;
  private double percentageNDP;
  private double percentageGreen;

  public Voting(String fileName){
    this.fileName = fileName;
    int finalCount=0;
    //this try and catch will read the csv files
     try{
      File myFile = new File (this.fileName);
      Scanner myFileReader= new Scanner(myFile); 
       //runs until data has no next lines
      while (myFileReader.hasNextLine()) {//start while loop
         String comma = myFileReader.nextLine();
         String [] data = comma.split(",");
         this.district = data[0];//the district name is the first data given
         String party = data[1];//name of party is second piece of data
         int vote = Integer.parseInt(data[2]);
        totalVotes.add(vote);//the number of votes of each party is added to the arraylist because then it can transversed to get total votes
        if(party.equals("Conservative/Conservateur")){//if party is conservative then percentage is conservative
          percentageCons = Double.parseDouble(data[3]);
        }
        else if(party.equals("Liberal/Libéral")){//if party is liberal, percentage is liberal
          percentageLib = Double.parseDouble(data[3]);
        }
        else if(party.equals("NDP-New Democratic Party/NPD-Nouveau Parti démocratique")){//if party is NDP, then percentage is NDP
          percentageNDP = Double.parseDouble(data[3]);
        }
        else if(party.equals("Green Party/Parti Vert")){//if party is green, then percentage is green 
          percentageGreen = Double.parseDouble(data[3]);
        }
        //other party percentages will be calculated by 100-(liberal+NDP+conservative+green)
        
    }
       int initialSize = totalVotes.size(); //not neccessary but good practice for arraylists
       for(int i =0;i<initialSize;i++){
         finalCount += totalVotes.get(i);//gets total votes
       }
       myFileReader.close();
       }  
       
    catch (FileNotFoundException e) {//if there is an error
      System.out.println("Error:");
      System.out.println("Your file does not exist");
    }
    
    //constructor to get the simulation
    Simulation riding = new Simulation(this.district,finalCount,percentageLib,percentageCons,percentageNDP,percentageGreen);
    
    //this try and catch statement will read the code and write it as an output file
    try{
      String file = this.district+".txt";//makes a name of file
      FileWriter myFileWriter = new FileWriter(file);
      myFileWriter.write(riding.toString());//writes the data into a txt file
      myFileWriter.close();//closes the filewriter
    }
    catch (IOException e) {
      System.out.println("There is an error");
    }
       System.out.println(riding);//prints all the data
  }
  
}
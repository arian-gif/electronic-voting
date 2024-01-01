import java.util.*;
public class Simulation{
  private String ridingDis;
  private int totalVotes;
  private int voteLiberal;
  private int voteCons;
  private int voteNDP;
  private int voteGreen;
  private int voteOther;
  private int invalidCounter;
  private double percentageLib;
  private double percentageCons;
  private double percentageNDP;
  private double percentageGreen;
  private double percentageOther;
  private double newLib;
  private double newCons;
  private double newNDP;
  private double newGreen;
  private double newOther;
  private double newInvalid;

  public Simulation(String ridingDis,int totalVotes, double percentageLib,double percentageCons,double percentageNDP,double percentageGreen){
    this.ridingDis = ridingDis;
    this.totalVotes = totalVotes; 
    this.percentageLib = percentageLib;
    this.percentageCons = percentageCons;
    this.percentageNDP = percentageNDP;
    this.percentageGreen = percentageGreen;
    this.percentageOther =100-(this.percentageLib+this.percentageCons+this.percentageNDP +this.percentageGreen);
    //to run the simulation
    election();
  }
  public void election(){
    //runs the simulation for however many votes there are
    for (int i =0;i<totalVotes;i++){
      double isInvalid = (Math.random()*100); 
      //from research 1% of online votes were spoiled, compared to real elections
      if(isInvalid<=1){//there is a 1% chance a ballot will be spoiled
        invalidCounter++;
      }
        
      else{//if its not spoiled
        double sim = (Math.random()*100);//creates a random num and if it falls into a certain category, it will add to a party cote
      if(sim<=this.percentageLib){//if it is in a certain range, lib vote will increased
        this.voteLiberal++;
      }
      else if(sim<=this.percentageLib+this.percentageCons){//if it is in a certain range, conservative vote will increased
        this.voteCons++;
      }
      else if(sim<=this.percentageLib+this.percentageCons+this.percentageNDP){//if it is in a certain range, NDP vote will increased
        this.voteNDP++;
      }
      else if(sim<=this.percentageLib+this.percentageCons+this.percentageNDP+percentageGreen){//if it is in a certain range, green vote will increased
        this.voteGreen++;
      }
      else{//if it is in a certain range, other vote will increased
        this.voteOther++;
      }
      } 
    }
    //new percentages
    this.newLib = ((double)this.voteLiberal/this.totalVotes)*100;
    this.newCons = ((double)this.voteCons/this.totalVotes)*100;
    this.newNDP = ((double)this.voteNDP/this.totalVotes)*100;
    this.newGreen =((double)this.voteGreen/this.totalVotes)*100;
    this.newOther = ((double)this.voteOther/this.totalVotes)*100;
    this.newInvalid = ((double)this.invalidCounter/this.totalVotes)*100;
  }
  //prints the output of the simulation 
  public String toString(){
    return String.format("%n%20s%s%n%n%s%d%n%n%s%n%-16s%-14d%-14.2f%n%-16s%-14d%-14.2f%n%-16s%-14d%-14.2f%n%-16s%-14d%-14.2f%n%-16s%-14d%-14.2f%n%-16s%-14d%-14.2f",this.ridingDis," Data","Total Votes: ", this.totalVotes, "Party         | Votes       | Percentage Votes","Liberal",this.voteLiberal, this.newLib,"Conservative", this.voteCons, this.newCons, "NDP", this.voteNDP, newNDP, "Green Party", this.voteGreen, this.newGreen, "Other Party", this.voteOther, this.newOther, "Spoiled Votes", this.invalidCounter, this.newInvalid);
  }
}
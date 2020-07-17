import java.util.Arrays;
import java.util.Scanner;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Player[] players = new Player[4];
        for(int i = 0;i < players.length;i++){
            players[i] = new Player(sc.nextInt(),sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        int target = sc.nextInt();
        sc.close();
        double[] averageRun = findAverageOfRuns(players,target);
        for(int i = 0;i < averageRun.length;i++){
            if(averageRun[i] >= 80 && averageRun[i] <= 100)
                System.out.println("Grade A");
            else if(averageRun[i] >= 50 && averageRun[i] <= 79)
                System.out.println("Grade B");
            else
                System.out.println("Grade C");
        }
}
    public static double[] findAverageOfRuns(Player[] players, int target){
        double averageRun[]= new double[0];
        for(int i = 0;i < players.length;i++){
            if(players[i].getMatchesPlayed() >= target){
                averageRun = Arrays.copyOf(averageRun, averageRun.length+1);
                averageRun[averageRun.length-1] = (double)(players[i].getRunsScored()/players[i].getMatchesPlayed());
            }
        }
        return averageRun;
    }
}

class Player
{
    int id;
    String name;
    int iccRank;
    int matchesPlayed;
    int runsScored;

    public int getMatchesPlayed(){
        return matchesPlayed;
    }
    public int getRunsScored(){
        return runsScored;
    }

    public Player(int id,String name,int iccRank,int matchesPlayed,int runsScored){
        this.id=id;
        this.name=name;
        this.iccRank=iccRank;
        this.matchesPlayed=matchesPlayed;
        this.runsScored=runsScored;
    }
}
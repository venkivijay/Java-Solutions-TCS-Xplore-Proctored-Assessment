import java.util.Scanner;
public class Solution {
   public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Player players[] = new Player[4];
    for(int i = 0; i<players.length; i++) {
        int playerId = sc.nextInt();
        sc.nextLine();
        String skill = sc.nextLine();
        String level = sc.nextLine();
        int points = sc.nextInt();
        sc.nextLine();
        players[i] = new Player(playerId, skill, level, points);
    }
    String newskill = sc.nextLine();
    String newlevel = sc.nextLine();
    int totalPoints = findPointsForGivenSkill(players, newskill);
    Player chosenOne = getPlayerBasedOnLevel(players, newskill, newlevel);
    if(totalPoints>0)
        System.out.println(totalPoints);
    else
        System.out.println("The given Skill is not available");
    if(chosenOne == null)
        System.out.println("No player is available with specified level, skill and eligibility points");
    else
        System.out.println(chosenOne.getPlayerId());
    }

    public static int findPointsForGivenSkill(Player[] players, String skill){
        int points = 0;
        for(int i = 0; i<players.length; i++) {
            if(players[i].getSkill().equalsIgnoreCase(skill))
            points = points + players[i].getPoints();
        }
        return points;
      }

    public static Player getPlayerBasedOnLevel(Player[] players, String skill, String level){
        for(int i=0;i<players.length; i++) {
            if(players[i].getSkill().equalsIgnoreCase(skill) && players[i].getLevel().equalsIgnoreCase(level)){
                if(players[i].getPoints() >= 20)
                return players[i];
            }
        }
        return null;
    }
}

class Player{
    private int playerId;
    private String skill;
    private String level;
    private int points;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Player(int playerId, String skill, String level, int points) {
        this.playerId = playerId;
        this.skill = skill;
        this.level = level;
        this.points = points;
    }
}
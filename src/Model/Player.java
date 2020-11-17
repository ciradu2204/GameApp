package Model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class Player implements Comparable<Player>, Serializable{

    protected final int id;
    protected String playerName;
    protected int currentLevel;
    protected int pointsEarned;
    protected static int lastIdAllocated = 0;
    protected static final char EQLN = '\n';
    protected static final String Quote = "\"";


    public Player(){
        this.id = ++lastIdAllocated;
        this.playerName = "Unknown";
        this.currentLevel = 1;
        this.pointsEarned = 0;
    }

    public Player(String playerName){
        this.id = ++lastIdAllocated;
        this.playerName = playerName;
        this.currentLevel = 1;
        this.pointsEarned = 0;

    }

    public Player(int id, String playerName, int currentLevel, int pointsEarned ){
        this.id = id;
        this.playerName = playerName;
        this.currentLevel = currentLevel;
        this.pointsEarned = pointsEarned;
        if(id > lastIdAllocated){
            lastIdAllocated = id;
        }
    }

    public int getId() {
        return this.id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(int pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    @Override
    public String toString() {
        return "\nPlayer Id: " + this.id + " _Player Name: " + this.playerName + " -Current Level:" + this.currentLevel + " _Points:" + this.pointsEarned;
    }

    public String toString(char delimeter){

        return  Integer.toString(this.id )+ delimeter + Quote + this.playerName + Quote + delimeter + Integer.toString(this.currentLevel) + delimeter + Integer.toString(this.pointsEarned)+ EQLN;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return getId() == player.getId() &&
                getCurrentLevel() == player.getCurrentLevel() &&
                getPointsEarned() == player.getPointsEarned() &&
                getPlayerName().equals(player.getPlayerName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPlayerName(), getCurrentLevel(), getPointsEarned());
    }

    public static Comparator<Player> pointsEarnedComparator = new Comparator<Player>() {
        @Override
        public int compare(Player player1, Player player2) {
            int player1PointsEarned = player1.getPointsEarned();
            int player2PointsEarned = player2.getPointsEarned();
            
            //ascending order


           // return player1PointsEarned - player2PointsEarned;
            //descending order
           return player2PointsEarned - player1PointsEarned;


        }
    };
    @Override
    public int compareTo(Player o) {
        int empId = ((Player) o).getId();

        // ascending order
        return this.id - empId;

        // descending order
       // return empId - this.id;
    }
}

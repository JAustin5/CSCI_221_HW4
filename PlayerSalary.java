import java.util.*;
/**
 * CSCI 221, Summer 2022, Programming HW4
 * Name: <Jalena Austin>
 * 
 * <PlayerSalary>.java
 * 
 * This class creates an array by putting a set of ints and strings by initalizing each
 * as an instant variable. Within each of the following methods after the constructor
 * are the getters for each instance variable which are then called at toString to
 * output the information given by the file chosen for the assignment.
 * 
 * Certification of Authentication:
 * I certify that this assignment is entirely my own work.
*/
public class PlayerSalary
{
    private int yearID;
    private String teamID;
    private String leagueID;
    private String playerID;
    private int salary;
    
    public PlayerSalary(int year, String team, String league, 
                        String player, int salary)
    {
        // This is the constructor to build the class PlayerSalary and the setter for the getter methods below.
        this.yearID = year;
        this.teamID = team;
        this.leagueID = league;
        this.playerID = player;
        this.salary = salary;
    }
    
    public int getYearID()
    {
        // This getter is used to get the year from the PlayerSalary.
        return yearID;
    }
    
    public String getTeamID()
    {
        // This getter is used to get the team ID from the PlayerSalary.
        return teamID;
    }
    
    public String getLeagueID()
    {
        // This getter is used to get the league ID from the PlayerSalary.
        return leagueID;
    }
    
    public String getPlayerID()
    {
        // This getter is used to get the player ID from the PlayerSalary.
        return playerID;
    }
    
    public int getSalary()
    {
        // This getter is used to get the salary for a player from PlayerSalary.
        return salary;
    }
    
    public String toString() 
    {   
        /*
         * This toString builds to make the output format for the information of a player by
         * their information given in PlayerSalary.
         */
        String rtnString = "Player information:" + 
            "\nYear: " + yearID + 
            "\nTeam: " + teamID + 
            "\nLeague: " + leagueID +
            "\nPlayer: " + playerID + 
            "\nSalary: " + salary;
        return rtnString;   
    }
}

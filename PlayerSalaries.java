import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * CSCI 221, Summer 2022, Programming HW4
 * Name: <Jalena Austin>
 * 
 * <PlayerSalaries>.java
 * 
 * This class uses the array created in the class PlayerSalary to use amongst
 * a variety of methods to output the information for players given the parameters
 * for each method. The constructor for this class reads the file given to the 
 * constructor is the main figure to be used to determine the player outputs for
 * each method within this class, while outputting the information in the format
 * given in PlayerSalary. With alongside each of these methods, now will throw the 
 * necessary exceptions.
 * 
 * Certification of Authentication:
 * I certify that this assignment is entirely my own work.
 */
public class PlayerSalaries
{
    private PlayerSalary[] salaries;
    
    public PlayerSalaries(String filename) throws FileNotFoundException
    {
        /*
         * This constructor reads through a file given to PlayerSalaries
         * and puts that inforamtion (for this assignment the baseball players
         * information) into an array titled salaries. It takes the number of records
         * from the first line of the csv and makes that its amount to make the array of.
         */
        
        File reviewFile = new File(filename);
        Scanner fileScan = new Scanner(reviewFile);
    
        int recordNum = fileScan.nextInt();
        salaries = new PlayerSalary[recordNum];
        fileScan.nextLine();
        fileScan.nextLine();
        
        for (int lineNum = 0; lineNum < recordNum; lineNum++)
        {
            String line = fileScan.nextLine();
            String[] splitArray = line.split(",");
            int playYear = Integer.parseInt(splitArray[0]);
            int playSalary = Integer.parseInt(splitArray[4]);
            salaries[lineNum] = new PlayerSalary(playYear, splitArray[1], splitArray[2], splitArray[3], playSalary);
        }
        
        fileScan.close();
    }
    
    
    public int averageSalaryInYear(int year) throws ArithmeticException, InputMismatchException
    {
        /*
         * This method calculates the average of a particular year's players
         * salaries and counts how many players for that year alongside
         * adding those salaries together for that year to calculate the average
         * for the year.
         */
        long total = 0;
        long count = 0;
        
        for (int i = 0; i < salaries.length; i++)
        {
            if (year == salaries[i].getYearID())
            {
                total += salaries[i].getSalary();
                count += 1;
            }
        }
        
        long avgTotal = total / count;
        return (int)avgTotal;
    }
    
    
    public PlayerSalary findPlayerInYear(String player, int year) throws InputMismatchException
    {
        /*
         * This method looks for a particular player within a specificed year
         * and returns the information for that player.
         */
        
        int position = -1;
        for (int i = 0; i < salaries.length; i++)
        {
                if (player.equals(salaries[i].getPlayerID()) && year == salaries[i].getYearID())
                {
                    position = i;
                }
        }
        
        if (position == -1) {
            return null;
        }
        else {
            return salaries[position];
        }
    }
    
    
    public PlayerSalary highestSalaryInYear(int year) throws InputMismatchException
    {
        /*
         * This method looks for the highest salary within a specificed
         * year and then returns the baseball players information for the
         * highest salary for that year.
         */
        int maxSalary = 0;
        int maxIndex = -1;
        
        for (int i = 0; i < salaries.length; i++)
        {
                if (year == salaries[i].getYearID() && salaries[i].getSalary() > maxSalary)
                {
                    maxSalary = salaries[i].getSalary();
                    maxIndex = i;
                }
        }
        if (maxIndex == -1) {
            return null;
        }
        else {
            return salaries[maxIndex];
        }
    }
    
    
    public PlayerSalary lowestSalaryInYear(int year) throws NullPointerException
    {
        /*
         * This method looks for the lowest salary within a specificed
         * year and then returns the baseball player's information for the
         * lowest salary for that year.
         */
        int minSalary = 999999999;
        int minIndex = -1;
        
        for (int i = 0; i < salaries.length; i++)
        {
            if (year == salaries[i].getYearID() && salaries[i].getSalary() < minSalary)
            {
                minSalary = salaries[i].getSalary();
                minIndex = i;
            }
            
        }
        
        if (minIndex == -1) {
            return null;
        }
        else {
            return salaries[minIndex];
        }
    }
    
    
    public PlayerSalary highestSalaryInTeamInYear(String team, int year) throws InputMismatchException
    {
        /*
         * This method looks for the highest salary within a specificed
         * year and team, and then returns the baseball player's information for the
         * highest salary for that year and team.
         */
        int maxInTeamYear = 0;
        int maxIndex = -1;
        
        
        for (int i = 0; i < salaries.length; i++)
        {
            if (team.equals(salaries[i].getTeamID()) && year == salaries[i].getYearID() &&
                salaries[i].getSalary() > maxInTeamYear)
            {
                maxInTeamYear = salaries[i].getSalary();
                maxIndex = i;
            }
        }
        
        if (maxIndex == -1) {
            return null;
        }
        else {
            return salaries[maxIndex];
        }
    }
    
        // FIXME issue with making exception work around return statement

    public PlayerSalary lowestSalaryInTeamInYear(String team, int year) throws InputMismatchException
    {
        /*
         * This method looks for the lowest salary within a specificed
         * year and team, and then returns the baseball player's information for the
         * lowest salary for that year and team.
         */
        int minInTeamYear = 999999999;
        int minIndex = -1;
        
        for (int i = 0; i < salaries.length; i++)
        {
            if ((team.equals(salaries[i].getTeamID())) && (year == salaries[i].getYearID()) &&
                (salaries[i].getSalary() < minInTeamYear))
            {
                minInTeamYear = salaries[i].getSalary();
                minIndex = i;
            }
        }
        
        if (minIndex == -1) {
            return null;
        }
        else {
            return salaries[minIndex];
        }
    }
    

    public PlayerSalary highestSalaryInLeagueInYear(String league, int year) throws InputMismatchException
    {
        /*
         * This method looks for the highest salary within a specificed
         * year and league, and then returns the baseball player's information for the
         * highest salary for that year and league.
         */
        int highestInLeagueYear = 0;
        int maxIndex = -1;
        
        for (int i = 0; i < salaries.length; i++)
        {
            if ((league.equals(salaries[i].getLeagueID())) && (year == salaries[i].getYearID()) &&
                (salaries[i].getSalary() > highestInLeagueYear))
            {
                    highestInLeagueYear = salaries[i].getSalary();
                    maxIndex = i;
            }
        }
        
        if (maxIndex == -1) {
            return null;
        }
        else {
        return salaries[maxIndex];
        }
    }


    public PlayerSalary lowestSalaryInLeagueInYear(String league, int year) throws InputMismatchException
    {
        /*
         * This method looks for the lowest salary within a specificed
         * year and league, and then returns the baseball players information for the
         * lowest salary for that year and league.
         */
        int lowestInLeagueYear = 999999999;
        int minIndex = -1;
        
        for (int i = 0; i < salaries.length; i++)
        {
            if ((league.equals(salaries[i].getLeagueID())) && (year == salaries[i].getYearID()) &&
                (salaries[i].getSalary() < lowestInLeagueYear))
                {
                    lowestInLeagueYear = salaries[i].getSalary();
                    minIndex = i;
                }
        }
        
        if (minIndex == -1) {
            return null;
        }
        else {
            return salaries[minIndex];
        }
    }
    
    public PlayerSalary comparePlayersInYear(String player1, String player2, int year) throws ArrayIndexOutOfBoundsException, 
        InputMismatchException
    {
        /*
         * This method compares the salary from two specificed players for a certain
         * year and sees who has the highest from the two and returns the information
         * for the player with the highest salary.
         */
        int playerOneSalary;
        int playerTwoSalary;
        int playerOneIndex = -1;
        int playerTwoIndex = -1;
        
        for (int i = 0; i < salaries.length; i++)
        {
            if (year == salaries[i].getYearID() && player1.equals(salaries[i].getPlayerID()))
            {
                playerOneSalary = salaries[i].getSalary();
                playerOneIndex = i;
            }
        }
        
        for (int j = 0; j < salaries.length; j++)
        {
            if (year == salaries[j].getYearID() && player2.equals(salaries[j].getPlayerID()))
            {
                playerTwoSalary = salaries[j].getSalary();
                playerTwoIndex = j;
            }
        }
        
        if (salaries[playerOneIndex].getSalary() > salaries[playerTwoIndex].getSalary())
        {
            return salaries[playerOneIndex];
        }
        else if (salaries[playerOneIndex].getSalary() < salaries[playerTwoIndex].getSalary())
        {
            return salaries[playerTwoIndex];
        }
        else {
            return null;
        }
    }
}

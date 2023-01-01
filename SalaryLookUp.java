import java.util.*;
import java.io.*;
import java.util.*;

/**
 * CSCI 221, Summer 2022, Programming HW4
 * Name: <Jalena Austin>
 * 
 * <SalaryLookUp>.java
 * 
 * This main class is used to be the main user interaction for the program as a whole.
 * It takes an integer by the user's chosing to be chosen for which option they want
 * to then proceed by going through the file given and then output the necessary return.
 * It goes through to return by being dependent on the user's input to then go through exceptions
 * to determine if such input is acceptable by the standard of the documents array boundaries.
 * 
 * Certification of Authentication:
 * I certify that this assignment is entirely my own work.
 */
public class SalaryLookUp
{   
    public static void main(String[] args) throws FileNotFoundException
     {
         /*
          * This method is the main to which allows for user interaction
          * to input a choice of their choosing to select from the file to run through
          * then to go through the PlayerSalaries class to perform such choice and inputted
          * information and return information mainly in format of PlayerSalary classes toString()
          * format. Alongside these functions, the method goes through the user's inputs
          * to run exceptions through each and test these to see if they are capable of running
          * the program still with such inputs.
          */
        Scanner yearInput = new Scanner(System.in);
        Scanner playerInput = new Scanner(System.in);
        Scanner teamInput = new Scanner(System.in);
        Scanner leagueInput = new Scanner(System.in);
        
        int choice = 0;
        Scanner scnr = new Scanner(System.in);
        
        String userPlayer;
        String userPlayer2;
        String userTeam;
        String userLeague;
        
        PlayerSalaries fileRun = new PlayerSalaries("Salaries.csv");    
         do {
             System.out.println();
             System.out.println("Please enter your choice: ");
             System.out.println("1: See the average salary in a specific year");
             System.out.println("2: See a specific player's salary in a specific year");
             System.out.println("3: See the highest salary in a specific year");
             System.out.println("4: See the lowest salary in a specific year");
             System.out.println("5: See the highest salary on a specific team in a specific year");
             System.out.println("6: See the lowest salary on a specific team in a specific year");
             System.out.println("7: See the highest salary in the league in a specific year");
             System.out.println("8: See the lowest salary in the league in a specific year");
             System.out.println("9: Compare salaries of two specific players in a specific year");
             System.out.println("10: Quit.");
             System.out.println();
             
             try {
             choice = scnr.nextInt();
             System.out.println();
             switch (choice) {
                         case 1:
                             try {
                                 System.out.println("Enter a year: ");
                                 int userYear = yearInput.nextInt();
                                 
                                 System.out.println();
                                 System.out.println("The average player salary for " + userYear + 
                                     " is: $" + fileRun.averageSalaryInYear(userYear));
                                }
                             catch (InputMismatchException excpt) {
                                 System.out.println(excpt + ": not a year");
                             }
                             catch (ArithmeticException msg) {
                                 System.out.println(msg + ": invalid year input years must be from (1985 to 2016)");
                             }
                             break;
                        
                         case 2:
                            try {
                                 System.out.println("Enter a player name: ");
                                 userPlayer = playerInput.next();
                                 
                                 System.out.println("Enter a specific year: ");
                                 int userYear = yearInput.nextInt();
                                 
                                 if (fileRun.findPlayerInYear(userPlayer, userYear) == null) {
                                     System.out.println("Invalid year and/or player name");
                                 }
                                 else {
                                 System.out.println();
                                 System.out.println(fileRun.findPlayerInYear(userPlayer, userYear));
                                }
                               }
                            catch (InputMismatchException excpt) {
                                System.out.println(excpt + ": invalid name and/or year (year must be between 1985 and 2016)"); 
                            }
                             
                            break;
                             
                         case 3:
                             try {
                                 System.out.println("Enter a year: ");
                                 int userYear = yearInput.nextInt();
                                 
                                 if (fileRun.highestSalaryInYear(userYear) == null) {
                                     System.out.println("Invalid year");
                                 }
                                 else {
                                     System.out.println("The information for the player with the highest salary in " + userYear + " is: ");
                                     System.out.println();
                                     System.out.println(fileRun.highestSalaryInYear(userYear));
                                }
                                
                            }
                            catch (InputMismatchException excpt) {
                                System.out.println(excpt + ": invalid name and/or year (year must be between 1985 and 2016)");
                            }
                            
                            break;
                             
                         case 4:
                             try {
                                 System.out.println("Enter a year: ");
                                 int userYear = yearInput.nextInt();
                                 
                                 if (fileRun.lowestSalaryInYear(userYear) == null) {
                                     System.out.println("Invalid year");
                                 }
                                 else {
                                 System.out.println("The information for the player with the lowest salary in " + userYear + " is:");
                                 System.out.println();
                                 System.out.println(fileRun.lowestSalaryInYear(userYear));
                                }
                            }
                            catch (InputMismatchException excpt) {
                                System.out.println(excpt + ": invalid year (year must be between 1985 and 2016)");
                            }
                            
                             break;
                             
                         case 5:
                             try {
                                 System.out.println("Enter a team: ");
                                 userTeam = teamInput.next();
                                 
                                 System.out.println("Enter a year: ");
                                 int userYear = yearInput.nextInt();
                                 
                                 if (fileRun.highestSalaryInTeamInYear(userTeam, userYear) == null) {
                                     System.out.println("Invalid team/year");
                                 }
                                 else {
                                 System.out.println("The information for the player with the highest salary on team " + 
                                     userTeam + " in " + userYear + " is:");
                                 System.out.println();
                                 System.out.println(fileRun.highestSalaryInTeamInYear(userTeam, userYear));
                                }
                            }
                            catch (InputMismatchException excpt) {
                                System.out.println(excpt + ": invalid team name and/or year (year must be between 1985 and 2016)");
                            }
                            
                             break;
                             
                         case 6:
                             try {
                                 System.out.println("Enter a team: ");
                                 userTeam = teamInput.next();
                                 
                                 System.out.println("Enter a year: ");
                                 int userYear = yearInput.nextInt();
                                 
                                 if (fileRun.lowestSalaryInTeamInYear(userTeam, userYear) == null) {
                                     System.out.println("Invalid team/year");
                                 }
                                 else {
                                     System.out.println("The information for the player with the lowest salary on team " + 
                                         userTeam + " in " + userYear + " is:");
                                     System.out.println();
                                     System.out.println(fileRun.lowestSalaryInTeamInYear(userTeam, userYear));
                                 }
                                }
                             catch (InputMismatchException excpt) {
                                 System.out.println(excpt + ": invalid team name and/or year (year must be between 1985 and 2016)");
                             }
    
                             break;
                             
                         case 7:
                             try {
                                 System.out.println("Enter a league: ");
                                 userLeague = leagueInput.next();
                                 
                                 System.out.println("Enter a year: ");
                                 int userYear = yearInput.nextInt();
                                 
                                 if (fileRun.highestSalaryInLeagueInYear(userLeague, userYear) == null) {
                                     System.out.println("Invalid league/year");
                                 }
                                 else {
                                 System.out.println("The information for the player with the highest salary in league " + 
                                     userLeague + " in " + userYear + " is:");
                                 System.out.println();
                                 System.out.println(fileRun.highestSalaryInLeagueInYear(userLeague, userYear));
                                }
                                }
                             catch (InputMismatchException excpt) {
                                 System.out.println(excpt + ": invalid league name and/or year (year must be between 1985 and 2016)");
                             }
                             break;
                             
                         case 8:
                             try {
                                 System.out.println("Enter a league: ");
                                 userLeague = leagueInput.next();
                                 
                                 System.out.println("Enter a year: ");
                                 int userYear = yearInput.nextInt();
                                 
                                 if (fileRun.lowestSalaryInLeagueInYear(userLeague, userYear) == null) {
                                    System.out.println("Invalid league/year");
                                    }
                                 else {
                                 System.out.println("The information for the player with the lowest salary in league " + 
                                     userLeague + " in " + userYear + " is:");
                                 System.out.println();
                                 System.out.println(fileRun.lowestSalaryInLeagueInYear(userLeague, userYear));
                                }
                            }
                            catch (InputMismatchException excpt) {
                                System.out.println(excpt + ": invalid name and/or year (year must be between 1985 and 2016)");
                            }
                             break;
                             
                         case 9:
                             try {
                                 System.out.println("Enter a player 1's name: ");
                                 userPlayer = playerInput.next();
                                 
                                 System.out.println("Enter player 2's name: ");
                                 userPlayer2 = playerInput.next();
                                 
                                 System.out.println("Enter a year: ");
                                 int userYear = yearInput.nextInt();
                                 
                                 if (fileRun.comparePlayersInYear(userPlayer, userPlayer2, userYear) == null) {
                                     System.out.println("Invalid player 1 / player 2 / year");
                                 }
                                 else {
                                 System.out.println("Between " + userPlayer + " and " + userPlayer2 + " in " +
                                     userYear + " the information for player with the highest salary is: ");
                                 System.out.println();
                                 System.out.println(fileRun.comparePlayersInYear(userPlayer, userPlayer2, userYear));
                                }
                                }
                             catch (InputMismatchException excpt) {
                                 System.out.println(excpt + ": invalid name and/or year (year must be between 1985 and 2016)");
                             }
                             catch (ArrayIndexOutOfBoundsException arraymsg) {
                                 System.out.println(arraymsg + ": invalid year");
                             }
                             break;
                             
                         case 10:
                             System.out.println("Goodbye");
                             break;
                             
                         default:
                             System.out.println("You must a integer between 1 and 10");
                         }
                    }
                    catch (InputMismatchException entermsg) {
                        System.out.println(entermsg + ": Enter an integer between 1 and 10");
                        scnr.next();
                    }
        } while (choice != 10);
     }
}

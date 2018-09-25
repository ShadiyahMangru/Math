import java.util.*;	

public class PlayerStats implements Comparable<PlayerStats>{
	
/**
* The PlayerStats class calculates a player's 2018 playoffs shooting percentage (to varying degrees of precision),
* and numerically sorts 2018 playoffs roster by shooting percentage (in double precision).
*
* @author  Shadiyah Mangru
* @version 1.0
* @since   September 2018
*/	
	
	private String firstName;
	private String lastName;
	private int goals;
	private int shots;
	private float shootingPercentageFloat;
	private double shootingPercentageDouble;
	private float shootingPercentageCast;
	private double shootingPercentagePromote;

	/**
	* Comprehensive constructor with four parameters that initialize first name, 
	* last name, goals, shots, and shooting percentage float/double/cast/promote player variables. 
	* @param fn player's first name
	* @param ln player's last name
	* @param jn player's goals
	* @param p player's shots
	*/
	public PlayerStats(String fn, String ln, int g, int sh){
		firstName = fn;
		lastName = ln;
		goals = g;
		shots = sh;
		setShootingPercentageFloat(g, sh);
		setShootingPercentageDouble(g, sh);
		setShootingPercentageCast(g, sh);
		setShootingPercentagePromote(g, sh);
	}
	
	/**
	* a method that defines how to sort Players numerically by shooting percentage
	* @param PlayerStats the player to which we are comparing
	*/
	@Override
    	public int compareTo(PlayerStats other) {
    		if (this.getShootingPercentageDouble() < other.getShootingPercentageDouble()) {
    			return -1;
    		}
    		if (this.getShootingPercentageDouble() == other.getShootingPercentageDouble()) {
    			return 0;
    		}
    		return 1;
    	}
	
    	/**
	* a method that returns the entire roster sorted numerically by shooting percentage
	* @return ArrayList roster numerically sorted by shooting percentage
	*/
	public static ArrayList<PlayerStats> sortedShootingPercentage(ArrayList<PlayerStats> unsortedArrayList){
		ArrayList<PlayerStats> sortPlayers = new ArrayList<PlayerStats>();
		for(int i=0; i<unsortedArrayList.size(); i++){
			sortPlayers.add(unsortedArrayList.get(i));	
		}
		Collections.sort(sortPlayers);
		return sortPlayers;
	}
	
	public static void main(String[] args){
		PlayerStats kuznetsov = new PlayerStats("Evgeny", "Kuznetsov", 12, 89);
		PlayerStats ovechkin = new PlayerStats("Alex", "Ovechkin", 15, 99);
		PlayerStats backstrom = new PlayerStats("Nicklas", "Backstrom", 5, 36);
		PlayerStats oshie = new PlayerStats("T.J.", "Oshie", 8, 55);
		PlayerStats carlson = new PlayerStats("John", "Carlson", 5, 80);
		PlayerStats eller = new PlayerStats("Lars", "Eller", 7, 52);
		
		System.out.println(kuznetsov.statsFormat(kuznetsov));
		System.out.println(ovechkin.statsFormat(ovechkin));
		System.out.println(backstrom.statsFormat(backstrom));
		System.out.println(oshie.statsFormat(oshie));
		System.out.println(carlson.statsFormat(carlson));
		System.out.println(eller.statsFormat(eller));
		
		ArrayList<PlayerStats> teamStats = new ArrayList<PlayerStats>();
		teamStats.add(kuznetsov);
		teamStats.add(ovechkin);
		teamStats.add(backstrom);
		teamStats.add(oshie);
		teamStats.add(carlson);
		teamStats.add(eller);
		
		for(int i=0; i<teamStats.size(); i++){
			System.out.println(teamStats.get(i).getLastName() + "'s shooting percentage: " + teamStats.get(i).getShootingPercentageDouble());
		}
		
		System.out.println("\nPLAYERS' SHOOTING PERCENTAGE SORTED NUMERICALLY: ");
		ArrayList<PlayerStats> sortedTeamStats = sortedShootingPercentage(teamStats);
		for(int i=0; i<sortedTeamStats.size(); i++){
			System.out.println(sortedTeamStats.get(i).getLastName() + "'s shooting percentage: " + sortedTeamStats.get(i).getShootingPercentageDouble());
		}
		
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public int getGoals(){
		return goals;
	}
	
	public int getShots(){
		return shots;	
	}
	
	public float getShootingPercentageFloat(){
		return shootingPercentageFloat;	
	}
	
	public double getShootingPercentageDouble(){
		return shootingPercentageDouble;	
	}
	
	public float getShootingPercentageCast(){
		return shootingPercentageCast;	
	}
	
	public double getShootingPercentagePromote(){
		return shootingPercentagePromote;	
	}
	
	
	
	public void setFirstName(String fName){
		firstName = fName;
	}
	
	public void setLastName(String lName){
		lastName = lName;
	}

	public void setGoals(int g){
		goals = g;
	}
	
	public void setShots(int s){
		shots = s;	
	}
	
	public void setShootingPercentageFloat(int g, int s){
		if(s==0){
			shootingPercentageFloat = 0.000f;	
		}
		else{
			shootingPercentageFloat = (100.00f*g/s);
		}
		
	}
	
	public void setShootingPercentageDouble(int g, int s){
		if(s==0){
			shootingPercentageDouble = 0.000;	
		}
		else{
			shootingPercentageDouble = (100.00*g/s);
		}
		
	}
	
	public void setShootingPercentageCast(int g, int s){
		shootingPercentageCast = (float)shootingPercentageDouble;
	}
	
	public void setShootingPercentagePromote(int g, int s){
		shootingPercentagePromote = shootingPercentageFloat;
	}
	
	
	public String statsFormat(PlayerStats pl){
		return pl.firstName + " " + pl.lastName + " took " + pl.shots + " shots, scored " + pl.goals + " goals, and had a \n" + 
		pl.getShootingPercentageFloat() + " shooting percentage (float) \n" + 
		pl.getShootingPercentageDouble() + " shooting percentage (double)\n" + 
		pl.getShootingPercentageCast() + " shooting percentage (float value by cast) \n" + 
		pl.getShootingPercentagePromote() + " shooting percentage (double value by numeric promotion) \n" + 
		"during the 2018 playoffs.\n";
	}
}
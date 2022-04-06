package mru.tsc.model;

/**
 * this class sets up the board game toy
 * @author Jonah
 *
 */
public class BoardGames extends Toys {

	//declaring the needed parameter
	String designers;
	String players;
	    
	
	/**
	 * this constructor creates the toy of type figure
	 * @param s is the serial number
	 * @param n is the name of the toy
	 * @param b is the brand of the toy
	 * @param p is the price of the toy
	 * @param aC is the available count of the toy
	 * @param aA is the age appropriate number for the toy
	 * @param material of the animal
	 * @param size of the animal
	 */
	public BoardGames(String s, String n, String b, double p, int aC, int aA, String noOfPlayers, String designer) {
		super(s, n, b, p, aC, aA);
		players = noOfPlayers;
		designers = designer;
	}

	// Getters for designer
		public String getDesigner() {
			return designers;
		}

		/**
		 * setter for designer
		 * @param designers
		 */
		public void setDesigners(String designers) {
			this.designers = designers;
		}
	
	@Override
	/**
	 * Prints the info in the following way
	 */
	public String toString() {
		return "BoardGame = SN:" + serialNo + ", Name:" + name + ", Brand:" + brand + ", Price:" + price + ", Available:"
				+ avaliableCount + ", Age Group:" + ageAppropriate + ", players:" + players + ", designers:"
				+ designers;
    }

	  
		@Override
		/**
		 * Formatting for boardgame
		 */
		public String Format() {
			return serialNo + ";" + name + ";" + brand + ";" + price + ";" + avaliableCount + ";" + ageAppropriate + ";" + players + ";" + designers;
		}
}
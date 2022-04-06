package mru.tsc.model;

public class Puzzles extends Toys {
	 
	String puzzleType;
	
    
    /**
     * this constructor creates the toy of type figure
     * Gives user option on what type of puzzle they want which is
     * either Mechanical, Trivia, Cryptic, Logic, or Riddle
     * @param sn - serial number of toy 
     * @param toyName - name of toy
     * @param toyBrand - brand of toy
     * @param price - price of toy
     * @param toyAmount - Amount of toys available
     * @param ageGroup - tells what age group is for toy
     * @param puzzleType - tells user what type of puzzle it is
     */
    public Puzzles(String s, String n, String b, double p, int aC, int aA, String puzzleT) {
        super(s, n, b, p, aC, aA);
        puzzleType = puzzleT;
    	
    }

    @Override
    /**
     * Overriding toString method that returns and tells user puzzle and puzzle type 
     */
    public String toString() {
    	return "Puzzle = SN:" + serialNo + ", Name:" + name + ", Brand:" + brand + ", Price:" + price + ", Available:"
				+ avaliableCount + ", Age Group:" + ageAppropriate + ", puzzleType:" + puzzleType;
    }
    
    /**
	 * Formatting for Puzzle
	 */
	@Override
	public String Format() {
		return String.format("%s;%c", super.Format(), this.puzzleType.toString().charAt(0));
	}
}
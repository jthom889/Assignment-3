package mru.tsc.model;

public class Figures extends Toys {

	char classification;
    
    /**
	 * this constructor creates the toy of type figure
	 * @param s is the serial number
	 * @param n is the name of the toy
	 * @param b is the brand of the toy
	 * @param p is the price of the toy
	 * @param aC is the available count of the toy
	 * @param aA is the age appropriate number for the toy
	 * @param classification of the figure
	 */
    public Figures(String s, String n, String b, double p, int aC, int aA, String Class)  {
    
        super(s, n, b, p, aC, aA);
        classification = Class.charAt(0);
    }
    

    /**
     * getter for classification
     * @return classification
     */
    public char getClassification() {
		return classification;
	}
    
    /**
     * setter for classification
     * @param classification
     */
	public void setClassification(char classification) {
		this.classification = classification;
	}

    @Override
    /**
     * Overriding toString method that returns to user Figure and classification of toy
     */
	public String toString() {
    	return "Figure = SN:" + serialNo + ", Name:" + name + ", Brand:" + brand + ", Price:" + price + ", Available:"
				+ avaliableCount + ", Age Group:" + ageAppropriate + ", classification:" + classification;
	}
    
    /**
	 * Formatting for Figure
	 */
	@Override
	public String Format() {
		return String.format("%s;%c", super.Format(), classification);
	}
}
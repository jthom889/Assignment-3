package mru.tsc.model;

public class Animals extends Toys {
	//variables declared
	private String material;
	char size;
	
	
	
    /**
     * this constructor creates the toy of Animal
     * Gives user option what size animal they want
     * @param s - serial number of toy 
     * @param n - name of toy
     * @param b - brand of toy
     * @param p - price of toy
     * @param aC - Amount of toys available
     * @param aA - tells what age group is for toy
     * @param material - material of the animal
     * @param sz - size of the animal
     */
    public Animals(String s, String n, String b, double p, int aC, int aA, String material, String sz) {
        super(s, n, b, p, aC, aA);
        this.material = material;
	     size = sz.charAt(0);
		
    }
    /**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	/**
	 * gets size of toy
	 * @return size
	 */
	public char getSize() {
		return size;
	}

	/**
	 * setter for size
	 * @param size
	 */
	public void setSize(char size) {
		this.size = size;
	}
    
    @Override
    /**
     * method that returns and tells user animal, material, and size
     */
    public String toString() {
        return "Category: Animal, " + super.toString() + ", Material: " + this.material + ", Size: " + this.size;
    }
    
    /**
	 * Formatting for animal
	 */
    @Override
	public String Format() {
		return String.format("%s;%s;%s", super.Format(), this.material, size);
	}
}
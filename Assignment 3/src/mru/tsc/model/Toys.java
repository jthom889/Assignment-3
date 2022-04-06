package mru.tsc.model;

/**
 * this class is the superclass for all toys
 * @author Jonah Thompson
 *
 */
public abstract class Toys {

	//parameters of the toys object
	 String serialNo;
	 String name;
	 String brand;
	 double price;
	 int avaliableCount;
	 int ageAppropriate;
	 
	
	/**
	 * the constructor for the toys class
	 * @param serial number of the toy
	 * @param name of the toy
	 * @param brand of the toy
	 * @param price of the toy
	 * @param avaliableCount is the number of toys available
	 * @param ageAppropriate is the minimum age the toy should be played with
	 */
	public Toys(String serialNo, String name, String brand, double price, int avaliableCount, int ageAppropriate) {
		 this.serialNo = serialNo;
	     this.name = name;
	     this.brand = brand;
	     this.price = price;
	     this.avaliableCount = avaliableCount;
	     this.ageAppropriate = ageAppropriate;
	}

	/**
	 * getter for serial number
	 * @return
	 */
	public String getSerialNo() {
		return serialNo;
	}
	
	public void setSerialNo(String sn) {
		serialNo = sn;
	}

	/**
	 * getter for the name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String toyName) {
		this.name = toyName;
	}

	/**
	 * getter for the brand
	 * @return
	 */
	public String getBrand() {
		return brand;
	}
	
	public void setBrand( String toyBrand) {
		this.brand = toyBrand;
	}

	/**
	 * getter for the price
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * getter for toy count
	 * @return
	 */
	public int getAvaliableCount() {
		return avaliableCount;
	}
	
	public void setAvaliableCount(int count) {
		this.avaliableCount = count;
	}
	
	/**
	 * @param decrement availableCount by 1
	 */
	public void decrementStock() {
		this.avaliableCount--;
	}

	/**
	 * getter for the age the toy should be sold to
	 * @return
	 */
	public int getAgeAppropriate() {
		return ageAppropriate;
	}
	
	public void setAgeAppropriate(int ageGroup) {
		this.ageAppropriate = ageGroup;
	}
	
	@Override
	/**
	 * to string method that returns a formatted return for the file
	 * @return formatted output
	 */
	public String toString() {
        return "Serial Number: " + serialNo + ", Name: " + name + ", Brand: " + brand + ", Price: " + price
                + ", Available Count: " + avaliableCount + ", Age Appropriate: " + ageAppropriate;
    }

	/**
	 * Formatting for Toys
	 * @return toys to user
	 */
	public String Format() {
		return String.format("%d;%s;%s;%f;%d;%s", this.serialNo, this.name, this.brand, this.price, this.avaliableCount, this.ageAppropriate);
	}
}
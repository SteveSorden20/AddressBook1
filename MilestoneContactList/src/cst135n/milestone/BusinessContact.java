package cst135n.milestone;

import java.util.ArrayList;

/*This class is a child class of Base contact which means it implements the same methods used in the BaseContact class,
 * however, it has unique attributes that will be implemented with this class to create a specific contact for businesses.
 * This class should include hours of operation for the business as well as a website URL.
 */

public class BusinessContact extends BaseContact{

	private String hours;
	private String URL;

	//Constructor
	public BusinessContact(int contactNumber, String contactName, String contactPhone, ArrayList<Photo> photos,
			Location location, String hours, String uRL) {
		super(contactNumber, contactName, contactPhone, photos, location);
		this.hours = hours;
		URL = uRL;
	}

	//Getters/Setters
	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	@Override
	public String toString() {
		return "BusinessContact [" + super.toString() + "hours=" + hours + ", URL=" + URL + "\n]";
	}
	
	
	
	
}

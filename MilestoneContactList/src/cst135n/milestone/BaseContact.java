package cst135n.milestone;

import java.util.ArrayList;

/*This is the parent class for all contacts that are created within the program. It sets the general rules of what all contacts 
 * should automatically include regardless of whether it is a personal or business contact.
 * The methods that should be included in this class are ID number, Contact name, Contact phone, photos, and location. 
 */

public class BaseContact {

	private int ContactNumber;
	private String ContactName;
	private String ContactPhone;
	//Has a Relationship
	private ArrayList<Photo> photos = new ArrayList<>();
	private Location location;
	
	//Constructor
	public BaseContact(int contactNumber, String contactName, String contactPhone, ArrayList<Photo> photos,
			Location location) {
		super();
		ContactNumber = contactNumber;
		ContactName = contactName;
		ContactPhone = contactPhone;
		this.photos = photos;
	}
	
	public BaseContact(int contactNumber, String contactName) {
		super();
		ContactNumber = contactNumber;
		ContactName = contactName;
	}

	//Getters/Setters
	public int getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(int contactNumber) {
		ContactNumber = contactNumber;
	}

	public String getContactName() {
		return ContactName;
	}

	public void setContactName(String contactName) {
		ContactName = contactName;
	}

	public String getContactPhone() {
		return ContactPhone;
	}

	public void setContactPhone(String contactPhone) {
		ContactPhone = contactPhone;
	}

	public ArrayList<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(ArrayList<Photo> photos) {
		this.photos = photos;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	//ToString
	@Override
	public String toString() {
		return "BaseContact [ContactNumber=" + ContactNumber + ", ContactName=" + ContactName + ", ContactPhone="
				+ ContactPhone + ", photos=" + photos + ", location=" + location + "]";
	}
	
	
	
}

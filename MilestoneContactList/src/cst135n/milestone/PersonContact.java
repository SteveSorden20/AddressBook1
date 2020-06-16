package cst135n.milestone;

import java.time.LocalDate;
import java.util.ArrayList;

/*This class is a child class of Base contact which means it implements the same methods used in the BaseContact class,
 * however, it has unique attributes that will be implemented with this class to create a specific contact for personal contacts.
 * This class should include the persons date of Birth, a description, and a list of relatives/ contacts.
 */

public class PersonContact extends BaseContact {

	private LocalDate dateOfBirth;
	private String description;
	private ArrayList<BaseContact> Relatives = new ArrayList<>();

	// Constructor
	public PersonContact(int contactNumber, String contactName, String contactPhone, ArrayList<Photo> photos,
			Location location, LocalDate dateOfBirth, String description, ArrayList<BaseContact> relatives) {
		super(contactNumber, contactName, contactPhone, photos, location);
		this.dateOfBirth = dateOfBirth;
		this.description = description;
		Relatives = relatives;
	}

	// Getters/Setters
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<BaseContact> getRelatives() {
		return Relatives;
	}

	public void setRelatives(ArrayList<BaseContact> relatives) {
		Relatives = relatives;
	}

	// ToString
	@Override
	public String toString() {
		return "PersonContact [" + super.toString() + "dateOfBirth=" + dateOfBirth + ", description=" + description
				+ ", Relatives=" + Relatives + "\n]";
	}

}

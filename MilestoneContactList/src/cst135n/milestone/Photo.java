package cst135n.milestone;

import java.time.LocalDate;

/*The photo class is a class that allows a user to input a photo or multiple photos that help to visually describe a contact 
 * either personal or business. The phot class should include methods of ID, Filename, Date of Photo, and Description.
 * 
 */

public class Photo {

	private int Id;
	private String filename;
	private LocalDate dateOfPhoto;
	private String description;
	
	//Constructor
	public Photo(int id, String filename, LocalDate dateOfPhoto, String description) {
		super();
		Id = id;
		this.filename = filename;
		this.dateOfPhoto = dateOfPhoto;
		this.description = description;
	}

	//Getters/Setters
	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}



	public String getFilename() {
		return filename;
	}



	public void setFilename(String filename) {
		this.filename = filename;
	}



	public LocalDate getDateOfPhoto() {
		return dateOfPhoto;
	}



	public void setDateOfPhoto(LocalDate dateOfPhoto) {
		this.dateOfPhoto = dateOfPhoto;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}

	//ToString
	@Override
	public String toString() {
		return "Photo [Id=" + Id + ", filename=" + filename + ", dateOfPhoto=" + dateOfPhoto + ", description="
				+ description + "]";
	}

	public static void add(Photo photo) {
		// TODO Auto-generated method stub
		
	}
	
	
}

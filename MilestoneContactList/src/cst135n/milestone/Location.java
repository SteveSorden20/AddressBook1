package cst135n.milestone;

/*The Location class includes information about a contacts whereabouts.
 * This includes information such as ID, Street name, City name, and State name.
 */

public class Location {

	
	private String street;
	private String city;
	private String state;
	
	//Constructor
	public Location(String street, String city, String state) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
	}

	//Getters/Setters
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	//ToString
	@Override
	public String toString() {
		return "Location [street=" + street + ", city=" + city + ", state=" + state + "]";
	}
	
	
	
}

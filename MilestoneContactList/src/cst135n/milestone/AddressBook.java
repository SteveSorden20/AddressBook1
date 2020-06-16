package cst135n.milestone;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * The address book class is the menu class that will direct the user to specific operations based on the action they are looking
 * for the program to complete. The methods in this class include add a contact, remove a contact, display one contact, sort through
 * all contacts, and search all contacts.
 */

public class AddressBook {

	// has a
	ArrayList<BaseContact> Contact = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// counts and numbers all contacts
	int countID = 0;

	// methods
	public void displayMenu() {
		// creates userinterface for menu
		Menu: do {
			System.out.println("++++++++++++++++++++++++++++++");
			System.out.println("+++    ADDRESS BOOK MENU   +++");
			System.out.println("++++++++++++++++++++++++++++++");
			System.out.println("1] ADD CONTACT");
			System.out.println("2] REMOVE CONTACT");
			System.out.println("3] SORT CONTACTS");
			System.out.println("4] SEARCH CONTACTS");
			System.out.println("5] DISPLAY ONE CONTACT");
			System.out.println("6] DISPLAY ALL CONTACTS");
			System.out.println("7] UPDATE CONTACT");
			System.out.println("0] EXIT");
			System.out.println("Please Enter your choice:");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				addContact();
				break;
			case 2:
				remove();
				break;
			case 3:
				sort();
				break;
			case 4:
				search();
				break;
			case 5:
				displayOne();
				break;
			case 6:
				displayAll();
				break;
			case 7:
				update();
				break;
			default:
				System.out.println("Exiting System");
				break Menu;
			}
		} while (true);

	}

	private void addContact() {

		// counts and numbers all photos
		int countPhotoID = 0;
		// checks if user wants to enter more than one photo
		boolean morephotos = true;
		// checks if user wants to enter more than one relative
		boolean morerelatives = true;

		// starts basic contact info
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("+++ ADDING CONTACT +++");
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println(" Is contact Business or Personal? (type B or P)");
		String contactChoice = sc.nextLine().toUpperCase();
		if (contactChoice.equals("P")) {
			System.out.println(" Contact ID: " + ++countID);
			System.out.println(" Contact Name: ");
			String contactName = sc.nextLine().toUpperCase();
			System.out.println(" Contact Phone: ");
			String contactPhone = sc.nextLine();

			ArrayList<Photo> photos = new ArrayList<>();

			// enter a photo action
			do {
				System.out.println(" Contact Photo ");
				System.out.println(" Photo Id: " + ++countPhotoID);
				System.out.println(" Photo filename: ");
				String filename = sc.nextLine();
				System.out.println(" Photo date: ");
				String date = sc.nextLine();
				LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
				System.out.println(" Photo description: ");
				String photodescription = sc.nextLine();
				photos.add(new Photo(countPhotoID, filename, localDate, photodescription));
				System.out.println("Would you like to enter another photo? (Y/N)");
				String ans = sc.nextLine().toUpperCase();
				if (ans.equals("N")) {
					morephotos = false;
				} else {
					morephotos = true;
				}
			} while (morephotos == true);

			// enter a contact action
			System.out.println(" Contact Location: ");
			System.out.println(" Street Name: ");
			String street = sc.nextLine();
			System.out.println(" City Name: ");
			String city = sc.nextLine();
			System.out.println(" State Name: ");
			String state = sc.nextLine();

			// unique to person contact
			System.out.println(" Contact Date of Birth: ");
			String dateOfBirth = sc.nextLine();
			LocalDate localDate2 = LocalDate.parse(dateOfBirth, dateTimeFormatter);
			System.out.println(" Contact Description: ");
			String description = sc.nextLine();

			// creates a relatives arraylist
			ArrayList<BaseContact> Relatives = new ArrayList<>();
			// do this will user doesn't want to add more photos
			do {
				System.out.println(" Contact Relatives: ");
				System.out.println("Does this contact have any relatives in your contacts? (Y/N)");
				String check = sc.nextLine().toUpperCase();
				// if user doesn't want to add more photos break do loop
				if (check.contentEquals("N")) {
					break;
				} else {
					System.out.println("Please enter relatives contact ID number:");
					int relatives = Integer.parseInt(sc.nextLine());
					Relatives.add(Contact.get(relatives));
					System.out.println("Would you like to enter another relative? (Y/N)");
					String ans2 = sc.nextLine().toUpperCase();
					if (ans2.equals("N")) {
						morerelatives = false;
					} else {
						morerelatives = true;
					}
				}
			} while (morerelatives == true);

			// creates new contact
			Contact.add(new PersonContact(countID, contactName, contactPhone, photos, new Location(street, city, state),
					localDate2, description, Relatives));
			// prints out check that you've added a new contact
			System.out.println("Personal contact has been added to your address book.");
		} else // repeats code for business class
		{
			System.out.println(" Contact ID: " + ++countID);
			System.out.println(" Contact Name: ");
			String contactName = sc.nextLine().toUpperCase();
			System.out.println(" Contact Phone: ");
			String contactPhone = sc.nextLine();

			ArrayList<Photo> photos = new ArrayList<>();

			do {
				System.out.println(" Contact Photo ");
				System.out.println(" Photo Id: " + ++countPhotoID);
				System.out.println(" Photo filename: ");
				String filename = sc.nextLine();
				System.out.println(" Photo date: ");
				String date = sc.nextLine();
				LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
				System.out.println(" Photo description: ");
				String photodescription = sc.nextLine();
				photos.add(new Photo(countPhotoID, filename, localDate, photodescription));
				System.out.println("Would you like to enter another photo? (Y/N)");
				String ans = sc.nextLine().toUpperCase();
				if (ans.equals("N")) {
					morephotos = false;
				} else {
					morephotos = true;
				}
			} while (morephotos == true);

			System.out.println(" Contact Location: ");
			System.out.println(" Street Name: ");
			String street = sc.nextLine();
			System.out.println(" City Name: ");
			String city = sc.nextLine();
			System.out.println(" State Name: ");
			String state = sc.nextLine();

			System.out.println(" Contact Hours of Operation: ");
			String hours = sc.nextLine();
			System.out.println(" Contact Website URL: ");
			String URL = sc.nextLine();

			Contact.add(new BusinessContact(countID, contactName, contactPhone, photos,
					new Location(street, city, state), hours, URL));

			System.out.println("Business contact has been added to your address book.");
		}

	}

	private void remove() {
		// If the address book doesn't have any contacts
		if (Contact.size() == 0) {
			System.out.println("There are currently no contacts in your address book");
		} else {
			System.out.println("which contact would you like to remove? (Enter Contact ID number)");
			int i = Integer.parseInt(sc.nextLine());
			Contact.remove(i - 1);
			System.out.println("Contact #" + i + " has been removed");
		}

	}

	private int update() {

		System.out.println(Contact);

		System.out.println("Which contact would you like to Edit? (Enter Contact ID number)");
		int i = Integer.parseInt(sc.nextLine());
		System.out.println("*** Editing Contact #" + i + " ***");
		if (Contact.get(i - 1).getClass().getSimpleName().equals("PersonContact")) {
			editPersonContact((PersonContact) Contact.get(i - 1), i);
		} else {
			editBusinessContact((BusinessContact) Contact.get(i - 1), i);
		}
		return i;
	}

	private void editPersonContact(PersonContact baseContact, int i) {

		int countPhotoID = 0;
		// checks if user wants to enter more than one photo
		boolean morephotos = true;
		// checks if user wants to enter more than one relative
		boolean morerelatives = true;

		// starts basic contact update
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("+++ EDITING CONTACT +++");
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println(" Contact ID: " + i);
		System.out.println(" Contact Name: ");
		baseContact.setContactName(sc.nextLine().toUpperCase());
		System.out.println(" Contact Phone: ");
		baseContact.setContactPhone(sc.nextLine());

		ArrayList<Photo> photos = new ArrayList<>();

		do {
			System.out.println(" Contact Photo ");
			System.out.println(" Photo Id: " + ++countPhotoID);
			System.out.println(" Photo filename: ");
			String filename = sc.nextLine();
			System.out.println(" Photo date: ");
			String date = sc.nextLine();
			LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
			System.out.println(" Photo description: ");
			String photodescription = sc.nextLine();
			photos.add(new Photo(countPhotoID, filename, localDate, photodescription));
			System.out.println("Would you like to enter another photo? (Y/N)");
			String ans = sc.nextLine().toUpperCase();
			if (ans.equals("N")) {
				morephotos = false;
			} else {
				morephotos = true;
			}
		} while (morephotos == true);
		baseContact.setPhotos(photos);
		
		// updates Location information
		System.out.println(" Contact Location: ");
		System.out.println(" Street Name: ");
		String street = sc.nextLine();
		System.out.println(" City Name: ");
		String city = sc.nextLine();
		System.out.println(" State Name: ");
		String state = sc.nextLine();

		baseContact.setLocation(new Location(street, city, state));

		// unique to person contact
		System.out.println(" Contact Date of Birth: ");
		baseContact.setDateOfBirth(LocalDate.parse(sc.nextLine(), dateTimeFormatter)); 
		System.out.println(" Contact Description: ");
		baseContact.setDescription(sc.nextLine()); 

		// creates a relatives arraylist
		ArrayList<BaseContact> Relatives = new ArrayList<>();
		// do this will user doesn't want to add more photos
		do {
			System.out.println(" Contact Relatives: ");
			System.out.println("Do you want to edit this contacts relatives list? (Y/N)");
			String check = sc.nextLine().toUpperCase();
			// if user doesn't want to add more photos break do loop
			if (check.contentEquals("N")) {
				break;
			} else {
				System.out.println("Do you want to add a relative or edit relatives list? (ADD/EDIT)");
				String rel = sc.nextLine().toUpperCase();
				if (rel.equals("ADD")) {
					System.out.println("Please enter relatives contact ID number:");
					int relatives = Integer.parseInt(sc.nextLine());
					Relatives.add(Contact.get(relatives));
					System.out.println("Would you like to enter another relative? (Y/N)");
					String ans2 = sc.nextLine().toUpperCase();
					if (ans2.equals("N")) {
						morerelatives = false;
					} else {
						morerelatives = true;
					}
				} else {
					System.out.println("Please enter relatives contact ID number:");
					int relatives = Integer.parseInt(sc.nextLine());
					Relatives.add(Contact.get(relatives));
					System.out.println("Would you like to enter another relative? (Y/N)");
					String ans2 = sc.nextLine().toUpperCase();
					if (ans2.equals("N")) {
						morerelatives = false;
					} else {
						morerelatives = true;
					}

				}
			}
		} while (morerelatives == true);

		// prints out check that you've added a new contact
		System.out.println("Personal contact has been updated in your address book.");

	}

	private void editBusinessContact(BusinessContact baseContact, int i) {

		// counts and numbers all photos
		int countPhotoID = 0;
		// checks if user wants to enter more than one photo
		boolean morephotos = true;
		// checks if user wants to enter more than one relative
		boolean morerelatives = true;

		System.out.println(" Contact ID: " + i);
		System.out.println(" Contact Name: ");
		baseContact.setContactName(sc.nextLine().toUpperCase());
		System.out.println(" Contact Phone: ");
		baseContact.setContactPhone(sc.nextLine());

		ArrayList<Photo> photos = new ArrayList<>();

		do {
			System.out.println(" Contact Photo ");
			System.out.println(" Photo Id: " + ++countPhotoID);
			System.out.println(" Photo filename: ");
			String filename = sc.nextLine();
			System.out.println(" Photo date: ");
			String date = sc.nextLine();
			LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
			System.out.println(" Photo description: ");
			String photodescription = sc.nextLine();
			photos.add(new Photo(countPhotoID, filename, localDate, photodescription));
			System.out.println("Would you like to enter another photo? (Y/N)");
			String ans = sc.nextLine().toUpperCase();
			if (ans.equals("N")) {
				morephotos = false;
			} else {
				morephotos = true;
			}
		} while (morephotos == true);
		baseContact.setPhotos(photos);
		
		System.out.println(" Contact Location: ");
		System.out.println(" Street Name: ");
		String street = sc.nextLine();
		System.out.println(" City Name: ");
		String city = sc.nextLine();
		System.out.println(" State Name: ");
		String state = sc.nextLine();

		Contact.get(i - 1).setLocation(new Location(street, city, state));

		System.out.println(" Contact Hours of Operation: ");
		baseContact.setHours(sc.nextLine());
		System.out.println(" Contact Website URL: ");
		baseContact.setURL(sc.nextLine()); 

		System.out.println("Business contact has been updated in your address book.");

	}

	private void displayAll() {
		// If the address book doesn't have any contacts
		if (Contact.size() == 0) {
			System.out.println("There are currently no contacts in your address book");
		} else {
			System.out.println(Contact);
		}
	}

	private void displayOne() {
		// If the address book doesn't have any contacts
		if (Contact.size() == 0) {
			System.out.println("There are currently no contacts in your address book");
		} else {
			System.out.println("which contact would you like to view? (Enter Contact ID number)");
			int i = Integer.parseInt(sc.nextLine());
			System.out.println(Contact.get(i - 1));

			System.out.println("Would you like to edit this contact? (Y/N)");
			String ans = sc.nextLine().toUpperCase();
			if (ans.equals("Y")) {

				update();
			}
		}

	}

	private void sort() {
		
		System.out.println("How would you like to sort the addressbook? (enter number)");
		System.out.println("1] Contact Name");
		System.out.println("2] Contact Phone");
		int choice = Integer.parseInt(sc.nextLine());
		
		if(choice == 1) {
		Collections.sort(Contact, (s1, s2)-> s1.getContactName().compareTo(s2.getContactName()));
		}else if(choice == 2) {
		Collections.sort(Contact, (s1, s2)-> s1.getContactPhone().compareTo(s2.getContactPhone()));
		}
		//Collections.sort(Contact, (s1, s2)-> -s1.getContactNumber().compareTo(s2.getContactNumber()));
		
		System.out.println(Contact);
	}

	private void search() {
		System.out.println("What contact Name are you looking for: ");
		String search = sc.nextLine().toUpperCase();
		for (BaseContact c : Contact) {
			if (c.getContactName().contentEquals(search)) {
				System.out.println(c);
			}
		}
	}

}

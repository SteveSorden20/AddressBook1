package cst135n.milestone;

/*
 * The console app is our main method and where we will run all the classes that make up the contact address book application
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import cst135n.milestone.AddressBook;
import cst135n.milestone.BaseContact;
import cst135n.milestone.BusinessContact;
import cst135n.milestone.ConsoleApp;
import cst135n.milestone.DataServices;
import cst135n.milestone.Location;
import cst135n.milestone.PersonContact;
import cst135n.milestone.Photo;


public class ConsoleApp implements DataServices{

	static final File file = new File("datadictionary.txt");//couldn't get datadictionary.xlsx to work
	static AddressBook addressbook = new AddressBook();
	
	
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsoleApp start = new ConsoleApp();
		start.read();
		
//		addressbook = new AddressBook();
		addressbook.displayMenu();
		start.write();
		
	}

	@Override
	public void read() {
		System.out.println("Loading previous data...");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			
			while((line = reader.readLine()) != null) {
				String [] part = line.split("\\|");
				switch (part[0]) {
				case "Person Contact":
					System.out.println("CREATING PERSON CONTACT ");
					addressbook.getContact().add(new PersonContact(Integer.parseInt(part[1]), part[2], part[3],part[4]));
					 break;
				case "Business Contact":
					System.out.println("CREATING BUSINESS CONTACT");
					addressbook.getContact().add(new BusinessContact(Integer.parseInt(part[1]), part[2], part[3],part[4], part[5]));
					 break;
				}
		}
			reader.close();
	}catch(Exception e) {
		
		}

		
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		//store AddressBook
		try {
			FileWriter wr = new FileWriter(file, false);
			storeAddressBook(wr);
			storeBaseContact(wr);
			wr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void storeAddressBook(FileWriter writer) throws IOException {
		System.out.println("Writing address book to File");
	}
	
	private void storeBaseContact(FileWriter writer) throws IOException {
		for(BaseContact b : addressbook.Contact) {
			if(b.getClass().getSimpleName().equals("PersonContact")) {
				System.out.println("Writing personContact to File");
				writer.write(((PersonContact)b) + System.lineSeparator());
			}
			if(b.getClass().getSimpleName().equals("BusinessContact")) {
				System.out.println("Writing BusinessContact to File");
				writer.write(((BusinessContact)b) + System.lineSeparator());
			}
		}
	}
}

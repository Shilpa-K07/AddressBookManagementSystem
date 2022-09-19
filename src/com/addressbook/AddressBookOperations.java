package com.addressbook;
import java.util.Scanner;


public class AddressBookOperations implements AddressBookServiceInf {
public void addPerson()
{
	Scanner scn=new Scanner(System.in);
	System.out.println("Enter the name of the address book to add person details if you don't have any address book then create one !!");
	String name=scn.nextLine();
	Person person=new Person();
	AddressBookRepository addressBookRepository = new AddressBookRepository();
	System.out.println("Enter first name");
	person.setFirstName(scn.nextLine());
	System.out.println("Enter Lastname");
	person.setLastName(scn.nextLine());
	System.out.println("Enter Address");
	person.setAddress(scn.nextLine());
	System.out.println("Enter city");
	person.setCity(scn.nextLine());
	System.out.println("Enter state");
	person.setState(scn.nextLine());
	System.out.println("Enter Zip");
	person.setZip(scn.nextLine());
	System.out.println("Enter phone number");
	person.setPhoneNumber(scn.nextLong());
	addressBookRepository.addPerson(person,name);
}

public void editPerson() {
	Scanner scn=new Scanner(System.in);
	System.out.println("Enter the name of the address book to edit person details.");
	String name=scn.next();
	AddressBookRepository addressBookRepository = new AddressBookRepository();
	System.out.println("Enter ID of person to edit");
	int personId=scn.nextInt();
	
	while(true)
	{
		System.out.println("Which field do you want to edit?");
		System.out.println("1.city 2.state 3.address 4.zip 5.phonenumber 6.Exit");
		System.out.println("Enter your option");
		int choice=scn.nextInt();
	
		switch(choice)
		{
			case 1:System.out.println("Enter new city");
				   scn.nextLine();
				   String city=scn.nextLine();
				   addressBookRepository.editCity(city,personId,name);
				   break;
			case 2:System.out.println("Enter new state");
				   scn.nextLine();
				   String state=scn.nextLine();
				   addressBookRepository.editState(state,personId,name);
				   break;
			case 3:System.out.println("Enter new address");
			       scn.nextLine();
			   	   String address=scn.nextLine();
				   addressBookRepository.editAddress(address,personId,name);
			       break;
			case 4:System.out.println("Enter new Zip");
			       scn.nextLine();
				   String zip=scn.nextLine();
				   addressBookRepository.editZip(zip,personId,name);
			       break;
			case 5:System.out.println("Enter new Phone number");
	   	           int phonenumber=scn.nextInt();
				   addressBookRepository.editPhoneNumber(phonenumber,personId,name);
			       break;
			case 6:System.out.println("Exiting..");
			       break;
			default:System.out.println("enter numbers between 1 to 6");		
		}
		if(choice == 6)
		{
			break;
		}
		System.out.println("Details updated successfully");
	}
}

public void deletePerson() {
	Scanner scn=new Scanner(System.in);
	System.out.println("Enter the name of the address book to delete person details.");
	String name=scn.nextLine();
	AddressBookRepository addressBookRepository = new AddressBookRepository();
	System.out.println("Enter ID of person to delete");
	int personId=scn.nextInt();
	int result=addressBookRepository.deletePerson(personId,name);
	if(result!=0)
		System.out.println("Successfully deleted");
	else
		System.out.println("Deletion failed");
}

public void displayDetails() {
	Scanner scn=new Scanner(System.in);
	System.out.println("Enter the name of the address book to display details");
	String name=scn.nextLine();
	AddressBookRepository addressBookRepository = new AddressBookRepository();
	addressBookRepository.getDetails(name);
}

public void sortByLastName() {
	Scanner scn=new Scanner(System.in);
	System.out.println("Enter the name of the address book to sort by lastname");
	String name=scn.nextLine();
	AddressBookRepository addressBookRepository = new AddressBookRepository();
	addressBookRepository.sortByLastName(name);
}

public void sortByZip() {
	Scanner scn=new Scanner(System.in);
	System.out.println("Enter the name of the address book to sort by zip");
	String name=scn.nextLine();
	AddressBookRepository addressBookRepository = new AddressBookRepository();
	addressBookRepository.sortByZip(name);
}

public void createNewaddressBook() {
	Scanner scn=new Scanner(System.in);
	System.out.println("Enter name for the addressbook");
	String name=scn.nextLine();
	AddressBookRepository addressBookRepository = new AddressBookRepository();
	addressBookRepository.createNewAddressBook(name);
}
}

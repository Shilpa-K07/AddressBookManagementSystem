package com.addressbook;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Scanner;import java.util.Scanner;

public class AddressBook {
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Management System !!!");
		Scanner scn = new Scanner(System.in);
		AddressBookOperations op=new AddressBookOperations();
		
		while(true)
		{
			System.out.println("Option 1: Add");
			System.out.println("Option 2: Edit");
			System.out.println("Option 3: Delete");
			System.out.println("Option 4: Display");
			System.out.println("Option 5: Sort by lastname");
			System.out.println("Option 6: Sort by zip");
			System.out.println("Option 7: Create new address book");
			System.out.println("Option 8: Exit");

			System.out.println("Enter your option");
			int choice=scn.nextInt();
			
			switch(choice)
			{
			case 1:op.addPerson();
					break;
			case 2:op.editPerson();
					break;
			case 3:op.deletePerson();
					break;
			case 4:op.displayDetails();
					break;
			case 5:op.sortByLastName();
					break;
			case 6:op.sortByZip();
					break;
			case 7:op.createNewaddressBook();
					break;
		        case 8:op.createNewaddressBook();
					break;
			case 9:System.out.println("Exiting..");
					break;
			default:System.out.println("enter numbers between 1 to 7");		
			}
			if(choice == 8)
			{
				break;
			}
		}
	}
}

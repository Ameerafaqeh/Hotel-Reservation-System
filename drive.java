package project_phase2;

import java.util.Scanner;

public class drive {

	public static void main(String[] args) {
		Hotel h = new Hotel();
		
	
		printMainMenu();
		Scanner in = new Scanner (System.in);
		int n = in.nextInt();
		switch (n) {
		case 1:
			h.reserveRoom();
			break;
		case 2:
			h.changeRoomType();
			break;
		case 3:
			h.deleteReservedRoom();
			break;
		case 4:
			h.deleteAllReservedRoom();
			break;
		case 5:
			h.deleteAllReservedRoom();
			break;
		case 6:
			h.showAllReservedRooms();
			break;
		
		default :
			System.out.println("sorry,you have enter a wrong number ");
			break;
		}
		

	}
	public static void printMainMenu() { // The main menu method that prints the menu
		System.out.println("please Select an Option(1-7):\n1- Reserve an available room.\r\n"
				+ "2- Choose room type.\r\n" + "3- Delete the reserved room \r\n" + "4- Delete all reserved room.\r\n"
				+ "5- show all reserved room information.\r\n" + "6-Exit System .\r\n");
}
}

package project_phase2;

import java.util.Scanner;

public class Hotel {
	private String hotelName;
	private String hotelAddress;
	private final int MAX_ROOM_NUMBER;
	private Room[] rooms;
	private Scanner scan;

	public Hotel() {
		this.MAX_ROOM_NUMBER = 0;
		this.scan = new Scanner(System.in);
		this.rooms = new Room[MAX_ROOM_NUMBER];
		for (int i = 0; i < MAX_ROOM_NUMBER; i++) {
			rooms[i] = new Room(i + 1);
		}

	}

	public Hotel(String hotelName, String hotelAddress, int mAX_ROOM_NUMBER) {
		
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		MAX_ROOM_NUMBER = mAX_ROOM_NUMBER;
		this.rooms = new Room[MAX_ROOM_NUMBER];
		for (int i = 0; i < MAX_ROOM_NUMBER; i++) {
			rooms[i] = new Room(i + 1);
		}
		this.scan = new Scanner(System.in);

	}

	public void reserveRoom() {
		int roomNumber = askForRoomNumber();
		if (roomNumber != -1) {
			selectRoomType(roomNumber);
			String customerName = scan.nextLine();
			rooms[roomNumber - 1].setCustomerName(customerName);
			rooms[roomNumber - 1].reserve();
			System.out.println("Room " + roomNumber + " has been reserved successfully.");
		}

	}

	public void selectRoomType(int roomNumber) {
		System.out.println("Select room type (Single/Double/Deluxe) for room " + roomNumber + ":");
		String roomType = scan.nextLine();
		while (!checkRoomType(roomType)) {
			System.out.println(
					"Invalid room type! Please select room type (Single/Double/Deluxe) for room " + roomNumber + ":");
			roomType = scan.nextLine();
		}
		rooms[roomNumber - 1].setRoomType(roomType);

	}

	public void changeRoomType() {
		int roomNumber = askForRoomNumber();
		if (roomNumber != -1 && !rooms[roomNumber - 1].isRoomAvailable()) {
			selectRoomType(roomNumber);
		}

	}

	public void deleteReservedRoom() {
		int roomNumber = askForRoomNumber();
		if (roomNumber != -1) {
			rooms[roomNumber - 1].delete();
			System.out.println("Room " + roomNumber + " reservation has been deleted successfully.");
		}

	}

	public void deleteAllReservedRoom() {
		for (Room room : rooms) {
			if (!room.isRoomAvailable()) {
				room.delete();
			}
		}
		System.out.println("All reservations have been deleted.");
	}

	public void showAllReservedRooms() {
		System.out.println("Reserved Rooms:");
		for (Room room : rooms) {
			if (!room.isRoomAvailable()) {
				System.out.println("Room number: " + room.getRoomNumber());
				System.out.println("Room type: " + room.getRoomType());
				System.out.println("Customer name: " + room.getCustomerName());
				System.out.println("------------------------------");
			}
		}
	}

	private Boolean checkRoomType(String roomType) {
		String[] validTypes = { "Single", "Double", "Deluxe" };
		for (String type : validTypes) {
			if (type.equalsIgnoreCase(roomType)) {
				return true;
			}
		}
		return false;
	}

	private void listAvailableRooms() {
		System.out.println("Available Rooms:");
		for (Room room : rooms) {
			if (room.isRoomAvailable()) {
				System.out.println("Room number: " + room.getRoomNumber());
				System.out.println("------------------------------");
			}
		}
	}

	private int askForRoomNumber() {
		System.out.println("enter room number ");
		int roomNumber = scan.nextInt();
		if (roomNumber < 1 || roomNumber > MAX_ROOM_NUMBER) {
			System.out.println("Invalid room number! Room number should be between 1 and " + MAX_ROOM_NUMBER + "");
			return -1;
		}
		return roomNumber;
	}

}

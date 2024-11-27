package project_phase2;

public class Room {

	    private int roomNumber;
	    private String roomType;
	    private boolean isRoomAvailable;
	    private String customerName;

	    public Room(int roomNumber) {
	        this.roomNumber = roomNumber;
	        this.isRoomAvailable = true;
	    }

	    public boolean isRoomAvailable() {
	        return isRoomAvailable;
	    }

	    public void reserve() {
	        if (isRoomAvailable) {
	            isRoomAvailable = false;
	        } else {
	            System.out.println("Room is already reserved.");
	        }
	    }

	    public void delete() {
	        if (!isRoomAvailable) {
	            isRoomAvailable = true;
	            customerName = null;
	            roomType = null;
	        } else {
	            System.out.println("Room is not reserved.");
	        }
	    }

	    public int getRoomNumber() {
	        return roomNumber;
	    }

	    public void setRoomNumber(int roomNumber) {
	        this.roomNumber = roomNumber;
	    }

	    public String getRoomType() {
	        return roomType;
	    }

	    public void setRoomType(String roomType) {
	        this.roomType = roomType;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }
	}

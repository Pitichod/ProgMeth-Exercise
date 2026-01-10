package logic;

public class Ticket {
	private int type;
	private int priceperstation;
	
	private Station start;
	private Station end;
	
	public Ticket(int type,Station start,Station end) {
		setType(type);
		setStation(start,end);
	}
	
	public int getType() {
		return type;
	}
	
	public int getPricePerStation() {
		return priceperstation;
	}
	
	public Station getStart() {
		return start;
	}
	
	public Station getEnd() {
		return end;
	}

	public void setType(int type) {
		if (type == 0) { // Student
			this.type = 0;
			this.priceperstation = 30;
		} else if (type == 1) { // Adult
			this.type = 1;
			this.priceperstation = 30;
		} else if (type == 2) { // Elderly
			this.type = 2;
			this.priceperstation = 25;
		} else {
			// Requirements: If invalid, set type to 1 (Adult)
			this.type = 1;
			this.priceperstation = 30;
		}
	}
	
	public void setStation(Station start,Station end) {
		this.start = start;
		this.end = end;
	}

	public double calculatePrice() {
		if (!isStationValid(start, end)) return -1.0;

		int distance = getStationDistance(start, end);
		double price = (double) distance * priceperstation;

		if (type == 0 && distance > 4) {
			return price * 0.8; // 20% discount [cite: 74]
		} else if (type == 2) {
			return price * 0.6; // 40% discount [cite: 76]
		}
		return price;
	}

	public String getDescription() {
		// Check if the trip is valid (e.g., distance for Elderly, or same station)
		if (!isStationValid(start, end)) {
			return "Invalid Ticket, from " + start.getName() + " to " + end.getName();
		}

		String typename;
		switch (this.type) {
			case 0: typename = "Student"; break;
			case 1: typename = "Adult"; break;
			case 2: typename = "Elderly"; break;
			default: typename = "Invalid";
		}
		return typename + " Ticket, from " + start.getName() + " to " + end.getName();
	}

	public boolean isStationValid(Station start, Station end) {
		if (start == null || end == null) {
			return false; // Prevent NPE if stations are null
		}
		if (type == 2 && this.getStationDistance(start, end) > 6) {
			return false;
		}
		return !start.getName().equals(end.getName());
	}
	
	public int getStationDistance(Station start,Station end) {
		return Math.abs(start.getNumber()-end.getNumber());
	}
	
}

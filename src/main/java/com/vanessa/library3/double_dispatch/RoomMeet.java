package com.vanessa.library3.double_dispatch;

public class RoomMeet extends Meeting {
	private int numberTeachers;
	private int numberRooms;
	
	public RoomMeet(int duration, int numberStudents, int numberTeachers, int numberRooms) {
		super(duration, numberStudents);
		this.numberTeachers = numberTeachers;
		this.numberRooms = numberRooms;
	}

	public void insertProperties(Agenda agenda) {
		super.insertProperties(agenda);
		agenda.insertProperty(MeetProperties.NUMBER_TEACHERS, numberTeachers);
		agenda.insertProperty(MeetProperties.NUMBER_ROOMS, numberRooms);
	}	
	
}

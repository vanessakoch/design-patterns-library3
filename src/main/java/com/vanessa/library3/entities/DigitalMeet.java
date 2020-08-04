package com.vanessa.library3.entities;

import com.vanessa.library3.util.MeetProperties;

public class DigitalMeet extends Meeting {
	private int numberComputers;

	public DigitalMeet(int duration, int numberStudents, int numberComputers) {
		super(duration, numberStudents);
		this.numberComputers = numberComputers;
	}

	public void insertProperties(Agenda agenda) {
		super.insertProperties(agenda);
		agenda.insertProperty(MeetProperties.NUMBER_COMPUTERS, numberComputers);
	}	

}

package com.vanessa.library3.entities;

import java.util.Calendar;

import com.vanessa.library3.util.MeetProperties;

public abstract class Meeting {
	private int hour;
	private int minute;
	private int duration;
	private int numberStudents;
	
	public Meeting(int duration, int numberStudents) {
		super();
		Calendar calendar = Calendar.getInstance();
		
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.duration = duration;
		this.numberStudents = numberStudents;
	}

	public void insertProperties(Agenda agenda) {
		agenda.insertProperty(MeetProperties.HOUR, hour);
		agenda.insertProperty(MeetProperties.MINUTE, minute);
		agenda.insertProperty(MeetProperties.DURATION, duration);
		agenda.insertProperty(MeetProperties.NUMBER_STUDENTS, numberStudents);
	}
	
}

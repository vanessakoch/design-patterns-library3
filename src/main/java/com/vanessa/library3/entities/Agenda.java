package com.vanessa.library3.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vanessa.library3.util.MeetProperties;

public class Agenda {
	private Map<MeetProperties, Integer> properties;
	private List<Meeting> meetings;

	public void insertMeet(Meeting meeting) {
		getMeetings().add(meeting);
		meeting.insertProperties(this);
	}

	public void insertProperty(MeetProperties type, int value) {
		if(!type.toString().equals("HOUR") && !type.toString().equals("MINUTE"))
			getProperties().put(type, getProperties().get(type) + value);
	}

	public String getTotal() {
		if (meetings.isEmpty())
			return "Sem reuniões no momento!";

		int total_computers = 0;
		int total_rooms = 0;
		int total_teachers = 0;
		int total_students = 0;
		int duration = 0;
		
		total_computers += getProperties().get(MeetProperties.NUMBER_COMPUTERS);
		total_rooms += getProperties().get(MeetProperties.NUMBER_ROOMS);
		total_teachers += getProperties().get(MeetProperties.NUMBER_TEACHERS);
		total_students += getProperties().get(MeetProperties.NUMBER_STUDENTS);
		duration += getProperties().get(MeetProperties.DURATION);

		return "Agenda: \nEstá sendo usado " + total_computers + " computadores e " + total_rooms + " sala(s) por " + total_students
				+ " aluno(s) e " + total_teachers + " professor(es). Duração de uso total de " + duration + " minutos.";
	}

	private List<Meeting> getMeetings() {
		if (meetings == null)
			meetings = new ArrayList<Meeting>();
		return meetings;
	}

	private Map<MeetProperties, Integer> getProperties() {
		if (properties == null) {
			properties = new HashMap<MeetProperties, Integer>();
			for (MeetProperties type : MeetProperties.values())
				properties.put(type, 0);
		}
		return properties;
	}

}

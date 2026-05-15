package Matan_Shemaya_Shelly_Roit;

public class Deparment {
	//properties
	public String name;
	public int num_of_students;
	public Lecturer[] lecturers_in_deparment;
	
	
	//Constructor
	public Deparment(String name, int num_of_students, Lecturer[] lecturers_in_deparment) {
		this.name = name;
		this.num_of_students = num_of_students;
		this.lecturers_in_deparment = lecturers_in_deparment;
	}
	
	//methods
	public void AddLecturerToDeparment(Lecturer lecturer) {
		
		if(lecturer.deparment == this) {
			System.err.println("lecturer is already in the deparment");
		}
		else {
			int logicalSize = 0;
			for (Lecturer l : lecturers_in_deparment) { 
				if (l != null) {
					logicalSize++;
				}
			}
			
			lecturer.deparment = this;
			lecturers_in_deparment[logicalSize] = lecturer;	
		}
	}
	public void RemoveLecturerFromDeparment(Lecturer lecturer) {
		
		if(lecturer.deparment == this) {
			int lecturer_index = 0;
			
			for (int i = 0; i < lecturers_in_deparment.length; ++i) {
				if (lecturers_in_deparment[i] == lecturer) {
					lecturer_index = i;
					break;
				}
			}
			
			lecturers_in_deparment[lecturer_index] = null;
			lecturer.deparment = null;
			
			for (int i = lecturer_index; i < lecturers_in_deparment.length; ++i) {
				
				if (lecturers_in_deparment[i]!=null) {
					
					lecturers_in_deparment[i-1] = lecturers_in_deparment[i];
					lecturers_in_deparment[i] = null;
				}
			}
			
		}
		else {
			System.err.println("lecturer is not in the deparment");
		}
	}
}

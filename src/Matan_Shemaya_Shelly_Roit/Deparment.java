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
		
	}
}

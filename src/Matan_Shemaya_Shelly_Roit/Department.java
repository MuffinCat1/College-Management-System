package Matan_Shemaya_Shelly_Roit;

import java.io.Serializable;
import java.util.ArrayList;

public class Department implements Serializable{
	//properties
	private String name;
	private int num_of_students;
	private ArrayList<Lecturer> lecturers_in_department;
	
	
	//Constructor
	public Department(String name, int num_of_students, ArrayList<Lecturer> lecturers_in_deparment) {
		setName(name);
		setNum_of_students(num_of_students);
		setLecturers_in_department(lecturers_in_deparment);
	}
	
	public Department(String name, int num_of_students) {
		this.name = name;
		this.num_of_students = num_of_students;
		lecturers_in_department = new ArrayList<Lecturer>();
	}
	
	
	@Override
	public String toString() {
		ArrayList<String> names = new ArrayList<String>();;
		
		for (int i = 0; i<lecturers_in_department.size(); i++) {
			names.add(lecturers_in_department.get(i).getName());
		}
		
		if(lecturers_in_department.size()==0) {
			return "Department [name=" + name + ", num_of_students=" + num_of_students + "no lecturers in department yet" + "]";
		}
		
		else {
			return "Department [name=" + name + ", num_of_students=" + num_of_students + ", lecturers_in_deparment="
				+ names + "]";
		}
	}
	
	
	//get+set
	public String getName() {
			return name;
		}
	public void setName(String name) {
		if (!(name == null)) {
			this.name = name;
		}
	}
	
	public int getNum_of_students() {
		return num_of_students;
	}
	public void setNum_of_students(int num_of_students) {
		if (num_of_students!=0) {
			this.num_of_students = num_of_students;
		}
	}
	
	public ArrayList<Lecturer> getLecturers_in_department() {
		return lecturers_in_department;
	}
	public void setLecturers_in_department(ArrayList<Lecturer> lecturers_in_department) {
		if (!(lecturers_in_department.size() == 0)) {
			this.lecturers_in_department = lecturers_in_department;
		}
	}
	
	//methods
	public boolean AddLecturer(Lecturer lecturer) throws Exception{
		
		if(lecturer.getDepartment() != null) {
			throw new Exceptions.LecturerHasDepartment();
		}
		
		
		lecturers_in_department.add(lecturer);
		
		lecturer.setDepartment(this);
		return true;
	}
	
	public double get_lecturers_avg() {
		if(lecturers_in_department.size() == 0) {
			return 0;
		}
		double sum = 0;
		for (int i = 0; i<lecturers_in_department.size(); i++) {
			sum += lecturers_in_department.get(i).getSalary();
		}
		return sum/lecturers_in_department.size();
	}
}

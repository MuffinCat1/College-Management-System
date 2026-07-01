package Matan_Shemaya_Shelly_Roit;

import java.util.Arrays;

public class Department {
	//properties
	private String name;
	private int num_of_students;
	private Lecturer[] lecturers_in_department;
	private int num_of_lecturers_in_department;
	
	
	//Constructor
	public Department(String name, int num_of_students, Lecturer[] lecturers_in_deparment) {
		setName(name);
		setNum_of_students(num_of_students);
		setLecturers_in_department(lecturers_in_deparment);
	}
	
	public Department(String name, int num_of_students) {
		this.name = name;
		this.num_of_students = num_of_students;
		lecturers_in_department = new Lecturer [10];
		num_of_lecturers_in_department = 0;
	}
	
	
	@Override
	public String toString() {
		String[] names = new String[num_of_lecturers_in_department];
		for (int i = 0; i<num_of_lecturers_in_department; i++) {
			names[i] = lecturers_in_department[i].getName();
		}
		if(num_of_lecturers_in_department==0) {
			return "Department [name=" + name + ", num_of_students=" + num_of_students + "no lecturers in department yet" + "]";
		}
		else {
		return "Department [name=" + name + ", num_of_students=" + num_of_students + ", lecturers_in_deparment="
				+ Arrays.toString(names) + "]";
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
	public Lecturer[] getLecturers_in_department() {
		return lecturers_in_department;
	}
	public void setLecturers_in_department(Lecturer[] lecturers_in_department) {
		if (!(lecturers_in_department.length == 0)) {
			this.lecturers_in_department = lecturers_in_department;
		}
	}
	
	//methods
	public boolean AddLecturer(Lecturer lecturer) {
		if(!(lecturer.getDepartment() == null) ) {
			return false;
		}
		if (num_of_lecturers_in_department == lecturers_in_department.length) {
			Lecturer[] lecturers_in_department2 = new Lecturer [2*lecturers_in_department.length];
			for (int i = 0; i<this.lecturers_in_department.length;i++) {
				lecturers_in_department2[i] = this.lecturers_in_department[i];
			}
			this.lecturers_in_department = lecturers_in_department2;
		}
		lecturers_in_department[num_of_lecturers_in_department] = lecturer;
		num_of_lecturers_in_department += 1;
		lecturer.setDepartment(this);
		return true;
	}
	
	public double get_lecturers_avg() {
		if(num_of_lecturers_in_department == 0) {
			return 0;
		}
		double sum = 0;
		for (int i = 0; i<num_of_lecturers_in_department; i++) {
			sum += lecturers_in_department[i].getSalary();
		}
		return sum/num_of_lecturers_in_department;
	}
}

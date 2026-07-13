package Matan_Shemaya_Shelly_Roit;

import java.io.Serializable;
import java.util.ArrayList;

public class Lecturer implements Serializable{
	
	//properties
	public enum Degree {
		FIRST,
		SECOND,
		DOCTOR,
		PROFESSOR
	};
	
	protected String name;
	protected int id;
	protected Degree lecturer_degree; 
	protected String degree_name;
	protected float salary;
	protected Department department;
	protected ArrayList<Committee> assigned_committees;
	
	//Constructor
	public Lecturer(String name, int id, Degree lecturer_degree, String degree_name, float salary) throws Exception{
		setName(name);
		setId(id);
		this.lecturer_degree = lecturer_degree; // enum deals with invalid input
		setDegree_name(degree_name);
		setSalary (salary);
		this.assigned_committees = new ArrayList<Committee>();
	}
	public Lecturer(String name, int id, Degree lecturer_degree, String degree_name, float salary, Department deparment) throws Exception{
		setName(name);
		setId(id);
		this.lecturer_degree = lecturer_degree; // enum deals with invalid input
		setDegree_name(degree_name);
		setSalary (salary);
		setDepartment(deparment);
		this.assigned_committees = new ArrayList<Committee>();
	}
	public Lecturer(String name, int id, Degree lecturer_degree, String degree_name, float salary, Department deparment,ArrayList<Committee> assigned_committees) throws Exception{
		setName(name);
		setId(id);
		this.lecturer_degree = lecturer_degree; // enum deals with invalid input
		setDegree_name(degree_name);
		setSalary (salary);
		setDepartment(deparment);
		setassigned_committees(assigned_committees);
	}
	
	
	@Override
	public String toString() {
		ArrayList<String> names = new ArrayList<String>();
		for (int i = 0; i<assigned_committees.size(); i++) {
			names.add(assigned_committees.get(i).getName());
		}
		String dept_name = "";
		if (this.department == null) {
			dept_name = "no department name";
		}
		else {
			dept_name = this.department.getName();	
		}
		
		if(assigned_committees.size() == 0) {
			return "Lecturer: name= " + name + ", id= " + id + ", lecturer_degree= " + lecturer_degree + ", degree_name= "
					+ degree_name + ", salary= " + salary + ", deparment= " + dept_name + ", Lecturers has no committees yet";
		}
		else {
			return "Lecturer: name= " + name + ", id= " + id + ", lecturer_degree= " + lecturer_degree + ", degree_name= "
					+ degree_name + ", salary= " + salary + ", deparment= " + dept_name + ", assigned_committees=" + names;
		}
		
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
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
	public int getId() {
		return id;
	}
	public void setId(int id) throws Exceptions.IdOutOfRange{
		if (id>=100000000 && id <= 999999999) {
			this.id = id;
		} else {
			throw new Exceptions.IdOutOfRange();
		}
	}
	public Degree getLecturer_degree() {
		return lecturer_degree;
	}
	public void setLecturer_degree(Degree lecturer_degree) {
		this.lecturer_degree = lecturer_degree;
	}
	public String getDegree_name() {
		return degree_name;
	}
	public void setDegree_name(String degree_name) {
		if (!(degree_name == null)) {
			this.degree_name = degree_name;
		}
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment (Department department) {
		this.department = department;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary (float salary) {
		if (salary>=0) {
			this.salary = salary;
		}
	}
	public ArrayList<Committee> getassigned_committees() {
		return assigned_committees;
	}
	public void setassigned_committees(ArrayList<Committee> assigned_committees) {
		if (assigned_committees.size() != 0) {
			this.assigned_committees = assigned_committees;
		}
	}
	
	
	//methods
	public void addCommitteeToLecturer(Committee new_committee) {
		if (this.assigned_committees == null) {
		    this.assigned_committees = new ArrayList<Committee>();;
		 }

		assigned_committees.add(new_committee);
	}
	
	public void removeCommittee(Committee committee) throws Exceptions.CommitteeDoesntExist{
		if(!assigned_committees.remove(committee))
			throw new Exceptions.CommitteeDoesntExist();
	}
}

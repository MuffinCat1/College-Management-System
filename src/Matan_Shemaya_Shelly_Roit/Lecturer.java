package Matan_Shemaya_Shelly_Roit;

import java.util.Arrays;

public class Lecturer {
	
	//properties
	public enum Degree {
		First,
		Second,
		Doctor,
		Professor
	};
	
	protected String name;
	protected int id;
	protected Degree lecturer_degree; 
	protected String degree_name;
	protected float salary;
	protected Department department;
	protected Committee[] assigned_comeeties;
	protected int assigned_comeeties_num;
	
	//Constructor
	public Lecturer(String name, int id, Degree lecturer_degree, String degree_name, float salary) throws Exception{
		setName(name);
		setId(id);
		this.lecturer_degree = lecturer_degree; // enum deals with invalid input
		setDegree_name(degree_name);
		setSalary (salary);
		assigned_comeeties_num = 0;
	}
	public Lecturer(String name, int id, Degree lecturer_degree, String degree_name, float salary, Department deparment) throws Exception{
		setName(name);
		setId(id);
		this.lecturer_degree = lecturer_degree; // enum deals with invalid input
		setDegree_name(degree_name);
		setSalary (salary);
		setDepartment(deparment);
		assigned_comeeties_num = 0;
	}
	public Lecturer(String name, int id, Degree lecturer_degree, String degree_name, float salary, Department deparment,Committee[] assigned_comeeties) throws Exception{
		setName(name);
		setId(id);
		this.lecturer_degree = lecturer_degree; // enum deals with invalid input
		setDegree_name(degree_name);
		setSalary (salary);
		setDepartment(deparment);
		setAssigned_comeeties(assigned_comeeties);
		assigned_comeeties_num = 0;
		
	}
	
	
	@Override
	public String toString() {
		String[] names = new String[assigned_comeeties_num];
		for (int i = 0; i<assigned_comeeties_num; i++) {
			names[i] = assigned_comeeties[i].getName();
		}
		String dept_name = "";
		if (this.department == null) {
			dept_name = "no department name";
		}
		else {
			dept_name = this.department.getName();	
		}
		
		if(assigned_comeeties_num == 0) {
			return "Lecturer: name= " + name + ", id= " + id + ", lecturer_degree= " + lecturer_degree + ", degree_name= "
					+ degree_name + ", salary= " + salary + ", deparment= " + dept_name + ", Lecturers has no committees yet";
		}
		else {
			return "Lecturer: name= " + name + ", id= " + id + ", lecturer_degree= " + lecturer_degree + ", degree_name= "
					+ degree_name + ", salary= " + salary + ", deparment= " + dept_name + ", assigned_comeeties=" +  Arrays.toString(names);
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
	public Committee[] getAssigned_comeeties() {
		return assigned_comeeties;
	}
	public void setAssigned_comeeties(Committee[] assigned_comeeties) {
		if (assigned_comeeties.length != 0) {
			this.assigned_comeeties = assigned_comeeties;
		}
	}
	
	
	//methods
	public void addCommitteeToLecturer(Committee new_committee) {
		if (this.assigned_comeeties == null) {
		    this.assigned_comeeties = new Committee[10];
		 }
		
		if (assigned_comeeties_num == assigned_comeeties.length) {
			Committee[] assigned_comeeties2 = new Committee [2*assigned_comeeties.length];
			for (int i = 0; i<this.assigned_comeeties.length;i++) {
				assigned_comeeties2[i] = this.assigned_comeeties[i];
			}
			this.assigned_comeeties = assigned_comeeties2;
		}
		
		assigned_comeeties[assigned_comeeties_num] = new_committee;
		assigned_comeeties_num++;
	}
	
	public boolean removeCommittee(Committee committee) {
		for (int i = 0; i<assigned_comeeties_num;i++ ) {
			if(assigned_comeeties[i].getName().equals(committee.getName())) {
				for(int j = i; j<assigned_comeeties_num-1; j++) {
					assigned_comeeties[j] = assigned_comeeties[j+1];
				}
				assigned_comeeties[assigned_comeeties_num-1] = null;
				assigned_comeeties_num-=1;
				return true;
			}
		}
		return false;
	}
}

package Matan_Shemaya_Shelly_Roit;

public class Lecturer {
	//properties
	public enum degree {
		First,
		Second,
		Doctor,
		Proffesor
	};
	public String name;
	public int id;
	public degree lecturer_degree;
	public String degree_name;
	public float salary;
	public Deparment deparment;
	
	//Constructor
	public Lecturer(String name, int id, degree lecturer_degree, String degree_name, float salary, Deparment deparment) {
		this.name = name;
		this.id = id;
		this.lecturer_degree = lecturer_degree;
		this.degree_name = degree_name;
		this.salary = salary;
		this.deparment = deparment;
	}
}

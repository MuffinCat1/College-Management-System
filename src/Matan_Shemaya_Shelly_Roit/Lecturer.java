package Matan_Shemaya_Shelly_Roit;

public class Lecturer {
	//properties
	enum degree_selector {
		First,
		Second,
		Doctor,
		Proffesor
	};
	
	
	public String name;
	public int id;
	public degree_selector degree;
	public String degree_name;
	public float salary;
	public Deparment deparment;
	
	//Constructor
	public Lecturer(String name, int id, degree_selector degree, String degree_name, float salary, Deparment deparment) {
		this.name = name;
		this.id = id;
		this.degree = degree;
		this.degree_name = degree_name;
		this.salary = salary;
		this.deparment = deparment;
	}
}

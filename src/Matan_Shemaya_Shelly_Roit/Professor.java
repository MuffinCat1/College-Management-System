package Matan_Shemaya_Shelly_Roit;

public class Professor extends Lecturer implements CommitteeHeadable{

	public Professor(String name, int id, String degree_name, float salary) {
		super(name, id, Degree.Professor, degree_name, salary);
		// TODO Auto-generated constructor stub
	}

}

package Matan_Shemaya_Shelly_Roit;

import java.io.Serializable;

public class Professor extends Doctor implements CommitteeHeadable, Serializable{

	private String awarding_body_of_professorship;
	
	public Professor(String name, int id, String degree_name, float salary) throws Exception {
		super(name, id, Degree.PROFESSOR, degree_name, salary);
	}
	
	@Override
	public String toString() {
		if(awarding_body_of_professorship != null)
			return "{"+super.toString() + ", awarding body of professorship= " + awarding_body_of_professorship+"}";
		else
			return "{"+super.toString() + ", awarding body of professorship= no awarding body of professorship assigned to the lecturer}";
	}
}

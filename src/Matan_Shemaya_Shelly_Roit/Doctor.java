package Matan_Shemaya_Shelly_Roit;

import java.util.Arrays;

public class Doctor extends Lecturer implements CommitteeHeadable{

	protected String articles[];
	
	public Doctor(String name, int id, String degree_name, float salary) throws Exception {
		super(name, id, Degree.Doctor, degree_name, salary);
	}
	
	protected Doctor(String name, int id, Degree degree, String degree_name, float salary) throws Exception {
		super(name, id, degree, degree_name, salary);
	}
	
	@Override
	public String toString() {
		if (articles == null)
			return "(" + super.toString() + ", articles= the lecturer has no articles)";
		else
			return "("+super.toString() + ", articles= " + Arrays.toString(articles)+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		Doctor doctor_obj = (Doctor)obj;
		
		return doctor_obj.articles.length == this.articles.length;
	}
	
	public String[] get_Articles() {
		return articles;
	}
	
}

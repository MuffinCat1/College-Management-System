package Matan_Shemaya_Shelly_Roit;

import java.io.Serializable;
import java.util.ArrayList;

public class Doctor extends Lecturer implements CommitteeHeadable, Serializable{

	protected ArrayList<String> articles;
	
	public Doctor(String name, int id, String degree_name, float salary) throws Exception {
		super(name, id, Degree.DOCTOR, degree_name, salary);
	}
	
	protected Doctor(String name, int id, Degree degree, String degree_name, float salary) throws Exception {
		super(name, id, degree, degree_name, salary);
	}
	
	@Override
	public String toString() {
		if (articles == null)
			return "(" + super.toString() + ", articles= the lecturer has no articles)";
		else
			return "("+super.toString() + ", articles= " + articles+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		Doctor doctor_obj = (Doctor)obj;
		
		return doctor_obj.articles.size()== this.articles.size();
	}
	
	public ArrayList<String> get_Articles() {
		return articles;
	}
	
}

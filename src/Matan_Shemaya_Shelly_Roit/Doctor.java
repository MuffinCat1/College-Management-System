package Matan_Shemaya_Shelly_Roit;

public class Doctor extends Lecturer implements CommitteeHeadable{

	public Doctor(String name, int id, String degree_name, float salary) {
		super(name, id, Degree.Doctor, degree_name, salary);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}

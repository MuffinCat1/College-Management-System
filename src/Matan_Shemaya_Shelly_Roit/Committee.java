package Matan_Shemaya_Shelly_Roit;

public class Committee {
	//properties
	public String name;
	public Lecturer[] lecturers_in_committee;
	public Lecturer committee_chairman;
	
	//Constructor 
	public Committee(String name, Lecturer[] lecturers_in_committee, Lecturer committee_chairman) {
		this.name = name;
		this.lecturers_in_committee = lecturers_in_committee;
		this.committee_chairman = committee_chairman;
	}
}

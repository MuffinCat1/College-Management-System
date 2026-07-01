package Matan_Shemaya_Shelly_Roit;

import java.util.Arrays;

public class Committee {
	//properties
	private String name;
	private Lecturer[] lecturers_in_committee;
	private int num_of_lecturers_in_committee;
	private Lecturer committee_chairman;
	 
	
	//Constructor 
	public Committee(String name,Lecturer committee_chairman) {
		setName(name);
		setCommittee_chairman(committee_chairman);
		this.lecturers_in_committee = new Lecturer[10];
	    this.num_of_lecturers_in_committee = 0;
	}
	public Committee(String name, Lecturer[] lecturers_in_committee, Lecturer committee_chairman) {
		setName(name);
		this.lecturers_in_committee = lecturers_in_committee;
		setCommittee_chairman(committee_chairman);
		this.num_of_lecturers_in_committee = lecturers_in_committee.length;
	}
	
	
	@Override
	public String toString() {
		return "Committee [name=" + name + ", lecturers_in_committee=" + Arrays.toString(lecturers_in_committee)
				+ ", committee_chairman=" + committee_chairman + "]";
	}
	
	// get+set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (!(name == null)) {
			this.name = name;
		}
	}
	public Lecturer getCommittee_chairman() {
		return committee_chairman;
	}
	public void setCommittee_chairman(Lecturer committee_chairman) {
		if(committee_chairman.getLecturer_degree() == Lecturer.Degree.Doctor ||
				committee_chairman.getLecturer_degree()  == Lecturer.Degree.Professor) {
					this.committee_chairman = committee_chairman;
		}
	}
	public Lecturer[] getLecturers_in_committee() {
		return lecturers_in_committee;
	}
	public void setLecturers_in_committee(Lecturer[] lecturers_in_committee) {
		if (!(lecturers_in_committee.length == 0)) {
			this.lecturers_in_committee = lecturers_in_committee;
		}
	}
	public int getNum_of_lecturers_in_committee() {
		return num_of_lecturers_in_committee;
	}
	
	//methods
	public boolean addLecturer(Lecturer other_lecturer) {
		if (other_lecturer.getName().equals(committee_chairman.getName())) {
			return false;
		}
		if (num_of_lecturers_in_committee == lecturers_in_committee.length) {
			Lecturer[] lecturers_in_committee2 = new Lecturer [2*lecturers_in_committee.length];
			for (int i = 0; i<num_of_lecturers_in_committee;i++) {
				lecturers_in_committee2[i] = this.lecturers_in_committee[i];
			}
			this.lecturers_in_committee = lecturers_in_committee2;
		}
		for (int i = 0; i<num_of_lecturers_in_committee; i++) {
			if (lecturers_in_committee[i].getName().equals(other_lecturer.getName()) ){
				return false;
			}
		}
		lecturers_in_committee[num_of_lecturers_in_committee] = other_lecturer;
		num_of_lecturers_in_committee+=1;
		other_lecturer.addCommitteeToLecturer(this);
		return true;
	}
	
	public boolean removeLecturer(String lecturer_name) {
		for (int i = 0; i<num_of_lecturers_in_committee;i++ ) {
			if(lecturers_in_committee[i].getName().equals(lecturer_name)) {
				for(int j = i; j<num_of_lecturers_in_committee-1; j++) {
					lecturers_in_committee[j] = lecturers_in_committee[j+1];
				}
				Lecturer temp = lecturers_in_committee[num_of_lecturers_in_committee-1];
				lecturers_in_committee[num_of_lecturers_in_committee-1] = null;
				num_of_lecturers_in_committee-=1;
				temp.removeCommittee(this);
				return true;
			}
		}
		return false;
	}
}

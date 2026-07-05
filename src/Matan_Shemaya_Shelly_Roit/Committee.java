package Matan_Shemaya_Shelly_Roit;

import java.util.Arrays;

import Matan_Shemaya_Shelly_Roit.Lecturer.Degree;

public class Committee {
	//properties
	private String name;
	private Lecturer[] lecturers_in_committee;
	private int num_of_lecturers_in_committee;
	private Lecturer committee_chairman;
	 
	
	//Constructor 
	public Committee(String name, Lecturer committee_chairman) throws Exceptions.CantMakeCommitteeChairMan{
		this.lecturers_in_committee = new Lecturer[10];
		setName(name);
		setCommittee_chairman(committee_chairman);
	    this.num_of_lecturers_in_committee = 0;
	}
	public Committee(String name, Lecturer[] lecturers_in_committee, Lecturer committee_chairman) throws Exceptions.CantMakeCommitteeChairMan{
		this.lecturers_in_committee = lecturers_in_committee;
		setName(name);
		setCommittee_chairman(committee_chairman);
		this.num_of_lecturers_in_committee = lecturers_in_committee.length;
	}
	
	@Override
	public String toString() {
		return "Committee [name=" + name + ", lecturers_in_committee=\n" + Arrays.toString(lecturers_in_committee)
				+ "\n, committee_chairman=\n" + committee_chairman + "]";
	}
	@Override
	public boolean equals(Object obj) {
		Committee committee_obj = (Committee)obj;
		return (committee_obj.getNum_of_lecturers_in_committee()==this.getNum_of_lecturers_in_committee())&&(committee_obj.Get_total_articles_in_commitee() == this.Get_total_articles_in_commitee());
	}
	
	// get+set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name != null) {
			this.name = name;
		}
	}
	
	public Lecturer getCommittee_chairman() {
		return committee_chairman;
	}	
	public void setCommittee_chairman(Lecturer committee_chairman) throws Exceptions.CantMakeCommitteeChairMan{
		if(committee_chairman instanceof CommitteeHeadable) {			
			this.committee_chairman = committee_chairman;
			lecturers_in_committee[0] = committee_chairman;
			this.committee_chairman.addCommitteeToLecturer(this);
		}
		else
			throw new Exceptions.CantMakeCommitteeChairMan();
	}
	
	public Lecturer[] getLecturers_in_committee() {
		return lecturers_in_committee;
	}
	public void setLecturers_in_committee(Lecturer[] lecturers_in_committee) {
		if (lecturers_in_committee.length != 0) {
			this.lecturers_in_committee = lecturers_in_committee;
		}
	}
	
	public int getNum_of_lecturers_in_committee() {
		return num_of_lecturers_in_committee;
	}
	
	public int Get_total_articles_in_commitee() {
		int total = 0;
		for (int i = 0; i < num_of_lecturers_in_committee; i++) {
			if(lecturers_in_committee[i].getLecturer_degree().ordinal() >= Degree.Doctor.ordinal()) {
				Doctor tmp = (Doctor)lecturers_in_committee[i];
				total += tmp.get_Articles().length;
			}
		}
		return total;
	}
	
	//methods
	public void addLecturer(Lecturer other_lecturer) throws Exception{
		/*
		 * if (other_lecturer.getName().equals(committee_chairman.getName())) { return
		 * false; }
		 */
		if (num_of_lecturers_in_committee == lecturers_in_committee.length) {
			Lecturer[] lecturers_in_committee2 = new Lecturer [2*lecturers_in_committee.length];
			for (int i = 0; i<num_of_lecturers_in_committee;i++) {
				lecturers_in_committee2[i] = this.lecturers_in_committee[i];
			}
			this.lecturers_in_committee = lecturers_in_committee2;
		}
		
		for (int i = 0; i<num_of_lecturers_in_committee; i++) {
			if (lecturers_in_committee[i].getName().equals(other_lecturer.getName())){
				throw new Exceptions.LecturerAlreadyExist();
			}
		}
		lecturers_in_committee[num_of_lecturers_in_committee] = other_lecturer;
		num_of_lecturers_in_committee+=1;
		other_lecturer.addCommitteeToLecturer(this);
	}
	
	public void removeLecturer(String lecturer_name) throws Exception{
		for (int i = 0; i<num_of_lecturers_in_committee;i++ ) {
			if(lecturers_in_committee[i].getName().equals(lecturer_name)) {
				for(int j = i; j<num_of_lecturers_in_committee-1; j++) {
					lecturers_in_committee[j] = lecturers_in_committee[j+1];
				}
				Lecturer temp = lecturers_in_committee[num_of_lecturers_in_committee-1];
				lecturers_in_committee[num_of_lecturers_in_committee-1] = null;
				num_of_lecturers_in_committee-=1;
				temp.removeCommittee(this);
				return;
			}
		}
		throw new Exceptions.LecturerDoesntExist();
	}
}

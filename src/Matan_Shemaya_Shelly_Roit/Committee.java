package Matan_Shemaya_Shelly_Roit;

import java.io.Serializable;
import java.util.ArrayList;

import Matan_Shemaya_Shelly_Roit.Lecturer.Degree;

public class Committee implements Serializable{
	//properties
	private String name;
	private ArrayList<Lecturer> lecturers_in_committee;
	private Lecturer committee_chairman;
	private Degree committee_degree;
	 
	
	//Constructor 
	public Committee(String name, Lecturer committee_chairman, Degree committee_degree) throws Exceptions.CantMakeCommitteeChairMan{
		this.lecturers_in_committee = new ArrayList<Lecturer>();
		this.committee_degree = committee_degree;
		setName(name);
		setCommittee_chairman(committee_chairman);
	}
	public Committee(String name, ArrayList<Lecturer> lecturers_in_committee, Lecturer committee_chairman, Degree committee_degree) throws Exceptions.CantMakeCommitteeChairMan{
		this.lecturers_in_committee = lecturers_in_committee;
		this.committee_degree = committee_degree;
		setName(name);
		setCommittee_chairman(committee_chairman);
	}
	
	@Override
	public String toString() {
		return "Committee [name=" + name + ", lecturers_in_committee=\n" + lecturers_in_committee
				+ "\n, committee_chairman=\n" + committee_chairman + "]";
	}
	@Override
	public boolean equals(Object obj) {
		Committee committee_obj = (Committee)obj;
		return (committee_obj.lecturers_in_committee.size()==this.lecturers_in_committee.size())&&(committee_obj.Get_total_articles_in_commitee() == this.Get_total_articles_in_commitee());
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
			lecturers_in_committee.add(committee_chairman);
			this.committee_chairman.addCommitteeToLecturer(this);
		}
		else
			throw new Exceptions.CantMakeCommitteeChairMan();
	}
	
	public ArrayList<Lecturer> getLecturers_in_committee() {
		return lecturers_in_committee;
	}
	public void setLecturers_in_committee(ArrayList<Lecturer> lecturers_in_committee) {
		if (lecturers_in_committee.size() != 0) {
			this.lecturers_in_committee = lecturers_in_committee;
		}
	}
	
	public int Get_total_articles_in_commitee() {
		int total = 0;
		for (int i = 0; i < lecturers_in_committee.size(); i++) {
			if(lecturers_in_committee.get(i).getLecturer_degree().ordinal() >= Degree.DOCTOR.ordinal()) {
				Doctor tmp = (Doctor)lecturers_in_committee.get(i);
				total += tmp.get_Articles().size();
			}
		}
		return total;
	}
	
	//methods
	public void addLecturer(Lecturer other_lecturer) throws Exception{
		for (int i = 0; i<lecturers_in_committee.size(); i++) {
			if (lecturers_in_committee.get(i).getName().equals(other_lecturer.getName())){
				throw new Exceptions.LecturerAlreadyExist();
			}
		}
		if (!other_lecturer.getLecturer_degree().equals(committee_degree))
			throw new Exceptions.WrongDegree();
		
		lecturers_in_committee.add(other_lecturer);
		other_lecturer.addCommitteeToLecturer(this);
	}
	
	public void removeLecturer(String lecturer_name) throws Exception{
		for (int i = 0; i<lecturers_in_committee.size();i++ ) {
			if(lecturers_in_committee.get(i).getName().equals(lecturer_name)) {
				lecturers_in_committee.get(i).removeCommittee(this);
				lecturers_in_committee.remove(lecturers_in_committee.get(i));
			}
		}
		throw new Exceptions.LecturerDoesntExist();
	}
}

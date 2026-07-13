package Matan_Shemaya_Shelly_Roit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ManagingClass implements Serializable{
	// properties
	private String college_name;
	private ArrayList<Lecturer> lecturers;
	private ArrayList<Department> departments;
	private ArrayList<Committee> committees;


	// Constructor
	public ManagingClass(String college_name) {
		this.college_name = college_name;
		
		this.lecturers = new ArrayList<Lecturer>();
		this.departments = new ArrayList<Department>();
		this.committees = new ArrayList<Committee>();
		
	}

	@Override
	public String toString() {
		return "College [name=" + college_name + ", committees=" + committees
		+ ", Departments=" + departments + ",  Lecturers=" + lecturers +"]";
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	// methods
	public void addLecturer(String name, int id, Lecturer.Degree lecturer_degree, String degree_name, float salary) throws Exception{
		for (int i = 0; i < lecturers.size(); i++) {
			if (this.lecturers.get(i).getName().equals(name)) {
				throw new Exceptions.LecturerAlreadyExist();
			}
		}
		
		try {			
			if (lecturer_degree.equals(Lecturer.Degree.DOCTOR)) {
				lecturers.add(new Doctor(name, id, degree_name, salary));
			} else if (lecturer_degree.equals(Lecturer.Degree.PROFESSOR)) {
				lecturers.add(new Professor(name, id, degree_name, salary));
			} else {			
				lecturers.add(new Lecturer(name, id, lecturer_degree, degree_name, salary));
			}
		} catch(Exceptions.IdOutOfRange e) {
			throw e;
		}
	}

	public void addCommittee(String name, String committee_chairman_name, Lecturer.Degree committee_degree) throws Exception{		
	    for (int i = 0; i < committees.size(); i++) {
	        if (committees.get(i).getName().equals(name)) {
	            throw new Exceptions.CommitteeAlreadyExist();
	        }
	    }
	    
	    for (int i = 0; i < lecturers.size(); i++) {
	        if (lecturers.get(i).getName().equals(committee_chairman_name) 
	            && lecturers.get(i) instanceof CommitteeHeadable) {

	            Committee committee = new Committee(name, lecturers.get(i), committee_degree);
	            committees.add(committee);
	            lecturers.get(i).addCommitteeToLecturer(committee);
	            return;
	        }
	    }
	    
	    throw new Exceptions.CantMakeCommitteeChairMan();
	}
	public void addCommittee(Committee committee){
		committees.add(committee);
	}

	public void add_lecturer_to_committee(String committee_name, String lecturer_name) throws Exception{
		boolean foundCommittee = false;
		boolean foundLecturer = false;
		
		try {
			for (int i = 0; i < committees.size(); i++) {
				if(committees.get(i).getName().equals(committee_name)) {					
					foundCommittee = true;
					for (int j = 0; j < lecturers.size(); j++) {
						if (lecturers.get(j).getName().equals(lecturer_name)) {
							foundLecturer = true;
							committees.get(i).addLecturer(lecturers.get(j));
							lecturers.get(j).addCommitteeToLecturer(committees.get(i));
							return;
						}
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		if(!foundCommittee) {			
			if (!foundLecturer)
				throw new Exception("Lecturer and committee doesnt exist");
			else
				throw new Exceptions.CommitteeDoesntExist();
		}
		else if(foundCommittee && !foundLecturer)
			throw new Exceptions.LecturerDoesntExist();
	}

	public void add_department(String name,int num_of_students) throws Exception{
		for (int i = 0; i<departments.size(); i++) {
			if(departments.get(i).getName().equals(name)) {
				throw new Exceptions.DepartmentAlreadyExist();
			}
		}

		departments.add(new Department (name,num_of_students));
	}

	public void update_committee_chairman(String committee_name, String new_chairman_name) throws Exception{
		try {
			for (int i = 0; i<committees.size(); i++) {
				for (int j = 0; j<lecturers.size(); j++) {
					if (committees.get(i).getName().equals(committee_name) && lecturers.get(j).getName().equals(new_chairman_name) && lecturers.get(j) instanceof CommitteeHeadable){
						committees.get(i).setCommittee_chairman(lecturers.get(j));
						remove_lecturer_from_commmittee(lecturers.get(j).getName(),committee_name);
					}
				}
			}
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public void remove_lecturer_from_commmittee(String lecturer_name, String committee_name) throws Exception{
		try {
			for (int i = 0; i<committees.size(); i++) {
				if(committees.get(i).getName().equals(committee_name)){
					committees.get(i).removeLecturer(lecturer_name);
				}
			}			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void AddLecturerToDepartment(String lecturer_name, String department_name) throws Exception{
		Lecturer found_lecturer = null;
		Department found_department = null;
		
		for(int i = 0; i<lecturers.size(); i++) {
			if (lecturers.get(i).getName().equals(lecturer_name)) {
				found_lecturer = lecturers.get(i);
				break;
			}		
		}
		
		for (int i = 0; i<departments.size(); i++) {
			if (departments.get(i).getName().equals(department_name)) {
				found_department = departments.get(i);
				break;
			}		
		}
		
		if (found_department == null)
			throw new NullPointerException("department doesnt exist");
		else if (found_lecturer == null)
			throw new NullPointerException("lecturer doesnt exist");
		
		try {
			found_department.AddLecturer(found_lecturer);
		} catch(Exception e) {
			throw e;
		}
		
	}
	
	public Doctor Get_Doctor(String name) throws Exception{
		for (int i =0; i< lecturers.size(); ++i) {
			if (lecturers.get(i).getName().equals(name)) {
				if (lecturers.get(i).getLecturer_degree().ordinal() < Lecturer.Degree.DOCTOR.ordinal()) {
					throw new Exceptions.CantMakeDoctor();
					 }
				} else {
					return (Doctor)lecturers.get(i);
				}
			}
			throw new Exceptions.LecturerDoesntExist();
	}
	
	public Committee get_Commettee(String name) throws Exception{
		for (int i =0; i< lecturers.size(); ++i) {
			if(committees.get(i).getName().equals(name)) {
				return committees.get(i);
			}
		}
		throw new Exceptions.CommitteeDoesntExist();
	}
	
	public double get_lecturers_avg() {
		if(lecturers.size() == 0) {
			return 0;
		}
		double sum = 0;
		for (int i = 0; i<lecturers.size(); i++) {
			sum += lecturers.get(i).getSalary();
		}
		return sum/lecturers.size();
	}
	
	public double get_departments_lecturers_avg(String department_name) {
		for (int i = 0; i<departments.size(); i++) {
			if(departments.get(i).getName().equals(department_name)) {
				return departments.get(i).get_lecturers_avg();
			}
		}
		return -1;
	}
	
	public void printAllLecturers() {
		for (int i = 0; i<lecturers.size(); i++) {
			System.out.println(lecturers.get(i));
		}
	}
	
	public void print_all_committees() {
		for (int i = 0; i<committees.size(); i++) {
			System.out.println(committees.get(i));
			System.out.println("================================================");
		}
	}

	public void saveSystem() throws IOException{
	    try {
	        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("college.dat"));

	        out.writeObject(this);

	        out.close();

	    } catch (IOException e) {
	        throw e;
	    }
	}
}

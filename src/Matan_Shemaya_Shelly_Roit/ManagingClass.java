package Matan_Shemaya_Shelly_Roit;

import java.util.Arrays;

public class ManagingClass{
	// properties
	private String college_name;
	private Lecturer[] lecturers;
	private Department[] departments;
	private Committee[] committees;

	private int num_of_lecturers;
	private int num_of_departments;
	private int num_of_committees;

	// Constructor
	public ManagingClass(String college_name) {
		this.college_name = college_name;
		
		this.lecturers = new Lecturer[100];
		this.departments = new Department[100];
		this.committees = new Committee[100];
		
		num_of_lecturers = 0;
		num_of_departments = 0;
		num_of_committees = 0;
	}

	@Override
	public String toString() {
		return "College [name=" + college_name + ", committees=" + Arrays.toString(committees)
		+ ", Departments=" + Arrays.toString(departments) + ",  Lecturers=" + Arrays.toString(lecturers) +"]";
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	// methods
	public void addLecturer(String name, int id, Lecturer.Degree lecturer_degree, String degree_name, float salary) throws Exception{
		if (num_of_lecturers == lecturers.length) {
			Lecturer[] lecturers2 = new Lecturer[2 * lecturers.length];
			for (int i = 0; i < this.lecturers.length; i++) {
				lecturers2[i] = this.lecturers[i];
			}
			this.lecturers = lecturers2;
		}

		for (int i = 0; i < num_of_lecturers; i++) {
			if (this.lecturers[i].getName().equals(name)) {
				throw new Exceptions.LecturerAlreadyExist();
			}
		}
		
		try {			
			if (lecturer_degree.equals(Lecturer.Degree.Doctor)) {
				lecturers[num_of_lecturers] = new Doctor(name, id, degree_name, salary);
			} else if (lecturer_degree.equals(Lecturer.Degree.Professor)) {
				lecturers[num_of_lecturers] = new Professor(name, id, degree_name, salary);
			} else {			
				lecturers[num_of_lecturers] = new Lecturer(name, id, lecturer_degree, degree_name, salary);
			}
			num_of_lecturers += 1;
		} catch(Exceptions.IdOutOfRange e) {
			throw e;
		}
	}

	public void addCommittee(String name, String committee_chairman_name) throws Exception{
		if (num_of_committees == committees.length) {
			Committee[] committees2 = new Committee[2 * committees.length];
			for (int i = 0; i < this.committees.length; i++) {
				committees2[i] = this.committees[i];
			}
			this.committees = committees2;
		}
		
		for (int i = 0; i < num_of_committees; i++) {
			if (committees[i].getName().equals(name)) {
				throw new Exceptions.CommitteeAlreadyExist();
			}
		}
		
		for (int i = 0; i < num_of_lecturers; i++) {
			if (lecturers[i].getName().equals(committee_chairman_name) && lecturers[i] instanceof CommitteeHeadable) {
				committees[num_of_committees] = new Committee(name, lecturers[i]);
				lecturers[i].addCommitteeToLecturer(committees[num_of_committees]);
				num_of_committees += 1;
				return;
			}
		}
		
		throw new Exceptions.CantMakeCommitteeChairMan();
	}
	public void addCommittee(Committee committee){
		if (num_of_committees == committees.length) {
			Committee[] committees2 = new Committee[2 * committees.length];
			for (int i = 0; i < this.committees.length; i++) {
				committees2[i] = this.committees[i];
			}
			this.committees = committees2;
		}
		
		committees[num_of_committees] = committee;
	}

	public void add_lecturer_to_committee(String committee_name, String lecturer_name) throws Exception{
		boolean foundCommittee = false;
		boolean foundLecturer = false;
		
		try {
			for (int i = 0; i < num_of_committees; i++) {
				if(committees[i].getName().equals(committee_name)) {					
					foundCommittee = true;
					for (int j = 0; j < num_of_lecturers; j++) {
						if (lecturers[j].getName().equals(lecturer_name)) {
							foundLecturer = true;
							committees[i].addLecturer(lecturers[j]);
							lecturers[j].addCommitteeToLecturer(committees[i]);
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
		for (int i = 0; i<num_of_departments; i++) {
			if(departments[i].getName().equals(name)) {
				throw new Exceptions.DepartmentAlreadyExist();
			}
		}
		if (num_of_departments == departments.length) {
			Department[] departments2 = new Department [2*departments.length];
			for (int i = 0; i<this.departments.length;i++) {
				departments2[i] = this.departments[i];
			}
			this.departments = departments2;
		}
		departments[num_of_departments] = new Department (name,num_of_students);
		num_of_departments+=1;
	}

	public void update_committee_chairman(String committee_name, String new_chairman_name) throws Exception{
		try {
			for (int i = 0; i<num_of_committees; i++) {
				for (int j = 0; j<num_of_lecturers; j++) {
					if (committees[i].getName().equals(committee_name) && lecturers[j].getName().equals(new_chairman_name) && lecturers[j] instanceof CommitteeHeadable){
						committees[i].setCommittee_chairman(lecturers[j]);
						remove_lecturer_from_commmittee(lecturers[j].getName(),committee_name);
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
			for (int i = 0; i<num_of_committees; i++) {
				if(committees[i].getName().equals(committee_name)){
					committees[i].removeLecturer(lecturer_name);
				}
			}			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void AddLecturerToDepartment(String lecturer_name, String department_name) throws Exception{
		Lecturer found_lecturer = null;
		Department found_department = null;
		
		for(int i = 0; i<num_of_lecturers; i++) {
			if (lecturers[i].getName().equals(lecturer_name)) {
				found_lecturer = lecturers[i];
				break;
			}		
		}
		
		for (int i = 0; i<num_of_departments; i++) {
			if (departments[i].getName().equals(department_name)) {
				found_department = departments[i];
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
		for (int i =0; i< num_of_lecturers; ++i) {
			if (lecturers[i].getName().equals(name)) {
				if (lecturers[i].getLecturer_degree().ordinal() < Lecturer.Degree.Doctor.ordinal()) {
					throw new Exceptions.CantMakeDoctor();
					 }
				} else {
					return (Doctor)lecturers[i];
				}
			}
			throw new Exceptions.LecturerDoesntExist();
	}
	
	public Committee get_Commettee(String name) throws Exception{
		for (int i =0; i< num_of_lecturers; ++i) {
			if(committees[i].getName().equals(name)) {
				return committees[i];
			}
		}
		throw new Exceptions.CommitteeDoesntExist();
	}
	
	public double get_lecturers_avg() {
		if(num_of_lecturers == 0) {
			return 0;
		}
		double sum = 0;
		for (int i = 0; i<num_of_lecturers; i++) {
			sum += lecturers[i].getSalary();
		}
		return sum/num_of_lecturers;
	}
	
	public double get_departments_lecturers_avg(String department_name) {
		for (int i = 0; i<num_of_departments; i++) {
			if(departments[i].getName().equals(department_name)) {
				return departments[i].get_lecturers_avg();
			}
		}
		return -1;
	}
	
	public void printAllLecturers() {
		for (int i = 0; i<num_of_lecturers; i++) {
			System.out.println(lecturers[i]);
		}
	}
	
	public void print_all_committees() {
		for (int i = 0; i<num_of_committees; i++) {
			System.out.println(committees[i]);
			System.out.println("================================================");
		}
	}
	}

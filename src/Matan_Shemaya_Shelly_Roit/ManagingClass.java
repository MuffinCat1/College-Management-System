package Matan_Shemaya_Shelly_Roit;

public class ManagingClass {
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

	// methods

	public boolean addLecturer(String name, int id, Lecturer.degree lecturer_degree, String degree_name, float salary) {
		if (num_of_lecturers == lecturers.length) {
			Lecturer[] lecturers2 = new Lecturer[2 * lecturers.length];
			for (int i = 0; i < this.lecturers.length; i++) {
				lecturers2[i] = this.lecturers[i];
			}
			this.lecturers = lecturers2;
		}
		// הגדלת מערך במידה וצריך
		for (int i = 0; i < num_of_lecturers; i++) {
			if (this.lecturers[i].getName().equals(name)) {
				return false;
			}
		}
		/// בדיקה האם השם מופיע
		lecturers[num_of_lecturers] = new Lecturer(name, id, lecturer_degree, degree_name, salary);
		num_of_lecturers += 1;
		// הוספת מרצה
		return true;
	}

	public boolean addCommittee(String name, String committee_chairman_name) {
		if (num_of_committees == committees.length) {
			Committee[] committees2 = new Committee[2 * committees.length];
			for (int i = 0; i < this.committees.length; i++) {
				committees2[i] = this.committees[i];
			}
			this.committees = committees2;
		}
		for (int i = 0; i < num_of_committees; i++) {
			if (committees[i].getName().equals(name)) {
				return false;
			}
		}
		for (int i = 0; i < num_of_lecturers; i++) {
			if (lecturers[i].getName().equals(committee_chairman_name)) {
				if (lecturers[i].getLecturer_degree() == Lecturer.degree.Doctor
						|| lecturers[i].getLecturer_degree() == Lecturer.degree.Professor) {
					committees[num_of_committees] = new Committee(name, lecturers[i]);
					num_of_committees += 1;
					return true;
				}
			}
		}
		return false;
	}

	public boolean add_lecturer_to_committee(String committee_name, String lecturer_name) {
		for (int i = 0; i < num_of_committees; i++) {
			for (int j = 0; j < num_of_lecturers; j++) {
				if (committees[i].getName().equals(committee_name) && lecturers[j].getName().equals(lecturer_name)) {
					return committees[i].addLecturer(lecturers[j]);
				}
			}
		}

		return false;
	}

	public boolean add_department(String name,int num_of_students) {
		for (int i = 0; i<num_of_departments; i++) {
			if(departments[i].getName().equals(name)) {
				return false;
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
		return true;
	}

	public boolean update_committee_chairman(String committee_name, String new_chairman_name) {
		for (int i = 0; i<num_of_committees; i++) {
			for (int j = 0; j<num_of_lecturers; j++) {
			if (committees[i].getName().equals(committee_name) &&
					lecturers[j].getName().equals(new_chairman_name) &&
					(lecturers[j].getLecturer_degree()== Lecturer.degree.Doctor || 
							lecturers[j].getLecturer_degree()== Lecturer.degree.Professor)){
				committees[i].setCommittee_chairman(lecturers[j]);
				remove_lecturer_from_commmittee(lecturers[j].getName(),committee_name);
				return true;
			}
		}
		}
		return false;
	}
	
	public boolean remove_lecturer_from_commmittee(String lecturer_name, String committee_name) {
		for (int i = 0; i<num_of_committees; i++) {
			if(committees[i].getName().equals(committee_name)){
					return committees[i].removeLecturer(lecturer_name);
			}
		}
		return false;
	}
	
	public boolean AddLecturerToDepartment(String lecturer_name, String department_name) {
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
		if(!(found_lecturer == null) && !(found_department == null)) {
			return found_department.AddLecturer(found_lecturer);
		}
		else {
			return false;
		}
		
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
		}
	}
	}

package Matan_Shemaya_Shelly_Roit;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Exceptions {
	public static class LecturerHasDepartment extends Exception implements Serializable{
		public LecturerHasDepartment() {
			super("There is a department assigned to the lecturer already");
		}
	}
	
	public static class LecturerAlreadyExist extends Exception {
		public LecturerAlreadyExist() {
			super("Lecturer already exist");
		}
	}
	
	public static class LecturerDoesntExist extends Exception {
		public LecturerDoesntExist() {
			super("Lecturer doesnt exist");
		}
	}
	
	public static class CommitteeAlreadyExist extends Exception {
		public CommitteeAlreadyExist() {
			super("Committee already exist");
		}
	}
	
	public static class CommitteeDoesntExist extends Exception {
		public CommitteeDoesntExist() {
			super("Committee doesnt exist");
		}
	}
	
	public static class DepartmentAlreadyExist extends Exception {
		public DepartmentAlreadyExist() {
			super("Department already exist");
		}
	}
	
	
	public static class CantMakeCommitteeChairMan extends Exception {
		public CantMakeCommitteeChairMan() {
			super("Cant make the lecturer a committe chairman his degree less then Doctor");
		}
	}
	
	public static class IdOutOfRange extends Exception {
		public IdOutOfRange() {
			super("id is out of range (100000000-999999999)");
										 
		}
	}
	public static class CantMakeDoctor extends Exception {
		public CantMakeDoctor() {
			super("Cant make a doctor with degree less then Doctor");							 
		}
	}
	public static class WrongDegree extends Exception {
		public WrongDegree() {
			super("Cant add lecturer because of wrong degree");							 
		}
	}
}
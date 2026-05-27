//Matan_Shemaya_Shelly_Roit_327777710
package Matan_Shemaya_Shelly_Roit;
import java.util.*;
public class Main {
	public static Scanner s  = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter collage name");
		String college_name = s.nextLine();
		ManagingClass collage = new ManagingClass(college_name);
		boolean f_continue = true;
		while (f_continue) {
			System.out.println("0 to exit");
			System.out.println("1 to add a lecturer to collage");
			System.out.println("2 to add commitee to collage");
			System.out.println("3 to add lecturer to committee");
			System.out.println("4 to update committee chairman");
			System.out.println("5 to remove lecturer from committee");
			System.out.println("6 to add deprtment");
			System.out.println("7 to add lecturer to department");
			System.out.println("8 to show averege of the lecturers in collage");
			System.out.println("9 to show averege of the lecturers in a certain department");
			System.out.println("10 to show details about all lecturers");
			System.out.println("11 to show details about all committees");
			System.out.print("Enter your choice: ");
			int choice = Integer.parseInt(s.nextLine());
			
			switch (choice) {
			case 0:
				f_continue = false;
				break;
			case 1:
				boolean is_added = false;
				while (!is_added) {
				System.out.println("Enter lecturer's name");
				String name = s.nextLine();
				System.out.println("Enter lecturer's id");
				int id = Integer.parseInt(s.nextLine());
				System.out.println("Enter lecturer's degree(First, Second, Doctor, Professor)");
				String degree = s.nextLine();
				Lecturer.degree lecturer_degree = Lecturer.degree.valueOf(degree);
				System.out.println("Enter lecturer's degree");
				String degree_name = s.nextLine();
				System.out.println("Enter lecturer's salary");
				int salary = Integer.parseInt(s.nextLine());
				is_added = collage.addLecturer(name, id, lecturer_degree, 
						degree_name, salary);
				if (is_added){
					System.out.println("Lecturer added successfully");
				}
				else {
					System.out.println("Lecturer exists in the system, adding failed try again");
				}
				}
				break;
			case 2:
				boolean is_added2 = false;
				while (!is_added2) {
				System.out.println("Enter committee name");
				String committee_name = s.nextLine();
				System.out.println("Enter committee chairman");
				String committee_chairman_name = s.nextLine();
				if (collage.addCommittee(committee_name,committee_chairman_name)) {
					System.out.println("Committee added successfully");
					is_added2 = true;
				}
				else {
					System.out.println("Failed to add committee, try again");
				}
				}
				break;
			case 3:
				boolean is_added3 = false;
				while(!is_added3) {
				System.out.println("Enter committee's name");
				String committee_name = s.nextLine();
				System.out.println("Enter Lecturer's name to add");
				String lecturer_name = s.nextLine();
				if(collage.add_lecturer_to_committee(committee_name, lecturer_name)) {
					is_added3 = true;
					System.out.println("Lecturer added to committee successfully");
				}
				else {
					System.out.println("Lecturer/committee not compatible, try again");
				}
				}
				break;
			case 4:
				boolean is_changed = false;
				while(!is_changed) {
					System.out.println("Enter committee name to change");
					String committee_name = s.nextLine();
					System.out.println("Enter new chairman name");
					String new_chairman_name = s.nextLine();
					if (collage.update_committee_chairman(committee_name,new_chairman_name)) {
						System.out.println("Committee chairman updated successfully");
						is_changed = true;
					}
					else {
						System.out.println("Failed to update, try again");
					}
				}
				break;
			case 5:
				boolean removed = false;
				while (!removed) {
					System.out.println("Enter name of committee");
					String committee_name = s.nextLine();
					System.out.println("Enter name of lecturer to remove");
					String lecturer_name = s.nextLine();
					if (collage.remove_lecturer_from_commmittee(lecturer_name,committee_name)) {
						System.out.println("lecturer removed successfully");
						removed = true;
					}
					else {
						System.out.println("Failed to remove, try again");
					}
				}
				break;
			case 6:
				boolean is_added4 = false;
				while(!is_added4) {
					System.out.println("Enter department's name");
					String department_name = s.nextLine();
					System.out.println("Enter number of students in department");
					int num_of_students = Integer.parseInt(s.nextLine());
					if (collage.add_department(department_name,num_of_students)) {
						System.out.println("Department added successfully");
						is_added4 = true;
					}
					else {
						System.out.println("Department in the system, try again");
					}
				}
				break;
			case 7:
				boolean is_added5 = false;
				while(!is_added5){
					System.out.println("Enter department");
					String department_name = s.nextLine();
					System.out.println("Enter lecturer to add");
					String lecturer_name = s.nextLine();
					if (collage.AddLecturerToDepartment(lecturer_name,department_name)) {
						System.out.println("Lecturer added to department successfully");
						is_added5 = true;
					}
					else {
						System.out.println("Adding failed, try again");
					}
				}
				break;
			case 8:
				System.out.println("The lecturers' average is" + collage.get_lecturers_avg());
				break;
			case 9:
				boolean succeed = false;
				while(!succeed) {
					System.out.println("Enter department to check");
					String departmant_name = s.nextLine();
					double result = collage.get_departments_lecturers_avg(departmant_name);
					if (!(result == -1)) {
						System.out.println("The average salary is" + result);
						succeed = true;
					}
					else {
						System.out.println("Department not found, try again");
					}
				}
				break;
			case 10:
				collage.printAllLecturers();
				break;
			case 11:
				collage.print_all_committees();
				break;
			default:
				System.out.println("Wrong input, try again");
			}
			
		}
	}

}

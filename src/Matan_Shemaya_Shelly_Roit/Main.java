//Matan_Shemaya_331582130_Shelly_Roit_327777710
package Matan_Shemaya_Shelly_Roit;

import java.util.*;

public class Main {
	public static Scanner s  = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter college name");
		
		String college_name = s.nextLine();
		ManagingClass college = new ManagingClass(college_name);
		
		boolean f_continue = true;
		
		while (f_continue) {
			System.out.println("0 to exit");
			System.out.println("1 to add a lecturer to college");
			System.out.println("2 to add commitee to college");
			System.out.println("3 to add lecturer to committee");
			System.out.println("4 to update committee chairman");
			System.out.println("5 to remove lecturer from committee");
			System.out.println("6 to add deprtment");
			System.out.println("7 to add lecturer to department");
			System.out.println("8 to show averege salary of the lecturers in college");
			System.out.println("9 to show averege salary of the lecturers in a certain department");
			System.out.println("10 to show details about all lecturers");
			System.out.println("11 to show details about all committees");
			System.out.println("12 to compare Doctors/Professors based on their articles amount");
			System.out.println("13 to compare committees");
			System.out.println("14 to clone a committee");
			System.out.print("Enter your choice: ");
			
			int choice = 0;
			
			try {
				choice = Integer.parseInt(s.nextLine());				
			} catch (NumberFormatException e) {
				System.err.println("Wrong input please try again");
				continue;
			}
			

			switch (choice) {
			
			case 0:
				System.out.println("Goodbye!");
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
					
					Lecturer.Degree lecturer_degree;
					
					try {						
						lecturer_degree = Lecturer.Degree.valueOf(degree);
					} catch(IllegalArgumentException e) {
						System.err.println("wrong input, please try again ");
						is_added = false;
						continue;
					}
					
					System.out.println("Enter lecturer's degree's name");
					String degree_name = s.nextLine();
					
					System.out.println("Enter lecturer's salary");
					int salary = Integer.parseInt(s.nextLine());
					
					try {
						college.addLecturer(name, id, lecturer_degree, degree_name, salary);
						System.out.println("Lecturer added successfully");
						is_added = true;
					}
					catch (Exception e) {
						is_added = false;
						
						if(e instanceof Exceptions.LecturerAlreadyExist) 	
							System.err.println("Lecturer exists in the system, adding failed");
						else if (e instanceof Exceptions.IdOutOfRange) {
							System.err.println("Id is not valid because id is out of range (100000000-999999999)");
						}
						
						
						System.out.println("Would you like to try again? (Y/N) ");
						String choise = s.nextLine();
						
						boolean shouldBreak = false;
						
						while (true) {
							if (choise.equals("N") || choise.equals("n")) {
								shouldBreak = true;
								break;
							}
							else if(choise.equals("Y") || choise.equals("y")) {
								break;
							} else
								System.err.println("wrong input");
							
							System.out.println("Would yous like to try again? (Y/N) ");
							choise = s.nextLine();
						}
						
						if (shouldBreak) break;
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
				
					try { 
						college.addCommittee(committee_name,committee_chairman_name);
						System.out.println("Committee added successfully");
						is_added2 = true;
					}
					catch (Exception e) {
						System.err.printf("Failed to add committee beacuase: %s, try again", e.getMessage());

						System.out.println("\nWould you like to try again? (Y/N) ");
						String choise = s.nextLine();
						
						boolean shouldBreak = false;
						
						while (true) {
							if (choise.equals("N") || choise.equals("n")) {
								shouldBreak = true;
								break;
							}
							else if(choise.equals("Y") || choise.equals("y")) {
								break;
							} else
								System.out.println("wrong input");
							
							System.out.println("\nWould yous like to try again? (Y/N) ");
							choise = s.nextLine();
						}
						
						if (shouldBreak) break;
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
					
					try {
						college.add_lecturer_to_committee(committee_name, lecturer_name);
						is_added3 = true;
						System.out.println("Lecturer added to committee successfully");
					} catch (Exception e) {
						System.err.printf("Cant add lecturer to the commite because: %s, please try again",e.getMessage());
						
						System.out.println("\nWould you like to try again? (Y/N) ");
						String choise = s.nextLine();
						
						boolean shouldBreak = false;
						
						while (true) {
							if (choise.equals("N") || choise.equals("n")) {
								shouldBreak = true;
								break;
							}
							else if(choise.equals("Y") || choise.equals("y")) {
								break;
							} else
								System.out.println("wrong input");
							
							System.out.println("\nWould yous like to try again? (Y/N) ");
							choise = s.nextLine();
						}
						
						if (shouldBreak) break;
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
					
					try {
						college.update_committee_chairman(committee_name,new_chairman_name);
						System.out.println("Committee chairman updated successfully");
						is_changed = true;
					} catch(Exception e) {
						System.err.printf("Failed to update because: %s", e.getMessage());
						
						System.out.println("\nWould you like to try again? (Y/N) ");
						String choise = s.nextLine();
						
						boolean shouldBreak = false;
						
						while (true) {
							if (choise.equals("N") || choise.equals("n")) {
								shouldBreak = true;
								break;
							}
							else if(choise.equals("Y") || choise.equals("y")) {
								break;
							} else
								System.out.println("wrong input");
							
							System.out.println("\nWould yous like to try again? (Y/N) ");
							choise = s.nextLine();
						}
						
						if (shouldBreak) break;
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
					
					try {
						college.remove_lecturer_from_commmittee(lecturer_name,committee_name);
						System.out.println("lecturer removed successfully");
						removed = true;
					} catch (Exception e) {
						if(e instanceof Exceptions.LecturerDoesntExist)
							System.err.printf("Cant remove lecturer to the commite because: %s%n",e.getMessage());
						else
							System.out.println("Failed to remove");
						
						System.out.println("\nWould you like to try again? (Y/N) ");
						String choise = s.nextLine();
						
						boolean shouldBreak = false;
						
						while (true) {
							if (choise.equals("N") || choise.equals("n")) {
								shouldBreak = true;
								break;
							}
							else if(choise.equals("Y") || choise.equals("y")) {
								break;
							} else
								System.out.println("wrong input");
							
							System.out.println("\nWould yous like to try again? (Y/N) ");
							choise = s.nextLine();
						}
						
						if (shouldBreak) break;
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
					
					try {
						college.add_department(department_name,num_of_students);
						System.out.println("Department added successfully");
						is_added4 = true;
					} catch(Exception e) {
						System.err.printf("Couldnt add department because: %s", e.getMessage());
						
						System.out.println("Would you like to try again? (Y/N) ");
						String choise = s.nextLine();
						
						boolean shouldBreak = false;
						
						while (true) {
							if (choise.equals("N") || choise.equals("n")) {
								shouldBreak = true;
								break;
							}
							else if(choise.equals("Y") || choise.equals("y")) {
								break;
							} else
								System.out.println("wrong input");
							
							System.out.println("Would yous like to try again? (Y/N) ");
							choise = s.nextLine();
						}
						
						if (shouldBreak) break;
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
					
					try {
						college.AddLecturerToDepartment(lecturer_name,department_name); 
						System.out.println("Lecturer added to department successfully");
						is_added5 = true;	
					}
					catch (Exception e) {
						System.out.printf("Adding failed because %s, try again%n", e.getMessage());
						
						System.out.println("Would you like to try again? (Y/N) ");
						String choise = s.nextLine();
						
						boolean shouldBreak = false;
						
						while (true) {
							if (choise.equals("N") || choise.equals("n")) {
								shouldBreak = true;
								break;
							}
							else if(choise.equals("Y") || choise.equals("y")) {
								break;
							} else
								System.out.println("wrong input");
							
							System.out.println("Would yous like to try again? (Y/N) ");
							choise = s.nextLine();
						}
						
						if (shouldBreak) break;
					}
				}
				break;
			case 8:
				System.out.println("The lecturers' average salary is " + college.get_lecturers_avg());
				break;
			case 9:
				boolean succeed = false;
				while(!succeed) {
					System.out.println("Enter department to check");
					String departmant_name = s.nextLine();
					
					double result = college.get_departments_lecturers_avg(departmant_name);
					
					if (result != -1) {
						System.out.println("The average salary is " + result);
						succeed = true;
					}
					else {
						System.out.println("Department not found, try again");
						
						System.out.println("Would you like to try again? (Y/N) ");
						String choise = s.nextLine();
						
						boolean shouldBreak = false;
						
						while (true) {
							if (choise.equals("N") || choise.equals("n")) {
								shouldBreak = true;
								break;
							}
							else if(choise.equals("Y") || choise.equals("y")) {
								break;
							} else
								System.out.println("wrong input");
							
							System.out.println("Would yous like to try again? (Y/N) ");
							choise = s.nextLine();
						}
						
						if (shouldBreak) break;
					}
				}
				break;
			case 10:
				college.printAllLecturers();
				break;
			case 11:
				college.print_all_committees();
				break;
			case 12:
				boolean done = false;
				
				while (done != true) {					 
					System.out.println("Enter first doctor/professor name: ");
					String first_name = s.nextLine();
					Doctor first_lecturer = null;
					
					boolean tryAgain = false;
					
					try {
						first_lecturer = college.Get_Doctor(first_name);					
					} catch(Exception e) {
						if (e instanceof Exceptions.CantMakeDoctor) {
							System.err.println("The lecturer you have been searching is not a doctor/professor");
						} else {
							System.err.println("The lecturer you have been searching does not exist");
							
							System.out.println("Would you like to try again? (Y/N) ");
							String choise = s.nextLine();
								
							while (true) {
								if (choise.equals("N") || choise.equals("n")) {
									break;
								}
								else if(choise.equals("Y") || choise.equals("y")) {
									tryAgain = true;
									break;
								} else {
									System.out.println("wrong input");
									
									System.out.println("Would yous like to try again? (Y/N) ");
									choise = s.nextLine();
								}
							}
							if (tryAgain) continue;
							else break;
						}
					}
					
					System.out.println("Enter second doctor/professor name: ");
					String second_name = s.nextLine();
					Doctor second_lecturer = null;
					try {
						second_lecturer = college.Get_Doctor(second_name);					
					} catch(Exception e) {
						if (e instanceof Exceptions.CantMakeDoctor) {
							System.err.println("The lecturer you have been searching is not a doctor/professor");
						} else 
							System.err.println("The lecturer you have been searching does not exist");
												 
						System.out.println("Would you like to try again? (Y/N) ");
						String choise = s.nextLine();
							
						while (true) {
							if (choise.equals("N") || choise.equals("n")) {
								break;
							}
							else if(choise.equals("Y") || choise.equals("y")) {
								tryAgain = true;
								break;
							} else {
								System.out.println("wrong input");
								
								System.out.println("Would yous like to try again? (Y/N) ");
								choise = s.nextLine();
							}
						}
						if (tryAgain) continue;
						else break;
					}
					
					if (first_lecturer.equals(second_lecturer)) {
						System.out.println("both Doctors/Professors have the same amount of articles");
						done = true;
					} else if(first_lecturer.get_Articles().length > second_lecturer.get_Articles().length) {
						System.out.printf("lecturer %s has more articles then %s\n", first_name, second_name);
						done = true;
					} else {
						System.out.printf("lecturer %s has more articles then %s\n", second_name, first_name);
						done = true;
					}
				 }
				break;
			case 13:
				boolean done1 = false;
				
				while (done1 != true) {					 
					System.out.println("Enter first committee name: ");
					String first_name = s.nextLine();
					Committee first_committee = null;
					
					boolean tryAgain = false;
					
					try {
						first_committee = college.get_Commettee(first_name);					
					} catch(Exception e) {
						
						System.err.println("the commetee you have been searching doesnt exist");
							
						System.out.println("Would you like to try again? (Y/N) ");
						String choise = s.nextLine();
							
						while (true) {
							if (choise.equals("N") || choise.equals("n")) {
								break;
							}
								else if(choise.equals("Y") || choise.equals("y")) {
									tryAgain = true;
									break;
								} else {
									System.out.println("wrong input");
									
									System.out.println("Would yous like to try again? (Y/N) ");
									choise = s.nextLine();
								}
							}
							if (tryAgain) continue;
							else break;
						}
					
					
					System.out.println("Enter second committee name: ");
					String second_name = s.nextLine();
					Committee second_committee = null;
					
					try {
						second_committee = college.get_Commettee(second_name);					
					} catch(Exception e) {
						System.err.println("the commetee you have been searching doesnt exist");				 
						
						System.out.println("Would you like to try again? (Y/N) ");
						String choise = s.nextLine();
							
						while (true) {
							if (choise.equals("N") || choise.equals("n")) {
								break;
							}
							else if(choise.equals("Y") || choise.equals("y")) {
								tryAgain = true;
								break;
							} else {
								System.out.println("wrong input");
								
								System.out.println("Would yous like to try again? (Y/N) ");
								choise = s.nextLine();
							}
						}
						if (tryAgain) continue;
						else break;
					}
					
					if(first_committee.equals(second_committee)) {
						System.out.println("Both committees have the same number of lecturers assigned and articles");
						done1 = true;
					} else if (first_committee.getNum_of_lecturers_in_committee() > second_committee.getNum_of_lecturers_in_committee()){
						System.out.println("first committee has more lecturers then second");
						done1 = true;
					} else if(first_committee.getNum_of_lecturers_in_committee() < second_committee.getNum_of_lecturers_in_committee()) {
						System.out.println("second committee has more lecturers then first");
						done1 = true;
					} else if (first_committee.Get_total_articles_in_commitee() > second_committee.Get_total_articles_in_commitee()) {
						System.out.println("first committee has more articles then second");
						done1 = true;
					}else if(first_committee.Get_total_articles_in_commitee() < second_committee.Get_total_articles_in_commitee()) {
						System.out.println("second committee has more articles then first");
						done1 = true;
					}
				}
				break;
			case 14:
				boolean done2 = false;
				
				while (done2 != true) {					 
					System.out.println("Enter committee name to clone: ");
					String name = s.nextLine();
					Committee committee = null;
					
					boolean tryAgain = false;
					
					try {
						committee = college.get_Commettee(name);			
					} catch(Exception e) {
						System.err.println("the commetee you have been searching doesnt exist");
							
						System.out.println("Would you like to try again? (Y/N) ");
						String choise = s.nextLine();
							
						while (true) {
							if (choise.equals("N") || choise.equals("n")) {
								break;
							}
							else if(choise.equals("Y") || choise.equals("y")) {
								tryAgain = true;
								break;
							} else {
								System.out.println("wrong input");
								
								System.out.println("Would yous like to try again? (Y/N) ");
								choise = s.nextLine();
							}
						}
						if (tryAgain) continue;
						else break;
					}
					
					Committee clone = committee;
					clone.setName(committee.getName()+"-new");
					college.addCommittee(clone);
					
					for (int i = 0; i < clone.getNum_of_lecturers_in_committee(); ++i) {
						clone.getLecturers_in_committee()[i].addCommitteeToLecturer(clone);
					}
					
					System.out.println("Cloning was succesfull");
					done2=true;
					
				}
				break;
			default:
				System.err.println("Wrong input, try again");
			}
			
		}
	}
}
package budget;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class

public class Main {

	public static void main(String[] args) throws IOException {
		
		File outFile = new File("expenses.txt");
		double total = 0;

		try(PrintWriter write = new PrintWriter(new FileWriter(outFile, true))){

		
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<ExpenseManager> expenseManager = new ArrayList<ExpenseManager>();
		int index = 0;
		String formattedDate;
		String item;
		double cost;
		int raj1 = 0;
		int raj2 = 0;
		

		
		while(true) {
			
			System.out.print("Enter 1 to write today's expences, enter 2 to find old data, 0 to exit: ");
			int input = scanner.nextInt();
			scanner.nextLine();

			
			if(input == 0) {
				break;
			}
											
				if(input == 1){
					
					LocalDateTime myDateObj = LocalDateTime.now();  
				    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
				    
				    formattedDate = myDateObj.format(myFormatObj);  
				    
					
					
				    System.out.print("Enter 1 to add data in today's date, and 2 to enter data for past dates: ");
					
					
					int input2 = scanner.nextInt();
					scanner.nextLine();
					
						if(input2 == 1) {
					
							int index3 = 0;
							write.println("**************************************************" + "\n");

							write.println("Date: " + formattedDate);
							write.println();
					
					

								while(true) {
						

									System.out.print("Enter the item name (@ to finish this section): ");
									item = scanner.nextLine();
									
									if(item.charAt(0) == '@' || item.charAt(0) == '@') {
										break;
									}
							
									System.out.print("Enter the cost of the item: ");
									cost = scanner.nextDouble();
									scanner.nextLine();
						
									total += cost;
						
											
									int date = 	Integer.parseInt(formattedDate.substring(0,2));
									int month = 	Integer.parseInt(formattedDate.substring(3,5));
									int year = 	Integer.parseInt(formattedDate.substring(6,10));

									ExpenseManager expense = new ExpenseManagerImplementer(item, cost, date, month, year);	
									File outputFile = new File("expenses.txt");


									
						
								write.print(expense.toStringDetails());
							
								}
									
									write.println("\nThe total is: " + total + "\n");
																	
						
					
					index3++;
					index++;


				}else if(input2 == 2) {
					
					total = 0;
					System.out.print("Enter the month date year (Format: MM DD YYYY) (separated by spaces): ");

					int month = scanner.nextInt();
					int date = scanner.nextInt();
					int year = scanner.nextInt();
					scanner.nextLine();
					
					
					while(true) {
						
						

					
					System.out.print("Enter the item name (@ to finish this section): ");
					item = scanner.nextLine();
					
					if(item.charAt(0) == '@' || item.charAt(0) == '@') {
						break;
					}
				
					System.out.print("Enter the cost of the item: ");
					cost = scanner.nextDouble();
					scanner.nextLine();
					
					total += cost;
				
					
					ExpenseManager expense = new ExpenseManagerImplementer(item, cost, date, month, year);	
					File outputFile = new File("expenses.txt");

				//	write.println("The total is: " + total + "\n");

				//	write.println("**************************************************" + "\n");
					write.println("**************************************************" + "\n");

					write.printf("Date: " + "%02d/%02d/%d%n", month, date, year);
					write.println();

					write.print(expense.toStringDetails());
					if(raj2 == 0) {
						
						write.println("\nThe total is: " + total + "\n");
						raj1 = 1;
								
						}

				}
				}
				
					
					

			}else if (input == 2) {
				 outFile = new File("expenses.txt");

					System.out.print("Enter the month date year (Format: MM DD YYYY) (separated by spaces): ");
					
				int searchMonth = scanner.nextInt();
				int searchDate = scanner.nextInt();
				int searchYear = scanner.nextInt();
				scanner.nextLine();
				
			
				
				
				searchInFile(outFile, searchMonth, searchDate, searchYear);
			}
			

				
	}
		
		} catch (FileNotFoundException e) {
			
			
			System.out.println("The file does not exist" + e.getMessage());
		}
	}
	
	
	

	private static void searchInFile(File file, int searchMonth, int searchDate, int searchYear) {
	    String searchFormattedDate = String.format("%02d/%02d/%d", searchMonth, searchDate, searchYear);
	    
	    try (Scanner fileScanner = new Scanner(file)) {
	        boolean found = false;
	        boolean printing = false;

	        while (fileScanner.hasNextLine()) {
	            String line = fileScanner.nextLine();
	            
	            // Check if the line contains the date
	            if (line.contains("Date: " + searchFormattedDate)) {
	                if (found) {
	                    // End of previous found section
	                    System.out.println("******************************************************");
	                }
	                found = true;
	                printing = true;
	                System.out.println("Found the following items for " + searchFormattedDate + ":");
	            } else if (line.startsWith("Date: ")) {
	                // New date found; stop printing if another date section is encountered
	                printing = false;
	            } else if (printing) {
	                // Print lines if we are in the correct date section
	                System.out.println(line);
	            }
	        }

	        if (!found) {
	            System.out.println("No data found for " + "Date: " + searchFormattedDate);
	        }

	    } catch (FileNotFoundException e) {
	        System.out.println("Error reading the file: " + e.getMessage());
	    }
	}
	
}


	
	
	
	

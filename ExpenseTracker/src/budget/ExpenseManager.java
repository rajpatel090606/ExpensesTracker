package budget;

interface ExpenseManager {
	
	
	void setItem(String item);
	String getItem();
	
	void setCost(double cost);
	double getCost();
	
	void setDate(int date);
	int getDate();
	
	void setMonth(int month);
	int getMonth();
	
	void setYear(int year);
	int getYear();
	
	String toStringDate();
	String toStringDetails();
	


	
	
	
	

}

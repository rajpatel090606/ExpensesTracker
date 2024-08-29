package budget;

class ExpenseManagerImplementer implements ExpenseManager{
	
	
	private String item;
	private double cost;
	private int date;
	private int month;
	private int year;
	
	
	public ExpenseManagerImplementer() {
		
		
	}
	
	
	public ExpenseManagerImplementer(String item, double cost, int date, int month, int year) {
		this.item = item;
		this.cost = cost;
		this.date = date;
		this.month = month;
		this.year = year;

	}
	
	public void setItem(String item) {
		this.item = item;
	}
	
	public String getItem() {
		return item;
	}
	
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getCost() {
		return cost;
	}
	
	

	
	public void setMonth(int month) {
		this.month = month;
	}
	public int getMonth() {
		return month;
	}
	
	public void setDate(int date) {
		this.date = date;
	}
	public int getDate() {
		return date;
	}
	
	
	public void setYear(int year) {
		this.year = year;
	}
	public int getYear() {
		return year;
	}
	
	
	public String toStringDate() {
		return "Date: " + date + "/" + month + "/" + year + "\n" ;
		
	
	}
		public String toStringDetails() {
			return String.format("%-5s%-10s%10s$%1f%n", "Item: ", item, "cost: ", cost) ;

		 
	 }
		
		

}

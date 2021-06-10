package com;

/**
 * EmpWageMultipleCompanies is a class of public type
 * @author rekha
 *Initializing two static variable
 */

 class EmployeeWageComputation 
{		
	public final static int FULL_DAY = 1;
	public final static int HALF_DAY = 2;
	
	private final String COMPANY_NAME ;
	private final int WAGE_PER_HOUR ;
	private int workDays ;
	private final int MAX_HOURS;
	public int totalSallary;
	
	/**
	 * Created a parameterize constructor of Company employee wage 
	 * @param company , empRatePerHour , numOfWorkingDays , maxHoursPerMonth as argument
	 */
	
	public EmployeeWageComputation(String companyName , int WagePerHour , int workDays , int MaxHours)
	{
		this.COMPANY_NAME = companyName;
		this.WAGE_PER_HOUR = WagePerHour;
		this.workDays = workDays;
		this.MAX_HOURS = MaxHours;
	}
	
	/**
	 * creating calculateEmpWage method to calculate the employee wage
	 * Here we are Calculating employee wage
	 * using random function to generate 0 to2 random numbers
	 * Here we are calculating total working days, total employee hour and total salary of employee
	 *Returning total Salary of employee
	 */
		
		public double calculateEmpWage() 
		{
			int workHours = 0 ,empHours = 0 ;
			int TotalWorkDays = 0;
			while(workHours <= MAX_HOURS && TotalWorkDays <= workDays)
			{
				workDays++ ;	
				int attendance = (int) Math.floor(Math.random() * 10) % 3; 
				switch (attendance)
				{
					case FULL_DAY: 
						empHours = 8;
					break;
					case HALF_DAY: 
						empHours = 4;
					break;
					default: 
						empHours = 0;
				}
				workHours += empHours;
			
			}
			System.out.println("Total working days : " + workDays +  "  Total working hours : " + workHours );
			int totalSalary = ( WAGE_PER_HOUR * workHours);
			return totalSalary;
		}
		
		/**
		 * Printing Welcome statement
		 * passing the days of 2 companies by providing company total working days, total working hours in a day , and salary per hour 
		 * to calculate the employee total wage.
		 *
		 */
		
		
		public static void main(String[] args)
		{
			System.out.println("Welcome in employee wage");
			
			EmployeeWageComputation Honda = new EmployeeWageComputation("Honda", 50, 7, 10);
			EmployeeWageComputation Relience = new EmployeeWageComputation("Relience", 50, 6, 10);
			double salaryHonda = Honda.calculateEmpWage();
			System.out.println("Employe Wage of honda is : " +salaryHonda);
			double salaryRelience =Relience.calculateEmpWage();
			System.out.println("Employe Wage of relience is : " +salaryRelience);
		}
}
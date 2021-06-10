package com;

/**
 * @author rekha
 *Variables Declaration
 */
public class EmployeeWageComputation
{
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;
	public static final int HOURS_PER_DAY = 8;
	public static final int WAGE_PER_HR = 20;
	public static final int Total_Working_DAYS_For_MONTH = 20;
	public static final int MAX_HRS_IN_MONTH = 100;
	private static final int TOTAL_WORKING_DAYS_FOR_MONTHS = 20;
	
	/**
	 * In while condition checking total working hours or days is reached for
        a month - by assuming 100 hours and 20 days
	 * Generating 0 to 3 random numbers using random function,
     * checking and displaying if employee is part time present or
         full time present or absent using switch case.
     * Calculating employee total employee wage 
     * Returning total totalEmpWage
     */
	
	public static int maxWage() 
	{
		int hrsPerDay = 0;
		int totalEmpHrs = 0, totalWorkingDays = 0;
		
		while (totalEmpHrs <= MAX_HRS_IN_MONTH && 
				totalWorkingDays < TOTAL_WORKING_DAYS_FOR_MONTHS)
		{
				totalWorkingDays++;

   		int random=(int)Math.floor(Math.random()*10) % 3;
   		
   		switch(random) 
   		{

   		case IS_FULL_TIME:
				  hrsPerDay = 8;
				  System.out.println("Employee is Present");
	
        		  		break;
   
   		case IS_PART_TIME:
				  hrsPerDay = 4;
				  System.out.println("Emloyee is Part time Present");
         
          		break;

   		default:
			hrsPerDay = 0;
			System.out.println("Employee is absent");
          		break;
		}
		totalEmpHrs += hrsPerDay; 
		System.out.println("Day#: " + totalWorkingDays + "EmpHr: " + hrsPerDay);
		}   		
		int totalEmpWage = totalEmpHrs * WAGE_PER_HR;
		return totalEmpWage;
	} 
	
	/**
     * calling maxWage method and printing or returning its result(totalEmpWage)
     */
	
	
	public static void main(String[] args)
	{
	System.out.println("The employer total daily wage is " +maxWage());
	}
}
package com;

public class EmployeeWageComputation 
{
		  public static final int IS_ABSENT = 0;
		  public static final int IS_PRESENT = 1;
		  public static final int EMP_RATE_PER_HOUR = 20;
		  public static final int FULL_DAY_HOUR = 8;
		  public static int salary = 0;
		  
	        /**
	        * generating random number 0 or 1
	        * checking and displaying if employee is present or absent
	        * Calculating employee day salary
	        */  
		  
		  public static int computeEmpWage() 
		  {
			  int emp_Check = (int)  Math.floor(Math.random() * 10) % 2;
			  
			  switch(emp_Check)
			  {
			     case IS_PRESENT:System.out.println("Employee is present and his salary is:");
			                   salary = EMP_RATE_PER_HOUR * FULL_DAY_HOUR;
			                   break;
			     case IS_ABSENT:System.out.println("Employee is absent");
			          	   break;
			  }
			  return salary;
		 }
		  
		  /**
			 * Calling and printing function computeEmpWage
			 * 
			 */
		  
		 public static void main(String[] args) 
		 {
			 System.out.println(computeEmpWage());
		 }

}
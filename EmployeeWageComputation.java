package com;

public class EmployeeWageComputation 
{
	      
//Constants variables
		  public static final int IS_ABSENT = 0;
		  public static final int IS_PRESENT = 1;
		  
		  /**
		 * generating random number 0 or 1
		 * checking and displaying if employee is present or absent
		 */
		public static void present() 
		  {
			  int emp_Check = (int) Math.floor(Math.random() * 10 ) % 2;
			  switch(emp_Check)
			  {
			     case IS_ABSENT:System.out.println("Employee is absent");
			                  break;
			     case IS_PRESENT:System.out.println("Employee is present");
			                  break;
		   }
	
		}
		  
		/**
		 * Calling function present
		 * @params args
		 */
		
		public static void main(String[] args) 
		
		{
				System.out.println("Welcome to Employee Wage Computation Problems");	
		present();
		}
	}

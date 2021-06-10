package com;

public class EmployeeWageComputation 

{
	public static int parttime()
	{
		System.out.println("Welcome to the Employee Wage Computation problem");
		
		int emp_Check=1;
		int part_time = 2;
		int wagePerHour=20;
    
   		int fullDayHour=8;

		int partDayHour=4;

       		int  salary=0;
     
    		double random=Math.floor(Math.random()*10) % 3;
    		
    		/**
    	        * checking and displaying if employee is part time present or
    	            full time present or absent
    	        * Calculating employee day salary
    	        * returning salary
    	        */  

   		if(random==emp_Check)
   		{

   			System.out.println("Employee is full time present");

			salary=wagePerHour*fullDayHour;
        
        		System.out.println("Employee is present and his salary is "+salary);
   		}
   		else if(random == part_time)
   		{

    			System.out.println("Employee is part time present");
			salary=wagePerHour*partDayHour;
        
        		System.out.println(" Employee is part time present and his salary is " +salary);
		}
		else
		{

			System.out.println(" Employee is absent " +salary);

		}
		return salary;

	}
	/**
	 * Calling and printing parttime function
	 * 
	 */
	public static void main(String[] args)
	{
		System.out.println(parttime());
	}
}
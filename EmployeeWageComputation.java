package com;

import java.util.Scanner;

/**
 * Declaration
 * Checking the condition working hours is less then or equal to max hours
 * checking the condition working days is less then or equal to total working days 
 * Generating 3 integer random numbers
 * Calculating attendance and returning working hours
 */
public class EmployeeWageComputation
{
    
	public String CompanyName;
	public int maxHours;
	public int wagePerHour;
	public int fullWorkingHour;
	public int halfWorkingHour;
	public int totalWorkingDays=0;
	public EmployeeWageComputation()
	{
		this.CompanyName="";
		this.maxHours= 0;
		this.wagePerHour= 0;
		this.fullWorkingHour= 0;
		this.halfWorkingHour= 0;
		this.totalWorkingDays= 0;
	}
public int Attendance(int MaxHours , int TotalWorkingDays,int FullWorkingHour,int HalfWaorkingHour) 
{
		int workingDays=0;
		int workingHours=0;
		while(workingHours <= MaxHours && workingDays <= TotalWorkingDays)
		{
			workingDays++ ;
			int attendance = (int) Math.floor(Math.random() * 10) % 3; 
			switch (attendance)
			{
			case 1: 
				workingHours=workingHours+FullWorkingHour;
			break;
			case 2: 
				workingHours=workingHours+halfWorkingHour;
				break;
			case 3: 
				workingHours = workingHours+0;
			}
			System.out.println("Total Working hours :");
			System.out.println (workingHours);
		}
		return workingHours;
}

/**
 * writing CalculateWages Method
 *calculating and displaying total salary of employee
 */

public void CalculateWages (int WagePerHour, int workingHours) 
{
	int totalSalary = ( WagePerHour * workingHours);
	System.out.println("Total Wages of the employee :");
	System.out.println (totalSalary);
}

/**
 * creating EmployeeWageComputation object
 * asking user to enter desired company details - name, Full Working hour, Maximum working hour
 * Wage per hour, total working days
 */

public static void main(String[] args) {
	EmployeeWageComputation emp = new EmployeeWageComputation();
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the company Name :");
	emp.CompanyName=scan.nextLine();
	scan.nextLine();	
	System.out.println("Enter the Full Working hour :");
	emp.fullWorkingHour=scan.nextInt();
	System.out.println("Enter the half Working hour :");
	emp.halfWorkingHour=scan.nextInt();
	System.out.println("Enter the Maximum working hour :");
	emp.maxHours=scan.nextInt();
	System.out.println("Enter the Wage per hour :");
	emp.wagePerHour=scan.nextInt();
	System.out.println("Enter the total working days :");
	emp.totalWorkingDays=scan.nextInt();	
	int totalworkinghours=emp.Attendance(emp.maxHours,emp.totalWorkingDays,emp.fullWorkingHour,emp.halfWorkingHour);
	emp.CalculateWages(emp.wagePerHour,totalworkinghours);
	}
}
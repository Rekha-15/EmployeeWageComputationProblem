package com;

import java.util.Scanner;

public class EmployeeWageComputation 
{		
	public final static int fullday = 1;
	public final static int halfday = 2;
	
		public static int Attendance(String companyName , int MaxHours , int WagePerHour,int TotalWorkDays ) 
		{
			int workHours = 0 ,empHours = 0 ,workDays = 0;
			while(workHours <= MaxHours && workDays <= TotalWorkDays)
			{
				workDays++ ;	
				int attendance = (int) Math.floor(Math.random() * 10) % 3; 
				switch (attendance)
				{
					case fullday: 
						empHours = 8;
					break;
					case halfday: 
						empHours = 4;
					break;
					default: 
						empHours = 0;
				}
				workHours += empHours;
			
			}
			System.out.println("Total working days" + workDays + "Total working hours" + workHours );
			int totalSalary = ( WagePerHour * workHours);
			System.out.println("Total Wages of the employee :" +totalSalary);
			return totalSalary;
		}
		public static void main(String[] args)
		{
			System.out.println("Welcome in employee wage");
			
			Attendance("Honda", 50, 7, 10);
			Attendance("Relience", 50, 6, 10);
		}
}
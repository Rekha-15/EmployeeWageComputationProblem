package com;

import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * EmployeeWageComputation is a class of public type
 * Initializing two static variable
 * Implementing IEmpWageBuilder
 */

public class EmployeeWageComputation implements IEmpWageBuilder
{	
	public static final int IS_PART_TIME = 1 ;
	public static final int IS_FULL_TIME = 2;
	private int numOfCompany = 0;
	private LinkedList<CompanyEmpwage> companyEmpWageList;
	private Map<String,CompanyEmpwage> companyToEmpWageMap;
	
/**
 * EmployeeWageComputation is a constructor of public class
 * Initializing an array of CompanyEmpWage  
 * @return 
 */
	public EmployeeWageComputation()
	{
		companyEmpWageList = new LinkedList<>();
		companyToEmpWageMap = new HashMap<>();
	}

	/**
	 * computeEmpWage is a function which is use to calculate the employee wage .
	 * function is void type which returns nothing .	
	 */
	
	public void computeEmpWage() 
	{
		for (int i = 0; i < companyEmpWageList.size(); i++)
		{
			CompanyEmpwage companyEmpWage = companyEmpWageList.get(i);
			companyEmpWage.setTotalEmpwage(this.computeEmpwage(companyEmpWage));
			System.out.println(companyEmpWage);	
		}
	}
	
	/**
	 *  using here the method overloading because using the same name of the method with different parameter. 
	 *  Here we are calculating total working days and total employee hour.
	 * @param companyEmpwage is a argument .
	 * @return integer  value .
	 */
	
	private int computeEmpwage(CompanyEmpwage companyEmpwage) 
	{
		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;

		while (totalEmpHrs < companyEmpwage.MAX_HOURS_PER_MONTH && totalWorkingDays<companyEmpwage.NUM_OF_WORKING_DAYS) 
		{
			totalWorkingDays++;
			int empCheck = (int) Math.floor(Math.random() * 10) %3;
			switch (empCheck) 
			{
				case IS_PART_TIME:
					empHrs = 4;
				break;
				case IS_FULL_TIME:
					empHrs = 8;
				break;
				default:
					empHrs = 0;
			}
				totalEmpHrs += empHrs;
				System.out.println("Total working Days : " +totalWorkingDays+   " Total Employee Hour : "+empHrs);
		}
		return totalEmpHrs * companyEmpwage.EMP_RATE_PER_HOUR;	
	}
	
	/**
	 * This is a main class where we are calling the function . 
	 * passing the data of companies to calculate the employee wage.
	 * @param args
	 */
	
	public static void main(String[] args) 
	{
		IEmpWageBuilder empWageBuilder = new EmployeeWageComputation();
		empWageBuilder.addCompanyEmpWage("Dmart",20,2,24);
		empWageBuilder.computeEmpWage();
		System.out.println("Total Wage for Dmart Company : " + empWageBuilder.getTotalWage1("Dmart"));
	}
	
	/**
	 * addCompanyEmpWage is a a function of private type
	 * @param company , empRatePerHour , numorworkingDays , maxHoursPerMonth as a argument
	 * created a array of companyEmpWage which stores the number of company 
	 * cling the constructor of company employee wage 
	 */
		
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) 
	{
		
		CompanyEmpwage companyEmpWage= new CompanyEmpwage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);
		companyEmpWageList.add(companyEmpWage);
		companyToEmpWageMap.put(company,companyEmpWage);
	}

	
	public int getTotalWage1(String company)
	{
		
		return companyToEmpWageMap.get(company).totalEmpwage;
	}
	
	
	
}

/**
 * created a another class of Company Employee Wage
 * taken some variable as a final which will never change.
 *
 */

class CompanyEmpwage
{
	public final String COMPANNY;
	public final int EMP_RATE_PER_HOUR;
	public final int NUM_OF_WORKING_DAYS;
	public final int MAX_HOURS_PER_MONTH;
	public int totalEmpwage;
/**
 * Created a parameterize constructor of Company employee wage 
 * @param company , empRatePerHour , numOfWorkingDays , maxHoursPerMonth as argument
 */
	public CompanyEmpwage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth)
	{
		this.COMPANNY = company;
		this.EMP_RATE_PER_HOUR = empRatePerHour;
		this.NUM_OF_WORKING_DAYS = numOfWorkingDays;
		this.MAX_HOURS_PER_MONTH = maxHoursPerMonth;
	}
	
	/**
	 * Created a seater of total employee wage use to set the value of totalEmpwage
	 * @param totalEmpwage as a argument.
	 */
	
	public void setTotalEmpwage(int totalEmpwage) 
	{
		this.totalEmpwage = totalEmpwage;
	}	
	public String toString()
	{
		return "Total Emp Wage for Company:" +COMPANNY+ " is :" + totalEmpwage;
	}
}

package com;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

interface IEmpWageBuilder
{
	public void addCompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth);
	public void computeEmpWage();
	public int getTotalWage1(String company);
}


/**
 * EmployeeWageComputation is a class of public type
 * Initializing two static variable
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

		while (totalEmpHrs < companyEmpwage.maxHoursPerMonth && totalWorkingDays<companyEmpwage.numOfWorkingDays) 
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
				System.out.println("Total working Days : " +totalWorkingDays+   " Total Employee Hour : "+empHrs+ " Day Wage : " +empHrs*companyEmpwage.empRatePerHour  );
		}
		return totalEmpHrs * companyEmpwage.empRatePerHour;	
	}
	
	/**
	 * This is a main class where we are calling the function . 
	 * passing the data of 2 companies to calculate the employee wage.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		IEmpWageBuilder empWageBuilder = new EmployeeWageComputation();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter company name");
		String company = input.nextLine();
		System.out.println("Enter Employee wage per hours");
		int wage=input.nextInt();
		System.out.println("Enter Maximum working hours");
		int maxhours=input.nextInt();
		System.out.println("Enter Working days");
		int maxdays=input.nextInt();
		empWageBuilder.addCompanyEmpWage(company,wage,maxdays,maxhours);
		empWageBuilder.computeEmpWage();
		System.out.println("Total Wage for Dmart Company : " + empWageBuilder.getTotalWage1("Dmart"));
	}
	
	/**
	 * addCompanyEmpWage is a a function of private type
	 * @param company , empRatePerHour , numorworkingDays , maxHoursPerMonth as a argument
	 * created a array of companyEmpWage which stores the number of company 
	 * cling the constructor of company employewage 
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

/**
 * created a another class of Company Employee Wage
 * taken some variable as a final which will never change.
 *
 */

class CompanyEmpwage
{
	public final String company;
	public final int empRatePerHour;
	public final int numOfWorkingDays;
	public final int maxHoursPerMonth;
	public int totalEmpwage;
/**
 * Created a parameterize constructor of Company employee wage 
 * @param company , empRatePerHour , numOfWorkingDays , maxHoursPerMonth as argument
 */
	public CompanyEmpwage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth)
	{
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
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
		return "Total Emp Wage for Company:" +company+ " is :" + totalEmpwage;
	}
}
}
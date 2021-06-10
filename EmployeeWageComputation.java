package com;

import java.util.ArrayList;
import java.util.List;
/**
 * EmployeeWageComputation  is a class of public type
 * Initializing two static variable
 */
public class EmployeeWageComputation 
{	
	public static final int IS_PART_TIME = 1 ;
	public static final int IS_FULL_TIME = 2;

	private int numOfCompany = 0;
	private CompanyEmpwage[] companyEmpwageArray;
/**
 * EmployeeWageComputation  is a constructor of public class
 * Initializing an array of CompanyEmpWage  
 */
	public EmployeeWageComputation()
	{
		companyEmpwageArray = new CompanyEmpwage[5];
	}
/**
 * addCompanyEmpWage is a a function of private type
 * @param company , empRatePerHour , numorworkingDays , maxHoursPerMonth as a argument
 * created a array of companyEmpWage which stores the number of company 
 * calling the constructor of company employewage 
 */
	private void addCompanyEmpwage(String company, int empRatePerHour,int numorworkingDays, int maxHoursPerMonth) 
	{
		companyEmpwageArray[numOfCompany] = new CompanyEmpwage(company,empRatePerHour,numorworkingDays,maxHoursPerMonth);
		numOfCompany++;
	}
	/**
	 * computeEmpWage is a function which is use to calculate the employee wage .
	 * function is void type which returns nothing .	
	 */
	private void computeEmpWage() 
	{
		for (int i = 0; i < numOfCompany; i++)
		{
			companyEmpwageArray[i].setTotalEmpwage(this.computeEmpwage(companyEmpwageArray[i]));
			System.out.println(companyEmpwageArray[i]);	
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
				System.out.println("Total working Days : " +totalWorkingDays+   " Total Employee Hour : "+empHrs );
		}
		return totalEmpHrs * companyEmpwage.empRatePerHour;	
	}
	/**
	 * This is a main class where we are calling the function . 
	 * EmployeeWageComputation is a class in that crating new object empWageBuilder
	 * passing the daya of 2 companies to calculate the employee wage.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		EmployeeWageComputation empWageBuilder = new EmployeeWageComputation();

		empWageBuilder.addCompanyEmpwage("DMart", 28, 10, 10); 
		empWageBuilder.addCompanyEmpwage("Reliance", 18, 8, 20);

		empWageBuilder.computeEmpWage();
	}
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
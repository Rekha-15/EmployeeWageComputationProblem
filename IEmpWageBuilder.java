package com;

public interface IEmpWageBuilder 
{
	public void addCompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth);
	public void computeEmpWage();
	public int getTotalWage1(String company);

}

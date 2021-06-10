package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * company is class of public type
 * @author rekha
 *
 */

class CompanyInfo
{
    // VARIABLES
    public final String company;
    public final int WAGE_PER_HOUR;
    public final int WORKING_DAYS_PER_MONTH;
    public final int MAX_WORKING_HRS;
    private int totalWage;
    public ArrayList<Integer> dailyWage;

    public CompanyInfo(String company, int wage_per_hr, int working_days_per_month, int max_working_hrs)
    {
        this.company = company;
        this.WAGE_PER_HOUR = wage_per_hr;
        this.WORKING_DAYS_PER_MONTH = working_days_per_month;
        this.MAX_WORKING_HRS = max_working_hrs;
    }

    public void setTotalWage(int totalWage)
    {
        this.totalWage = totalWage;
    }

    public void setDailyWage(ArrayList<Integer> daily_wage)
    {
        this.dailyWage = daily_wage;
    }

    public ArrayList<Integer> getDailyWages()
    {
        return dailyWage;
    }

    public int getTotalWage()
    {
        return totalWage;
    }

    public String toString()
    {
        System.out.println("Company: "+company);
        return "DailyWage: "+dailyWage+"\n"+"Total Wage: "+totalWage;
    }
}

/**
 * EmployeeWageComputation is a class of public type
 * Initializing two static variable
 * Implementing IEmpWageBuilder
 */

//MAIN CLASS


public class EmployeeWageComputation implements IEmpWageBuilder
    // CONSTANTS
{
    public final int IS_PRESENT = 1;
    public final int IS_FULL_TIME = 1;

    ArrayList<CompanyInfo> totalWageofDiffEmp = new ArrayList<CompanyInfo>();;

    //Object for Company Info method
    CompanyInfo wcc;

    public void company(String company, int wage_per_hr, int working_days_per_month, int max_working_hrs)
    {
        //Adding details to the array list (array list of type 'CompanyInfo')
        wcc = new CompanyInfo(company, wage_per_hr, working_days_per_month, max_working_hrs);

        totalWageofDiffEmp.add(wcc);

        CompanyInfo cI;

        ArrayList<Integer> al2;

        
        
        //calling calculator method for every company
        for(int i=0;i<totalWageofDiffEmp.size();i++)
        {
            cI = totalWageofDiffEmp.get(0);

            al2 = wageCalculator(cI);
            int totalWage = al2.get(al2.size()-1);
            wcc.setDailyWage(al2);
            wcc.setTotalWage(totalWage);
            //map.put(company, totalWage);//<-----------NULL POINTER EXCEPTION*

            System.out.println(cI);
        }
    }

    // WAGE CALCULATOR
    public ArrayList<Integer> wageCalculator(CompanyInfo cI)
    {
        // VARIABLES
        int checkPresence;
        int checkEmpType;
        int empDailyWage = 0;
        int dayOfMonth = 0;
        int totalWage;
        int workingHrs = 0;
        int totalWorkedHrs = 0;

        //array-list
        ArrayList<Integer> al1 = new ArrayList<Integer>();

        // Wage calculation
        while (dayOfMonth <= cI.WORKING_DAYS_PER_MONTH && totalWorkedHrs <= cI.MAX_WORKING_HRS)
        {
            checkPresence = (int) (Math.random() * 10) % 2; // Presence check
            checkEmpType = (int) (Math.random() * 10) % 2; // Work Type check
            dayOfMonth++;
            switch (checkPresence)
            {
                case IS_PRESENT:
                    switch (checkEmpType)
                    {
                        case IS_FULL_TIME:
                            workingHrs = 8;
                            totalWorkedHrs += workingHrs;
                            break;
                        default:
                            workingHrs = 4;
                            totalWorkedHrs += workingHrs;
                    }
                    break;
                default:
                    totalWorkedHrs += 0;
            }

            empDailyWage = cI.WAGE_PER_HOUR * workingHrs;
            al1.add(empDailyWage);

            totalWage = (cI.WAGE_PER_HOUR * totalWorkedHrs);

            al1.add(totalWage);

        }
        return al1;
    }
    
    /**
     * Main method
     * @author rekha
     *EmployeeWageComputation is a class here created company1 and company2 objects  
     */

    public static void main(String[] args)
    {
        EmployeeWageComputation company1 = new EmployeeWageComputation();
        EmployeeWageComputation company2 = new EmployeeWageComputation();

        company1.company("company1",20, 20, 100);
        company2.company("company2",25, 15, 150);
        
    }
}
package com.bridgelabz.fourtyuc3anduc4;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.management.JMException;
public class EmployeeOperation<Employee> {
   
    
	private static EmployeeOperation employeeOperation;
    public static <employee_list, Employee> List<Employee> getEmployee_list()
    {
		return null;
    }
    
 
	


    public List<Employee> readData(Connection con) throws JMException, SQLException {

        try {
            String query = "select * from employee_payroll";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                char gender = rs.getString(3).charAt(0);
                double salary = rs.getDouble(4);
                String date = rs.getString(5);
                String isActive = rs.getString(6);

                System.out.print("\nID: " + id);
                System.out.print("\nName: " + name);
                System.out.print("\nGender: " + gender);
                System.out.print("\nSalary: " + salary);
                System.out.print("\nDate: " + date);
                System.out.println("\nActive: " + isActive);
            }                
  
    public int insertDataToEmployeeDB(Connection con, String name, char gender, double salary, String date, String dept) throws SQLException {
        int result_query1 = -1, result_query2 = -1,result_query3 = -1, result = 0;
        int id = 0;
        Employee emp = null;
        try {
       
      
            con.setAutoCommit(false);
            String query = String.format("Insert into employee_payroll (Name,Gender,Salary,StartDate, Is_Active) values " +
                    "('%s', '%s', '%s', '%s','%s')", name, gender, salary, date, "Yes");
            Statement stmt = con.createStatement();
            result_query1 = stmt.executeUpdate(query, stmt.RETURN_GENERATED_KEYS);
            if (result_query1 == 1) {
                ResultSet rs = stmt.getGeneratedKeys();
                while (rs.next()) {
                    id = rs.getInt(1);
               
                }
            }

            double deductions = .2 * salary;
            double taxable_pay = salary - deductions;
            double income_tax = 0.1 * taxable_pay;
            double net_salary = salary - income_tax;
            String query2 = String.format("Insert into payroll_details (Id, basic_pay, deductions, taxable_pay, income_tax, netPay)" +
                    " values ('%s', '%s', '%s', '%s', '%s', '%s')", id, salary, deductions, taxable_pay, income_tax, net_salary);
            result_query2 = stmt.executeUpdate(query2, stmt.RETURN_GENERATED_KEYS);

            if (result_query1 == 1 && result_query2 == 2) {
                con.commit();
                EmployeeOperation.getEmployee_list().add(emp);
            }

            String query3 = String.format("Insert into department (Id, dept)" + "values ('%s', '%s')", id, dept);
            result_query3 = stmt.executeUpdate(query3, stmt.RETURN_GENERATED_KEYS);

            if (result_query1 == 1 && result_query2 == 1 && result_query3 == 1) {
                con.commit();
                result = 1;
                EmployeeOperation.getEmployee_list().add(emp);
            }
        } catch (SQLException sq) {
            sq.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
        
    }





	public int countNumEntries(Connection con) {
		// TODO Auto-generated method stub
		return 0;
	}
}
        
        
        
        
    


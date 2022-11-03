package AngajatiApp.controller;

import AngajatiApp.model.Employee;
import AngajatiApp.repository.EmployeeMock;
import AngajatiApp.repository.EmployeeRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeControllerTest {
    EmployeeRepositoryInterface employeeRepository = new EmployeeMock();


    @Test
//    toate datele sunt valide
    void addEmployee_TC01() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("Nume");
        employee.setFirstName("Prenume");
        employee.setCnp("1234567891234");
        employee.setFunction(DidacticFunction.LECTURER);
        employee.setSalary(Double.valueOf("1500"));

//        int nr_angajati = employeeRepository.getEmployeeList().size();
        boolean b = employeeRepository.addEmployee(employee);
        assertTrue(b);
    }

    @Test
//    Numele contine si cifre
    void addEmployee_TC02() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("Nume12");
        employee.setFirstName("Prenume");
        employee.setCnp("1234567891234");
        employee.setFunction(DidacticFunction.LECTURER);
        employee.setSalary(Double.valueOf("1500"));

        boolean b = employeeRepository.addEmployee(employee);
        assertTrue(b);
    }


    @Test
//    CNP != 13 char
    void addEmployee_TC03() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("Nume");
        employee.setFirstName("Prenume");
        employee.setCnp("123456");
        employee.setFunction(DidacticFunction.LECTURER);
        employee.setSalary(Double.valueOf("1500"));

        boolean b = employeeRepository.addEmployee(employee);
        assertTrue(b);
    }


    @Test
//    firstNAme are 1 char
    void addEmployee_TC04() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("Nume");
        employee.setFirstName("P");
        employee.setCnp("1234567891234");
        employee.setFunction(DidacticFunction.LECTURER);
        employee.setSalary(Double.valueOf("1500"));

        boolean b = employeeRepository.addEmployee(employee);
        assertTrue(b);
    }

    @Test
//    firstName are 3 char
    void addEmployee_TC05_BVA() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("Nume");
        employee.setFirstName("Pre");
        employee.setCnp("1234567891234");
        employee.setFunction(DidacticFunction.LECTURER);
        employee.setSalary(Double.valueOf("1500"));

        boolean b = employeeRepository.addEmployee(employee);
        assertTrue(b);
    }

    @Test
//   firstName are 14 char
    void addEmployee_TC06_BVA() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("Nume");
        employee.setFirstName("Prenumeeeeeeee");
        employee.setCnp("1234567891234");
        employee.setFunction(DidacticFunction.LECTURER);
        employee.setSalary(Double.valueOf("1500"));

        boolean b = employeeRepository.addEmployee(employee);
        assertTrue(b);
    }

    @Test
//   firstName are 15 char
    void addEmployee_TC07_BVA() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("Nume");
        employee.setFirstName("Prenumeeeeeeeee");
        employee.setCnp("1234567891234");
        employee.setFunction(DidacticFunction.LECTURER);
        employee.setSalary(Double.valueOf("1500"));

        boolean b = employeeRepository.addEmployee(employee);
        assertTrue(b);
    }

    @Test
//   firstName are 16 char
    void addEmployee_TC08_BVA() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("Nume");
        employee.setFirstName("Prenumeeeeeeeeee");
        employee.setCnp("1234567891234");
        employee.setFunction(DidacticFunction.LECTURER);
        employee.setSalary(Double.valueOf("1500"));

        boolean b = employeeRepository.addEmployee(employee);
        assertTrue(b);
    }

    @Test
//    salary == 250
    void addEmployee_TC05_ECP() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("Nume");
        employee.setFirstName("Prenume");
        employee.setCnp("1234567891234");
        employee.setFunction(DidacticFunction.LECTURER);
        employee.setSalary(Double.valueOf("250"));

        boolean b = employeeRepository.addEmployee(employee);
        assertTrue(b);
    }

    @Test
//    salary == 1001
    void addEmployee_TC01_BVA() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("Nume");
        employee.setFirstName("Prenume");
        employee.setCnp("1234567891234");
        employee.setFunction(DidacticFunction.LECTURER);
        employee.setSalary(Double.valueOf("1001"));

        boolean b = employeeRepository.addEmployee(employee);
        assertTrue(b);
    }

    @Test
//    salary == 1000
    void addEmployee_TC02_BVA() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("Nume");
        employee.setFirstName("Prenume");
        employee.setCnp("1234567891234");
        employee.setFunction(DidacticFunction.LECTURER);
        employee.setSalary(Double.valueOf("1000"));

        boolean b = employeeRepository.addEmployee(employee);
        assertTrue(b);
    }


    @Test
//    salary == 999
    void addEmployee_TC03_BVA() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("Nume");
        employee.setFirstName("Prenume");
        employee.setCnp("1234567891234");
        employee.setFunction(DidacticFunction.LECTURER);
        employee.setSalary(Double.valueOf("999"));

        boolean b = employeeRepository.addEmployee(employee);
        assertTrue(b);
    }

    @Test
//    id include litere
    void addEmployee_TC06_ECP() {
        Employee employee = new Employee();
        employee.setId(Integer.parseInt("1abc"));
        employee.setLastName("Nume");
        employee.setFirstName("Prenume");
        employee.setCnp("1234567891234");
        employee.setFunction(DidacticFunction.LECTURER);
        employee.setSalary(Double.valueOf("999"));

        boolean b = employeeRepository.addEmployee(employee);
        assertTrue(b);
    }

}
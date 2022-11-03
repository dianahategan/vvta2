package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest2 {

    EmployeeRepositoryInterface employeeRepository = new EmployeeMock();
    List<Employee> employeeList;

    @BeforeEach
    public void setUp () {
        employeeList = new ArrayList<Employee>();
        employeeList = employeeRepository.getEmployeeList();
    }

    @Test
//    employee != null -> FALSE
//    output, no change
    void modifyEmployeeFunctionTC01() {
        int counter1 = 0;
        int counter2 = 0;

        for (Employee item : employeeList) {
            if (item.getFunction() == DidacticFunction.CONFERENTIAR) {
                counter1++;
            }
        }
        employeeRepository.modifyEmployeeFunction(null, DidacticFunction.CONFERENTIAR);
        for (Employee item : employeeList) {
            if (item.getFunction() == DidacticFunction.CONFERENTIAR) {
                counter1++;
            }
        }
        assertEquals(counter1, counter2);
    }

    @Test
//    employee = employeeList[0]
//    output: function has changed
    void modifyEmployeeFunctionTC02() {
        System.out.println("Initial function: " + employeeList.get(0).getFunction());
        employeeRepository.modifyEmployeeFunction(employeeList.get(0), DidacticFunction.CONFERENTIAR);
        System.out.println("Changed function: " + employeeList.get(0).getFunction());
        assertEquals(DidacticFunction.CONFERENTIAR, employeeList.get(0).getFunction());
    }


    @Test
//    i < employeeList.size() -> FALSE
//    employee id = 8
    void modifyEmployeeFunctionTC0ss1() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            employeeRepository.modifyEmployeeFunction(employeeList.get(8), DidacticFunction.CONFERENTIAR);});
    }
}

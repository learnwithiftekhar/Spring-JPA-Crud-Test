package com.learnwithiftekhar.SpringJPACrudTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository repository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void testSave() {
        Employee employee = new Employee(
                "Iftekhar",
                "learnwithiftekhar@gmail.com",
                LocalDate.of(2024, 1, 3)
        );

        Employee savedEmployee = repository.save(employee);

        assertNotNull(savedEmployee);
    }


    @Test
    @Order(2)
    public void testFindByEmail() {
        Employee employee = repository.findByEmail("learnwithiftekhar@gmail.com").get();
        assertNotNull(employee);
        assertEquals("Iftekhar", employee.getName());
    }

    @Test
    @Order(3)
    public void testFindAll() {
        List<Employee> employeeList = (List<Employee>) repository.findAll();
        assertNotNull(employeeList);
        assertTrue(employeeList.size() > 0);
    }

    @Test
    @Order(4)
    public void testUpdate() {
        Employee e1 = repository.findByEmail("learnwithiftekhar@gmail.com").get();

        //testEM.persistAndFlush(b1);
        repository.save(e1);

        // update update Name
        e1.setName("Hossain");

        // update
        repository.save(e1);

        Employee result = repository.findByEmail("learnwithiftekhar@gmail.com").get();

        assertEquals("Hossain", result.getName());
    }

    @Test
    @Order(5)
    public void testDelete() {
        Employee isExistBeforeDelete = repository.findByEmail("learnwithiftekhar@gmail.com").get();
        assertNotNull(isExistBeforeDelete);

        repository.delete(isExistBeforeDelete);

        Employee notExistAfterDelete = repository.findByEmail("learnwithiftekhar@gmail.com").orElse(null);
        assertEquals(null, notExistAfterDelete);
    }
}

package com.learnwithiftekhar.SpringJPACrudTest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);

    List<Employee> findByName(String name);

    @Query("select e from Employee e where e.joinDate > :date")
    List<Employee> findEmployeeByJoinDateAfter(LocalDate date);
}

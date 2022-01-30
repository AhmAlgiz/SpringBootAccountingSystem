package ru.AccountingSystem.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.AccountingSystem.project.Models.Departments;

import java.util.List;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Long> {
    List<Departments> findByName(String name);

    @Query(value = "SELECT u FROM Departments u WHERE u.id=?1")
    Departments findByID(Long id);
}

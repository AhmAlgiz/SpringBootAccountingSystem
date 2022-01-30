package ru.AccountingSystem.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.AccountingSystem.project.Models.Divisions;

import java.util.List;

@Repository
public interface DivisionsRepository extends JpaRepository<Divisions, Long> {
    List<Divisions> findByName(String name);

    @Query(value = "SELECT u FROM Divisions u WHERE u.id = ?1")
    Divisions findByID(Long id);
}

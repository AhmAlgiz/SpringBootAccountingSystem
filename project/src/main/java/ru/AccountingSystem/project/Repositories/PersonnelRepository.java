package ru.AccountingSystem.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.AccountingSystem.project.Models.Personnel;

import java.util.List;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long>{
    List<Personnel> findByName(String name);
    List<Personnel> findBySecondname(String secondname);
    List<Personnel> findByPatronymic(String patronymic);
    List<Personnel> findByPost(String post);
    List<Personnel> findByPhonenumber(Long phonenumber);
    List<Personnel> findByMail(String mail);
}

package ru.AccountingSystem.project.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ru.AccountingSystem.project.Exception.RecordNotFoundException;
import ru.AccountingSystem.project.Models.Personnel;
import ru.AccountingSystem.project.Repositories.PersonnelRepository;

import java.util.List;

@Service
public class PersonnelService {
    private final PersonnelRepository personnelRepository;

    public PersonnelService(PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }

    public List<Personnel> findAll() {
        return personnelRepository.findAll();
    }

    public Personnel findById( Long id) {
        return personnelRepository.findById(id)
                .orElseThrow(()-> new RecordNotFoundException(id));
    }

    public List<Personnel> findByName(String name) {
        return personnelRepository.findByName(name);
    }

    public List<Personnel> findBySecondname(String secondname) {
        return personnelRepository.findBySecondname(secondname);
    }

    public List<Personnel> findByPatronymic(String patronymic) {
        return personnelRepository.findByPatronymic(patronymic);
    }

    public List<Personnel> findByPost(String post) {
        return personnelRepository.findByPost(post);
    }

    public List<Personnel> findByPhonenumber(Long phonenumber) {
        return personnelRepository.findByPhonenumber(phonenumber);
    }

    public List<Personnel> findByMail(String mail) {
        return personnelRepository.findByMail(mail);
    }

    public Personnel createNew(Personnel newPersonnel) {
        return personnelRepository.save(newPersonnel);
    }

    public Personnel editById (Long id, Personnel newPersonnel) {
        return personnelRepository.findById(id)
                .map(personnel -> {
                    personnel.setName(newPersonnel.getName());
                    personnel.setSecondname(newPersonnel.getSecondname());
                    personnel.setPatronymic(newPersonnel.getPatronymic());
                    personnel.setPost(newPersonnel.getPost());
                    personnel.setPhonenumber(newPersonnel.getPhonenumber());
                    personnel.setMail(newPersonnel.getMail());
                    personnel.setDivisions(newPersonnel.getDivisions());
                    return personnelRepository.save(personnel);
                })
                .orElseGet(()-> {
                    newPersonnel.setId(id);
                    return personnelRepository.save(newPersonnel);
                });
    }

    public void deleteById(Long id) {
        personnelRepository.deleteById(id);
    }
}

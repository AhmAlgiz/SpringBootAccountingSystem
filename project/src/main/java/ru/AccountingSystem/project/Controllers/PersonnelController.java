package ru.AccountingSystem.project.Controllers;

import org.springframework.web.bind.annotation.*;
import ru.AccountingSystem.project.Exception.RecordNotFoundException;
import ru.AccountingSystem.project.Models.Personnel;
import ru.AccountingSystem.project.Repositories.PersonnelRepository;

import java.util.List;

@RestController
public class PersonnelController {
    private PersonnelRepository personnelRepository;

    public PersonnelController(PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }

    @GetMapping("/api/personnel")
    public List<Personnel> all() {
        return personnelRepository.findAll();
    }

    @GetMapping("/api/personnel/{id}")
    public Personnel one(@PathVariable Long id) {
        return personnelRepository.findById(id)
                .orElseThrow(()-> new RecordNotFoundException(id));
    }

    @GetMapping("/api/personnelByName/{name}")
    public List<Personnel> personnelList(@PathVariable String name) {
        return personnelRepository.findByName(name);
    }

    @GetMapping("/api/personnelBySecondname/{secondname}")
    public List<Personnel> personnelSecondnameList(@PathVariable String secondname) {
        return personnelRepository.findBySecondname(secondname);
    }

    @GetMapping("/api/personnelByPatronymic/{patronymic}")
    public List<Personnel> personnelPatronymicList(@PathVariable String patronymic) {
        return personnelRepository.findByPatronymic(patronymic);
    }

    @GetMapping("/api/personnelByPost/{post}")
    public List<Personnel> personnelPostList(@PathVariable String post) {
        return personnelRepository.findByPost(post);
    }

    @GetMapping("/api/personnelByPhonenumber/{phonenumber}")
    public List<Personnel> personnelPhonenumberList(@PathVariable Long phonenumber) {
        return personnelRepository.findByPhonenumber(phonenumber);
    }
    @GetMapping("/api/personnelByMail/{mail}")
    public List<Personnel> personnelMailList(@PathVariable String mail) {
        return personnelRepository.findByMail(mail);
    }

    @PostMapping("/api/personnel")
    public Personnel personnel(@PathVariable Personnel newPersonnel) {
        return personnelRepository.save(newPersonnel);
    }

    @PutMapping("/api/personnel/{id}")
    public Personnel editPersonnel (@PathVariable Long id, Personnel newPersonnel) {
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

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        personnelRepository.deleteById(id);
    }
}

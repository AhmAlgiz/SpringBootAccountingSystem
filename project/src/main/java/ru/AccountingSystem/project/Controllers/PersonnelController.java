package ru.AccountingSystem.project.Controllers;

import org.springframework.web.bind.annotation.*;
import ru.AccountingSystem.project.Models.Personnel;
import ru.AccountingSystem.project.Services.PersonnelService;

import java.util.List;

@RestController
public class PersonnelController {
    private PersonnelService personnelService;

    public PersonnelController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @GetMapping("/api/personnel")
    public List<Personnel> all() {
        return personnelService.findAll();
    }

    @GetMapping("/api/personnel/{id}")
    public Personnel one(@PathVariable Long id) {
        return personnelService.findById(id);
    }

    @GetMapping("/api/personnelByName/{name}")
    public List<Personnel> personnelList(@PathVariable String name) {
        return personnelService.findByName(name);
    }

    @GetMapping("/api/personnelBySecondname/{secondname}")
    public List<Personnel> personnelSecondnameList(@PathVariable String secondname) {
        return personnelService.findBySecondname(secondname);
    }

    @GetMapping("/api/personnelByPatronymic/{patronymic}")
    public List<Personnel> personnelPatronymicList(@PathVariable String patronymic) {
        return personnelService.findByPatronymic(patronymic);
    }

    @GetMapping("/api/personnelByPost/{post}")
    public List<Personnel> personnelPostList(@PathVariable String post) {
        return personnelService.findByPost(post);
    }

    @GetMapping("/api/personnelByPhonenumber/{phonenumber}")
    public List<Personnel> personnelPhonenumberList(@PathVariable Long phonenumber) {
        return personnelService.findByPhonenumber(phonenumber);
    }
    @GetMapping("/api/personnelByMail/{mail}")
    public List<Personnel> personnelMailList(@PathVariable String mail) {
        return personnelService.findByMail(mail);
    }

    @PostMapping("/api/personnel")
    public Personnel personnel(@PathVariable Personnel newPersonnel) {
        return personnelService.createNew(newPersonnel);
    }

    @PutMapping("/api/personnel/{id}")
    public Personnel editPersonnel (@PathVariable Long id, Personnel newPersonnel) {
        return personnelService.editById(id, newPersonnel);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        personnelService.deleteById(id);
    }
}

package ru.AccountingSystem.project.Controllers;

import org.springframework.web.bind.annotation.*;
import ru.AccountingSystem.project.Exception.RecordNotFoundException;
import ru.AccountingSystem.project.Models.Divisions;
import ru.AccountingSystem.project.Models.Personnel;
import ru.AccountingSystem.project.Repositories.DivisionsRepository;


import java.util.List;

@RestController
public class DivisionsController {
    private final DivisionsRepository divisionsRepository;


    public DivisionsController(DivisionsRepository divisionsRepository) {
        this.divisionsRepository = divisionsRepository;
    }

    @GetMapping("/api/divisions")
    public List<Divisions> divisionsListAll() {
        return divisionsRepository.findAll();
    }

    @GetMapping("/api/divisions/{id}")
    public Divisions division(@PathVariable Long id) {
        return divisionsRepository.findById(id)
                .orElseThrow(()->new RecordNotFoundException(id));
    }

    @GetMapping("/api/divisions/findByName/{name}")
    public List <Divisions> division(@PathVariable String name) {
        return divisionsRepository.findByName(name);
    }

    @GetMapping("/api/divisions/personnel/{divisionsId}")
    public List<Personnel> personnelList(@PathVariable Long divisionsId) {
        return divisionsRepository.findById(divisionsId).get().getPersonnel();
    }

    @PostMapping("/api/divisions")
    public Divisions newDivision(Divisions newDivision) {
        return divisionsRepository.save(newDivision);
    }

    @PutMapping("/api/divisions/{id}")
    public Divisions editDivision (@PathVariable Long id, Divisions newDivision) {
        return divisionsRepository.findById(id)
                .map(division -> {
                    division.setName(newDivision.getName());
                    division.setDepartment(newDivision.getDepartment());
                    return divisionsRepository.save(division);
                })
                .orElseGet(()-> {
                    newDivision.setId(id);
                    newDivision.setDepartment(newDivision.getDepartment());
                    return divisionsRepository.save(newDivision);
                });
    }

    @DeleteMapping("/api/divisions/{id}")
    public void delete(@PathVariable Long id) {
        divisionsRepository.deleteById(id);
    }
}

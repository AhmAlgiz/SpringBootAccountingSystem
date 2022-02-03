package ru.AccountingSystem.project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.AccountingSystem.project.Models.Divisions;
import ru.AccountingSystem.project.Models.Personnel;

import ru.AccountingSystem.project.Services.DivisionsService;


import java.util.List;

@RestController
public class DivisionsController {
    private final DivisionsService divisionsService;

    @Autowired
    public DivisionsController(DivisionsService divisionsService) {
        this.divisionsService = divisionsService;
    }

    @GetMapping("/api/divisions")
    public List<Divisions> divisionsListAll() {
        return divisionsService.findAll();
    }

    @GetMapping("/api/divisions/{id}")
    public Divisions division(@PathVariable Long id) {
        return divisionsService.findById(id);
    }

    @GetMapping("/api/divisions/findByName/{name}")
    public List <Divisions> division(@PathVariable String name) {
        return divisionsService.findByName(name);
    }

    @GetMapping("/api/divisions/personnel/{divisionsId}")
    public List<Personnel> personnelList(@PathVariable Long divisionsId) {
        return divisionsService.showAllPersonnelInDivision(divisionsId);
    }

    @PostMapping("/api/divisions")
    public Divisions newDivision(Divisions newDivision) {
        return divisionsService.createNew(newDivision);
    }

    @PutMapping("/api/divisions/{id}")
    public Divisions editDivision (@PathVariable Long id, Divisions newDivision) {
        return divisionsService.editById(id, newDivision);
    }

    @DeleteMapping("/api/divisions/{id}")
    public void delete(@PathVariable Long id) {
        divisionsService.deleteById(id);
    }
}

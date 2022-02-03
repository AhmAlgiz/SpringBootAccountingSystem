package ru.AccountingSystem.project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.AccountingSystem.project.Models.Departments;
import ru.AccountingSystem.project.Models.Divisions;
import ru.AccountingSystem.project.Repositories.DepartmentsRepository;
import ru.AccountingSystem.project.Services.DepartmentsService;


import java.util.List;

@RestController
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    @Autowired
    public DepartmentsController(DepartmentsRepository departmentsRepository, DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping("/api/departments")
    public List<Departments> departmentsList() {
        return departmentsService.findAll();
    }

    @GetMapping("/api/departments/{id}")
    public Departments one(@PathVariable Long id) {
        return departmentsService.findById(id);
    }

    @GetMapping("/api/departments/findByName/{name}")
    public List <Departments> one(@PathVariable String name) {
        return departmentsService.findByName(name);
    }

    @GetMapping("/api/departments/divisions/{departmentId}")
    public List<Divisions> all(@PathVariable Long departmentId) {
        return departmentsService.showAllDivisionsInDepartment(departmentId);
    }

    @PostMapping("/api/departments")
    public Departments newDepartment(Departments newDepartment) {
        return departmentsService.createNew(newDepartment);
    }

    @PutMapping("/api/departments/{id}")
    public Departments editDepartment(@PathVariable Long id, Departments newDepartment) {
        return departmentsService.editById(id, newDepartment);
    }

    @DeleteMapping("/api/departments/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentsService.deleteById(id);
    }
}

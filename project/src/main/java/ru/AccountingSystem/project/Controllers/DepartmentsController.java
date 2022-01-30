package ru.AccountingSystem.project.Controllers;

import org.springframework.web.bind.annotation.*;
import ru.AccountingSystem.project.Models.Departments;
import ru.AccountingSystem.project.Exception.RecordNotFoundException;
import ru.AccountingSystem.project.Models.Divisions;
import ru.AccountingSystem.project.Repositories.DepartmentsRepository;


import java.util.List;

@RestController
public class DepartmentsController {
    private final DepartmentsRepository departmentsRepository;

    public DepartmentsController(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }
    @GetMapping("/api/departments")
    public List<Departments> departmentsList() {
        return departmentsRepository.findAll();
    }

    @GetMapping("/api/departments/{id}")
    public Departments one(@PathVariable Long id) {
        return departmentsRepository.findById(id)
                .orElseThrow(()->new RecordNotFoundException(id));
    }

    @GetMapping("/api/departments/findByName/{name}")
    public List <Departments> one(@PathVariable String name) {
        return departmentsRepository.findByName(name);
    }

    @GetMapping("/api/departments/divisions/{departmentId}")
    public List<Divisions> all(@PathVariable Long departmentId) {
        List<Divisions> divisionsList = departmentsRepository.findById(departmentId).get().getDivisions();
        return divisionsList;
    }

    @PostMapping("/api/departments")
    public Departments newDepartment(Departments newDepartment) {
        return departmentsRepository.save(newDepartment);
    }

    @PutMapping("/api/departments/{id}")
    public Departments editDepartment(@PathVariable Long id, Departments newDepartment) {
        return departmentsRepository.findById(id)
                .map(department -> {
                    department.setName(newDepartment.getName());
                    return departmentsRepository.save(department);
                })
                .orElseGet(()-> {
                    newDepartment.setId(id);
                    return departmentsRepository.save(newDepartment);
                });
    }

    @DeleteMapping("/api/departments/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentsRepository.deleteById(id);
    }
}

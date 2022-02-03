package ru.AccountingSystem.project.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.AccountingSystem.project.Exception.RecordNotFoundException;
import ru.AccountingSystem.project.Models.Departments;
import ru.AccountingSystem.project.Models.Divisions;
import ru.AccountingSystem.project.Repositories.DepartmentsRepository;

import java.util.List;

@Service
public class DepartmentsService {
    private final DepartmentsRepository departmentsRepository;

    public DepartmentsService(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    public List<Departments> findAll() {
        return departmentsRepository.findAll();
    }

    public Departments findById(Long id) {
        return departmentsRepository.findById(id)
                .orElseThrow(()->new RecordNotFoundException(id));
    }

    public List<Departments> findByName(String name) {
        return departmentsRepository.findByName(name);
    }

    public List<Divisions> showAllDivisionsInDepartment(Long departmentId) {
        List<Divisions> divisionsList = departmentsRepository.findById(departmentId).get().getDivisions();
        return divisionsList;
    }

    public Departments createNew(Departments newDepartment) {
        return departmentsRepository.save(newDepartment);
    }

    public Departments editById(Long id, Departments newDepartment) {
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

    public void deleteById (Long id) {
        departmentsRepository.deleteById(id);
    }
}

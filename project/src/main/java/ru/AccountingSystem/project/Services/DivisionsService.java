package ru.AccountingSystem.project.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ru.AccountingSystem.project.Exception.RecordNotFoundException;
import ru.AccountingSystem.project.Models.Divisions;
import ru.AccountingSystem.project.Models.Personnel;
import ru.AccountingSystem.project.Repositories.DivisionsRepository;

import java.util.List;

@Service
public class DivisionsService {
    private final DivisionsRepository divisionsRepository;

    public DivisionsService(DivisionsRepository divisionsRepository) {
        this.divisionsRepository = divisionsRepository;
    }

    public List<Divisions> findAll() {
        return divisionsRepository.findAll();
    }

    public Divisions findById(Long id) {
        return divisionsRepository.findById(id)
                .orElseThrow(()->new RecordNotFoundException(id));
    }

    public List <Divisions> findByName(String name) {
        return divisionsRepository.findByName(name);
    }

    public List<Personnel> showAllPersonnelInDivision(Long divisionsId) {
        return divisionsRepository.findById(divisionsId).get().getPersonnel();
    }

    public Divisions createNew(Divisions newDivision) {
        return divisionsRepository.save(newDivision);
    }

    public Divisions editById (Long id, Divisions newDivision) {
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

    public void deleteById( Long id) {
        divisionsRepository.deleteById(id);
    }

}

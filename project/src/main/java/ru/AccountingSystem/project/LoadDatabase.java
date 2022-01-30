package ru.AccountingSystem.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.AccountingSystem.project.Models.Departments;
import ru.AccountingSystem.project.Models.Divisions;
import ru.AccountingSystem.project.Models.Personnel;
import ru.AccountingSystem.project.Repositories.DepartmentsRepository;
import ru.AccountingSystem.project.Repositories.DivisionsRepository;
import ru.AccountingSystem.project.Repositories.PersonnelRepository;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(DepartmentsRepository departmentsRepository,
                                   DivisionsRepository divisionsRepository,
                                   PersonnelRepository personnelRepository) {
        return args -> {
            log.info("Preload" + departmentsRepository.save(new Departments("IT")));
            log.info("Preload" + departmentsRepository.save(new Departments("Security")));
            log.info("Preload" + divisionsRepository.save(new Divisions("office1", departmentsRepository.findByID(1L))));
            log.info("Preload" + divisionsRepository.save(new Divisions("office2", departmentsRepository.findByID(2L))));
            log.info("Preload" + divisionsRepository.save(new Divisions("office3", departmentsRepository.findByID(1L))));
            log.info("Preload" + personnelRepository.save(new Personnel("Tom","Green","", "TeamLead",89552223344L,"Tom@mail", divisionsRepository.findByID(3L))));
            log.info("Preload" + personnelRepository.save(new Personnel("Alex","Karpov","Ivanovich","Manager", 89552223366L,"Alex@mail", divisionsRepository.findByID(3L))));
            log.info("Preload" + personnelRepository.save(new Personnel("Igor","Volkov","Petrovich","JuniorDeveloper", 89556623366L,"Igor@mail", divisionsRepository.findByID(5L))));
        };
    }

}

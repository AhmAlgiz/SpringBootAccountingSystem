package ru.AccountingSystem.project.Exception;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(Long id) {
        super("Could not find record with id:" + id);
    }
}

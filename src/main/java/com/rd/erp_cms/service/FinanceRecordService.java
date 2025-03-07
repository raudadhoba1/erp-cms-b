package com.rd.erp_cms.service;


import com.rd.erp_cms.model.FinanceRecord;
import com.rd.erp_cms.repository.FinanceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceRecordService {

    @Autowired
    private FinanceRecordRepository repository;

    public List<FinanceRecord> getAllRecords() {
        return repository.findAll();
    }

    public FinanceRecord getRecordById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public FinanceRecord addRecord(FinanceRecord record) {
        return repository.save(record);
    }

    public FinanceRecord updateRecord(Long id, FinanceRecord updatedRecord) {
        FinanceRecord record = repository.findById(id).orElse(null);
        if (record != null) {
            record.setTitle(updatedRecord.getTitle());
            record.setAmount(updatedRecord.getAmount());
            record.setType(updatedRecord.getType());
            record.setDate(updatedRecord.getDate());
            record.setDescription(updatedRecord.getDescription());
            return repository.save(record);
        }
        return null;
    }

    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }
}


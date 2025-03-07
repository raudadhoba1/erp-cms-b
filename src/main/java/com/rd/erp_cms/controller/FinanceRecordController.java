package com.rd.erp_cms.controller;


import com.rd.erp_cms.model.FinanceRecord;
import com.rd.erp_cms.service.FinanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") // Allow frontend requests
@RestController
@RequestMapping("/api/finance")
public class FinanceRecordController {

    @Autowired
    private FinanceRecordService service;

    @GetMapping
    public List<FinanceRecord> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public FinanceRecord getRecordById(@PathVariable Long id) {
        return service.getRecordById(id);
    }

    @PostMapping
    public FinanceRecord addRecord(@RequestBody FinanceRecord record) {
        return service.addRecord(record);
    }

    @PutMapping("/{id}")
    public FinanceRecord updateRecord(@PathVariable Long id, @RequestBody FinanceRecord updatedRecord) {
        return service.updateRecord(id, updatedRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable Long id) {
        service.deleteRecord(id);
    }
}

package com.rd.erp_cms.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.rd.erp_cms.model.FinanceRecord;

public interface FinanceRecordRepository extends JpaRepository<FinanceRecord, Long> {
}

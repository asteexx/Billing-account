package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.BillingAccountViewModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BillingAccountDataService {
    List<BillingAccountViewModel> getAll();
    BillingAccountViewModel getBillingAccountById(Long id);
    BillingAccountViewModel saveBillingAccount(BillingAccountViewModel account);
    void deleteBillingAccount(Long id);
}

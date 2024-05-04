package com.springRest.restApis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CheckRollback {
    @Autowired
    private TransactionService transactionService;
    @Transactional
    public void rollbackSection(Integer amount)
    {
        transactionService.transferMoney(amount);
    }
}

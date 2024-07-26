package com.jpa.dao;

import com.jpa.dto.BankAccount;

import java.util.List;
import java.util.Objects;

public interface BankAccountDao {
    public void insertBankAccount(BankAccount bankAccount);
    public void updateBankAccount(BankAccount bankAccount,String field);
    public void deleteBankAccount(int accountNo);
    public List<BankAccount> getAllBankAccount();
    public List<BankAccount> getBankAccountByAccountNo(int accountNo);
    public List<BankAccount> getBankAccountByAccountName(String accountName);
    public List<BankAccount> getBankAccountByBranchCode(int branchCode);
    public List<Object[]> getGroupByCity();

 }

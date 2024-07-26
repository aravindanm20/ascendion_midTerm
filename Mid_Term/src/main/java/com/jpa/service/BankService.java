package com.jpa.service;

import com.jpa.dto.BankAccount;

import java.util.List;

public interface BankService {
    public void insertAccount(BankAccount bankAccount);
    public void updateAccount(BankAccount bankAccount,String field);
    public void deleteAccount(int accountNo);
    public List<BankAccount> getAllAccount();
    public List<BankAccount> getAccountByAccountNo(int accountNo);
    public List<BankAccount> getAccountByAccountName(String accountName);
    public List<BankAccount> getAccountByBranchCode(int branchCode);
    public List<Object[]> getGroupByCity();
}

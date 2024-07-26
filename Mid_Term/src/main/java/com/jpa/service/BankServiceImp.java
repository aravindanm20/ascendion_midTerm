package com.jpa.service;

import com.jpa.dao.BankAccountDao;
import com.jpa.dao.BankAccountDaoImpl;
import com.jpa.dto.BankAccount;

import java.util.List;

public class BankServiceImp implements BankService{
    private BankAccountDao bankAccountDao = new BankAccountDaoImpl();
    @Override
    public void insertAccount(BankAccount bankAccount) {
        bankAccountDao.insertBankAccount(bankAccount);
    }

    @Override
    public void updateAccount(BankAccount bankAccount, String field) {
        bankAccountDao.updateBankAccount(bankAccount, field);
    }

    @Override
    public void deleteAccount(int accountNo) {
        bankAccountDao.deleteBankAccount(accountNo);
    }

    @Override
    public List<BankAccount> getAllAccount() {
        return bankAccountDao.getAllBankAccount();
    }

    @Override
    public List<BankAccount> getAccountByAccountNo(int accountNo) {
        return bankAccountDao.getBankAccountByAccountNo(accountNo);
    }

    @Override
    public List<BankAccount> getAccountByAccountName(String accountName) {
        return bankAccountDao.getBankAccountByAccountName(accountName);
    }

    @Override
    public List<BankAccount> getAccountByBranchCode(int branchCode) {
        return bankAccountDao.getBankAccountByBranchCode(branchCode);
    }

    @Override
    public List<Object[]> getGroupByCity() {
        return bankAccountDao.getGroupByCity();
    }
}

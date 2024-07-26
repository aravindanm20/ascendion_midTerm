package com.jpa.dao;

import com.jpa.dto.BankAccount;
import com.jpa.util.EntityUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class BankAccountDaoImpl implements BankAccountDao{

    @Override
    public void insertBankAccount(BankAccount bankAccount) {
        EntityManager em = EntityUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(bankAccount);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateBankAccount(BankAccount bankAccount,String field) {
        EntityManager em = EntityUtil.getEntityManager();
        BankAccount bankAccount1 = em.find(BankAccount.class, bankAccount.getActNumber());
        em.getTransaction().begin();
        switch (field){
            case "Customer Name":
                bankAccount1.setCustomerName(bankAccount.getCustomerName());
                break;
            case "City":
                bankAccount1.setCity(bankAccount.getCity());
                break;
            case "Branch Code":
                bankAccount1.setBranchCode(bankAccount.getBranchCode());
                break;
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteBankAccount(int accountNo) {
        EntityManager em = EntityUtil.getEntityManager();
        BankAccount bankAccount = em.find(BankAccount.class, accountNo);
        em.getTransaction().begin();
        em.remove(bankAccount);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<BankAccount> getAllBankAccount() {
        EntityManager em = EntityUtil.getEntityManager();
        return em.createQuery("select e from BankAccount e").getResultList();


    }

    @Override
    public List<BankAccount> getBankAccountByAccountNo(int accountNo) {
        EntityManager em = EntityUtil.getEntityManager();
        Query q =em.createQuery("select e from BankAccount e where e.actNumber =:an");
        q.setParameter("an", accountNo);
        return q.getResultList();

    }

    @Override
    public List<BankAccount> getBankAccountByAccountName(String accountName) {
        EntityManager em = EntityUtil.getEntityManager();
        Query q =em.createQuery("select e from BankAccount e where e.customerName =:accountName");
        q.setParameter("accountName", accountName);
        return q.getResultList();
    }

    @Override
    public List<BankAccount> getBankAccountByBranchCode(int branchCode) {
        EntityManager em = EntityUtil.getEntityManager();
        Query q =em.createQuery("select e from BankAccount e  where e.branchCode =:branchCode");
        q.setParameter("branchCode", branchCode);
        return q.getResultList();
    }

    @Override
    public List<Object[]> getGroupByCity() {
        EntityManager em = EntityUtil.getEntityManager();
        return em.createQuery("select e.city,count(e.city) from BankAccount e group by e.city").getResultList();
    }
}

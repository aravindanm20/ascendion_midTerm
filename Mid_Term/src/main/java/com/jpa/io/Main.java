package com.jpa.io;

import com.jpa.dto.BankAccount;
import com.jpa.service.BankService;
import com.jpa.service.BankServiceImp;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char ch;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1.Insert Record");
            System.out.println("2.Update Record");
            System.out.println("3.View Records");
            System.out.println("4.Delete Record");
            System.out.println("5.Find");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addRecord();
                    break;
                case 2:
                    updateRecord();
                    break;
                case 3:
                    ViewRecords();
                    break;
                case 4:
                    deleteRecords();
                    break;
                case 5:
                    findRecord();


            }
            System.out.print("Do you want to continue? (y/n)");
            ch = sc.next().charAt(0);
        }while(ch == 'y' || ch == 'Y');
    }

    private static void findRecord() {
        BankService bankService = new BankServiceImp();
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Find By Account No");
        System.out.println("2.Find By Account Name");
        System.out.println("3.Find By Branch Code");
        System.out.println("4.Group by City");
        System.out.print("Enter your choice: ");
        int choice2 = sc.nextInt();
        switch (choice2) {
            case 1:
                System.out.print("Enter Account No :");
                List<BankAccount> list= bankService.getAccountByAccountNo(sc.nextInt());
                list.forEach(System.out::println);
                break;
            case 2:
                System.out.print("Enter Account Name :");
                List<BankAccount> list2= bankService.getAccountByAccountName(sc.next());
                list2.forEach(System.out::println);
                break;
            case 3:
                System.out.print("Enter Branch Code :");
                List<BankAccount> list3= bankService.getAccountByBranchCode(sc.nextInt());
                list3.forEach(System.out::println);
                break;
            case 4:
                List<Object[]> list4 = bankService.getGroupByCity();
                for (Object[] objects : list4) {
                    System.out.println(objects[0]+" "+objects[1]);
                }
                break;
        }
    }

    private static void deleteRecords() {
        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankServiceImp();
        System.out.print("Enter account number: ");
        bankService.deleteAccount(sc.nextInt());
    }

    private static void ViewRecords() {
        BankService bankService = new BankServiceImp();
        List<BankAccount> list = bankService.getAllAccount();
        list.forEach(System.out::println);
    }

    private static void updateRecord() {
        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankServiceImp();
        BankAccount bankAccount = new BankAccount();
        System.out.print("Enter account number: ");
        bankAccount.setActNumber(sc.nextInt());
        System.out.println("1.Customer Name");
        System.out.println("2.City");
        System.out.println("3.Branch Code");
        System.out.print("Which field you want to update?");
        int field = sc.nextInt();
        switch (field) {
            case 1:
                System.out.print("Enter account name: ");
                bankAccount.setCustomerName(sc.next());
                bankService.updateAccount(bankAccount,"Customer Name");
                break;
            case 2:
                System.out.print("Enter city: ");
                bankAccount.setCity(sc.next());
                bankService.updateAccount(bankAccount,"City");
                break;
            case 3:
                System.out.print("Enter branch code: ");
                bankAccount.setBranchCode(sc.nextInt());
                bankService.updateAccount(bankAccount,"Branch Code");
                break;
        }
    }

    private static void addRecord() {
        Scanner sc = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount();
        System.out.print("Enter Account No: ");
        bankAccount.setActNumber(sc.nextInt());
        System.out.print("Enter Account Name: ");
        bankAccount.setCustomerName(sc.next());
        System.out.print("Enter Account Balance: ");
        bankAccount.setActBalance(sc.nextDouble());
        System.out.print("Enter Branch Code: ");
        bankAccount.setBranchCode(sc.nextInt());
        System.out.print("Enter City: ");
        bankAccount.setCity(sc.next());
        BankService bankService =new BankServiceImp();
        bankService.insertAccount(bankAccount);
    }
}

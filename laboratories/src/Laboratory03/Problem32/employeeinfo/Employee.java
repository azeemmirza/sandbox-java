package Laboratory03.Problem32.employeeinfo;

import Laboratory03.Problem32.Account;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Employee {
    private Account savingsAcct;
    private Account checkingAcct;
    private Account retirementAcct;
    private String name;
    private LocalDate hireDate;

    public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire){
        this.name = name;
        GregorianCalendar cal = new GregorianCalendar(yearOfHire,monthOfHire-1,dayOfHire);
        hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
    }

    public void createNewChecking(double startAmount) {
        if (checkingAcct == null) {
            checkingAcct = new Account();
            checkingAcct.updateBalance(startAmount);
        } else {
            System.out.println("Checking account already exists.");
        }
    }

    public void createNewSavings(double startAmount) {
        if (savingsAcct == null) {
            savingsAcct = new Account();
            savingsAcct.updateBalance(startAmount);
        } else {
            System.out.println("Savings account already exists.");
        }
    }

    public void createNewRetirement(double startAmount) {
        if (retirementAcct == null) {
            retirementAcct = new Account();
            retirementAcct.updateBalance(startAmount);
        } else {
            System.out.println("Retirement account already exists.");
        }
    }

    public String getFormattedAcctInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employee Name: ").append(name).append("\n");
        sb.append("Hire Date: ").append(hireDate).append("\n");
        sb.append("Checking Account: ").append(checkingAcct != null ? checkingAcct.toString() : "No account").append("\n");
        sb.append("Savings Account: ").append(savingsAcct != null ? savingsAcct.toString() : "No account").append("\n");
        sb.append("Retirement Account: ").append(retirementAcct != null ? retirementAcct.toString() : "No account").append("\n");
        return sb.toString();
    }
    public void deposit(String acctType, double amt){
        if (amt <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        switch (acctType.toLowerCase()) {
            case "checking":
                if (checkingAcct != null) {
                    checkingAcct.updateBalance(amt);
                } else {
                    System.out.println("Checking account does not exist.");
                }
                break;
            case "savings":
                if (savingsAcct != null) {
                    savingsAcct.updateBalance(amt);
                } else {
                    System.out.println("Savings account does not exist.");
                }
                break;
            case "retirement":
                if (retirementAcct != null) {
                    retirementAcct.updateBalance(amt);
                } else {
                    System.out.println("Retirement account does not exist.");
                }
                break;
            default:
                System.out.println("Invalid account type specified.");
        }
    }
    public boolean withdraw(String acctType, double amt) {
        if (amt <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        switch (acctType.toLowerCase()) {
            case "checking":
                if (checkingAcct != null && checkingAcct.getBalance() >= amt) {
                    checkingAcct.updateBalance(-amt);
                    return true;
                } else {
                    System.out.println("Insufficient funds in checking account or account does not exist.");
                    return false;
                }
            case "savings":
                if (savingsAcct != null && savingsAcct.getBalance() >= amt) {
                    savingsAcct.updateBalance(-amt);
                    return true;
                } else {
                    System.out.println("Insufficient funds in savings account or account does not exist.");
                    return false;
                }
            case "retirement":
                if (retirementAcct != null && retirementAcct.getBalance() >= amt) {
                    retirementAcct.updateBalance(-amt);
                    return true;
                } else {
                    System.out.println("Insufficient funds in retirement account or account does not exist.");
                    return false;
                }
            default:
                System.out.println("Invalid account type specified.");
                return false;
        }
    }
}

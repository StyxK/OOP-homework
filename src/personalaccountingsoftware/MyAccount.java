package personalaccountingsoftware;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class MyAccount {

    private String firstName;
    private String lastName;
    private String accountNumber;
    private ArrayList<RecieveItem> recieveItems = new ArrayList<RecieveItem>();
    private ArrayList<ExpenseItem> expenseItems = new ArrayList<ExpenseItem>();

    public MyAccount(String firstName, String lastName) {
        Random rand = new Random();
        this.firstName = firstName;
        this.lastName = lastName;
        int first5digits = rand.nextInt(99999+1)+10000;
        int last5digits = rand.nextInt(99999+1)+10000;
        this.accountNumber = ""+first5digits+last5digits;
    }

    public void createTransaction(String type, String transactionName, double bath, Date date) {
        if (type.equals("+")) {
            RecieveItem recieveItem = new RecieveItem(transactionName, bath, date);
            this.recieveItems.add(recieveItem);
        } else if (type.equals("-")) {
            ExpenseItem expenseItem = new ExpenseItem(transactionName, bath, date);
            this.expenseItems.add(expenseItem);
        }
    }

    public void findTransaction(String name) {
        ArrayList<String> matchTransaction = new ArrayList<String>();
        for (RecieveItem recieveItem : recieveItems) {
            if (recieveItem.getName().contains(name)) {
                matchTransaction.add(
                        "วันที่ " + recieveItem.getDate() + " ชื่อรายรับ " + recieveItem.getName() + " จำนวน(บาท) " + recieveItem.getBath()
                );
            }
        }
        for (ExpenseItem expenseItem : expenseItems) {
            if (expenseItem.getName().contains(name)) {
                matchTransaction.add(
                        "วันที่ " + expenseItem.getDate() + " ชื่อรายจ่าย " + expenseItem.getName() + " จำนวน(บาท) " + expenseItem.getBath()
                );
            }
        }
        System.out.println("รายการที่พบ : " + matchTransaction.size() + " รายการ");
        for (String transaction : matchTransaction) {
            System.out.println(transaction);
        }
    }

    public void calculateTransactions() {
        double expenseAmount = 0;
        double recieveAmount = 0;
        for (RecieveItem recieveItem : recieveItems) {
            recieveAmount += recieveItem.getBath();
        }
        for (ExpenseItem expenseItem : expenseItems) {
            expenseAmount += expenseItem.getBath();
        }
        System.out.println("รายรับทั้งหมด = " + recieveAmount);
        System.out.println("รายจ่ายทั้งหมด = " + expenseAmount);
        if((recieveAmount - expenseAmount)<0){
           System.out.println("ติดหนี้ = " + (recieveAmount - expenseAmount));
        }
        else{
           System.out.println("เหลือเงิน = " + (recieveAmount - expenseAmount));
        }
    }

    public String toString() {
        return "your account info :" + this.firstName + " " + this.lastName + " " + this.accountNumber;
    }

}

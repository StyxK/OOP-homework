package personalaccountingsoftware;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PersonalAccountingSoftware {

    public static void main(String[] args) throws ParseException {
        MyAccount account = null;
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("กรุณาเลือกเมนู");
            System.out.println("พิมพ์     I   กรณีต้องการเปิดบัญชีใหม่");
            System.out.println("พิมพ์     N   เพื่อกรอกรายรับ หรือ รายจ่าย");
            System.out.println("พิมพ์     F   เพื่อค้นหารายการรับ หรือ รายจ่จายที่บันทึก");
            System.out.println("พิมพ์     C   เพื่อสรุปยอดเงินในบัญชี");
            System.out.println("พิมพ์     X   เพื่อปิดโปรแกรม");
            System.out.print("> ");
            String menu = sc.nextLine();
            if(menu.equalsIgnoreCase("I")){
                System.out.print("ชื่อจริง : ");
                String firstName = sc.nextLine();
                System.out.print("นามสกุล : ");
                String lastName = sc.nextLine();
                account = new MyAccount(firstName,lastName);
                System.out.println("ข้อมูลบัญชีของคุณคือ : "+account.toString());
            }
            else if(menu.equalsIgnoreCase("N")){
                System.out.println(account.toString());
                System.out.println("กรุณาพิมพ์ประเภทของรายการ : ");
                System.out.println("พิมพ์ + เพื่อพิมพ์รายการประเภทรายรับ : ");
                System.out.println("พิมพ์ - เพื่อพิมพ์รายการประเภทรายจ่าย : ");
                System.out.print("> ");
                String transactionType = sc.next();
                System.out.print("กรุณากรอกชื่อรายการ : ");
                String name = sc.next();
                System.out.print("กรุณากรอกยอดเงิน (หน่วยบาท): ");
                double bath = sc.nextDouble();
                System.out.print("กรุณากรอกวันที่ของรายการ : ");
                String dateString = sc.next();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
                account.createTransaction(transactionType,name,bath,date);
            }
            else if(menu.equalsIgnoreCase("F")){
                System.out.print("กรุณากรอกชื่อรายการที่ต้องการค้นหา : ");
                String name = sc.nextLine();
                account.findTransaction(name);
            }
            else if(menu.equalsIgnoreCase("C")){
                account.calculateTransactions();
            }
            else if(menu.equalsIgnoreCase("X")){
                System.exit(0);
            }
            
        }
    }   
}
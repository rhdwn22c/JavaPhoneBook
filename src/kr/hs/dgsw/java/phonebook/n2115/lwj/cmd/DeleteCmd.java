package kr.hs.dgsw.java.phonebook.n2115.lwj.cmd;

import kr.hs.dgsw.java.phonebook.n2115.lwj.Info;
import kr.hs.dgsw.java.phonebook.n2115.lwj.Main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DeleteCmd {
    public static void delete(Scanner scan, List<Info> personInfo) throws IOException {
        StringBuilder basket = new StringBuilder();
        List<Info> temp = new ArrayList<>();
        boolean lastMsg = false;
        System.out.println("삭제하실 사람을 골라주세요. >> ");
        String deleteName = scan.next();

        for (Info info : personInfo) {
            if (info.getName().equals(deleteName)) {
                temp.add(info);
            } else {
                basket.append(info.getName()).append(",").append(info.getPhoneNum()).append("\r\n");
            }
        }
        int leg = temp.size();

        if (leg > 1) {
            System.out.println("이름이 같은 사용자가 존재합니다. \r\n");
            for (Info phone : temp) {
                System.out.printf("%d. %-5s\t%s\r\n", phone.getNum(), phone.getName(), phone.getPhoneNum());
            }
            System.out.print("전화 번호를 입력해주세요.  >> \r\n");
            String deletePhone = scan.next();

            for (Info phone : temp) {
                if (phone.getPhoneNum().equals(deletePhone)) {
                    personInfo.remove(phone);
                    lastMsg = true;

                } else {
                    basket.append(phone.getName()).append(",").append(phone.getPhoneNum()).append("\r\n");
                }
            }
        }
        else if(leg == 1){
            personInfo.remove(personInfo.get(0));
            lastMsg = true;
        }

        FileWriter fw = new FileWriter(Main.rootAddress);
        PrintWriter pw = new PrintWriter(fw);
        pw.write(basket.toString());
        pw.close();
        String msg;
        if(lastMsg) {
            msg = "전화번호부에서 제거가 되었습니다.";
        }
        else {
            msg = "존재하지 않습니다.";
        }
        System.out.println(msg);
        UpdateCmd.update(personInfo);
    }
}

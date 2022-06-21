package kr.hs.dgsw.java.phonebook.n2115.lwj.cmd;

import kr.hs.dgsw.java.phonebook.n2115.lwj.Info;
import kr.hs.dgsw.java.phonebook.n2115.lwj.Main;

import java.util.List;
import java.util.Scanner;

public class AddCmd {
    public static void add(Scanner scan, List<Info> personInfo) {
        String phoneNumber;
        System.out.print("이름을 입력해주세요. >> ");
        String name = scan.next();
        System.out.print("전화번호를 입력해주세요. >> ");
        phoneNumber = scan.next();
        personInfo.add(new Info(name, phoneNumber));
        UpdateCmd.update(personInfo);
        System.out.println();
        Main.writeTxt(personInfo);
        System.out.println("*** 등록되었습니다. ***");
    }
}

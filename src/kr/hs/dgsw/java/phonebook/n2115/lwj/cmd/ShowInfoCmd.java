package kr.hs.dgsw.java.phonebook.n2115.lwj.cmd;

import kr.hs.dgsw.java.phonebook.n2115.lwj.Info;

import java.util.List;

public class ShowInfoCmd {
    public static void showInfo(List<Info> personInfo) {
        for (Info info : personInfo) {
            System.out.println(info.toString());
        }
    }
}

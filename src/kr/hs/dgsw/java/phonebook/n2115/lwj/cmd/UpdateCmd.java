package kr.hs.dgsw.java.phonebook.n2115.lwj.cmd;

import kr.hs.dgsw.java.phonebook.n2115.lwj.Info;

import java.util.List;

public class UpdateCmd {
    public static void update(List<Info> personInfo) {
        for(int i = 0; i < personInfo.size(); i++) {
            Info info = personInfo.get(i);
            info.setNum(i + 1);
        }
    }
}

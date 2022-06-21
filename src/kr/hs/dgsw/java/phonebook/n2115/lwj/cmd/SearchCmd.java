package kr.hs.dgsw.java.phonebook.n2115.lwj.cmd;

import kr.hs.dgsw.java.phonebook.n2115.lwj.Info;

import java.util.List;

public class SearchCmd {
    public static void search(List<Info> personInfo, String search) {
        for (Info searchPhoneBook : personInfo) {
            if (searchPhoneBook.getName().contains(search) || searchPhoneBook.getPhoneNum().contains((search))) {
                System.out.println(searchPhoneBook);
            }
        }
    }
}

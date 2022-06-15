package kr.hs.dgsw.java.phonebook.n2115.lwj;

import java.io.*;
import java.util.*;


public class main {
    static final String rootPath = "C:\\Temp\\PhoneDB\\";
    static final String rootAddress = rootPath + "PhoneDB.txt";

    public static void main(String[] args) throws IOException {
        List<Info> personInfo = new ArrayList<>();
        readTxt(personInfo);
        run(personInfo);
    }
    private static void run(List<Info> personInfo) throws IOException {
        boolean run = true;
        String choose = "";
        String searchStr = "";

        System.out.println("┌──────────────────────────────────────┐");
        System.out.println("│               전화번호부               │");
        System.out.println("└──────────────────────────────────────┘");

        while(run) {
            personInfo.sort(Comparator.comparing(Info::getName));
            update(personInfo);
            Scanner scan = new Scanner(System.in);
            System.out.println("1. 목록  2. 등록  3. 삭제  4. 검색  5. 종료");
            System.out.println("---------------------------------------");
            System.out.println("사용하실 시스템을 골라주세요 >> ");
            choose = scan.next();

            switch (choose) {
                case "목록":
                    System.out.println();
                    System.out.println("** 목록 **");
                    showInfo(personInfo);
                    System.out.println();
                    break;
                case "등록":
                    System.out.println();
                    System.out.println("** 등록 **");
                    add(scan, personInfo);
                    break;
                case "삭제":
                    System.out.println();
                    System.out.println("** 삭제 **");
                    System.out.println("삭제하실 번호를 골라주세요 >> ");
                    delete(scan, personInfo);
                    break;
                case "검색":
                    System.out.println();
                    System.out.println("** 검색 **");
                    System.out.println("검색하실 이름이나 전화번호를 입력해주세요 >> ");
                    System.out.println();
                    searchStr = scan.next();
                    search(personInfo, searchStr);
                    System.out.println();
                    break;
                case "종료":
                    System.out.println();
                    System.out.println("**** 시스템을 종료하겠습니다. ****");
                    scan.close();
                    run = false;
                    break;
                default:
                    System.out.println("다시 입력해주세요 >> ");
                    System.out.println();
            }
        }
    }

    private static void showInfo(List<Info> personInfo) {
        for(int i = 0; i < personInfo.size(); i++) {
            System.out.println(personInfo.get(i).toString());
        }
    }

    private static void add(Scanner scan, List<Info> personInfo) throws IOException {
        String phoneNumber;
        System.out.print("이름 >> ");
        String name = scan.next();
        System.out.print("전화번호 >> ");
        phoneNumber = scan.next();
        personInfo.add(new Info(name, phoneNumber));
        update(personInfo);
        System.out.println();
        writeTxt(personInfo);
        System.out.println("*** 등록되었습니다. ***");
    }

    private static void delete(Scanner scan, List<Info> personInfo) throws IOException {
        /*for(Info check : personInfo) {
            String name = check.getName();

        }*/
        int delete = scan.nextInt();
        personInfo.remove(delete - 1);
        update(personInfo);
        System.out.println();
        writeTxt(personInfo);
        System.out.println("*** 삭제되었습니다. ***");
    }

    private static void search(List<Info> personInfo, String search) {
        for(int i = 0; i < personInfo.size(); i++) {
            Info searchPhoneBook = (Info)personInfo.get(i);
            if(searchPhoneBook.getName().contains(search) || searchPhoneBook.getPhoneNumber().contains((search))) {
                System.out.println(searchPhoneBook.toString());
            }
        }
    }

    private static void update(List<Info> personInfo) {
        for(int i = 0; i < personInfo.size(); i++) {
            Info info = (Info)personInfo.get(i);
            info.setNum(i + 1);
        }
    }

    private static void writeTxt(List<Info> personInfo) throws IOException{
        Writer w = null;
        BufferedWriter bw = null;
        try {
            w = new FileWriter(rootAddress);
            bw = new BufferedWriter(w);

            for(int i = 0; i < personInfo.size(); i++) {
                Info writeInfo = personInfo.get(i);
                bw.write(writeInfo.getName() + ",");
                bw.write(writeInfo.getPhoneNumber());
                bw.write("\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static List<Info> readTxt(List<Info> personInfo) throws IOException {
        Reader r = null;
        BufferedReader br = null;
        try {
            r = new FileReader(rootAddress);
            br = new BufferedReader(r);
            String line = "";
            String[] words = new String[2];
            while((line = br.readLine()) != null) {
                words = line.split(",");
                personInfo.add(new Info(words[0], words[1]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        update(personInfo);
        return personInfo;
    }

}

package kr.hs.dgsw.java.phonebook.n2115.lwj;

import kr.hs.dgsw.java.phonebook.n2115.lwj.cmd.*;
import java.io.*;
import java.util.*;


public class Main {
    public static final String rootPath = "C:\\Temp\\PhoneDB\\";
    public static final String rootAddress = rootPath + "PhoneDB.txt";

    public static void main(String[] args) throws IOException {
        List<Info> personInfo = new ArrayList<>();
        readTxt(personInfo);
        run(personInfo);
    }

    public static void readTxt(List<Info> personInfo){
        Reader r;
        BufferedReader br = null;
        try {
            r = new FileReader(rootAddress);
            br = new BufferedReader(r);
            String line;
            String[] words;
            while((line = br.readLine()) != null) {
                words = line.split(",");
                personInfo.add(new Info(words[0], words[1]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        UpdateCmd.update(personInfo);
    }

    public static void writeTxt(List<Info> personInfo){
        Writer w;
        BufferedWriter bw = null;
        try {
            w = new FileWriter(Main.rootAddress);
            bw = new BufferedWriter(w);

            for (Info writeInfo : personInfo) {
                bw.write(writeInfo.getName() + ",");
                bw.write(writeInfo.getPhoneNum());
                bw.write("\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(bw != null) {
                try {
                    bw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void run(List<Info> personInfo) throws IOException {
        boolean run = true;
        String choose;
        String searchStr;

        System.out.println("┌──────────────────────────────────────┐");
        System.out.println("│           전  화  번  호  부           │");
        System.out.println("└──────────────────────────────────────┘");

        while(run) {
            personInfo.sort(Comparator.comparing(Info::getName));
            UpdateCmd.update(personInfo);
            Scanner scan = new Scanner(System.in);
            System.out.println("1. 목록  2. 등록  3. 삭제  4. 검색  5. 종료");
            System.out.println("---------------------------------------");
            System.out.println("사용하실 시스템을 골라주세요. >> ");
            choose = scan.next();

            switch (choose) {
                case "목록":
                    System.out.println("\r\n** 목록 **");
                    ShowInfoCmd.showInfo(personInfo);
                    System.out.println();
                    break;
                case "등록":
                    System.out.println("\r\n** 등록 **");
                    AddCmd.add(scan, personInfo);
                    break;
                case "삭제":
                    System.out.println("\r\n** 삭제 **");
                    DeleteCmd.delete(scan, personInfo);
                    break;
                case "검색":
                    System.out.println("\r\n** 검색 **");
                    System.out.println("검색하실 이름이나 전화번호를 입력해주세요. >> ");
                    System.out.println();
                    searchStr = scan.next();
                    SearchCmd.search(personInfo, searchStr);
                    System.out.println();
                    break;
                case "종료":
                    System.out.println("\r\n**** 시스템을 종료하겠습니다. ****");
                    scan.close();
                    run = false;
                    break;
                default:
                    System.out.println("다시 입력해주세요. >> ");
                    System.out.println();
            }
        }
    }


}

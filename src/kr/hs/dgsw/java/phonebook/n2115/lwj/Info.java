package kr.hs.dgsw.java.phonebook.n2115.lwj;

public class Info {
    private int num;
    private String name;
    private String phoneNumber;

    public Info(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void showInfo() {
        System.out.printf("%d. %-5s\t%s", num, name, phoneNumber);
    }
    @Override
    public String toString() {
        String printList = String.format("%d. %-5s\t%s", num, name, phoneNumber);
        return printList;
    }
}

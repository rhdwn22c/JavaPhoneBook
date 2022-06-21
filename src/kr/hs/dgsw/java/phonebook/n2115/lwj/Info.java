package kr.hs.dgsw.java.phonebook.n2115.lwj;

public class Info {
    private int num;
    private final String name;
    private final String phoneNum;

    public Info(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
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

    public String getPhoneNum() {
        return phoneNum;
    }

    @Override
    public String toString() {
        return String.format("%d. %-5s\t%s", num, name, phoneNum);
    }
}

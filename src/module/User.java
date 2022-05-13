package module;

import java.time.LocalDate;

public class User {
    private String numberPhone;
    private String group;
    private String name;
    private String sex;
    private String address;
    private LocalDate dateOfBirth;
    private String email;

    public User() {
    }

    public User(String numberPhone, String group, String name, String sex, String address, LocalDate dateOfBirth, String email) {
        this.numberPhone = numberPhone;
        this.group = group;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "Số điện thoại: '" + numberPhone + '\'' +
                ", Nhóm của danh bạ: '" + group + '\'' +
                ", Họ tên: '" + name + '\'' +
                ", Giới tính: '" + sex + '\'' +
                ", Địa chỉ: '" + address + '\'' +
                ", Ngày sinh: " + dateOfBirth +
                ", Email'" + email + '\'' +
                '}';
    }
}

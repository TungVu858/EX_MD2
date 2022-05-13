package control;

import module.User;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    private List<User> users = new ArrayList<>();

    public PhoneBook() {
    }

    public PhoneBook(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public int findIndexByNumberPhone(String numberPhone) {
        int index = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getNumberPhone().equals(numberPhone)) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public void deleteUser(String numberPhone) {
        int index = findIndexByNumberPhone(numberPhone);
        if (index == -1) {
            System.out.println(ANSI_RED+"Không tìm thấy số điện thoại này"+ANSI_RESET);
        }
        else {
            users.remove(index);
            System.out.println(ANSI_BLUE+"Xóa thành công"+ANSI_RESET);
        }
    }

    public List<User> findUserByNumberPhoneOrName (String input) {
        List<User> listFinder = new ArrayList<>();
        for (User user : users) {
            if (user.getName().contains(input) || user.getNumberPhone().contains(input)) {
                listFinder.add(user);
            }
        }
        return listFinder;
    }

    public void updateUser(String numberPhone, User newUser) {
        int index = findIndexByNumberPhone(numberPhone);
        if (index == -1) {
            System.out.println(ANSI_RED+"Không tìm được danh bạ với số điện thoại này."+ANSI_RESET);
        }
        else {
            users.set(index, newUser);
            System.out.println(ANSI_BLUE+"Sửa thành công"+ANSI_RESET);
        }
    }

    public void showPhoneBook() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}

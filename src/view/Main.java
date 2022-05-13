package view;

import control.PhoneBook;
import file.FileUserCSV;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static PhoneBook phoneBook = new PhoneBook();
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void createMain() {
        Scanner scn = new Scanner(System.in);
        Scanner scl = new Scanner(System.in);
        int choose = 0;
        String select;
        do {
            Menu.builtMenu();
            do {
                try {
                    System.out.print("Nhập lựa chọn của bạn: ");
                    choose = scn.nextInt();
                    if (choose < 1 || choose > 8) throw new Exception();
                } catch (InputMismatchException e) {
                    choose = -1;
                    System.out.println(ANSI_RED + "Không được nhập chữ " + ANSI_RESET);
                    scn.nextLine();
                } catch (Exception e) {
                    choose = -1;
                    System.out.println(ANSI_RED + "Chỉ được nhập từ 1 -->8" + ANSI_RESET);
                }
            } while (!(choose >= 1 && choose <= 8));
            switch (choose) {
                case 1:
                    phoneBook.showPhoneBook();
                    break;
                case 2:
                    do {
                        phoneBook.addUser(Menu.createUser(scl));
                        do {
                            System.out.print("Bạn muốn nhập tiếp không (y/n): ");
                            select = scl.nextLine();
                        } while (!(select.equals("n") || select.equals("y")));
                    } while (select.equals("y"));
                    break;
                case 3:
                    do {
                        Menu.editUser(scl, phoneBook);
                        do {
                            System.out.print("Bạn muốn sửa tiếp không (y/n): ");
                            select = scl.nextLine();
                        } while (!(select.equals("n") || select.equals("y")));
                    } while (select.equals("y"));
                    break;
                case 4:
                    do {
                        Menu.deleteUser(scl, phoneBook);
                        do {
                            System.out.print("Bạn muốn xóa tiếp không (y/n): ");
                            select = scl.nextLine();
                        } while (!(select.equals("n") || select.equals("y")));
                    } while (select.equals("y"));
                    break;
                case 5:
                    Menu.findUser(scl, phoneBook);
                    break;
                case 6:
                    FileUserCSV.readFile(phoneBook);
                    System.out.println(ANSI_BLUE + "Đọc file thành công" + ANSI_RESET);
                    break;
                case 7:
                    FileUserCSV.writeFile(phoneBook);
                    System.out.println(ANSI_BLUE + "Ghi file Thành công" + ANSI_RESET);
                    break;
            }
        } while (choose <= 7);
    }
}

package file;

import control.PhoneBook;
import date.DateFormatter;
import module.User;

import java.io.*;

public class FileUserCSV {
    public static void readFile(PhoneBook phoneBook) {
        String s;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/data/contacts.csv"))) {
            bufferedReader.readLine();
            while (true) {
                s = bufferedReader.readLine();
                if (s == null) {
                    break;
                }
                String[] arr = s.split(",");
                phoneBook.addUser(new User(arr[0], arr[1], arr[2], arr[3], arr[4], DateFormatter.parseDate(arr[5]), arr[6]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFile(PhoneBook phoneBook) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/data/contacts.csv"))) {
            bufferedWriter.write("Số điện thoại, nhóm, tên, giới tính, địa chỉ, ngày sinh, email");
            bufferedWriter.newLine();
            for (User user : phoneBook.getUsers()) {
                bufferedWriter.write(user.getNumberPhone() + "," + user.getGroup() + "," + user.getName() + "," + user.getSex()
                        + "," + user.getAddress() + "," + user.getDateOfBirth().toString() + "," + user.getEmail());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

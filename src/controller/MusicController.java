package controller;

import Model.Users;
import service.MusicService;

import java.sql.SQLException;
import java.util.Scanner;

public class MusicController {
    private MusicService musicService = new MusicService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("Press 1 to Register");
            System.out.println("Press 0 to Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    register();
            }
            break;
        }
    }

    private void register() {
        System.out.println("Enter user name");
        String name = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        System.out.println("Enter email");
        String email = scanner.nextLine();

        Users user = new Users(4, name, password, email);
        try {
            musicService.addUser(user);
            System.out.println("User registered");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

package com.bipin.vastika.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.bipin.vastika.model.User;
import com.bipin.vastika.service.UserService;
import com.bipin.vastika.service.UserServiceImpl;

public class UserController {

    UserService userService = new UserServiceImpl();

    public void saveUserInfo(Scanner input) {
        User user = getUserData(input);
        int saved = userService.saveUserInfo(user);
        if (saved >= 1) {
            System.out.println("User info is saved in db successfully!!!");
        } else {
            System.out.println("error in db.");
        }
    }

    public void updateUserInfo(Scanner input) {
        User user = getUserData(input);
        System.out.println("Enter id: ");
        int id = input.nextInt();
        user.setId(id);
        int updated = userService.updateUserInfo(user);
        if (updated >= 1) {
            System.out.println("User info is updated in db successfully!!!");
        } else {
            System.out.println("error in db.");
        }
    }


    public void deleteUserInfo(Scanner input) {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        int deleted=userService.deleteUserInfo(id);
        if (deleted >= 1) {
            System.out.println("User info is deleted in db successfully!!!");
        } else {
            System.out.println("error in db.");
        }
    }

    public void getUserById(Scanner input) {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        User user = userService.getUserById(id);
        System.out.println("User id is: "+user.getId());
        System.out.println("User name is: "+user.getUsername());
        System.out.println("User password is: "+user.getPassword());
        System.out.println("User email is: "+user.getEmail());
        System.out.println("User mobile no is: "+user.getMobileNo());
        System.out.println("User dob is: "+user.getDob());
    }

    public void getAllUser() {
        List<User> userList = userService.getAllUser();
        for(User user : userList) {
            System.out.println("User id is: "+user.getId());
            System.out.println("User name is: "+user.getUsername());
            System.out.println("User password is: "+user.getPassword());
            System.out.println("User email is: "+user.getEmail());
            System.out.println("User mobile no is: "+user.getMobileNo());
            System.out.println("User dob is: "+user.getDob());
            System.out.println("=========================================");
        }
    }

    private User getUserData(Scanner input) {
        User user = new User();
        System.out.println("Enter Username: ");
        String username = input.nextLine();
        input.nextLine();
        System.out.println("Enter Password: ");
        String password = input.nextLine();
        System.out.println("Enter Email: ");
        String email = input.nextLine();
        System.out.println("Enter dob: ");
        String dob = input.nextLine();
        System.out.println("Enter mobile no: ");
        long mobileNo = input.nextLong();

        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setMobileNo(mobileNo);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = sdf.parse(dob);
            user.setDob(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return user;
    }
}

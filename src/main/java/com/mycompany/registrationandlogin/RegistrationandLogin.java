/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationandlogin;

import javax.swing.JOptionPane;

/**
 *
 * @author Adhir
 */
public class RegistrationandLogin {

    private final String username;
    private final String password;
    private final String cellNumber;
    private final String firstName;
    private final String lastName;

    public RegistrationandLogin(String username, String password, String cellNumber, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.cellNumber = cellNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*()].*");
    }

    public boolean checkCellPhoneNumber() {
        return cellNumber.matches("^\\+27\\d{9}$");
    }

    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore "
                    + "and is no more than five characters in length.";
        } else {
           JOptionPane.showMessageDialog(null,"Username successfully captured.");
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, "
                    + "a capital letter, a number and a special character.";
        } else {
            JOptionPane.showMessageDialog(null, "Password successfully captured.");
        }
        if (!checkCellPhoneNumber()) {
            return "Cell number is incorrectly formatted or does not contain an international code, please correct the number and try again.";
        } else {
            JOptionPane.showMessageDialog(null,"Cell phone number successfully added.");
        }
        return "User has been registered successfully.";
    }

    public boolean loginUser(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + firstName +" " + lastName + ","  + "it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again. ";
            
        }
    }

        public static void main(String[] args) throws InterruptedException {
        String firstName = JOptionPane.showInputDialog("Enter your First Name:");
        String lastName = JOptionPane.showInputDialog("Enter your Last Name:");
        String username = JOptionPane.showInputDialog("Enter your Username:");
        String password = JOptionPane.showInputDialog("Enter your Password:");
        String phone = JOptionPane.showInputDialog("Enter your Cell Number (e.g., +27XXXXXXXX):");

        RegistrationandLogin user = new RegistrationandLogin(username, password, phone, firstName, lastName);
        String regMsg = user.registerUser();
        JOptionPane.showMessageDialog(null, regMsg);
       

        if (regMsg.equals("User has been registered successfully.")) {
            
            String loginUser = JOptionPane.showInputDialog("Login - Enter Username:");
            String loginPass = JOptionPane.showInputDialog("Login - Enter Password:");
            JOptionPane.showMessageDialog(null, "Verifying,please wait...");
            Thread.sleep(2000);

            boolean success = user.loginUser(loginUser, loginPass);
            JOptionPane.showMessageDialog(null, user.returnLoginStatus(success));
        }
        
    }
}    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    


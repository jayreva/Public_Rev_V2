package demos;

import sun.plugin2.message.GetAuthenticationReplyMessage;

//class UserAlreadyLoggedInException extends Exception{
//    System.out.println("You are already logged in");
//}
//
//class Authentication{
//    private boolean isLoggedIn = false;
//
//    public void login(String email, String password){
//        if (isLoggedIn){
//            if(email.equals("admin") && password.equals("123")){
//                isLoggedIn = true;
//                System.out.println("login successful");
//            } else
//                System.out.println("Login failed, try again");
//        } else{
//            throw new UserAlreadyLoggedInException();
//        }
//    }
//
//}
//
//public class demo47 {
//    public static void main(String[] args) {
//        Authentication auth = new Authentication();
//        try{
//            auth.login("admin", "123");
//        } catch{
//
//        }
//    }
//}

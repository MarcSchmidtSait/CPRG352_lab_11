package services;

import dataaccess.UserDB;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

public class AccountService {
    
    public User login(String email, String password, String path) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
//                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);
           //    GmailService.sendMail(email, "Notes App Login", "A login has been made to your notes app account", false);
              
                String to = user.getEmail();
                String subject = "Notes App Login";
                String template = path + "/emailtemplates/login.html";
                
                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("date", (new java.util.Date()).toString());
                
                GmailService.sendMail(to, subject, template, tags);

                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public void resetPassword(String email, String path, String url){
        String uuid = UUID.randomUUID().toString();
        UserDB userDB = new UserDB();
        
        try{
            User user = userDB.get(email);
            user.setUuid(uuid);
            userDB.update(user);
            String to = email;
            String subject = "Lab 11 reset password";
            String template = path + "/emailtemplates/resetpassword.html";
            String link = url + "?uuid=" + uuid;
            
            HashMap<String, String> tags = new HashMap<>();
            tags.put("firstname", user.getFirstName());
            tags.put("lastname", user.getLastName());
            tags.put("link", link);
            
            GmailService.sendMail(to, subject, template, tags);
        } catch (Exception e){
            
        }
    }
    
    public boolean changePassword(String uuid, String password){
        UserDB userDB = new UserDB();
        try{
            System.out.println("inside change password");
            User user = userDB.getByUuid(uuid);
            System.out.println("this is the user: " + user);
            user.setPassword(password);
            user.setUuid(null);
            userDB.update(user);
            return true;
        }catch (Exception e){
            return false;
        }
        
        
    }
    
}

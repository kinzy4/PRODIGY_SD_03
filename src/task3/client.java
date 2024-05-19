/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kinzy
 */
public class client {
  private  String first_name;
   private String last_name;
    private String user_name;
    private String password;
    private String name;
    private String email;
    private String phone;

  client(){}
  public boolean register(String fname,String lname,String username,String pass){
  this.first_name=fname;
  this.last_name=lname;
  this.user_name=username;
  this.password=pass;
  File file=new File("users.txt");
      try {
          FileWriter fwrite =new FileWriter(file);
          fwrite.write(fname+","+lname+","+username+","+password+"\n");
          fwrite.close();
      } catch (IOException ex) {
          Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
          file.createNewFile();
          
      } catch (IOException ex) {
          Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
      }
  return true;
  }
   public boolean login(String username,String pass) throws IOException{
     File file=new File("users.txt");
  Scanner fread =new Scanner(file);
  while(fread.hasNextLine() ){
  String data = fread.nextLine();
      
  String[] client=data.split(",");
   
  if(client[2].equals(username )&& client[3].equals(pass)){
      File user =new File(username+".txt");
      user.createNewFile();
  return true;
  }
  }
  return false;
  }
   public boolean addcontact(String username,String name,String email,String phone ) throws IOException{
     
       String s1=username+".txt";
   File dir=new File("C:\\Users\\Kinzy\\OneDrive\\Documents\\NetBeansProjects\\task3");
   File contact;
   String flist[]=dir.list();
   for(String i : flist){
       System.out.println(i);
   if(i.equals(s1)){contact=new File(username+".txt");FileWriter fwrite= new FileWriter(contact);
   fwrite.write(name+","+email+","+phone+"\n");
   fwrite.close();
      return true;}  
   
   }
    return false;
   }
   
      public void listcontact(String username) throws IOException{
     
       String s1=username+".txt";
   File dir=new File("C:\\Users\\Kinzy\\OneDrive\\Documents\\NetBeansProjects\\task3");
   File contact;
   String flist[]=dir.list();
   for(String i : flist){
      
   if(i.equals(s1)){contact=new File(username+".txt"); 
     Scanner fread =new Scanner(contact);
  while(fread.hasNextLine() ){
  String data = fread.nextLine();
      
  String[] client=data.split(",");
      System.out.println(Arrays.toString(client));
      }  
   
   }
    }}
      public boolean deleteContact(String username, String name, String email, String phone) throws IOException {
    String s1 = username + ".txt";
    File dir = new File("C:\\Users\\Kinzy\\OneDrive\\Documents\\NetBeansProjects\\task3");
    File contact;
    String[] flist = dir.list();
 

    for (String i : flist) {
        if (i.equals(s1)) {
            contact = new File(dir, s1);
            List<String> lines = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(contact));
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                if (line.equals(name + "," + email + "," + phone)) {
                    found = true; 
                } else {
                    lines.add(line);  
                }
            }
            br.close();

            if (found) {
                
                FileWriter fwrite = new FileWriter(contact);
                for (String l : lines) {
                    fwrite.write(l + "\n");
                }
                fwrite.close();
                return true;  
            } else {
                return false;   
            }
        }
    }
    return false; 
}
     
   
}

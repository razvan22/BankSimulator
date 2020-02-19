package com.company.databaseManager;
import com.company.users.User;


import java.io.*;
import java.util.*;

public class DatabaseManager {

    public static Map<String,String> userNameList = new HashMap<>();
    public static Map<String,User> users = new HashMap<>();
    private static Properties properties = new Properties();


    public static void insert(String path, Object object )throws IOException {
        String filePath = path+".dat";

        try (ObjectOutputStream objectWriter = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)))) {
                objectWriter.writeObject(object);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static Object select(String path){
        String filePath = path;
        Object currentObject = null;
        try(ObjectInputStream read = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)))) {
            boolean eof = false;
            while(!eof) {
                try {
                     currentObject =  read.readObject();
                } catch(EOFException e) {
                    eof = true;
                }
            }
        } catch(IOException io) {
            System.out.println("IO Exception" + io.getMessage());
        } catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e.getMessage());
        }
        return currentObject;
    }
    public static void delete(String path){

    }

    public static void update(String path){

    }

    public static void replace (){

    }

    public static void truncate(){

    }


    public static void writeUserFilesPath(String username, String usersFilePath  ) throws IOException {
        readUsersFilePath();
        userNameList.put(username,usersFilePath);

        for (Map.Entry<String,String> entry : userNameList.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        properties.store(new FileOutputStream("JavaDB/Users/users.txt"), null);
    }

    public static void readUsersFilePath() throws IOException {
        properties.load(new FileInputStream("JavaDB/Users/users.txt"));

        for (String key : properties.stringPropertyNames()) {
            userNameList.put(key, properties.get(key).toString());
        }
    }

}



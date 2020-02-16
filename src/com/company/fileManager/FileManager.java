package com.company.fileManager;
import com.company.users.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileManager {

    public static Map<String,String> usersFilesPath = new HashMap<>();
    public static Map<String,User> usersList = new HashMap<>();
    private static Properties properties = new Properties();

    public static void writeUsersData(String path )throws IOException {
        String filePath = path+".dat";
        try (ObjectOutputStream objectWriter = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)))) {
            for(Object object  : usersList.values()) {
                objectWriter.writeObject(object);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void readUsersData(String path){
        String filePath = path+".dat";
        try(ObjectInputStream read = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)))) {
            boolean eof = false;
            while(!eof) {
                try {
                    User user = (User) read.readObject();
                    usersList.put(user.getFirstName(),user);
                } catch(EOFException e) {
                    eof = true;
                }
            }
        } catch(IOException io) {
            System.out.println("IO Exception" + io.getMessage());
        } catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e.getMessage());
        }
    }

    public static void writeUserFilesPath(String username, String usersFilePath  ) throws IOException {
        usersFilesPath.put(username,usersFilePath);

        for (Map.Entry<String,String> entry : usersFilesPath.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        properties.store(new FileOutputStream("JavaDB/Users/users.txt"), null);
    }

    public static void readUsersFilePath() throws IOException {
        properties.load(new FileInputStream("JavaDB/Users/users.txt"));

        for (String key : properties.stringPropertyNames()) {
            usersFilesPath.put(key, properties.get(key).toString());
        }
    }
}



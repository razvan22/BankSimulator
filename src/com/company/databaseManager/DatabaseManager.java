package com.company.databaseManager;
import com.company.users.User;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

public class DatabaseManager {

    public static Map<String,String> userNameList = new HashMap<>();
    public static Map<String,User> users = new HashMap<>();
    private static Properties properties = new Properties();


    public static void write(String path, Object object )throws IOException {
        String filePath = path+".dat";

        try (ObjectOutputStream objectWriter = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)))) {
                objectWriter.writeObject(object);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void read(String path){
        String filePath = path;

        try(ObjectInputStream read = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)))) {

            boolean eof = false;
            while(!eof) {
                try {
                    Object currentObject =  read.readObject();
                    Class class0 = currentObject.getClass();
                    Method[] methods = class0.getMethods();
                    for (Method method : methods){
                        if (method.getName().startsWith("get")){
                            System.out.println(method);
                        }
                    }

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



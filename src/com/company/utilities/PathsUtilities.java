package com.company.utilities;

import com.company.users.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsUtilities {

    public static String generatePath(User user)  {
        Path path = Paths.get("JavaDB/UsersData/"+user.getUserType()+"/"+user.getName());
        File directory = new File(path.toString());
        if (!directory.exists()){
            try {
                Files.createDirectory(path);
                directory.mkdirs();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return path.toString()+"/"+user.getName()+".dat";
    }
    
    public static File[] dbFilesPaths(){
        return new File("JavaDB/UsersData/").listFiles();
    }

}

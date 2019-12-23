package LOGIC;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

public class MainLogic {
    public static void main(String[] args){
       //Logic l = new Logic(1);

        File file = new File("duidokupuzzles");
        System.out.println(file.exists());
    }
}

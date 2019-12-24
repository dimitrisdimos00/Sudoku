package LOGIC;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.concurrent.ForkJoinPool;

public class MainLogic {
    public static void main(String[] args) throws IOException {
       Logic l = new Logic(1);
        l.showArray();

    }
}

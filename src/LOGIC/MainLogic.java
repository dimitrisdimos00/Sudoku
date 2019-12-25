package LOGIC;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class MainLogic {
    public static void main(String[] args) throws IOException {
        Logic l = new Logic(1);
        Scanner scanner = new Scanner(System.in);
        int element, row, column;
        while (!l.hasWon()){
            l.showArray();
            int []answer = l.Input();
            l.insertElement(answer[0], answer[1], answer[2]); //returns boolean
        }


    }


}

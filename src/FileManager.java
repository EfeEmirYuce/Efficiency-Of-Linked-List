import java.io.File;
import java.io.*;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class FileManager {
    public static void writeFile(String txtName) throws Exception{
        Random rand = new Random();
        File file = new File(txtName);
        if(!file.exists()){
            file.createNewFile();
        }
        String data = rand.nextInt(1, 301) + ",";
        for(int i=1; i<10000;i++){
            int number = rand.nextInt(1,301);
            data = data + number + ",";
        }

        FileWriter fileWriter = new FileWriter(file,false);
        fileWriter.write(data);
        fileWriter.close();
    }
    public static String[] readFile(String pathname) throws IOException {
        File file = new File(pathname);
        Scanner reader = new Scanner(file);
        String source = reader.next();
        String[] values = source.split(",");
        return values;
    }
}

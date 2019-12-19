package app.util;

import java.io.*;

import javax.xml.registry.infomodel.User;

public class FileUtilImpl implements FileUtil {
    public String readFile(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(path);
     
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        String line;

        while ((line = bf.readLine()) != null){
            sb.append(line).append(System.lineSeparator());
        }

        return sb.toString();
    }
}

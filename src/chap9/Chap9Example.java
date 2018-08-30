package chap9;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;

public class Chap9Example {

    public static void main(String args[]){
      Path p = Paths.get("/","home","cay");
      Path p1 = Paths.get("myapp","conf","user.properties");
      System.err.println(p1.toString());
      System.err.println(p.toString());
    }
}

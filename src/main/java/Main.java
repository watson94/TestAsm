import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;

import java.io.*;

/**
 * Created by watson on 04.02.15.
 */
public class Main {
    public static void main(String[] args) throws IOException { //Optional - args[0] - relative path to the folder with class files.
        File f = new File(System.getProperty("user.dir") + "/" + (args.length > 0 ? args[0] : ""));
        File[] files = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches("(.)*\\.class");
            }
        });
        for (File file : files) {
            ClassReader cr = new ClassReader(new FileInputStream(file));
            ClassVisitor cv = new MyClassVisitor();
            cr.accept(cv, ClassReader.SKIP_DEBUG);
        }
    }
}


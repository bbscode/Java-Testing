import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class io {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        student s = new student("Ben", "22645608");
        File obj = new File("ben.txt");
        byte[] b = new byte[1000];
        ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(obj));
        objOut.writeObject(s);
        objOut.close();
        ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(obj));
        student newStu = null;
        newStu = (student)objIn.readObject();
        System.out.println(newStu.name + " " + newStu.num);
        objIn.close();
    }
}

class student implements Serializable {
    String name;
    String num;
    public student(String name, String num) {
        this.name = name;
        this.num = num;
    }
}
 
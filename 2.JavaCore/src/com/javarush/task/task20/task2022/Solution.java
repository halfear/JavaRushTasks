package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private String fileName;
    private transient FileOutputStream stream;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(fileName);
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution original = new Solution("original.txt");
        original.writeObject("Some Data");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.bin"));
        oos.writeObject(original);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.bin"));
        Solution clone = (Solution) ois.readObject();
        ois.close();

        clone.writeObject("New Data");

        try(BufferedReader reader = new BufferedReader(new FileReader("original.txt"))) {
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}

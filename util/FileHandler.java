package util;

import model.Student;
import java.io.*;
import java.util.*;

public class FileHandler {

    private static final String FILE_PATH = "data/students.txt";

    // 📖 Read all students
    public static List<Student> readAll() throws IOException {
        List<Student> students = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            file.getParentFile().mkdirs(); // ensure folder exists
            file.createNewFile();
            return students;
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                students.add(Student.fromFileString(line));
            }
        }

        br.close();
        return students;
    }

    // ✍️ Write all students
    public static void writeAll(List<Student> students) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH));

        for (Student s : students) {
            bw.write(s.toFileString());
            bw.newLine();
        }

        bw.close();
    }
}
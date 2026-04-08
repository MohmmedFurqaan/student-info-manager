package model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }

    // setters
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCourse(String course) { this.course = course; }

    // convert object → file string
    public String toFileString() {
        return id + "," + name + "," + age + "," + course;
    }

    // convert file string → object
    public static Student fromFileString(String line) {
        String[] parts = line.split(",");
        return new Student(
            Integer.parseInt(parts[0].trim()),
            parts[1].trim(),
            Integer.parseInt(parts[2].trim()),
            parts[3].trim()
        );
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Age: " + age +
               ", Course: " + course;
    }
}
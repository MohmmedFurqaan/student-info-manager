package model;


public class Student {

    // schema for the student 
    private int id;
    private String name;
    private int age;
    private String course;

    // set all the value for the class Constructor....
    public Student(int id, String name, int age, String course){
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // function for the setter
    public int getId() {return id; }
    public String getName() {return name; }
    public int getAge() {return age; }
    public String getCourse() {return course; }

    // getter
    public String setName(String name) {return this.name = name;}
    public int setAge(int age) {return this.age = age;}
    public String setCourse(String course) {return this.course = course;}

    // convert object -> file
    public String toFileString() {
        return id + "," + name + "," + age + "," + course;
    }

    // convert file -> String 
    public static Student fromFileString(String line) {
        String[] parts = line.split(",");

        return new Student(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), parts[3]);
    } 








}
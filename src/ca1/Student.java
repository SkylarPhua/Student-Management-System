package ca1;

// Class: DIT/FT/1B/01
// Admission Number: 2002161
// Name: Skylar Phua

public class Student {
    private String course; 
    private String adminNumber;
    private String studentName;
    private double gpa;
    private String[] studentModules; 
    
    public Student(String course, String aNumber, String sName, double gpa, String[] sModules) {
        this.course = course;
        adminNumber = aNumber;
        studentName = sName;
        this.gpa = gpa;
        studentModules = sModules;
    }
    
    public String getCourse() {
        return course;
    }
    
     public String getANum() {
         return adminNumber;
     }
    
    public String getName() {
        return studentName;
    }
    
    public double getGPA() {
        return gpa;
    }
   
    public String[] getModules() {
        return studentModules;
    }
}

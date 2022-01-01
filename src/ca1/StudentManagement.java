package ca1;

// imports
import javax.swing.JOptionPane;

// Class: DIT/FT/1B/01
// Admission Number: 2002161
// Name: Skylar Phua

public class StudentManagement {

    Module[] studentModule = new Module[9];
    Student[] student = new Student[3];

    String[] JameModule = new String[2];
    String[] MaryModule = new String[4];
    String[] JackModule = new String[3];
    //----------------------------------------------------
    String bedcode = "ST1000";
    String bed = "BED";
    int bedCU = 6;
    //----------------------------------------------------
    String javacode = "ST1001";
    String java = "JPRG";
    int javaCU = 4;
    //----------------------------------------------------
    String fopcode = "ST1002", fop = "FOP";
    int fopCU = 6;
    //----------------------------------------------------
    String fedcode = "ST1002", fed = "FED";
    int fedCU = 3;

    public void generateModules() {
        studentModule[0] = new Module(bedcode, bed, bedCU, 88.0);
        studentModule[1] = new Module(javacode, java, javaCU, 80.5);
        //------------------------------------------------------------
        studentModule[2] = new Module(bedcode, bed, bedCU, 90.5);
        studentModule[3] = new Module(javacode, java, javaCU, 78.0);
        studentModule[4] = new Module(fopcode, fop, fopCU, 65.5);
        studentModule[5] = new Module(fedcode, fed, fedCU, 81.0);
        //------------------------------------------------------------
        studentModule[6] = new Module(bedcode, bed, bedCU, 55.5);
        studentModule[7] = new Module(fopcode, fop, fopCU, 86.0);
        studentModule[8] = new Module(fedcode, fed, fedCU, 66.0);
    }

    public double calculateGPA(int[] credit, double[] marks) {
        int totalCU = 0, totalP = 0;
        double GPA;

        for (int i = 0; i < marks.length; i++) {
            double currMark = marks[i];
            double currGradeP = calculateGP(currMark);
            int currCredit = credit[i];
            for (int j = 0; j < marks.length; j++) {
                totalP += currCredit * currGradeP;
                totalCU += currCredit;
            }
        }
        GPA = (double) totalP / totalCU;
        return GPA;
    }

    public double calculateGP(double marks) {
        double gradeP = 0;
        if (marks < 50) {
            gradeP = 0;
        } else if (marks < 60) {
            gradeP = 1;
        } else if (marks < 70) {
            gradeP = 2;
        } else if (marks < 80) {
            gradeP = 3;
        } else if (marks <= 100) {
            gradeP = 4;
        } else {
            System.out.println("There is an error in getting grade point!!!");
        }
        return gradeP;
    }

    public void generate() {
        generateModules();
        //String[] JameModule = {studentModule[1].getModuleName(), studentModule[2].getModuleName()};
        int[] jamesCredit = {studentModule[0].getCreditUnit(), studentModule[1].getCreditUnit()};
        double[] jamesMarks = {studentModule[0].getStudentMarks(), studentModule[1].getStudentMarks()};
        String[] JameModule = {studentModule[0].getModuleName(), studentModule[1].getModuleName()};
        student[0] = new Student("DIT", "P2134777", "James Appleseed", calculateGPA(jamesCredit, jamesMarks), JameModule);
        //------------------------------------------------------------

        int[] maryCredit = {studentModule[2].getCreditUnit(), studentModule[3].getCreditUnit(), studentModule[4].getCreditUnit(), studentModule[5].getCreditUnit()};
        double[] maryMarks = {studentModule[2].getStudentMarks(), studentModule[3].getStudentMarks(), studentModule[4].getStudentMarks(), studentModule[5].getStudentMarks()};
        String[] MaryModule = {studentModule[2].getModuleName(), studentModule[3].getModuleName(), studentModule[4].getModuleName(), studentModule[5].getModuleName()};
        student[1] = new Student("DISM", "P1001222", "Mary Lim", calculateGPA(maryCredit, maryMarks), MaryModule);

        //------------------------------------------------------------
        int[] jackCredit = {studentModule[6].getCreditUnit(), studentModule[7].getCreditUnit(), studentModule[8].getCreditUnit()};
        double[] jackMarks = {studentModule[6].getStudentMarks(), studentModule[7].getStudentMarks(), studentModule[8].getStudentMarks()};
        String[] JackModule = {studentModule[6].getModuleName(), studentModule[7].getModuleName(), studentModule[8].getModuleName()};
        student[2] = new Student("DAAA", "P3003212", "Jack Tan", calculateGPA(jackCredit, jackMarks), JackModule);
    }

    public String modulesTaken(int startNum, String[] modules) {
        String totalMods = "";
        for (int i = 0, j = startNum; i < modules.length; i++, j++) {
            totalMods += "\n" + i + ".   " + studentModule[j].getModuleCode() + "/" + studentModule[j].getModuleName() + "/" + studentModule[j].getCreditUnit() + ":   " + studentModule[j].getStudentMarks();
        }
        return totalMods;
    }

    public void displayAll() {
        //------------------------------------------------------------
        String layout = "\nCourse     Admin#     Name\n";
        String student1Cred = student[0].getCourse() + "            " + student[0].getANum() + "   " + student[0].getName() + "\n";
        String student2Cred = student[1].getCourse() + "         " + student[1].getANum() + "   " + student[1].getName() + "\n";
        String student3Cred = student[2].getCourse() + "        " + student[2].getANum() + "  " + student[2].getName() + "\n";
        //------------------------------------------------------------
        JOptionPane.showMessageDialog(null, "Student 1:" + layout + student1Cred + "Modules Taken:" + modulesTaken(0, JameModule) + "\n\n\nStudent 2:" + layout + student2Cred + "Modules Taken:" + modulesTaken(2, MaryModule) + "\n\n\nStudent 3:" + layout + student3Cred + "Modules Taken:" + modulesTaken(6, JackModule) + "\n\n\n\n", "All Students", JOptionPane.INFORMATION_MESSAGE);
    }

    public void searchByName(String studentName) {
        String layout2 = "Course     Admin#     Name\n";
        String name = "";
        for (int i = 0; i < student.length; i++) {
            if (studentName.equalsIgnoreCase(student[i].getName())) {
                name = student[i].getName();
                break;
            }

        }
        if (name.equalsIgnoreCase(student[0].getName())) {
            JOptionPane.showMessageDialog(null, layout2 + student[0].getCourse() + "             " + student[0].getANum() + "   " + student[0].getName() + "\n\n" + "Modules Taken:" + modulesTaken(0, JameModule) + "\n\nYour GPA = " + String.format("%.2f", student[0].getGPA()));

        } else if (name.equalsIgnoreCase(student[1].getName())) {
            JOptionPane.showMessageDialog(null, layout2 + student[1].getCourse() + "         " + student[1].getANum() + "   " + student[1].getName() + "\n\n" + "Modules Taken:" + modulesTaken(2, MaryModule) + "\n\nYour GPA = " + String.format("%.2f", student[1].getGPA()));

        } else if (name.equalsIgnoreCase(student[2].getName())) {
            JOptionPane.showMessageDialog(null, layout2 + student[2].getCourse() + "        " + student[2].getANum() + "   " + student[2].getName() + "\n\n" + "Modules Taken:" + modulesTaken(6, JackModule) + "\n\nYour GPA = " + String.format("%.2f", student[2].getGPA()));

        } else {
            JOptionPane.showMessageDialog(null, "Cannot find the student \"" + studentName + "\"!!", "Info", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void searchByModule(String moduleName) {
        int count = 0;
        double totalMarks = 0.0;
        double avgMarks = 0.0;
        for (int i = 0; i < studentModule.length; i++) {
            if (moduleName.equalsIgnoreCase(studentModule[i].getModuleName())) {
                count++;
                totalMarks += studentModule[i].getStudentMarks();
            }
        }
        if (count != 0) {
            avgMarks = totalMarks / count;
            JOptionPane.showMessageDialog(null, "There are " + count + " student(s) taking " + moduleName + " module.\nThe average marks for " + moduleName + " is " + String.format("%.1f", avgMarks));
        } else {
            JOptionPane.showMessageDialog(null, "No student taking " + moduleName + ".");
        }
    }

    public void printStatistic() {
        // count1 is to count the number of students getting greater than or equal to 3.5
        int count1 = 0;
        // count2 is to count the number of students getting less than 1
        int count2 = 0;
        // avgMarks1 is the average num of student getting greater than or equal to 3.5
        double avgMarks1 = 0.0;
        // avgMarks2 is the average num of student getting less than 1
        double avgMarks2 = 0.0;
        
        for (int i = 0; i < student.length; i++) {
            if (student[i].getGPA() > 3.5) {
                count1++;
            } else if (student[i].getGPA() < 1.0) {
                count2++;
            } else {
                System.out.println("Moving on to the next one");
            }
        }
        avgMarks1 = ((double) count1/student.length) * 100;
        avgMarks2 = ((double) count2/student.length) * 100;
       
        JOptionPane.showMessageDialog(null, "STATISTIC:\n----------------\n\nThere are " + student.length + " students in total.\n\nThere is/are " + count1 + " student(s) getting GPA greater than 3.5. This is " + String.format("%.2f", avgMarks1) + "%.\n\nThere is/are " + count2 + " student(s) getting GPA less than 1. This is " + String.format("%.2f", avgMarks2) + "%.\n\n");
    }

}

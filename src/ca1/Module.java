package ca1;

// Class: DIT/FT/1B/01
// Admission Number: 2002161
// Name: Skylar Phua

public class Module {

    private String moduleCode;
    private String moduleName;
    private int creditUnit;
    private double studentMarks;

    public Module(String mCode, String mName, int cUnit, double sMarks) {
        moduleCode = mCode;
        moduleName = mName;
        creditUnit = cUnit;
        studentMarks = sMarks;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String mCode) {
        moduleCode = mCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String mName) {
        moduleName = mName;
    }

    public int getCreditUnit() {
        return creditUnit;
    }

    public void setCreditUnit(int cUnit) {
        creditUnit = cUnit;
    }

    public double getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(double sMarks) {
        studentMarks = sMarks;
    }

}

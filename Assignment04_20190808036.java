import java.util.*;

/**
 * @author Berkay Acar
 * ${29.05.2021}
 */
public class Assignment04_20190808036 {

}
class Department {
    private String ID;
    private String name;
    private Teacher chair;

    public Department(String ID, String name) {
        setID(ID);
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        if (ID.length() == 3 || ID.length() == 4)
            this.ID = ID;
        else throw new InvalidIDException(ID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getChair() {
        return chair;
    }

    public void setChair(Teacher chair) {
        if (chair == null) {
            this.chair = null;
        } else if (chair.getDepartment() == this) {
            this.chair = chair;
        } else {
            throw new DepartmentMismatchException(this, chair);
        }
    }
}

class Course {
    private int number;
    private String title;
    private int AKTS;
    private Department department;
    private Teacher teacher;

    public Course(Department department, int number, String title, int AKTS,
                  Teacher teacher) {
        this.department = department;
        setNumber(number);
        this.title = title;
        setAKTS(AKTS);
        this.teacher = teacher;

        if (teacher.getDepartment() != this.department) {
            throw new DepartmentMismatchException(teacher, this);
        }
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        if (teacher.getDepartment().equals(getDepartment()))
            this.teacher = teacher;
        else
            throw new DepartmentMismatchException(teacher, this);

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if ((number <= 499 && number >= 100) || (number <= 5000 && number >= 5999) ||
            (number <= 7000 && number >= 7999))
            this.number = number;
        else
            throw new InvalidNumberException(number);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAKTS() {
        return AKTS;
    }

    public void setAKTS(int AKTS) {
        if (AKTS > 0)
            this.AKTS = AKTS;
        else
            throw new InvalidAKTSException(AKTS);
    }

    public String courseCode() {
        return department.getID() + " " + number;
    }

    @Override
    public String toString() {
        return department.getID() + " " + number + "- " + title + " (" + AKTS + ")";
    }
}

abstract class Person {
    private String name;
    private String email;
    private long ID;
    private Department department;

    public Person(String name, String email, long ID, Department department) {
        this.name = name;
        setEmail(email);
        this.ID=ID;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.contains(".") && email.contains("@"))
            this.email = email;
        else throw new InvalidEmailException(email);
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " (" + ID + ") -  " + email;
    }
}

class Teacher extends Person {
    private int rank;

    public Teacher(String name, String email, long ID,
                   Department department, int rank) {
        super(name, email, ID,department);
        if (rank < 6 && rank > 0) {
            this.rank = rank;
        } else {
            throw new InvalidRankException(rank);
        }
    }

    @Override
    public void setDepartment(Department department) {
        if (getDepartment().getChair() == this) {
            getDepartment().setChair(null);
        }
        super.setDepartment(department);
    }

    public int getRank() {
        return rank;
    }

    public String getTitle() {
        if (rank == 1) return "Adjunct Instructor";
        else if (rank == 2) return "Lecturer";
        else if (rank == 3) return "Assistant Professor";
        else if (rank == 4) return "Associate Professor";
        else if (rank == 5) return "Professor";
        else return "";
    }

    public void promote() {
        if (getRank()<4)
            this.rank = rank + 1;
        else
            throw new InvalidRankException(rank);
    }

    public void demote() {
        if (getRank()>1)
            this.rank = rank - 1;
        else
            throw new InvalidRankException(rank);
    }

    @Override
    public String toString() {
        return getTitle() + " " + super.toString();
    }
}

class Student extends Person {
    private ArrayList<Course> courses;
    private ArrayList<Double> grades;
    private ArrayList<Semester> semesters;
    private ArrayList<Double>highestGrade;
    private ArrayList<Semester> allSemesters;
    private ArrayList<Double> allGrades;
    private ArrayList<Course> allCourses;

    public Student(String name, String email, long ID, Department department) {
        super(name, email, ID, department);
        courses = new ArrayList<>();
        grades = new ArrayList<>();
        semesters = new ArrayList<>();
        allSemesters = new ArrayList<>();
        highestGrade = new ArrayList<>();
        allGrades = new ArrayList<>();
        allCourses = new ArrayList<>();

    }

    public ArrayList<Semester> getSemesters() {
        return semesters;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Double> getSemesterGrades() {
        return grades;
    }

    public ArrayList<Double> getHighestGrade() {
        return highestGrade;
    }

    public int getAKTS() {
        int totalAKTS = 0;
        for (int i = 0; i < courses.size(); i++) {
            if (grades.get(i) >= 60) {
                totalAKTS += courses.get(i).getAKTS();
            }
        }
        return totalAKTS;
    }

    public void addCourse(Course course,Semester semester, double grade) {
        int a=courses.indexOf(course);

        if (grade <=100 && grade >= 0) {
            if(courses.contains(course)) {
                if (getSemesters().get(a).getYear()<semester.getYear()){
                    grades.set(a, grade);
                    semesters.set(a,semester);
                    allSemesters.add(semester);
                    allGrades.add(grade);
                    allCourses.add(course);
                    if(grades.get(a) > highestGrade.get(a)){
                        highestGrade.set(a,grade);
                    }
                }else if(getSemesters().get(a).getYear()==semester.getYear()&&
                         getSemesters().get(a).getSeasonNumber()<semester.getSeasonNumber()){
                    grades.set(a, grade);
                    semesters.add(a,semester);
                    allSemesters.add(semester);
                    allGrades.add(grade);
                    allCourses.add(course);
                    if(grades.get(a) > highestGrade.get(a)){
                        highestGrade.set(a,grade);
                    }
                }
            }else {
                courses.add(course);
                grades.add(grade);
                semesters.add(semester);
                highestGrade.add(grade);
                allSemesters.add(semester);
                allGrades.add(grade);
                allCourses.add(course);
            }
        }else{
            throw new InvalidGradeException(grade);
        }
    }
    public String courseResult(Course course) {
        if (getCourses().contains(course)) {
            int index = getCourses().indexOf(course);
            double grade = getHighestGrade().get(index);
            if (grade < 46)
                return "Failed";
            else if (grade >=46&&grade<60)
                return "Conditionally Passed";
            else return "Passed";
        } else {
            throw new CourseNotFoundException(this, course);
        }
    }
    public double courseGPAPoints(Course course) {
        double GPA = 0;
        if (!courses.contains(course)) {
            throw new CourseNotFoundException(this, course);
        } else {
            int index = courses.indexOf(course);
            double grade = getHighestGrade().get(index);

            if (grade < 35) GPA = 0.0;
            else if (grade < 46) GPA = 0.5;
            else if (grade < 53) GPA = 1.0;
            else if (grade < 60) GPA = 1.5;
            else if (grade < 67) GPA = 2.0;
            else if (grade < 74) GPA = 2.5;
            else if (grade < 81) GPA = 3.0;
            else if (grade < 88) GPA = 3.5;
            else GPA = 4.0;
            return GPA;
        }
    }
    public String courseGradeLetter(Course course){
        String gradeLetter = "";
        if (!courses.contains(course)) {
            throw new CourseNotFoundException(this, course);
        } else {
            int index = courses.indexOf(course);
            double grade = getHighestGrade().get(index);

            if (grade < 35)
                gradeLetter ="FF";
            else if (grade < 46)
                gradeLetter ="FD";
            else if (grade < 53)
                gradeLetter ="DD";
            else if (grade < 60)
                gradeLetter ="DC";
            else if (grade < 67)
                gradeLetter ="CC";
            else if (grade < 74)
                gradeLetter ="CB";
            else if (grade < 81)
                gradeLetter ="BB";
            else if (grade < 88)
                gradeLetter = "BA";
            else gradeLetter ="AA";
            return gradeLetter;
        }
    }
    public int getAttemptedAKTS() {
        int sumOfAKTS = 0;
        for (int i = 0; i < courses.size(); i++) {
            sumOfAKTS += courses.get(i).getAKTS();
        }
        return sumOfAKTS;
    }
    public double getGPA() {
        double sum = 0;
        double grade = 0;
        int AKTS = 0;
        for (int i = 0; i < courses.size(); i++) {
            grade = grades.get(i);
            AKTS = courses.get(i).getAKTS();
            if (grade < 35)
                sum += 0.0;
            else if (grade < 46)
                sum += 0.5 * AKTS;
            else if (grade < 53)
                sum += 1.0 * AKTS;
            else if (grade < 60)
                sum += 1.5 * AKTS;
            else if (grade < 67)
                sum += 2.0 * AKTS;
            else if (grade < 74)
                sum += 2.5 * AKTS;
            else if (grade < 81)
                sum += 3.0 * AKTS;
            else if (grade < 88)
                sum += 3.5 * AKTS;
            else sum += 4.0 * AKTS;
        }
        return sum / getAttemptedAKTS();
    }
    public String listGrades(Semester semester) {
        ArrayList<Course> semesterCourses = new ArrayList<>();
        ArrayList<Double> semesterGrades = new ArrayList<>();
        String text = "";

        for (int i = 0; i < allSemesters.size(); i++) {
            if (allSemesters.get(i).equals(semester)) {
                semesterGrades.add(allGrades.get(i));
                semesterCourses.add(allCourses.get(i));
            }
        }
        if(semesterCourses.size()==0){
            throw new SemesterNotFoundException(this,semester);
        }else {
            for (int i = 0; i < semesterCourses.size(); i++) {
                text += semesterCourses.get(i).courseCode() + " - ";
                if (semesterGrades.get(i) < 35)
                    text +="FF\n";
                else if (semesterGrades.get(i) < 46)
                    text +="FD\n";
                else if (semesterGrades.get(i) < 53)
                    text +="DD\n";
                else if (semesterGrades.get(i) < 60)
                    text +="DC\n";
                else if (semesterGrades.get(i) < 67)
                    text +="CC\n";
                else if (semesterGrades.get(i) < 74)
                    text +="CB\n";
                else if (semesterGrades.get(i) < 81)
                    text +="BB\n";
                else if (semesterGrades.get(i) < 88)
                    text += "BA\n";
                else text +="AA\n";
            }

        }
        return text;
    }
    public String listGrades (Course course) {
        String text= "";
        int say =0;
        for (Course course1:allCourses) {
            if(course1.equals(course)){
                say++;
            }
        }
        for (int i=0;i<allCourses.size();i++) {
            if(allCourses.get(i).equals(course)){
                say--;
                text+=allSemesters.get(i)+" - ";
                if (allGrades.get(i) < 35)
                    text += "FF";
                else if (allGrades.get(i) < 46)
                    text += "FD";
                else if (allGrades.get(i) < 53)
                    text += "DD";
                else if (allGrades.get(i) < 60)
                    text += "DC";
                else if (allGrades.get(i) < 67)
                    text += "CC";
                else if (allGrades.get(i) < 74)
                    text += "CB";
                else if (allGrades.get(i) < 81)
                    text += "BB";
                else if (allGrades.get(i) < 88)
                    text += "BA";
                else if(allGrades.get(i)<=100)
                    text += "AA";
                else text += "";
                if(say>0) {
                    text += "\n";
                }
            }


        }
        return text;
    }
    public String transcript() {
        String text = "";
        TreeSet<Semester> treeSet = new TreeSet<>(new Comparator<Semester>() {
            public int compare(Semester o1, Semester o2) {
                if (o1.getYear() > o2.getYear() || (o1.getYear()==o2.getYear() && o1.getSeasonNumber() > o2.getSeasonNumber())) {
                    return 1;
                } else if ((o1.getYear()==o2.getYear() && o1.getSeasonNumber()==o2.getSeasonNumber())) {
                    return 0;
                } else return -1 ;
            }
        });
        for (Semester semester : allSemesters) {
            treeSet.add(semester);
        }

        for (Semester semester:treeSet) {
            ArrayList<Course> semesterCourses = new ArrayList<>();
            ArrayList<Double> semesterGrades = new ArrayList<>();
            double semesterGPA = 0;
            int semesterAKTS = 0;
            int j =0;
            text+=semester+"\n";
            for (int i = 0; i < allCourses.size(); i++) {
                if (allSemesters.get(i).equals(semester)) {
                    text+="   "+ allCourses.get(i).courseCode()+" - ";
                    semesterCourses.add(allCourses.get(i));
                    semesterGrades.add(allGrades.get(i));
                    while (j<semesterGrades.size()){
                        if (semesterGrades.get(j) < 35)
                            text += "FF\n";
                        else if (semesterGrades.get(j) < 46)
                            text += "FD\n";
                        else if (semesterGrades.get(j) < 53)
                            text += "DD\n";
                        else if (semesterGrades.get(j) < 60)
                            text += "DC\n";
                        else if (semesterGrades.get(j) < 67)
                            text += "CC\n";
                        else if (semesterGrades.get(j) < 74)
                            text += "CB\n";
                        else if (semesterGrades.get(j) < 81)
                            text += "BB\n";
                        else if (semesterGrades.get(j) < 88)
                            text += "BA\n";
                        else if(semesterGrades.get(j)<=100)
                            text += "AA\n";
                        else text += "";
                        j++;
                    }

                }

            }
            for (Course course : semesterCourses) {
                double GPA = 0;
                int index = semesterCourses.indexOf(course);
                double grade = semesterGrades.get(index);

                if (grade < 35) GPA = 0.0;
                else if (grade < 46) GPA = 0.5;
                else if (grade < 53) GPA = 1.0;
                else if (grade < 60) GPA = 1.5;
                else if (grade < 67) GPA = 2.0;
                else if (grade < 74) GPA = 2.5;
                else if (grade < 81) GPA = 3.0;
                else if (grade < 88) GPA = 3.5;
                else GPA = 4.0;
                semesterGPA += course.getAKTS()*GPA;
                semesterAKTS += course.getAKTS();
            }
            semesterGPA = semesterGPA / semesterAKTS;
            text+="GPA: - "+semesterGPA+"\n\n";
        }
        text+="Overall GPA:"+ getGPA();
        return text;
    }


    @Override
    public String toString() {
        return super.toString() + " -GPA: " + getGPA();
    }
}

class GradStudent extends Student {
    private String thesis;
    private Course teachingAssistant;

    public GradStudent(String name, String email, long ID, Department department
            , String thesis) {
        super(name, email, ID, department);
        this.thesis = thesis;
    }

    @Override
    public double courseGPAPoints(Course course) {
        double GPA = 0;
        if (!getCourses().contains(course)) {
            throw new CourseNotFoundException(this, course);
        } else {
            int index = getCourses().indexOf(course);
            double grade = getSemesterGrades().get(index);

            if (grade < 70) GPA=0.0;
            else if(grade<75&&grade>=70) GPA = 2.0;
            else if(grade<80&&grade>=75) GPA = 2.5;
            else if(grade<85&&grade>=80) GPA = 3.0;
            else if(grade<90&&grade>=85) GPA = 3.5;
            else GPA= 4.0;
            return GPA;
        }
    }

    @Override
    public String courseGradeLetter(Course course) {
        String gradeLetter = "";
        if (!getCourses().contains(course)) {
            throw new CourseNotFoundException(this, course);
        } else {
            int index = getCourses().indexOf(course);
            double grade = getSemesterGrades().get(index);

            if (grade < 70&& grade>0)
                gradeLetter ="FF";
            else if (grade < 75 && grade>=70)
                gradeLetter = "CC";
            else if (grade < 80 && grade>=75)
                gradeLetter = "CB";
            else if (grade < 85 && grade>=80)
                gradeLetter = "BB";
            else if (grade < 90&& grade>=85)
                gradeLetter = "BA";
            else gradeLetter="AA";
            return gradeLetter;
        }
    }

    public void setTeachingAssistant(Course course){
        if(this.courseGPAPoints(course)>=3.0){
            this.teachingAssistant=course;
        }else{
            throw new CourseNotFoundException(this,course);
        }
    }
    public Course getTeachingAssistant(){
        return teachingAssistant;
    }

    @Override
    public String courseResult(Course course) {
        if (getCourses().contains(course)) {
            int index = getCourses().indexOf(course);
            double grade = getSemesterGrades().get(index);
            if (grade < 70)
                return "Failed";
            else return "Passed";
        } else {
            throw new CourseNotFoundException(this, course);
        }
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Semester{
    private int seasonNumber;
    private int year;

    public Semester(int seasonNumber, int year) {
        this.seasonNumber = seasonNumber;
        this.year = year;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public String getSeason(){
        if(seasonNumber==1) return "Fall";
        else if(seasonNumber==2) return "Spring";
        else if(seasonNumber==3) return "Summer";
        else return "";
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return getSeason() + " - " + year;
    }
}

class SemesterNotFoundException extends RuntimeException {
    private Student student;
    private Semester semester;

    public SemesterNotFoundException(Student student, Semester semester) {
        this.student = student;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "SemesterNotFoundException: " + student.getID() + " has "+
               "not taken any courses in " + semester;
    }
}

class CourseNotFoundException extends RuntimeException {

    private Student student;
    private Course course;

    public CourseNotFoundException(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseNotFoundExcepiton: " + student.getID() +
               " has not yet taken " + course.courseCode();
    }
}

class DepartmentMismatchException extends RuntimeException {

    private Department department;
    private Teacher person;
    private Course course;

    public DepartmentMismatchException(Teacher person, Course course) {
        this.person = person;
        this.course = course;
        this.department = null;
    }

    public DepartmentMismatchException(Department department, Teacher person) {
        this.department = department;
        this.person = person;
        this.course = null;
    }

    @Override
    public String toString() {
        if (course == null) {
            return "DepartmentMismatchException: " + person.getName() +
                   "(" + person.getID() + ") cannot be chair of " +
                   department.getID() + " because he/she is currently "
                   + "assigned to " + person.getDepartment().getID();
        } else {
            return "DepartmentMismatchException: " + person.getName() + "(" +
                   person.getID() + ") cannot teach " +
                   course.courseCode() + " because he/she is currently"
                   + " assigned to " + person.getDepartment().getID();
        }
    }
}

class InvalidGradeException extends RuntimeException {

    private double grade;

    public InvalidGradeException(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "InvalidGradeException: " + grade;
    }
}

class InvalidRankException extends RuntimeException {

    private int rank;

    public InvalidRankException(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "InvalidRankException:" + rank;
    }
}

class InvalidNumberException extends RuntimeException{
    private int number;

    public InvalidNumberException(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "InvalidNumberException:Course.number-attempted to assign "+number
               +" to number must be in the range 100-499 or 5000-5999 or "
               + "7000-7999";
    }
}

class InvalidEmailException extends RuntimeException{
    private String email;

    public InvalidEmailException(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "InvalidEmailException: Person.email - attempted to assign to a "
               + email+ " String that must have the format "
               + "{text}@{text}.{text}";
    }
}

class InvalidIDException extends  RuntimeException{
    private String ID;

    public InvalidIDException(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "InvalidIDException: Department.ID  attempted to assign to a " +
               ID + " but ID length must be 3 or 4.";
    }
}

class InvalidAKTSException extends  RuntimeException{
    private int AKTS;

    public InvalidAKTSException(int AKTS) {
        this.AKTS = AKTS;
    }

    @Override
    public String toString() {
        return "InvalidAKTSException: Course.AKTS attempted to assign to a "+
               AKTS + " but AKTS must be positive.";
    }
}

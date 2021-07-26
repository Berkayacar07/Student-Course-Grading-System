package assignment;

import java.util.ArrayList;

/**
 * @author Berkay Acar
 * ${29.10.2020}
 */
public class Assignment02_20190808036 {
    public static void main(String[] args) {
        Department department = new Department("102","Berkay");
        Teacher teacher = new Teacher("Ledet","jwl.@com",20,department,
                3);
        System.out.println(department.getChair());

    }
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
        if (rank < 5 && rank > 0) {
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
        if (rank == 1) return "Lecturer";
        else if (rank == 2) return "Assistant Professor";
        else if (rank == 3) return "Associate Professor";
        else if (rank == 4) return "Professor";
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

    public Student(String name, String email, long ID, Department department) {
        super(name, email, ID, department);
        courses = new ArrayList<>();
        grades = new ArrayList<>();

    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Double> getGrades() {
        return grades;
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

    public void addCourse(Course course, double grade) {
        int a=courses.indexOf(course);

        if (grade <=100 && grade >= 0) {
            if (courses.contains(course)) {
                grades.set(a, grade);
            } else {
                courses.add(course);
                grades.add(grade);
            }
        } else {
            throw new InvalidGradeException(grade);
        }
    }


    public String courseResult(Course course) {
        if (getCourses().contains(course)) {
            int index = getCourses().indexOf(course);
            double grade = getGrades().get(index);
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
            double grade = grades.get(index);

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
            double grade = grades.get(index);

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

    @Override
    public String toString() {
        return super.toString() + " -GPA: " + getGPA();
    }
}

class GradStudent extends Student {
    private String thesis;

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
            double grade = getGrades().get(index);

            if (grade < 70) GPA=1.5;
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
            double grade = getGrades().get(index);

            if (grade < 70&& grade>0)
                gradeLetter ="DC";
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

    @Override
    public String courseResult(Course course) {
        if (getCourses().contains(course)) {
            int index = getCourses().indexOf(course);
            double grade = getGrades().get(index);
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


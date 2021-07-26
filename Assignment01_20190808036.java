/**
 * @author Berkay Acar
 * ${25.03.2021}
 */
public class Assignment01_20190808036 {
    public static void main(String[] args) {
        Course c1 = new Course("cse", 101, "Programming", 6);
        System.out.println(c1);
        Person p1 = new Person("Ali", "ali@outlook.com",
                1, "cse");
        System.out.println(p1);
        Teacher t1 = new Teacher("Joseph", "jwl@hotmail.com", 11,
                "cse", 3);
        System.out.println(t1);
        Student s1 = new Student("Berkay", "berkay@hotmail.com",
                2019, "CSE", 30);
        System.out.println(s1);
        GradStudent g1 = new GradStudent("Mehmet",
                "mehmet@outlook.com", 2015, "CSE", 24,
                "Java");
        System.out.println(g1);
    }
}

class Course {
    private String department;
    private int number;
    private String title;
    private int AKTS;

    public Course(String department, int number, String title, int AKTS) {
        setDepartment(department);
        setNumber(number);
        this.title = title;
        setAKTS(AKTS);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department.length() == 3 || department.length() == 4)
            this.department = department;
        else throw new RuntimeException();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if ((number <= 499 && number >= 100) || (number <= 5000 && number >= 5999) ||
            (number <= 7000 && number >= 7999))
            this.number = number;
        else
            throw new RuntimeException();
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
            throw new RuntimeException();
    }

    public String courseCode() {
        return department + " " + number;
    }

    @Override
    public String toString() {
        return department + "- " + title + " (" + AKTS + ")";
    }
}

class Person {
    private String name;
    private String email;
    private long ID;
    private String department;

    public Person(String name, String email, long ID, String department) {
        this.name = name;
        setEmail(email);
        setID(ID);
        setDepartment(department);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department.length() == 3 || department.length() == 4)
            this.department = department;
        else throw new RuntimeException();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.contains(".") && email.contains("@"))
            this.email = email;
        else throw new RuntimeException();
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        if (ID % 2 == 1) this.ID = ID;
        else throw new RuntimeException();
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

    class Teacher extends Person {
        private int rank;

        public Teacher(String name, String email, long id, String department,
                       int rank) {
            super(name, email, id, department);
            setRank(rank);
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            if (rank >= 1 && rank >= 3)
                this.rank = rank;
            else
                throw new RuntimeException();
        }
    }
}

class Teacher extends Person {
    private int rank;

    public Teacher(String name, String email, long ID, String department,
                   int AKTS) {
        super(name, email, ID, department);
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        if (rank == 0) return "Assistant Professor";
        else if (rank == 1) return "Associate Professor";
        else return "Professor";
    }

    public void promote() {
        if (rank - 1 > 0 && rank - 1 < 4)
            this.rank = rank + 1;
        else
            throw new RuntimeException();
    }

    public void demote() {
        if (rank - 1 > 0 && rank - 1 < 4)
            this.rank = rank - 1;
        else
            throw new RuntimeException();
    }

    @Override
    public String toString() {
        return getTitle() + " " + super.toString();
    }
}

class Student extends Person {
    private int AKTS;

    public Student(String name, String email, long ID, String department,
                   int AKTS) {
        super(name, email, ID, department);
        this.AKTS = AKTS;
    }

    public int getAKTS() {
        return AKTS;
    }

    public void setAKTS(int AKTS) {
        if (AKTS > 0)
            this.AKTS = AKTS;
        else throw new RuntimeException();
    }

    public void passCourse(Course course) {
        this.AKTS += course.getAKTS();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class GradStudent extends Student {
    private String thesis;

    public GradStudent(String name, String email, long ID, String department,
                       int AKTS, String thesis) {
        super(name, email, ID, department, AKTS);
        this.thesis = thesis;
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

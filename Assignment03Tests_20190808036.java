/**
 * @author Berkay Acar
 * ${14.05.2021}
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Assignment03Tests_20190808036 {


    @Test
    public void getIDTestInDepartment() {
        Department department = new Department("102", "Berkay");
        Assert.assertEquals("102", department.getID());
    }

    @Test
    public void runtimeExceptionTest() {
        try {
            Department department = new Department("8", "Berkay");
            Assert.assertEquals(false,true);
        } catch (RuntimeException runtimeException) {
            Assert.assertEquals(true, true);
        }

    }

    @Test
    public void setIDTest() {
        Department department = new Department("102", "Berkay");
        department.setID("101");
        Assert.assertEquals("101", department.getID());
    }

    @Test
    public void getNameTestInDepartment() {
        Department department = new Department("102", "Berkay");
        Assert.assertEquals("Berkay", department.getName());
    }

    @Test
    public void setNameTestInDepartment() {
        Department department = new Department("102", "Berkay");
        department.setName("Berkay");
        Assert.assertEquals("Berkay", department.getName());
    }

    @Test
    public void getChairTest() {
        Department department = new Department("102", "Berkay");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                3);
        department.setChair(teacher);
        Assert.assertEquals(teacher, department.getChair());
    }
    @Test
    public void setChairTest() {
        Department department = new Department("102", "Berkay");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                3);
        department.setChair(teacher);
        Assert.assertEquals(teacher, department.getChair());
    }

    @Test
    public void DepartmentMismatchExceptionTestInSetChair() {
        try {
            Department department = new Department("102", "Berkay");
            Department department2 = new Department("102", "Berkay");
            Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                    3);
            department2.setChair(teacher);
            Assert.assertEquals(false,true);
        } catch (Exception departmentMismatchException) {
            Assert.assertEquals(departmentMismatchException instanceof
                            DepartmentMismatchException,
                    true);
        }

    }

    @Test
    public void getDepartmentTestInCourse() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                3);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        Assert.assertEquals(department, course.getDepartment());
    }

    @Test
    public void setDepartmentTestInCourse() {
        Department department = new Department("102", "CSE");
        Department department2 = new Department("101", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                3);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        course.setDepartment(department2);
        Assert.assertEquals(department2, course.getDepartment());
    }

    @Test
    public void getTeacherTest() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                3);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        Assert.assertEquals(teacher, course.getTeacher());
    }

    @Test
    public void setTeacherTest() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                3);
        Teacher teacher2 = new Teacher("Gunay", "jwl.@com", 20, department,
                3);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        course.setTeacher(teacher2);
        Assert.assertEquals(teacher2, course.getTeacher());
    }

    @Test
    public void departmentMismatchExceptionInSetTeacher() {
        try {
            Department department = new Department("102", "CSE");
            Department department2 = new Department("101", "CSE");
            Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                    3);
            Teacher teacher2 = new Teacher("Gunay", "jwl.@com", 20, department2,
                    3);
            Course course = new Course(department, 102, "CSE", 6, teacher);
            course.setTeacher(teacher2);
            Assert.assertEquals(false,true);
        } catch (Exception departmentMismatchException) {
            Assert.assertEquals(departmentMismatchException instanceof
                            DepartmentMismatchException,
                    true);
        }
    }

    @Test
    public void getNumberTest() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                3);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        Assert.assertEquals(102, course.getNumber());
    }

    @Test
    public void setNumberTest() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                3);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        course.setNumber(101);
        Assert.assertEquals(101, course.getNumber());
    }

    @Test
    public void runtimeExceptionInSetNumber() {
        try {
            Department department = new Department("102", "CSE");
            Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                    3);
            Course course = new Course(department, 102, "CSE", 6, teacher);
            course.setNumber(10);
            Assert.assertEquals(false,true);
        } catch (RuntimeException runtimeException) {
            Assert.assertEquals(true, true);
        }
    }

    @Test
    public void getTitleTest() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                3);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        Assert.assertEquals("CSE", course.getTitle());
    }

    @Test
    public void setTitleTest() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                3);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        course.setTitle("TDB");
        Assert.assertEquals("TDB", course.getTitle());
    }

    @Test
    public void getAKTSTest() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                3);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        Assert.assertEquals(6, course.getAKTS());
    }

    @Test
    public void setAKTSTest() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                3);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        course.setAKTS(5);
        Assert.assertEquals(5, course.getAKTS());
    }

    @Test
    public void runtimeExceptionInSetAKTS() {
        try {
            Department department = new Department("102", "CSE");
            Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                    3);
            Course course = new Course(department, 102, "CSE", 6, teacher);
            course.setAKTS(-1);
            Assert.assertEquals(false,true);
        } catch (RuntimeException runtimeException) {
            Assert.assertEquals(true, true);
        }
    }

    @Test
    public void courseCodeTest() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                3);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        Assert.assertEquals(department.getID() + " " + course.getNumber(),
                course.courseCode());
    }

    @Test
    public void toStringTestInCourse() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                3);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        Assert.assertEquals(department.getID() + " " + course.getNumber()
                            + "- " + course.getTitle() + " "
                            + "(" + course.getAKTS() + ")",
                course.toString());
    }

    @Test
    public void getDepartmentTestInPerson() {
        Department department = new Department("102", "CSE");
        Person person = new Person("Berkay", "b.@com", 100, department) {
        };
        Assert.assertEquals(department, person.getDepartment());
    }

    @Test
    public void setDepartmentTestInPerson() {
        Department department = new Department("102", "CSE");
        Department department2 = new Department("101", "CSE");
        Person person = new Person("Berkay", "b.@com", 100, department) {
        };
        person.setDepartment(department2);
        Assert.assertEquals(department2, person.getDepartment());
    }

    @Test
    public void getEmail() {
        Department department = new Department("102", "CSE");
        Person person = new Person("Berkay", "b.@com", 100, department) {
        };

        Assert.assertEquals("b.@com", person.getEmail());
    }

    @Test
    public void setEmail() {
        Department department = new Department("102", "CSE");
        Person person = new Person("Berkay", "b.@com", 100, department) {
        };
        person.setEmail("berkay.@com");

        Assert.assertEquals("berkay.@com", person.getEmail());
    }

    @Test
    public void runtimeExceptionInPerson() {
        try {
            Department department = new Department("102", "CSE");
            Person person = new Person("Berkay", "b@com", 100, department) {
            };
            Assert.assertEquals(false,true);
        } catch (RuntimeException runtimeException) {
            Assert.assertEquals(true, true);
        }
    }

    @Test
    public void getIDTestInPerson() {
        Department department = new Department("102", "CSE");
        Person person = new Person("Berkay", "b.@com", 100, department) {
        };
        Assert.assertEquals(100, person.getID());
    }

    @Test
    public void setIDTestInPerson() {
        Department department = new Department("102", "CSE");
        Person person = new Person("Berkay", "b.@com", 100, department) {
        };
        person.setID(101);
        Assert.assertEquals(101, person.getID());
    }

    @Test
    public void getNameTestInPerson() {
        Department department = new Department("102", "CSE");
        Person person = new Person("Berkay", "b.@com", 100, department) {
        };
        Assert.assertEquals("Berkay", person.getName());
    }

    @Test
    public void setNameTestInPerson() {
        Department department = new Department("102", "CSE");
        Person person = new Person("Berkay", "b.@com", 100, department) {
        };
        person.setName("Acar");
        Assert.assertEquals("Acar", person.getName());
    }

    @Test
    public void toStringTestInPerson() {
        Department department = new Department("102", "CSE");
        Person person = new Person("Berkay", "b.@com", 100, department) {
        };
        Assert.assertEquals(person.getName() + " (" + person.getID() +
                            ") -  " + person.getEmail(), person.toString());
    }

    @Test
    public void getRankTest() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                3);
        Assert.assertEquals(3, teacher.getRank());
    }

    @Test
    public void promoteTest() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                2);
        teacher.promote();
        Assert.assertEquals(3, teacher.getRank());
    }

    @Test
    public void demoteTest() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                2);
        teacher.demote();
        Assert.assertEquals(1, teacher.getRank());
    }

    @Test
    public void getTitleTestInTeacher() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                1);
        Assert.assertEquals("Lecturer", teacher.getTitle());
        teacher.promote();
        Assert.assertEquals("Assistant Professor", teacher.getTitle());
        teacher.promote();
        Assert.assertEquals("Associate Professor", teacher.getTitle());
        teacher.promote();
        Assert.assertEquals("Professor", teacher.getTitle());

    }

    @Test
    public void invalidRankExceptionInPromote() {
        try {
            Department department = new Department("102", "CSE");
            Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                    4);
            teacher.promote();
            Assert.assertEquals(false,true);
        } catch (RuntimeException invalidRankException) {
            Assert.assertEquals(invalidRankException instanceof
                            InvalidRankException, true);
        }
    }

    @Test
    public void invalidRankExceptionInDemote() {
        try {
            Department department = new Department("102", "CSE");
            Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                    1);
            teacher.demote();
        } catch (RuntimeException invalidRankException) {
            Assert.assertEquals(invalidRankException instanceof
                            InvalidRankException,
                    true);
        }
    }

    @Test
    public void toStringTestInTeacher() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                2);
        Person person = new Person("Ledet", "jwl.@com", 20, department) {
        };
        Assert.assertEquals(teacher.getTitle() + " " + person.toString(),
                teacher.toString());

    }

    @Test
    public void getAKTSTestInStudent() {
        Department department = new Department("102", "CSE");
        Student student = new Student("Berkay", "b.@com", 20, department);
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                2);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        student.addCourse(course, 90);
        Assert.assertEquals(6, student.getAKTS());
    }

    @Test
    public void addCourseTest() {
        Department department = new Department("102", "CSE");
        Student student = new Student("Berkay", "b.@com", 20, department);
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                2);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        Course course1 = new Course(department, 101, "CSE", 4, teacher);
        student.addCourse(course, 90);
        student.addCourse(course, 100);
        student.addCourse(course1, 95);
        Assert.assertEquals(10, student.getAKTS());
    }

    @Test
    public void invalidGradeExceptionTest() {
        try {
            Department department = new Department("102", "CSE");
            Student student = new Student("Berkay", "b.@com", 20, department);
            Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                    2);
            Course course = new Course(department, 102, "CSE", 6, teacher);
            student.addCourse(course, -90);
            Assert.assertEquals(false,true);
        } catch (Exception invalidGradeException) {
            Assert.assertEquals(invalidGradeException instanceof
                            InvalidGradeException,
                    true);
        }
    }

    @Test
    public void courseResultTest() {
        Department department = new Department("102", "CSE");
        Student student = new Student("Berkay", "b.@com", 20, department);
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                2);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        student.addCourse(course, 90);
        Assert.assertEquals("Passed", student.courseResult(course));
        student.addCourse(course, 55);
        Assert.assertEquals("Conditionally Passed",
                student.courseResult(course));
        student.addCourse(course, 20);
        Assert.assertEquals("Failed", student.courseResult(course));
    }

    @Test
    public void courseNotFoundExceptionTestInCourseResult() {
        try {
            Department department = new Department("102", "CSE");
            Student student = new Student("Berkay", "b.@com", 20, department);
            Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                    2);
            Course course = new Course(department, 102, "CSE", 6, teacher);
            Course course1 = new Course(department, 101, "CSE", 4, teacher);
            student.courseResult(course);
            Assert.assertEquals(false,true);
        } catch (Exception courseNotFoundException) {
            Assert.assertEquals(courseNotFoundException instanceof
                            CourseNotFoundException,
                    true);
        }
    }

    @Test
    public void courseGPAPointsTest() {
        Department department = new Department("102", "CSE");
        Student student = new Student("Berkay", "b.@com", 20, department);
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                2);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        student.addCourse(course, 90);
        Assert.assertEquals(4.0, student.courseGPAPoints(course), 0.001);
    }

    @Test
    public void courseNotFoundExceptionTestIncourseGPAPointsTest() {
        try {
            Department department = new Department("102", "CSE");
            Student student = new Student("Berkay", "b.@com", 20, department);
            Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                    2);
            Course course = new Course(department, 102, "CSE", 6, teacher);
            student.courseGPAPoints(course);
            Assert.assertEquals(false,true);
        } catch (Exception courseNotFoundException) {
            Assert.assertEquals(courseNotFoundException instanceof
                            CourseNotFoundException,
                    true);
        }
    }

    @Test
    public void courseGradeLetterTest() {
        Department department = new Department("102", "CSE");
        Student student = new Student("Berkay", "b.@com", 20, department);
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                2);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        student.addCourse(course, 90);
        Assert.assertEquals("AA", student.courseGradeLetter(course));
    }

    @Test
    public void courseNotFoundExceptionTestIncourseGradeLetterTest() {
        try {
            Department department = new Department("102", "CSE");
            Student student = new Student("Berkay", "b.@com", 20, department);
            Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                    2);
            Course course = new Course(department, 102, "CSE", 6, teacher);
            student.courseGradeLetter(course);
            Assert.assertEquals(false,true);
        } catch (Exception courseNotFoundException) {
            Assert.assertEquals(courseNotFoundException instanceof
                            CourseNotFoundException,
                    true);
        }
    }

    @Test
    public void getAttemptedAKTSTest() {
        Department department = new Department("102", "CSE");
        Student student = new Student("Berkay", "b.@com", 20, department);
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                2);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        Course course1 = new Course(department, 101, "CSE", 6, teacher);
        student.addCourse(course, 90);
        student.addCourse(course1, 80);
        Assert.assertEquals(12, student.getAttemptedAKTS());
    }

    @Test
    public void getGPATest() {
        Department department = new Department("102", "CSE");
        Student student = new Student("Berkay", "b.@com", 20, department);
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                2);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        Course course1 = new Course(department, 101, "CSE", 6, teacher);
        student.addCourse(course, 90);
        student.addCourse(course1, 85);
        Assert.assertEquals(3.75, student.getGPA(), 0.0001);
    }

    @Test
    public void toStringTestInStudent() {
        Department department = new Department("102", "CSE");
        Student student = new Student("Berkay", "b.@com", 20, department);
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                2);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        Person person = new Person("Berkay", "b.@com", 20, department) {
        };
        Assert.assertEquals(person.toString() + " -GPA: " + student.getGPA(),
                student.toString());
    }

    @Test
    public void courseGPAPointsTestInGradStudent() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                2);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        GradStudent gradStudent = new GradStudent("Berkay", "b.@com", 20,
                department, "Java");
        gradStudent.addCourse(course, 70);
        Assert.assertEquals(2, gradStudent.courseGPAPoints(course), 0.001);
    }

    @Test
    public void courseNotFoundExceptionTestInGradStudent() {
        try {
            Department department = new Department("102", "CSE");
            Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                    2);
            Course course = new Course(department, 102, "CSE", 6, teacher);
            GradStudent gradStudent = new GradStudent("Berkay", "b.@com", 20,
                    department, "Java");
            gradStudent.courseGPAPoints(course);
            Assert.assertEquals(false,true);
        } catch (Exception courseNotFoundException) {
            Assert.assertEquals(courseNotFoundException instanceof
                            CourseNotFoundException,
                    true);
        }
    }

    @Test
    public void courseGradeLetterTestInGradStudent() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                2);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        GradStudent gradStudent = new GradStudent("Berkay", "b.@com", 20,
                department, "Java");
        gradStudent.addCourse(course, 90);
        Assert.assertEquals("AA", gradStudent.courseGradeLetter(course));
    }

    @Test
    public void courseNotFoundExceptionTestInGradStudent2() {
        try {
            Department department = new Department("102", "CSE");
            Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                    2);
            Course course = new Course(department, 102, "CSE", 6, teacher);
            GradStudent gradStudent = new GradStudent("Berkay", "b.@com", 20,
                    department, "Java");
            gradStudent.courseGradeLetter(course);
            Assert.assertEquals(false,true);
        } catch (Exception courseNotFoundException) {
            Assert.assertEquals(courseNotFoundException instanceof
                            CourseNotFoundException,
                    true);
        }
    }

    @Test
    public void courseResultTestInGradStudent() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                2);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        Course course1 = new Course(department, 102, "CSE", 6, teacher);
        GradStudent gradStudent = new GradStudent("Berkay", "b.@com", 20,
                department, "Java");
        gradStudent.addCourse(course, 90);
        gradStudent.addCourse(course1, 60);
        Assert.assertEquals("Passed", gradStudent.courseResult(course));
        Assert.assertEquals("Failed", gradStudent.courseResult(course1));
    }

    @Test
    public void courseNotFoundExceptionTestInGradStudent3() {
        try {
            Department department = new Department("102", "CSE");
            Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                    2);
            Course course = new Course(department, 102, "CSE", 6, teacher);
            GradStudent gradStudent = new GradStudent("Berkay", "b.@com", 20,
                    department, "Java");
            gradStudent.courseResult(course);
            Assert.assertEquals(false,true);
        } catch (Exception courseNotFoundException) {
            Assert.assertEquals(courseNotFoundException instanceof
                            CourseNotFoundException,
                    true);
        }
    }

    @Test
    public void getThesisTest() {
        Department department = new Department("102", "CSE");
        GradStudent gradStudent = new GradStudent("Berkay", "b.@com", 20,
                department, "Java");
        Assert.assertEquals("Java", gradStudent.getThesis());
    }

    @Test
    public void setThesisTest() {
        Department department = new Department("102", "CSE");
        GradStudent gradStudent = new GradStudent("Berkay", "b.@com", 20,
                department, "Java");
        gradStudent.setThesis("Python");
        Assert.assertEquals("Python", gradStudent.getThesis());
    }

    @Test
    public void toStringTestInGradStudent() {
        Department department = new Department("102", "CSE");
        Student student = new Student("Berkay", "b.@com", 20,
                department);
        GradStudent gradStudent = new GradStudent("Berkay", "b.@com", 20,
                department, "Java");
        Assert.assertEquals(student.toString(), gradStudent.toString());
    }

    @Test
    public void toStringInCourseNotFoundException() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("Ledet", "jwl.@com", 20, department,
                2);
        Course course = new Course(department, 102, "CSE", 6, teacher);
        Student student = new Student("Berkay", "b.@com", 20,
                department);
        CourseNotFoundException courseNotFoundException =
                new CourseNotFoundException(student, course);
        Assert.assertEquals("CourseNotFoundExcepiton: " + student.getID() +
                            " has not yet taken " + course.courseCode(),
                courseNotFoundException.toString());
    }
    @Test
    public void toStringInDepartmentMismatchException() {
        Department department = new Department("102", "CSE");
        Teacher person= new Teacher("Ledet", "jwl.@com", 20, department,
                2);
        Course course = new Course(department, 102, "CSE", 6, person);
        DepartmentMismatchException departmentMismatchException =
                new DepartmentMismatchException(person,course);
        Assert.assertEquals("DepartmentMismatchException: " + person.getName() + "(" +
                            person.getID() + ") cannot teach " +
                            course.courseCode() + " because he/she is currently"
                            + " assigned to " + person.getDepartment().getID(),
                departmentMismatchException.toString());
    }
    @Test
    public void toStringInDepartmentMismatchException2() {
        Department department = new Department("102", "CSE");
        Teacher person= new Teacher("Ledet", "jwl.@com", 20, department,
                2);
        DepartmentMismatchException departmentMismatchException =
                new DepartmentMismatchException(department,person);
        Assert.assertEquals("DepartmentMismatchException: " + person.getName() +
                            "(" + person.getID() + ") cannot be chair of " +
                            department.getID() + " because he/she is currently "
                            + "assigned to " + person.getDepartment().getID(),
                departmentMismatchException.toString());
    }
    @Test
    public void toStringInInvalidGradeException() {
        InvalidGradeException invalidGradeException =
                new InvalidGradeException(40);
        Assert.assertEquals("InvalidGradeException: " + 40.0,
                invalidGradeException.toString());
    }
    @Test
    public void toStringInInvalidRankException() {
        InvalidRankException invalidRankException = new InvalidRankException(3);
        Assert.assertEquals("InvalidRankException:" + 3,
                invalidRankException.toString());
    }
    @Test
    public void getNameTestInStudent() {
        Department department = new Department("102", "CSE");
        Student student = new Student("Berkay", "b.@com", 20, department);
        Assert.assertEquals("Berkay",student.getName());
    }
    @Test
    public void setNameTestInStudent() {
        Department department = new Department("102", "CSE");
        Student student = new Student("Berkay", "b.@com", 20, department);
        student.setName("Acar");
        Assert.assertEquals("Acar",student.getName());
    }
    @Test
    public void getNameTestInTeacher() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("JWL","j@.com",20,department,3);
        Assert.assertEquals("JWL",teacher.getName());
    }
    @Test
    public void setNameTestInTeacher() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("JWL","j@.com",20,department,3);
        teacher.setName("Acar");
        Assert.assertEquals("Acar",teacher.getName());
    }
    @Test
    public void getNameTestInGradStudent() {
        Department department = new Department("102", "CSE");
        GradStudent gradStudent = new GradStudent("Berkay","b@.com",07,
                department,"Java");
        Assert.assertEquals("Berkay",gradStudent.getName());
    }
    @Test
    public void setNameTestInGradStudent() {
        Department department = new Department("102", "CSE");
        GradStudent gradStudent = new GradStudent("Berkay","b@.com",07,
                department,"Java");
        gradStudent.setName("Acar");
        Assert.assertEquals("Acar",gradStudent.getName());
    }
    @Test
    public void getEmailTestInStudent() {
        Department department = new Department("102", "CSE");
        Student student = new Student("Berkay", "b.@com", 20, department);
        Assert.assertEquals("b.@com",student.getEmail());
    }
    @Test
    public void setEmailTestInStudent() {
        Department department = new Department("102", "CSE");
        Student student = new Student("Berkay", "b.@com", 20, department);
        student.setEmail("c@.com");
        Assert.assertEquals("c@.com",student.getEmail());
    }
    @Test
    public void getEmailTestInTeacher() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("JWL","j@.com",20,department,3);
        Assert.assertEquals("j@.com",teacher.getEmail());
    }
    @Test
    public void setEmailTestInTeacher() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("JWL","j@.com",20,department,3);
        teacher.setEmail("j..@com");
        Assert.assertEquals("j..@com",teacher.getEmail());
    }
    @Test
    public void getEmailTestInGradStudent() {
        Department department = new Department("102", "CSE");
        GradStudent gradStudent = new GradStudent("Berkay","b@.com",07,
                department,"Java");
        Assert.assertEquals("b@.com",gradStudent.getEmail());
    }
    @Test
    public void setEmailTestInGradStudent() {
        Department department = new Department("102", "CSE");
        GradStudent gradStudent = new GradStudent("Berkay","b@.com",07,
                department,"Java");
        gradStudent.setEmail("c@.com");
        Assert.assertEquals("c@.com",gradStudent.getEmail());
    }
    @Test
    public void getIDTestInStudent() {
        Department department = new Department("102", "CSE");
        Student student = new Student("Berkay", "b.@com", 20, department);
        Assert.assertEquals(20,student.getID());
    }
    @Test
    public void setIDTestInStudent() {
        Department department = new Department("102", "CSE");
        Student student = new Student("Berkay", "b.@com", 20, department);
        student.setID(10);
        Assert.assertEquals(10,student.getID());
    }
    @Test
    public void getIDTestInTeacher() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("JWL","j@.com",20,department,3);
        Assert.assertEquals(20,teacher.getID());
    }
    @Test
    public void setIDTestInTeacher() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("JWL","j@.com",20,department,3);
        teacher.setID(10);
        Assert.assertEquals(10,teacher.getID());
    }
    @Test
    public void getIDTestInGradStudent() {
        Department department = new Department("102", "CSE");
        GradStudent gradStudent = new GradStudent("Berkay","b@.com",07,
                department,"Java");
        Assert.assertEquals(07,gradStudent.getID());
    }
    @Test
    public void setIDTestInGradStudent() {
        Department department = new Department("102", "CSE");
        GradStudent gradStudent = new GradStudent("Berkay","b@.com",07,
                department,"Java");
        gradStudent.setID(00);
        Assert.assertEquals(00,gradStudent.getID());
    }
    @Test
    public void getdepartmentTestInStudent() {
        Department department = new Department("102", "CSE");
        Student student = new Student("Berkay", "b.@com", 20, department);
        Assert.assertEquals(department,student.getDepartment());
    }
    @Test
    public void setdepartmentTestInStudent() {
        Department department = new Department("102", "CSE");
        Department department2 = new Department("101", "CSE1");
        Student student = new Student("Berkay", "b.@com", 20, department);
        student.setDepartment(department2);
        Assert.assertEquals(department2,student.getDepartment());
    }
    @Test
    public void getdepartmentTestInTeacher() {
        Department department = new Department("102", "CSE");
        Teacher teacher = new Teacher("JWL","j@.com",20,department,3);
        Assert.assertEquals(department,teacher.getDepartment());
    }
    @Test
    public void setdepartmentTestInTeacher() {
        Department department = new Department("102", "CSE");
        Department department2 = new Department("101", "CSE1");
        Teacher teacher = new Teacher("JWL","j@.com",20,department,3);
        teacher.setDepartment(department2);
        Assert.assertEquals(department2,teacher.getDepartment());
    }
    @Test
    public void getdepartmentTestInGradStudent() {
        Department department = new Department("102", "CSE");
        GradStudent gradStudent = new GradStudent("Berkay","b@.com",07,
                department,"Java");
        Assert.assertEquals(department,gradStudent.getDepartment());
    }
    @Test
    public void setdepartmentTestInGradStudent() {
        Department department = new Department("102", "CSE");
        Department department2 = new Department("101", "CSE1");
        GradStudent gradStudent = new GradStudent("Berkay","b@.com",07,
                department,"Java");
        gradStudent.setDepartment(department2);
        Assert.assertEquals(department2,gradStudent.getDepartment());
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


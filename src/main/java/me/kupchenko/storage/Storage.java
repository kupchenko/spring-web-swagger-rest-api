package me.kupchenko.storage;

import me.kupchenko.model.Course;
import me.kupchenko.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class Storage {
    private List<Course> courses = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public Storage() {
        prepareTestData();
    }

    private void prepareTestData() {
        Student student1 = new Student(1L, "Dmitrii", "Kup", "21.03.****", "dmitrii@email.com");
        Student student2 = new Student(2L, "Yuliia", "Sereda", "29.09.****", "yuliia@email.com");
        Student student3 = new Student(3L, "Zui", "Dang", "**.**.****", "zui@email.com");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        Course course = new Course(1L, "QA", 202, Arrays.asList("sub1", "sub2"), 2019, Arrays.asList("1", "2", "3"));
        courses.add(course);
    }

    public Optional<Student> getStudentById(Long studId) {
        return students.stream()
                .filter(student -> student.getId().equals(studId))
                .findFirst();
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    public void deleteStudentById(Long studId) {
        students.removeIf(student -> student.getId().equals(studId));
        courses.forEach(course -> {
            List<String> students = course.getStudents();
            students.remove(studId);
        });
    }

    public void deleteCourseById(Long studId) {
        courses.removeIf(student -> student.getId().equals(studId));
    }

    public void save(Student student) {
        students.add(student);
    }

    public void save(Course course) {
        courses.add(course);
    }

    public Optional<Course> getCourseById(Long courseId) {
        return courses.stream()
                .filter(course -> course.getId().equals(courseId))
                .findFirst();
    }
}

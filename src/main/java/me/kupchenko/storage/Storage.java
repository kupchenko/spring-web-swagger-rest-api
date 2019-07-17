package me.kupchenko.storage;

import me.kupchenko.model.Course;
import me.kupchenko.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Storage {
    private List<Course> courses;
    private List<Student> students;

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

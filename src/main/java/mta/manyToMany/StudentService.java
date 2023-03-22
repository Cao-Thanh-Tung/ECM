package mta.manyToMany;


import mta.mvcOnToMany.entity.Cart;

import java.util.List;

public interface StudentService {
    void save(Student student);
    Student findById(Long id);
    public List<Student> listAllStudents();
}

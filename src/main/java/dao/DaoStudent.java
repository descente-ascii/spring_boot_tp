package dao;

import domain.Student;

public class DaoStudent extends AbstractJpaDao{

    public DaoStudent(){
        setClazz(Student.class);
    }
}

package dao;

import domain.Teacher;

public class DaoTeacher extends AbstractJpaDao{

    public DaoTeacher(){
        setClazz(Teacher.class);
    }

    /*private void createTeacher() {
        int numOfTeachers = entityManager.createQuery("Select a From Employee a", Employee.class).getResultList().size();
        if (numOfTeachers == 0) {
            Department department = new Department("java");
            entityManager.persist(department);
            entityManager.persist(new Teacher("Jakab Gipsz", department));
            entityManager.persist(new Teacher("Captain Nemo", department));
        }
    }
    private void listEmployees() {
        List<Employee> resultList = entityManager.createQuery("Select a From Employee a", Employee.class).getResultList();
        System.out.println("num of employess:" + resultList.size());
        for (Employee next : resultList) {
            System.out.println("next employee: " + next);
        }
    }*/
}

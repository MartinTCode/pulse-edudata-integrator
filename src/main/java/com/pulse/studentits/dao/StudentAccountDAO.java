package com.pulse.studentits.dao;

import com.pulse.studentits.entity.StudentAccount;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class StudentAccountDAO {
    private final EntityManager em;

    public StudentAccountDAO(EntityManager em) {
        this.em = em;
    }

    // find by student id
    public StudentAccount findByStudentId(String studentId) {
        return em.find(StudentAccount.class, studentId);
    }

    // Find by personal number
    public List<StudentAccount> findAccountsByPersonalNo(String personalNo) {
        TypedQuery<StudentAccount> query = em.createQuery(
                "SELECT sa FROM StudentAccount sa WHERE sa.personalNo = :personalNo",
                StudentAccount.class);
        query.setParameter("personalNo", personalNo);
        return query.getResultList();
    }

}

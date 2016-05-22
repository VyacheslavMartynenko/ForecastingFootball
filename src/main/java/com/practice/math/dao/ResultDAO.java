package com.practice.math.dao;

import java.util.List;

import com.practice.math.model.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@SuppressWarnings("JpaQlInspection")
@Repository
public class ResultDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public void addResult(Result p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
    }

    public void updateResult(Result p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
    }

    @SuppressWarnings("unchecked")
    public List<Result> listResults() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Result").list();
    }

    public Result getResultByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Result) session.load(Result.class, id);
    }

    public void removeResult(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Result p = (Result) session.load(Result.class, id);
        if (null != p) {
            session.delete(p);
        }
    }
}

package com.practice.math.dao;

import java.util.List;

import com.practice.math.model.Club;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@SuppressWarnings("JpaQlInspection")
@Repository
public class ClubDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public void addClub(Club p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
    }

    public void updateClub(Club p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
    }

    @SuppressWarnings("unchecked")
    public List<Club> listClubs() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Club").list();
    }

    public Club getClubByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Club) session.load(Club.class, id);
    }

    public Club getClubByName(String name) {
        Query query = sessionFactory.getCurrentSession().
                createQuery("from Club where name=:name");
        query.setParameter("name", name);
        return (Club) query.uniqueResult();
    }

    public void removeClub(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Club p = (Club) session.load(Club.class, id);
        if (null != p) {
            session.delete(p);
        }
    }

}

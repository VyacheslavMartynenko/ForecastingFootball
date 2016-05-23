package com.practice.math.dao;

import com.practice.math.model.Game;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
public class GameDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public void addGame(Game p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
    }

    public void updateGame(Game p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
    }

    @SuppressWarnings("unchecked")
    public List<Game> listGames() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Game").list();
    }

    @SuppressWarnings("unchecked")
    public List<Game> getGamesByClubs(String firstClub, String secondClub){
        Query query = sessionFactory.getCurrentSession().
                createQuery("from Game where (firstClub=:firstClub OR firstClub=:secondClub)" +
                        "AND (secondClub=:firstClub OR secondClub=:secondClub)");
        query.setParameter("firstClub", firstClub);
        query.setParameter("secondClub", secondClub);
        return query.list();
    }

    public Game getGameByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Game) session.load(Game.class, id);
    }

    public void removeGame(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Game p = (Game) session.load(Game.class, id);
        if (null != p) {
            session.delete(p);
        }
    }
}

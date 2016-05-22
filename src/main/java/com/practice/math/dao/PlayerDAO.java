package com.practice.math.dao;

import java.util.List;

import com.practice.math.model.Player;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@SuppressWarnings("JpaQlInspection")
@Repository
public class PlayerDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public void addPlayer(Player p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
    }

    public void updatePlayer(Player p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
    }

    @SuppressWarnings("unchecked")
    public List<Player> listPlayers() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Player").list();
    }

    public Player getPlayerByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Player) session.load(Player.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Player> getPlayersByClub(String club) {
        Query query = sessionFactory.getCurrentSession().
                createQuery("from Player where club=:club");
        query.setParameter("club", club);
        return query.list();
    }

    public void removePlayer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Player p = (Player) session.load(Player.class, id);
        if (null != p) {
            session.delete(p);
        }
    }
}

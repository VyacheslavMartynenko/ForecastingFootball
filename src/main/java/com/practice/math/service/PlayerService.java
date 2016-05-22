package com.practice.math.service;

import java.util.List;

import com.practice.math.dao.PlayerDAO;
import com.practice.math.model.Player;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerService {
    private PlayerDAO playerDAO;

    public void setPlayerDAO(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    @Transactional
    public void addPlayer(Player p) {
        this.playerDAO.addPlayer(p);
    }

    @Transactional
    public void updatePlayer(Player p) {
        this.playerDAO.updatePlayer(p);
    }

    @Transactional
    public List<Player> listPlayers() {
        return this.playerDAO.listPlayers();
    }

    @Transactional
    public Player getPlayerByID(int id) {
        return this.playerDAO.getPlayerByID(id);
    }

    @Transactional
    public List<Player> getPlayersByClub(String club) {
        return this.playerDAO.getPlayersByClub(club);
    }

    @Transactional
    public void removePlayer(int id) {
        this.playerDAO.removePlayer(id);
    }

}
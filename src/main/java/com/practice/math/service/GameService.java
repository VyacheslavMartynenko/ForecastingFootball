package com.practice.math.service;

import com.practice.math.dao.GameDAO;
import com.practice.math.model.Game;
import com.practice.math.model.Player;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    private GameDAO gameDAO;

    public void setGameDAO(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @Transactional
    public void addGame(Game p) {
        this.gameDAO.addGame(p);
    }

    @Transactional
    public void updateGame(Game p) {
        this.gameDAO.updateGame(p);
    }

    @Transactional
    public List<Game> listGames() {
        return this.gameDAO.listGames();
    }

    @Transactional
    public Game getGameByID(int id) {
        return this.gameDAO.getGameByID(id);
    }

    @Transactional
    public List<Game> getGamesByClub(String club) {
        return this.gameDAO.getGamesByClub(club);
    }

    @Transactional
    public List<Game> getGamesByClubs(String firstClub, String secondClub) {
        return this.gameDAO.getGamesByClubs(firstClub, secondClub);
    }

    @Transactional
    public void removeGame(int id) {
        this.gameDAO.removeGame(id);
    }

}

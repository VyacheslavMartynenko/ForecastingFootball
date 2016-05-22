package com.practice.math.service;

import java.util.List;

import com.practice.math.dao.ClubDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.math.model.Club;

@Service
public class ClubService{
    private ClubDAO clubDAO;

    public void setClubDAO(ClubDAO clubDAO) {
        this.clubDAO = clubDAO;
    }

    @Transactional
    public void addClub(Club p) {
        this.clubDAO.addClub(p);
    }

    @Transactional
    public void updateClub(Club p) {
        this.clubDAO.updateClub(p);
    }

    @Transactional
    public List<Club> listClubs() {
        return this.clubDAO.listClubs();
    }

    @Transactional
    public Club getClubByID(int id) {
        return this.clubDAO.getClubByID(id);
    }

    @Transactional
    public Club getClubByName(String name) {
        return this.clubDAO.getClubByName(name);
    }

    @Transactional
    public void removeClub(int id) {
        this.clubDAO.removeClub(id);
    }

}

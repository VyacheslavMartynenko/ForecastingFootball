package com.practice.math.service;

import java.util.List;

import com.practice.math.dao.ResultDAO;
import com.practice.math.model.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResultService {
    private ResultDAO resultDAO;

    public void setResultDAO(ResultDAO resultDAO) {
        this.resultDAO = resultDAO;
    }

    @Transactional
    public void addResult(Result p) {
        this.resultDAO.addResult(p);
    }

    @Transactional
    public void updateResult(Result p) {
        this.resultDAO.updateResult(p);
    }

    @Transactional
    public List<Result> listResults() {
        return this.resultDAO.listResults();
    }

    @Transactional
    public Result getResultByID(int id) {
        return this.resultDAO.getResultByID(id);
    }

    @Transactional
    public void removeResult(int id) {
        this.resultDAO.removeResult(id);
    }

}

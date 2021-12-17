package main.repository;

import main.entity.New;

import java.util.List;

public interface NewsRepository {
    List<New> getNews();
}
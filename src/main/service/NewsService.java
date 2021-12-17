package main.service;

import main.entity.New;
import main.repository.NewsRepository;

import java.util.List;

public class NewsService {
    private NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<New> getNews() {
        return newsRepository.getNews();
    }
}
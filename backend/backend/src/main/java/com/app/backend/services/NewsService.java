package com.app.backend.services;

import com.app.backend.model.News;
import com.app.backend.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public Optional<News> getNewsById(Long id) {
        return newsRepository.findById(id);
    }

    public News createNews(News news) {
        return newsRepository.save(news);
    }

    public News updateNews(Long id, News updatedNews) {
        return newsRepository.findById(id).map(news -> {
            news.setTitle(updatedNews.getTitle());
            news.setDescription(updatedNews.getDescription());
            news.setImage_url(updatedNews.getImage_url());
            news.setContent(updatedNews.getContent());
            news.getCategory().setId(updatedNews.getCategory().getId());
            return newsRepository.save(news);
        }).orElseThrow(() -> new RuntimeException("news not found"));
    }

    public void deleteNews(Long id) {
        if (!newsRepository.existsById(id)) {
            throw new RuntimeException("news not found");
        }
        newsRepository.deleteById(id);
    }
}

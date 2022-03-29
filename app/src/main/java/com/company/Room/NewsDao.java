package com.company.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.company.models.News;

import java.util.List;

@Dao
public interface NewsDao {

    @Query("SELECT * FROM news ORDER BY createdAt DESC")
    List<News> getAll();

    @Query("SELECT * FROM news ORDER BY title ASC")
    List<News> getAZ();

    @Insert
    void insert(News news);

    @Update
    void update(News news);



    @Query("SELECT * FROM news WHERE title LIKE :search ORDER BY title")
    List<News> searchNews(String search);

    @Delete
    void delete(News news);
    }

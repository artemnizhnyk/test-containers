package com.artemnizhnyk.testcontainers.repository;

import com.artemnizhnyk.testcontainers.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = """
            UPDATE posts
            SET views_amount = views_amount + 1
            WHERE id = :id
            """, nativeQuery = true)
    @Modifying
    void addView(@Param("id") long id);

}

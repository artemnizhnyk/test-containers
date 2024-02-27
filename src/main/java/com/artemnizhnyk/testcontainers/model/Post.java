package com.artemnizhnyk.testcontainers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "posts")
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1024)
    private String title;

    @Column(length = 16384)
    private String text;

    private long viewsAmount;

    public Post(String title, String text) {
        this.title = title;
        this.text = text;
    }

}
package com.jhemeson.ferramentaprodutividadeback.entity;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer pages;
    @Column(nullable = false)
    private Integer chapters;
    @Column(nullable = false, unique = true)
    private String isbn;
    @Column(nullable = false, name = "publisher_name")
    private String publisherName;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "author_id")
    private Author author;
}

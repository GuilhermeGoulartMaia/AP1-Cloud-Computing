package br.edu.ibmec.model;


import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private LocalDateTime dtPublish;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private String article;

    @Column(nullable=false)
    private String author;

    

    @OneToMany(cascade = jakarta.persistence.CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private List<Comment> comments;
    
    public String getArticle() {
        return article;
    }
    public void setArticle(String article) {
        this.article = article;
    }

    public LocalDateTime getDtPublish() {
        return dtPublish;
    }
    public void setDtPublish(LocalDateTime dtPublish) {
        this.dtPublish = dtPublish;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    
}

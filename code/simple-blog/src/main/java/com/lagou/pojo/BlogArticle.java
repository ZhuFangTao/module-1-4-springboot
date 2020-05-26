package com.lagou.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * \* User: ZhuFangTao
 * \* Date: 2020/5/26 10:24 上午
 * \
 */
@Entity(name = "t_article")
public class BlogArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @Column(name="created")
    private Date createdDate;

    @Column(name="modified")
    private Date modifiedDate;

    private String categories;

    private String tags;

    @Column(name="allow_comment")
    private int allowComment;

    private String thumbnail;

    public Long getId() {
        return id;
    }

    public BlogArticle setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BlogArticle setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public BlogArticle setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public BlogArticle setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public BlogArticle setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public String getCategories() {
        return categories;
    }

    public BlogArticle setCategories(String categories) {
        this.categories = categories;
        return this;
    }

    public String getTags() {
        return tags;
    }

    public BlogArticle setTags(String tags) {
        this.tags = tags;
        return this;
    }

    public int getAllowComment() {
        return allowComment;
    }

    public BlogArticle setAllowComment(int allowComment) {
        this.allowComment = allowComment;
        return this;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public BlogArticle setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    @Override
    public String toString() {
        return "BlogArticle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", categories='" + categories + '\'' +
                ", tags='" + tags + '\'' +
                ", allowComment=" + allowComment +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
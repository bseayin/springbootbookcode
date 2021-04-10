package com.zz.vo;

import lombok.Data;

@Data
public class ArticleVO {
    private int id;
    private int read;
    private int comment_count;
    private int category_id;
    private int like_count;
    private int is_like;
    private int is_favorite;
    private String title;
    private String content;
    private String source;
    private String source_url;
    private String photo_url;
    private String create_time;
    private LinkVO link;
}

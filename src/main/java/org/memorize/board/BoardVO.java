package org.memorize.board;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class BoardVO {
    private Integer id;
    private String writer;
    private String title;
    private String content;
    private String date;

    public Integer getId() {
        return id;
    }
    public String getWriter() {
        return writer;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public String getDate() {
        return date;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setDate() {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String strDate = date.format(now);
        System.out.println(strDate);
        this.date = strDate;
    }
}

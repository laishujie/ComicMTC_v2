package com.lai.comicmtc_v2.db;

import org.litepal.crud.LitePalSupport;

/**
 * @author Lai
 * @time 2019/10/8 16:54
 * @describe 已读章节
 */
public class ReadChapter extends LitePalSupport {
    //对应的章节Id和名字
    private String chapter_id;
    private String chapterName;
    //对应的书ID和名字
    private String comicId;
    private String comicName;
    private String type;
    //读到第几页
    private int readPosition;

    public int getReadPosition() {
        return readPosition;
    }

    public void setReadPosition(int readPosition) {
        this.readPosition = readPosition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(String chapter_id) {
        this.chapter_id = chapter_id;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getComicId() {
        return comicId;
    }

    public void setComicId(String comicId) {
        this.comicId = comicId;
    }

    public String getComicName() {
        return comicName;
    }

    public void setComicName(String comicName) {
        this.comicName = comicName;
    }
}

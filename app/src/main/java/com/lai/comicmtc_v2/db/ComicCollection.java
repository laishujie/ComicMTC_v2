package com.lai.comicmtc_v2.db;

import org.litepal.crud.LitePalSupport;

/**
 * @author Lai
 * @time 2019/10/14 1:47
 * @describe describe
 */
public class ComicCollection extends LitePalSupport {
    //对应的书ID和名字
    private String comicId;
    private String comicName;
    private String coverUrl;
    private int comicSize;
    private int readChapterPosition;

    public int getComicSize() {
        return comicSize;
    }

    public void setComicSize(int comicSize) {
        this.comicSize = comicSize;
    }

    public int getReadChapterPosition() {
        return readChapterPosition;
    }

    public void setReadChapterPosition(int readChapterPosition) {
        this.readChapterPosition = readChapterPosition;
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

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}

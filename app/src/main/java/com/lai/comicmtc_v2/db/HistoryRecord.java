package com.lai.comicmtc_v2.db;

import org.litepal.crud.LitePalSupport;

import java.util.Date;

/**
 * @author Lai
 * @time 2019/10/15 15:40
 * @describe describe
 */
public class HistoryRecord extends LitePalSupport {
    private String comicId;
    private String name;
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getComicId() {
        return comicId;
    }

    public void setComicId(String comicId) {
        this.comicId = comicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

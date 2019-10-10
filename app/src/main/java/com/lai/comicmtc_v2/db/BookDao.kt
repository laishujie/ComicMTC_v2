package com.lai.comicmtc_v2.db

import com.lai.comicmtc_v2.bean.detail.ComicDetailResponse
import org.litepal.LitePal

/**
 *
 * @author  Lai
 *
 * @time 2019/10/9 1:34
 * @describe describe
 *
 */
class BookDao {

    /**
     * 保存chapter
     */
    fun saveReadChapter(
        book: ComicDetailResponse.ComicBean,
        chapterListBean: ComicDetailResponse.ChapterListBean
    ): Boolean {
        val chapter = ReadChapter()
        chapter.comicId = book.comic_id
        chapter.comicName = book.name
        chapter.chapter_id = chapterListBean.chapter_id
        chapter.chapterName = chapterListBean.name
        chapter.type = chapterListBean.type
        return chapter.save()
    }

    /**
     * 保存chapter
     */
    fun saveReadChapter(
            comicId: String,
            comicName: String,
            chapterListBean: ComicDetailResponse.ChapterListBean
    ): Boolean {
        val chapter = ReadChapter()
        chapter.comicId = comicId
        chapter.comicName = comicName
        chapter.chapter_id = chapterListBean.chapter_id
        chapter.chapterName = chapterListBean.name
        chapter.type = chapterListBean.type
        return chapter.save()
    }

    /**
     * 找到最近读取的章节
     */
    fun findLastReadChapter(comicId: String): ReadChapter? {
        return LitePal.where("comicId=?", comicId).findLast(ReadChapter::class.java)
    }

    /**
     *找到所有已读章节
     */
    fun finReadChapterList(comicId: String?): List<ReadChapter> {
        return LitePal.where("comicId=?", comicId).find(ReadChapter::class.java)
    }


}
package com.lai.comicmtc_v2.db

import com.lai.comicmtc_v2.bean.detail.ComicDetailResponse
import org.litepal.LitePal
import org.litepal.extension.findFirst

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
     * 保存chapter阅读记录
     */
    fun saveReadChapter(
        comicId: String,
        comicName: String,
        chapter_id: String,
        chapterName: String,
        type: String
    ): Boolean {
        val chapter = ReadChapter()
        chapter.comicId = comicId
        chapter.comicName = comicName
        chapter.chapter_id = chapter_id
        chapter.chapterName = chapterName
        chapter.type = type
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

    /**
     * 保存阅读位置
     */
    fun saveReadPosition(chapter_id: String, position: Int): Boolean {
        LitePal.where("chapter_id=?", chapter_id).find(ReadChapter::class.java)?.apply {
            if (this.isNotEmpty()) {
                val bean = get(0)
                bean.readPosition = position
                return bean.save()
            }
        }
        return false
    }

    fun finReadChapterById(chapter_id: String): ReadChapter? {
        LitePal.where("chapter_id=?", chapter_id).find(ReadChapter::class.java)?.apply {
            if (this.isNotEmpty()) {
               return get(0)
            }
        }
        return null
    }

    fun saveCollection(comicBean: ComicDetailResponse.ComicBean):Boolean{
        val collection = ComicCollection()
        collection.comicId = comicBean.comic_id
        collection.comicName = comicBean.name
        collection.coverUrl = comicBean.cover
        return  collection.save()
    }

    fun findCollection(comicId:String):ComicCollection?{
       return  LitePal.where("comicId=?", comicId).findFirst<ComicCollection>()
    }

    fun  deleteCollection(comicId:String):Int{
        findCollection(comicId)?.apply {
            return delete()
        }
        return 0
    }


}
package com.lai.comicmtc_v2.bean.search;

import java.util.List;

/**
 * @author Lai
 * @time 2019/10/15 15:03
 * @describe describe
 */
public class SeachHotResponse {

    /**
     * hotItems : [{"comic_id":"184252","name":"法师与猹","bgColor":"#D8577340"},{"comic_id":"195","name":"雏蜂","bgColor":"#D8138D7E"},{"comic_id":"99679","name":"崩坏3rd","bgColor":"#D85DA446"},{"comic_id":"68471","name":"鬼刀","bgColor":"#D800A652"},{"comic_id":"75859","name":"噬规者","bgColor":"#D8F5702D"},{"comic_id":"71064","name":"斗罗大陆","bgColor":"#D8AF8B6B"},{"comic_id":"8805","name":"虎x鹤 妖师录","bgColor":"#D8F8A032"},{"comic_id":"190","name":"拜见女皇陛下","bgColor":"#D89DA23E"},{"comic_id":"3166","name":"镇魂街","bgColor":"#D8784B8E"},{"comic_id":"120824","name":"西行纪","bgColor":"#D8527FC2"},{"comic_id":"177465","name":"十三生笑","bgColor":"#D87B7B93"}]
     * defaultSearch : 鬼刀
     */

    private String defaultSearch;
    private List<HotItemsBean> hotItems;

    public String getDefaultSearch() {
        return defaultSearch;
    }

    public void setDefaultSearch(String defaultSearch) {
        this.defaultSearch = defaultSearch;
    }

    public List<HotItemsBean> getHotItems() {
        return hotItems;
    }

    public void setHotItems(List<HotItemsBean> hotItems) {
        this.hotItems = hotItems;
    }

    public static class HotItemsBean {
        /**
         * comic_id : 184252
         * name : 法师与猹
         * bgColor : #D8577340
         */

        private String comic_id;
        private String name;
        private String bgColor;

        public String getComic_id() {
            return comic_id;
        }

        public void setComic_id(String comic_id) {
            this.comic_id = comic_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBgColor() {
            return bgColor;
        }

        public void setBgColor(String bgColor) {
            this.bgColor = bgColor;
        }
    }
}

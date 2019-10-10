package com.lai.comicmtc_v2.bean.detail;

import android.os.Parcel;
import android.os.Parcelable;

import com.lai.comicmtc_v2.db.ReadChapter;

import java.util.List;

/**
 * @author Lai
 * @time 2019/10/3 15:29
 * @describe describe
 */
public class ComicDetailResponse {

    /**
     * comic : {"name":"我在日本当道士","comic_id":"181258","short_description":"玉藻前与田中真守","accredit":3,"cover":"http://cover.u17i.com/2019/05/19018611_1557285656_37mvvVXjvMPm.sbig.jpg","is_vip":"0","type":"0","ori":"http://cover.u17i.com/temp/2019/05/19018611_1557285656_37mvvVXjvMPm.jpg","theme_ids":["少年","搞笑","魔幻"],"series_status":"0","last_update_time":1569945610,"description":"【周三、周五更新】鹤姬山，时常妖怪出没，生气的玉藻前大人要报仇。而她的仇家竟是一个普通的男高中生\u2014\u2014田中真守，玉藻前大人跟田中真守有过什么矛盾呢\u2026\u2026","cate_id":"故事漫画","status":2,"thread_id":"32008021","last_update_week":"","wideCover":"http://cover.u17i.com/2019/05/19018611_1557285692_qZjAyC8MYBYI.ubig.jpg","classifyTags":[{"name":"少年","argName":"cate","argVal":1},{"name":"搞笑","argName":"theme","argVal":1},{"name":"魔幻","argName":"theme","argVal":2}],"is_week":1,"level":"A级","comic_color":"彩漫","author":{"avatar":"http://k.avatar.u17i.com/2019/0105/19018611_ae90abcf59bffc15e171d80ebfadae8c_1546679633.big.png","name":"火龙传媒","id":"19018611"},"is_dub":0}
     * chapter_list : [{"name":"预告","image_total":"11","chapter_id":"834515","type":"0","price":"0","size":"0","pass_time":"1547136520","release_time":"0","zip_high_webp":"792632","crop_zip_size":"792632","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1131","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":11},{"name":"第一话：生气的玉藻前大人","image_total":"20","chapter_id":"835230","type":"0","price":"0","size":"0","pass_time":"1547459363","release_time":"1547568000","zip_high_webp":"1396616","crop_zip_size":"1396616","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":20},{"name":"第二话：那个男人","image_total":"16","chapter_id":"835231","type":"0","price":"0","size":"0","pass_time":"1547459377","release_time":"1547654400","zip_high_webp":"977786","crop_zip_size":"977786","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":16},{"name":"第三话：她究竟想干嘛？","image_total":"12","chapter_id":"835233","type":"0","price":"0","size":"0","pass_time":"1547459449","release_time":"1547740800","zip_high_webp":"747605","crop_zip_size":"747605","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1131","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1131","width":"800"}]],"countImHightArr":12},{"name":"第四话：这个道士坏得很","image_total":"15","chapter_id":"836869","type":"0","price":"0","size":"0","pass_time":"1548051174","release_time":"1548172800","zip_high_webp":"1032019","crop_zip_size":"1032019","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":15},{"name":"第五话：这个少女好疯狂","image_total":"12","chapter_id":"836872","type":"0","price":"0","size":"0","pass_time":"1548051233","release_time":"1548432000","zip_high_webp":"853591","crop_zip_size":"853591","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":12},{"name":"第六话：羞涩的好斗少女","image_total":"19","chapter_id":"837428","type":"0","price":"0","size":"0","pass_time":"1548255480","release_time":"1548604800","zip_high_webp":"1452649","crop_zip_size":"1452649","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":19},{"name":"第七话：柿丘的风纪委员","image_total":"10","chapter_id":"837434","type":"0","price":"0","size":"0","pass_time":"1548255485","release_time":"1548691200","zip_high_webp":"805067","crop_zip_size":"805067","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":10},{"name":"第八话：奇怪的社团","image_total":"14","chapter_id":"837435","type":"0","price":"0","size":"0","pass_time":"1548255493","release_time":"1548777600","zip_high_webp":"1090189","crop_zip_size":"1090189","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第九话：心塞的妖狐","image_total":"16","chapter_id":"837436","type":"0","price":"0","size":"0","pass_time":"1548255499","release_time":"1548864000","zip_high_webp":"1317365","crop_zip_size":"1317365","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":16},{"name":"第十话：一缕残丝唤泉子","image_total":"15","chapter_id":"837438","type":"0","price":"0","size":"0","pass_time":"1548255509","release_time":"1548950400","zip_high_webp":"1071604","crop_zip_size":"1071604","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":15},{"name":"第十一话：泉子灵魂的所在","image_total":"12","chapter_id":"837440","type":"0","price":"0","size":"0","pass_time":"1548255516","release_time":"1549036800","zip_high_webp":"933403","crop_zip_size":"933403","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":12},{"name":"第十二话：臭道士，你想干嘛！","image_total":"10","chapter_id":"837808","type":"0","price":"0","size":"0","pass_time":"1548342526","release_time":"1549123200","zip_high_webp":"629139","crop_zip_size":"629139","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":10},{"name":"第十三话：你以为你跑得掉吗！","image_total":"15","chapter_id":"837957","type":"0","price":"0","size":"0","pass_time":"1548399532","release_time":"1549382400","zip_high_webp":"1190365","crop_zip_size":"1190365","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":15},{"name":"第十四话：万雷天牢破","image_total":"12","chapter_id":"837958","type":"0","price":"0","size":"0","pass_time":"1548399542","release_time":"1549641600","zip_high_webp":"975810","crop_zip_size":"975810","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1130","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":12},{"name":"第十五话：六尾妖狐显形","image_total":"10","chapter_id":"839531","type":"0","price":"0","size":"0","pass_time":"1548903201","release_time":"1549987200","zip_high_webp":"780717","crop_zip_size":"780717","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":10},{"name":"第十六话：勾玉的秘密","image_total":"14","chapter_id":"839532","type":"0","price":"0","size":"4294967295","pass_time":"1550042021","release_time":"1550246400","zip_high_webp":"924119","crop_zip_size":"921131","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第十七话：剿灭恶灵","image_total":"15","chapter_id":"842643","type":"0","price":"0","size":"0","pass_time":"1550329942","release_time":"1550592000","zip_high_webp":"1113483","crop_zip_size":"1113483","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":15},{"name":"第十八话：怀中抱妹杀","image_total":"14","chapter_id":"842644","type":"0","price":"0","size":"0","pass_time":"1550329984","release_time":"1550851200","zip_high_webp":"775883","crop_zip_size":"775883","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第十九话：我就住这了","image_total":"13","chapter_id":"844159","type":"0","price":"0","size":"0","pass_time":"1550847566","release_time":"1551196800","zip_high_webp":"835755","crop_zip_size":"835755","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第二十话：我和我的兽耳娘妹妹","image_total":"13","chapter_id":"844161","type":"0","price":"0","size":"0","pass_time":"1550847619","release_time":"1551456000","zip_high_webp":"916569","crop_zip_size":"916569","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第二十一话：我对小帅哥更感兴趣","image_total":"15","chapter_id":"846795","type":"0","price":"0","size":"0","pass_time":"1551881667","release_time":"1552060800","zip_high_webp":"1255886","crop_zip_size":"1255886","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":15},{"name":"第二十二话：旧伤发作","image_total":"15","chapter_id":"848286","type":"0","price":"0","size":"0","pass_time":"1552616047","release_time":"1552665600","zip_high_webp":"1199896","crop_zip_size":"1199896","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":15},{"name":"第二十三话：我阻止不了这个男人","image_total":"27","chapter_id":"849583","type":"0","price":"0","size":"0","pass_time":"1553134238","release_time":"1553184000","zip_high_webp":"2279546","crop_zip_size":"2279546","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":27},{"name":"第二十四话：田中君是我的！","image_total":"13","chapter_id":"850836","type":"0","price":"0","size":"0","pass_time":"1553675738","release_time":"1553788800","zip_high_webp":"1098607","crop_zip_size":"1098607","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第二十五话：他们这是在干嘛？","image_total":"16","chapter_id":"851920","type":"0","price":"0","size":"4294967295","pass_time":"1554125753","release_time":"1554220800","zip_high_webp":"1192981","crop_zip_size":"1192215","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":16},{"name":"第二十六话：会飞的\u201c胖次\u201d","image_total":"16","chapter_id":"852602","type":"0","price":"0","size":"0","pass_time":"1554357062","release_time":"1554393600","zip_high_webp":"1106484","crop_zip_size":"1106484","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":16},{"name":"第二十七话：偷内裤的妖怪","image_total":"14","chapter_id":"853639","type":"0","price":"0","size":"8398203","pass_time":"1554801343","release_time":"1554825600","zip_high_webp":"1033736","crop_zip_size":"1033736","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1020","width":"720"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第二十八话：绘里家有妖气","image_total":"14","chapter_id":"853928","type":"0","price":"0","size":"0","pass_time":"1554960091","release_time":"1554998400","zip_high_webp":"1249172","crop_zip_size":"1249172","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第二十九话：羞羞的诱饵","image_total":"14","chapter_id":"854851","type":"0","price":"0","size":"0","pass_time":"1555348065","release_time":"1555430400","zip_high_webp":"1193234","crop_zip_size":"1193234","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第三十话：没有气息的结界","image_total":"15","chapter_id":"855310","type":"0","price":"0","size":"0","pass_time":"1555567390","release_time":"1555603200","zip_high_webp":"1158780","crop_zip_size":"1158780","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":15},{"name":"第三十一话：孽缘啊孽缘","image_total":"14","chapter_id":"856255","type":"0","price":"0","size":"0","pass_time":"1556011495","release_time":"1556035200","zip_high_webp":"1048739","crop_zip_size":"1048739","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第三十二话：天才阴阳师","image_total":"12","chapter_id":"856678","type":"0","price":"0","size":"0","pass_time":"1556182891","release_time":"1556218800","zip_high_webp":"953290","crop_zip_size":"953290","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":12},{"name":"第三十三话：失心咒","image_total":"15","chapter_id":"857597","type":"0","price":"0","size":"0","pass_time":"1556599263","release_time":"1556640000","zip_high_webp":"1167812","crop_zip_size":"1167812","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":15},{"name":"第三十四话：古庙里的木偶","image_total":"14","chapter_id":"857600","type":"0","price":"0","size":"0","pass_time":"1556599285","release_time":"1556812800","zip_high_webp":"1119471","crop_zip_size":"1119471","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第三十五话：中计","image_total":"14","chapter_id":"858873","type":"0","price":"0","size":"0","pass_time":"1557153001","release_time":"1557244800","zip_high_webp":"1115156","crop_zip_size":"1115156","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第三十六话：埋在花坛下的盒子","image_total":"12","chapter_id":"859159","type":"0","price":"0","size":"0","pass_time":"1557311697","release_time":"1557417600","zip_high_webp":"1013216","crop_zip_size":"1013216","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":12},{"name":"第三十七话：你究竟是何人","image_total":"14","chapter_id":"860090","type":"0","price":"0","size":"0","pass_time":"1557813319","release_time":"1557849600","zip_high_webp":"1208652","crop_zip_size":"1208652","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第三十八话：不服气的阴阳师","image_total":"13","chapter_id":"860590","type":"0","price":"0","size":"0","pass_time":"1558005553","release_time":"1558040400","zip_high_webp":"997804","crop_zip_size":"997804","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第三十九话：女生变光头！","image_total":"13","chapter_id":"861555","type":"0","price":"0","size":"0","pass_time":"1558419108","release_time":"1558454400","zip_high_webp":"931409","crop_zip_size":"931409","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第四十话：想要我的内衣吗","image_total":"13","chapter_id":"861897","type":"0","price":"0","size":"0","pass_time":"1558594064","release_time":"1558627200","zip_high_webp":"957844","crop_zip_size":"957844","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第四十一话：食发鬼","image_total":"14","chapter_id":"862789","type":"0","price":"0","size":"0","pass_time":"1559024467","release_time":"1559059200","zip_high_webp":"1024015","crop_zip_size":"1024015","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第四十二话：输了，随你怎么样","image_total":"14","chapter_id":"863379","type":"0","price":"0","size":"0","pass_time":"1559203250","release_time":"1559242800","zip_high_webp":"1237921","crop_zip_size":"1237921","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第四十三话：桃子，你别误会","image_total":"12","chapter_id":"864330","type":"0","price":"0","size":"0","pass_time":"1559631031","release_time":"1559664000","zip_high_webp":"22","crop_zip_size":"22","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":12},{"name":"第四十四话：枯死的树根","image_total":"13","chapter_id":"864832","type":"0","price":"0","size":"0","pass_time":"1559813041","release_time":"1559854800","zip_high_webp":"1115911","crop_zip_size":"1115911","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1132","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第四十五话：许愿之树","image_total":"14","chapter_id":"865700","type":"0","price":"0","size":"0","pass_time":"1560235021","release_time":"1560268800","zip_high_webp":"1099020","crop_zip_size":"1099020","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第四十六话：我扒了你的树皮","image_total":"13","chapter_id":"866138","type":"0","price":"0","size":"0","pass_time":"1560430423","release_time":"1560459600","zip_high_webp":"912973","crop_zip_size":"912973","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第四十七话：你不是这里的人","image_total":"12","chapter_id":"867125","type":"0","price":"0","size":"0","pass_time":"1560911255","release_time":"1560877200","zip_high_webp":"1101920","crop_zip_size":"1101920","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1116","width":"800"}],[{"height":"1116","width":"800"}],[{"height":"1116","width":"800"}],[{"height":"1116","width":"800"}],[{"height":"1116","width":"800"}],[{"height":"1116","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1116","width":"800"}],[{"height":"1116","width":"800"}]],"countImHightArr":12},{"name":"第四十八话：神秘的符号","image_total":"12","chapter_id":"867229","type":"0","price":"0","size":"4294967295","pass_time":"1560947386","release_time":"1561046400","zip_high_webp":"874222","crop_zip_size":"872632","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":12},{"name":"第四十九话：校园祭","image_total":"14","chapter_id":"868617","type":"0","price":"0","size":"10476544","pass_time":"1561440782","release_time":"1561478400","zip_high_webp":"1307822","crop_zip_size":"1307822","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第五十话：狐狸毛挂件","image_total":"12","chapter_id":"869047","type":"0","price":"0","size":"4294967295","pass_time":"1561702495","release_time":"1561651200","zip_high_webp":"950202","crop_zip_size":"949374","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1116","width":"800"}],[{"height":"1116","width":"800"}],[{"height":"1116","width":"800"}],[{"height":"1116","width":"800"}],[{"height":"1116","width":"800"}],[{"height":"1116","width":"800"}],[{"height":"1116","width":"800"}],[{"height":"1116","width":"800"}],[{"height":"1116","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":12},{"name":"第五十一话：桃子，你要冷静！","image_total":"12","chapter_id":"870024","type":"0","price":"0","size":"0","pass_time":"1562045031","release_time":"1562083200","zip_high_webp":"828217","crop_zip_size":"828217","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":12},{"name":"第五十二话：哪有不害人的妖!","image_total":"12","chapter_id":"870507","type":"0","price":"0","size":"0","pass_time":"1562204495","release_time":"1562256000","zip_high_webp":"993439","crop_zip_size":"993439","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":12},{"name":"第五十三话：帮着妖怪的阴阳师","image_total":"12","chapter_id":"870730","type":"0","price":"0","size":"4294967295","pass_time":"1562325723","release_time":"0","zip_high_webp":"988500","crop_zip_size":"987692","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":12},{"name":"第五十四话：师妹怎么来日本了！","image_total":"13","chapter_id":"870731","type":"0","price":"0","size":"4294967295","pass_time":"1562325734","release_time":"1562428800","zip_high_webp":"998652","crop_zip_size":"997844","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第五十五话：麻将社社长","image_total":"11","chapter_id":"871612","type":"0","price":"0","size":"0","pass_time":"1562672358","release_time":"1562713200","zip_high_webp":"763496","crop_zip_size":"763496","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1129","width":"800"}],[{"height":"1129","width":"800"}],[{"height":"1129","width":"800"}],[{"height":"1129","width":"800"}],[{"height":"1129","width":"800"}],[{"height":"1129","width":"800"}],[{"height":"1129","width":"800"}]],"countImHightArr":11},{"name":"第五十六话：快点走，别被认出来!","image_total":"11","chapter_id":"872057","type":"0","price":"0","size":"0","pass_time":"1562831844","release_time":"1562878800","zip_high_webp":"740775","crop_zip_size":"740775","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":11},{"name":"第五十七话：以后的日子可怎么过","image_total":"13","chapter_id":"873101","type":"0","price":"0","size":"0","pass_time":"1563269062","release_time":"1563310800","zip_high_webp":"1112996","crop_zip_size":"1112996","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第五十八话：桃子，我们回家吧！","image_total":"12","chapter_id":"873460","type":"0","price":"0","size":"4294967295","pass_time":"1563454383","release_time":"1563487200","zip_high_webp":"846867","crop_zip_size":"838616","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":12},{"name":"第五十九话：你们听我解释！","image_total":"11","chapter_id":"874306","type":"0","price":"0","size":"0","pass_time":"1563804944","release_time":"1563897600","zip_high_webp":"898426","crop_zip_size":"898426","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1117","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1115","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1117","width":"800"}]],"countImHightArr":11},{"name":"第六十话：女人真是难以理解！","image_total":"14","chapter_id":"874887","type":"0","price":"0","size":"0","pass_time":"1564065975","release_time":"1564088400","zip_high_webp":"1117193","crop_zip_size":"1117193","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第六十一话：引魂聚煞！","image_total":"12","chapter_id":"875931","type":"0","price":"0","size":"0","pass_time":"1564470976","release_time":"1564524000","zip_high_webp":"870344","crop_zip_size":"870344","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":12},{"name":"第六十二话：鬼屋有鬼！","image_total":"16","chapter_id":"876428","type":"0","price":"0","size":"0","pass_time":"1564657596","release_time":"1564696800","zip_high_webp":"1169761","crop_zip_size":"1169761","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":16},{"name":"第六十三话：秒杀！","image_total":"13","chapter_id":"877415","type":"0","price":"0","size":"0","pass_time":"1565069940","release_time":"1565121600","zip_high_webp":"1128268","crop_zip_size":"1128268","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第六十四话：你一点都不好奇吗？","image_total":"12","chapter_id":"877882","type":"0","price":"0","size":"0","pass_time":"1565259484","release_time":"1565305200","zip_high_webp":"956340","crop_zip_size":"956340","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":12},{"name":"第六十五话：邀请","image_total":"13","chapter_id":"878795","type":"0","price":"0","size":"0","pass_time":"1565668031","release_time":"1565712000","zip_high_webp":"851287","crop_zip_size":"851287","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第六十六话：修复封印","image_total":"13","chapter_id":"879090","type":"0","price":"0","size":"0","pass_time":"1565841031","release_time":"1565884800","zip_high_webp":"1086140","crop_zip_size":"1086140","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第六十七话：答谢宴","image_total":"13","chapter_id":"879434","type":"0","price":"0","size":"0","pass_time":"1565953542","release_time":"1566316800","zip_high_webp":"1023342","crop_zip_size":"1023342","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第六十八话：田中君，你没事吧","image_total":"13","chapter_id":"883004","type":"0","price":"0","size":"0","pass_time":"1566464819","release_time":"1566507600","zip_high_webp":"973082","crop_zip_size":"973082","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第六十九话：绘里不见了","image_total":"13","chapter_id":"885397","type":"0","price":"0","size":"0","pass_time":"1566888984","release_time":"1566921600","zip_high_webp":"829473","crop_zip_size":"829473","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第七十话：营救！","image_total":"13","chapter_id":"885965","type":"0","price":"0","size":"0","pass_time":"1567072280","release_time":"1567119600","zip_high_webp":"836641","crop_zip_size":"836641","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第七十一话：我当然是绑匪啦","image_total":"14","chapter_id":"886747","type":"0","price":"0","size":"0","pass_time":"1567420722","release_time":"1567526400","zip_high_webp":"973776","crop_zip_size":"973776","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第七十二话：两位小姐，你们好","image_total":"15","chapter_id":"887182","type":"0","price":"0","size":"0","pass_time":"1567662110","release_time":"1567699200","zip_high_webp":"1242541","crop_zip_size":"1242541","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":15},{"name":"第七十三话：你果然是不行！","image_total":"16","chapter_id":"888054","type":"0","price":"0","size":"0","pass_time":"1568086603","release_time":"1568131200","zip_high_webp":"2295317","crop_zip_size":"2295317","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":16},{"name":"第七十四话：师兄你居然是这种人！","image_total":"15","chapter_id":"888695","type":"0","price":"0","size":"0","pass_time":"1568270116","release_time":"1568322000","zip_high_webp":"1874656","crop_zip_size":"1874656","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":15},{"name":"第七十五话：\u201c贴身\u201d保护","image_total":"14","chapter_id":"889491","type":"0","price":"0","size":"0","pass_time":"1568709567","release_time":"1568743200","zip_high_webp":"1999714","crop_zip_size":"1999714","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第七十六话：该小哥哥发善心了","image_total":"14","chapter_id":"889957","type":"0","price":"0","size":"0","pass_time":"1568894573","release_time":"1568930400","zip_high_webp":"1653722","crop_zip_size":"1653722","is_new":0,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1129","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":14},{"name":"第七十七话：表姐，她们只是租客","image_total":"13","chapter_id":"890759","type":"0","price":"0","size":"0","pass_time":"1569311275","release_time":"1569340800","zip_high_webp":"2030730","crop_zip_size":"2030730","is_new":1,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第七十八话：好好享受吧，少年！","image_total":"13","chapter_id":"891133","type":"0","price":"0","size":"0","pass_time":"1569490107","release_time":"1569513600","zip_high_webp":"1637875","crop_zip_size":"1637875","is_new":1,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":13},{"name":"第七十九话：什么鬼！","image_total":"15","chapter_id":"891908","type":"0","price":"0","size":"0","pass_time":"1569749310","release_time":"1569945600","zip_high_webp":"1829277","crop_zip_size":"1829277","is_new":1,"has_locked_image":false,"imHightArr":[[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]],"countImHightArr":15}]
     * otherWorks : []
     */

    private ComicBean comic;
    private List<ChapterListBean> chapter_list;
    private List<?> otherWorks;

    public ComicBean getComic() {
        return comic;
    }

    public void setComic(ComicBean comic) {
        this.comic = comic;
    }

    public List<ChapterListBean> getChapter_list() {
        return chapter_list;
    }

    public void setChapter_list(List<ChapterListBean> chapter_list) {
        this.chapter_list = chapter_list;
    }

    public List<?> getOtherWorks() {
        return otherWorks;
    }

    public void setOtherWorks(List<?> otherWorks) {
        this.otherWorks = otherWorks;
    }

    public static class ComicBean {
        /**
         * name : 我在日本当道士
         * comic_id : 181258
         * short_description : 玉藻前与田中真守
         * accredit : 3
         * cover : http://cover.u17i.com/2019/05/19018611_1557285656_37mvvVXjvMPm.sbig.jpg
         * is_vip : 0
         * type : 0
         * ori : http://cover.u17i.com/temp/2019/05/19018611_1557285656_37mvvVXjvMPm.jpg
         * theme_ids : ["少年","搞笑","魔幻"]
         * series_status : 0
         * last_update_time : 1569945610
         * description : 【周三、周五更新】鹤姬山，时常妖怪出没，生气的玉藻前大人要报仇。而她的仇家竟是一个普通的男高中生——田中真守，玉藻前大人跟田中真守有过什么矛盾呢……
         * cate_id : 故事漫画
         * status : 2
         * thread_id : 32008021
         * last_update_week :
         * wideCover : http://cover.u17i.com/2019/05/19018611_1557285692_qZjAyC8MYBYI.ubig.jpg
         * classifyTags : [{"name":"少年","argName":"cate","argVal":1},{"name":"搞笑","argName":"theme","argVal":1},{"name":"魔幻","argName":"theme","argVal":2}]
         * is_week : 1
         * level : A级
         * comic_color : 彩漫
         * author : {"avatar":"http://k.avatar.u17i.com/2019/0105/19018611_ae90abcf59bffc15e171d80ebfadae8c_1546679633.big.png","name":"火龙传媒","id":"19018611"}
         * is_dub : 0
         */

        private String name;
        private String comic_id;
        private String short_description;
        private int accredit;
        private String cover;
        private String is_vip;
        private String type;
        private String ori;
        private String series_status;
        private int last_update_time;
        private String description;
        private String cate_id;
        private int status;
        private String thread_id;
        private String last_update_week;
        private String wideCover;
        private int is_week;
        private String level;
        private String comic_color;
        private AuthorBean author;
        private int is_dub;
        private List<String> theme_ids;
        private List<ClassifyTagsBean> classifyTags;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getComic_id() {
            return comic_id;
        }

        public void setComic_id(String comic_id) {
            this.comic_id = comic_id;
        }

        public String getShort_description() {
            return short_description;
        }

        public void setShort_description(String short_description) {
            this.short_description = short_description;
        }

        public int getAccredit() {
            return accredit;
        }

        public void setAccredit(int accredit) {
            this.accredit = accredit;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getIs_vip() {
            return is_vip;
        }

        public void setIs_vip(String is_vip) {
            this.is_vip = is_vip;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getOri() {
            return ori;
        }

        public void setOri(String ori) {
            this.ori = ori;
        }

        public String getSeries_status() {
            return series_status;
        }

        public void setSeries_status(String series_status) {
            this.series_status = series_status;
        }

        public int getLast_update_time() {
            return last_update_time;
        }

        public void setLast_update_time(int last_update_time) {
            this.last_update_time = last_update_time;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getThread_id() {
            return thread_id;
        }

        public void setThread_id(String thread_id) {
            this.thread_id = thread_id;
        }

        public String getLast_update_week() {
            return last_update_week;
        }

        public void setLast_update_week(String last_update_week) {
            this.last_update_week = last_update_week;
        }

        public String getWideCover() {
            return wideCover;
        }

        public void setWideCover(String wideCover) {
            this.wideCover = wideCover;
        }

        public int getIs_week() {
            return is_week;
        }

        public void setIs_week(int is_week) {
            this.is_week = is_week;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getComic_color() {
            return comic_color;
        }

        public void setComic_color(String comic_color) {
            this.comic_color = comic_color;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public int getIs_dub() {
            return is_dub;
        }

        public void setIs_dub(int is_dub) {
            this.is_dub = is_dub;
        }

        public List<String> getTheme_ids() {
            return theme_ids;
        }

        public void setTheme_ids(List<String> theme_ids) {
            this.theme_ids = theme_ids;
        }

        public List<ClassifyTagsBean> getClassifyTags() {
            return classifyTags;
        }

        public void setClassifyTags(List<ClassifyTagsBean> classifyTags) {
            this.classifyTags = classifyTags;
        }

        public static class AuthorBean {
            /**
             * avatar : http://k.avatar.u17i.com/2019/0105/19018611_ae90abcf59bffc15e171d80ebfadae8c_1546679633.big.png
             * name : 火龙传媒
             * id : 19018611
             */

            private String avatar;
            private String name;
            private String id;

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class ClassifyTagsBean {
            /**
             * name : 少年
             * argName : cate
             * argVal : 1
             */

            private String name;
            private String argName;
            private int argVal;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getArgName() {
                return argName;
            }

            public void setArgName(String argName) {
                this.argName = argName;
            }

            public int getArgVal() {
                return argVal;
            }

            public void setArgVal(int argVal) {
                this.argVal = argVal;
            }
        }
    }

    public static class ChapterListBean implements Parcelable {
        /**
         * name : 预告
         * image_total : 11
         * chapter_id : 834515
         * type : 0
         * price : 0
         * size : 0
         * pass_time : 1547136520
         * release_time : 0
         * zip_high_webp : 792632
         * crop_zip_size : 792632
         * is_new : 0
         * has_locked_image : false
         * imHightArr : [[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1131","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}],[{"height":"1133","width":"800"}]]
         * countImHightArr : 11
         */


        //private List<List<ImHightArrBean>> imHightArr;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage_total() {
            return image_total;
        }

        public void setImage_total(String image_total) {
            this.image_total = image_total;
        }

        public String getChapter_id() {
            return chapter_id;
        }

        public void setChapter_id(String chapter_id) {
            this.chapter_id = chapter_id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getPass_time() {
            return pass_time;
        }

        public void setPass_time(String pass_time) {
            this.pass_time = pass_time;
        }

        public String getRelease_time() {
            return release_time;
        }

        public void setRelease_time(String release_time) {
            this.release_time = release_time;
        }

        public String getZip_high_webp() {
            return zip_high_webp;
        }

        public void setZip_high_webp(String zip_high_webp) {
            this.zip_high_webp = zip_high_webp;
        }

        public String getCrop_zip_size() {
            return crop_zip_size;
        }

        public void setCrop_zip_size(String crop_zip_size) {
            this.crop_zip_size = crop_zip_size;
        }

        public int getIs_new() {
            return is_new;
        }

        public void setIs_new(int is_new) {
            this.is_new = is_new;
        }

        public boolean isHas_locked_image() {
            return has_locked_image;
        }

        public void setHas_locked_image(boolean has_locked_image) {
            this.has_locked_image = has_locked_image;
        }

        public int getCountImHightArr() {
            return countImHightArr;
        }

        public void setCountImHightArr(int countImHightArr) {
            this.countImHightArr = countImHightArr;
        }

        //覆写equals()方法
        public boolean equals(Object obj) {
            if (obj instanceof ChapterListBean) {
                ChapterListBean bean =  (ChapterListBean)obj;
                if(bean.chapter_id.equals(chapter_id)){
                    return true;
                }
            }
            if(obj instanceof ReadChapter){
                ReadChapter bean =  (ReadChapter)obj;
                if(bean.getChapter_id().equals(chapter_id)){
                    return true;
                }
            }
            return super.equals(obj);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        private String name;
        private String image_total;
        private String chapter_id;
        private String type;
        private String price;
        private String size;
        private String pass_time;
        private String release_time;
        private String zip_high_webp;
        private String crop_zip_size;
        private int is_new;
        private boolean has_locked_image;
        private int countImHightArr;
        private boolean isRead;

        public boolean isRead() {
            return isRead;
        }

        public void setRead(boolean read) {
            isRead = read;
        }

        public static final Creator<ChapterListBean> CREATOR = new Creator<ChapterListBean>() {

            @Override
            public ChapterListBean createFromParcel(Parcel source) {
                ChapterListBean bean = new ChapterListBean();

                bean.name = source.readString();
                bean.image_total = source.readString();
                bean.chapter_id = source.readString();
                bean.type = source.readString();
                bean.price = source.readString();
                bean.size = source.readString();
                bean.pass_time = source.readString();
                bean.release_time = source.readString();
                bean.zip_high_webp = source.readString();
                bean.crop_zip_size = source.readString();
                bean.is_new = source.readInt();
                boolean[] booleans = new boolean[1];
                source.readBooleanArray(booleans);
                bean.has_locked_image = booleans[0];
                bean.countImHightArr = source.readInt();

                boolean[] booleans2 = new boolean[1];
                source.readBooleanArray(booleans2);
                bean.isRead = booleans2[0];
                return bean;
            }

            @Override
            public ChapterListBean[] newArray(int size) {
                return new ChapterListBean[size];
            }
        };

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeString(image_total);
            dest.writeString(chapter_id);
            dest.writeString(type);
            dest.writeString(price);
            dest.writeString(size);
            dest.writeString(pass_time);
            dest.writeString(release_time);
            dest.writeString(zip_high_webp);
            dest.writeString(crop_zip_size);
            dest.writeInt(is_new);
            dest.writeBooleanArray(new boolean[]{has_locked_image});
            dest.writeInt(countImHightArr);
            dest.writeBooleanArray(new boolean[]{isRead});
        }

        /*public List<List<ImHightArrBean>> getImHightArr() {
            return imHightArr;
        }

        public void setImHightArr(List<List<ImHightArrBean>> imHightArr) {
            this.imHightArr = imHightArr;
        }*/

        public static class ImHightArrBean {
            /**
             * height : 1133
             * width : 800
             */

            private String height;
            private String width;

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }
        }
    }


}

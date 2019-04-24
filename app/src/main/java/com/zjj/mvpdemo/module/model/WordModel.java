package com.zjj.mvpdemo.module.model;

import com.zjj.mvpdemo.module.contract.Contract;

import java.util.List;

public class WordModel implements Contract.Model {

    /**
     * rating : {"max":10,"average":"8.6","numRaters":4789,"min":0}
     * author : [{"name":"The Shanghai Restoration Project"}]
     * alt_title : 上海复兴方案
     * image : https://img1.doubanio.com/view/subject/s/public/s2661047.jpg
     * title : The Shanghai Restoration Project
     * mobile_link : https://m.douban.com/music/subject/2337701/
     * summary : The Shanghai Restoration Project / 专辑 / 2006-03-06 / Undercover Culture Music / Audio CD
     * attrs : {"publisher":["Undercover Culture Music"],"singer":["The Shanghai Restoration Project"],"version":["专辑"],"pubdate":["2006-03-06"],"title":["The Shanghai Restoration Project"],"media":["Audio CD"],"radio_url":"https://douban.fm/?context=channel:0|subject_id:2337701","tracks":["Introduction (1936)  1:27\n2.   Nanking Road  3:42\n3.   Shanghai Express  3:46\n4.   Jade Buddha Temple 3:42\n5.   Peace Hotel (What is Love)  3:30\n6.   Miss Shanghai 3:21\n7.   Lu Xun (Watch Me Dance) 3:16\n8.   Babylon of the Orient  3:53\n9.   Pearl Tower  2:58\n10.   Avenue Joffre  4:15\n11.   The Bund  6:31\n12.   Old City  3:54\n13.   Pudong  3:32\n14.   Bubbling Well Road  4:55\n15.   Jessfield Park"],"discs":["1"]}
     * alt : https://music.douban.com/subject/2337701/
     * id : 2337701
     * tags : [{"count":904,"name":"Electronic"},{"count":802,"name":"上海复兴方案"},{"count":432,"name":"电子"},{"count":316,"name":"上海，Lounge，Electronic"},{"count":269,"name":"Lounge"},{"count":245,"name":"jazz"},{"count":180,"name":"jazzyhiphop"},{"count":170,"name":"美国"}]
     */

    private RatingBean rating;
    private String alt_title;
    private String image;
    private String title;
    private String mobile_link;
    private String summary;
    private AttrsBean attrs;
    private String alt;
    private String id;
    private List<AuthorBean> author;
    private List<TagsBean> tags;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public void setAlt_title(String alt_title) {
        this.alt_title = alt_title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMobile_link() {
        return mobile_link;
    }

    public void setMobile_link(String mobile_link) {
        this.mobile_link = mobile_link;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public AttrsBean getAttrs() {
        return attrs;
    }

    public void setAttrs(AttrsBean attrs) {
        this.attrs = attrs;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<AuthorBean> getAuthor() {
        return author;
    }

    public void setAuthor(List<AuthorBean> author) {
        this.author = author;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 8.6
         * numRaters : 4789
         * min : 0
         */

        private int max;
        private String average;
        private int numRaters;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public String getAverage() {
            return average;
        }

        public void setAverage(String average) {
            this.average = average;
        }

        public int getNumRaters() {
            return numRaters;
        }

        public void setNumRaters(int numRaters) {
            this.numRaters = numRaters;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class AttrsBean {
        /**
         * publisher : ["Undercover Culture Music"]
         * singer : ["The Shanghai Restoration Project"]
         * version : ["专辑"]
         * pubdate : ["2006-03-06"]
         * title : ["The Shanghai Restoration Project"]
         * media : ["Audio CD"]
         * radio_url : https://douban.fm/?context=channel:0|subject_id:2337701
         * tracks : ["Introduction (1936)  1:27\n2.   Nanking Road  3:42\n3.   Shanghai Express  3:46\n4.   Jade Buddha Temple 3:42\n5.   Peace Hotel (What is Love)  3:30\n6.   Miss Shanghai 3:21\n7.   Lu Xun (Watch Me Dance) 3:16\n8.   Babylon of the Orient  3:53\n9.   Pearl Tower  2:58\n10.   Avenue Joffre  4:15\n11.   The Bund  6:31\n12.   Old City  3:54\n13.   Pudong  3:32\n14.   Bubbling Well Road  4:55\n15.   Jessfield Park"]
         * discs : ["1"]
         */

        private String radio_url;
        private List<String> publisher;
        private List<String> singer;
        private List<String> version;
        private List<String> pubdate;
        private List<String> title;
        private List<String> media;
        private List<String> tracks;
        private List<String> discs;

        public String getRadio_url() {
            return radio_url;
        }

        public void setRadio_url(String radio_url) {
            this.radio_url = radio_url;
        }

        public List<String> getPublisher() {
            return publisher;
        }

        public void setPublisher(List<String> publisher) {
            this.publisher = publisher;
        }

        public List<String> getSinger() {
            return singer;
        }

        public void setSinger(List<String> singer) {
            this.singer = singer;
        }

        public List<String> getVersion() {
            return version;
        }

        public void setVersion(List<String> version) {
            this.version = version;
        }

        public List<String> getPubdate() {
            return pubdate;
        }

        public void setPubdate(List<String> pubdate) {
            this.pubdate = pubdate;
        }

        public List<String> getTitle() {
            return title;
        }

        public void setTitle(List<String> title) {
            this.title = title;
        }

        public List<String> getMedia() {
            return media;
        }

        public void setMedia(List<String> media) {
            this.media = media;
        }

        public List<String> getTracks() {
            return tracks;
        }

        public void setTracks(List<String> tracks) {
            this.tracks = tracks;
        }

        public List<String> getDiscs() {
            return discs;
        }

        public void setDiscs(List<String> discs) {
            this.discs = discs;
        }
    }

    public static class AuthorBean {
        /**
         * name : The Shanghai Restoration Project
         */

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class TagsBean {
        /**
         * count : 904
         * name : Electronic
         */

        private int count;
        private String name;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return "WordModel{" +
                "alt_title='" + alt_title + '\'' +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", mobile_link='" + mobile_link + '\'' +
                ", summary='" + summary + '\'' +
                ", alt='" + alt + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
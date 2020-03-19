package com.bw.nierunzhang20200313.bean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.13<p>
 * <p>更改时间：2020.3.13<p>
 */
public class LearyBean {

    /**
     * code : 200
     * bannerdata : [{"imageUrl":"http://blog.zhaoliang5156.cn/api/images/01.jpg"},{"imageUrl":"http://blog.zhaoliang5156.cn/api/images/02.jpg"},{"imageUrl":"http://blog.zhaoliang5156.cn/api/images/03.jpg"},{"imageUrl":"http://blog.zhaoliang5156.cn/api/images/01.jpg"}]
     * listdata : [{"name":"张海霞","info":"专业-婚姻家庭","avatar":"http://blog.zhaoliang5156.cn/api/images/head1.jpeg","url":"https://www.sina.com.cn/","content":"请问实习律师到法院开庭要穿律师袍吗？","publishedAt":"11:10","type":1,"share":2,"collection":2,"fabulous":2,"comment":2},{"name":"张海霞","info":"专业-婚姻家庭","avatar":"http://blog.zhaoliang5156.cn/api/images/head2.jpeg","url":"https://www.sina.com.cn/","content":"请问实习律师到法院开庭要穿律师袍吗？","publishedAt":"11:12","type":2,"share":3,"collection":3,"fabulous":3,"comment":3},{"name":"张海霞","info":"专业-婚姻家庭","avatar":"http://blog.zhaoliang5156.cn/api/images/head3.jpg","url":"https://www.sina.com.cn/","content":"请问实习律师到法院开庭要穿律师袍吗？","publishedAt":"11:14","type":1,"share":4,"collection":4,"fabulous":4,"comment":4}]
     */

    private String code;
    private List<BannerdataBean> bannerdata;
    private List<ListdataBean> listdata;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<BannerdataBean> getBannerdata() {
        return bannerdata;
    }

    public void setBannerdata(List<BannerdataBean> bannerdata) {
        this.bannerdata = bannerdata;
    }

    public List<ListdataBean> getListdata() {
        return listdata;
    }

    public void setListdata(List<ListdataBean> listdata) {
        this.listdata = listdata;
    }

    public static class BannerdataBean {
        /**
         * imageUrl : http://blog.zhaoliang5156.cn/api/images/01.jpg
         */

        private String imageUrl;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }

    public static class ListdataBean {
        /**
         * name : 张海霞
         * info : 专业-婚姻家庭
         * avatar : http://blog.zhaoliang5156.cn/api/images/head1.jpeg
         * url : https://www.sina.com.cn/
         * content : 请问实习律师到法院开庭要穿律师袍吗？
         * publishedAt : 11:10
         * type : 1
         * share : 2
         * collection : 2
         * fabulous : 2
         * comment : 2
         */

        private String name;
        private String info;
        private String avatar;
        private String url;
        private String content;
        private String publishedAt;
        private int type;
        private int share;
        private int collection;
        private int fabulous;
        private int comment;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getShare() {
            return share;
        }

        public void setShare(int share) {
            this.share = share;
        }

        public int getCollection() {
            return collection;
        }

        public void setCollection(int collection) {
            this.collection = collection;
        }

        public int getFabulous() {
            return fabulous;
        }

        public void setFabulous(int fabulous) {
            this.fabulous = fabulous;
        }

        public int getComment() {
            return comment;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }
    }
}

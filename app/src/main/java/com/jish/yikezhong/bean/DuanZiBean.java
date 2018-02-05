package com.jish.yikezhong.bean;

import java.util.List;

/**
 * Created by Adminjs on 2018/1/26.
 */

public class DuanZiBean {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"张恒","createTime":"2018-01-26T14:26:06","imgUrls":null,"jid":1231,"praiseNum":null,"shareNum":null,"uid":2856,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"123","praiseNum":"null"}},{"commentNum":null,"content":"天哪","createTime":"2018-01-26T14:26:02","imgUrls":null,"jid":1230,"praiseNum":null,"shareNum":null,"uid":5408,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"\"康家帅最帅\"","createTime":"2018-01-26T14:25:29","imgUrls":null,"jid":1229,"praiseNum":null,"shareNum":null,"uid":11844,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"阿萨德","createTime":"2018-01-26T14:17:46","imgUrls":null,"jid":1228,"praiseNum":null,"shareNum":null,"uid":1600,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/151575551828852d4ae27f2029.jpg","nickname":"哈哈哈","praiseNum":"null"}},{"commentNum":null,"content":"阿萨德","createTime":"2018-01-26T14:16:57","imgUrls":null,"jid":1227,"praiseNum":null,"shareNum":null,"uid":1600,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/151575551828852d4ae27f2029.jpg","nickname":"哈哈哈","praiseNum":"null"}},{"commentNum":null,"content":"阿萨德","createTime":"2018-01-26T14:14:27","imgUrls":null,"jid":1226,"praiseNum":null,"shareNum":null,"uid":1600,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/151575551828852d4ae27f2029.jpg","nickname":"哈哈哈","praiseNum":"null"}},{"commentNum":null,"content":"阿萨德","createTime":"2018-01-26T14:08:31","imgUrls":null,"jid":1225,"praiseNum":null,"shareNum":null,"uid":1600,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/151575551828852d4ae27f2029.jpg","nickname":"哈哈哈","praiseNum":"null"}},{"commentNum":null,"content":"阿萨德","createTime":"2018-01-26T14:08:01","imgUrls":null,"jid":1224,"praiseNum":null,"shareNum":null,"uid":1600,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/151575551828852d4ae27f2029.jpg","nickname":"哈哈哈","praiseNum":"null"}},{"commentNum":null,"content":"1111","createTime":"2018-01-26T14:06:57","imgUrls":null,"jid":1223,"praiseNum":null,"shareNum":null,"uid":1600,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/151575551828852d4ae27f2029.jpg","nickname":"哈哈哈","praiseNum":"null"}},{"commentNum":null,"content":"sassasa","createTime":"2018-01-26T14:03:35","imgUrls":null,"jid":1222,"praiseNum":null,"shareNum":null,"uid":4043,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1516190673102IMG_20160213_001009.jpg","nickname":"Constraint","praiseNum":"null"}}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : null
         * content : 张恒
         * createTime : 2018-01-26T14:26:06
         * imgUrls : null
         * jid : 1231
         * praiseNum : null
         * shareNum : null
         * uid : 2856
         * user : {"age":null,"fans":"null","follow":false,"icon":null,"nickname":"123","praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private Object imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(Object imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : null
             * nickname : 123
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}

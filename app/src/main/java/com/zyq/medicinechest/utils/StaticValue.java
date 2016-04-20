package com.zyq.medicinechest.utils;

/**
 * Created by ZYQ on 2016/4/20.
 * 用来存放各个请求网页的接口
 */
public class StaticValue {

    public static class URL {
        /**
         * 基准的url
         */
        public static final String BASEURL_Text = "120.24.174.205120.24.174.205/iMedical";
        public static final String BASEURL = BASEURL_Text;

        /**
         * 登录url
         */
        public static final String LOGIN = BASEURL + "android_user_login.action";

        /**
         * 药单url
         */
        public static final String MEDICAL_LIST = BASEURL + "android_pres_list.action";

        /**
         * 备忘录url
         */
        public static final String MEMO_LIST = BASEURL + "android_memo_list.action";

    }

}

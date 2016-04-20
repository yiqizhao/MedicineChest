package com.zyq.medicinechest.utils;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by acer-PC on 2015/12/4.
 */
public class FragmentUtil {

    // 侧拉栏的文字
    public static Map<Integer, String> stringTitle = new HashMap<>();


    static {

        stringTitle.put(0, "用药提醒");
        stringTitle.put(1, "关爱家人");
        stringTitle.put(2, "我的药箱");

    }
}


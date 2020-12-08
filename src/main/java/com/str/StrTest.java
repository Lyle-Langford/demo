package com.str;

/**
 * @author: Lyle
 * @date: 2020/10/9
 * @description:
 **/
public class StrTest {

    public static void main(String[] args) {
        String bannerIdStr = "taolijin_10008";
        int index = bannerIdStr.indexOf("_");
        String bannerId;
        String channel = null;
        if (index >= 0){
            bannerId = bannerIdStr.substring(0, index);
            channel = bannerIdStr.substring(index + 1);
        }else{
            bannerId = bannerIdStr;
        }


        System.out.println("bannerId:" + bannerId + "\tchannel:" + channel);
    }
}

package com.jish.yikezhong.retrofit;

import com.jish.yikezhong.bean.DuanZiBean;
import com.jish.yikezhong.bean.FuJinBean;
import com.jish.yikezhong.bean.GuanZhuBean;
import com.jish.yikezhong.bean.LoginBean;
import com.jish.yikezhong.bean.LunBean;
import com.jish.yikezhong.bean.ReDianBean;
import com.jish.yikezhong.bean.ReMenBean;
import com.jish.yikezhong.bean.ZhuCeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Adminjs on 2018/1/25.
 */

public interface Api {
    //广告轮播图
    @GET("/quarter/getAd")
    Observable<LunBean> getLun();
    //注册
    @GET("/quarter/register")
    Observable<ZhuCeBean> getZhuCe(@Query("mobile") String mobile,@Query("password") String password);
    //注册
    @GET("/user/login")
    Observable<LoginBean> getLogin(@Query("mobile") String mobile, @Query("password") String password);
    //视频列表
    @GET("/quarter/getVideos")
    Observable<ReDianBean> getReDian(@Query("uid") String uid, @Query("page") String page, @Query("source") String source, @Query("appVersion") String appVersion);

    //获取关注用户列表
    @GET("/quarter/getFollowUsers")
    Observable<GuanZhuBean> getGuanZhu(@Query("uid") String uid, @Query("token") String token, @Query("source") String source, @Query("appVersion") String appVersion);
    //获取段子用户列表
    @GET("/quarter/getJokes")
    Observable<DuanZiBean> getDuanZi(@Query("page") String page, @Query("token") String token, @Query("source") String source, @Query("appVersion") String appVersion);
    //获取热门视频列表
    @GET("/quarter/getHotVideos")
    Observable<ReMenBean> getReMen(@Query("page") String page, @Query("token") String token, @Query("source") String source, @Query("appVersion") String appVersion);
    //获取附近视频列表
    @GET("/quarter/getNearVideos")
    Observable<FuJinBean> getFuJin(@Query("page") String page, @Query("token") String token, @Query("source") String source, @Query("appVersion") String appVersion);
}

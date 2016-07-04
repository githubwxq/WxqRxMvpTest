package com.orange.wxq.wxqrxmvptest.mvp.model;

/**
 * Created by Administrator on 2016/7/4.
 * 业务逻辑层
 */
public interface BaseModel<T> {
    // 模型层需要干的事情 此刻的T 代表的是接口 回调接口 前面也定义好了级交互接口给只要回调数据的
    void netWork(T model);


    interface AllStudentModel {

        void getAllStudent(DataListener.NewsDetailData call);

    }





}

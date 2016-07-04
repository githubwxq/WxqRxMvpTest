package com.orange.wxq.wxqrxmvptest.mvp.model;

import com.orange.wxq.wxqrxmvptest.mvp.bean.Student;

import java.util.List;

/**
 * Created by Administrator on 2016/7/4.
 * 回调接口定义处 不同模块不同回调接口 契约接口
 *
 * present成想干的事情写在这
 */
public interface DataListener<T> {
    //给上层实现的方法 下层 将参数塞进去即可 这个是返回集合的
    void getData(List<T> datas );
    void error();

    interface NewsDetailData  { //这个是返回对象的
        void addData(Student datas);
        void error();
    }



}

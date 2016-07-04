package com.orange.wxq.wxqrxmvptest.http;

import com.orange.wxq.wxqrxmvptest.mvp.bean.Student;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/7/4.
 * dao的实现层
 */
public class NetWorkRequest {
    //将 订阅和订阅者 简单封装确定 执行流程 吊着方法里面订阅时间触发  回调给上一成的 现在只是参数抽取而已 未涉及回调
  // model 的一个帮助类 把rx炒作进行了封装
    public static void getStudentInfo(String name,Subscriber<Student> subscriber ){

       Network.getStudnetService()//对不同retrofit的实现类的封装
                .getAllStudentByName(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

    public static void getStudentInfo(Subscriber<Student> subscriber ){

        Network.getStudnetService()
                .getAllStudent()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }


}

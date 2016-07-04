package com.orange.wxq.wxqrxmvptest.http;

import com.orange.wxq.wxqrxmvptest.mvp.bean.Student;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Administrator on 2016/7/3.
 */
public interface StudentService {

    //获取所有student数据
    @GET(API.ALLSTUDENT)
    Observable<Student> getAllStudent();


}

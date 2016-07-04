package com.orange.wxq.wxqrxmvptest.http;

import com.orange.wxq.wxqrxmvptest.mvp.bean.Student;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/7/3.
 * dao层
 */
public interface StudentService {

    //获取所有student数据
    @GET(API.ALLSTUDENT)
    Observable<Student> getAllStudent();

    @GET(API.ALLSTUDENT)
    Observable<Student> getAllStudentByName(@Query("name") String name);

    @POST(API.ALLSTUDENT)
    Observable<Student> getAllStudentByObject(@Body Student user);







}

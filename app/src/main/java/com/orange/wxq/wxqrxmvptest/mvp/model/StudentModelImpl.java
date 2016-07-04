package com.orange.wxq.wxqrxmvptest.mvp.model;

import com.orange.wxq.wxqrxmvptest.http.MySubscriber;
import com.orange.wxq.wxqrxmvptest.http.NetWorkRequest;
import com.orange.wxq.wxqrxmvptest.mvp.bean.Student;

/**
 * Created by Administrator on 2016/7/4.
 *model层提供数据回调 present层 业务逻辑成需要model 获取数据了 由于获取数据 和拿数据要在不同的现成所以要用回调等待数据加载完成然后干活
 */
public class StudentModelImpl implements BaseModel.AllStudentModel {


    @Override
    public void getAllStudent(final DataListener.NewsDetailData call) {

        NetWorkRequest.getStudentInfo(new MySubscriber<Student>(){
            @Override
            public void onNext(Student student) {
                super.onNext(student);
                call.addData(student);

            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                call.error();

              }
        });



    }
}

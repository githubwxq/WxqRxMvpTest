package com.orange.wxq.wxqrxmvptest.mvp.view;

import com.orange.wxq.wxqrxmvptest.mvp.bean.Student;

import java.util.List;

/**
 * by y on 2016/5/27.
 */
public interface BaseView<T> {


    void setData(List<T> datas);

    interface StudentInfoView extends BaseView<Student> {

        void setStudentData(Student datas);
    }

}

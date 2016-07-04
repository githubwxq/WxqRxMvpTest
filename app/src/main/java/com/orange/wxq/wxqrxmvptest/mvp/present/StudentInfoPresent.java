package com.orange.wxq.wxqrxmvptest.mvp.present;

import com.orange.wxq.wxqrxmvptest.mvp.bean.Student;
import com.orange.wxq.wxqrxmvptest.mvp.model.BaseModel;
import com.orange.wxq.wxqrxmvptest.mvp.model.DataListener;
import com.orange.wxq.wxqrxmvptest.mvp.model.StudentModelImpl;
import com.orange.wxq.wxqrxmvptest.mvp.view.BaseView;

/**
 * Created by Administrator on 2016/7/4.
 */
public class StudentInfoPresent extends BasePresenterImpl<BaseView.StudentInfoView> implements BasePresenter.StudentInfoPresenter,DataListener.NewsDetailData {

  public  BaseModel.AllStudentModel a;

    public StudentInfoPresent(BaseView.StudentInfoView view) {
        super(view);
        a=new StudentModelImpl(); //实例 mode给个回调接口
    }
    @Override
    public void requestNetWork() {
        a.getAllStudent(this);//this 回调接口拿到 数据 在requestNetWork(String stuName)中 拿到数据改干嘛设置数据
        //addData(Student datas)这个方法已经拿到了datas数据

    }

    @Override
    public void requestNetWork(String stuName) {

    }

    @Override
    public void addData(Student datas) {
        //最后拿到的数据
        view.setStudentData(datas);

    }

    @Override
    public void error() {

    }
}

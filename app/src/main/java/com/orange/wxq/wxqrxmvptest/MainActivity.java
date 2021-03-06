package com.orange.wxq.wxqrxmvptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.orange.wxq.wxqrxmvptest.http.NetWorkRequest;
import com.orange.wxq.wxqrxmvptest.http.Network;
import com.orange.wxq.wxqrxmvptest.http.StudentService;
import com.orange.wxq.wxqrxmvptest.mvp.bean.Course;
import com.orange.wxq.wxqrxmvptest.mvp.bean.Student;
import com.orange.wxq.wxqrxmvptest.mvp.model.DataListener;
import com.orange.wxq.wxqrxmvptest.mvp.model.StudentModelImpl;
import com.orange.wxq.wxqrxmvptest.mvp.present.BasePresenter;
import com.orange.wxq.wxqrxmvptest.mvp.present.StudentInfoPresent;
import com.orange.wxq.wxqrxmvptest.mvp.view.BaseView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements BaseView.StudentInfoView {
    //实现接口并把当前接口实现类给其他人是机既可以监听其他类 其他类某种状态 时调用该类 实现回调
    // 一些上成不用关心的超值即可给底层类处理 上乘只要处理结果
    TextView tv;
    TextView tv2;
    TextView tv3;
    BasePresenter.StudentInfoPresenter present;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.tv);
        tv2= (TextView) findViewById(R.id.tv2);
        tv3= (TextView) findViewById(R.id.tv3);

        present=new StudentInfoPresent(this);
        present.requestNetWork();


        Student stu=new Student(100,"我是对象数据");
       stu.setName1("王晓清");
        ArrayList<Course> courses=new ArrayList<Course>();
        Course a=new Course();
        a.setId(6);
        a.setTitel("新课程");
        courses.add(a );
        stu.setCourse(courses);

       // StudentService service = Network.getService(StudentService.class);


        Observable<Student> allStudentByObject = Network.getService(StudentService.class).getAllStudentByObject(stu);
        allStudentByObject.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Student>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Student student) {



            }
        });
        NetWorkRequest.getStudentInfo("wxq", new Subscriber<Student>() {
            @Override
            public void onCompleted() {
                //  tv2.setText("tv2");
            }

            @Override
            public void onError(Throwable e) {
                tv2.setText("tv2");
            }

            @Override
            public void onNext(Student student) {
             //这是我最关心的数据 student
                tv2.setText("泛型tv2"+student.getAge());
            }
        });


        StudentModelImpl studentmoinpl = new StudentModelImpl();
        studentmoinpl.getAllStudent(new  DataListener.NewsDetailData(){
            @Override
            public void addData(Student datas) {
                tv.setText("回调数据年龄为"+datas.getAge());

            }

            @Override
            public void error() {

            }
        });
    }


    @Override
    public void setStudentData(Student datas) {
       tv3.setText("最新"+datas.getAge());
    }

    @Override
    public void setData(List<Student> datas) {

    }
}

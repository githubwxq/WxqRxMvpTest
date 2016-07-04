package com.orange.wxq.wxqrxmvptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.orange.wxq.wxqrxmvptest.http.Network;
import com.orange.wxq.wxqrxmvptest.mvp.bean.Student;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
tv= (TextView) findViewById(R.id.tv);
        Observable<Student> observable = Network.getStudnetService().getAllStudent();

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Student>() {
            @Override
            public void onCompleted() {
             //   tv.setText("ok");
            }

            @Override
            public void onError(Throwable e) {
                tv.setText("nono");
            }

            @Override
            public void onNext(Student student) {
               System.out.print("student: info "+student.getName1());
                tv.setText(student.getCourse().get(0).getTitel());



            }
        });
    }
}

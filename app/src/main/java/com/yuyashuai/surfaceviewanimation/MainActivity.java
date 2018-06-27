package com.yuyashuai.surfaceviewanimation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yuyashuai.silkyanimation.SilkyAnimation;

import java.io.File;

/**
 * 帧动画不同框架播放对比
 * gxj
 * 2018/6/22
 */
public class MainActivity extends AppCompatActivity {
    private Gson mGSon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_1).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Animation1Activity.class)));
        findViewById(R.id.btn_2).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Animation2Activity.class)));
        findViewById(R.id.btn_3).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Animation3Activity.class)));
        findViewById(R.id.btn_4).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Animation4Activity.class)));
        findViewById(R.id.btn_5).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Animation5Activity.class)));
        if (mGSon == null) {
            mGSon = new GsonBuilder().disableHtmlEscaping().create();
        }
        testObjectToJson();
        testJsonToObject();
    }

    /**
     * json 转对象
     */
    private void testJsonToObject() {
        String json = "{\"age\":\"1\",\"big\":\"1\",\"name\":\"1\",\"ren\":true}";

        Person person = JSON.parseObject(json,Person.class);
//        Person person1 = mGSon.fromJson(json, Person.class);
        Log.e("gxj", person.toString());
    }

    /**
     * 测试不同解析框架的作用
     */
    private void testObjectToJson() {
        Person person1 = new Person();
        person1.setRen(true);
        person1.setAge("1");
        person1.setBig("2");
        person1.setName("3");
        Person person2 = new Person();
        person2.setRen(true);
        person2.setAge("1");
        person2.setBig("2");
        person2.setName("3");
        String name = JSON.toJSONString(person1);
        String name1 = mGSon.toJson(person1);
        Log.e("gxj---", name + "---" + name1);
    }

  static   class Person extends BasePerson {
        private String name;
        private String age;
        private String big;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getBig() {
            return big;
        }

        public void setBig(String big) {
            this.big = big;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    "age='" + age + '\'' +
                    "big='" + big + '\'' +
                    ", ren=" + ren +
                    '}';
        }
    }

    static  class BasePerson {
        protected boolean ren;

        public boolean isRen() {
            return ren;
        }

        public void setRen(boolean ren) {
            this.ren = ren;
        }
    }
}

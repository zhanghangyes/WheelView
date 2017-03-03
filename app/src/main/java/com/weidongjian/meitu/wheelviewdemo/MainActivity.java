package com.weidongjian.meitu.wheelviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

    private Toast toast;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private LoopView loopView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);

        loopView = (LoopView) findViewById(R.id.loopView);
        loopView.setNotLoop();


        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loopView.setVisibility(View.VISIBLE);
                ArrayList<String> list = new ArrayList<>();

                for (int i = 1; i < 100; i++) {
                    list.add(i + "%");
                }

                //滚动监听
                loopView.setListener(new OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(int index) {
                        if (toast == null) {
                            toast = Toast.makeText(MainActivity.this, "item " + index + 1, Toast.LENGTH_SHORT);
                        }
                        toast.setText("item " + index + 1);
                        tv1.setText(index + 1 + "");
                        toast.show();
                    }
                });
                //设置原始数据
                loopView.setItems(list);
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loopView.setVisibility(View.VISIBLE);
                //滚动监听
                loopView.setListener(new OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(int index) {
                        if (toast == null) {
                            toast = Toast.makeText(MainActivity.this, "item " + index + 1, Toast.LENGTH_SHORT);
                        }
                        toast.setText("item " + index + 1);
                        tv2.setText(index + 1 + "");
                        toast.show();
                    }
                });
                //设置原始数据
                String length = tv1.getText().toString();

                int length1 = Integer.parseInt(length);

                ArrayList<String> list = new ArrayList<>();

                for (int i = 1; i < 101 - length1; i++) {
                    list.add(i + "%");
                }

                loopView.setItems(list);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loopView.setVisibility(View.VISIBLE);
                //滚动监听
                loopView.setListener(new OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(int index) {
                        if (toast == null) {
                            toast = Toast.makeText(MainActivity.this, "item " + index + 1, Toast.LENGTH_SHORT);
                        }
                        toast.setText("item " + index + 1);
                        tv3.setText(index + 1 + "");
                        toast.show();
                        loopView.setVisibility(View.GONE);
                    }
                });
                //设置原始数据
                String length = tv1.getText().toString();
                String length2 = tv2.getText().toString();

                int length1 = Integer.parseInt(length);
                int length3 = Integer.parseInt(length2);
                if (100 - length1 - length3 == 0) {
                    Toast.makeText(MainActivity.this, "vdsv", Toast.LENGTH_SHORT).show();
                    loopView.setVisibility(View.GONE);
                    return;
                } else {
                    ArrayList<String> list = new ArrayList<>();

                    for (int i = 1; i < 101 - length1 - length3; i++) {
                        list.add(i + "%");
                    }

                    loopView.setItems(list);
                }
            }
        });


    }

}

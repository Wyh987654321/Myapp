package com.swufe.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CompleteActivity extends AppCompatActivity {
    String mynumber;
    String TAG = "run1";
    private ArrayList<HashMap<String, Object>> listItems; // 存放文字、图片信息
    private SimpleAdapter listItemAdapter; // 适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);
        Log.i(TAG, "onCreate:我过来了 ");
        Bundle bundle = this.getIntent().getExtras();
        mynumber = bundle.getString("number", "41811002");
        ListView view = findViewById(R.id.complet_tasks);
        final MyTasksManger manger = new MyTasksManger(this);
        listItems = new ArrayList<>();
        List<MyTasks> list = manger.listAll2(mynumber);
        if (list != null) {
            for (MyTasks item : list) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("details", item.getDetails());
                map.put("money", item.getMoney());
                map.put("university", item.getUniversity());
                map.put("head", item.getAvatar());
                map.put("id", item.getId());
                map.put("employer_name", item.getEmployer_name());
                listItems.add(map);
            }
            listItemAdapter = new SimpleAdapter(this, listItems, // listItems数据源
                    R.layout.accept_tasks, // ListItem的XML布局实现
                    new String[]{"head", "university", "name", "details", "money", "id"},
                    new int[]{R.id.mytasks_head, R.id.mytasks_university, R.id.mytasks_name, R.id.mytasks_details,
                            R.id.mytasks_money, R.id.mytasks_id}
            );
            ListView listView = view.findViewById(R.id.complet_tasks);
            listView.setAdapter(listItemAdapter);
        }
        else {
            Toast.makeText(this,"暂时还没有任务哦，快去接取任务吧！",Toast.LENGTH_SHORT).show();
        }
    }
}

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

public class MyPublishActivity extends AppCompatActivity {
    String mynumber;
    String TAG = "run1";
    private ArrayList<HashMap<String, Object>> listItems; // 存放文字、图片信息
    private SimpleAdapter listItemAdapter; // 适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_publish);
        Log.i(TAG, "onCreate:我过来了 ");
        Bundle bundle = this.getIntent().getExtras();
        mynumber = bundle.getString("number", "");
        ListView view = findViewById(R.id.publicsh_tasks);
        final TaskManger manger = new TaskManger(this);
        DBManager manager1= new DBManager(this);
        UserItem user =manager1.select(mynumber);
        listItems = new ArrayList<>();
        List<TaskItem> list = manger.listAll2(mynumber);
        if (list != null) {
            for (TaskItem item : list) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("head",user.getAvatar());
                map.put("university",user.getUniversity());
                map.put("details", item.getDetails());
                map.put("name",user.getName());
                map.put("money", item.getReward());
                map.put("id", item.getId());
                map.put("people",item.getPeople());
                listItems.add(map);
            }
            listItemAdapter = new SimpleAdapter(this, listItems, // listItems数据源
                    R.layout.task_item, // ListItem的XML布局实现
                    new String[]{"head", "university", "name", "details", "money", "people","id"},
                    new int[]{R.id.item_head, R.id.item_university,R.id.item_name,R.id.item_details,
                            R.id.item_money,R.id.item_peoples,R.id.item_id }
            );
            ListView listView = view.findViewById(R.id.publicsh_tasks);
            listView.setAdapter(listItemAdapter);
        }
        else {
            Toast.makeText(this,"暂时还没有任务哦，快去发布任务吧！",Toast.LENGTH_SHORT).show();
        }
    }
}

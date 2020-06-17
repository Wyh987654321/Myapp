package com.swufe.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AcceptTasks extends AppCompatActivity {
    String mynumber;
    String TAG="run1";
    private ArrayList<HashMap<String, Object>> listItems; // 存放文字、图片信息
    private SimpleAdapter listItemAdapter; // 适配器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_tasks2);
        Log.i(TAG, "onCreate:我过来了 ");
        Bundle bundle =this.getIntent().getExtras();
        mynumber =bundle.getString("number","41811002");
        ListView view =findViewById(R.id.accept_taskview);
        final MyTasksManger manger = new MyTasksManger(this);
        listItems = new ArrayList<>();
        List<MyTasks> list = manger.listAll(mynumber);
        if(list!=null){
            for(MyTasks item:list){
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("details",item.getDetails());
                map.put("money",item.getMoney());
                map.put("university",item.getUniversity());
                map.put("head",item.getAvatar());
                map.put("id",item.getId());
                map.put("employer_name",item.getEmployer_name());
                listItems.add(map);
            }
            listItemAdapter= new SimpleAdapter(this, listItems, // listItems数据源
                    R.layout.accept_tasks, // ListItem的XML布局实现
                    new String[] { "head", "university" ,"name","details","money","id"},
                    new int[] { R.id.mytasks_head, R.id.mytasks_university,R.id.mytasks_name,R.id.mytasks_details,
                            R.id.mytasks_money,R.id.mytasks_id }
            );
            ListView listView =view.findViewById(R.id.accept_taskview);
            listView.setAdapter(listItemAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(AcceptTasks.this);
                    builder.setTitle("提示").setMessage("请确认是否已完成任务").setPositiveButton("是", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            TextView idview = view.findViewById(R.id.mytasks_id);
                            int id =Integer.parseInt(idview.getText().toString());
                            manger.update(id,"0");
                            Toast.makeText(AcceptTasks.this,"任务完成成功",Toast.LENGTH_SHORT).show();
                            listItems.remove(position);
                            listItemAdapter.notifyDataSetChanged();
                        }
                    })
                            .setNegativeButton("否",null);
                    builder.create().show();
                }
            });
        }
        else {
            Toast.makeText(this,"暂时还没有任务哦，快去接取任务吧！",Toast.LENGTH_SHORT).show();
        }
    }
}

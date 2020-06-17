package com.swufe.myapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ArrayList<HashMap<String, Object>> listItems; // 存放文字、图片信息
    private SimpleAdapter listItemAdapter; // 适配器
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String TAG="run1";
    String  mynumber;
    List<Integer> photo;
    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String s) {
        FirstFragment myFragment = new FirstFragment();
        Bundle bundle = new Bundle();
        bundle.putString("DATA",s);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_first, container, false);
        TaskManger manger = new TaskManger(getActivity());
        DBManager  dbManager = new DBManager(getActivity());
        listItems = new ArrayList<>();
        //得到所有可用的任务信息
        List<TaskItem> list =manger.listAll();
        //对list进行遍历
        if(list!=null){
            if(list.size()==0){
                Toast.makeText(getContext(),"暂时还没有任务哦，快去发布任务吧！",Toast.LENGTH_SHORT).show();
            }
            photo= new ArrayList<>();
            for (TaskItem item:list){
                //得到任务发布人的number
                String number = item.getNumber();
                //通过number获取任务发布人的信息
                UserItem userItem =dbManager.select(number);
                //生成HashMap对象
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("head",userItem.getAvatar());
                photo.add(userItem.getAvatar());
                map.put("employer",number);
                map.put("university",userItem.getUniversity());
                map.put("name",userItem.getName());
                map.put("details",item.getDetails());
                map.put("id",item.getId());
                map.put("reward",item.getReward());
                map.put("people",item.getPeople());
                //填充数据
                listItems.add(map);
            }
            listItemAdapter= new SimpleAdapter(getActivity(), listItems, // listItems数据源
                    R.layout.task_item, // ListItem的XML布局实现
                    new String[] { "head", "university" ,"name","details","reward","people","id","employer"},

                   new int[] { R.id.item_head, R.id.item_university,R.id.item_name,R.id.item_details,
                           R.id.item_money,R.id.item_peoples,R.id.item_id ,R.id.item_number}

            );
            ListView listView =view.findViewById(R.id.taskview);
            listView.setAdapter(listItemAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("提示").setMessage("请确认是否接取任务").setPositiveButton("是", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mynumber =getActivity().getIntent().getStringExtra("number");
                            View view1 =getView();
                            String status="1";
                            TextView employerview =view1.findViewById(R.id.item_number);
                            String employer_id =employerview.getText().toString();
                            if(employer_id.equals(mynumber)){
                                Toast.makeText(getContext(),"不能接取自己发布的任务哦",Toast.LENGTH_SHORT).show();
                                return;
                            }
                            TextView peopleview =view1.findViewById(R.id.item_peoples);
                            TextView idview =view1.findViewById(R.id.item_id);
                            int id=Integer.parseInt(idview.getText().toString());
                            int people =Integer.parseInt(peopleview.getText().toString())-1;
                            if (people == 0) {
                                status="0";
                                listItems.remove(position);
                            }
                            TaskManger manger1 =new TaskManger(getActivity());
                            manger1.update(id,people,status);
                            Toast.makeText(getContext(),"任务接取成功",Toast.LENGTH_SHORT).show();
                            listItemAdapter.notifyDataSetChanged();

                            TextView moneyview =view1.findViewById(R.id.item_money);
                            int money =Integer.parseInt(moneyview.getText().toString());

                            //ImageView avatarview =view1.findViewById(R.id.item_head);
//                            int avatar =Integer.parseInt(avatarview.get.toString());
                            int avatar =photo.get(position);

                            TextView detailsview =view1.findViewById(R.id.item_details);
                            String details =detailsview.getText().toString();

                            TextView nameview =view1.findViewById(R.id.item_name);
                            String employer_name =employerview.getText().toString();

                            TextView schoolview =view1.findViewById(R.id.item_university);
                            String university = schoolview.getText().toString();

                            addMytasks(id,money,avatar,details,mynumber,employer_id,employer_name,university);
                            Log.i(TAG, "onClick: mynumber="+mynumber);
                        }
                    })
                            .setNegativeButton("否",null);
                    builder.create().show();
                }
            });
        }
        else{
            Toast.makeText(getContext(),"暂时还没有任务哦，快去发布任务吧！",Toast.LENGTH_SHORT).show();
        }
        return view;
    }
    public void addMytasks(int id, int money, int avatar, String details, String mynumber,
                           String employer_id, String employer_name, String university){
        MyTasksManger manger = new MyTasksManger(getContext());
        MyTasks task =new MyTasks(id,money,avatar,details,mynumber,employer_id,employer_name,university);
        manger.add(task);
    }

}


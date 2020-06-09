package com.swufe.myapp;

import android.app.Activity;
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


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FifthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FifthFragment extends Fragment implements  AdapterView.OnItemClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ArrayList<HashMap<String, Object>> listItems,listItems2; // 存放文字、图片信息
    private SimpleAdapter listItemAdapter,listItemAdapter2; // 适配器
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String number;
    public FifthFragment(){
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment FifthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FifthFragment newInstance(String s) {
        FifthFragment myFragment = new FifthFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fifth, container, false);
        ImageView head = view.findViewById(R.id.my_head);
        TextView name =view.findViewById(R.id.my_name);
        TextView grade = view.findViewById(R.id.my_grade);
        TextView intro = view.findViewById(R.id.my_intro);
        TextView attention = view.findViewById(R.id.my_attention);
        TextView rate = view.findViewById(R.id.my_rate);
        TextView money = view.findViewById(R.id.my_money);
        TextView fans = view.findViewById(R.id.my_fans);
        //得到用户ID
        number =  getActivity().getIntent().getStringExtra("number");
        DBManager2 manager = new DBManager2(getContext());
        //得到用户信息
        InfroItem user =manager.select(number);
        //设置控件内容
        head.setImageResource(user.getAvatar());
        name.setText(user.getName());
        grade.setText(user.getGrade());
        intro.setText(user.getIntro());
        attention.setText(user.getAttention());
        rate.setText(user.getRate());
        fans.setText(user.getFans());
        money.setText(user.getFans());
        Log.i("School2Activity","intro="+user.getIntro());
        //第一个列表
        listItems = new ArrayList<HashMap<String, Object>>();
        String title [] = new String[]{"已报名","已发布","已完成"};
        int photo [] = new int[]{R.mipmap.sing_up,R.mipmap.issue,R.mipmap.complete};
        //生成数据
        for (int i = 0; i < 3; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("title", title[i]); // 图片
            map.put("photo", photo[i]); // 标题
            listItems.add(map);
        }
        //将数据与列表绑定
        listItemAdapter = new SimpleAdapter(getActivity(), listItems, // listItems数据源
                R.layout.list_item, // ListItem的XML布局实现
                new String[] { "title", "photo" },
                new int[] { R.id.ttitle, R.id.photo }
        );
        ListView listView =view.findViewById(R.id.mylist);
        listView.setAdapter(listItemAdapter);

        //第二个列表
        listItems2 = new ArrayList<HashMap<String, Object>>();
        String title2 [] = new String[]{"我的收藏","联系客服","意见反馈","身份绑定","关于我们","隐私政策"};
        int photo2 [] = new int[]{R.mipmap.heart,R.mipmap.service,R.mipmap.msg2,R.mipmap.identity,R.mipmap.about_us,R.mipmap.agreement};
        //生成数据
        for (int i = 0; i < 6; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("title", title2[i]); // 图片
            map.put("photo", photo2[i]); // 标题
            listItems2.add(map);
        }
        //将数据与列表绑定
        listItemAdapter2 = new SimpleAdapter(getActivity(), listItems2, // listItems数据源
                R.layout.list_item, // ListItem的XML布局实现
                new String[] { "title", "photo" },
                new int[] { R.id.ttitle, R.id.photo }
        );
        ListView listView2=view.findViewById(R.id.mylist2);
        listView2.setAdapter(listItemAdapter2);
        listView.setOnItemClickListener(this);
        listView2.setOnItemClickListener(this);
        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(),"敬请期待",Toast.LENGTH_SHORT).show();
    }
}

package com.swufe.myapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String number;

    public ThirdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThirdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        View view =inflater.inflate(R.layout.fragment_thrid,container,false);
        Button button =view.findViewById(R.id.issue);
        //得到用户ID，用于上传任务
        number =  getActivity().getIntent().getStringExtra("number");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view =getView();
                EditText detail =view.findViewById(R.id.detail);

                EditText reward =view.findViewById(R.id.reward);
                EditText people =view.findViewById(R.id.people);
                String details = detail.getText().toString();

                String rewardStr =reward.getText().toString();
                String peopleStr =people.getText().toString();
                int rewardInt=0;
                int peopleInt=0;
                if(rewardStr.length()>0){
                    rewardInt=Integer.parseInt(rewardStr);
                }
                if(peopleStr.length()>0){
                    peopleInt=Integer.parseInt(peopleStr);
                }
                TaskManger manger = new TaskManger(getContext());
                TaskItem task = new TaskItem(number,details,rewardInt,peopleInt);

                manger.add(task);
                List<TaskItem> list= manger.listAll();
                Toast.makeText(getActivity(),"任务发布成功",Toast.LENGTH_SHORT).show();
            }

        });
        return view;
    }
}

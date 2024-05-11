package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Ch3Ex3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch3_ex3);

        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        // 创建一个FragmentPagerAdapter
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new PlaceholderFragment();
                    case 1:
                        return new MyFriendsFragment();
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 2; // 你有两个Fragment
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "好友列表";
                    case 1:
                        return "我的好友";
                    default:
                        return null;
                }
            }
        };

        // 将adapter设置到viewPager上
        viewPager.setAdapter(adapter);

        // 将TabLayout和ViewPager关联起来
        tabLayout.setupWithViewPager(viewPager);
    }
}
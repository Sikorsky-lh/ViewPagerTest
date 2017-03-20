package com.example.lihang.viewpagertest;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;




public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    private ViewPager mViewPager;
    private MyPagerAdapter madapter;

    private LinearLayout mTabWeixin;
    private LinearLayout mTabFriends;
    private LinearLayout mTabEXplore;
    private LinearLayout mTabMe;

    private ImageButton mWeixinImg;
    private ImageButton mFriendsImg;
    private ImageButton mExploreImg;
    private ImageButton mMeImg;

    private TextView mWeixinTxt;
    private TextView mFriendsTxt;
    private TextView mExploreTxt;
    private TextView mMeTxt;

    private List<View> mViews=new ArrayList<>();

    private  long exitTime=0;

    private ListView listView;
    private List<Chat> chatList=new ArrayList<>();
    private MyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.toolbar_MainActivity);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();
        mViewPager.setCurrentItem(0);
        mWeixinTxt.setTextColor(getResources().getColor(R.color.green));
        mWeixinImg.setImageResource(R.drawable.chat_after);
        initEvents();
    }




    private void initEvents() {
        mTabWeixin.setOnClickListener(MainActivity.this);
        mTabFriends.setOnClickListener(MainActivity.this);
        mTabEXplore.setOnClickListener(MainActivity.this);
        mTabMe.setOnClickListener(MainActivity.this);

        mWeixinImg.setOnClickListener(this);
        mFriendsImg.setOnClickListener(this);
        mExploreImg.setOnClickListener(this);
        mMeImg.setOnClickListener(this);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem= mViewPager.getCurrentItem();
                resetImg();
                switch(currentItem){
                    case 0:
                        mWeixinImg.setImageResource(R.drawable.chat_after);
                        mWeixinTxt.setTextColor(getResources().getColor(R.color.green));
                        break;
                    case 1:
                        mFriendsImg.setImageResource(R.drawable.friends_after);
                        mFriendsTxt.setTextColor(getResources().getColor(R.color.green));
                        break;
                    case 2:
                        mExploreImg.setImageResource(R.drawable.explore_after);
                        mExploreTxt.setTextColor(getResources().getColor(R.color.green));
                        break;
                    case 3:
                        mMeImg.setImageResource(R.drawable.me_after);
                        mMeTxt.setTextColor(getResources().getColor(R.color.green));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        mViewPager= (ViewPager) findViewById(R.id.viewpager);

        mWeixinImg= (ImageButton) findViewById(R.id.imgbtn_chat);
        mFriendsImg= (ImageButton) findViewById(R.id.imgbtn_friends);
        mExploreImg= (ImageButton) findViewById(R.id.imgbtn_explore);
        mMeImg= (ImageButton) findViewById(R.id.imgbtn_me);

        mTabWeixin= (LinearLayout) findViewById(R.id.chat_llayout);
        mTabFriends= (LinearLayout) findViewById(R.id.friends_llayout);
        mTabEXplore= (LinearLayout) findViewById(R.id.explore_llayout);
        mTabMe= (LinearLayout) findViewById(R.id.me_llayout);

        mWeixinTxt= (TextView) findViewById(R.id.text_weixin);
        mFriendsTxt= (TextView) findViewById(R.id.text_friends);
        mExploreTxt= (TextView) findViewById(R.id.text_explore);
        mMeTxt= (TextView) findViewById(R.id.text_me);

        LayoutInflater mInflater= LayoutInflater.from(this);
        View tab1=mInflater.inflate(R.layout.view1,null);
        View tab2=mInflater.inflate(R.layout.view2,null);
        View tab3=mInflater.inflate(R.layout.view3,null);
        View tab4=mInflater.inflate(R.layout.view4,null);

        mViews.add(tab1);
        mViews.add(tab2);
        mViews.add(tab3);
        mViews.add(tab4);

        madapter=new MyPagerAdapter(mViews);
        mViewPager.setAdapter(madapter);


        try {
            listView= (ListView) tab1.findViewById(R.id.listview_contact);
            initList();
//            chatList.add(new Chat(R.mipmap.ic_launcher,"李航"," 666"));
            adapter=new MyListAdapter(MainActivity.this,R.layout.item_layout,chatList);
            listView.setAdapter(adapter);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    private void initList() {
        for (int i=0;i<20;i++){
            chatList.add(new Chat(R.mipmap.ic_launcher,"李航"," 666"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.search:
                Toast.makeText(this,"你点击了搜索",Toast.LENGTH_SHORT).show();
                break;
            case R.id.add:
                Toast.makeText(this,"你点击了添加",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
    private void resetImg(){
        mWeixinImg.setImageResource(R.drawable.chat_before);
        mFriendsImg.setImageResource(R.drawable.friends_before);
        mExploreImg.setImageResource(R.drawable.explore_before);
        mMeImg.setImageResource(R.drawable.me_before);
        mWeixinTxt.setTextColor(getResources().getColor(android.R.color.white));
        mFriendsTxt.setTextColor(getResources().getColor(android.R.color.white));
        mExploreTxt.setTextColor(getResources().getColor(android.R.color.white));
        mMeTxt.setTextColor(getResources().getColor(android.R.color.white));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK && event.getAction()==KeyEvent.ACTION_DOWN){
            if(System.currentTimeMillis()-exitTime>2000){
                Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
                exitTime=System.currentTimeMillis();
            }else{
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        resetImg();
        switch (v.getId()){
            case R.id.chat_llayout:
                mViewPager.setCurrentItem(0);
                mWeixinImg.setImageResource(R.drawable.chat_after);
                mWeixinTxt.setTextColor(getResources().getColor(R.color.green));
                break;
            case R.id.friends_llayout:
                mFriendsImg.setImageResource(R.drawable.friends_after);
                mViewPager.setCurrentItem(1);
                mFriendsTxt.setTextColor(getResources().getColor(R.color.green));
                break;
            case R.id.explore_llayout:
                mViewPager.setCurrentItem(2);
                mExploreImg.setImageResource(R.drawable.explore_after);
                mExploreTxt.setTextColor(getResources().getColor(R.color.green));
                break;
            case R.id.me_llayout:
                mViewPager.setCurrentItem(3);
                mMeImg.setImageResource(R.drawable.me_after);
                mMeTxt.setTextColor(getResources().getColor(R.color.green));
                break;
            case R.id.imgbtn_chat:
                mViewPager.setCurrentItem(0);
                mWeixinImg.setImageResource(R.drawable.chat_after);
                mWeixinTxt.setTextColor(getResources().getColor(R.color.green));
                break;
            case R.id.imgbtn_friends:
                mFriendsImg.setImageResource(R.drawable.friends_after);
                mViewPager.setCurrentItem(1);
                mFriendsTxt.setTextColor(getResources().getColor(R.color.green));
                break;
            case R.id.imgbtn_explore:
                mViewPager.setCurrentItem(2);
                mExploreImg.setImageResource(R.drawable.explore_after);
                mExploreTxt.setTextColor(getResources().getColor(R.color.green));
                break;
            case R.id.imgbtn_me:
                mViewPager.setCurrentItem(3);
                mMeImg.setImageResource(R.drawable.me_after);
                mMeTxt.setTextColor(getResources().getColor(R.color.green));
                break;
        }

    }
}

package com.example.myweibo;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener{
	private LinearLayout[] lines = new LinearLayout[4];
	private int[] lineIds = {R.id.act_line1,R.id.act_line2,R.id.act_line3,R.id.act_line4};
	private ImageView[] imgs = new ImageView[4];
	private int[] imgIds = {R.id.act_line1_iv,R.id.act_line2_iv,R.id.act_line3_iv,R.id.act_line4_iv};
	private TextView[] tvs = new TextView[4];
	private int[] tvIds = {R.id.act_line1_tv,R.id.act_line2_tv,R.id.act_line3_tv,R.id.act_line4_tv};
	private List<Fragment> list;
	private ViewPager vp;
	private FragmentManager manager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bmob.initialize(this, "a3c34d118212065e18ead9004aca9107");
		setContentView(R.layout.activity_main);
		initView();
        
		list = new ArrayList<Fragment>();
		list.add(new ShouYeFragment());
		list.add(new MessageFragment());
		list.add(new FindFragment());
		list.add(new WoFragment());
		manager = getSupportFragmentManager();
		vp.setAdapter(new MyAdapter(manager));
		
	}
	private void initView() {
		for (int i = 0; i < 4; i++) {
			lines[i] = (LinearLayout) findViewById(lineIds[i]);
			imgs[i] = (ImageView) findViewById(imgIds[i]);
			tvs[i] = (TextView) findViewById(tvIds[i]);
			lines[i].setOnClickListener(this);
		}
		vp = (ViewPager) findViewById(R.id.act_main_vp);
		vp.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				
				changeView(arg0);
				System.out.println("arg0");
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			

			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.act_line1:
			changeView(0);
			vp.setCurrentItem(0);
			break;
		case R.id.act_line2:
			changeView(1);
			vp.setCurrentItem(1);
			break;
		case R.id.act_line3:
			changeView(2);
			vp.setCurrentItem(2);
			break;
		case R.id.act_line4:
			changeView(3);
			vp.setCurrentItem(3);
			break;
		
		}
	}
	int[] imgOff = {R.drawable.tabbar_home
			,R.drawable.tabbar_message_center
			,R.drawable.tabbar_discover
			,R.drawable.tabbar_profile};
	int[] imgOn = {R.drawable.tabbar_home_highlighted
			,R.drawable.tabbar_message_center_highlighted
			,R.drawable.tabbar_discover_highlighted
			,R.drawable.tabbar_profile_highlighted};
	public void changeView(int arg0) {
		System.out.println("µã»÷ÊÂ¼þ"+arg0);
		for (int j = 0; j < 4; j++) {
			if(j==arg0){
				System.out.println("---------"+arg0);
				imgs[j].setImageResource(imgOn[j]);
				tvs[j].setTextColor(Color.parseColor("#FF6C3B"));
				
			}else{
				imgs[j].setImageResource(imgOff[j]);
				tvs[j].setTextColor(Color.parseColor("#000000"));
			}
		}
	}
	class MyAdapter extends FragmentStatePagerAdapter{
		
		public MyAdapter(FragmentManager fm) {
			super(fm);
		}
		
		@Override
		public Fragment getItem(int arg0) {
			return list.get(arg0);
		}
		
		@Override
		public int getCount() {
			return list.size();
		}
		
	}
	
	public void getDataFromFragment(String data){
		((ShouYeFragment) list.get(0)).getDataFromActivity(data);
	}
	public void onClick1(View v){
		Intent intent = new Intent(this,ZhuCeActivity.class);
		startActivity(intent);
	}
	public void onClick2(View v){
		Intent intent = new Intent(this,DengLuActivity.class);
		startActivity(intent);
	}
}

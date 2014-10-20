package com.example.musicplayer;




import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	
	String[] Slist={"Track1","Track2","Track3","Track4","Track5"};

	ImageButton btnNext,btnPrevious;
	ImageView sicon,artists;
	TextView stitle;
	int i=-1;
	private static final int NUM_PAGES=5;
	private ViewPager mPager;
	private PagerAdapter mPagerAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnNext=(ImageButton)findViewById(R.id.imgN);
		btnPrevious=(ImageButton)findViewById(R.id.imgP);
		sicon=(ImageView)findViewById(R.id.imgIcon);
		artists=(ImageView)findViewById(R.id.imgArtists);
		stitle=(TextView)findViewById(R.id.txtTitile);
		
		//mPager=(ViewPager)findViewById(R.id.pager);
		//mPagerAdapter=new ScreenSlidePagerAdapter(getSupportFragmentManager());
		//mPager.setAdapter(mPagerAdapter);	
		
		btnNext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				i++;
				ChangeSong();
			}
		});
		
		btnPrevious.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i--;
				ChangeSong();
			}
		});
	}

	public void ChangeSong()
	{
		
		if(i>=0 && i<5)
		{
			
		Resources res=this.getResources();
		int id=res.getIdentifier("track"+i , "drawable","com.example.musicplayer");
		 sicon.setImageResource(id);
		 sicon.refreshDrawableState();
		 sicon.invalidate();
		 
		 artists.setImageResource(id);
		artists.refreshDrawableState();
		artists.invalidate();
		 stitle.setText(Slist[i]);
		}
		else
			i=-1;
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	/*
	private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(android.support.v4.app.FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		

        @Override
        public Fragment getItem(int position) {
        	
    		
            return new PageFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }*/
}

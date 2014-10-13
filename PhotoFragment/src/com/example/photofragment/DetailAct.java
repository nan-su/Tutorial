package com.example.photofragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

public class DetailAct extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		DetailFrag df=new DetailFrag();
		df.setArguments(getIntent().getExtras());
		getFragmentManager().beginTransaction().add(android.R.id.content, df).commit();
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		return super.onMenuItemSelected(featureId, item);
	}

}

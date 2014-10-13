package com.example.assignment1;




import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements TabListener {
	//public final static String EXTRA_MESSAGE = "com.example.assignment1.MESSAGE";
	public final static String EXTRA_MESSAGE="com.example.assignment1.MESSAGE";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv1=(TextView)findViewById(R.id.tv1);
		tv1.setText(tv1.getResources().getText(R.string.hello_world).toString());
		ActionBar actionbar1=getActionBar();
		//actionbar1.setDisplayHomeAsUpEnabled(true);
		
		actionbar1.addTab(actionbar1.newTab().setText("Tab1").setTabListener(this));
		actionbar1.addTab(actionbar1.newTab().setText("Tab2").setTabListener(this));
		actionbar1.addTab(actionbar1.newTab().setText("Tab3").setTabListener(this));
		actionbar1.addTab(actionbar1.newTab().setText("Tab4").setTabListener(this));
		actionbar1.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		getActionBar().setSubtitle("Testing 123");
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch(item.getItemId())
		 {
		 case android.R.id.home:
			 Toast.makeText(this,item.getTitle(), Toast.LENGTH_LONG).show();break;
		 case R.id.action_search:
			 Toast.makeText(this,item.getTitle(), Toast.LENGTH_LONG).show();break;
		 case R.id.action_settings:
			 Toast.makeText(this,item.getTitle(), Toast.LENGTH_LONG).show();break;
		 		 
		 }
		 return false;
	}
	
	public void SendMessage(View view)
	{
		
		Intent intent= new Intent(this,TestActivity.class );
		EditText ed1=(EditText)findViewById(R.id.editText1);
		String message=ed1.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		Toast.makeText(this,arg0.getText()+"onTabReselected", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		Toast.makeText(this, arg0.getText()+"onTabSelected",Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		Toast.makeText(this,arg0.getText()+"onTabUnselected", Toast.LENGTH_SHORT).show();
	}
}

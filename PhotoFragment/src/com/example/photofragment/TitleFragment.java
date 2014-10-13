package com.example.photofragment;


import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitleFragment extends ListFragment{
	Boolean isDual;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_activated_1,InfoText.Name));
	
		//View detail=getActivity().findViewById(R.id.textView1);
		isDual=getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE;
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		if(isDual)
		{
			setFragment(position);
		}
		else
		{
			
			setActivity(position);
		}
	}
	private void setFragment(int position) {
		// TODO Auto-generated method stub
		
            DetailFrag dff=(DetailFrag)getFragmentManager().findFragmentById(R.id.details);
            
            if(dff ==null|| dff.getPosition() !=position)
            {
            	dff=DetailFrag.newInstance(position);
            	
            	 android.app.FragmentTransaction ft=getFragmentManager().beginTransaction();
            	
            	ft.replace(R.id.details, dff);
            	ft.setTransition(android.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            	ft.commit();
            }
		
		
		
	}
	private void setActivity(int position) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		intent.setClass(getActivity(), DetailAct.class);
		intent.putExtra("position", position);
		startActivity(intent);
		
	}

}

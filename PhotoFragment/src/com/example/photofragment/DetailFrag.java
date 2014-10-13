package com.example.photofragment;


import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFrag extends Fragment{
	
	public static DetailFrag newInstance(int position){
		DetailFrag dd=new DetailFrag();
		
		Bundle args=new Bundle();
		args.putInt("position", position);
		dd.setArguments(args);
		return dd;
	}
	public int getPosition() {
		// TODO Auto-generated method stub
		return getArguments().getInt("position",0);
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v1= inflater.inflate(R.layout.detail,container,false);
		TextView tv1=(TextView)v1.findViewById(R.id.details);
		tv1.setText(InfoText.dName[getPosition()]);
		
		ImageView img1=(ImageView)v1.findViewById(R.id.imageView1);
		
		Resources res=getActivity().getResources();
		int id=res.getIdentifier("photo"+(getPosition()+1) , "drawable","com.example.photofragment");
		 img1.setImageResource(id);
		 img1.refreshDrawableState();
		 img1.invalidate();
		 
		 return v1;
		
		
	}

		

}

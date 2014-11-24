package org.nhnnext.cozyhome;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class List3CustomAdapter extends ArrayAdapter<List3Data> {

	private Context context;
	private ArrayList<List3Data> listData;
	private int layoutResourceId;

	public List3CustomAdapter(Context context, int layoutResourceId, ArrayList<List3Data> listData) {
		super(context, layoutResourceId, listData);
		
		this.context =context;
		this.layoutResourceId = layoutResourceId;
		this.listData = listData;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View row = convertView;
		
		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater(); 
			
			row = inflater.inflate(layoutResourceId, parent, false);
		}
		
		TextView textView1 = (TextView) row.findViewById(R.id.rowText1);
		TextView textView2 = (TextView) row.findViewById(R.id.rowText2);
		
		textView1.setText(listData.get(position).getText1());
		textView2.setText(listData.get(position).getText2());
		
		ImageView imageView = (ImageView) row.findViewById(R.id.rowImg);
		
		InputStream is;
		try {
			is = context.getAssets().open(listData.get(position).getImgName());
			Drawable d = Drawable.createFromStream(is, null);
			imageView.setImageDrawable(d);
			
		} catch (IOException e) {
			Log.e("ERROR", "ERROR: "+e);
		}
		
		return row;
	}
}

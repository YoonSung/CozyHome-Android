package org.nhnnext.cozyhome.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.nhnnext.cozyhome.R;
import org.nhnnext.cozyhome.R.id;
import org.nhnnext.cozyhome.model.Article;
import org.nhnnext.cozyhome.model.ListData;

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

public class CustomListAdapter extends ArrayAdapter<Article> {

	private Context context;
	private ArrayList<Article> articleList;
	private int layoutResourceId;

	public CustomListAdapter(Context context, int layoutResourceId, ArrayList<Article> articleList) {
		super(context, layoutResourceId, articleList);
		
		this.context =context;
		this.layoutResourceId = layoutResourceId;
		this.articleList = articleList;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View row = convertView;
		
		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater(); 
			
			row = inflater.inflate(layoutResourceId, parent, false);
		}
		
		TextView txtTitle = (TextView) row.findViewById(R.id.main_list_row_text1);
		TextView txtContent = (TextView) row.findViewById(R.id.main_list_row_text2);
		
		txtTitle.setText(articleList.get(position).getTitle());
		txtContent.setText(articleList.get(position).getContent());
		
		ImageView imageView = (ImageView) row.findViewById(R.id.main_list_row_img);
		
		InputStream is;
		try {
			is = context.getAssets().open(articleList.get(position).getImageName());
			Drawable d = Drawable.createFromStream(is, null);
			imageView.setImageDrawable(d);
			
		} catch (IOException e) {
			Log.e("ERROR", "ERROR: "+e);
		}
		
		return row;
	}
}

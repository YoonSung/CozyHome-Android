package org.nhnnext.cozyhome;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Main extends Activity implements OnItemClickListener{

	private ArrayList<ListData> dataList = new ArrayList<ListData>(); 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    
	    ListView listView = (ListView) findViewById(R.id.list3);
	    
	    ListData dto = null;
	    for (int i = 0; i < 5 ; i++) {
	    	dto = new ListData(i+"-첫번째 줄", i+"-두번째 줄", "0"+i+".jpg");
	    	dataList.add(dto);
		}
	    
	    CustomListAdapter adapter = new CustomListAdapter(this, R.layout.list3_row, dataList);
	    
	    listView.setAdapter(adapter);
	    listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		String msg = position+ "번 리스트가 선택됨";
		Log.i("TEST", msg);
		Toast.makeText(Main.this, msg, Toast.LENGTH_SHORT).show();
	}

}
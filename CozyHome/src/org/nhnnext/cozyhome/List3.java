package org.nhnnext.cozyhome;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class List3 extends Activity implements OnItemClickListener{

	private ArrayList<List3Data> dataList = new ArrayList<List3Data>(); 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.list3);
	    
	    ListView listView = (ListView) findViewById(R.id.list3);
	    
	    List3Data dto = null;
	    for (int i = 0; i < 5 ; i++) {
	    	dto = new List3Data(i+"-첫번째 줄", i+"-두번째 줄", "0"+i+".jpg");
	    	dataList.add(dto);
		}
	    
	    List3CustomAdapter adapter = new List3CustomAdapter(this, R.layout.list3_row, dataList);
	    
	    listView.setAdapter(adapter);
	    listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		String msg = position+ "번 리스트가 선택됨";
		Log.i("TEST", msg);
		Toast.makeText(List3.this, msg, Toast.LENGTH_SHORT).show();
	}

}

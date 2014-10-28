package org.nhnnext.cozyhome;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List1 extends Activity {

	ListView listView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.list1);
	    
	    listView = (ListView) findViewById(R.id.list1);
	    
	    ArrayList<String> dataList = new ArrayList<String>();

	    for (int i = 0; i < 5; i++) {
	    	dataList.add("데이터 "+i);
		}
	    
	    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList);
	    
	    listView.setAdapter(arrayAdapter);
 	}

}

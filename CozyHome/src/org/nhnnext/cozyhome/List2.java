package org.nhnnext.cozyhome;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class List2 extends Activity {

	ListView listView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.list2);
	    
	    listView = (ListView) findViewById(R.id.list2);
	    
	    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String,String>>();
	    
	    for (int i = 0; i < 5; i++) {
	    	HashMap<String, String> map = new HashMap<String, String>();
	    	map.put("line1", "첫번째 줄의 " + i + "번");
	    	map.put("line2", "두번째 줄의 " + i + "번");
	    	
	    	dataList.add(map);
		}
	    
	    String[] from = {"line1", "line2"};
	    		
	    int[] to = {android.R.id.text1, android.R.id.text2};
	    
	    SimpleAdapter adapter = new SimpleAdapter(this, dataList, android.R.layout.simple_list_item_2, from, to); 
	    
	    listView.setAdapter(adapter);
	}

}

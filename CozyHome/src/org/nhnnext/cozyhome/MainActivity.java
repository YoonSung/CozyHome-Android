package org.nhnnext.cozyhome;

import java.util.ArrayList;

import org.nhnnext.cozyhome.model.ListData;
import org.nhnnext.cozyhome.support.CustomListAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener{

	private ArrayList<ListData> dataList = new ArrayList<ListData>(); 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    
	    ListView listView = (ListView) findViewById(R.id.main_list);
	    
	    ListData dto = null;
	    for (int i = 0; i < 5 ; i++) {
	    	dto = new ListData(i+"-첫번째 줄", i+"-두번째 줄", "0"+i+".jpg");
	    	dataList.add(dto);
		}
	    
	    CustomListAdapter adapter = new CustomListAdapter(this, R.layout.main_list_row, dataList);
	    
	    listView.setAdapter(adapter);
	    listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		String msg = position+ "번 리스트가 선택됨";
		Log.i("TEST", msg);
		Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
	}

}
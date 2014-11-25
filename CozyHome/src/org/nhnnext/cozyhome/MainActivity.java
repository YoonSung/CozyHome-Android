package org.nhnnext.cozyhome;

import java.util.ArrayList;

import org.nhnnext.cozyhome.model.ListData;
import org.nhnnext.cozyhome.support.CustomListAdapter;
import org.nhnnext.cozyhome.support.Dao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener, OnClickListener{

	private static final String TAG = MainActivity.class.getName();
	private ArrayList<ListData> dataList = new ArrayList<ListData>(); 
	private Button btnWrite;
	private Button btnRefresh;
	private ListView listView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    
	    initialize();
	    setupListView();
	    setEvent();
	    
	}

	private void setEvent() {
		listView.setOnItemClickListener(this);
		btnRefresh.setOnClickListener(this);
		btnWrite.setOnClickListener(this);
	}

	private void setupListView() {
		ListData dto = null;
	    for (int i = 0; i < 5 ; i++) {
	    	//TODO DELTE Codeline Text
	    	dto = new ListData(i+"-첫번째 줄", i+"-두번째 줄", "0"+i+".jpg");
	    	dataList.add(dto);
		}
	    
	    CustomListAdapter adapter = new CustomListAdapter(this, R.layout.main_list_row, dataList);
	    
	    listView.setAdapter(adapter);
	}

	private void initialize() {
		listView = (ListView) findViewById(R.id.main_list);
	    btnWrite = (Button) findViewById(R.id.main_btn_write);
	    btnRefresh = (Button) findViewById(R.id.main_btn_refresh);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		//TODO DELTE Codeline Text
		String msg = position+ "번 리스트가 선택됨";
		Log.i(TAG, msg);
		Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.main_btn_write:
			startActivity(new Intent(MainActivity.this, WriteActivity.class));
			break;

		case R.id.main_btn_refresh:
			//TODO DELTE Codeline Text
			Dao dao = new Dao(getApplicationContext());
			dao.insert(dao.getJsonTestData());
			Toast.makeText(MainActivity.this, "Refresh!", Toast.LENGTH_SHORT).show();
			break;
		}
	}

}
package org.nhnnext.cozyhome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener {

	Button btnList1, btnList2, btnList3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btnList1 = (Button) findViewById(R.id.btnList1);
		btnList2 = (Button) findViewById(R.id.btnList2);
		btnList3 = (Button) findViewById(R.id.btnList3);

		btnList1.setOnClickListener(this);
		btnList2.setOnClickListener(this);
		btnList3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		Class target = null;
		
		switch (v.getId()) {
		case R.id.btnList1:
			target = List1.class;
			break;

		case R.id.btnList2:
			Toast.makeText(Main.this, "List2", Toast.LENGTH_SHORT).show();
			break;
		case R.id.btnList3:
			Toast.makeText(Main.this, "List3", Toast.LENGTH_SHORT).show();
			break;
		}

		Intent intent = new Intent(Main.this, target);
		startActivity(intent);
	}

}

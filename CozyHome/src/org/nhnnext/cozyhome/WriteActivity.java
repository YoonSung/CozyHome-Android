package org.nhnnext.cozyhome;

import org.nhnnext.cozyhome.support.Constant;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.provider.SyncStateContract.Constants;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class WriteActivity extends Activity implements OnClickListener{

	EditText edtWriter, edtTitle, edtContent;
	Button btnSave;
	ImageButton btnPhoto;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_write);
	    
	    edtWriter = (EditText) findViewById(R.id.activity_writer_edt_writer);
	    edtTitle = (EditText) findViewById(R.id.activity_writer_edt_title);
	    edtContent = (EditText) findViewById(R.id.activity_writer_edt_content);
	    
	    btnSave = (Button) findViewById(R.id.activity_writer_btn_save);
	    btnPhoto = (ImageButton) findViewById(R.id.activity_writer_btn_photo);
	    
	    btnSave.setOnClickListener(this);
	    btnPhoto.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.activity_writer_btn_photo:
			Intent intent = new Intent(Intent.ACTION_PICK);
			intent.setType(Images.Media.CONTENT_TYPE);
			intent.setData(Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(intent, Constant.INTENT_REQUEST_PHOTO_ALBUM);
			
			break;
		case R.id.activity_writer_btn_save:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == Constant.INTENT_REQUEST_PHOTO_ALBUM) {
			Uri uri = getRealPathUri(data.getData());
			String filePath = uri.toString();
			String fileName = uri.getLastPathSegment();
			
			Bitmap bitmap = BitmapFactory.decodeFile(filePath);
			btnPhoto.setImageBitmap(bitmap);
		}
	}

	private Uri getRealPathUri(Uri uri) {
		Uri filePathUri = uri;
		if (uri.getScheme().toString().compareTo("content") == 0) {
			Cursor cursor = getApplicationContext().getContentResolver().query(uri, null, null, null, null);
			if (cursor.moveToFirst()) {
				int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
				filePathUri = Uri.parse(cursor.getString(columnIndex));
			}
		}
		return filePathUri;
	}
	
}
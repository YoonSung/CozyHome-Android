package org.nhnnext.cozyhome.support;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Dao {
	private static final String TAG = Dao.class.getName();
	private Context context;
	private SQLiteDatabase database; 
	
	public Dao(Context context) {
		this.context = context;
		
		//Initialize SQLite
		database = context.openOrCreateDatabase("cozyhome", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		
		//Create table If not exists
		try {
			String sql = "CREATE TABLE IF NOT EXISTS Articles(" 
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "title TEXT NOT NULL,"
					+ "article_num INTEGER UNIQUE not null,"
					+ "writer TEXT NOT NULL,"
					+ "writer_id TEXT NOT NULL,"
					+ "content TEXT NOT NULL,"
					+ "write_date TEXT NOT NULL,"
					+ "img_name TEXT UNIQUE NOT NULL"
					+ ");";
			database.execSQL(sql);
		} catch (Exception e) {
			Log.e(TAG, "CREATE TABLE FAILED! - "+e);
			e.printStackTrace();
		}
	}
	
	public void insert(String jsonData) {
		
		//Temp Variable
		int articleNumber;
		String title;
		String writer;
		String writerId;
		String content;
		String writeDate;
		String imageName;
		
		try {
			JSONArray jsonArray = new JSONArray(jsonData);
			
			JSONObject jsonObject = null;
			for (int i = 0; i < jsonArray.length(); ++i) {
				jsonObject = jsonArray.getJSONObject(i);
				
				String sql = "CREATE TABLE IF NOT EXISTS Articles(" 
						+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
						+ "title TEXT NOT NULL,"
						+ "article_num INTEGER UNIQUE not null,"
						+ "writer TEXT NOT NULL,"
						+ "writer_id TEXT NOT NULL,"
						+ "content TEXT NOT NULL,"
						+ "write_date TEXT NOT NULL,"
						+ "img_name TEXT UNIQUE NOT NULL"
						+ ");";
				
				articleNumber = jsonObject.getInt("article_num");
				title = jsonObject.getString("title");
				writer = jsonObject.getString("writer");
				writerId = jsonObject.getString("writer_id");
				content = jsonObject.getString("content");
				writeDate = jsonObject.getString("write_date");
				imageName = jsonObject.getString("img_name");
				
				Log.i(TAG, "ArticleNumber : "+articleNumber + "Title : "+title);
			}
			
		} catch (JSONException e) {
			Log.e(TAG, "JSON ERROR! - " +e);
			e.printStackTrace();
		}
	}
	
	/**
	 * JSON파싱을 위한 테스트 문자열입니다.
	 * 각 데이터는 다음과 같습니다.
	 * ArticleNumber - 글번호 중복X 숫자
	 * Title - 글제목 문자열
	 * Writer - 작성자
	 * Id - 작성자ID
	 * Content - 글내용
	 * WriteDate - 작성일
	 * ImgName - 사진명
	 */
	public String getJsonTestData() {

		StringBuilder sb = new StringBuilder();
		sb.append("");
		
		sb.append("[");
		
		sb.append("	 {");
		sb.append("	    'article_num':'1',");
		sb.append("	    'title':'오늘도 좋은 하루',");
		sb.append("	    'writer':'학생1',");
		sb.append("	    'writer_id':'6613d02f3e2153283f23bf621145f877',");
		sb.append("	    'content':'하지만 곧 기말고사지...',");
		sb.append("	    'write_date':'2013-09-23-10-10',");
		sb.append("	    'img_name':'photo1.jpg'");
		sb.append("	 },");
		sb.append("	 {");
		sb.append("	    'article_num':'2',");
		sb.append("	    'title':'대출 최고 3000만원',");
		sb.append("	    'writer':'김미영 팀장',");
		sb.append("	    'writer_id':'6326d02f3e2153266f23bf621145f734',");
		sb.append("	    'content':'김미영팀장입니다. 고갱님께서는 최저이율로 최고 3000만원까지 30분 이내 통장입금가능합니다.',");
		sb.append("	    'write_date':'2013-09-24-11-22',");
		sb.append("	    'img_name':'photo2.jpg'");
		sb.append("	 },");
		sb.append("	 {");
		sb.append("	    'article_num':'3',");
		sb.append("	    'title':'MAC등록신청',");
		sb.append("	    'writer':'학생2',");
		sb.append("	    'writer_id':'8426d02f3e2153283246bf6211454262',");
		sb.append("	    'content':'1a:2b:3c:4d:5e:6f',");
		sb.append("	    'write_date':'2013-09-25-12-33',");
		sb.append("	    'img_name':'photo3.jpg'");
		sb.append("	 }");
		
		sb.append("]");
		 
		 return sb.toString();
	}
}

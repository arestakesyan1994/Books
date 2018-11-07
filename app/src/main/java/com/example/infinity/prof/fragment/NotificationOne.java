package com.example.infinity.prof.fragment;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.infinity.prof.R;
import com.example.infinity.prof.handler.ResponseHandler;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;
import java.util.HashMap;

public class NotificationOne extends Activity implements View.OnClickListener {

	ApiService mApiService;
	ResponseHandler session;
	private ListView notifications;
	private ListView notificationTime;
	TextView not;
	TextView timss;

	@Override
	   public void onCreate(Bundle savedInstanceState)
	   {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.notification_one);
	      CharSequence s = "Inside the activity of Notification one ";
	      int id=0;
	      
	      Bundle extras = getIntent().getExtras();
			if (extras == null) {
				s = "error";
			}
			else {
				id = extras.getInt("notificationId");
			}
			NotificationManager myNotificationManager = 
					(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
			
			// remove the notification with the specific id
			myNotificationManager.cancel(id);

		   mApiService = UtilsApi.getAPIService();
		   session = new ResponseHandler(getApplicationContext());
		   session.checkLogin();

		   HashMap<String, String> user = session.getResponseDetails();
		   System.out.println("start");

		   String text = user.get(ResponseHandler.NOTIFICATION_TEXT);
		   String[] notText = text.split("%");

		   String count = user.get(ResponseHandler.NOTIFICATION_WHEN);
		   String[] time = count.split("%");

		   ArrayAdapter<CharSequence> end = new ArrayAdapter<CharSequence>(this, R.layout.row_item, R.id.textNot, notText);
		   ArrayAdapter<CharSequence> tims = new ArrayAdapter<CharSequence>(this, R.layout.row_item, R.id.times, time);
		   notifications = (ListView) findViewById(R.id.notification);
//		   not = (TextView) findViewById(R.id.textNot);
		   notifications.setAdapter(end);
//		   notifications.setAdapter(tims);

           System.out.println(time);
//		   ArrayAdapter<CharSequence> when = new ArrayAdapter<CharSequence>(this, R.layout.list_item, time);
//           notificationTime = (ListView) findViewById(R.id.notificationTime);
//           notificationTime.setAdapter(when);


	   }

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
			case R.id.notification:
				intent = new Intent(NotificationOne.this,TnajinFragment.class);
				startActivity(intent);
				break;
		}
	}
}
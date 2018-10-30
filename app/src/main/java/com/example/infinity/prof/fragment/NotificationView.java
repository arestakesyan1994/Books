package com.example.infinity.prof.fragment;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;  
import android.widget.TextView;  
import android.widget.Toast;

import com.example.infinity.prof.R;

public class NotificationView extends AppCompatActivity {
    TextView textView;
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
			TextView t = (TextView) findViewById(R.id.textView);
			s = s+"with id = "+id;
			t.setText(s);
			NotificationManager myNotificationManager =
					(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

			// remove the notification with the specific id
			myNotificationManager.cancel(id);
	   }


//    TextView textView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.notification_one);
//        textView = findViewById(R.id.textView);
//        //getting the notification message
//        String message=getIntent().getStringExtra("message");
//        textView.setText(message);
//    }
}  
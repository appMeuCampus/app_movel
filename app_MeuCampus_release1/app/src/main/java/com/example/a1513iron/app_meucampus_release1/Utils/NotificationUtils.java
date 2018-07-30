package com.example.a1513iron.app_meucampus_release1.Utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.text.Html;

import com.example.a1513iron.app_meucampus_release1.Activities.MainActivity;
import com.example.a1513iron.app_meucampus_release1.Activities.SobreActivity;
import com.example.a1513iron.app_meucampus_release1.Notification.NotificationVO;
import com.example.a1513iron.app_meucampus_release1.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abhi on 13 Nov 2017 013.
 */

public class NotificationUtils {
    private static final int NOTIFICATION_ID = 200;
    private static final String PUSH_NOTIFICATION = "pushNotification";
    private static final String CHANNEL_ID = "myChannel";
    private static final String URL = "url";
    private static final String ACTIVITY = "activity";
    Map<String, Class> activityMap = new HashMap<>();
    private Context mContext;

    public NotificationUtils(Context mContext) {
        this.mContext = mContext;
        //Populate activity map
        activityMap.put("MainActivity", MainActivity.class);
        activityMap.put("SecondActivity", SobreActivity.class);
    }

    /**
     * Displays notification based on parameters
     *
     * @param notificationVO
     * @param resultIntent
     */
    public void displayNotification(NotificationVO notificationVO, Intent resultIntent) {
        {
            String message = notificationVO.getMessage();
            String title = notificationVO.getTitle();
            //
            //String action = notificationVO.getAction();
            //String destination = notificationVO.getActionDestination();
            //Bitmap iconBitMap = null;

            final int icon = R.drawable.logo_circulo;

            PendingIntent resultPendingIntent;


            resultIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            resultPendingIntent =
                    PendingIntent.getActivity(
                            mContext,
                            0,
                            resultIntent,
                            PendingIntent.FLAG_CANCEL_CURRENT
                    );


            final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                    mContext, CHANNEL_ID);

            Notification notification;


            //When Inbox Style is applied, user can expand the notification
            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

            inboxStyle.addLine(message);
            notification = mBuilder
                    .setSmallIcon(R.drawable.ic_notificationicon_teste5)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setAutoCancel(true)
                    .setContentIntent(resultPendingIntent)
                    .setStyle(inboxStyle)
                    .build();


            NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(NOTIFICATION_ID, notification);
        }
    }


    /**
     * Playing notification sound
     */
    public void playNotificationSound() {
        try {
            Uri alarmSound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE
                    + "://" + mContext.getPackageName() + "/raw/notification");
            Ringtone r = RingtoneManager.getRingtone(mContext, alarmSound);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
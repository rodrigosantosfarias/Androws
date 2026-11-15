package br.com.rocardan.androws;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.content.Intent;
public class NoticeService extends NotificationListenerService {
 @Override public void onNotificationPosted(StatusBarNotification sbn){ sendBroadcast(new Intent("br.com.rocardan.androws.NOTICE").setPackage(getPackageName())); }
 @Override public void onNotificationRemoved(StatusBarNotification sbn){ sendBroadcast(new Intent("br.com.rocardan.androws.NOTICE").setPackage(getPackageName())); }
}

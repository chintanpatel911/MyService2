package com.example.chintanpatel.myservice2;

/**
 * Created by Chintan Patel on 4/18/2018.
 */
import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import java.net.MalformedURLException;
import java.net.URL;

public class MyIntentService extends IntentService {
    public MyIntentService() {
        super("MyIntentServiceName");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            int result =
                    DownloadFile(new URL("http://www.amazon.com/somefile.pdf"));
            Log.d("IntentService", "Downloaded " + result + " bytes");
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction("FILE_DOWNLOADED_ACTION");
            getBaseContext().sendBroadcast(broadcastIntent);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    private int DownloadFile(URL url) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) { e.printStackTrace();  }
        return 100;
    }
}

package work.beltran.rentaboat

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDeepLinkBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendFakeNotification()
    }


    private fun sendFakeNotification() {
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val important = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channel0", "name", important)
            notificationManager.createNotificationChannel(channel)
        }

        /*Arguments for the boatFragment to receive, using the generated BoatFragmentClass
        and a random id parameter of 3, and converting it to bundle*/
        val args = BoatFragmentArgs.Builder(3).build().toBundle()

        val pendingIntent = NavDeepLinkBuilder(this)
                .setGraph(R.navigation.nav_graph_main)
                .setDestination(R.id.boatFragment)
                .setArguments(args)
                .createPendingIntent()

        val notification = Notification.Builder(this)
                .setContentTitle("Now on sale!")
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.speed_boat_blue)
                .setContentIntent(pendingIntent)

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            notification.setChannelId("channel0")
        }

        notificationManager.notify(0, notification.build())
    }
}

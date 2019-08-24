package inductiongames.colourblind;

//import com.scoreloop.client.android.ui.LeaderboardsScreenActivity;
//import com.scoreloop.client.android.ui.ScoreloopManagerSingleton;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class scorlup {

	public static void submitscr(int scr) {

		Double scoreResult = (double) scr;
		if (scoreResult > 10)
			//ScoreloopManagerSingleton.get().onGamePlayEnded(scoreResult, 0);
		if (HaveNetworkConnection())
			show();
		else
			show_local();
	} 

	private static boolean HaveNetworkConnection() {
		boolean HaveConnectedWifi = false;
		boolean HaveConnectedMobile = false;

		ConnectivityManager cm = (ConnectivityManager) colourremedy.contex
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo[] netInfo = cm.getAllNetworkInfo();
		for (NetworkInfo ni : netInfo) {
			if (ni.getTypeName().equalsIgnoreCase("WIFI"))
				if (ni.isConnected())
					HaveConnectedWifi = true;
			if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
				if (ni.isConnected())
					HaveConnectedMobile = true;
		}
		return HaveConnectedWifi || HaveConnectedMobile;
	}

	public static void show() {

		//final Intent intent = new Intent(colorblind.contex,
			//	LeaderboardsScreenActivity.class);
		//colorblind.contex.startActivity(intent);

	}

	public static void show_local() {

		//final Intent intent = new Intent(colorblind.contex,
		//		LeaderboardsScreenActivity.class);
		//intent.putExtra(LeaderboardsScreenActivity.LEADERBOARD,
		//		LeaderboardsScreenActivity.LEADERBOARD_LOCAL);
		//colorblind.contex.startActivity(intent);

	}

	public static void init() {
		//ScoreloopManagerSingleton.init(colorblind.contex,
		//		"YO25A++qAyZbIxm+UorL9N7tM9eZ5LhBVlsZ0fzs/Q7TuWiJOHLThw==");

	}

	public static void destroy() {

		//ScoreloopManagerSingleton.destroy();

	}

}

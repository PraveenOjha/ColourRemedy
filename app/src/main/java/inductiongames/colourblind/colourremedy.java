package inductiongames.colourblind;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class colourremedy extends Activity {
	public class R {

	}

	public static Context contex;

	public static TextView textvrf;

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Context cn = this;
		contex = this;
		setfullscreen();
		setContentView(inductiongames.colorblind.R.layout.main);
		View mainmenuscreen = new ViewManager(cn);

		LinearLayout layout = (LinearLayout) findViewById(inductiongames.colorblind.R.id.fd);
		LinearLayout layout1 = (LinearLayout) findViewById(inductiongames.colorblind.R.id.Fla);

		ViewManager.leadbot=0;
		layout.addView(mainmenuscreen);

	 
	}

	void setfullscreen() {
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	}
  public static void showleadbot()
	 {
		 Runnable r= new Thread()
	 	 { @Override public void run()
		  {super.run();
		  fn();
		  }	  
        };
	 		
	  ((Activity) contex).runOnUiThread(r);
   }

	 
	 protected static void fn() 
	 {   switch(ViewManager.leadbot)
		 {//case 0:adholder.setVisibility(View.GONE); break;
		 //case 1:adholder.setVisibility(View.VISIBLE);break;
		 }
	 }

	public void quit() {
		new Thread() {
			@Override
			public void run() {
				super.run();
				try {
					while (!Menu.quit) {
						Thread.sleep(500);
					}
				} catch (InterruptedException e) {
				} finally {
					Menu.quit = false;
					alert.flag = false;
					this.stop();
					scorlup.destroy();
					finish();
				}
			}

		}.start();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	
		
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			
		if(ViewManager.leadbot==1)
			{ViewManager.leadbot=0;
			colourremedy.showleadbot();
			return false;
			}
	   	
			
			if (ViewManager.viewid == 1) {
				if (alert.flag == false) {
					alert.flag = true;
					Menu.al = 3;
					quit();
				} else if (alert.flag == true && Menu.al == 3) {
					alert.flag = false;
					finish();
				} else if (alert.flag == true) {
					alert.flag = false;

				}
			} else {
				if (alert.flag == false) {
					switch (ViewManager.viewid) {
					case 2:
						ViewManager.viewid = 1;
						break;
					case 3:
						ViewManager.viewid = 5;
						break;
					case 4:
						if (episelector.episode != 4)
							ViewManager.viewid = 3;
						else
							ViewManager.viewid = 2;
						break;
					case 5:
						ViewManager.viewid = 2;
						break;
					}
				} else
					alert.flag = false;

			}

			return true;

		}

		return false;

	}

}

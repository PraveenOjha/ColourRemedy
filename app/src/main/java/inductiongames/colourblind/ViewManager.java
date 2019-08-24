package inductiongames.colourblind;

import java.util.Random;

import inductiongames.colorblind.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class ViewManager extends View {

	public enum views {
		main, episode, stage, game, colorshow
	}

	public static Random r;
	boolean isselected = false;
	long refreshtime = 10;
	static int width = 0; 
	static int height = 0;
	public boolean splash = true;
	private Rect dest;
	private long inittimer;
	private long waittimer = 5000;
	public static int viewid = 1;
	static public int onb = 0;
	public static int numberofstage;
	public static Datastore savedstate;
	public static Bitmap eassel;
	public static Bitmap nonsol;
	public static Bitmap bk;
	public static Bitmap nx;
	public static curData levlholders;
	public static int leadbot=0;

	public ViewManager(Context context) {
		super(context);
		this.setFocusable(true);
		r = new Random();
		splash = true;
		Menu.grat = BitmapFactory.decodeResource(getResources(), R.drawable.splash);
		Menu.colorpicker = BitmapFactory.decodeResource(getResources(),
				R.drawable.cs);
		colorpicker.temp = BitmapFactory.decodeResource(getResources(),
				R.drawable.cs);
		Menu.logo = BitmapFactory.decodeResource(getResources(),
				R.drawable.colorblind);
		Menu.sp1 = BitmapFactory.decodeResource(getResources(), R.drawable.ind);
		Menu.spscreen = BitmapFactory.decodeResource(getResources(),
				R.drawable.menu);
		Menu.lock = BitmapFactory.decodeResource(getResources(),
				R.drawable.lock);
		Menu.aspectRatio = ((double) Menu.spscreen.getWidth())
				/ Menu.spscreen.getHeight();
		Menu.aspectRatio1 = ((double) Menu.logo.getWidth())
				/ Menu.logo.getHeight();

		eassel = BitmapFactory.decodeResource(getResources(), R.drawable.btou);
		nonsol = BitmapFactory.decodeResource(getResources(), R.drawable.bunso);
		bk = BitmapFactory.decodeResource(getResources(), R.drawable.bk1);
		nx = BitmapFactory.decodeResource(getResources(), R.drawable.bk);

		numberofstage = 45;
		width = this.getWidth();
		height = this.getHeight();
		savedstate = Datastore.Load(Datastore.FILENAME, colourremedy.contex);
		scorlup.init();
		if (savedstate == null) {
			savedstate = new Datastore();
		}
		gameloop();

		inittimer = android.os.SystemClock.uptimeMillis();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		if (splash) {
			if (Menu.grat != null) {
				dest = new Rect(0, 0, this.getWidth(), this.getHeight());
				Menu.paint.setAntiAlias(true);
				canvas.drawBitmap(Menu.grat, null, dest, Menu.paint);
				if ((android.os.SystemClock.uptimeMillis() - inittimer) > waittimer)
					splash = false;
			}
		} else
			switch (viewid) {
			case 1:
				Menu.menu_draw(canvas, Menu.paint);
				break;
			case 2:
				episelector.episelector_draw(canvas, Menu.paint);
				break;
			case 3:
				showcolor.stage_draw(canvas, Menu.paint);
				break;
			case 4:
				game.stage_draw(canvas, Menu.paint);
				break;
			case 5:
				stage.stage_draw(canvas, Menu.paint);
				break;

			}
	}

	@Override
	public boolean onTouchEvent(final MotionEvent event) {
		if (!splash) {
			switch (viewid) {
			case 1:
				Menu.touch(event);
				break;
			case 2:
				episelector.touch(event);
				break;
			case 3:
				showcolor.touch(event);
				break;
			case 4:
				game.touch(event);
				break;
			case 5:
				stage.touch(event);
				break;
			}
			return true;
		}
		return false;

	}

	static public void viewchanger(int i) {
		switch (i) {
		case 0:
			viewid = 1;
			break;
		case 1:
			viewid = 2;
			break;
		case 2:
			viewid = 3;
			break;
		case 3:
			viewid = 4;
			break;
		case 4:
			viewid = 5;
			break;
		}

	}

	private void gameloop() {
		new Thread() {
			@Override
			public void run() {
				super.run();
				try {
					while (!isselected) {
						Thread.sleep(refreshtime);
						postInvalidate();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					this.stop();

				}
			}

		}.start();
		// TODO Auto-generated method stub

	}

	public static String cal_accu() {
		float accu = savedstate.gameper;
		if (accu < 50f)
			return "N.D.";
		accu = Math.round(accu * 10) / 10;
		return "" + accu;
	}

}

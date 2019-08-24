package inductiongames.colourblind;

import inductiongames.colorblind.R;

import java.util.Random;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.MotionEvent;
import android.webkit.WebView;

public class Menu {
	public static boolean _alert = false;
	static public int bdel = 4;
	static int width = 0;
	static int height = 0;
	static public Paint paint = new Paint();
	static public int delta = 10;
	static public int tx = 50;
	static public int spd;
	static public double aspectRatio, aspectRatio1;
	static public Bitmap spscreen;
	static public Bitmap sp1;
	static public Bitmap logo;
	static public Bitmap lock;
	static public Bitmap colorpicker;

	static public Random random = new Random();
	static public int bnum = 3;
	static public int al = 0;
	static public String[] s = { "ColorRemedy", "   Play ", "   Help ",
			"  About", " More Games", " Get Top Android Downloads ", "  Rate This" };
	static public Bitmap menub = null;
	static public Bitmap menubp = null;
	static public boolean quit = false;
	public static Bitmap grat;

	static public void menu_draw(Canvas c, Paint p) {
		bnum = 7;
		_alert = alert.flag;
		height = c.getHeight();
		width = c.getWidth();
		bdel = height / 100;
		tx = width / 6;
		p.setFilterBitmap(true);
		Rect dest = new Rect(0, 0, width, (int) (height / Menu.aspectRatio));
		Matrix m = new Matrix();
		m.postRotate(-6);
		m.postTranslate(c.getWidth() * 1 / 13, c.getHeight() * 1 / 12);
		c.drawBitmap(Menu.spscreen, null, dest, p);

		dest = new Rect(Menu.delta, (int) (2.3 * height / 8), width
				- Menu.delta, (int) (height / Menu.aspectRatio1));
		c.drawBitmap(Menu.logo, null, dest, p);
		int tex = width / 8;
		p.setAntiAlias(true);
		p.setTypeface(Typeface.SANS_SERIF);
		p.setTextSize(Menu.tx);
		p.setTextScaleX(0.75f);
		c.drawBitmap(Menu.sp1, m, p);
		c.drawText(Menu.s[0], Menu.tx, Menu.tx * 2, p);
		Menu.spd = (int) (width / 3.5);
		int jum = height / 18 + (height / 20) * 3;
		paintbutton.intiate(bnum);
		int tx = 0;
		int ix = 1900;
		// tx=0;
		if (!_alert) {
			paintbutton.paint_button(c, p, tex, height - jum - jum / 4,
					6 * width / 35, height / 15, s[1], bdel, 1, menub, menubp);
			paintbutton.paint_button(c, p, tex + spd, height - jum - jum / 4,
					6 * width / 35, height / 15, s[2], bdel, 2, menub, menubp);
			paintbutton.paint_button(c, p, tex + spd + spd, height - jum - jum
					/ 4, 6 * width / 35, height / 15, s[3], bdel, 3, menub,
					menubp);
			paintbutton.paint_button(c, p, tx + tex + spd - spd / 1, height
					- jum + jum / 8, 10 * width / 35, height / 15, s[4], bdel,
					4, menub, menubp);
			paintbutton.paint_button(c, p, ix+tex + spd * 3f / 6,(float) (height - jum - jum / 1.6), 19 * width / 38,					height / 15, s[5], bdel, 5, menub, menubp);
			paintbutton.paint_button(c, p, tx + tex + spd + spd *1.4f/ 2,
					(float) (height - jum + jum / 8), 9 * width / 35,
					height / 15, s[6], bdel, 6, menub, menubp);
			paintbutton.paint_button(
					c,
					p,
					c.getWidth() * 8 / 10,
					c.getHeight() * 2.6f / 10, 
					c.getWidth() / 9,
					c.getHeight() / 12,
					s[6],
					bdel,
					7,
					BitmapFactory.decodeResource(
							colourremedy.contex.getResources(), R.drawable.shr),
					BitmapFactory.decodeResource(
							colourremedy.contex.getResources(), R.drawable.shr1));

		} else {
			paintbutton.paint_button(c, p, tex, height - jum - jum / 4,
					6 * width / 35, height / 15, s[1], bdel, 4, menub, menubp);
			paintbutton.paint_button(c, p, tex + spd, height - jum - jum / 4,
					6 * width / 35, height / 15, s[2], bdel, 4, menub, menubp);
			paintbutton.paint_button(c, p, tex + spd + spd, height - jum - jum
					/ 4, 6 * width / 35, height / 15, s[3], bdel, 4, menub,
					menubp);
			paintbutton.paint_button(c, p, tx + tex + spd - spd / 1, height
					- jum + jum / 8, 10 * width / 35, height / 15, s[4], bdel,
					4, menub, menubp);
			paintbutton.paint_button(c, p, ix+tex + spd * 3f / 6,					(float) (height - jum - jum / 1.6), 19 * width / 38,					height / 15, s[5], bdel, 4, menub, menubp);
			paintbutton.paint_button(c, p, tx + tex + spd + spd *1.4F/ 2,
					(float) (height - jum + jum / 8), 9 * width / 35,
					height / 15, s[6], bdel, 4, menub, menubp);
			paintbutton.paint_button(
					c,
					p,
					c.getWidth() * 8 / 10,
					c.getHeight() * 2.6f / 10,
					c.getWidth() / 9,
					c.getHeight() / 12,
					s[6],
					bdel,
					4,
					BitmapFactory.decodeResource(
							colourremedy.contex.getResources(), R.drawable.shr),
					BitmapFactory.decodeResource(
							colourremedy.contex.getResources(), R.drawable.shr1));

		}

		if (_alert) {
			switch (al) {
			case 1:
				alert.help_draw(c, p);
				break;
			case 2:
				alert.about_draw(c, p);
				break;
			case 3:
				alert.exit_draw(c, p);
				break;
			}
		}

		p.setColor(Color.BLACK);
		p.setAntiAlias(true);
		p.setTextSize(height / 15);
		c.drawText("Game Accuracy =" + ViewManager.cal_accu() + "%", width / 2
				- 1 * width / 40, height - height / 20, p);

	}

	public static void openWebURL(String inURL, Context c) {
		Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(inURL));

		c.startActivity(browse);
	}

	public static void share(String siteb) {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_TITLE,
				"ColorRemedy A game to test your color perception");

		intent.putExtra(
				Intent.EXTRA_TEXT,
				"Download ColorRemedy from android market : https://market.android.com/details?id=inductiongames.colorblind");
		colourremedy.contex.startActivity(Intent.createChooser(intent,
				"Help us by Sharing"));
	}

	static public void touch(final MotionEvent event) {
		ViewManager.onb = 0;
		int i = 0;
		if (!_alert) {
			while (i < bnum) {
				if (event.getX() > paintbutton.buttonarrayleftx[i]
						&& event.getX() < paintbutton.buttonarrayrightx[i]
						&& event.getY() > paintbutton.buttonarraylefty[i]
						&& event.getY() < paintbutton.buttonarrayrighty[i]) {
					ViewManager.onb = i + 1;
					if (event.getAction() == MotionEvent.ACTION_UP) {
						ViewManager.onb = 0;
						switch (i + 1) {
						case 1:
							ViewManager.viewchanger(1);
							break;
						case 2:
							alert.flag = true;
							al = 1;
							break;
						case 3:
							alert.flag = true;
							al = 2;
							break;
						case 4:
							openWebURL(
									"market://search?q=pub:\"Induction Labs\"",
									colourremedy.contex);
							break;
						case 5:
							int sc = 0;
							int k = 0;
							while (k < ViewManager.savedstate.per.length) {
								sc += ViewManager.savedstate.per[k];
								k++;
							}
							;
							 
							ViewManager.leadbot=1;
							colourremedy.showleadbot();
					   	
							break;
						case 6:
							openWebURL(
									"market://details?id=inductiongames.colorblind",
									colourremedy.contex);
							break;
						case 7:
							share("");
							break;

						}
					}
				}
				i++; 
			}
			;
		} else {
			while (i < alert.bnum) {
				if (event.getX() > paintbutton.buttonarrayleftx[i]
						&& event.getX() < paintbutton.buttonarrayrightx[i]
						&& event.getY() > paintbutton.buttonarraylefty[i]
						&& event.getY() < paintbutton.buttonarrayrighty[i]) {
					ViewManager.onb = i + 1;
					if (event.getAction() == MotionEvent.ACTION_UP) {
						ViewManager.onb = 0;
						switch (i + 1) {
						case 1:
							alert.flag = false;
							break;
						case 2:
							if (al == 3)
								quit = true;
							break;
							
						}
					}
				}
				i++;
			}
			;
		}
	}

}

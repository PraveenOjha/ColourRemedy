package inductiongames.colourblind;

import inductiongames.colorblind.R;
import inductiongames.colorblind.R.raw;

import java.io.FileNotFoundException;
import java.io.InputStream;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

public class episelector {
	public static boolean dataloaded = false;
	public static int bnum = 3;
	public static int width;
	public static int height;
	public static int tx;
	public static int tex;
	public static int scrolx = 0;
	public static int sfx = 0;
	public static int scroly = 0;
	public static int delx = 0;
	public static int dely = 0;
	public static int l = 0;
	public static Data dat;
	public static int episode = 1;
	public static int bdel;
	public static Bitmap ep2 = null;
	public static Bitmap ep1 = null;
	public static boolean scrol = false;
	static public Bitmap spscreen;
	static public boolean no_up = true;
	static public String[] s = { "                 RainBow",
			"                 Natural", "                Synthetic",
			"                  Random" };

	static public void episelector_draw(Canvas c, Paint p) {
		if (!dataloaded) {
			loaddata();
			dataloaded = true;
		}

		Rect dest = new Rect(0, 0, width, (int) (height / Menu.aspectRatio));
		c.drawBitmap(Menu.spscreen, null, dest, p);
		bnum = 5;
		paintbutton.intiate(bnum + 1);
		height = c.getHeight();
		width = c.getWidth();
		p.setFilterBitmap(true);
		tx = width / 6;
		tex = width / 15;
		bdel = height / 100;
		sfx = 200;
		int z = height / 10;
		if (scrol) {
			scrolx += delx;
			scroly += dely;
		}
		Menu.spd = (int) (width / 3.5);
		p.setColor(Color.BLACK);
		p.setAntiAlias(true);
		p.setTextSize(height / 10);
		c.drawText("Select Stage", width / 2 - 7 * width / 40, z + height / 10,
				p);

		// int jum=height/20+(height/20)*3;
		paintbutton.paint_button(c, p, tex + scrolx, z + height / 8 + scroly,
				width - tex * 2, height / 10, s[0], bdel, 1, ep1, ep2);
		paintbutton.paint_button(c, p, tex + scrolx, (float) (z + 2.2f * height
				/ 8 + scroly), width - tex * 2, height / 10, s[1], bdel, 2,
				ep1, ep2);
		paintbutton
				.paint_button(c, p, tex + scrolx, z + 3.5f * height / 8
						+ scroly, width - tex * 2, height / 10, s[2], bdel, 3,
						ep1, ep2);
		paintbutton
				.paint_button(c, p, tex + scrolx, z + 4.8f * height / 8
						+ scroly, width - tex * 2, height / 10, s[3], bdel, 4,
						ep1, ep2);
		paintbutton.paint_button(c, p, c.getWidth() * 8.4f / 10,
				c.getHeight() * 8.3f / 10, c.getWidth() / 9,
				c.getHeight() / 12, "", bdel, 5, BitmapFactory.decodeResource(
						colourremedy.contex.getResources(), R.drawable.shr1),
				BitmapFactory.decodeResource(colourremedy.contex.getResources(),
						R.drawable.shr));
		paintbutton.paint_button(c, p, (float) 1.2 * width / 10,
				13 * height / 15, width / 5, (float) 1.5 * height / 20,
				"  Back", bdel, bnum + 1, ep1, ep2);

	}

	static public void loaddata() {
		try {
			InputStream f = inductiongames.colourblind.colourremedy.contex
					.getResources().openRawResource(raw.stages);
			dat = mapparser.importObj(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static public void scrol_X(MotionEvent event) {
		int j = width / 10;
		if ((event.getX() > l - j || event.getX() < l + j) && no_up) {
			scrol = true;
			if (event.getX() > l) {
				delx = width / 20;
			} else {
				delx = -width / 20;
			}

		} else {
			scrol = false;
		}
		l = (int) event.getX();
		no_up = true;
		if (event.getAction() == MotionEvent.ACTION_UP) {

			scrolx = 0;
			no_up = false;
			delx = 0;
		}

	}

	static public void scrol_Y(MotionEvent event) {
		int j = width / 10;
		float Y = event.getY();

		if ((Y > l - j && Y < l + j) && no_up) {
			scrol = true;
			if (Y > l) {
				dely = height / 20;
			} else {
				dely = -height / 20;
			}

		} else {
			scrol = false;
		}
		l = (int) Y;
		no_up = true;
		if (scroly > height / 30)
			scroly = 0;
		if (scroly < -2 * height / 3 - height / 3)
			scroly = -2 * height / 3 - height / 3;
		if (event.getAction() == MotionEvent.ACTION_UP) {
			if (scroly > 10)
				scroly = 0;
			if (scroly < -2 * height / 3 - height / 5)
				scroly = -2 * height / 3 - height / 5;
			no_up = false;
			dely = 0;
		}

	}

	static public void touch(final MotionEvent event) {

		ViewManager.onb = 0;
		int i = 0;
		while (i < bnum - 1) {

			if (!scrol && event.getX() > paintbutton.buttonarrayleftx[i]
					&& event.getX() < paintbutton.buttonarrayrightx[i]
					&& event.getY() > paintbutton.buttonarraylefty[i]
					&& event.getY() < paintbutton.buttonarrayrighty[i]) {
				ViewManager.onb = i + 1;
				if (event.getAction() == MotionEvent.ACTION_UP) {
					if (i + 1 != 5) {
						ViewManager.onb = 0;
						alert.flag = false;
						episode = i + 1;
						ViewManager.viewchanger(4);
					} else {
						ViewManager.viewchanger(4);
					}
				}
			}

			i++;
		}
		;

		if (!scrol && event.getX() > paintbutton.buttonarrayleftx[i]
				&& event.getX() < paintbutton.buttonarrayrightx[i]
				&& event.getY() > paintbutton.buttonarraylefty[i]
				&& event.getY() < paintbutton.buttonarrayrighty[i]) {
			ViewManager.onb = i + 1;
			if (event.getAction() == MotionEvent.ACTION_UP) {
				ViewManager.onb = 0;
				Menu.share("");
			}
		}
		i++;

		if (!scrol && event.getX() > paintbutton.buttonarrayleftx[i]
				&& event.getX() < paintbutton.buttonarrayrightx[i]
				&& event.getY() > paintbutton.buttonarraylefty[i]
				&& event.getY() < paintbutton.buttonarrayrighty[i]) {
			ViewManager.onb = i + 1;
			if (event.getAction() == MotionEvent.ACTION_UP) {
				ViewManager.onb = 0;
				ViewManager.viewchanger(0);
			}
		}

		// scrol_Y(event);
	}

}

package inductiongames.colourblind;

import inductiongames.colorblind.R;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.MotionEvent;

public class showcolor {
	public static int bnum = 2;
	public static int width;
	public static int height;
	public static int tx;
	public static int tex;
	public static int bdel = 4;
	public static Bitmap ep2 = null;
	public static Bitmap ep1 = null;
	static public Bitmap spscreen;
	static public String[] s = { "Back", "Done" };
	static public int gr = 192;
	static public int re = 192;
	static public int bl = 192;

	static public void stage_draw(Canvas c, Paint p) {
		bnum = 2;
		paintbutton.intiate(bnum);
		p.setFilterBitmap(true);
		Rect dest = new Rect(0, 0, width, (int) (height / Menu.aspectRatio));
		c.drawBitmap(Menu.spscreen, null, dest, p);
		height = c.getHeight();
		width = c.getWidth();

		tx = width / 6;
		tex = width / 10;
		bdel = height / 100;
		RectF b1 = new RectF(width / 9, 2 * height / 10, width - width / 9,
				height - 4 * height / 10);
		p.setColor(Color.argb(255, re, gr, bl));
		c.drawRoundRect(b1, width / 20, width / 20, p);
		p.setTextScaleX(.4f);
		p.setTextSize(height / 12);
		p.setTypeface(Typeface.SANS_SERIF);
		p.setColor(Color.DKGRAY);
		c.drawText("     Memorise the color .....", (float) (1.5 * width / 9),
				(float) 1.8 * (height / 10), p);
		spscreen = BitmapFactory.decodeResource(
				inductiongames.colourblind.colourremedy.contex.getResources(),
				R.drawable.icon);
		Rect dest1 = new Rect(width / 5, 7 * height / 10, width - width / 5,
				height - height / 10);
		c.drawBitmap(spscreen, null, dest1, p);
		paintbutton.paint_button(c, p, (float) 1.2 * width / 10,
				13 * height / 15, width / 5, (float) 1.5 * height / 20, s[0],
				bdel, 1, ep1, ep2);
		paintbutton.paint_button(c, p, (float) 7 * width / 10,
				13 * height / 15, width / 5, (float) 1.5 * height / 20, s[1],
				bdel, 2, ep1, ep2);

	}

	static public void touch(final MotionEvent event) {
		ViewManager.onb = 0;
		int i = 0;
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
						ViewManager.viewid = 5;
						break;
					case 2:
						game.red = re;
						game.green = gr;
						game.blue = bl;
						game.set_slider(192, 192, 192, width);

						ViewManager.viewchanger(3);
						break;
					}

				}
			}

			i++;
		}
		;

	}

	public static void init() {

		re = ViewManager.levlholders.r;
		gr = ViewManager.levlholders.g;
		bl = ViewManager.levlholders.b;
	}
}

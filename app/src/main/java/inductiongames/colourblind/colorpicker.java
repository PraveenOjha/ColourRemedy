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

public class colorpicker {
	public static int bnum = 3;
	public static int width;
	public static int height;
	public static int tx;
	public static int tex;
	public static int bdel = 4;
	public static Bitmap ep2 = null;
	public static Bitmap ep1 = null;
	static public Bitmap spscreen;
	static public Bitmap temp = null;
	static public String[] s = { "   Back", "  Done", "RandomColor", };
	static public int gr = 192;
	static public int re = 192;
	static public int bl = 192;
	static public int x = 0;
	static public int y = 0;
	static public int cx = 0;
	static public int cy = 0;
	static public float sx = 1;
	static public float sy = 1;
	private static RectF bz;

	static public void stage_draw(Canvas c, Paint p) {

		bnum = 3;
		paintbutton.intiate(bnum);
		p.setFilterBitmap(true);
		Rect dest = new Rect(0, 0, width, (int) (height / Menu.aspectRatio));

		c.drawBitmap(Menu.spscreen, null, dest, p);
		height = c.getHeight();
		width = c.getWidth();

		tx = width / 6;
		tex = width / 10;
		bdel = height / 100;
		RectF b1 = new RectF(width / 9, 2 * height / 10, width - width / 5,
				height - 4 * height / 10);
		p.setColor(Color.argb(255, re, gr, bl));
		c.drawRoundRect(b1, width / 20, width / 20, p);
		p.setTextScaleX(.4f);
		p.setTextSize(height / 12);
		p.setTypeface(Typeface.SANS_SERIF);
		p.setColor(Color.DKGRAY);
		c.drawText("   Memorise the color .....", (float) (1.5 * width / 9),
				(float) 1.8 * (height / 10), p);
		spscreen = BitmapFactory.decodeResource(
				inductiongames.colourblind.colourremedy.contex.getResources(),
				R.drawable.icon);
		Rect dest1 = new Rect(width / 5, 7 * height / 10, width - width / 5,
				(int) (height - height / 8.2f));
		c.drawBitmap(spscreen, null, dest1, p);
		paintbutton.paint_button(c, p, (float) 1.1f * width / 10,
				13 * height / 15, width / 5, (float) 1.5 * height / 20, s[0],
				bdel, 1, ep1, ep2);
		paintbutton.paint_button(c, p, (float) 7.2f * width / 10,
				13 * height / 15, width / 5, (float) 1.5 * height / 20, s[1],
				bdel, 2, ep1, ep2);
		paintbutton.paint_button(c, p, (float) 3.5f * width / 10,
				13f * height / 15, width / 3.2f, (float) 1.5 * height / 20,
				s[2], bdel, 3, ep1, ep2);

		// RectF bj =new
		// RectF(width-width/6,height/6,width-width/6+width/8,height/6+height/1.5f);
		// c.drawBitmap(Menu.colorpicker, null, bj, p);
		// Matrix m=new Matrix();
		// m.postScale(sx, sy);
		// m.postTranslate(cx, cy);
		// c.drawBitmap(Menu.colorpicker, m, p);
		bz = new RectF(width - width / 6, 2 * height / 10,
				width - width / 8.5f, height - 4 * height / 10);
		c.drawBitmap(Menu.colorpicker, null, bz, p);
		sx = temp.getWidth() / bz.width();
		sy = temp.getHeight() / bz.height();
		cx = (int) bz.left;
		cy = (int) bz.top;
		float rad = width / 50;
		p.setColor(Color.BLACK);
		RectF te = new RectF(cx - rad + x, cy - rad + y, cx + rad + x, cy + rad
				+ y);
		c.drawArc(te, 0, 360, true, p);
		p.setColor(Color.WHITE);
		rad = width / 54;
		te = new RectF(cx - rad + x, cy - rad + y, cx + rad + x, cy + rad + y);
		c.drawArc(te, 0, 360, true, p);
		p.setColor(Color.BLACK);
		rad = width / 55;
		te = new RectF(cx - rad + x, cy - rad + y, cx + rad + x, cy + rad + y);
		c.drawArc(te, 0, 360, true, p);

	}

	static public void touch(final MotionEvent event) {
		if (bnum != 3)
			return;
		ViewManager.onb = 0;
		int i = 0;
		while (i < bnum) {
			if (event.getX() > bz.left && event.getX() < bz.right
					&& event.getY() > bz.top && event.getY() < bz.bottom) {
				x = (int) (event.getX() - bz.left);
				y = (int) (event.getY() - bz.top);
				int col = temp.getPixel((int) (x * sx) % temp.getWidth(),
						(int) (y * sy) % temp.getHeight());
				gr = Color.green(col);
				re = Color.red(col);
				;
				bl = Color.blue(col);
				;

			}

			if (event.getX() > paintbutton.buttonarrayleftx[i]
					&& event.getX() < paintbutton.buttonarrayrightx[i]
					&& event.getY() > paintbutton.buttonarraylefty[i]
					&& event.getY() < paintbutton.buttonarrayrighty[i]) {
				ViewManager.onb = i + 1;
				if (ViewManager.onb == 3)
					randomise();
				if (event.getAction() == MotionEvent.ACTION_UP) {
					ViewManager.onb = 0;
					game.hint_used = false;
					switch (i + 1) {
					case 1:
						ViewManager.viewchanger(1);
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

	private static void randomise() {
		int n = 240;
		re = ViewManager.r.nextInt(n) + 10;
		gr = ViewManager.r.nextInt(n) + 10;
		bl = ViewManager.r.nextInt(n) + 10;
		// TODO Auto-generated method stub

	}

	public static void init() {

		re = ViewManager.levlholders.r;
		gr = ViewManager.levlholders.g;
		bl = ViewManager.levlholders.b;
	}

}

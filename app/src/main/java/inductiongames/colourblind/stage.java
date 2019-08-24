package inductiongames.colourblind;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

public class stage {
	public static int bnum = 28;
	public static float[] per;
	public static int unlocked = 0;
	public static int rd = 192;
	public static int bl = 192;
	public static int gr = 192;
	public static int bdel = 4;
	public static int epiindex = 0;
	public static int epist = 0;
	public static Datastore tdata = null;
	public static int buttonrealindex = 0;
	public static Bitmap ep2 = null;
	public static Bitmap ep1 = null;
	static public Bitmap spscreen;
	static public boolean no_up = true;
	static public int episode = 0;
	static public int sn = 10;
	static public int[] lock;
	static int dificul = 2;
	static public int curstage = 0;
	private static int maxstage;

	static public void stage_draw(Canvas c, Paint p) {
		episode = episelector.episode - 1;
		if (episode == 3) {
			colorpicker.stage_draw(c, p);
		}

		else {
			sn = 16;

			maxstage = ViewManager.numberofstage;
			bnum = sn;
			game.hint_used = false;
			curstage = 0;
			Rect dest = new Rect(0, 0, c.getWidth(), c.getHeight());
			c.drawBitmap(Menu.spscreen, null, dest, p);
			lock = new int[84];
			if (ViewManager.savedstate != null) {
				lock = ViewManager.savedstate.unlocked;

			} else {
				dificul = 1;
				int locker = 1;
				while (locker < 84) {
					lock[locker++] = 0;
				}
				lock[0] = 1;
				lock[16] = 1;
				lock[32] = 1;
			}

			sppaintbutton.intiate(bnum + 1);
			p.setFilterBitmap(true);
			int i = 0, k = 1, j = 0;
			int Bx = c.getWidth() / 10;
			int By = c.getHeight() / 6;
			int h = c.getHeight() / 6;
			int w = 4 * c.getWidth() / 10;
			int d = c.getHeight() / 20;
			while (i < sn) {
				i++;
				Matrix m = new Matrix();
				m.postTranslate(Bx + w * (k - 1) / 2.5f,
						(float) (By + (h / 1.3) * j));
				m.postScale(1.2f, 1.2f);
				if (lock[(i + sn * episode) - 1] == 2) {
					c.drawBitmap(ViewManager.eassel, m, p);
					p.setColor(Color.BLACK);

					p.setTextSize(c.getHeight() / 20);
					float ax = c.getWidth() / 30;
					float ay = 2 * c.getHeight() / 25;

					c.drawText(
							""
									+ ViewManager.savedstate.per[(i + sn
											* episode) - 1] + "%", 1.2f
									* (Bx + w * (k - 1) / 2.5f) + ax,
							(float) (1.2f * (By + (h / 1.3) * j)) + 1.3f * ay,
							p);
				} else if (lock[(i + sn * episode) - 1] == 1)
					c.drawBitmap(ViewManager.nonsol, m, p);

				float a1 = 1.2f * (Bx + w * (k - 1) / 2.5f);
				float b1 = (float) (1.2f * (By + (h / 1.3) * j));
				float c1 = 1.2f * ViewManager.eassel.getWidth();
				float d1 = 1.2f * ViewManager.eassel.getHeight();
				sppaintbutton.paint_button(c, p, a1, b1, c1, d1, ""
						+ (i + sn * episode), d, i, ep1, ep2, lock[(i + sn
						* episode) - 1]);
				p.setAntiAlias(true);
				if (k > 3) {
					j++;
					k = 0;
				}
				k++;
			}

			sppaintbutton.paint_button(c, p, Bx * 8.3f, By * 5 + d / 2, Bx, h,
					"", d, i + 1, ViewManager.bk, ViewManager.nx, 2);
		}

	}

	static public void stage_initiate(int e) {
		episode = e;
	}

	static public void touch(final MotionEvent event)

	{
		if (episode == 3) {
			colorpicker.touch(event);
		} else {

			int sn = 16;

			ViewManager.onb = 0;
			int i = 0;
			while (i < bnum) {
				if (event.getX() > sppaintbutton.buttonarrayleftx[i]
						&& event.getX() < sppaintbutton.buttonarrayrightx[i]
						&& event.getY() > sppaintbutton.buttonarraylefty[i]
						&& event.getY() < sppaintbutton.buttonarrayrighty[i]) {
					ViewManager.onb = i + 1;
					if (event.getAction() == MotionEvent.ACTION_UP) {
						ViewManager.onb = 0;
						if (lock[(i + sn * episode)] > 0) {
							curstage = (i + sn * episode);
							ViewManager.levlholders = levelloader
									.level_loader(curstage);
							showcolor.init();
							ViewManager.viewchanger(2);
						}
					}
				}
				i++;
			}
			;

			if (event.getX() > sppaintbutton.buttonarrayleftx[i]
					&& event.getX() < sppaintbutton.buttonarrayrightx[i]
					&& event.getY() > sppaintbutton.buttonarraylefty[i]
					&& event.getY() < sppaintbutton.buttonarrayrighty[i]) {
				ViewManager.onb = i + 1;
				if (event.getAction() == MotionEvent.ACTION_UP) {
					ViewManager.onb = 0;
					ViewManager.viewchanger(1);
				}
			}

		}
	}

	public static void unlocker() {
		Datastore temp;
		if (ViewManager.savedstate == null)
			temp = new Datastore();
		else
			temp = ViewManager.savedstate;
		if (game.accu > temp.per[curstage]) {
			temp.per[curstage] = (int) game.accu;
			ViewManager.savedstate.per[curstage] = (int) game.accu;
		}

		if (temp.unlocked[curstage] == 1) {
			temp.unlocked[curstage] = 2;
			temp.num_un++;

		}
		int k = 0;
		float s = 0;
		while (k < 45) {
			s += temp.per[k];
			k++;
		}
		if (temp.num_un != 0)
			temp.gameper = (float) (s / temp.num_un);

		if (curstage + 1 < maxstage) {
			if (temp.unlocked[curstage + 1] != 2)
				temp.unlocked[curstage + 1] = 1;

		}

		ViewManager.savedstate = temp;
		Datastore.save(Datastore.FILENAME, ViewManager.savedstate,
				colourremedy.contex);

	}

}

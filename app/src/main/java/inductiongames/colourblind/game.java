package inductiongames.colourblind;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.MotionEvent;

public class game {
	public static boolean _alert = false;
	public static int bnum = 5;
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
	public static int sliderred = 12;
	public static int sliderblue = 12;
	public static int slidergreen = 12;
	public static int rd = 12;
	public static int bl = 12;
	public static int gr = 12;
	public static int cby = 230;
	public static int bw = 20;
	public static int bh = 20;
	public static int bdel = 4;
	public static float accu = 0;
	public static Bitmap ep2 = null;
	public static Bitmap ep1 = null;
	public static boolean scrol = false;
	static public Bitmap spscreen;
	static public boolean no_up = true;
	static public String[] s = { "  Recall", "GetGreen", "GetBlue", "Get Red",
			"  Done" };
	public static boolean hint_used = false;
	public static int al = 0;
	public static int green = 23;
	public static int red = 23;
	public static int blue = 23;

	static public void stage_draw(Canvas c, Paint p) {
		int z = (int) (3.5 * height / 20);
		_alert = alert.flag;
		bnum = 5;
		Rect dest = new Rect(0, 0, width, (int) (height / Menu.aspectRatio));
		c.drawBitmap(Menu.spscreen, null, dest, p);
		paintbutton.intiate(bnum + 3);
		height = c.getHeight();
		width = c.getWidth();
		p.setFilterBitmap(true);
		tx = width / 6;
		tex = width / 10;
		bdel = height / 100;
		sfx = 200;
		RectF b1 = new RectF(tx / 5, tx / 5 + z / 2, width - tx, height / 2
				+ tx / 2);
		get_canvascolor();
		p.setColor(Color.argb(255, rd, gr, bl));
		c.drawRoundRect(b1, width / 40, width / 40, p);
		p.setTextSize(height / 20);
		/*
		 * if(hint_used) {p.setColor(Color.BLUE);
		 * c.drawText("Hint Used",(float)(width-1.2*tx) ,tx/6+z-width/10 , p); }
		 * else {p.setColor(Color.CYAN);
		 * c.drawText("Hint Available",(float)(width-1.2*tx) ,tx/6+z-width/10 ,
		 * p);
		 * 
		 * }
		 */
		p.setColor(Color.GRAY);
		if (!_alert) {
			paintbutton.paint_button(c, p, (float) (width - 1.5 * tx), tx / 6
					+ z, width / 5, width / 10, s[0], bdel, 1, ep1, ep2);
			paintbutton.paint_button(c, p, (float) (width - 1.5 * tx), tx / 6
					+ width / 8 + z, width / 5, width / 10, s[1], bdel, 2, ep1,
					ep2);
			paintbutton.paint_button(c, p, (float) (width - 1.5 * tx), tx / 6
					+ 2 * width / 8 + z, width / 5, width / 10, s[2], bdel, 3,
					ep1, ep2);
			paintbutton.paint_button(c, p, (float) (width - 1.5 * tx), tx / 6
					+ 3 * width / 8 + z, width / 5, width / 10, s[3], bdel, 4,
					ep1, ep2);
			// paintbutton.paint_button( c, p,(float)
			// (width-1.5*tx),tx/6+4*width/8+z,width/5,width/10,s[4],bdel,5,ep1,ep2);
			paintbutton.paint_button(c, p, (float) (width / 2 - .5 * tx),
					height - 3 * height / 20, width / 5, width / 8, s[4], bdel,
					5, ep1, ep2);
		} else {
			paintbutton.paint_button(c, p, (float) (width - 1.5 * tx), tx / 6
					+ z, width / 5, width / 10, s[0], bdel, 4, ep1, ep2);
			paintbutton.paint_button(c, p, (float) (width - 1.5 * tx), tx / 6
					+ width / 8 + z, width / 5, width / 10, s[1], bdel, 4, ep1,
					ep2);
			paintbutton.paint_button(c, p, (float) (width - 1.5 * tx), tx / 6
					+ 2 * width / 8 + z, width / 5, width / 10, s[2], bdel, 4,
					ep1, ep2);
			paintbutton.paint_button(c, p, (float) (width - 1.5 * tx), tx / 6
					+ 3 * width / 8 + z, width / 5, width / 10, s[3], bdel, 4,
					ep1, ep2);
			// paintbutton.paint_button( c, p,(float)
			// (width-1.5*tx),tx/6+4*width/8+z,width/5,width/10,s[4],bdel,4,ep1,ep2);
			paintbutton.paint_button(c, p, (float) (width / 2 - .5 * tx),
					height - 3 * height / 20, width / 5, width / 8, s[4], bdel,
					4, ep1, ep2);

		}
		cby = height * 12 / 20;
		bw = width / 10;
		bh = height / 20;
		cby -= bh / 2;
		p.setColor(Color.RED);
		b1 = new RectF(10, cby + bh / 2 - bh / 5, width - 10, cby + bh / 2 + bh
				/ 5);
		c.drawRoundRect(b1, 10, cby + bh / 2 - bh / 5, p);
		p.setColor(Color.BLUE);
		b1 = new RectF(10, cby + bh / 2 - bh / 5 + bh + bh, width - 10, cby
				+ bh / 2 + bh / 5 + bh + bh);
		c.drawRoundRect(b1, 10, cby + bh / 2 - bh / 5 + bh + bh, p);
		p.setColor(Color.GREEN);
		b1 = new RectF(10, cby + bh / 2 - bh / 5 + bh + 3 * bh, width - 10, cby
				+ bh / 2 + bh / 5 + bh + 3 * bh);
		c.drawRoundRect(b1, 10, cby + bh / 2 - bh / 5 + bh + 3 * bh, p);

		p.setColor(Color.RED);
		paintbutton.paint_button(c, p, sliderred, cby, bw, bh, " R", bdel, 6,
				ep1, ep2);

		p.setColor(Color.BLUE);
		paintbutton.paint_button(c, p, sliderblue, cby + bh + bh, bw, bh, " B",
				bdel, 7, ep1, ep2);

		p.setColor(Color.GREEN);
		paintbutton.paint_button(c, p, slidergreen, cby + bh + 3 * bh, bw, bh,
				" G", bdel, 8, ep1, ep2);

		p.setAntiAlias(true);
		p.setTypeface(Typeface.SANS_SERIF);
		p.setTextSize(tx);
		if (_alert) {
			if (al == 1)
				alert.Recall(c, p);
			else
				alert.ale_draw(c, p);
		}

	}

	private static void get_canvascolor() {
		rd = (int) (((float) (sliderred + bw / 2) / width) * 255);
		bl = (int) (((float) (sliderblue + bw / 2) / width) * 255);
		gr = (int) (((float) (slidergreen + bw / 2) / width) * 255);

	}

	static void set_slider(int r, int g, int b, int w) {
		sliderred = (int) (((float) r / 255) * w - bw / 2);
		sliderblue = (int) (((float) b / 255) * w - bw / 2);
		slidergreen = (int) (((float) g / 255) * w - bw / 2);

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
		if ((event.getY() > l - j && event.getY() < l + j) && no_up) {
			scrol = true;
			if (event.getY() > l) {
				dely = height / 20;
			} else {
				dely = -height / 20;
			}

		} else {
			scrol = false;
		}
		l = (int) event.getY();
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
	
	
	public static void share(float a,float b) {
		Intent intent = new Intent(Intent.ACTION_SEND);
		String x="I had passed ColorRemedie's stage "+ a + " with a accuracy of " + b+ "%"; 
		if(a>1||b>70||a>45)
		{x="I played ColorRemedie ,A must try.Play It.";
			
		}
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_TITLE,
				"ColorBlind A game to test your color perception");

		intent.putExtra(
				Intent.EXTRA_TEXT,
				x+"Download ColorRemedy from android market : https://market.android.com/details?id=inductiongames.colorblind");
		
		colourremedy.contex.startActivity(Intent.createChooser(intent,x));
	}

	static public void touch(final MotionEvent event) {
		// scrol_Y(event);
		ViewManager.onb = 0;
		int i = 0;
		if (_alert == false) {
			while (i < bnum) {

				if (!scrol && event.getX() > paintbutton.buttonarrayleftx[i]
						&& event.getX() < paintbutton.buttonarrayrightx[i]
						&& event.getY() > paintbutton.buttonarraylefty[i]
						&& event.getY() < paintbutton.buttonarrayrighty[i]) {
					if (hint_used) {
						if (i + 1 == 5)
							ViewManager.onb = i + 1;
					} else
						ViewManager.onb = i + 1;
					if (event.getAction() == MotionEvent.ACTION_UP) {
						ViewManager.onb = 0;
						switch (i + 1) {
						case 1:
							if (!hint_used) {
								al = 1;
								alert.flag = true;
								hint_used = true;
							}
							break;
						case 2:
							if (!hint_used)
								set_slider(rd, green, bl, width);
							hint_used = true;
							break;
						case 3:
							if (!hint_used)
								set_slider(rd, gr, blue, width);
							hint_used = true;
							break;
						case 4:
							if (!hint_used)
								set_slider(red, gr, bl, width);
							hint_used = true;
							break;
						case 5:
							al = 0;
							alert.flag = true;
						}

					}
				}

				i++;
			}
			;

			if (!scrol
					&& event.getX() > paintbutton.buttonarrayleftx[i] - width
							/ 10
					&& event.getX() < paintbutton.buttonarrayrightx[i] + width
							/ 10
					&& event.getY() > paintbutton.buttonarraylefty[i] - height
							/ 35
					&& event.getY() < paintbutton.buttonarrayrighty[i] + height
							/ 35) {
				ViewManager.onb = i + 1;
				sliderred = (int) (event.getX() - (paintbutton.buttonarrayrightx[i] - paintbutton.buttonarrayleftx[i]) / 2);
				if (event.getAction() == MotionEvent.ACTION_UP) {
					ViewManager.onb = -1;
				}

			}
			i++;
			if (!scrol
					&& event.getX() > paintbutton.buttonarrayleftx[i] - width
							/ 10
					&& event.getX() < paintbutton.buttonarrayrightx[i] + width
							/ 10
					&& event.getY() > paintbutton.buttonarraylefty[i] - height
							/ 35
					&& event.getY() < paintbutton.buttonarrayrighty[i] + height
							/ 35) {
				ViewManager.onb = i + 1;
				sliderblue = (int) (event.getX() - (paintbutton.buttonarrayrightx[i] - paintbutton.buttonarrayleftx[i]) / 2);
				if (event.getAction() == MotionEvent.ACTION_UP) {
					ViewManager.onb = -1;
				}

			}
			i++;
			if (!scrol
					&& event.getX() > paintbutton.buttonarrayleftx[i] - width
							/ 10
					&& event.getX() < paintbutton.buttonarrayrightx[i] + width
							/ 10
					&& event.getY() > paintbutton.buttonarraylefty[i] - height
							/ 35
					&& event.getY() < paintbutton.buttonarrayrighty[i] + height
							/ 35) {
				ViewManager.onb = i + 1;
				slidergreen = (int) (event.getX() - (paintbutton.buttonarrayrightx[i] - paintbutton.buttonarrayleftx[i]) / 2);
				if (event.getAction() == MotionEvent.ACTION_UP) {
					ViewManager.onb = -1;
				}
			}
		} else {
			while (i < alert.bnum) {

				if (!scrol && event.getX() > paintbutton.buttonarrayleftx[i]
						&& event.getX() < paintbutton.buttonarrayrightx[i]
						&& event.getY() > paintbutton.buttonarraylefty[i]
						&& event.getY() < paintbutton.buttonarrayrighty[i]) {
					ViewManager.onb = i + 1;
					if (event.getAction() == MotionEvent.ACTION_UP) {
						ViewManager.onb = 0;
						switch (i + 1) {
						case 2:
							alert.flag = false;
							if (al == 1) {
								al = 0;
							} else {
								if (episelector.episode != 4)
									stage.unlocker();
								ViewManager.viewchanger(4);
							}
							break;
						case 1:
							alert.flag = false;break;
						case 3: share(stage.curstage,game.accu);
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

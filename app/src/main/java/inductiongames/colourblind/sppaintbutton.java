package inductiongames.colourblind;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;

public class sppaintbutton {
	static float[] buttonarrayleftx;
	static float[] buttonarraylefty;
	static float[] buttonarrayrightx;
	static float[] buttonarrayrighty;
	static float[] lockstate;

	public static void paint_button(Canvas c, Paint p, float Bx, float By,
			float w, float h, String Bt, int delta, int index, Bitmap bt,
			Bitmap bt1, int j) {
		w = w + Bx;
		h = h + By;
		buttonarrayleftx[index - 1] = Bx;
		buttonarraylefty[index - 1] = By;
		buttonarrayrightx[index - 1] = w;
		buttonarrayrighty[index - 1] = h;
		lockstate[index - 1] = j;
		RectF b0 = new RectF(Bx, By, w, h);
		if (bt == null && bt1 == null) {

			p.setAntiAlias(true);
			p.setTypeface(Typeface.SANS_SERIF);
			p.setTypeface(Typeface.DEFAULT_BOLD);

			if (j > 0) {
				p.setTextSize(0.8f * (h - By));
				if (ViewManager.onb == index) {
					hov();
					p.setColor(Color.BLACK);
					c.drawText(Bt, Bx + delta / (3 * Bt.length()), h - delta
							/ 2, p);

				} else {
					p.setColor(Color.WHITE);
					c.drawText(Bt, Bx + delta / (3 * Bt.length()), h - delta
							/ 2, p);

				}
			}
		} else {

			Matrix matrix = new Matrix();
			if (ViewManager.onb == index) {
				hov();
				matrix.postScale(0.5f, 0.5f);
				matrix.postTranslate(b0.right - (bt.getWidth() * 0.5f), b0.top
						+ c.getHeight() / 55);
				c.drawBitmap(bt, matrix, p);
			} else {
				matrix.postScale(0.6f, 0.6f);
				matrix.postTranslate(b0.right - (bt1.getWidth() * 0.6f), b0.top);
				c.drawBitmap(bt1, matrix, p);
			}
		}

	}

	public static void hov() {
		// ViewManager.soundbc=true;

	}

	public static void intiate(int bnum) {
		buttonarrayleftx = new float[bnum];
		buttonarraylefty = new float[bnum];
		buttonarrayrightx = new float[bnum];
		buttonarrayrighty = new float[bnum];
		lockstate = new float[bnum];
	}
}

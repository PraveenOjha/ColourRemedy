package inductiongames.colourblind;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;

public class paintbutton {
	static float[] buttonarrayleftx;
	static float[] buttonarraylefty;
	static float[] buttonarrayrightx;
	static float[] buttonarrayrighty;

	public static void paint_button(Canvas c, Paint p, float Bx, float By,
			float w, float h, String Bt, int delta, int index, Bitmap bt,
			Bitmap bt1) {
		w = w + Bx;
		h = h + By;
		buttonarrayleftx[index - 1] = Bx;
		buttonarraylefty[index - 1] = By;
		buttonarrayrightx[index - 1] = w;
		buttonarrayrighty[index - 1] = h;
		RectF b0 = new RectF(Bx, By, w, h);
		int clor = p.getColor();
		if (bt == null && bt1 == null) {
			RectF b1 = new RectF(Bx + delta / 2, By + delta / 2, w - delta / 2,
					h - delta / 2);
			RectF b2 = new RectF(Bx + delta, By + delta, w - delta, h - delta);
			p.setAntiAlias(true);
			p.setTypeface(Typeface.SANS_SERIF);
			p.setTextSize(h - By - delta);
			if (ViewManager.onb == index) {
				p.setColor(Color.BLACK);
				c.drawRoundRect(b0, delta, delta, p);
				p.setColor(Color.CYAN);
				c.drawRoundRect(b1, delta, delta, p);
				p.setColor(Color.WHITE);
				c.drawRoundRect(b2, delta, delta, p);

			} else {
				p.setColor(Color.BLACK);
				c.drawRoundRect(b0, delta, delta, p);
				p.setColor(Color.GRAY);
				c.drawRoundRect(b1, delta, delta, p);
				p.setColor(Color.WHITE);
				c.drawRoundRect(b2, delta, delta, p);

			}
			p.setColor(Color.BLACK);
			if (clor == Color.RED || clor == Color.GREEN || clor == Color.BLUE)
				p.setColor(clor);
			p.setTextScaleX(0.4f);
			c.drawText(Bt, Bx + delta, h - delta, p);
		} else {
			if (ViewManager.onb == index) {
				c.drawBitmap(bt, null, b0, p);
			} else {
				c.drawBitmap(bt1, null, b0, p);
			}
		}
		// TODO Auto-generated method stub

	}

	public static void intiate(int bnum) {
		buttonarrayleftx = new float[bnum];
		buttonarraylefty = new float[bnum];
		buttonarrayrightx = new float[bnum];
		buttonarrayrighty = new float[bnum];
	}
}

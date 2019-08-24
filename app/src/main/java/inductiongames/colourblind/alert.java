package inductiongames.colourblind;

import inductiongames.colorblind.R;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;

public class alert {
	public static boolean flag = false;
	public static Bitmap ep2 = null;
	public static Bitmap ep1 = null;
	public static int bdel = 4;
	public static int bnum;

	static public void ale_draw(Canvas c, Paint p) {
		int height;
		int width;
		height = c.getHeight();
		width = c.getWidth();
		RectF dest = new RectF(width / 9, height / 10, width - width / 9,
				height - height / 10);
		p.setColor(Color.argb(200, 200, 200, 200));
		c.drawRoundRect(dest, width / 20, width / 20, p);
		dest = new RectF((float) (1.25 * width / 9), 3 * height / 10,
				(float) (4.3 * width / 9), 6 * height / 10);
		p.setColor(Color.argb(255, game.red, game.green, game.blue));
		c.drawRoundRect(dest, width / 20, width / 20, p);
		dest = new RectF((float) (4.7 * width / 9), 3 * height / 10,
				(float) (7.75 * width / 9), 6 * height / 10);
		p.setColor(Color.argb(255, game.rd, game.gr, game.bl));
		c.drawRoundRect(dest, width / 20, width / 20, p);
		p.setTextScaleX(1.1f);
		p.setTextSize(height / 10);
		p.setTypeface(Typeface.SANS_SERIF);
		p.setColor(Color.BLACK);
		c.drawText("Accuracy", (float) (1.2 * width / 9),
				(float) (7 * height / 10), p);
		p.setTextSize(height / 10);
		c.drawText("Colour", (float) (2.4 * width / 9),
				(float) (2 * height / 10), p);
		p.setTextSize(height / 20);
		p.setTextScaleX(1f);
		p.setTypeface(Typeface.SANS_SERIF);
		c.drawText("Required", (float) (1.3 * width / 9),
				(float) (2.8 * height / 10), p);
		c.drawText("Produced", (float) (4.8 * width / 9),
				(float) (2.8 * height / 10), p);
		p.setTextSize(height / 10);
		p.setColor(Color.BLUE);
		float gacu = game.green - game.gr;
		float racu = game.red - game.rd;
		float bacu = game.blue - game.bl;
		if (gacu < 0) {
			gacu = -1 * gacu;
		}
		if (racu < 0) {
			racu = -1 * racu;
		}
		if (bacu < 0) {
			bacu = -1 * bacu;
		}
		double acu = Math.sqrt(gacu * gacu + racu * racu + bacu * bacu)
				/ Math.sqrt(3 * 255 * 255);
		acu = (100 - acu * 100);
		if (acu < 75)
			p.setColor(Color.RED);
		if (acu < 88 && acu >= 75)
			p.setColor(Color.YELLOW);
		if (acu > 88)
			p.setColor(Color.GREEN);
		if (acu > 99.9)
			acu = 100;
		else {
			acu = Math.round(acu * 10.0) / 10.0;
		}
		c.drawText((acu) + "%", (float) (2.9 * width / 9),
				(float) (8.1 * height / 10), p);
		game.accu = (int) acu;
		if (acu >= 75) {
			bnum = 3;
			paintbutton.intiate(bnum);
			p.setColor(Color.DKGRAY);
			paintbutton.paint_button(c, p, (float) 1.3 * width / 10,
					(float) (12.2 * height / 15), width / 5, (float) 1.5
							* height / 20, "   Back", bdel, 1, ep1, ep2);
			paintbutton.paint_button(c, p, (float) 6.8 * width / 10,
					(float) (12.2 * height / 15), width / 5, (float) 1.5
							* height / 20, "   Next", bdel, 2, ep1, ep2);
			
			
			paintbutton.paint_button(c, p, (float) 3.8 * width / 10,
					(float) (12.2 * height / 15), width / 5, (float) 1.5
					* height / 20, "   Next",bdel,
					3,
					BitmapFactory.decodeResource(
							colourremedy.contex.getResources(), R.drawable.shr),
					BitmapFactory.decodeResource(
							colourremedy.contex.getResources(), R.drawable.shr1));

		} else {
			bnum = 1;
			paintbutton.intiate(bnum);
			p.setColor(Color.DKGRAY);
			paintbutton.paint_button(c, p, (float) 4.2 * width / 10,
					(float) (12.2 * height / 15), width / 5, (float) 1.5
							* height / 20, " Retry", bdel, 1, ep1, ep2);
		}
		game.accu = (float) acu;
	}

	static public void help_draw(Canvas c, Paint p) {

		int height;
		int width;
		height = c.getHeight();
		width = c.getWidth();
		RectF dest = new RectF(width / 9, height / 10, width - width / 9,
				height - height / 10);
		p.setColor(Color.argb(200, 200, 200, 200));
		c.drawRoundRect(dest, width / 20, width / 20, p);

		p.setColor(Color.BLACK);
		p.setTextSize(height / 10);
		p.setTypeface(Typeface.SANS_SERIF);
		c.drawText("    Help", (float) (3 * width / 9),
				(float) (2 * height / 10), p);
		p.setTextSize(height / 25);
		p.setTextScaleX(.8f);
		p.setTypeface(Typeface.SANS_SERIF);
		c.drawText("The game's motive is to check  ",
				(float) (1.3 * width / 9), (float) (2.8 * height / 10), p);
		c.drawText("color perception.Each stage ", (float) (1.3 * width / 9),
				(float) (3.4 * height / 10), p);
		c.drawText("is ment thus  you memorise ", (float) (1.3 * width / 9),
				(float) (4 * height / 10), p);
		c.drawText("a color and reproduce it. Each  ",
				(float) (1.3 * width / 9), (float) (4.6 * height / 10), p);
		c.drawText("stage contain 4 hints ,only one",
				(float) (1.3 * width / 9), (float) (5.2 * height / 10), p);
		c.drawText("hint can be used per stage.  ", (float) (1.3 * width / 9),
				(float) (5.8 * height / 10), p);
		p.setTextScaleX(.66f);
		c.drawText("75% or more accuracy is required  ",
				(float) (1.3 * width / 9), (float) (6.3 * height / 10), p);
		p.setTextScaleX(.8f);
		c.drawText("for unlocking next stage ", (float) (1.3 * width / 9),
				(float) (6.9 * height / 10), p);

		bnum = 1;
		paintbutton.intiate(bnum);
		p.setColor(Color.DKGRAY);
		paintbutton.paint_button(c, p, (float) 4 * width / 10,
				12 * height / 15, width / 5, (float) 1.5 * height / 20,
				"   Back", bdel, 1, ep1, ep2);

	}

	static public void about_draw(Canvas c, Paint p) {
		int height;
		int width;
		height = c.getHeight();
		width = c.getWidth();
		RectF dest = new RectF(width / 9, height / 10, width - width / 9,
				height - height / 10);
		p.setColor(Color.argb(200, 200, 200, 200));
		c.drawRoundRect(dest, width / 20, width / 20, p);
		p.setColor(Color.BLACK);
		p.setTextSize(height / 10);
		p.setTypeface(Typeface.SANS_SERIF);
		c.drawText("    About", (float) (3 * width / 9),
				(float) (2 * height / 10), p);
		p.setTextSize(height / 25);
		p.setTextScaleX(.8f);
		p.setTypeface(Typeface.SANS_SERIF);
		c.drawText("The game is sole property of ", (float) (1.3 * width / 9),
				(float) (2.8 * height / 10), p);
		p.setColor(Color.BLUE);
		c.drawText("Induction games.", (float) (1.3 * width / 9),
				(float) (3.4 * height / 10), p);
		p.setColor(Color.BLACK);
		c.drawText("Designed and produced by", (float) (1.3 * width / 9),
				(float) (4 * height / 10), p);
		p.setColor(Color.BLUE);
		c.drawText("Praveen Ojha", (float) (1.3 * width / 9),
				(float) (4.6 * height / 10), p);
		p.setColor(Color.BLACK);
		c.drawText("This work is copyright  ", (float) (1.3 * width / 9),
				(float) (5.2 * height / 10), p);
		c.drawText("  All rights reserved", (float) (1.8 * width / 9),
				(float) (6.8 * height / 10), p);
		c.drawText("© Induction Games ", (float) (3.2 * width / 9),
				(float) (7.3 * height / 10), p);

		p.setTextSize(height / 10);

		bnum = 1;
		paintbutton.intiate(bnum);
		p.setColor(Color.DKGRAY);
		paintbutton.paint_button(c, p, (float) 4 * width / 10,
				12 * height / 15, width / 5, (float) 1.5 * height / 20,
				"   Back", bdel, 1, ep1, ep2);

	}

	static public void exit_draw(Canvas c, Paint p) {
		int height;
		int width;
		height = c.getHeight();
		width = c.getWidth();
		RectF dest = new RectF(width / 12, 3 * height / 10, width - width / 12,
				height - 3 * height / 10);
		p.setColor(Color.argb(200, 200, 200, 200));
		c.drawRoundRect(dest, width / 20, width / 20, p);
		p.setTextSize(height / 10);
		p.setColor(Color.BLACK);
		p.setTypeface(Typeface.SANS_SERIF);
		c.drawText("      Quit? ", (float) (2.5 * width / 9),
				(float) (4 * height / 10), p);
		p.setTextSize(height / 20);
		p.setTextScaleX(1f);
		p.setTypeface(Typeface.SANS_SERIF);
		c.drawText(" Do you ", (float) (1.2 * width / 9),
				(float) (5.5 * height / 10), p);
		c.drawText(" want to quit ", (float) (4 * width / 9),
				(float) (5.5 * height / 10), p);
		p.setTextSize(height / 10);
		bnum = 2;
		paintbutton.intiate(bnum);
		paintbutton.paint_button(c, p, (float) 1.3 * width / 10,
				9 * height / 15, width / 5, (float) 1.5 * height / 20,
				"   Yes", bdel, 2, ep1, ep2);
		paintbutton.paint_button(c, p, (float) 6.8 * width / 10,
				9 * height / 15, width / 5, (float) 1.5 * height / 20,
				"    No", bdel, 1, ep1, ep2);

	}

	static public void Recall(Canvas c, Paint p) {
		int height;
		int width;
		height = c.getHeight();
		width = c.getWidth();
		RectF dest = new RectF(width / 12, 3 * height / 10, width - width / 12,
				height - 3 * height / 10);
		p.setColor(Color.argb(255, game.red, game.green, game.blue));
		c.drawRoundRect(dest, width / 20, width / 20, p);
		p.setTextSize(height / 10);
		p.setColor(Color.BLACK);
		p.setTypeface(Typeface.SANS_SERIF);
		bnum = 1;
		paintbutton.intiate(bnum);
		paintbutton.paint_button(c, p, (float) 4 * width / 10, 8 * height / 15,
				width / 5, (float) 1.5 * height / 20, "   Back", bdel, 1, ep1,
				ep2);
	}
}

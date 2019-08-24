package inductiongames.colourblind;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import inductiongames.colorblind.R;

public class SplashScreen extends View {
	Bitmap spscreen = null;

	public SplashScreen(Context context) {
		super(context);
		spscreen = BitmapFactory.decodeResource(getResources(),
				R.drawable.splash);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// called when view is drawn
		Paint paint = new Paint();
		paint.setFilterBitmap(true);
		// The image will be scaled so it will fill the width, and the
		// height will preserve the image’s aspect ration
		double aspectRatio = ((double) spscreen.getWidth())
				/ (spscreen.getHeight());
		Rect dest = new Rect(0, 0, this.getWidth(),
				(int) (this.getHeight() / aspectRatio));
		canvas.drawBitmap(spscreen, null, dest, paint);
	}

}

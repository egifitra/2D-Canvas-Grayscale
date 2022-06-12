package com.example.canvas2d;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Paint paint = new Paint ();
        paint.setColor(Color.parseColor("#CD5C5C"));
        Bitmap bg = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas (bg);
        canvas.drawRect (50, 50, 200, 200, paint);
        
        bg = change2GrayScale(bg);
        
        LinearLayout ll = (LinearLayout) findViewById(R.id.Layout1);
        ll.setBackgroundDrawable (new BitmapDrawable (bg));
    
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public Bitmap change2GrayScale(Bitmap bg) {
    	int A, R, G, B;
    	int pixel;
    	
    	int width = bg.getWidth();
    	int height = bg.getHeight();
    	
    	for (int x=0; x<width; ++x) {
    		for (int y= 0; y < height; ++y) {
    			
    			pixel = bg.getPixel(x, y);
    			
    			A= Color.alpha(pixel);
    			R= Color.red(pixel);
    			G= Color.green(pixel);
    			B= Color.blue(pixel);
    			
    			R=G=B=(int)(R+G+B)/3;
    			
    			bg.setPixel (x,y,Color.argb(A,R,G,B));
    		}
    	}
    	return bg;
    }
}

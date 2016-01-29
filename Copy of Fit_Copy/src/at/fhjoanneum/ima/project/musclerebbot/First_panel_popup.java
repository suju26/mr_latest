package at.fhjoanneum.ima.project.musclerebbot;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import at.fhjoanneum.ima.project.getfit.R;

public class First_panel_popup extends Activity  {

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstpanel_popup);

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int width=dm.widthPixels;
		int height=dm.heightPixels;
		getWindow().setLayout((int)(width*.8),(int) (height*.6));
	}

}

package at.fhjoanneum.ima.project.musclerebbot;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import at.fhjoanneum.ima.project.getfit.R;

public class Weightgain_week1_day1 extends Activity {
	
	public void onCreate(Bundle savedInstacestate)
	{
		super.onCreate(savedInstacestate);
		setContentView(R.layout.weightgain_week1_day1);
		
	}
	public void onBackPressed() {
		Intent i_back_to_main = new Intent(this, MainActivity.class);
		startActivity(i_back_to_main);
		finish();
	}
}

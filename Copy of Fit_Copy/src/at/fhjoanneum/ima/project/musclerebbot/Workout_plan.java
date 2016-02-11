package at.fhjoanneum.ima.project.musclerebbot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import at.fhjoanneum.ima.project.getfit.R;


public class Workout_plan extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_workout_plan);
	}
	@Override
	public void onBackPressed() {

		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}

	public void week1(View v)
	{
		Intent intent = new Intent(this, Cycle1_W1_D1.class);
		startActivity(intent);
		finish();
	}
}

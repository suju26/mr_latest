package at.fhjoanneum.ima.project.musclerebbot;




import android.os.Bundle;
import android.os.Handler;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Gallery;
import at.fhjoanneum.ima.project.getfit.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
	ViewFlipper mViewFlipper;
	private GestureDetector mGestureDetector;

	//Images List
	Integer[] imageIDs={

			R.drawable.g1,
			R.drawable.g2
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_test);
		ActionBar actionBar = getActionBar();
		actionBar.show();
		mViewFlipper = (ViewFlipper) findViewById(R.id.image1);
		mViewFlipper.startFlipping();

		// Add all the images to the ViewFlipper
		for (int i = 0; i < imageIDs.length; i++) {
			ImageView imageView = new ImageView(this);
			imageView.setImageResource(imageIDs[i]);
			mViewFlipper.addView(imageView);
		}
		// Set in/out flipping animations
		mViewFlipper.setInAnimation(this, android.R.anim.fade_in);
		mViewFlipper.setOutAnimation(this, android.R.anim.fade_out);

		CustomGestureDetector customGestureDetector = new CustomGestureDetector();
		mGestureDetector = new GestureDetector(this, customGestureDetector);



	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);

	}



	public void mainMenuButtonOnClick(View view) {
		switch (view.getId()) {
		case R.id.scheduler_button:
			Intent i_scheduler = new Intent(this, Scheduler.class);
			startActivity(i_scheduler);
			break;

		case R.id.exercise_button:
			Intent i_exercises = new Intent(this, Exercises.class);
			startActivity(i_exercises);
			break;

		case R.id.body_profile_button:
			Intent i_body = new Intent(this, BodyProfil.class);
			startActivity(i_body);
			break;

		case R.id.stats_button:
			Intent i_stats = new Intent(this, Stats.class);
			startActivity(i_stats);
			break;

		case R.id.todays_exec_button:
			Intent i_todayse = new Intent(this, TodaysTraining.class);
			startActivity(i_todayse);
			break;

		case R.id.credtits_button:
			Intent i_credits = new Intent(this, Credits.class);
			startActivity(i_credits);
			break;





		}


	}
	public void buttonClickFunction(View v)
	{
		Intent intent = new Intent(this, Your_Profile_Fragment.class);
		startActivity(intent);
	}
	public void workout_plan(View v)
	{
		Intent intent = new Intent(this, Weightgain_week1_day1.class);
		startActivity(intent);
	}
	@Override
	public void onBackPressed() {
		finish();
	}
	class CustomGestureDetector extends GestureDetector.SimpleOnGestureListener {

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

			// Swipe left (next)
			if (e1.getX() > e2.getX()) {
				mViewFlipper.showNext();
			}

			// Swipe right (previous)
			if (e1.getX() < e2.getX()) {
				mViewFlipper.showPrevious();
			}

			return super.onFling(e1, e2, velocityX, velocityY);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		mGestureDetector.onTouchEvent(event);

		return super.onTouchEvent(event);
	}
}
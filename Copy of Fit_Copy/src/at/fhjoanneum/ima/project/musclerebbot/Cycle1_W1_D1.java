package at.fhjoanneum.ima.project.musclerebbot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import at.fhjoanneum.ima.project.getfit.R;

public class Cycle1_W1_D1 extends Activity{
	ViewFlipper mview,calfpress_view,decline_cruch_view;

	//Images List legpress
	Integer[] legpressimg={

			R.drawable.leg_press_1_1024x670,
			R.drawable.leg_press_2_1024x670

	};
	Integer[] calfpressimg={

			R.drawable.calves_press_on_leg_machine_1,
			R.drawable.calves_press_on_leg_machine_2

	};
	Integer[] declinecrunchimg={

			R.drawable.decline_crunch_1,
			R.drawable.decline_crunch_2

	};
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c1_w1_d1);
		mview=(ViewFlipper)findViewById(R.id.leg_press);
		calfpress_view=(ViewFlipper)findViewById(R.id.calf_press);
		decline_cruch_view=(ViewFlipper)findViewById(R.id.decline_crunch);

		for (int i = 0; i < legpressimg.length; i++) {
			ImageView imageView = new ImageView(this);
			imageView.setImageResource(legpressimg[i]);
			mview.addView(imageView);
		}
		for (int i = 0; i < calfpressimg.length; i++) {
			ImageView imageView = new ImageView(this);
			imageView.setImageResource(calfpressimg[i]);
			calfpress_view.addView(imageView);
		}
		for (int i = 0; i < declinecrunchimg.length; i++) {
			ImageView imageView = new ImageView(this);
			imageView.setImageResource(declinecrunchimg[i]);
			decline_cruch_view.addView(imageView);
		}
		calfpress_view.setInAnimation(this, android.R.anim.slide_in_left);
		calfpress_view.setOutAnimation(this, android.R.anim.slide_out_right);
		decline_cruch_view.setInAnimation(this, android.R.anim.slide_in_left);
		decline_cruch_view.setOutAnimation(this, android.R.anim.slide_out_right);
		mview.setInAnimation(this, android.R.anim.slide_in_left);
		mview.setOutAnimation(this, android.R.anim.slide_out_right);
		mview.startFlipping();
		mview.setFlipInterval(100);
		calfpress_view.startFlipping();
		calfpress_view.setFlipInterval(100);
		decline_cruch_view.startFlipping();
		decline_cruch_view.setFlipInterval(0);
	}
	@Override
	public void onBackPressed() {

		Intent intent = new Intent(this, Workout_plan.class);
		startActivity(intent);
		finish();
	}

}

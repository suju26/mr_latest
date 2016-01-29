package at.fhjoanneum.ima.project.musclerebbot;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import at.fhjoanneum.ima.project.getfit.R;

public class Your_Goal_Fragment extends Activity {

	String selectedgoal;
	Spinner nutri_spinner;
	String selectednutri;
	SharedPreferences sharedpreferences;
	String Astatus;
	TextView text_gaol;
	TextView tdee_result;
	String tdde_activity;
	double tdde_num;
	double tdde_goal;
	TextView txtview_percent_macro_protein;
	TextView txtview_percent_maccro_fats;
	TextView txtview_percent_maccro_carbs;
	TextView txt_macro_protein_percentage_manual;
	TextView txt_macro_fat_percentage_manual;
	TextView txt_macro_carb_percentage_manual;
	double your_pro,your_carbs,your_fats;
	TextView txt_macro_fats_percentage_manual;
	TextView txt_macro_carbs_percentage_manual;



	public Your_Goal_Fragment(){}

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_your_goal);

		sharedpreferences = this.getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
		Astatus = sharedpreferences.getString("bmr_key", "0");
		Log.e("", "namdev Astatus  "+Astatus);

		tdee_result=(TextView)findViewById(R.id.txt_result);

		tdee_result.setText(""+Astatus);

		text_gaol=(TextView)findViewById(R.id.macro_goal_calories_calculated);
		txtview_percent_macro_protein=(TextView)findViewById(R.id.macro_protein_percentage_calculated);
		txtview_percent_maccro_fats=(TextView)findViewById(R.id.macro_fat_percentage_calculated);
		txtview_percent_maccro_carbs=(TextView)findViewById(R.id.macro_carb_percentage_calculated);
		txt_macro_protein_percentage_manual=(TextView)findViewById(R.id.macro_protein_percentage_manual);
		txt_macro_fats_percentage_manual=(TextView)findViewById(R.id.macro_fat_percentage_manual);
		txt_macro_carbs_percentage_manual=(TextView)findViewById(R.id.macro_carb_percentage_manual);

		Spinner goal_spinner = (Spinner)findViewById(R.id.macro_goal_spinner);
		List<String> setactivity = new ArrayList<String>();
		setactivity.add("Choose your Goal");
		setactivity.add("Gain Weight");
		setactivity.add("Loss Weight");
		setactivity.add("Maintain Weight");
		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, setactivity);
		// Drop down layout style - list view with radio button
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// attaching data adapter to spinner
		goal_spinner.setAdapter(dataAdapter);
		goal_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				selectedgoal=parent.getItemAtPosition(position).toString();	


				//TDEE Calculation Based on Goal Selected

				if(selectedgoal.equals("Choose your Goal"))
				{
					tdde_activity=tdee_result.getText().toString();
					Log.e("", "Sujit"+tdde_activity);
					tdde_num=Double.parseDouble(tdde_activity);
					tdde_goal=0;
					text_gaol.setText(""+Math.round(tdde_goal));

				}

				if(selectedgoal.equals("Gain Weight"))
				{
					tdde_activity=tdee_result.getText().toString();
					Log.e("", "Sujit"+tdde_activity);
					tdde_num=Double.parseDouble(tdde_activity);
					tdde_goal=tdde_num+(tdde_num*0.20);
					text_gaol.setText(""+Math.round(tdde_goal));

				}

				if(selectedgoal.equals("Loss Weight"))
				{
					tdde_activity=tdee_result.getText().toString();
					tdde_num=Double.parseDouble(tdde_activity);
					tdde_goal=tdde_num-(tdde_num*0.20);
					text_gaol.setText(""+tdde_goal);

				}

				if(selectedgoal.equals("Maintain Weight"))
				{
					tdde_activity=tdee_result.getText().toString();
					tdde_num=Double.parseDouble(tdde_activity);
					tdde_goal=tdde_num;
					text_gaol.setText(""+tdde_goal);

				}
				Log.d("", "selecteditem : "+selectedgoal);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}

		});





		//Choose your Nutritional Plan
		Button btn_nutrition=(Button)findViewById(R.id.btn_nutrtional_plan);
		btn_nutrition.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				on_nutri();
			}
		});

		//Back to Profile

		Button btn_bck_pro=(Button)findViewById(R.id.btn_back_profile);
		btn_bck_pro.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				on_bck_pro();
			}
		});





	}
	public void on_nutri()
	{
		if(selectedgoal.equals("Choose your Goal"))
		{
			Toast.makeText(this, "Choose Your Desired Goal",
					Toast.LENGTH_SHORT).show();

		}else{
			//text_gaol
			String your_goal=text_gaol.getText().toString();
			SharedPreferences.Editor editor = sharedpreferences.edit();
			editor.putString("Goal_Cal", your_goal);
			editor.commit();
			Intent intent = new Intent(this, Macro_Required_Fragment.class);
			startActivity(intent);
		}
	}
	public void on_bck_pro()
	{


		/*
		Fragment fragment = new Your_Profile_Fragment();
		// Insert the fragment by replacing any existing fragment
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction()
		.replace(R.id.frame_container, fragment)
		.commit();*/
	}



}

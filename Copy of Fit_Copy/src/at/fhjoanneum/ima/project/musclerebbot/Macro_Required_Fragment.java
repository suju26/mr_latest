package at.fhjoanneum.ima.project.musclerebbot;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import at.fhjoanneum.ima.project.getfit.R;

public class Macro_Required_Fragment extends Activity {
	Spinner goal_spinner;
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
	TextView your_goal;
	double macro_result;
	String savedplan;

	public Macro_Required_Fragment(){}

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.fragment_macro_requirement);


		txtview_percent_macro_protein=(TextView)findViewById(R.id.macro_protein_percentage_calculated);
		txtview_percent_maccro_fats=(TextView)findViewById(R.id.macro_fat_percentage_calculated);
		txtview_percent_maccro_carbs=(TextView)findViewById(R.id.macro_carb_percentage_calculated);
		txt_macro_protein_percentage_manual=(TextView)findViewById(R.id.macro_protein_percentage_manual);
		txt_macro_fats_percentage_manual=(TextView)findViewById(R.id.macro_fat_percentage_manual);
		txt_macro_carbs_percentage_manual=(TextView)findViewById(R.id.macro_carb_percentage_manual);
		nutri_spinner = (Spinner)findViewById(R.id.macro_nutrition_spinner);


		your_goal=(TextView)findViewById(R.id.macro_goal_calories_calculated);

		sharedpreferences = this.getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
		Astatus = sharedpreferences.getString("Goal_Cal", "0");
		savedplan=sharedpreferences.getString("selected_plan","0");

		Log.e("", "namdev Astatus  "+Astatus);

		tdee_result=(TextView)findViewById(R.id.txt_result);

		your_goal.setText(""+Astatus);
		// Spinner click listener
		// activity_spinner.setOnItemSelectedListener(this);
		// Spinner Drop down elements
		List<String> setnutri = new ArrayList<String>();
		setnutri.add("Choose Your Goal");
		setnutri.add("Ketogenic Macro");
		setnutri.add("Zone Macro");
		setnutri.add("Low Carb Macro");
		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, setnutri);
		// Drop down layout style - list view with radio button
		dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// attaching data adapter to spinner
		nutri_spinner.setAdapter(dataAdapter1);

		nutri_spinner.setSelection(Integer.parseInt(savedplan));


		//Spinner Activity Level
		//nutri_spinner = (Spinner)rootView.findViewById(R.id.macro_nutrition_spinner);
		nutri_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {



			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				selectednutri=String.valueOf(position);//parent.getItemAtPosition(position).toString();
				Log.d("", "selecteditem : "+selectednutri);

				if(selectednutri.equals("0"))
				{
					macro_result=Double.parseDouble(Astatus);
					txtview_percent_macro_protein.setText("0%");
					txtview_percent_maccro_fats.setText("0%");
					txtview_percent_maccro_carbs.setText("0%");
					your_pro=macro_result*0;
					your_carbs=macro_result*0;
					your_fats=macro_result*0;
					txt_macro_protein_percentage_manual.setText(""+Math.round(your_pro));
					txt_macro_fats_percentage_manual.setText(""+Math.round(your_fats));
					txt_macro_carbs_percentage_manual.setText(""+Math.round(your_carbs));

				}

				if(selectednutri.equals("1"))
				{
					macro_result=Double.parseDouble(Astatus);
					txtview_percent_macro_protein.setText("35%");
					txtview_percent_maccro_fats.setText("60%");
					txtview_percent_maccro_carbs.setText("5%");
					your_pro=macro_result*0.35/4;
					your_carbs=macro_result*0.05/4;
					your_fats=macro_result*0.6/9;
					txt_macro_protein_percentage_manual.setText(""+Math.round(your_pro));
					txt_macro_fats_percentage_manual.setText(""+Math.round(your_fats));
					txt_macro_carbs_percentage_manual.setText(""+Math.round(your_carbs));

				}
				if(selectednutri.equals("2"))
				{
					txtview_percent_macro_protein.setText("30%");
					txtview_percent_maccro_fats.setText("60%");
					txtview_percent_maccro_carbs.setText("40%");

					your_pro=macro_result*0.30/4;
					your_carbs=macro_result*0.40/4;
					your_fats=macro_result*0.60/9;
					txt_macro_protein_percentage_manual.setText(""+Math.round(your_pro));
					txt_macro_fats_percentage_manual.setText(""+Math.round(your_fats));
					txt_macro_carbs_percentage_manual.setText(""+Math.round(your_carbs));
				}

				if(selectednutri.equals("3"))
				{
					txtview_percent_macro_protein.setText("45%");
					txtview_percent_maccro_fats.setText("30%");
					txtview_percent_maccro_carbs.setText("25%");	

					your_pro=macro_result*0.45/4;
					your_carbs=macro_result*0.25/4;
					your_fats=macro_result*0.30/9;
					txt_macro_protein_percentage_manual.setText(""+Math.round(your_pro));
					txt_macro_fats_percentage_manual.setText(""+Math.round(your_fats));
					txt_macro_carbs_percentage_manual.setText(""+Math.round(your_carbs));
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				txtview_percent_macro_protein.setText("0%");


			}

		});


		Button btn_bck_pro=(Button)findViewById(R.id.btn_back_goal);
		btn_bck_pro.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				on_bck_goal();
			}
		});

		Button btn_save_macro=(Button)findViewById(R.id.btn_save_macro);
		btn_save_macro.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				on_save_macro(selectednutri);
			}
		});


	}

	public void on_bck_goal()
	{



		/*Fragment fragment = new Your_Goal_Fragment();
		// Insert the fragment by replacing any existing fragment
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction()
		.replace(R.id.frame_container, fragment)
		.commit();*/
	}

	public void on_save_macro(String selectednutri)
	{
		if(selectednutri.equals("0"))
		{

			Toast.makeText(this, "Choose Your Nutrtional Plan",
					Toast.LENGTH_SHORT).show();
		}else{
			SharedPreferences.Editor editor = sharedpreferences.edit();
			editor.putString("selected_plan", selectednutri);
			editor.commit();
		}
	}
}
package at.fhjoanneum.ima.project.musclerebbot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Spinner;
import android.widget.TextView;
import at.fhjoanneum.ima.project.getfit.R;

public class Nutrition extends Activity{


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
	TextView txt_macro_fats_percentage_manual,txt_your_health_goal,txt_your_diet_goal;
	TextView txt_macro_carbs_percentage_manual;
	Spinner goal_spinner;
	TextView your_goal;
	double macro_result;
	String savedplan;
	String auto_goal;
	String auto_diet;





	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_your_nutrition);
		sharedpreferences = this.getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
		auto_goal=sharedpreferences.getString("goal_health_position", "Not Set");
		Astatus = sharedpreferences.getString("bmr_key", "0");
		auto_diet=sharedpreferences.getString("diet_key", "Not Set");
		text_gaol=(TextView)findViewById(R.id.macro_goal_calories_calculated);
		text_gaol.setText(""+Astatus);
		txtview_percent_macro_protein=(TextView)findViewById(R.id.macro_protein_percentage_calculated);
		txtview_percent_maccro_fats=(TextView)findViewById(R.id.macro_fat_percentage_calculated);
		txtview_percent_maccro_carbs=(TextView)findViewById(R.id.macro_carb_percentage_calculated);
		txt_macro_protein_percentage_manual=(TextView)findViewById(R.id.macro_protein_percentage_manual);
		txt_macro_fats_percentage_manual=(TextView)findViewById(R.id.macro_fat_percentage_manual);
		txt_macro_carbs_percentage_manual=(TextView)findViewById(R.id.macro_carb_percentage_manual);
		txt_your_health_goal=(TextView)findViewById(R.id.your_health_goal);
		txt_your_diet_goal=(TextView)findViewById(R.id.your_diet_goal);



		if(auto_goal.equals("Gain Weight"))
		{
			tdde_activity=text_gaol.getText().toString();
			tdde_num=Double.parseDouble(tdde_activity);
			tdde_goal=tdde_num+(tdde_num*0.20);
			text_gaol.setText(""+Math.round(tdde_goal));
			txt_your_health_goal.setText(auto_goal);
			txt_your_health_goal.setTypeface(Typeface.MONOSPACE);
			txt_your_health_goal.setGravity(Gravity.CENTER_HORIZONTAL);

		}

		if(auto_goal.equals("Loss Weight"))
		{
			tdde_activity=text_gaol.getText().toString();
			tdde_num=Double.parseDouble(tdde_activity);
			tdde_goal=tdde_num-(tdde_num*0.20);
			text_gaol.setText(""+tdde_goal);
			txt_your_health_goal.setText(auto_goal);
			txt_your_health_goal.setTypeface(Typeface.MONOSPACE);
			txt_your_health_goal.setGravity(Gravity.CENTER_HORIZONTAL);



		}

		if(auto_goal.equals("Maintain Weight"))
		{
			tdde_activity=text_gaol.getText().toString();
			tdde_num=Double.parseDouble(tdde_activity);
			tdde_goal=tdde_num;
			text_gaol.setText(""+tdde_goal);
			txt_your_health_goal.setText(auto_goal);
			txt_your_health_goal.setTypeface(Typeface.MONOSPACE);
			txt_your_health_goal.setGravity(Gravity.CENTER_HORIZONTAL);


		}





		txtview_percent_macro_protein=(TextView)findViewById(R.id.macro_protein_percentage_calculated);
		txtview_percent_maccro_fats=(TextView)findViewById(R.id.macro_fat_percentage_calculated);
		txtview_percent_maccro_carbs=(TextView)findViewById(R.id.macro_carb_percentage_calculated);
		txt_macro_protein_percentage_manual=(TextView)findViewById(R.id.macro_protein_percentage_manual);
		txt_macro_fats_percentage_manual=(TextView)findViewById(R.id.macro_fat_percentage_manual);
		txt_macro_carbs_percentage_manual=(TextView)findViewById(R.id.macro_carb_percentage_manual);
		nutri_spinner = (Spinner)findViewById(R.id.macro_nutrition_spinner);


		your_goal=(TextView)findViewById(R.id.macro_goal_calories_calculated);
		your_goal.setText(""+Astatus);
		macro_result=Double.parseDouble(Astatus);


		if(auto_diet.equals("Ketogenic Macro"))
		{
			txtview_percent_macro_protein.setText("35%");
			txtview_percent_maccro_fats.setText("60%");
			txtview_percent_maccro_carbs.setText("5%");
			your_pro=macro_result*0.35/4;
			your_carbs=macro_result*0.05/4;
			your_fats=macro_result*0.6/9;
			txt_macro_protein_percentage_manual.setText(""+Math.round(your_pro));
			txt_macro_fats_percentage_manual.setText(""+Math.round(your_fats));
			txt_macro_carbs_percentage_manual.setText(""+Math.round(your_carbs));
			txt_your_diet_goal.setText(auto_diet);
			txt_your_diet_goal.setTypeface(Typeface.MONOSPACE);
			txt_your_diet_goal.setGravity(Gravity.CENTER_HORIZONTAL);

		}
		if(auto_diet.equals("Zone Macro"))
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
			txt_your_diet_goal.setText(auto_diet);
			txt_your_diet_goal.setTypeface(Typeface.MONOSPACE);
			txt_your_diet_goal.setGravity(Gravity.CENTER_HORIZONTAL);

		}

		if(auto_diet.equals("Low Carb Macro"))
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
			txt_your_diet_goal.setText(auto_diet);
			txt_your_diet_goal.setTypeface(Typeface.MONOSPACE);
			txt_your_diet_goal.setGravity(Gravity.CENTER_HORIZONTAL);

		}


	}
	@Override
	public void onBackPressed() {
		Intent i_back_to_main = new Intent(this, Your_Profile_Fragment.class);
		startActivity(i_back_to_main);
		finish();

	}

}

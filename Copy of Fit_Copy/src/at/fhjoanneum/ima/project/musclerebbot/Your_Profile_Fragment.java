package at.fhjoanneum.ima.project.musclerebbot;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;
import at.fhjoanneum.ima.project.getfit.R;




public class Your_Profile_Fragment extends Activity {
	Spinner spinneractivity ;
	String selected_Activity_level;
	EditText age,height_ft,weight,height_inch;
	RadioGroup radiogender;
	RadioButton radioSexButton;
	Double bmr;
	View rootView ;
	SharedPreferences sharedpreferences;
	public static final String MyPREFERENCES = "MyPrefs" ;
	double tdde;
	double height_ft_to_cm,height_inch_cm,age_input,height_input,weight_input,cm_to_meter,bmi_result;
	String age_text_view,weight_string;
	TextView bmi_text;
	public Your_Profile_Fragment(){}



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.fragment_your_profile);
		bmi_text=(TextView)findViewById(R.id.bmi_result);
		//Shared Prefferance

		/*String age_saved=sharedpreferences.getString("age_key", "");
		age.setText(age_saved);*/

		Spinner activity_spinner = (Spinner)findViewById(R.id.spinnerprofile_ui_activity);
		List<String> setactivity = new ArrayList<String>();
		setactivity.add("Select Your Activity Level");
		setactivity.add("Little to no exercise");
		setactivity.add("3 time per week");
		setactivity.add("5 time per week");
		setactivity.add("Daily Exercise and physical job");
		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, setactivity);
		// Drop down layout style - list view with radio button
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// attaching data adapter to spinner
		activity_spinner.setAdapter(dataAdapter);



		//radiogender=(RadioGroup)findViewById(R.id.radioGroup1);
		//Spinner Activity Level
		spinneractivity = (Spinner)findViewById(R.id.spinnerprofile_ui_activity);
		spinneractivity.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				selected_Activity_level=parent.getItemAtPosition(position).toString();	
				Log.d("", "selecteditem : "+selected_Activity_level);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}

		});

		//Initializing all component
		age=(EditText)findViewById(R.id.profile_ui_age);
		radiogender=(RadioGroup)findViewById(R.id.radioGroup1);
		height_ft=(EditText)findViewById(R.id.profile_ui_height_ft);
		height_inch=(EditText)findViewById(R.id.profile_ui_height_inch);
		weight=(EditText)findViewById(R.id.profile_ui_weight);
		sharedpreferences = this.getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

		Button bp=(Button)findViewById(R.id.profile_help);
		bp.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				first_panel_help();
			}
		});




		Button btw=(Button)findViewById(R.id.bmi_cal);
		btw.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				bmi_calculation();
			}
		});
		
		





	}
	public void OnSave()
	{

		String age_string=age.getText().toString();
		String height_string=height_ft.getText().toString();
		String weight_string=weight.getText().toString();

		if(age_string.equals("")||height_string.equals("")||weight_string.equals("")){

			Toast.makeText(this, "Enter all Required Details",
					Toast.LENGTH_SHORT).show();

		}else{
			if(selected_Activity_level.equals("Select Your Activity Level"))
			{
				Toast.makeText(this, "Please Select your Activity Level",
						Toast.LENGTH_SHORT).show();
			}else{
				double age_input= Double.parseDouble(age_string);

				double height_input=Double.parseDouble(height_string);

				double weight_input= Double.parseDouble(weight_string);

				//BMR Calculation 

				int selectedId=radiogender.getCheckedRadioButtonId();
				radioSexButton=(RadioButton)findViewById(selectedId);
				if(radioSexButton.getText().equals("Male")){
					bmr=10*weight_input+6.25*height_input-5*age_input+5;
				}
				if(radioSexButton.getText().equals("Female"))
				{
					bmr=10*weight_input+6.25*height_input-5*age_input-161;

				}



				if(selected_Activity_level.equals("Little to no exercise"))
				{
					tdde=bmr*1.2;
				}
				if(selected_Activity_level.equals("3 time per week"))
				{
					tdde=bmr*1.375;
				}
				if(selected_Activity_level.equals("5 time per week"))
				{
					tdde=bmr*1.55;
				}
				if(selected_Activity_level.equals("Daily Exercise and physical job"))
				{
					tdde=bmr*1.725;
				}
				String final_tdde=Double.toString(Math.round(tdde));

				SharedPreferences.Editor editor = sharedpreferences.edit();
				editor.putString("bmr_key", final_tdde);
				editor.putString("age_key",age_string );
				editor.putString("weight_key",weight_string );
				editor.putString("height_key", height_string);
				if(selectedId == R.id.profile_ui_male_radio)
					editor.putBoolean("is_male", true);
				else
					editor.putBoolean("is_male", false);

				editor.commit();

				Intent intent = new Intent(this, Your_Goal_Fragment.class);
				startActivity(intent);

			}
		}
	}
	public void bmi_calculation() {
		String height_ft_textview=height_ft.getText().toString();
		String height_inch_textview=height_inch.getText().toString();
		age_text_view=age.getText().toString();
		weight_string=weight.getText().toString();



		if(height_ft_textview.equals("")||height_inch_textview.equals("")||age_text_view.equals("")||weight_string.equals(""))
		{
			Toast.makeText(this, "Please Enter All Required Details",
					Toast.LENGTH_SHORT).show();
		}
		else{
			height_ft_to_cm=Double.parseDouble(height_ft_textview)/0.032808;
			height_inch_cm=Double.parseDouble(height_inch_textview)*2.54;
			//Handling null value 


			age_input= Double.parseDouble(age_text_view);

			height_input=height_ft_to_cm+height_inch_cm;

			weight_input= Double.parseDouble(weight_string);
			cm_to_meter= height_input/100*2;

			bmi_result=weight_input/cm_to_meter;




			if(bmi_result<18.5)
			{
				bmi_text.setText("You are underweight, so you may need to put on some weight. Your recommended Goal and Macro is Set.");
				bmi_text.setTextColor(Color.parseColor("#FF5722"));
				bmi_text.setTypeface(Typeface.MONOSPACE);
			}
			if(bmi_result>=18.5 && bmi_result<=25)
			{
				bmi_text.setText("You are at a healthy weight for your height. Your recommended Goal and Macro is Sets.");
				bmi_text.setTextColor(Color.parseColor("#4CAF50"));
				bmi_text.setTypeface(Typeface.MONOSPACE);

			}
			if(bmi_result>=25 && bmi_result<=30)
			{
				bmi_text.setText("You are slightly overweight. You may be advised to lose some weight for health reasons. Your recommended Goal and Macro is Set.");
				bmi_text.setTextColor(Color.parseColor("#FFA000"));
				bmi_text.setTypeface(Typeface.MONOSPACE);

			}
			if(bmi_result>30)
			{
				bmi_text.setText("You are heavily overweight. Your health may be at risk if you do not lose weight. Your recommended Goal and Macro is Set.");
				bmi_text.setTextColor(Color.parseColor("#D32F2F"));
				bmi_text.setTypeface(Typeface.MONOSPACE);

			}

		}


	}
	public void first_panel_help(){
		startActivity(new Intent(this,First_panel_popup.class));
		
	}


}

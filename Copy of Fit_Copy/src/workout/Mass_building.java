package workout;

import at.fhjoanneum.ima.project.getfit.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class Mass_building extends Activity  {
	ListView l;
	String[] days={"Back and Biceps","Chest and Triceps","Rest Day","Quads.Hamstrings and Calves","Shoulder,Traps and Foreearms","Rest Day","Rest Day"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.mass_building);

	}

}

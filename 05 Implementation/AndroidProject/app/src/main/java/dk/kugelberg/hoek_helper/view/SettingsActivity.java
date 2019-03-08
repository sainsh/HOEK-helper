package dk.kugelberg.hoek_helper.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import dk.kugelberg.hoek_helper.R;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

//        ActionBar actionBar = this.getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == android.R.id.home) {
//            NavUtils.navigateUpFromSameTask(this);
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

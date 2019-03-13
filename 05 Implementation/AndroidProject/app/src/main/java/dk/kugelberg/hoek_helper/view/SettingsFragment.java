package dk.kugelberg.hoek_helper.view;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;
import dk.kugelberg.hoek_helper.R;

public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
//        setPreferencesFromResource(R.xml.settings, rootKey);
        addPreferencesFromResource(R.xml.settings);
    }

}
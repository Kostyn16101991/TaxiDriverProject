package ua.step.kostyn.taxidriverproject;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ua.step.kostyn.taxidriverproject.fragments.SingInFragment;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeFragment(SingInFragment.newInstance());
    }

    public void changeFragment(Fragment fragment){
        this.fragment = fragment;
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}

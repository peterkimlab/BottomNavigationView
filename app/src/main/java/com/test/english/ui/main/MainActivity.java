package com.test.english.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.exam.english.R;
import com.exam.english.databinding.ActivityMainBinding;
import com.test.english.ui.frag1.Fragment1;
import com.test.english.ui.frag2.Fragment2;
import com.test.english.ui.frag3.Fragment3;
import com.test.english.ui.frag4.Fragment4;
import com.test.english.ui.helper.BottomNavigationNotShiftHelper;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private FragmentTransaction transaction = null;
    private Fragment fragment;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragment1 = Fragment1.newInstance();
        fragment2 = Fragment2.newInstance();
        fragment3 = Fragment3.newInstance();
        fragment4 = Fragment4.newInstance();

        fragment = fragment1;
        changeFragment();

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        BottomNavigationNotShiftHelper.disableShiftMode(mainBinding.bottomNavigation);

        mainBinding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.frag1:
                        fragment = fragment1;
                        changeFragment();
                        return true;
                    case R.id.frag2:
                        fragment = fragment2;
                        changeFragment();
                        return true;
                    case R.id.frag3:
                        fragment = fragment3;
                        changeFragment();
                        return true;
                    case R.id.frag4:
                        fragment = fragment4;
                        changeFragment();
                        return true;
                }
                return false;
            }
        });
    }

    private void changeFragment() {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flContainerHome, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

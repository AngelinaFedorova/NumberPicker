package com.super_rabbit.demo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.super_rabbit.demo.demo_fragments.BirthdayPickerFragment;
import com.super_rabbit.demo.demo_fragments.DateAndTimePickerFragment;
import com.super_rabbit.demo.demo_fragments.UnlimitedNumberPickerDemo;
import com.super_rabbit.demo.demo_fragments.WeekDayPickerFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(BirthdayPickerFragment.newInstance());
        setClickListeners(this);
    }

    public void setClickListeners(MainActivity activity) {
        activity.findViewById(R.id.show_style_demo).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DemoActivity.class);
            startActivity(intent);
        });
        activity.findViewById(R.id.show_unlimited_number_picker).setOnClickListener(v -> replaceFragment(UnlimitedNumberPickerDemo.newInstance()));
        activity.findViewById(R.id.show_week_day_picker).setOnClickListener(v -> replaceFragment(WeekDayPickerFragment.newInstance()));
        activity.findViewById(R.id.show_day_picker).setOnClickListener(v -> replaceFragment(DateAndTimePickerFragment.newInstance()));
        activity.findViewById(R.id.show_birthday_day_picker).setOnClickListener(v -> replaceFragment(BirthdayPickerFragment.newInstance()));
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.commit();
    }
}

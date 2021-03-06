package com.leap.aries.presentation;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.leap.aries.R;
import com.leap.aries.databinding.ActivityMainBinding;
import com.leap.aries.presentation.base.BaseActivity;
import com.leap.mini.util.ToastUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
  private String TAG = "MainActivity";
  private ActivityMainBinding binding;
  private Context context;
  private MainPagerAdapter adapter;
  private List<MainFragment> fragments;

  @Override
  protected void initComponent() {
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    context = this;
  }

  @Override
  protected void loadData(Bundle savedInstanceState) {
    EventBus.getDefault().post("");
    fragments = new ArrayList<>();
    fragments.add(new MainFragment());
    fragments.add(new MainFragment());
    adapter = new MainPagerAdapter(getSupportFragmentManager());
    binding.viewPage.setAdapter(adapter);
  }

  @Override
  protected void createEventHandlers() {
    binding.button1.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        Log.e("OnTouchListener", event.getAction() + "");
        ToastUtil.showFailure(context, getString(R.string.test_1));
        return false;
      }
    });
  }
  // onCreate, onStart, onResume, onPause, onStop, onDestroy

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState,
      @Nullable PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);
    Log.i(TAG, "onCreate");
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.i(TAG, "onStart");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.i(TAG, "onResume");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.i(TAG, "onPause");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.i(TAG, "onStop");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.i(TAG, "onDestroy");
  }

  private class MainPagerAdapter extends FragmentPagerAdapter {
    MainPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      return fragments.get(position);
    }

    @Override
    public int getCount() {
      return fragments.size();
    }
  }
}

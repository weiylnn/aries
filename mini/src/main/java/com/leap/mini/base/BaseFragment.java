package com.leap.mini.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 基础Fragment
 * <p>
 * Created by ylwei on 2016/12/7.
 */
public abstract class BaseFragment extends Fragment {

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = initComponent(inflater, container);
    loadData(savedInstanceState);
    createEventHandlers();
    return view;
  }

  /**
   * 初始化界面控件
   */
  protected abstract View initComponent(LayoutInflater inflater, ViewGroup container);

  /**
   * 初次加载数据
   */
  protected abstract void loadData(Bundle savedInstanceState);

  /**
   * 判断界面表单数据填写是否有效
   */
  protected boolean isValid() {
    return true;
  }

  /**
   * 界面事件响应
   */
  protected void createEventHandlers() {
  }
}

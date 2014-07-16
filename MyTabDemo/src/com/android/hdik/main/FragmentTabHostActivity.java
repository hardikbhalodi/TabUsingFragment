/**
 * @author Hardik A. Bhalodi  
 * this demo is solution for who want to write app using Tab with fragment,enjoy !!!!
 * {@link FeatureInfo}
 *  -sticky header with back button navigation
 *  -Tab solution with back to home screen function
 *  - 
 *  
 *
 */

package com.android.hdik.main;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.pm.FeatureInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

import com.android.hdik.R;
import com.android.hdik.firsttab.FirstScreen;
import com.android.hdik.fotrhtab.Tab4FirstScreen;
import com.android.hdik.secondtab.Tab2FirstScreen;
import com.android.hdik.thirdtab.Tab3FirstScreen;
import com.android.hdik.utils.Const;

public class FragmentTabHostActivity extends FragmentActivity implements
		OnTabChangeListener {

	private TabHost tabHost;
	private String currentSelectedTab;
	private HashMap<String, ArrayList<Fragment>> hMapTabs;
	final int TEXT_ID = 100;
	private Button btnHeaderBack;
	final String arrTabLabel[] = { "First", "Second", "Third", "Forth" };
	/*
	 * used arrIcons when foreground icon and background image both required in tab
	 */
	/*
	 * final static int arrIcons[] = {};
	 */
	private MyTabView arrTabs[] = new MyTabView[4];

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.fragment_tab_host_activity);
		btnHeaderBack = (Button) findViewById(R.id.btnHeaderBack);

		// initlizing tabs//

		hMapTabs = new HashMap<String, ArrayList<Fragment>>();
		hMapTabs.put(Const.TAB_FIRST, new ArrayList<Fragment>());
		hMapTabs.put(Const.TAB_SECOND, new ArrayList<Fragment>());
		hMapTabs.put(Const.TAB_THIRD, new ArrayList<Fragment>());
		hMapTabs.put(Const.TAB_FORTH, new ArrayList<Fragment>());

		tabHost = (TabHost) findViewById(android.R.id.tabhost);
		tabHost.setOnTabChangedListener(this);
		tabHost.setup();

		btnHeaderBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});

		TabHost.TabSpec spec = tabHost.newTabSpec(Const.TAB_FIRST);
		tabHost.setCurrentTab(0);
		arrTabs[0] = new MyTabView(this, 0, arrTabLabel[0]);
		spec.setContent(new TabHost.TabContentFactory() {
			public View createTabContent(String tag) {
				return findViewById(android.R.id.tabcontent);
			}
		});
		spec.setIndicator(arrTabs[0]);
		tabHost.addTab(spec);

		spec = tabHost.newTabSpec(Const.TAB_SECOND);
		arrTabs[1] = new MyTabView(this, 1, arrTabLabel[1]);
		spec.setContent(new TabHost.TabContentFactory() {
			public View createTabContent(String tag) {
				return findViewById(android.R.id.tabcontent);
			}
		});

		spec.setIndicator(arrTabs[1]);
		tabHost.addTab(spec);

		spec = tabHost.newTabSpec(Const.TAB_THIRD);
		arrTabs[2] = new MyTabView(this, 2, arrTabLabel[2]);
		spec.setContent(new TabHost.TabContentFactory() {
			public View createTabContent(String tag) {
				return findViewById(android.R.id.tabcontent);
			}
		});
		spec.setIndicator(arrTabs[2]);
		tabHost.addTab(spec);

		spec = tabHost.newTabSpec(Const.TAB_FORTH);
		arrTabs[3] = new MyTabView(this, 3, arrTabLabel[3]);
		spec.setContent(new TabHost.TabContentFactory() {
			public View createTabContent(String tag) {
				return findViewById(android.R.id.tabcontent);
			}
		});
		spec.setIndicator(arrTabs[3]);
		tabHost.addTab(spec);

		// set background for Selected Tab
		TextView tv = (TextView) tabHost.getCurrentTabView().findViewById(
				TEXT_ID);
		tv.setTextColor(Color.parseColor("#ffffff"));
		View iv = (View) tabHost.getCurrentTabView();
		iv.setBackgroundResource(R.color.green);

		// Listner for Tab 1//
		tabHost.getTabWidget().getChildAt(0)
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if (hMapTabs.size() > 0) {

							if (tabHost.getTabWidget().getChildAt(0)
									.isSelected()) {
								if (hMapTabs.get(Const.TAB_FIRST).size() > 1) {
									resetFragment();
								}
							}
							tabHost.getTabWidget().setCurrentTab(0);
							tabHost.setCurrentTab(0);
						}
					}
				});

		/* Listner for Tab 2 */
		tabHost.getTabWidget().getChildAt(1)
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						if (hMapTabs.size() > 0) {

							if (tabHost.getTabWidget().getChildAt(1)
									.isSelected()) {
								if (hMapTabs.get(Const.TAB_SECOND).size() > 1) {
									resetFragment();
								}
							}
							tabHost.getTabWidget().setCurrentTab(1);
							tabHost.setCurrentTab(1);
						}
					}
				});

		/* Listner for Tab 3 */
		tabHost.getTabWidget().getChildAt(2)
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						if (hMapTabs.size() > 0) {

							if (tabHost.getTabWidget().getChildAt(2)
									.isSelected()) {
								if (hMapTabs.get(Const.TAB_THIRD).size() > 1) {
									resetFragment();
								}
							}
							tabHost.getTabWidget().setCurrentTab(2);
							tabHost.setCurrentTab(2);
						}
					}
				});
		/* Listner for Tab 4 */
		tabHost.getTabWidget().getChildAt(3)
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						if (hMapTabs.size() > 0) {

							if (tabHost.getTabWidget().getChildAt(3)
									.isSelected()) {
								if (hMapTabs.get(Const.TAB_FORTH).size() > 1) {
									resetFragment();
								}
							}
							tabHost.getTabWidget().setCurrentTab(3);
							tabHost.setCurrentTab(3);
						}
					}
				});

	}

	/* Method for adding fragment */

	public void addFragments(String tabName, Fragment fragment,
			boolean animate, boolean add) {
		if (add) {
			hMapTabs.get(tabName).add(fragment);
		}
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction ft = manager.beginTransaction();
		if (animate) {
			ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
		}
		ft.replace(android.R.id.tabcontent, fragment);
		ft.commit();
	}

	/* Method for remove fragment */

	public void removeFragment() {
		Fragment fragment = hMapTabs.get(currentSelectedTab).get(
				hMapTabs.get(currentSelectedTab).size() - 2);
		hMapTabs.get(currentSelectedTab).remove(
				hMapTabs.get(currentSelectedTab).size() - 1);
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction ft = manager.beginTransaction();
		ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
		ft.replace(android.R.id.tabcontent, fragment);
		ft.commit();
	}

	// reset frgment used when clicked on same tab
	private void resetFragment() {
		Fragment fragment = hMapTabs.get(currentSelectedTab).get(0);
		hMapTabs.get(currentSelectedTab).clear();
		hMapTabs.get(currentSelectedTab).add(fragment);
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction ft = manager.beginTransaction();
		ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
		ft.replace(android.R.id.tabcontent, fragment);
		ft.commit();

	}

	@Override
	public void onBackPressed() {

		if (hMapTabs.get(currentSelectedTab).size() <= 1) {
			super.onBackPressed();
		} else {
			removeFragment();
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (hMapTabs.get(currentSelectedTab).size() == 0) {
			return;
		}
		hMapTabs.get(currentSelectedTab)
				.get(hMapTabs.get(currentSelectedTab).size() - 1)
				.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onTabChanged(String tabName) {
		// TODO Auto-generated method stub
		currentSelectedTab = tabName;

		// make iteration for unselected tab and make normal background
		for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
			TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i)
					.findViewById(TEXT_ID);
			View iv = (View) tabHost.getTabWidget().getChildAt(i);
			iv.setBackgroundColor(0x00000000);
		}
		TextView tv = (TextView) tabHost.getCurrentTabView().findViewById(
				TEXT_ID); // for Selected Tab
		tv.setTextColor(Color.parseColor("#ffffff"));

		View iv = (View) tabHost.getCurrentTabView();

		if (hMapTabs.get(tabName).size() == 0) {

			if (tabName.equals(Const.TAB_FIRST)) {
				addFragments(tabName, new FirstScreen(), false, true);
			} else if (tabName.equals(Const.TAB_SECOND)) {
				addFragments(tabName, new Tab2FirstScreen(), false, true);
			} else if (tabName.equals(Const.TAB_THIRD)) {
				addFragments(tabName, new Tab3FirstScreen(), false, true);
			} else if (tabName.equals(Const.TAB_FORTH)) {
				addFragments(tabName, new Tab4FirstScreen(), false, true);
			}
		} else {
			addFragments(
					tabName,
					hMapTabs.get(tabName).get(hMapTabs.get(tabName).size() - 1),
					false, false);
		}

		switch (tabHost.getCurrentTab()) {
		case 0:
			iv.setBackgroundResource(R.color.green);
			break;
		case 1:
			iv.setBackgroundResource(R.color.red);
			break;
		case 2:
			iv.setBackgroundResource(R.color.yellow);
			break;
		case 3:
			iv.setBackgroundResource(R.color.twitter);
			break;

		}

	}

	private class MyTabView extends LinearLayout {
		int nIdx = -1;
		TextView tv;

		public MyTabView(Context c, int drawableIdx, String label) {
			super(c);
			ImageView iv = new ImageView(c);
			nIdx = drawableIdx;
			// used for forground icons//
			// iv.setImageResource(arrIcons[nIdx]);

			tv = new TextView(c);
			tv.setText(label);
			tv.setGravity(Gravity.CENTER_HORIZONTAL);
			tv.setTextSize(11.0f);
			tv.setId(TEXT_ID);
			LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			layout.setMargins(0, 3, 0, 0);
			iv.setLayoutParams(layout);
			layout.setMargins(0, 3, 0, 2);
			tv.setLayoutParams(layout);
			tv.setTextColor(Color.parseColor("#ffffff"));

			setOrientation(LinearLayout.VERTICAL);
			setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
			addView(iv);
			addView(tv);
		}
	}

}

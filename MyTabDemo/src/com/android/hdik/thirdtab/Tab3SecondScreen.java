package com.android.hdik.thirdtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.hdik.R;
import com.android.hdik.main.BaseFragment;
import com.android.hdik.utils.Const;

public class Tab3SecondScreen extends BaseFragment implements OnClickListener  {
	private Button backButton;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.tab3_secodscreen,
				container, false);

		backButton = (Button) view.findViewById(R.id.btnBack);
		backButton.setOnClickListener(this);
		System.out.println("replace");
		return view;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		fragmentTabActivity.onBackPressed();
		
	}
}

package com.example.aparn.joketellingapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainFreeFragment extends Fragment {
	private static final String TAG = MainFreeFragment.class.getSimpleName();
	private ProgressBar mProgressBar;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		final View root = inflater.inflate(R.layout.free_fragment, container, false);
		Button button = (Button) root.findViewById(R.id.jokebutton);
		mProgressBar = (ProgressBar) root.findViewById(R.id.progressbar);
		final AdView adView = (AdView) root.findViewById(R.id.adView);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				fetchJoke();
			}
		});

		AdRequest adRequest = new AdRequest.Builder()
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				//.addTestDevice("")
				.build();
		adView.loadAd(adRequest);
		return root;
	}

	public void fetchJoke() {
		new FetchJokeTask(getContext(), mProgressBar).execute();
	}
}

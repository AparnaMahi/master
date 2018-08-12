package com.example.aparn.joketellingapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.aparn.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

public class FetchJokeTask extends AsyncTask<Void, Void, String> {
	private static final String TAG = FetchJokeTask.class.getSimpleName();
	private static MyApi myApiService = null;

	ProgressBar mProgressBar;
	private Context context;

	public FetchJokeTask(Context context) {
		this.context = context;
	}

	public FetchJokeTask(Context context, ProgressBar progressBar) {
		this.context = context;
		mProgressBar = progressBar;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		if (mProgressBar != null) {
			mProgressBar.setVisibility(View.VISIBLE);
		}
	}

	@Override
	protected String doInBackground(Void... voids) {
		if (myApiService == null) {
			MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
					new AndroidJsonFactory(), null)
					.setRootUrl("http://10.0.2.2:8080/_ah/api/")
					//.setRootUrl("https://joketellingapp.appspot.com/_ah/api/")
					.setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
						@Override
						public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
							abstractGoogleClientRequest.setDisableGZipContent(true);
						}
					});
			myApiService = builder.build();
		}

		try {
			return myApiService.telljoke().execute().getData();
		} catch (IOException e) {
			return e.getMessage();
		}
	}

	@Override
	protected void onPostExecute(final String result) {
		if (mProgressBar != null) {
			mProgressBar.setVisibility(View.GONE);
		}
		start_jokeActivity(result);
	}

	private void start_jokeActivity(String result) {
		Intent intent = new Intent(context, com.example.jokesdisplayandroidlib.JokesDisplayActivity.class);
		intent.putExtra(context.getString(R.string.jokes), result);
		context.startActivity(intent);
	}
}
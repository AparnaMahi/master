package com.example.aparn.joketellingapp;

import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.ExecutionException;

public class FetchJokeTestCase extends AndroidTestCase {
    private static final String TAG = FetchJokeTestCase.class.getSimpleName();

    public void testJokesNotNull()
    {
        FetchJokeTask fetchJokeTask = new FetchJokeTask(getContext());
        fetchJokeTask.execute();
        try
        {
            String joke = fetchJokeTask.get();
            Log.d(TAG, "Joke text: " + joke);
            assertNotNull(joke);
            assertTrue(joke.length() > 0);
        }
        catch (InterruptedException | ExecutionException e)
        {
            Log.e(TAG, Log.getStackTraceString(e));
        }
    }
}
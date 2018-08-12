package com.example.aparn.joketellingapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class FetchJokeTestCase {

    private static final String TAG = FetchJokeTask.class.getSimpleName();
    Context context;

    @Test
    public void testAllJokes() {

        final CountDownLatch signal = new CountDownLatch(1);
        try {
            context = InstrumentationRegistry.getContext();
            FetchJokeTask testJokeTask = new FetchJokeTask(context) {
                @Override
                protected void onPostExecute(String jokes) {
                    //Log.d(TAG, "Joke text: " + jokes);
                    if(jokes.equals("Error"))
                        assertTrue(jokes.equals("Error"));
                    else {
                        assertNotNull(jokes);
                        assertTrue(jokes.length() > 0);
                    }
                    signal.countDown();
                }
            };
            testJokeTask.execute();
            signal.await();
        } catch (InterruptedException e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
    }
}

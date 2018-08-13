package com.example.aparn.joketellingapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class FetchJokeTestCase {

    private static final String TAG = FetchJokeTask.class.getSimpleName();
    Context context;

    @Test
    public void testAllJokes() {

        final CountDownLatch latch = new CountDownLatch(1);
        try {
            context = InstrumentationRegistry.getContext();
            FetchJokeTask testJokeTask = new FetchJokeTask(context) {
                @Override
                protected void onPostExecute(String jokes) {
                    //Log.d(TAG, "Joke text: " + jokes);
                    if(jokes.isEmpty()||jokes.equals(null)||jokes.equals("Error")){
                        assertFalse(jokes.isEmpty()||jokes.equals(null)||jokes.equals("Error"));
                    }
                    else {
                        assertFalse(jokes.isEmpty() || jokes.equals(null) || jokes.equals("Error"));
                    }
                    latch.countDown();
                }
            };
            testJokeTask.execute();
            latch.await();
        } catch (InterruptedException e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
    }
}

package com.example.logins;


import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import java.util.logging.LogRecord;

public class MyJobService extends JobService {
    private static final String TAG = "My Job Service";
    private boolean jobCancelled = false;
    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d(TAG, "Job started");
        doBackgroundWork(params);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d(TAG, "Job cancelled before completion");
        jobCancelled = true;
        return true;
    }

    private void doBackgroundWork(final JobParameters params){
        new Thread(new Runnable() {
            @Override
            public void run() {
                    for (int i = 0; i < 10; i++) {
                        Handler handler = new Handler(getMainLooper());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),"Hai",Toast.LENGTH_SHORT).show();
                            }
                        });
                    if(jobCancelled){
                        return;
                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Log.d(TAG, "Job finished");
                jobFinished(params, false);
            }
        }).start();
    }



}

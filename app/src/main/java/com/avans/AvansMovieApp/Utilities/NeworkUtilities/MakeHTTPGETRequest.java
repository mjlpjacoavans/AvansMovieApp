package com.avans.AvansMovieApp.Utilities.NeworkUtilities;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MakeHTTPGETRequest extends AsyncTask<String, Integer, String> {

    private HTTPGETRequestable context;

    public MakeHTTPGETRequest(HTTPGETRequestable context) {
        this.context = context;
    }

    protected String doInBackground(String... urls) {
        String response = "";
        try {
            URL url = new URL(urls[0]);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream stream = conn.getInputStream();
            Scanner s = new Scanner(stream).useDelimiter("\\A");
            response += s.hasNext() ? s.next() : "";
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    protected void onPostExecute(String responseBody) {
        // do the callback on this.context (implements HTTPGETRequestable)
        context.ProcessHTTPGETResponse(responseBody);
    }
}
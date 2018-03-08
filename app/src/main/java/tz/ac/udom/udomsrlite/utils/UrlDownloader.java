package tz.ac.udom.udomsrlite.utils;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ali on 11/26/17.
 */

public class UrlDownloader {

    private static final String TAG = UrlDownloader.class.getSimpleName();

    public static String getData(String mUrl) throws IOException {

        String data = "";
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            URL url = new URL(mUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            // buffer data to string
            data = stringBuilder.toString();
            bufferedReader.close();

        } catch (IOException e) {
            Log.d(TAG, e.getMessage());

        } finally {

            if (inputStream != null)
                inputStream.close();

            if (urlConnection != null)
                urlConnection.disconnect();
        }


        return data;
    }
}

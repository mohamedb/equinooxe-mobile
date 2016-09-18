package com.equinooxe.base;

import android.util.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Common service to do basic transaction with the server
 * Created by mboullouz on 11/09/2016.
 */
public class BaseService<E>   {
    private Class<E[]> klazz;
    public BaseService(Class<E[]> klazz){
        this.klazz = klazz;
    }
    public List<E> getData(String serverUrl) {
        StringBuilder urlString = new StringBuilder();
        urlString.append(serverUrl);
        System.out.println("URL: " + urlString.toString());

        HttpURLConnection urlConnection = null;
        URL url = null;
        List<E> entitiesList = null;

        try
        {
            url = new URL(urlString.toString());
            urlConnection = (HttpURLConnection) url.openConnection();


            String basicAuth = "Basic " + new String( Base64.encode(ServerSettings.USER_CREDENTIALS.getBytes(), Base64.DEFAULT));
            urlConnection.addRequestProperty("Authorization", basicAuth);

            urlConnection.addRequestProperty("Content-Type", "application/json");

            urlConnection.setRequestMethod("GET");


            urlConnection.connect();
            InputStream inStream = null;
            inStream = urlConnection.getInputStream();
            System.out.println("Reponse code: "+urlConnection.getResponseCode() );
            System.out.println("\n resp msg: "+urlConnection.getResponseMessage() );

            BufferedReader bReader = new BufferedReader(new InputStreamReader(inStream));
            String temp, responseJsonString = "";
            while ((temp = bReader.readLine()) != null){
                responseJsonString += temp;

            }
            System.out.println("obj: " +   responseJsonString);
            bReader.close();
            inStream.close();
            urlConnection.disconnect();

            ObjectMapper objectMapper = new ObjectMapper();
            E[] locations = objectMapper.readValue(responseJsonString, klazz);
            entitiesList = new ArrayList<>(Arrays.asList(locations));
            System.out.println("obj: " + entitiesList);
        }
        catch (Exception e)
        {
            System.out.println("Exception: "+e );
        }

        return entitiesList;
    }
}

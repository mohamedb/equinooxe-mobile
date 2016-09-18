package com.equinooxe.component.location;

import android.os.AsyncTask;

import com.equinooxe.base.BaseService;
import com.equinooxe.base.ServerSettings;
import com.equinooxe.domain.Location;

import java.util.List;


/**
 * Created by mohamed on 13/06/2016.
 */
public class LocationService extends AsyncTask<String, Void, List<Location>> {


    @Override
    protected List<Location> doInBackground(String... params) {
        BaseService<Location> baseService = new BaseService<>(Location[].class);
        return baseService.getData(ServerSettings.LOCATION_ALL);
    }




}

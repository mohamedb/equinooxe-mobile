package com.equinooxe.component.user;

import android.os.AsyncTask;

import com.equinooxe.base.BaseService;
import com.equinooxe.base.ServerSettings;
import com.equinooxe.domain.User;

import java.util.List;


/**
 * Created by mohamed on 13/06/2016.
 */
public class UserService extends AsyncTask<String, Void, List<User>> {

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected List<User> doInBackground(String... params) {
        BaseService<User> baseService = new BaseService<>(User[].class);
        return baseService.getData(ServerSettings.USERS_ALL);
    }




}

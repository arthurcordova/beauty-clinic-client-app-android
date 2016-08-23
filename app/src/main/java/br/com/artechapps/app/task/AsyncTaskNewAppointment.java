package br.com.artechapps.app.task;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import br.com.artechapps.app.BuildConfig;
import br.com.artechapps.app.activity.MainMenuActivity;
import br.com.artechapps.app.model.User;
import br.com.artechapps.app.utils.EndPoints;
import br.com.artechapps.app.utils.SessionManager;

/**
 * Created by arthurcordova on 7/8/16.
 */
public class AsyncTaskNewAppointment extends AsyncTaskHttp {

    private JSONObject mJson;

    public AsyncTaskNewAppointment(String msg, Context context, boolean showDialog) {
        mMsg = msg;
        mContext = context;
        mShowDialog = showDialog;

    }

    @Override
    protected String doInBackground(String... params) {
        try {
            String cpf = params[0].replace(".","").replace("-","");
            String pwd = params[1];

            User user = new User();
            user.setCodFilial(BuildConfig.FILIAL);
            user.setSenha(pwd);
            user.setCpfcnpj(cpf);

            Gson gson = new Gson();
            String userJson = gson.toJson(user);

            mJson = connectServerO(EndPoints.CONFIRM_APPOINTMENT, userJson,false);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (mJson != null){

        } else {
            Toast.makeText(mContext,"Usuário ou senha inválida.", Toast.LENGTH_LONG).show();
        }
    }
}

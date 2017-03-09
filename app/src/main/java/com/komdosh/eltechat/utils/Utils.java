package com.komdosh.eltechat.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.komdosh.eltechat.constants.JSONConstants;
import com.komdosh.eltechat.constants.ServerCommandConstants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by komdosh on 14.02.17.
 */

public class Utils {

    private Context context;
    private SharedPreferences sharedPref;

    private static Utils ourInstance = new Utils();

    public static Utils getInstance() {
        return ourInstance;
    }

    private static final String KEY_SESSION_ID = "sessionId";
    private static final String FLAG_MESSAGE = "message";

    private static final String KEY_SHARED_FILE = "ElteChat";
    private static final int KEY_MODE_PRIVATE = 0;


    private Utils() {
    }

    public void init(Context context) {
        this.context = context;
        sharedPref = this.context.getSharedPreferences(KEY_SHARED_FILE, KEY_MODE_PRIVATE);
    }

    public void storeSessionId(String sessionId) {
        Editor editor = sharedPref.edit();
        editor.putString(KEY_SESSION_ID, sessionId);
        editor.apply();
    }

    public String getSessionId() {
        return sharedPref.getString(KEY_SESSION_ID, null);
    }

    public String getJSONForMessage(String message, String name) {
        Map<String, String> keyVal = new HashMap<>();
        keyVal.put(JSONConstants.FLAG, ServerCommandConstants.MESSAGE);
        keyVal.put(JSONConstants.MESSAGE, message);
        keyVal.put(JSONConstants.NAME, name);

        return getJSON(keyVal);
    }

    public String getJSONForLogin(String name){
        Map<String, String> keyVal = new HashMap<>();
        keyVal.put(JSONConstants.FLAG, ServerCommandConstants.LOGIN);
        keyVal.put(JSONConstants.NAME, name);

        return getJSON(keyVal);
    }

    public String getJSONForLogoff(String name){
        Map<String, String> keyVal = new HashMap<>();
        keyVal.put(JSONConstants.FLAG, ServerCommandConstants.LEFT);
        keyVal.put(JSONConstants.NAME, name);

        return getJSON(keyVal);
    }

    private String getJSON(Map<String, String> keyVal){
        String json = null;

        try {
            JSONObject jObj = new JSONObject();

            Set<String> keySet = keyVal.keySet();

            for(String k : keySet){
                if(keyVal.containsKey(k)) {
                    jObj.put(k, keyVal.get(k));
                }
            }
            json = jObj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }

}
package com.example.java_pos.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.java_pos.Models.Order;
import com.google.gson.Gson;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.java_pos.Models.Order;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPrefHelper {

    private static final String ORDER_PREF_NAME = "orderList";

    // Store order list in shared preferences
    public static void storeOrderList(Context context, List<Order> orderList, String username) {
        SharedPreferences.Editor editor = context.getSharedPreferences(username, Context.MODE_PRIVATE).edit();
        Gson gson = new Gson();
        String json = gson.toJson(orderList);
        editor.putString(ORDER_PREF_NAME, json);
        editor.apply();
    }

    // Retrieve order list from shared preferences
    public static List<Order> retrieveOrderList(Context context, String username) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(username, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(ORDER_PREF_NAME, null);
        Type type = new TypeToken<List<Order>>() {}.getType();
        return gson.fromJson(json, type);
    }


    // Remove order list from shared preferences
    public static void removeOrderList(Context context, String username) {
        SharedPreferences.Editor editor = context.getSharedPreferences(username, Context.MODE_PRIVATE).edit();
        editor.remove(ORDER_PREF_NAME);
        editor.apply();
    }


}

package com.romilparh.shadybond.finalexam;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.johnhiott.darkskyandroidlib.ForecastApi;
import com.johnhiott.darkskyandroidlib.RequestBuilder;
import com.johnhiott.darkskyandroidlib.models.Request;
import com.johnhiott.darkskyandroidlib.models.WeatherResponse;

import org.w3c.dom.Text;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(final Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them

        System.out.println("Called OnUpdate");

        ForecastApi.create("2b9bfdd3c0b46243d5dc449718204853");

        RequestBuilder weather = new RequestBuilder();

        Request request = new Request();
        request.setLat("43.6529");
        request.setLng("-79.3849");

        request.setUnits(Request.Units.SI);
        request.setLanguage(Request.Language.PIG_LATIN);
        request.addExcludeBlock(Request.Block.CURRENTLY);
        request.removeExcludeBlock(Request.Block.CURRENTLY);

        weather.getWeather(request, new Callback<WeatherResponse>() {
            @Override
            public void success(WeatherResponse weatherResponse, Response response) {
                Log.d("Temp", "Temp: " + weatherResponse.getCurrently().getTemperature());
                RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
                views.setTextViewText(R.id.appwidget_text, Double.toString(weatherResponse.getCurrently().getTemperature()));
                final AppWidgetManager mgr = AppWidgetManager.getInstance(context);
                final ComponentName cn = new ComponentName(context, NewAppWidget.class);
                mgr.updateAppWidget(cn, views);

            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.d("Error", "Error while calling: " + retrofitError.getUrl());
            }
        });

        // Construct the RemoteViews object


        super.onUpdate(context, appWidgetManager, appWidgetIds);

        Log.d("Question Two: PartOne","What is happening?");
        Log.d("Answer Two", "I used a wrapper class for DarkSky API to handle the JSON Responses. The link to the repository is https://github.com/johnhiott/DarkSkyApi . It is fetching all the values in their respective data types for the current temperature forecast. ");
        Log.d("Question Two: PartTwo","Why is it happening?");
        Log.d("Answer Two", "Because this was the final exam and it had to happen anyway");

        Log.d("Question Two: PartThree","What's in the circle?");
        Log.d("Answer Two", "Life. It just revolves around some shit that everyone wants to be out of and enjoy at a distant beach with no one around oneself.");

        Log.d("If its a wrong context","If these questions were not asked in such context and were all based off life, then, here are the answers. ");

        Log.d("Question Two: PartOne","What is happening?");
        Log.d("Answer Two", "Well, I started having good time now as I think I am becoming at least a bit open to people and I talk to them, maybe even professionally, but I do. My behavior has gone soft though, that I can observe, which I have no idea why but maybe you know why.");
        Log.d("Question Two: PartTwo","Why is it happening?");
        Log.d("Answer Two", "I don't know. Maybe because I allowed someone to be with me and also, made some other people known to me, I don't know if I should call them friends, but it is because my perspective of thinking and behavior with other people is changing that I can see, and I don't know if you can see that too jenelle.");

        Log.d("Question Two: PartThree","What's in the circle?");
        Log.d("Answer Two", "It's life. It just is the way. It's like the candy, given to everyone and after receiving this candy, everyone needs to find a way to finish the candy in a way they want. For that, one may need to do somethings to the extreme level, which eventually will get him the taste of life and also, let him enjoy it.");



    }

    public void onUpdate(){
        ForecastApi.create("2b9bfdd3c0b46243d5dc449718204853");

        RequestBuilder weather = new RequestBuilder();

        Request request = new Request();
        request.setLat("43.6529");
        request.setLng("-79.3849");

        request.setUnits(Request.Units.SI);
        request.setLanguage(Request.Language.PIG_LATIN);
        request.addExcludeBlock(Request.Block.CURRENTLY);
        request.removeExcludeBlock(Request.Block.CURRENTLY);

        weather.getWeather(request, new Callback<WeatherResponse>() {
            @Override
            public void success(WeatherResponse weatherResponse, Response response) {
                Log.d("Temp", "Temp: " + weatherResponse.getCurrently().getTemperature());

            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.d("Error", "Error while calling: " + retrofitError.getUrl());
            }
        });

    }


}


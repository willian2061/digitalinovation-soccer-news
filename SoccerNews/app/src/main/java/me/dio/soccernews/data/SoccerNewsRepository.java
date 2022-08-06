package me.dio.soccernews.data;


import androidx.room.Room;

import me.dio.soccernews.App;
import me.dio.soccernews.data.remote.SoccerNewsApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SoccerNewsRepository {

//region Constantes
    private static final String REMOTE_API_URL = "";
    private static final String LOCAL_DB_NAME = "SOCCER-NEWS";
//endregion


    private SoccerNewsApi remoteapi;
    private SoccerNewsDb localDb;

    public SoccerNewsApi getRemoteApi(){return remoteApi;
    }
    public SoccerNewsDb getLocalDb() {return localDb;
    }

    private SoccerNewsRepository(){
        remoteApi = new Retrofit.Builder().baseUrl(REMOTE_API_URL).addConverterFactory(GsonConverterFactory.create()).build().create(SoccerNewsApi.class)

        localDb = Room.databaseBuilder(App.getInstance(), SoccerNewsDb.class)
    }
}

package apps.savvisingh.docsapptestapp.data.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SavviSingh on 06/08/17.
 */

public class NetworkClient {
    public static final String BASE_URL = "https://www.personalityforge.com/api/";
    private static Retrofit retrofit = null;



    public static Retrofit getClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            HttpUrl originalHttpUrl = original.url();

            HttpUrl url = originalHttpUrl.newBuilder()
                    .addQueryParameter("apiKey", "6nt5d1nJHkqbkphe")
                    .addQueryParameter("chatBotID", "63906")
                    .addQueryParameter("externalID", "chirag1")
                    .build();

            // Request customization: add request headers
            Request.Builder requestBuilder = original.newBuilder()
                    .url(url);

            Request request = requestBuilder.build();
            return chain.proceed(request);
        });

        OkHttpClient client = httpClient.build();



        synchronized (NetworkClient.class) {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(client)
                        .build();
            }
            return retrofit;
        }
    }
}

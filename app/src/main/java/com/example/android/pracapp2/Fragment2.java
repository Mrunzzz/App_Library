package com.example.android.pracapp2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.android.pracapp2.data.Books;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Fragment2 extends Fragment {
    SearchView search;
    ImageButton searchButton;

    RecyclerView searchResults;

    String searchKey;


    String BASE_URL="http://192.168.0.102:8000/";
    OkHttpClient.Builder httpClient=new OkHttpClient.Builder();
    public Fragment2() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        container.removeAllViews();
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);



        search = (SearchView) view.findViewById(R.id.searchView1);
        searchButton = (ImageButton) view.findViewById(R.id.imageButton1);
        searchResults = (RecyclerView) view.findViewById(R.id.recyclerview_search);
        searchResults.setVisibility(View.INVISIBLE);
        searchKey = search.getQuery().toString();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit.Builder builder =
                        new Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(
                                        GsonConverterFactory.create()
                                );
                Retrofit retrofit =
                        builder
                                .client(
                                        httpClient.build()
                                )
                                .build();

                SearchBookClient client =  retrofit.create(SearchBookClient.class);

                Call<List<Books>> calls=client.searchBooks(searchKey);

                calls.enqueue(new Callback<List<Books>>() {
                    @Override
                    public void onResponse(Call<List<Books>> call, Response<List<Books>> response) {

                        int statusCode = response.code();
                        List<Books> books=response.body();
                        SearchAdapter adapter;
                        LinearLayoutManager layoutManager;
                        adapter=new SearchAdapter(books,getContext());
                        layoutManager
                                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

                        searchResults.setLayoutManager(layoutManager);



                        searchResults.setAdapter(adapter);
                        searchResults.setVisibility(View.VISIBLE);
                        Log.i("TAG",books.get(0).getBookName());

                    }

                    @Override
                    public void onFailure(Call<List<Books>> call, Throwable t) {
                        Toast.makeText(getContext(), "done", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        return view;

    }
}

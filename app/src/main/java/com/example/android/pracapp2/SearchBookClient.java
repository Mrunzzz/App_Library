package com.example.android.pracapp2;

import com.example.android.pracapp2.data.Books;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mrunz on 12/6/17.
 */

public interface SearchBookClient {

    @GET("book/")
    Call<List<Books>> searchBooks(@Query("format") String format,@Query("search") String key);


}

/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.pracapp2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.pracapp2.data.Books;

import java.util.List;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchAdapterViewHolder> {

    private List<Books> books;
    private Context context;

    public SearchAdapter(List<Books> books,Context context) {
        this.context=context;
        this.books=books;
    }

    @Override
    public SearchAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        int layoutIdForListItem = R.layout.listitem;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View view = inflater.inflate(layoutIdForListItem, viewGroup,false);
        return new SearchAdapterViewHolder(view);
    }


    @Override
    public void onBindViewHolder(SearchAdapterViewHolder holder, int position) {
        holder.author.setText(books.get(position).getBookAuthor());
        holder.title.setText(books.get(position).getBookName());
        holder.genre.setText(books.get(position).getBookGenre());
        holder.id.setText(String.valueOf(books.get(position).getBookID()));

    }


    @Override
    public int getItemCount() {
        if (null == books) return 0;
        return books.size();
    }


    public class SearchAdapterViewHolder extends RecyclerView.ViewHolder {


        TextView title,author,genre,id;

        public SearchAdapterViewHolder(View v) {

            super(v);

            title = (TextView) v.findViewById(R.id.title);
            author=(TextView) v.findViewById(R.id.author);
            genre=(TextView) v.findViewById(R.id.genre);
            id=(TextView) v.findViewById(R.id.objectId);}
    }

}

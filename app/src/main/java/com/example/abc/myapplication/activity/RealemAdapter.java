package com.example.abc.myapplication.activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.abc.myapplication.R;


import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;
import model.Book;

public class RealemAdapter extends RealmRecyclerViewAdapter<Book, RealemAdapter.ViewHolder> {



    RealemAdapter(RealmResults<Book> data) {
        super(data, true);
        // Only set this if the model class has a primary key that is also a integer or long.
        // In that case, {@code getItemId(int)} must also be overridden to return the key.
        // See https://developer.android.com/reference/android/support/v7/widget/RecyclerView.Adapter.html#hasStableIds()
        // See https://developer.android.com/reference/android/support/v7/widget/RecyclerView.Adapter.html#getItemId(int)
        setHasStableIds(true);
    }


   
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_realem_book_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Book book = getItem(position);
        holder.tvTitle.setText("Title : "+book.getTitle());
        holder.tvDescription.setText("Description : "+book.getDescription());
        holder.tvAuthor.setText("Author : "+book.getAuthor() );
        holder.tvLibrary.setText("Library : "+book.getLibrary().getName());
    }

    @Override
    public long getItemId(int index) {
        //noinspection ConstantConditions
        return getItem(index).getId();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDescription,tvAuthor,tvLibrary;
        LinearLayout layoutMain;

        public ViewHolder(View itemLayoutView) {

            super(itemLayoutView);
            layoutMain = (LinearLayout) itemLayoutView.findViewById(R.id.ll_book_layout);
            tvTitle = (TextView) itemLayoutView.findViewById(R.id.rd_book_each_title);
            tvDescription = (TextView) itemLayoutView.findViewById(R.id.rd_book_each_description);
            tvAuthor = (TextView) itemLayoutView.findViewById(R.id.rd_book_each_author);
            tvLibrary = (TextView) itemLayoutView.findViewById(R.id.rd_book_each_library);

        /*    layoutMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("file:///" + Environment.getExternalStorageDirectory().getPath() + "/MV_e-learning_Mar/Modules/1/story_html5.html"));
                    mContext.startActivity(browserIntent);



                }
            });

            imgshare = (ImageView) itemLayoutView.findViewById(R.id.imgshare);
            imgDownload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    trainingFragment.startDownload(getAdapterPosition());
                }
            });*/



        }
    }
}
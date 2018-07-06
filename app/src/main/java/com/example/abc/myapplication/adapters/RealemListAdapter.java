/*
package com.example.abc.myapplication.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.abc.myapplication.R;

import java.util.List;

import model.Book;

public class RealemListAdapter extends RealmRecyclerViewAdapter<Book>{

    private Context mContext;
    private Resources resources;
    private List<Book> mDataList;


    public RealemListAdapter(Context context) {
        mContext = context;
        resources = context.getResources();

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_realem_book_item, parent, false);

        // create ViewHolder
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }


    @Override
    public int getItemCount() {
        if (getRealmAdapter() != null) {
            return getRealmAdapter().getCount();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDescription,tvAuthor,tvLibrary;
        LinearLayout layoutMain;

        public ViewHolder(View itemLayoutView) {

            super(itemLayoutView);
            layoutMain = (LinearLayout) itemLayoutView.findViewById(R.id.ll_book_layout);
            tvTitle = (TextView) itemLayoutView.findViewById(R.id.rd_book_each_title);
            tvDescription = (TextView) itemLayoutView.findViewById(R.id.rd_book_each_description);
            tvAuthor = (TextView) itemLayoutView.findViewById(R.id.rd_book_each_author);
            tvLibrary = (TextView) itemLayoutView.findViewById(R.id.rd_book_each_library);

            layoutMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   */
/* Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("file:///" + Environment.getExternalStorageDirectory().getPath() + "/MV_e-learning_Mar/Modules/1/story_html5.html"));
                    mContext.startActivity(browserIntent);*//*



                }
            });

          */
/*     imgshare = (ImageView) itemLayoutView.findViewById(R.id.imgshare);
         imgDownload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    trainingFragment.startDownload(getAdapterPosition());
                }
            });*//*



        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Book book = getItem(position);
        holder.tvTitle.setText("Title : "+book.getTitle());
        holder.tvDescription.setText("Description : "+book.getDescription());
        holder.tvAuthor.setText("Author : "+book.getAuthor() );
        holder.tvLibrary.setText("Library : "+book.getLibrary().getName());
        }


}
*/

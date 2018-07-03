/*
package com.example.abc.myapplication.activity;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.abc.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class SQlDEmoAdapter extends RecyclerView.Adapter<SQlDEmoAdapter.MyViewHolder> {

    ArrayList<String> menuList;
    Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView menu_name;
        public ImageView menu_icon, img_lock;
        public LinearLayout layout;
        public RelativeLayout invisiblityLayout;

        public MyViewHolder(View view) {
            super(view);

            menu_name = (TextView) view.findViewById(R.id.tv_home_menu_name);
            menu_icon = (ImageView) view.findViewById(R.id.iv_home_menu_icon);


            layout = (LinearLayout) view.findViewById(R.id.layout_home);
            invisiblityLayout = (RelativeLayout) view.findViewById(R.id.invisiblityLayout);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (menuList.get(getAdapterPosition()).getAccessible()) {
                        preferenceHelper.insertString(Constants.Leave, "");
                        Intent openClass = new Intent(mContext, menuList.get(getAdapterPosition()).getDestination());
                        mContext.startActivity(openClass);
                    } else {

                    }
                }
            });
        }

        void bindTo(String drawable) {
            menu_name.setText(drawable);
            ViewGroup.LayoutParams lp = menu_name.getLayoutParams();
            if (lp instanceof FlexboxLayoutManager.LayoutParams) {
                FlexboxLayoutManager.LayoutParams flexboxLp = (FlexboxLayoutManager.LayoutParams) lp;
                flexboxLp.setFlexGrow(1.0f);
                flexboxLp.setAlignSelf(AlignSelf.BASELINE);
                //flexboxLp.setAlignSelf(AlignSelf.FLEX_END);
            }
        }
    }


    public SQlDEmoAdapter(ArrayList<String> menuList, Context context) {
        this.menuList = menuList;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_home, parent, false);
*/
/*        int height = parent.getMeasuredHeight() / 4;
        itemView.setMinimumHeight(height);*//*

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.menu_icon.setImageResource(menuList.get(position).getMenuIcon());
        holder.bindTo(menuList.get(position).getMenuName());
        if (!menuList.get(position).getAccessible()) {
            //  holder.layout.setBackgroundColor(mContext.getColor(R.color.blue));
            // holder..setBackgroundColor(mContext.getColor(R.color.tranparant_lighter_grey));

            holder.invisiblityLayout.setVisibility(View.VISIBLE);
        } else {
            holder.invisiblityLayout.setVisibility(View.GONE);
        }

        //holder.menu_icon.setImageResource(menuList.get(position).getMenuIcon());
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public static void openActivity(Activity source, Class<?> destination) {
        Intent openClass = new Intent(source, destination);
        source.startActivity(openClass);
        source.overridePendingTransition(R.anim.right_in, R.anim.left_out);
        */
/*if (Util.isLollipop()) {
            ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(source, view, mTransitionName);
            source.startActivity(openClass, transitionActivityOptions.toBundle());
        } else {
        }*//*

    }

}*/

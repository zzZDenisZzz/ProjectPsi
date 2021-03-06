package com.psi.projectpsi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.psi.projectpsi.model.PsiModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PsiAdapter extends RecyclerView.Adapter<PsiAdapter.ViewHolder> {

    private List<PsiModel> posts;
    Context context;

    public PsiAdapter(List<PsiModel> posts,Context context) {
        this.posts = posts;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        PsiModel post = posts.get(position);
        holder.pageName.setText(post.getPageName());
        holder.name.setText(post.getName());
        holder.text.setText(post.getText());

        Picasso.get()
                .load(post.getImage())
                .resize(700,360)
                .into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ServiceActivity.class);
                intent.putExtra("position",getItemId(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (posts == null)
            return 0;
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,text,pageName;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            pageName = (TextView) itemView.findViewById(R.id.page_name);
            name = (TextView) itemView.findViewById(R.id.name);
            text = (TextView) itemView.findViewById(R.id.text);

            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }

//    class RecyclerViewListener implements RecyclerView.OnClickListener{
//
//        @Override
//        public void onClick(View view) {
//
//        }
//    }
}

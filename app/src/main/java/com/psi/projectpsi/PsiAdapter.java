package com.psi.projectpsi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.psi.projectpsi.model.PsiModel;

import java.util.List;

public class PsiAdapter extends RecyclerView.Adapter<PsiAdapter.ViewHolder> {

    private List<PsiModel> posts;

    public PsiAdapter(List<PsiModel> posts) {
        this.posts = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PsiModel post = posts.get(position);
        holder.post1.setText(post.getFirst());
        holder.post2.setText(post.getSecond());
        holder.post3.setText(post.getThird());
    }

    @Override
    public int getItemCount() {
        if (posts == null)
            return 0;
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView post1;
        TextView post2;
        TextView post3;

        public ViewHolder(View itemView) {
            super(itemView);
            post1 = (TextView) itemView.findViewById(R.id.post_one);
            post2 = (TextView) itemView.findViewById(R.id.post_two);
            post3 = (TextView) itemView.findViewById(R.id.post_three);
        }
    }
}

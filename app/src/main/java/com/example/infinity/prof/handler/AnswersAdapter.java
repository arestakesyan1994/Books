//package com.example.infinity.prof.handler;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.example.infinity.prof.model.StudentsItem;
//
//import java.util.List;
//
//public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder> {
//
//    private List<StudentsItem> studentsItems;
//    private Context mContext;
//    private PostItemListener mItemListener;
//
//    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//
//        public TextView titleTv;
//        PostItemListener mItemListener;
//
//        public ViewHolder(View itemView, PostItemListener postItemListener) {
//            super(itemView);
//            titleTv = (TextView) itemView.findViewById(android.R.id.text1);
//
//            this.mItemListener = postItemListener;
//            itemView.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View view) {
//            StudentsItem item = getStudent(getAdapterPosition());
//            this.mItemListener.onPostClick(Long.parseLong(item.getGroupId()));
//
//            notifyDataSetChanged();
//        }
//    }
//
//    public AnswersAdapter(Context context, List<StudentsItem> posts, PostItemListener itemListener) {
//        studentsItems = posts;
//        mContext = context;
//        mItemListener = itemListener;
//    }
//
//    @Override
//    public AnswersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        Context context = parent.getContext();
//        LayoutInflater inflater = LayoutInflater.from(context);
//
//        View postView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
//
//        ViewHolder viewHolder = new ViewHolder(postView, this.mItemListener);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(AnswersAdapter.ViewHolder holder, int position) {
//
//        StudentsItem item = studentsItems.get(position);
//        TextView textView = holder.titleTv;
//        textView.setText(item.getGroupId());
//    }
//
//    @Override
//    public int getItemCount() {
//        return studentsItems.size();
//    }
//
//    public void updateAnswers(List<StudentsItem> items) {
//        studentsItems = items;
//        notifyDataSetChanged();
//    }
//
//    private StudentsItem getStudent(int adapterPosition) {
//        return studentsItems.get(adapterPosition);
//    }
//
//    public interface PostItemListener {
//        void onPostClick(long id);
//    }
//}
//

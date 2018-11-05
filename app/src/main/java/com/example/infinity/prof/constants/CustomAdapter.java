//package com.example.infinity.prof.constants;
//
//import android.content.Context;
//import android.support.design.widget.Snackbar;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.infinity.prof.R;
//import com.example.infinity.prof.model.NotificationsItem;
//
//import java.util.ArrayList;
//
//public class CustomAdapter extends ArrayAdapter<NotificationsItem> implements View.OnClickListener{
//
//    private ArrayList<NotificationsItem> dataSet;
//    Context mContext;
//
//    // View lookup cache
//    private static class ViewHolder {
//        TextView txtName;
//        TextView txtType;
//        TextView txtVersion;
//        ImageView info;
//    }
//
//    public CustomAdapter(ArrayList<NotificationsItem> data, Context context) {
//        super(context, R.layout.row_item, data);
//        this.dataSet = data;
//        this.mContext=context;
//
//    }
//
//    @Override
//    public void onClick(View v) {
//
//        int position=(Integer) v.getTag();
//        Object object= getItem(position);
//        NotificationsItem notModel=(NotificationsItem)object;
//
//        switch (v.getId())
//        {
//            case R.id.textNot:
//                Snackbar.make(v, "Release date " +notModel.getText(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
//                break;
//        }
//    }
//
//    private int lastPosition = -1;
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        // Get the data item for this position
//        NotificationsItem dataModel = getItem(position);
//        // Check if an existing view is being reused, otherwise inflate the view
//        ViewHolder viewHolder; // view lookup cache stored in tag
//
//        final View result;
//
//        if (convertView == null) {
//
//            viewHolder = new ViewHolder();
//            LayoutInflater inflater = LayoutInflater.from(getContext());
//            convertView = inflater.inflate(R.layout.row_item, parent, false);
//            viewHolder.txtName = (TextView) convertView.findViewById(R.id.textNot);
//            viewHolder.txtType = (TextView) convertView.findViewById(R.id.timeNot);
//
//            result=convertView;
//
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//            result=convertView;
//        }
//
//        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
//        result.startAnimation(animation);
//        lastPosition = position;
//
//        viewHolder.txtName.setText(dataModel.getText());
//        viewHolder.txtType.setText(dataModel.getWhen());
////        viewHolder.info.setTag(position);
//        // Return the completed view to render on screen
//        return convertView;
//    }
//}

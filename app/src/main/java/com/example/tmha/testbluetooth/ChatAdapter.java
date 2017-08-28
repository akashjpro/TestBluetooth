package com.example.tmha.testbluetooth;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tmha on 8/28/2017.
 */

public class ChatAdapter extends BaseAdapter{

    private Context mContext;
    private int mLayout;
    private List<Chat> mListChat;


    public ChatAdapter(Context mContext, int mLayout, List<Chat> mListChat) {
        this.mContext = mContext;
        this.mLayout = mLayout;
        this.mListChat = mListChat;
    }

    @Override
    public int getCount() {
        return mListChat.size();
    }

    @Override
    public Object getItem(int i) {
        return mListChat.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public static class ViewHolder{
        TextView txtMessage;
        ImageView imgPhoto;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder viewHolder = new ViewHolder();
        View rowView = view;

        if (rowView == null){
            rowView = inflater.inflate(mLayout, null);
            viewHolder.txtMessage = rowView.findViewById(R.id.txtMessage);
            viewHolder.imgPhoto = rowView.findViewById(R.id.imgPhoto);

            rowView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) rowView.getTag();
        }

        if (mListChat.get(i).getmMessage() != null)
            viewHolder.txtMessage.setText(mListChat.get(i).getmMessage());
        if (mListChat.get(i).getmPhoto() != null){
            byte[] bytes = mListChat.get(i).getmPhoto();
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            viewHolder.imgPhoto.setImageBitmap(bitmap);
            viewHolder.imgPhoto.setVisibility(View.VISIBLE);
        }else {
            viewHolder.imgPhoto.setVisibility(View.GONE);
        }


        return rowView;
    }
}

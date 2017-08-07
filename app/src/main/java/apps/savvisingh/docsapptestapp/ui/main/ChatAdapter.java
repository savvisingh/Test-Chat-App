package apps.savvisingh.docsapptestapp.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import apps.savvisingh.docsapptestapp.R;
import apps.savvisingh.docsapptestapp.data.db.Message;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SavviSingh on 06/08/17.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.Holder> {

    private static final int SELF = 1;
    private static final int OTHER = 2;

    ArrayList<Message> messageArrayList;

    public ChatAdapter(ArrayList<Message> messageArrayList){
        this.messageArrayList = messageArrayList;
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messageArrayList.get(position);
        if(message.getUserType().equals("self"))
            return SELF;
        else return OTHER;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView;

        if (viewType == SELF) {
            // self message
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.message_item_self, parent, false);
        } else {
            // others message
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.message_item_other, parent, false);
        }

        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Message message = messageArrayList.get(position);

        holder.message.setText(message.getText());

        holder.timeStamp.setText(message.getCreatedAt());

    }

    @Override
    public int getItemCount() {
        return messageArrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        @BindView(R.id.message)
        TextView message;

        @BindView(R.id.timestamp)
        TextView timeStamp;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

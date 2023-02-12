package com.aavaros.whatsup.adapters;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aavaros.whatsup.databinding.ItemContainerRecievedMsgBinding;
import com.aavaros.whatsup.databinding.ItemContainerSentMessageBinding;
import com.aavaros.whatsup.databinding.ItemContainerUserBinding;
import com.aavaros.whatsup.models.ChatMessage;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final List<ChatMessage> chatMessages;
    private final Bitmap recieverProfileImage;
    private final String senderId;

    public static final int VIEW_TYPE_SENT = 1;
    public static final int VIEW_TYPE_RECIEVED = 2;

    public ChatAdapter(List<ChatMessage> chatMessages, Bitmap recieverProfileImage, String senderId) {
        this.chatMessages = chatMessages;
        this.recieverProfileImage = recieverProfileImage;
        this.senderId = senderId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_SENT)
        {
            return new SentMessageViewHolder(
                    ItemContainerSentMessageBinding.inflate(
                            LayoutInflater.from(parent.getContext()),
                            parent,
                            false
                    )
            );
        }else
        {
            return new RecievedMessageViewHolder(
                    ItemContainerRecievedMsgBinding.inflate(
                            LayoutInflater.from(parent.getContext()),
                            parent,
                            false
                    )
            );
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(getItemViewType(position) == VIEW_TYPE_SENT)
        {
            ((SentMessageViewHolder) holder).setData(chatMessages.get(position));
        }else
        {
            ((RecievedMessageViewHolder) holder).setData(chatMessages.get(position), recieverProfileImage);
        }

    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(chatMessages.get(position).senderId.equals(senderId))
        {
            return VIEW_TYPE_SENT;
        }else
        {
            return VIEW_TYPE_RECIEVED;
        }
    }

    static class SentMessageViewHolder extends RecyclerView.ViewHolder
    {
        private final ItemContainerSentMessageBinding binding;

        SentMessageViewHolder(ItemContainerSentMessageBinding itemContainerSentMessageBinding)
        {
            super(itemContainerSentMessageBinding.getRoot());
            binding = itemContainerSentMessageBinding;
        }

        void setData(ChatMessage chatMessage)
        {
            binding.txtMsg.setText(chatMessage.message);
            binding.txtDateTime.setText(chatMessage.dateTime);
        }

    }

    static class RecievedMessageViewHolder extends RecyclerView.ViewHolder
    {

        private final ItemContainerRecievedMsgBinding binding;

        RecievedMessageViewHolder(ItemContainerRecievedMsgBinding itemContainerRecievedMsgBinding)
        {
            super(itemContainerRecievedMsgBinding.getRoot());
            binding = itemContainerRecievedMsgBinding;
        }

        void setData(ChatMessage chatMessage, Bitmap recieverProfileImage)
        {

            binding.txtMsg.setText(chatMessage.message);
            binding.txtDateTime.setText(chatMessage.dateTime);
            binding.imgProPic.setImageBitmap(recieverProfileImage);

        }

    }

}

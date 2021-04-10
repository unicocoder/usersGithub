package com.unicocoder.usergithub.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.unicocoder.usergithub.R;
import com.unicocoder.usergithub.databinding.RowUsersItemBinding;
import com.unicocoder.usergithub.model.User;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ListUserViewHolder> {

    private List<User> userList;

    private OnClickItem onClickItem;
    public interface OnClickItem{
        void onItem(User userList, ImageView imageView);
    }

    public ListUserAdapter(List<User> userList, OnClickItem onClickItem) {
        this.userList = userList;
        this.onClickItem = onClickItem;
    }

    @NotNull
    @Override
    public ListUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RowUsersItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.row_users_item, parent, false);
        return new ListUserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListUserViewHolder holder, int position) {

        holder.binding.setUser(userList.get(position));

        holder.binding.cvRowUserItemParent.setOnClickListener(v ->
                onClickItem.onItem(userList.get(position), holder.binding.ivRowUserItemImage));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class ListUserViewHolder extends RecyclerView.ViewHolder {
        RowUsersItemBinding binding;

        public ListUserViewHolder(@NonNull RowUsersItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

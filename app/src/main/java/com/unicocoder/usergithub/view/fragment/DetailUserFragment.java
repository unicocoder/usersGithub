package com.unicocoder.usergithub.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.ActivityNavigator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unicocoder.usergithub.R;
import com.unicocoder.usergithub.databinding.FragmentDetailUesrBinding;
import com.unicocoder.usergithub.model.User;
import com.unicocoder.usergithub.utils.OnBackPressedListner;

import org.jetbrains.annotations.NotNull;

import static com.unicocoder.usergithub.R.id.action_ListUserFragment_to_DetailUesrFragment;

public class DetailUserFragment extends Fragment {

    private FragmentDetailUesrBinding binding;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_uesr, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null)
            binding.setDetail(getArguments().getParcelable("userItem"));
    }

}
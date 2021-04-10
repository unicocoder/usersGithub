package com.unicocoder.usergithub.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.unicocoder.usergithub.R;
import com.unicocoder.usergithub.ViewModel.UserListViewModel;
import com.unicocoder.usergithub.databinding.FragmentListUserBinding;
import com.unicocoder.usergithub.model.User;
import com.unicocoder.usergithub.utils.NetworkConnected;
import com.unicocoder.usergithub.view.adapter.ListUserAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.unicocoder.usergithub.R.id.action_ListUserFragment_to_DetailUesrFragment;

public class ListUserFragment extends Fragment {

    private FragmentListUserBinding binding;
    private ListUserAdapter listUserAdapter;
    private NavController navController;
    private UserListViewModel userListViewModel;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_user, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userListViewModel = new ViewModelProvider(requireActivity()).get(UserListViewModel.class);

        NavHostFragment navHost = (NavHostFragment) requireActivity().getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
        assert navHost != null;
        navController = navHost.getNavController();

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);
        binding.rcListUsersShowList.setLayoutManager(linearLayoutManager);

        getUsers();

        setError();

    }

    private void setError() {
        userListViewModel.errorMutableLiveData.observe(getViewLifecycleOwner(), integer -> {
            if (integer == 0)
                Toast.makeText(requireActivity(), "دریافت اطلاعات از سرور با مشکل مواجه شده است", Toast.LENGTH_SHORT).show();
            else if (integer == -1)
                Toast.makeText(requireActivity(), "ارتباط با سرور با مشکل مواجه شده است", Toast.LENGTH_SHORT).show();

            userListViewModel.errorMutableLiveData.removeObservers(getViewLifecycleOwner());
        });
    }

    private void getUsers() {
        if (NetworkConnected.getInstance(requireActivity())) {
            userListViewModel.getListUser().observe(getViewLifecycleOwner(), users -> {
                if (users != null) {
                    binding.pbListUsersLoading.setVisibility(View.GONE);
                    binding.rcListUsersShowList.setVisibility(View.VISIBLE);

                    listUserAdapter = new ListUserAdapter(users, (item, imageView) -> {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("userItem", item);

                        FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
                                .addSharedElement(imageView, "hero_image")
                                .build();

                        navController.navigate(action_ListUserFragment_to_DetailUesrFragment
                                , bundle
                                , null
                                , extras);
                    });

                    binding.rcListUsersShowList.setAdapter(listUserAdapter);

                    userListViewModel.getListUser().removeObservers(getViewLifecycleOwner());
                }
            });

        } else
            Toast.makeText(requireActivity(), "از اتصال به شبکه اینترنت اطمینان حاصل کنید", Toast.LENGTH_SHORT).show();
    }
}
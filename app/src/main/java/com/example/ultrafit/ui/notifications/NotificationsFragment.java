package com.example.ultrafit.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ultrafit.EditActivity;
import com.example.ultrafit.MainActivity;
import com.example.ultrafit.R;
import com.example.ultrafit.RegisterActivity;

public class NotificationsFragment extends Fragment implements View.OnClickListener {

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_users, container, false);

        Button editBtn = (Button)root.findViewById(R.id.edit_button);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), RegisterActivity.class);
                getActivity().startActivity(intent);
            }
        });

        return root;
    }

    public void onProfile() {
        Intent intent = new Intent();
        intent.setClass(getActivity(), EditActivity.class);
        getActivity().startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }
}
package com.example.ultrafit.ui.exercises;
import com.example.ultrafit.ObjectivesHandler;
import com.example.ultrafit.RegisterActivity;
import com.example.ultrafit.Routine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ultrafit.R;
import com.example.ultrafit.User;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ExercisesFragment extends Fragment {



    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_exercises, container, false);

        createButtons(root, User.getInstance().getObjective());

        return root;
    }

    public void createButtons(View view, int id){
        List<Routine> list = getObjective(id);
        for (int i = 0; i < list.size(); i++){
            addButton(view, list.get(i), i);
        }
    }

    public List<Routine> getObjective(int id){
        List<Routine> list = new ArrayList<Routine>();
        switch (id){
            case 0:
                list = ObjectivesHandler.getInstance().getAdelgazarObjective();
                break;
            case 1:
                list = ObjectivesHandler.getInstance().getTonificarObjective();
                break;
        }
        return list;
    }

    public void addButton(View view, final Routine routine, final int id){

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.main_layout);

        final Button btnTag = new Button(this.getContext());
        btnTag.setId(id);
        btnTag.setBackgroundResource(getResId(routine.getResourceId(), R.drawable.class));
        btnTag.setHeight(400);

        btnTag.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent();
                                        intent.putExtra("routine", routine);
                                        intent.setClass(getActivity(), ExercisesListActivity.class);
                                        getActivity().startActivity(intent);
                                    }
                                });
        layout.addView(btnTag);
    }

    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


}
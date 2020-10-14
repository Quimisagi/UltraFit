package com.example.ultrafit;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class ExerciseDisplayLayout extends View {

    private TextView exerciseName;
    private TextView repsText;
    public ExerciseDisplayLayout(Context context) {
        super(context);
        init(context, null);

    }

    public ExerciseDisplayLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ExerciseDisplayLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ExerciseDisplayLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ExerciseDisplayLayout, defStyleAttr, 0);

        String exerciseName = a.getString(R.styleable.ExerciseDisplayLayout_exercise_name);
        String reps = a.getString(R.styleable.ExerciseDisplayLayout_reps);

        a.recycle();

        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs){
        exerciseName = (TextView) findViewById(R.id.exercise_name);
        repsText = (TextView) findViewById(R.id.reps);
    }
}

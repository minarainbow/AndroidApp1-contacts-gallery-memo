package com.example.user.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ThirdTab extends Fragment {
    public ThirdTab() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    EditText mMemoEdit = null;
    TextFileManager mTextFileManager = null;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ConstraintLayout layout = (ConstraintLayout) inflater.inflate(R.layout.fragment3,container, false);

        mMemoEdit = null;
        mTextFileManager = new TextFileManager(getContext());

        View view = inflater.inflate(R.layout.fragment3, container, false);
        mMemoEdit=(EditText) view.findViewById(R.id.memo_edit);

        Button button1 = (Button)view.findViewById(R.id.load_btn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String memoData = mTextFileManager.load();
               mMemoEdit.setText(memoData);
               Toast.makeText(getActivity(), "Successfully loaded", Toast.LENGTH_LONG).show();
            }
        });

        Button button2 = (Button)view.findViewById(R.id.save_btn);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String memoData = mMemoEdit.getText().toString();
                 mTextFileManager.save(memoData);
                 mMemoEdit.setText("");
                Toast.makeText(getActivity(), "Successfully saved", Toast.LENGTH_LONG).show();
            }
        });

        Button button3 = (Button)view.findViewById(R.id.delete_btn);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextFileManager.delete();
                mMemoEdit.setText("");
                Toast.makeText(getActivity(), "Successfully deleted", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}

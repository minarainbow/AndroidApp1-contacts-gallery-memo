package com.example.user.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

//import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import com.google.gson.Gson;


/*
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by user on 2017-12-26.
 */
/*
public class FirstTab extends Activity{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        String activityName = getClass().getSimpleName();

        TextView tv = new TextView(this);
        tv.setText(activityName + "화면");
        setContentView(tv);
    }
}

package com.example.kjh.viewpager_fragment;
*/


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class FirstTab extends Fragment {
    public FirstTab()
    {
        // required
    }



    static final String[] LIST_MENU = {"LIST1", "LIST2", "LIST3"} ;
    // ... 코드 계속

    private ArrayList<Map<String, String>> dataList;

    private ListView mListview;

    @Override
    public ListView onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_content_provider);

        View view = inflater.inflate(R.layout.fragment1,container,false);

        mListview = view.findViewById(R.id.listview);
        ((ViewGroup) mListview.getParent()).removeView(mListview);

        //mBtnAddress = (Button) findViewById(R.id.btnAddress);

        //mBtnAddress.setOnClickListener(this);
        dataList = new ArrayList<Map<String, String>>();

        Cursor c = getActivity().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,

                null, null, null,

                ContactsContract.Contacts.DISPLAY_NAME_PRIMARY + " asc");


        while (c.moveToNext()) {

            HashMap<String, String> map = new HashMap<String, String>();

            // 연락처 id 값

            String id = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));

            // 연락처 대표 이름

            String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));

            map.put("name", name);


            // ID로 전화 정보 조회

            Cursor phoneCursor = getActivity().getContentResolver().query(

                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,

                    null,

                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,

                    null, null);


            // 데이터가 있는 경우

            if (phoneCursor.moveToFirst()) {

                String number = phoneCursor.getString(phoneCursor.getColumnIndex(

                        ContactsContract.CommonDataKinds.Phone.NUMBER));

                map.put("phone", number);

            }


            phoneCursor.close();

            dataList.add(map);

        }// end while

        c.close();


        SimpleAdapter adapter = new SimpleAdapter(getActivity().getApplicationContext(),

                dataList,

                android.R.layout.simple_list_item_2,

                new String[]{"name", "phone"},

                new int[]{android.R.id.text1, android.R.id.text2});

        mListview.setAdapter(adapter);
        return mListview;
    }


        }


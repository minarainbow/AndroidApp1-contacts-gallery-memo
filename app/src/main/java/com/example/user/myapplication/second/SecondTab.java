package com.example.user.myapplication;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;

public class SecondTab extends Fragment {
    public SecondTab()
    {
        // required
    }

    private int[] imageIDs = new int[]{
            R.drawable.gallery_image_01,
            R.drawable.gallery_image_02,
            R.drawable.gallery_image_03,
            R.drawable.gallery_image_04,
            R.drawable.gallery_image_05,
            R.drawable.gallery_image_06,
            R.drawable.gallery_image_07,
            R.drawable.gallery_image_08,
            R.drawable.gallery_image_09,
            R.drawable.gallery_image_10,
            R.drawable.gallery_image_11,
            R.drawable.gallery_image_12,
            R.drawable.gallery_image_13,
            R.drawable.gallery_image_14,
            R.drawable.gallery_image_15,
            R.drawable.gallery_image_16,
            R.drawable.gallery_image_01,
            R.drawable.gallery_image_02,
            R.drawable.gallery_image_03,
            R.drawable.gallery_image_04,
            R.drawable.gallery_image_05,
            R.drawable.gallery_image_06,
            R.drawable.gallery_image_07,
            R.drawable.gallery_image_08,
            R.drawable.gallery_image_09,
            R.drawable.gallery_image_10,
            R.drawable.gallery_image_11,
            R.drawable.gallery_image_12,
            R.drawable.gallery_image_13,
            R.drawable.gallery_image_14,
            R.drawable.gallery_image_15,
            R.drawable.gallery_image_16
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.fragment2, container, false);
        View myfragmentView = inflater.inflate(R.layout.fragment2,container,false);
        GridView gridViewImages = (GridView) myfragmentView.findViewById(R.id.gridViewImages);
        com.example.user.myapplication.ImageGridAdapter imageGridAdapter = new com.example.user.myapplication.ImageGridAdapter(getActivity(), imageIDs);
        gridViewImages.setAdapter(imageGridAdapter);

        return myfragmentView;
    }
}

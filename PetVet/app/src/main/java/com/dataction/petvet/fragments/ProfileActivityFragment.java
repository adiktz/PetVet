package com.dataction.petvet.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.dataction.petvet.R;
import com.dataction.petvet.models.Users;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */

public class ProfileActivityFragment extends Fragment {

    @Bind(R.id.txtEmail)
    EditText email;
    @Bind(R.id.txtMobile)
    EditText mobile;
    @Bind(R.id.personalWidget)
    CardView personalWidget;

    public ProfileActivityFragment() {
    }

    public static ProfileActivityFragment newInstance() {

        Bundle args = new Bundle();

        ProfileActivityFragment fragment = new ProfileActivityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        email.setEnabled(false);
        email.setFocusable(false);
        mobile.setEnabled(false);
        mobile.setFocusable(false);


        Users users = Users.getInstance();
        email.setText(users.getEmail());
        if(users.getNumber()!=0)
            mobile.setText(users.getNumber());
//        mobile.setText(users.getNumber());
        /*if(!TextUtils.isEmpty(users.getEmail())){
            email.setText(users.getEmail());
        }*/

        Integer number = null;

        try {
            number = Integer.valueOf(users.getNumber());
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }

        /*if (number != null) {
            mobile.setText(number + "");
        }else{
            mobile.setText("");
        }*/
    }

    public void setUpProfileEdit(){
        personalWidget.setVisibility(View.VISIBLE);
    }

}

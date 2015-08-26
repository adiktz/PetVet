package com.dataction.petvet.fragments;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.dataction.petvet.R;
import com.dataction.petvet.models.Users;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUpFragment extends Fragment {

    @Bind(R.id.txtFirstName)
    EditText firstName;
    @Bind(R.id.txtLastName)
    EditText lastName;
    @Bind(R.id.txtEmailSignup)
    EditText email;
    @Bind(R.id.txtsignUpPassword)
    EditText password;
    @Bind(R.id.txtConfirmPassword)
    EditText confirmPassword;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignUpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignUpFragment newInstance() {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btnSignup)
    public void submit(View view){
        if(!TextUtils.isEmpty(password.getText()) && (password.getText().toString()).equals(confirmPassword.getText().toString())){
            Users user = new Users();
            user.setEmail(email.getText().toString());
            user.setFirstName(firstName.getText().toString());
            user.setLastName(lastName.getText().toString());
            user.setPassword(password.getText().toString());
            //TODO: Implement network call after this.

        }else{
            Snackbar.make(getView(),"Password do not match",Snackbar.LENGTH_LONG).show();
        }
    }

}

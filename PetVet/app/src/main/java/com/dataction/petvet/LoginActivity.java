package com.dataction.petvet;


import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dataction.petvet.fragments.LoginActivityFragment;
import com.dataction.petvet.fragments.SignUpFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginActivityFragment.OnFragmentInteractionListener{

    @Bind(R.id.toolbar_login)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        // Show the login form
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment,
                    LoginActivityFragment.newInstance()).commit();
        }

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                } else {
                //    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Bundle bundle) {
        int button = bundle.getInt("bundle");
        if(button == 1){
            startActivity(new Intent(this, DashboardActivity.class));
            finish();
        }

        if(button != 1){

//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            // Show the signup form, but keep the transaction on the back stack
            // so that if the user clicks the back button, they are brought back
            // to the login form.
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment,
                    SignUpFragment.newInstance());
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}

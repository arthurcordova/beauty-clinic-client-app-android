package br.com.artechapps.app.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.artechapps.app.R;
import br.com.artechapps.app.fragment.EventFragment;
import br.com.artechapps.app.fragment.MessageFragment;
import br.com.artechapps.app.fragment.MoneyFragment;
import br.com.artechapps.app.fragment.ProductFragment;
import br.com.artechapps.app.model.User;
import br.com.artechapps.app.utils.SessionManager;

public class MainMenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView mTvHeaderUserName;
    private TextView mTvHeaderUserEmail;
    private SessionManager mSM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mSM = new SessionManager(this);
        User user = mSM.getSessionUser();

//        mTvHeaderUserName = (TextView) findViewById(R.id.header_user_name);
//        mTvHeaderUserEmail = (TextView) findViewById(R.id.header_user_email);
//        mTvHeaderUserName.setText(user.getName());
//        mTvHeaderUserEmail.setText(user.getCpfcnpj());


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_logout:
//
//                break;
//
//        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_message :
                replaceFragment(new MessageFragment());
                break;
            case R.id.nav_event :
                replaceFragment(new EventFragment());
                break;
            case R.id.nav_products :
                replaceFragment(new ProductFragment());
                break;
            case R.id.nav_money :
                replaceFragment(new MoneyFragment());
                break;
            case R.id.nav_about :
                break;
            case R.id.nav_logout :
                SessionManager sm = new SessionManager(MainMenuActivity.this);
                sm.destroySessionLogin(SplashActivity.class);
                break;

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }
}
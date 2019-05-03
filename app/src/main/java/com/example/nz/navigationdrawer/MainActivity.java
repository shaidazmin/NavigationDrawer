package com.example.nz.navigationdrawer;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
      //  getSupportActionBar().hide();
    }
// navigation er cinno dekhanor jonno......
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (toggle.onOptionsItemSelected(item)){
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }
// back button er jonno......
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            this.finish();
        }
        return super.onContextItemSelected(item);
    }
// navigation item er jonno......
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
     /*   FragmentManager fragmentManager = getSupportFragmentManager();
        CustomAdapter adapter = new CustomAdapter(fragmentManager);
        if(item.getItemId()==R.id.home){
            Fragment fragment = NewFragment();


        }*/

        Fragment selectedfragment = null;

        switch (item.getItemId()){
            case R.id.shaer:
                selectedfragment = new NewFragment();
                break;
            case R.id.homeid:
                selectedfragment = new NewFragment();
                break;

        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentId,selectedfragment).commit();

      /*  if(item.getItemId()== R.id.home){

            selectedfragment = new NewFragment();
          // getFragmentManager().beginTransaction().replace(R.id.fragmentId,selectedfragment).commit();

        }
        else  if(item.getItemId() == R.id.about){
            Toast.makeText(MainActivity.this,"About",Toast.LENGTH_SHORT).show();
        }*/



        return  true;
    }
}

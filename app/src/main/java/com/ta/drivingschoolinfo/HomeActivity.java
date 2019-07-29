package com.ta.drivingschoolinfo;


import android.support.annotation.NonNull;
import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.ta.drivingschoolinfo.Fragment.fragment_home;
import com.ta.drivingschoolinfo.Fragment.fragment_info;



public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

            //Menampilkan halaman Fragment yang pertama kali muncul
            getFragmentPage(new fragment_home());



            /*Inisialisasi BottomNavigationView beserta listenernya untuk
             *menangkap setiap kejadian saat salah satu menu item diklik
             */
            BottomNavigationView bottomNavigation = findViewById(R.id.btm_nav);
            bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment fragment = null;

                    //Menantukan halaman Fragment yang akan tampil
                    switch (item.getItemId()){
                        case R.id.home_menu:
                            fragment = new fragment_home();
                            break;

                        case R.id.info_menu:
                            fragment = new fragment_info();
                            break;

                        case R.id.login_menu:
                            Intent i= new Intent(HomeActivity.this,LoginActivity.class);
                            startActivity(i);
                            break;

                    }
                    return getFragmentPage(fragment);
                }
            });
        }

        //Menampilkan halaman Fragment

        private boolean getFragmentPage(Fragment fragment){
            if (fragment != null){
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.page_container, fragment)
                        .commit();
                return true;
            }
            return false;
        }
    }
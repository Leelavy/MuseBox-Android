package com.lilo.museboxapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lilo.museboxapp.R;
import com.lilo.museboxapp.fragments.CommentsListFragment;
import com.lilo.museboxapp.fragments.FeedListFragment;
import com.lilo.museboxapp.fragments.FeedListFragmentDirections;
import com.lilo.museboxapp.model.Post;

public class HomeActivity extends AppCompatActivity implements FeedListFragment.Delegate {

    NavController navCtrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navCtrl = Navigation.findNavController(this, R.id.home_nav_host);
        BottomNavigationView bottomNav = findViewById(R.id.home_bottom_nav);
        NavigationUI.setupWithNavController(bottomNav, navCtrl);
    }

    @Override
    public void onItemSelected(Post post) {
        navCtrl = Navigation.findNavController(this, R.id.home_nav_host);
        FeedListFragmentDirections.ActionFeedListFragmentToPostDetailsFragment directions = FeedListFragmentDirections.actionFeedListFragmentToPostDetailsFragment(post);
        navCtrl.navigate(directions);
    }
}
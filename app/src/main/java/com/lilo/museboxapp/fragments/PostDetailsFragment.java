package com.lilo.museboxapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.lilo.museboxapp.R;
import com.lilo.museboxapp.model.Model;
import com.lilo.museboxapp.model.Post;
import com.lilo.museboxapp.model.StoreModel;
import com.lilo.museboxapp.model.User;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostDetailsFragment extends Fragment {

    Post post;
    View view;
    TextView postTitle;
    TextView username;
    TextView postContent;
    TextView contact;
    ImageView postImg;
    ImageButton closeBtn;
    ImageButton editPostBtn;
    ImageButton deletePostBtn;
    CircleImageView profilePic;

    public PostDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_post_details, container, false);
        postTitle = view.findViewById(R.id.post_details_fragment_title_text_view);
        username = view.findViewById(R.id.post_details_fragment_username_text_view);
        postContent = view.findViewById(R.id.post_details_fragment_post_content_text_view);
        contact = view.findViewById(R.id.post_details_fragment_contact_text_view);
        postImg = view.findViewById(R.id.post_details_fragment_post_image_view);
        profilePic = view.findViewById(R.id.post_details_fragment_profile_image_view);

        post = PostDetailsFragmentArgs.fromBundle(getArguments()).getPost();
        if (post != null) {
            postTitle.setText(post.postTitle);
            username.setText(post.username);
            postContent.setText(post.postContent);
            contact.setText("Contact: " + post.contact);
            if (post.postImgUrl != null && post.userProfileImageUrl != null){
                Picasso.get().load(post.postImgUrl).noPlaceholder().into(postImg);
                Picasso.get().load(post.userProfileImageUrl).noPlaceholder().into(profilePic);
            }
            else {
                postImg.setImageResource(R.drawable.profile_pic_placeholder);
                profilePic.setImageResource(R.drawable.profile_pic_placeholder);
            }
        }

        closeBtn = view.findViewById(R.id.post_details_fragment_close_btn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navCtrl = Navigation.findNavController(view);
                navCtrl.popBackStack();
            }
        });

        editPostBtn = view.findViewById(R.id.post_details_fragment_edit_btn);
        editPostBtn.setVisibility(View.INVISIBLE);
        deletePostBtn = view.findViewById(R.id.post_details_fragment_delete_btn);
        deletePostBtn.setVisibility(View.INVISIBLE);

        if (post.userId.equals(User.getInstance().userId)) {

            editPostBtn.setVisibility(View.VISIBLE);
            editPostBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "Edit button clicked", Toast.LENGTH_SHORT).show();
                }
            });

            deletePostBtn.setVisibility(View.VISIBLE);
            deletePostBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deletePost(post);
                    Toast.makeText(getContext(), "Delete button clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }

        return view;
    }

    void deletePost(Post postToDelete){

        Model.instance.deletePost(postToDelete, new Model.Listener<Boolean>() {
            @Override
            public void onComplete(Boolean data) {
                NavController navCtrl = Navigation.findNavController(view);
                navCtrl.navigateUp();
            }
        });
    }

}
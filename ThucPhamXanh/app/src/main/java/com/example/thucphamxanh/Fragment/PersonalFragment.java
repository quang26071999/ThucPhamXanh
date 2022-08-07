package com.example.thucphamxanh.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thucphamxanh.Activity.MainActivity;
import com.example.thucphamxanh.Activity.SignInActivity;
import com.example.thucphamxanh.Fragment.Profile.ProfileFragment;
import com.example.thucphamxanh.Model.User;
import com.example.thucphamxanh.R;
import com.example.thucphamxanh.databinding.FragmentPersonalBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PersonalFragment extends Fragment {
    FragmentPersonalBinding binding;
    Button btn_logout_personal, btn_changepassword_personal;
    TextView tvNumberPhoneUser, tvEdit;
    ImageView imgUser;
    List<User> listUser = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        getUser();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("My_User", Context.MODE_PRIVATE);
//        View view = inflater.inflate(R.layout.fragment_personal, container, false);
        binding = FragmentPersonalBinding.inflate(inflater, container, false);
        btn_logout_personal = binding.btnPersonalFragmentLogoutPersonal;
        btn_changepassword_personal = binding.btnPersonalFragmentChangePasswordPersonal;
        tvNumberPhoneUser = binding.tvPersonalFragmentNumberPhoneUser;
        tvNumberPhoneUser.setText(sharedPreferences.getString("username",""));
        tvEdit = binding.tvPersonalFragmentEditUser;
        imgUser = binding.imgPersonalFragmentImgUser;
//        User user = listUser.get(0);
//        if (user.getStrUriAvatar()!=""){
//            byte[] imgByte = Base64.decode(user.getStrUriAvatar(),Base64.DEFAULT);
//            Bitmap bitmap = BitmapFactory.decodeByteArray(imgByte,0,imgByte.length);
//            imgUser.setImageBitmap(bitmap);
//        }else {
//            imgUser.setImageResource(R.drawable.ic_avatar_default);
//        }
        tvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
//        imgUser.setOnClickListener(view -> {
//            Toast.makeText(getContext(), "imgUser.getS00ourceLayoutResId()",Toast.LENGTH_SHORT).show();
//        });

        btn_logout_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SignInActivity.class);
                startActivity(intent);
                getActivity().finishAffinity();
            }
        });

        btn_changepassword_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout, new ChangePasswordFragment()).addToBackStack(null).commit();
            }
        });

        tvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout, new ProfileFragment()).addToBackStack(null).commit();
            }
        });

        return binding.getRoot();
    }
//    public void getUser(){
//        SharedPreferences sharedPreferences = getContext().getSharedPreferences("My_User", Context.MODE_PRIVATE);
//        String id = sharedPreferences.getString("id","");
//        Log.d("username", String.valueOf(id));
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference reference = database.getReference("User");
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot snap : snapshot.getChildren()){
//                    User user1 = snap.getValue(User.class);
//                    if (id.equals(user1.getPhoneNumber())){
//                        listUser.add(user1);
//                    }
//                }
//                Log.d("size", String.valueOf(listUser.size()));
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
}
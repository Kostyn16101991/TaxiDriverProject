package ua.step.kostyn.taxidriverproject.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import ua.step.kostyn.taxidriverproject.R;
import ua.step.kostyn.taxidriverproject.models.DriverModel;

/**
 * Created by konstantin on 27.05.17.
 */

public class SingUpFragment extends BaseFragment {
    @BindView(R.id.user_avatar)
    CircleImageView user_avatar;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_last_name)
    EditText etLastName;
    @BindView(R.id.sp_sex)
    Spinner spSex;
    @BindView(R.id.sp_age)
    Spinner spAge;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_conf_password)
    EditText etConfPassword;
    @BindView(R.id.et_car_model)
    EditText etCarModel;
    @BindView(R.id.et_num_plate)
    EditText etNumPlate;

    private DriverModel driverModel = new DriverModel();
    static final int galleryRequest = 1;

    public static SingUpFragment newInstance() {
        return new SingUpFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sing_up_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void createUserId() {
        mReference = mDatabase.getReference("users");
        Query lastQuery = mReference.orderByKey().limitToLast(1);
        lastQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapsHot : dataSnapshot.getChildren()) {
                    driverModel.setIdUser(Integer.parseInt(snapsHot.getKey()) + 1);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @OnClick(R.id.btn_create_account)
    public void btnCreateAccount() {
        mReference = mDatabase.getReference("users");
//        if (validation(etName) && validation(etLastName)
//                && validation(etEmail) && validation(etPassword)
//                && confirmPasswordValidation(etConfPassword,  etConfPassword)
//                && validation(etCarModel) && validation(etNumPlate)){
//
//
//        }
        setDataInDriverModel();
        mReference.child(String.valueOf(driverModel.getIdUser())).setValue(driverModel);
    }


    public void setDataInDriverModel(){
        createUserId();
        driverModel.setNameUser(etName.getText().toString());
        driverModel.setLastNameUser(etLastName.getText().toString());
        driverModel.setSexUser(spAge.getSelectedItem().toString());
        driverModel.setAgeUser(spSex.getSelectedItem().toString());
        driverModel.setEmailUser(etEmail.getText().toString());
        driverModel.setPasswordUser(etPassword.getText().toString());
        driverModel.setCarModelDriver(etCarModel.getText().toString());
        driverModel.setNumPlateCarDriver(etNumPlate.getText().toString());
    }

    ///UserAvatar///

    @OnClick(R.id.user_avatar)
    public void setAvatar() {
        Intent photoPicerIntent = new Intent(Intent.ACTION_PICK);
        photoPicerIntent.setType("image/*");
        startActivityForResult(photoPicerIntent, galleryRequest);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = null;
        switch (requestCode) {
            case galleryRequest:
                Uri selectedImage = data.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //user_avatar.setImageURI(selectedImage);
                user_avatar.setImageBitmap(bitmap);
        }
    }
}

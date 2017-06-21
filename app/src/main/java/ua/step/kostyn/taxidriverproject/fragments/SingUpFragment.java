package ua.step.kostyn.taxidriverproject.fragments;

import android.app.Activity;
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
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import ua.step.kostyn.taxidriverproject.R;
import ua.step.kostyn.taxidriverproject.models.DriverModel;

/**
 * Created by konstantin on 27.05.17.
 */

public class SingUpFragment extends BaseFragment {
    private final int GALLERY_REQUEST = 1;
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
    @BindView(R.id.et_phone)
    EditText etPhone;
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
    @BindView(R.id.et_experience)
    EditText etExperience;


    private DriverModel driverModel = new DriverModel();
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

    @OnClick(R.id.btn_create_account)
    public void btnCreateAccount() {
        mReference = mDatabase.getReference("users");
        if (validation(etName) && validation(etLastName)
                && validation(etEmail) && validation(etPassword)
                && confirmPasswordValidation(etConfPassword, etPassword)
                && validation(etCarModel) && validation(etNumPlate)) {
            setDataInDriverModel();
            mReference.child(String.valueOf(driverModel.getIdUser())).setValue(driverModel);
        } else {

        }

    }


    public void setDataInDriverModel() {
        int id = new Random().nextInt() + new Random().nextInt();
        driverModel.setIdUser(id);
        driverModel.setNameUser(etName.getText().toString());
        driverModel.setLastNameUser(etLastName.getText().toString());
        driverModel.setSexUser(spSex.getSelectedItem().toString());
        driverModel.setAgeUser(spAge.getSelectedItem().toString());
        driverModel.setPhoneUser(etPhone.getText().toString());
        driverModel.setEmailUser(etEmail.getText().toString());
        driverModel.setPasswordUser(etPassword.getText().toString());
        driverModel.setCarModelDriver(etCarModel.getText().toString());
        driverModel.setNumPlateCarDriver(etNumPlate.getText().toString());
        driverModel.setExperienceDriver(Double.valueOf((etExperience.getText()).toString()));
        DriverModel.Driver.setDriverModel(driverModel);
    }

    ///UserAvatar///
    @OnClick(R.id.user_avatar)
    public void setAvatar() {
        startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI), GALLERY_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case GALLERY_REQUEST:
            if (resultCode == Activity.RESULT_OK){
                try {
                    user_avatar.setImageBitmap(MediaStore.Images.Media.getBitmap(this.getActivity().getContentResolver(), data.getData()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String link = String.valueOf(data.getData());
    }

    private void photoToString() {

    }
}

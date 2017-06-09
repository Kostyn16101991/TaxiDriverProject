package ua.step.kostyn.taxidriverproject.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import butterknife.BindView;
import butterknife.OnClick;
import ua.step.kostyn.taxidriverproject.DriverActivity;
import ua.step.kostyn.taxidriverproject.MainActivity;
import ua.step.kostyn.taxidriverproject.R;
import ua.step.kostyn.taxidriverproject.models.DriverModel;
import ua.step.kostyn.taxidriverproject.models.TestModel;

/**
 * Created by konstantin on 27.05.17.
 */

public class SingInFragment extends BaseFragment {
    @BindView(R.id.et_login)
    EditText etLogin;
    @BindView(R.id.et_password)
    EditText etPassword;
    private ProgressDialog progressDialog;


    public static SingInFragment newInstance() {
        return new SingInFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sing_in_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.tv_link_sing_up)
    public void createAccount() {
        ((MainActivity) getActivity()).changeFragment(SingUpFragment.newInstance());
    }

    @OnClick(R.id.btn_login)
    public void btnLogin() {
        if (validation(etLogin) && validation(etPassword)) {
            progressDialogShow();
            checkUserInDB();
            System.out.println("good");
        }
    }

    public void checkUserInDB() {
        mReference = mDatabase.getReference("users");
        mReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println(dataSnapshot.getChildren());
                for (DataSnapshot snapsHot : dataSnapshot.getChildren()) {
                    System.out.println(snapsHot.getValue().toString());
                    if (checkUserExistInDB(snapsHot)){
                        DriverModel.Driver.setDriverModel(gson.fromJson(snapsHot.getValue().toString(), DriverModel.class));
                        startActivity(new Intent(getActivity(),DriverActivity.class));
                        DriverModel driverModel = gson.fromJson(snapsHot.getValue().toString(), DriverModel.class);
                        System.out.println("DriverModel"+ driverModel);

                    } else {
                        makeToast("invalid email / password");
                        progressDialogDismiss();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });
    }

    private boolean checkUserExistInDB(DataSnapshot dataSnapshot) {
        System.out.println(etLogin.getText().toString());
        return ((etLogin.getText().toString().equals((gson.fromJson(dataSnapshot.getValue().toString(), DriverModel.class)).getEmailUser()) ||
                etLogin.getText().toString().equals((gson.fromJson(dataSnapshot.getValue().toString(), DriverModel.class)).getPhoneUser())) &&
                etPassword.getText().toString()
                        .equals((gson.fromJson(dataSnapshot.getValue().toString(), DriverModel.class)).getPasswordUser()));
    }

    private void progressDialogShow(){
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Autentification...");
        progressDialog.show();
    }

    private void progressDialogDismiss(){
        progressDialog.dismiss();
    }
}

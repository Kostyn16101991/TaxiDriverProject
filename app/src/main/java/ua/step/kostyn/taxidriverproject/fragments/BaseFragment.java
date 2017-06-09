package ua.step.kostyn.taxidriverproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.regex.Pattern;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ua.step.kostyn.taxidriverproject.R;


/**
 * Created by konstantin on 27.05.17.
 */

public class BaseFragment extends Fragment {
    public Unbinder unbinder;
    public FirebaseDatabase mDatabase;
    public DatabaseReference mReference;
    public GsonBuilder builder;
    public Gson gson;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        mDatabase = FirebaseDatabase.getInstance();
        builder = new GsonBuilder();
        gson = builder.create();
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    protected boolean validation(EditText editText) {
        if (editText.getId() == R.id.et_login) {
            if (!isValidEmail(editText.getText().toString())) {
                editText.setError("wrong email");
                return false;
            }
        } else if (editText.getId() == R.id.et_password) {
            if (!isdValidPassword(editText.getText().toString())) {
                editText.setError("password should contain lowercase letters and numbers and be at least 6 characters");
                return false;
            }
        } else if (editText.getText().toString().isEmpty()) {
            editText.setError("can't be empty fields");
            return false;
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        boolean isValid;
        isValid = Patterns.EMAIL_ADDRESS.matcher(email).matches();
        if (!isValid) {
            isValid = Patterns.PHONE.matcher(email).matches();
        }
        return isValid;
    }

    private boolean isdValidPassword(String password) {
        boolean isValid = false;
        if (Pattern.compile("([A-Za-z0-9]){6,15}").matcher(password).matches()) {
            if (Pattern.compile("([A-Z])+").matcher(password).find()
                    && Pattern.compile("([0-9])+").matcher(password).find()) {
                isValid = true;
            }
        }
        return isValid;
    }

    protected void makeToast(String message){
        Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
    }
}

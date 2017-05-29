package ua.step.kostyn.taxidriverproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ua.step.kostyn.taxidriverproject.R;


/**
 * Created by konstantin on 27.05.17.
 */

public class BaseFragment extends Fragment {
    public Unbinder unbinder;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    public boolean validation(EditText editText) {
        if (editText.getId() == R.id.et_login) {
            if (!isValidEmail(editText.getText().toString())) {
                editText.setError("the value of \"E-mail\" is not valid");
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
        isValid = Pattern
                .compile("(([a-zA-Z0-9])+([//*&^%$#.-])?)+([a-zA-z0-9])+@([a-z])+([//.]([a-z]){2,4})+")
                .matcher(email).matches();
        if (!isValid) {
            isValid = Pattern.compile("([0-9]){10,12}").matcher(email).matches();
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
}

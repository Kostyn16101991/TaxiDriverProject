package ua.step.kostyn.taxidriverproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import ua.step.kostyn.taxidriverproject.R;

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

    public static SingUpFragment newInstance (){
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
}

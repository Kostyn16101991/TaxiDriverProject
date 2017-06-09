package ua.step.kostyn.taxidriverproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;


import butterknife.BindView;
import butterknife.OnClick;
import ua.step.kostyn.taxidriverproject.MainActivity;
import ua.step.kostyn.taxidriverproject.R;
import ua.step.kostyn.taxidriverproject.models.TestModel;

/**
 * Created by konstantin on 27.05.17.
 */

public class SingInFragment extends BaseFragment {
    @BindView(R.id.et_login)
    EditText etLogin;
    @BindView(R.id.et_password)
    EditText etPassword;

    public static SingInFragment newInstance(){
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
    public void createAccount(){
        ((MainActivity)getActivity()).changeFragment(SingUpFragment.newInstance());
    }
    @OnClick(R.id.btn_login)
    public void btnLogin (){
        if (validation(etLogin) && validation(etPassword)){
            checkUserInDB();
            System.out.println("good");
        }
    }

    public void checkUserInDB(){
        mReference = mDatabase.getReference("users");
        mReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println(dataSnapshot.getChildren());
                for (DataSnapshot snapsHot : dataSnapshot.getChildren()) {
                    System.out.println(snapsHot.getValue().toString());
                    TestModel testModel = gson.fromJson(snapsHot.getValue().toString(), TestModel.class);
                    System.out.println("testModel "+testModel);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

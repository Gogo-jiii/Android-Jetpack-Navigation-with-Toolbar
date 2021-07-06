package com.example.navigationcomponent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.HashSet;

public class FragmentOne extends Fragment {

    private View rootView;
    private NavController navController;
    private Button btnGotoSecondFragment, btnGoToFourthFragment;
    private ToolbarManager toolbarManager;
    private Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_one, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.fragmentContainerView);
        toolbarManager = ToolbarManager.getInstance();

        toolbar = rootView.findViewById(R.id.toolbar);
        btnGotoSecondFragment = rootView.findViewById(R.id.btnGotoSecondFragment);
        btnGoToFourthFragment = rootView.findViewById(R.id.btnGoToFourthFragment);

        setupToolbar();

        btnGotoSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                navController.navigate(R.id.action_fragmentOne_to_fragmentTwo);
            }
        });

        btnGoToFourthFragment.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                navController.navigate(R.id.action_fragmentOne_to_fragmentFour);
            }
        });

        return rootView;
    }

    private void setupToolbar() {
        toolbarManager.setupToolbar(getActivity(), navController, null, toolbar,
                false);
    }

}
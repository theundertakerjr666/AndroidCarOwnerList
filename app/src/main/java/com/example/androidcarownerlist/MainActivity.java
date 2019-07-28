package com.example.androidcarownerlist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked {

    Button btnCarInfo, btnOwnerInfo;
    ImageView ivMake;
    TextView tvModel, tvName, tvTel;
    FragmentManager fragmentManager;
    Fragment buttonFrag, listFrag, carInfoFrag, ownerInfoFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnCarInfo = findViewById(R.id.btnCarDetails);
        btnOwnerInfo = findViewById(R.id.btnOwnerDetails);
        ivMake = findViewById(R.id.idMake);
        tvModel = findViewById(R.id.tvModel);
        tvName = findViewById(R.id.tvName);
        tvTel = findViewById(R.id.tvTel);

        fragmentManager = getSupportFragmentManager();

        listFrag = fragmentManager.findFragmentById(R.id.listFragment);
        buttonFrag = fragmentManager.findFragmentById(R.id.buttonFrag);
        carInfoFrag = fragmentManager.findFragmentById(R.id.carInfoFrag);
        ownerInfoFrag = fragmentManager.findFragmentById(R.id.ownerInfoFrag);

        fragmentManager.beginTransaction()
                .show(buttonFrag)
                .show(listFrag)
                .show(carInfoFrag)
                .hide(ownerInfoFrag)
                .commit();

        btnOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .hide(carInfoFrag)
                        .show(ownerInfoFrag)
                        .commit();

            }
        });

        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .show(carInfoFrag)
                        .hide(ownerInfoFrag)
                        .commit();

            }
        });

        onItemClicked(0);
    }

    @Override
    public void onItemClicked(int index) {

        tvName.setText(ApplicationCarClass.cars.get(index).getOwnerName());
        tvModel.setText(ApplicationCarClass.cars.get(index).getModel());
        tvTel.setText(ApplicationCarClass.cars.get(index).getOwnerTel());

        if(ApplicationCarClass.cars.get(index).getMake().equalsIgnoreCase("Courcheval_Manta")) {
            ivMake.setImageResource(R.drawable.courcheval_manta);
        } else if(ApplicationCarClass.cars.get(index).getMake().equalsIgnoreCase("phaedra_palomino")) {
            ivMake.setImageResource(R.drawable.phaedra_palomino);
        } else {
            ivMake.setImageResource(R.drawable.picard_phirana);
        }

    }
}

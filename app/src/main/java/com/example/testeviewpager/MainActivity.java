package com.example.testeviewpager;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.testeviewpager.databinding.ActivityMainBinding;

import java.util.ArrayList;

import static com.example.testeviewpager.BR.viewModel;
import static com.example.testeviewpager.BR.viewModel;
import static com.example.testeviewpager.BR.viewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Israel1");
        nomes.add("Israel2");
        nomes.add("Israel3");
        nomes.add("Israel4");

        ArrayList<String> nomes1 = new ArrayList<>();
        nomes1.add("Teste1");
        nomes1.add("Teste2");
        nomes1.add("Teste3");
        nomes1.add("Teste4");

        ArrayList<String> nomes2 = new ArrayList<>();
        nomes2.add("Modelo1");
        nomes2.add("Modelo2");
        nomes2.add("Modelo3");
        nomes2.add("Modelo4");

        ArrayList<String> nomes3 = new ArrayList<>();
        nomes3.add("Cor1");
        nomes3.add("Cor2");
        nomes3.add("Cor3");
        nomes3.add("Cor4");


        ViewPager viewPager = findViewById(R.id.container);

        ViewModel viewModel = new ViewModel(viewPager);

        viewModel.items.addAll(nomes);
        viewModel.items2.addAll(nomes1);
        viewModel.items3.addAll(nomes2);
        viewModel.items4.addAll(nomes3);

        CustomPagerAdapter pagerAdapter = new CustomPagerAdapter(this, viewModel);

        viewPager.setAdapter(pagerAdapter);



        binding.setViewModel(viewModel);

        binding.executePendingBindings();
    }
}

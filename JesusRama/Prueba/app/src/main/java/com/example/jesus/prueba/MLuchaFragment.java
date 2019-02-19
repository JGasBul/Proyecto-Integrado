package com.example.jesus.prueba;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class MLuchaFragment extends Fragment {
    TextView Fase,Ronda;
    int fas,ron;



    public MLuchaFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MLuchaFragment newInstance(int f, int r) {
        MLuchaFragment fragment = new MLuchaFragment();
        Bundle args = new Bundle();
        args.putInt("Fases", f);
        args.putInt("Rondas", r);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            fas = (int) getArguments().get("Fases");
            ron = (int) getArguments().get("Rondas");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_m_lucha, container, false);

        Fase =(TextView) v.findViewById(R.id.fase);
        Fase.setText(String.valueOf(fas));
        Ronda =(TextView) v.findViewById(R.id.ronda);
        Ronda.setText(String.valueOf(ron));


        return v;
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

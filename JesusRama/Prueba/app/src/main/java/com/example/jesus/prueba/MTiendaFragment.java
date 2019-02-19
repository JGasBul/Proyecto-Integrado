package com.example.jesus.prueba;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MTiendaFragment extends Fragment {
    TextView Oro;
    int oro;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MTiendaFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MTiendaFragment newInstance(int o) {
        MTiendaFragment fragment = new MTiendaFragment();
        Bundle args = new Bundle();
        args.putInt("Oro", o);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            oro = (int) getArguments().get("Oro");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_m_tienda, container, false);
        Oro =(TextView) v.findViewById(R.id.oro);
        Oro.setText(String.valueOf(oro));

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

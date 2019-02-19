package educacion.trax.proyectointegrado.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import educacion.trax.proyectointegrado.Clases.Personaje;
import educacion.trax.proyectointegrado.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link entrar_tienda.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link entrar_tienda#newInstance} factory method to
 * create an instance of this fragment.
 */
public class entrar_tienda extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters
    private Personaje personaje;


    private OnFragmentInteractionListener mListener;

    public entrar_tienda() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment entrar_tienda.
     */
    // TODO: Rename and change types and number of parameters
    public static entrar_tienda newInstance(Personaje p) {
        entrar_tienda fragment = new entrar_tienda();
        Bundle args = new Bundle();
        args.putParcelable("personaje", p);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            personaje = getArguments().getParcelable("personaje");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_entrar_tienda, container, false);
        ImageButton img=v.findViewById(R.id.UwU);
        img.setOnClickListener(this);
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.UwU){
            mListener.tienda(personaje);
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void tienda(Personaje p);
    }
}

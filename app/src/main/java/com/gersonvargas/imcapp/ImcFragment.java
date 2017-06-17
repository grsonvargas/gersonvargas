package com.gersonvargas.imcapp;

/**
 * Created by at_campeche on 16/06/2017.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ImcFragment extends Fragment {
    EditText mCampoPeso; //Se declara la variable peso
    EditText mCampoEstatura;// Se declara la variable estatura
    Button mBotonCalcular;//Se crea/declara el boton calcular
    Button mBotonLimpiar; //Se crea/declara el boton limpiar
    TextView mEtiquetaImc;//Se crea la etiqueta en la que se muestra el resultado




    @Nullable
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                        View v = inflater.inflate(R.layout.fragment_imc, container, false);
        //Se inicializan las variables declaradas anteriormente
        mCampoPeso= (EditText) v.findViewById(R.id.campo_peso);
        mCampoEstatura= (EditText) v.findViewById(R.id.campo_estatura);
        mBotonCalcular= (Button) v.findViewById(R.id.boton_calcular);
        mBotonLimpiar= (Button) v.findViewById(R.id.boton_limpiar);
        mEtiquetaImc= (TextView) v.findViewById(R.id.etiqueta_imc);

        mBotonCalcular.setOnClickListener(new View.OnClickListener(){//Ejecuta la operacion calcular al darle click
            @Override
            public void onClick(View v){
                String s = mCampoPeso.getText().toString();
                double peso = Double.parseDouble(s);
                s = mCampoEstatura.getText().toString();
                double estatura = Double.parseDouble(s);
                double  imc = peso / (estatura*estatura);
                s = String.format("%2.2f" , imc);
                mEtiquetaImc.setText(s);
            }

        });

        mBotonLimpiar.setOnClickListener(new View.OnClickListener(){//Limpia los cuadros de texto al darle click
            @Override
            public void onClick(View v){
                mCampoPeso.setText("");
                mCampoEstatura.setText("");
                mEtiquetaImc.setText("0.0");
            }
        });

                        return v;
    }


}

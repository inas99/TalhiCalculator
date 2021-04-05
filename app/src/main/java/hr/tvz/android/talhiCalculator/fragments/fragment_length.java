package hr.tvz.android.talhiCalculator.fragments;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.tvz.android.talhiCalculator.R;
import hr.tvz.android.talhiCalculator.converters.convertToInt;
import hr.tvz.android.talhiCalculator.converters.converterLength;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_length extends Fragment {

    View v;
    String from_length;
    String to_length;


    Double first_arg=0.0;
    Double second_arg=0.0;

    String second_arg_string ;
    String resultInt;
    Integer first_arg_int = 0;

    String dummy_string="hello";




    public fragment_length(){
        // Required empty public constructor
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_length,container,false);

        //Referring to our arguments
        final EditText left_number= v.findViewById(R.id.left_number_area);
        final EditText right_number = v.findViewById(R.id.right_number);
        final Button btn_convert = v.findViewById(R.id.btn_convert);


        //creating spinner for "from" field
        Spinner spinner_from = v.findViewById(R.id.area_left);
        ArrayAdapter<CharSequence> adapter_from = ArrayAdapter.createFromResource(getContext(),R.array.length,android.R.layout.simple_spinner_item);
        adapter_from.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_from.setAdapter(adapter_from);
        spinner_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from_length = parent.getItemAtPosition(position).toString();


//                Toast.makeText(getContext(), "From: "+from_length+" to: "+to_length, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //creating spinner for "to" field
        Spinner spinner_to = v.findViewById(R.id.length_right);
        ArrayAdapter<CharSequence> adapter_to = ArrayAdapter.createFromResource(getContext(),R.array.length,android.R.layout.simple_spinner_item);
        adapter_to.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_to.setAdapter(adapter_to);
        spinner_to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to_length = parent.getItemAtPosition(position).toString();




//                Toast.makeText(getContext(), "From: "+from_length+" to: "+to_length, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





        //Handling seekbar
        final SeekBar seekBar = v.findViewById(R.id.seekBar_length);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                first_arg_int  = progress;



                    left_number.setText(first_arg_int.toString());
                    second_arg = new converterLength(from_length,to_length,Double.valueOf(first_arg_int)).convert();
//                second_arg = Double.valueOf(first_arg_int*1.6);
//                second_arg = Double.valueOf(Math.round(second_arg));
                    second_arg_string = String.format("%.4f",second_arg);

                    resultInt = new convertToInt(second_arg_string).ifInt();

                    right_number.setText(resultInt);







            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {



            }
        });


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        left_number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {








                if(s.toString().matches("")){
                    Toast.makeText(getContext(), "Please enter a value", Toast.LENGTH_SHORT).show();

                    first_arg = Double.parseDouble(String.valueOf("0"));
                    second_arg = new converterLength(from_length,to_length,first_arg).convert();
                    second_arg_string = String.format("%.4f",second_arg);
                    resultInt = new convertToInt(second_arg_string).ifInt();

                    right_number.setText(resultInt);
                }
                else{

                    first_arg = Double.parseDouble(String.valueOf(s));
                    second_arg = new converterLength(from_length,to_length,first_arg).convert();
                    second_arg_string = String.format("%.4f",second_arg);
                    resultInt = new convertToInt(second_arg_string).ifInt();

                    right_number.setText(resultInt);

                }










            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dummy_string = left_number.getText().toString();
                if(dummy_string.matches("")){
                    Toast.makeText(getContext(), "Please enter a value", Toast.LENGTH_SHORT).show();
                    left_number.setText("0");
                    first_arg = Double.parseDouble(String.valueOf(left_number.getText()));
                    second_arg = new converterLength(from_length,to_length,first_arg).convert();
                    second_arg_string = String.format("%.4f",second_arg);
                    resultInt = new convertToInt(second_arg_string).ifInt();

                    right_number.setText(resultInt);

                }
                else{

                    first_arg = Double.parseDouble(String.valueOf(left_number.getText()));
                    second_arg = new converterLength(from_length,to_length,first_arg).convert();
                    second_arg_string = String.format("%.4f",second_arg);
                    resultInt = new convertToInt(second_arg_string).ifInt();

                    right_number.setText(resultInt);

                }




            }
        });





        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        if(getActivity()!=null){
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(getActivity()!=null){
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }







}

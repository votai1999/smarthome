package com.nguyenngochuong.smarthome;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Device extends Fragment {
    View view;
    Button btnAll;
    Button btn4, btn5, btn3, btn1, btn2;
    TextView txtStt4, txtStt5, txtStt3, txtStt1, txtStt2;
    SeekBar skValue4, skValue5, skValue1;
    TextView txtValue4, txtValue5, txtValue1;
    Button btnAuto4, btnAuto5, btnAuto1, btnAuto3, btnAuto2;
    Spinner spnValue2;

    //biến trạng thái thiết bị
    String valueStt4, valueStt5, valueStt1, valueStt3, valueStt2;
    String valueValue4, valueValue5, valueValue1, valueValue2;
    String valueAuto4, valueAuto5, valueAuto1, valueAuto3, valueAuto2;

    //Khai báo đường truyền dữ liệu với Firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference allDB = database.getReference("device/ALL");
    DatabaseReference stt4DB = database.getReference("device/STT4");
    DatabaseReference stt5DB = database.getReference("device/STT5");
    DatabaseReference stt1DB = database.getReference("device/STT1");
    DatabaseReference stt3DB = database.getReference("device/STT3");
    DatabaseReference stt2DB = database.getReference("device/STT2");
    DatabaseReference value4DB = database.getReference("device/VAL4");
    DatabaseReference value5DB = database.getReference("device/VAL5");
    DatabaseReference value1DB = database.getReference("device/VAL1");
    DatabaseReference value2DB = database.getReference("device/VAL2");
    DatabaseReference AM4DB = database.getReference("userMode/AM4");
    DatabaseReference AM5DB = database.getReference("userMode/AM5");
    DatabaseReference AM1DB = database.getReference("userMode/AM1");
    DatabaseReference AM3DB = database.getReference("userMode/AM3");
    DatabaseReference AM2DB = database.getReference("userMode/AM2");


    public Device(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.device, container, false);

        //Ánh xạ
        btnAll = (Button) view.findViewById(R.id.btnAll);
        btn4 = (Button) view.findViewById(R.id.btn4);
        btn5 = (Button) view.findViewById(R.id.btn5);
        btn1 = (Button) view.findViewById(R.id.btn1);
        btn3 = (Button) view.findViewById(R.id.btn3);
        btn2 = (Button) view.findViewById(R.id.btn2);
        txtStt4 =  (TextView) view.findViewById(R.id.txtStt4);
        txtStt5 = (TextView) view.findViewById(R.id.txtStt5);
        txtStt1 = (TextView) view.findViewById(R.id.txtStt1);
        txtStt3 = (TextView) view.findViewById(R.id.txtStt3);
        txtStt2 = (TextView) view.findViewById(R.id.txtStt2);
        skValue4 = (SeekBar) view.findViewById(R.id.skValue4);
        skValue5 = (SeekBar) view.findViewById(R.id.skValue5);
        skValue1 = (SeekBar) view.findViewById(R.id.skValue1);
        txtValue4 = (TextView) view.findViewById(R.id.txtValue4);
        txtValue5 = (TextView) view.findViewById(R.id.txtValue5);
        txtValue1 = (TextView) view.findViewById(R.id.txtValue1);
        btnAuto4 = (Button) view.findViewById(R.id.btnAuto4);
        btnAuto5 = (Button) view.findViewById(R.id.btnAuto5);
        btnAuto1 = (Button) view.findViewById(R.id.btnAuto1);
        btnAuto3 = (Button) view.findViewById(R.id.btnAuto3);
        btnAuto2 = (Button) view.findViewById(R.id.btnAuto2);
        spnValue2 = (Spinner) view.findViewById(R.id.spnValue2);

        //Tạo arrayList cho spinner Channel
        final ArrayList<String> arrayChannel = new ArrayList<String>();
        arrayChannel.add("00");
        arrayChannel.add("01");
        arrayChannel.add("02");
        arrayChannel.add("03");
        arrayChannel.add("04");
        arrayChannel.add("05");
        arrayChannel.add("06");
        arrayChannel.add("07");
        arrayChannel.add("08");
        arrayChannel.add("09");
        arrayChannel.add("10");
        arrayChannel.add("11");
        arrayChannel.add("12");
        arrayChannel.add("13");
        arrayChannel.add("14");
        arrayChannel.add("15");
        arrayChannel.add("16");
        arrayChannel.add("17");
        arrayChannel.add("18");
        arrayChannel.add("19");
        arrayChannel.add("20");
        arrayChannel.add("21");
        arrayChannel.add("22");
        arrayChannel.add("23");
        arrayChannel.add("24");
        arrayChannel.add("25");
        arrayChannel.add("26");
        arrayChannel.add("27");
        arrayChannel.add("28");
        arrayChannel.add("29");
        arrayChannel.add("30");

        //Đổ dữ liệu thời gian từ arrayList vào arrayAdapter
        ArrayAdapter arraychannel = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item, arrayChannel);

        //Đổ dữ liệu từ arrayAdapter ra màn hình
        spnValue2.setAdapter(arraychannel);

        //Bắt sự kiện button Turn off all Devices
        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allDB.setValue("1");
                }
            });

        /*--------------------------------------------------------------------------------*/
        /*--------------------------------------TB1---------------------------------------*/
        /*--------------------------------------------------------------------------------*/
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueStt1.equals("0")){
                    stt1DB.setValue("1");
                }
                if(valueStt1.equals("1")){
                    stt1DB.setValue("0");
                }
            }
            });

        btnAuto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueAuto1.equals("0")){
                    AM1DB.setValue("1");
                }
                if(valueAuto1.equals("1")) {
                    AM1DB.setValue("0");
                }
            }
        });

        stt1DB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valueStt1 = dataSnapshot.getValue(String.class);
                if(valueStt1.equals("1")){
                    //Toast.makeText(getActivity(), "Air Conditioner is On", Toast.LENGTH_SHORT).show();
                    txtStt1.setText("AIR CONDITIONER: ON");
                }
                if(valueStt1.equals("0")){
                    //Toast.makeText(getActivity(), "Air Conditioner is Off", Toast.LENGTH_SHORT).show();
                    txtStt1.setText("AIR CONDITIONER: OFF");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getActivity(), "Reading status of Air Conditioner is failed", Toast.LENGTH_SHORT).show();
            }
        });

        AM1DB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valueAuto1 = dataSnapshot.getValue(String.class);
                if(valueAuto1.equals("1")){
                    btnAuto1.setText("AUTO: ON");
                }
                if(valueAuto1.equals("0")){
                    btnAuto1.setText("AUTO: OFF");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getActivity(), "Read status of button AutoTB1 is failed", Toast.LENGTH_SHORT).show();
            }
        });

        skValue1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueValue1 = String.valueOf(progress+16);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                value1DB.setValue(valueValue1);
            }
        });

        value1DB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                valueValue1 = dataSnapshot.getValue(String.class);
                txtValue1.setText("Air Conditioner: "+valueValue1+"°C");
                int i = Integer.parseInt(valueValue1)-16;
                skValue1.setProgress(i);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Reading temperature of Air Conditioner is failed", Toast.LENGTH_LONG).show();
            }
        });

        /*--------------------------------------------------------------------------------*/
        /*--------------------------------------TB2---------------------------------------*/
        /*--------------------------------------------------------------------------------*/
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueStt2.equals("0")){
                    stt2DB.setValue("1");
                }
                if(valueStt2.equals("1")){
                    stt2DB.setValue("0");
                }
            }
            });

        btnAuto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueAuto2.equals("0")){
                    AM2DB.setValue("1");
                }
                if(valueAuto2.equals("1")) {
                    AM2DB.setValue("0");
                }
            }
        });


        stt2DB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valueStt2 = dataSnapshot.getValue(String.class);
                if(valueStt2.equals("1")){
                    //Toast.makeText(getActivity(), "Light 1 is On", Toast.LENGTH_SHORT).show();
                    txtStt2.setText("TV: ON");
                }
                if(valueStt2.equals("0")){
                    //Toast.makeText(getActivity(), "Light 1 is Off", Toast.LENGTH_SHORT).show();
                    txtStt2.setText("TV: OFF");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getActivity(), "Read status of 2 is failed", Toast.LENGTH_SHORT).show();
            }
        });

        AM2DB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valueAuto2 = dataSnapshot.getValue(String.class);
                if(valueAuto2.equals("1")){
                    btnAuto2.setText("AUTO: ON");
                }
                if(valueAuto2.equals("0")){
                    btnAuto2.setText("AUTO: OFF");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getActivity(), "Read status of button AutoTB2 is failed", Toast.LENGTH_SHORT).show();
            }
        });

        spnValue2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                value2DB.setValue(arrayChannel.get(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        value2DB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                valueValue2 = dataSnapshot.getValue(String.class);
                spnValue2.setSelection(getIndex(spnValue2, valueValue2));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Error when read Channel of TV from Firebase", Toast.LENGTH_LONG).show();
            }
        });

        /*--------------------------------------------------------------------------------*/
        /*--------------------------------------TB3---------------------------------------*/
        /*--------------------------------------------------------------------------------*/
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueStt3.equals("0")){
                    stt3DB.setValue("1");
                }
                if(valueStt3.equals("1")){
                    stt3DB.setValue("0");
                }
            }
        });

        btnAuto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueAuto3.equals("0")){
                    AM3DB.setValue("1");
                }
                if(valueAuto3.equals("1")) {
                    AM3DB.setValue("0");
                }
            }
        });

        stt3DB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valueStt3 = dataSnapshot.getValue(String.class);
                if(valueStt3.equals("1")){
                    //Toast.makeText(getActivity(), "Projector is On", Toast.LENGTH_SHORT).show();
                    txtStt3.setText("LIGHT 3: ON");
                }
                if(valueStt3.equals("0")){
                    //Toast.makeText(getActivity(), "Projector is Off", Toast.LENGTH_SHORT).show();
                    txtStt3.setText("LIGHT 3: OFF");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getActivity(), "Read status of TB3 is failed", Toast.LENGTH_SHORT).show();
            }
        });

        AM3DB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valueAuto3 = dataSnapshot.getValue(String.class);
                if(valueAuto3.equals("1")){
                    btnAuto3.setText("AUTO: ON");
                }
                if(valueAuto3.equals("0")){
                    btnAuto3.setText("AUTO: OFF");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getActivity(), "Read status of button AutoTB3 is failed", Toast.LENGTH_SHORT).show();
            }
        });

        /*--------------------------------------------------------------------------------*/
        /*--------------------------------------TB4---------------------------------------*/
        /*--------------------------------------------------------------------------------*/
        //Bắt sự kiện button STT
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueStt4.equals("0")){
                    stt4DB.setValue("1");
                }
                if(valueStt4.equals("1")){
                    stt4DB.setValue("0");
                }
            }
        });

        btnAuto4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueAuto4.equals("0")){
                    AM4DB.setValue("1");
                }
                if(valueAuto4.equals("1")) {
                    AM4DB.setValue("0");
                }
            }
        });

        stt4DB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                valueStt4 = dataSnapshot.getValue(String.class);
                if(valueStt4.equals("1")){
                    //Toast.makeText(getActivity(), "Light 1 is On", Toast.LENGTH_SHORT).show();
                    txtStt4.setText("LIGHT 1: ON");
                }
                if(valueStt4.equals("0")){
                    //Toast.makeText(getActivity(), "Light 1 is Off", Toast.LENGTH_SHORT).show();
                    txtStt4.setText("LIGHT 1: OFF");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getActivity(), "Read status of 4 is failed", Toast.LENGTH_SHORT).show();
            }
        });

        AM4DB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valueAuto4 = dataSnapshot.getValue(String.class);
                if(valueAuto4.equals("1")){
                    btnAuto4.setText("AUTO: ON");
                }
                if(valueAuto4.equals("0")){
                    btnAuto4.setText("AUTO: OFF");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getActivity(), "Read status of button AutoTB3 is failed", Toast.LENGTH_SHORT).show();
            }
        });

        skValue4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueValue4 = String.valueOf(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                value4DB.setValue(valueValue4);
            }
        });

        value4DB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                valueValue4 = dataSnapshot.getValue(String.class);
                txtValue4.setText("Brightness Light 1: "+valueValue4+"%");
                int i = Integer.parseInt(valueValue4);
                skValue4.setProgress(i);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Error when read Brightness Light 1 from Firebase", Toast.LENGTH_LONG).show();
            }
        });

        /*--------------------------------------------------------------------------------*/
        /*--------------------------------------TB5---------------------------------------*/
        /*--------------------------------------------------------------------------------*/
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueStt5.equals("0")){
                    stt5DB.setValue("1");
                }
                if(valueStt5.equals("1")){
                    stt5DB.setValue("0");
                }
            }
        });

        btnAuto5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueAuto5.equals("0")){
                    AM5DB.setValue("1");
                }
                if(valueAuto5.equals("1")) {
                    AM5DB.setValue("0");
                }
            }
        });

        stt5DB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valueStt5 = dataSnapshot.getValue(String.class);
                if(valueStt5.equals("1")){
                    //Toast.makeText(getActivity(), "Light 2 is On", Toast.LENGTH_SHORT).show();
                    txtStt5.setText("LIGHT 2: ON");
                }
                if(valueStt5.equals("0")){
                    //Toast.makeText(getActivity(), "Light 2 is Off", Toast.LENGTH_SHORT).show();
                    txtStt5.setText("LIGHT 2: OFF");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getActivity(), "Read status of TB5 is failed", Toast.LENGTH_SHORT).show();
            }
        });

        AM5DB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valueAuto5 = dataSnapshot.getValue(String.class);
                if(valueAuto5.equals("1")){
                    btnAuto5.setText("AUTO: ON");
                }
                if(valueAuto5.equals("0")){
                    btnAuto5.setText("AUTO: OFF");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getActivity(), "Read status of button AutoTB5 is failed", Toast.LENGTH_SHORT).show();
            }
        });

        skValue5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueValue5 = String.valueOf(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                value5DB.setValue(valueValue5);
            }
        });

        value5DB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                valueValue5 = dataSnapshot.getValue(String.class);
                txtValue5.setText("Brightness Light 2: "+valueValue5+"%");
                int i = Integer.parseInt(valueValue5);
                skValue5.setProgress(i);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Error when read Brightness Light 2 from Firebase", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    //Hàm quy đổi Position từ Value của Spinner
    private int getIndex(Spinner spinner, String myString){
        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                return i;
            }
        }
        return 0;
    }
}

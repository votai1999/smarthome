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

public class UserMode extends Fragment {

    View view;

    Spinner spnMonTimeOn1, spnMonTimeOff1, spnMonValue1;
    Spinner spnTueTimeOn1, spnTueTimeOff1, spnTueValue1;
    Spinner spnWedTimeOn1, spnWedTimeOff1, spnWedValue1;
    Spinner spnThuTimeOn1, spnThuTimeOff1, spnThuValue1;
    Spinner spnFriTimeOn1, spnFriTimeOff1, spnFriValue1;
    Spinner spnSatTimeOn1, spnSatTimeOff1, spnSatValue1;
    Spinner spnSunTimeOn1, spnSunTimeOff1, spnSunValue1;
    Button btnReset1, btnSetup1, btnAuto1;

    Spinner spnMonTimeOn2, spnMonTimeOff2, spnMonValue2;
    Spinner spnTueTimeOn2, spnTueTimeOff2, spnTueValue2;
    Spinner spnWedTimeOn2, spnWedTimeOff2, spnWedValue2;
    Spinner spnThuTimeOn2, spnThuTimeOff2, spnThuValue2;
    Spinner spnFriTimeOn2, spnFriTimeOff2, spnFriValue2;
    Spinner spnSatTimeOn2, spnSatTimeOff2, spnSatValue2;
    Spinner spnSunTimeOn2, spnSunTimeOff2, spnSunValue2;
    Button btnReset2, btnSetup2, btnAuto2;

    Spinner spnMonTimeOn3, spnMonTimeOff3, spnMonValue3;
    Spinner spnTueTimeOn3, spnTueTimeOff3, spnTueValue3;
    Spinner spnWedTimeOn3, spnWedTimeOff3, spnWedValue3;
    Spinner spnThuTimeOn3, spnThuTimeOff3, spnThuValue3;
    Spinner spnFriTimeOn3, spnFriTimeOff3, spnFriValue3;
    Spinner spnSatTimeOn3, spnSatTimeOff3, spnSatValue3;
    Spinner spnSunTimeOn3, spnSunTimeOff3, spnSunValue3;
    Button btnReset3, btnSetup3, btnAuto3;

    Spinner spnMonTimeOn4, spnMonTimeOff4, spnMonValue4;
    Spinner spnTueTimeOn4, spnTueTimeOff4, spnTueValue4;
    Spinner spnWedTimeOn4, spnWedTimeOff4, spnWedValue4;
    Spinner spnThuTimeOn4, spnThuTimeOff4, spnThuValue4;
    Spinner spnFriTimeOn4, spnFriTimeOff4, spnFriValue4;
    Spinner spnSatTimeOn4, spnSatTimeOff4, spnSatValue4;
    Spinner spnSunTimeOn4, spnSunTimeOff4, spnSunValue4;
    Button btnReset4, btnSetup4, btnAuto4;

    Spinner spnMonTimeOn5, spnMonTimeOff5, spnMonValue5;
    Spinner spnTueTimeOn5, spnTueTimeOff5, spnTueValue5;
    Spinner spnWedTimeOn5, spnWedTimeOff5, spnWedValue5;
    Spinner spnThuTimeOn5, spnThuTimeOff5, spnThuValue5;
    Spinner spnFriTimeOn5, spnFriTimeOff5, spnFriValue5;
    Spinner spnSatTimeOn5, spnSatTimeOff5, spnSatValue5;
    Spinner spnSunTimeOn5, spnSunTimeOff5, spnSunValue5;
    Button btnReset5, btnSetup5, btnAuto5;

    //Biến lưu trữ giá trị Setup


    String MonTimeOn1, MonTimeOff1, MonValue1;
    String TueTimeOn1, TueTimeOff1, TueValue1;
    String WedTimeOn1, WedTimeOff1, WedValue1;
    String ThuTimeOn1, ThuTimeOff1, ThuValue1;
    String FriTimeOn1, FriTimeOff1, FriValue1;
    String SatTimeOn1, SatTimeOff1, SatValue1;
    String SunTimeOn1, SunTimeOff1, SunValue1;

    String MonTimeOn2, MonTimeOff2, MonValue2;
    String TueTimeOn2, TueTimeOff2, TueValue2;
    String WedTimeOn2, WedTimeOff2, WedValue2;
    String ThuTimeOn2, ThuTimeOff2, ThuValue2;
    String FriTimeOn2, FriTimeOff2, FriValue2;
    String SatTimeOn2, SatTimeOff2, SatValue2;
    String SunTimeOn2, SunTimeOff2, SunValue2;

    String MonTimeOn3, MonTimeOff3, MonValue3;
    String TueTimeOn3, TueTimeOff3, TueValue3;
    String WedTimeOn3, WedTimeOff3, WedValue3;
    String ThuTimeOn3, ThuTimeOff3, ThuValue3;
    String FriTimeOn3, FriTimeOff3, FriValue3;
    String SatTimeOn3, SatTimeOff3, SatValue3;
    String SunTimeOn3, SunTimeOff3, SunValue3;

    String MonTimeOn4, MonTimeOff4, MonValue4;
    String TueTimeOn4, TueTimeOff4, TueValue4;
    String WedTimeOn4, WedTimeOff4, WedValue4;
    String ThuTimeOn4, ThuTimeOff4, ThuValue4;
    String FriTimeOn4, FriTimeOff4, FriValue4;
    String SatTimeOn4, SatTimeOff4, SatValue4;
    String SunTimeOn4, SunTimeOff4, SunValue4;

    String MonTimeOn5, MonTimeOff5, MonValue5;
    String TueTimeOn5, TueTimeOff5, TueValue5;
    String WedTimeOn5, WedTimeOff5, WedValue5;
    String ThuTimeOn5, ThuTimeOff5, ThuValue5;
    String FriTimeOn5, FriTimeOff5, FriValue5;
    String SatTimeOn5, SatTimeOff5, SatValue5;
    String SunTimeOn5, SunTimeOff5, SunValue5;

    String valueSetup4, valueSetup5, valueSetup1, valueSetup3, valueSetup2;

    //Biến lưu trữ trạng thái Auto
    String valueAuto4, valueAuto5, valueAuto1, valueAuto3, valueAuto2;

    //Khai báo đường truyền dữ liệu với Firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference AM1 = database.getReference("userMode/AM1");
    DatabaseReference sAM1 = database.getReference("userMode/sAM1");
    DatabaseReference AM2 = database.getReference("userMode/AM2");
    DatabaseReference sAM2 = database.getReference("userMode/sAM2");
    DatabaseReference AM3 = database.getReference("userMode/AM3");
    DatabaseReference sAM3 = database.getReference("userMode/sAM3");
    DatabaseReference AM4 = database.getReference("userMode/AM4");
    DatabaseReference sAM4 = database.getReference("userMode/sAM4");
    DatabaseReference AM5 = database.getReference("userMode/AM5");
    DatabaseReference sAM5 = database.getReference("userMode/sAM5");

    public UserMode() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.usermode, container, false);

        //Ánh xạ


        spnMonTimeOn1 = (Spinner) view.findViewById(R.id.spnMonTimeOn1);
        spnMonTimeOff1 = (Spinner) view.findViewById(R.id.spnMonTimeOff1);
        spnMonValue1 = (Spinner) view.findViewById(R.id.spnMonValue1);
        spnTueTimeOn1 = (Spinner) view.findViewById(R.id.spnTueTimeOn1);
        spnTueTimeOff1 = (Spinner) view.findViewById(R.id.spnTueTimeOff1);
        spnTueValue1 = (Spinner) view.findViewById(R.id.spnTueValue1);
        spnThuTimeOn1 = (Spinner) view.findViewById(R.id.spnThuTimeOn1);
        spnThuTimeOff1 = (Spinner) view.findViewById(R.id.spnThuTimeOff1);
        spnThuValue1 = (Spinner) view.findViewById(R.id.spnThuValue1);
        spnWedTimeOn1 = (Spinner) view.findViewById(R.id.spnWedTimeOn1);
        spnWedTimeOff1 = (Spinner) view.findViewById(R.id.spnWedTimeOff1);
        spnWedValue1 = (Spinner) view.findViewById(R.id.spnWedValue1);
        spnFriTimeOn1 = (Spinner) view.findViewById(R.id.spnFriTimeOn1);
        spnFriTimeOff1 = (Spinner) view.findViewById(R.id.spnFriTimeOff1);
        spnFriValue1 = (Spinner) view.findViewById(R.id.spnFriValue1);
        spnSatTimeOn1 = (Spinner) view.findViewById(R.id.spnSatTimeOn1);
        spnSatTimeOff1 = (Spinner) view.findViewById(R.id.spnSatTimeOff1);
        spnSatValue1 = (Spinner) view.findViewById(R.id.spnSatValue1);
        spnSunTimeOn1 = (Spinner) view.findViewById(R.id.spnSunTimeOn1);
        spnSunTimeOff1 = (Spinner) view.findViewById(R.id.spnSunTimeOff1);
        spnSunValue1 = (Spinner) view.findViewById(R.id.spnSunValue1);
        btnReset1 = (Button) view.findViewById(R.id.btnReset1);
        btnSetup1 = (Button) view.findViewById(R.id.btnSetup1);
        btnAuto1 = (Button) view.findViewById(R.id.btnAuto1);

        spnMonTimeOn2 = (Spinner) view.findViewById(R.id.spnMonTimeOn2);
        spnMonTimeOff2 = (Spinner) view.findViewById(R.id.spnMonTimeOff2);
        spnMonValue2 = (Spinner) view.findViewById(R.id.spnMonValue2);
        spnTueTimeOn2 = (Spinner) view.findViewById(R.id.spnTueTimeOn2);
        spnTueTimeOff2 = (Spinner) view.findViewById(R.id.spnTueTimeOff2);
        spnTueValue2 = (Spinner) view.findViewById(R.id.spnTueValue2);
        spnThuTimeOn2 = (Spinner) view.findViewById(R.id.spnThuTimeOn2);
        spnThuTimeOff2 = (Spinner) view.findViewById(R.id.spnThuTimeOff2);
        spnThuValue2 = (Spinner) view.findViewById(R.id.spnThuValue2);
        spnWedTimeOn2 = (Spinner) view.findViewById(R.id.spnWedTimeOn2);
        spnWedTimeOff2 = (Spinner) view.findViewById(R.id.spnWedTimeOff2);
        spnWedValue2 = (Spinner) view.findViewById(R.id.spnWedValue2);
        spnFriTimeOn2 = (Spinner) view.findViewById(R.id.spnFriTimeOn2);
        spnFriTimeOff2 = (Spinner) view.findViewById(R.id.spnFriTimeOff2);
        spnFriValue2 = (Spinner) view.findViewById(R.id.spnFriValue2);
        spnSatTimeOn2 = (Spinner) view.findViewById(R.id.spnSatTimeOn2);
        spnSatTimeOff2 = (Spinner) view.findViewById(R.id.spnSatTimeOff2);
        spnSatValue2 = (Spinner) view.findViewById(R.id.spnSatValue2);
        spnSunTimeOn2 = (Spinner) view.findViewById(R.id.spnSunTimeOn2);
        spnSunTimeOff2 = (Spinner) view.findViewById(R.id.spnSunTimeOff2);
        spnSunValue2 = (Spinner) view.findViewById(R.id.spnSunValue2);
        btnReset2 = (Button) view.findViewById(R.id.btnReset2);
        btnSetup2 = (Button) view.findViewById(R.id.btnSetup2);
        btnAuto2 = (Button) view.findViewById(R.id.btnAuto2);

        spnMonTimeOn3 = (Spinner) view.findViewById(R.id.spnMonTimeOn3);
        spnMonTimeOff3 = (Spinner) view.findViewById(R.id.spnMonTimeOff3);
        //spnMonValue3 = (Spinner) view.findViewById(R.id.spnMonValue3);
        spnTueTimeOn3 = (Spinner) view.findViewById(R.id.spnTueTimeOn3);
        spnTueTimeOff3 = (Spinner) view.findViewById(R.id.spnTueTimeOff3);
        //spnTueValue3 = (Spinner) view.findViewById(R.id.spnTueValue3);
        spnThuTimeOn3 = (Spinner) view.findViewById(R.id.spnThuTimeOn3);
        spnThuTimeOff3 = (Spinner) view.findViewById(R.id.spnThuTimeOff3);
        //spnThuValue3 = (Spinner) view.findViewById(R.id.spnThuValue3);
        spnWedTimeOn3 = (Spinner) view.findViewById(R.id.spnWedTimeOn3);
        spnWedTimeOff3 = (Spinner) view.findViewById(R.id.spnWedTimeOff3);
        //spnWedValue3 = (Spinner) view.findViewById(R.id.spnWedValue3);
        spnFriTimeOn3 = (Spinner) view.findViewById(R.id.spnFriTimeOn3);
        spnFriTimeOff3= (Spinner) view.findViewById(R.id.spnFriTimeOff3);
        //spnFriDValue = (Spinner) view.findViewById(R.id.spnFriValue3);
        spnSatTimeOn3 = (Spinner) view.findViewById(R.id.spnSatTimeOn3);
        spnSatTimeOff3= (Spinner) view.findViewById(R.id.spnSatTimeOff3);
        //spnSatValue3 = (Spinner) view.findViewById(R.id.spnSatValue;
        spnSunTimeOn3 = (Spinner) view.findViewById(R.id.spnSunTimeOn3);
        spnSunTimeOff3 = (Spinner) view.findViewById(R.id.spnSunTimeOff3);
        //spnSunValue3 = (Spinner) view.findViewById(R.id.spnSunValue3);
        btnReset3 = (Button) view.findViewById(R.id.btnReset3);
        btnSetup3 = (Button) view.findViewById(R.id.btnSetup3);
        btnAuto3 = (Button) view.findViewById(R.id.btnAuto3);

        spnMonTimeOn4 = (Spinner) view.findViewById(R.id.spnMonTimeOn4);
        spnMonTimeOff4 = (Spinner) view.findViewById(R.id.spnMonTimeOff4);
        spnMonValue4 = (Spinner) view.findViewById(R.id.spnMonValue4);
        spnTueTimeOn4 = (Spinner) view.findViewById(R.id.spnTueTimeOn4);
        spnTueTimeOff4 = (Spinner) view.findViewById(R.id.spnTueTimeOff4);
        spnTueValue4 = (Spinner) view.findViewById(R.id.spnTueValue4);
        spnThuTimeOn4 = (Spinner) view.findViewById(R.id.spnThuTimeOn4);
        spnThuTimeOff4 = (Spinner) view.findViewById(R.id.spnThuTimeOff4);
        spnThuValue4 = (Spinner) view.findViewById(R.id.spnThuValue4);
        spnWedTimeOn4 = (Spinner) view.findViewById(R.id.spnWedTimeOn4);
        spnWedTimeOff4 = (Spinner) view.findViewById(R.id.spnWedTimeOff4);
        spnWedValue4 = (Spinner) view.findViewById(R.id.spnWedValue4);
        spnFriTimeOn4 = (Spinner) view.findViewById(R.id.spnFriTimeOn4);
        spnFriTimeOff4 = (Spinner) view.findViewById(R.id.spnFriTimeOff4);
        spnFriValue4 = (Spinner) view.findViewById(R.id.spnFriValue4);
        spnSatTimeOn4 = (Spinner) view.findViewById(R.id.spnSatTimeOn4);
        spnSatTimeOff4 = (Spinner) view.findViewById(R.id.spnSatTimeOff4);
        spnSatValue4 = (Spinner) view.findViewById(R.id.spnSatValue4);
        spnSunTimeOn4 = (Spinner) view.findViewById(R.id.spnSunTimeOn4);
        spnSunTimeOff4 = (Spinner) view.findViewById(R.id.spnSunTimeOff4);
        spnSunValue4 = (Spinner) view.findViewById(R.id.spnSunValue4);
        btnReset4 = (Button) view.findViewById(R.id.btnReset4);
        btnSetup4 = (Button) view.findViewById(R.id.btnSetup4);
        btnAuto4 = (Button) view.findViewById(R.id.btnAuto4);

        spnMonTimeOn5 = (Spinner) view.findViewById(R.id.spnMonTimeOn5);
        spnMonTimeOff5 = (Spinner) view.findViewById(R.id.spnMonTimeOff5);
        spnMonValue5 = (Spinner) view.findViewById(R.id.spnMonValue5);
        spnTueTimeOn5 = (Spinner) view.findViewById(R.id.spnTueTimeOn5);
        spnTueTimeOff5 = (Spinner) view.findViewById(R.id.spnTueTimeOff5);
        spnTueValue5 = (Spinner) view.findViewById(R.id.spnTueValue5);
        spnThuTimeOn5 = (Spinner) view.findViewById(R.id.spnThuTimeOn5);
        spnThuTimeOff5 = (Spinner) view.findViewById(R.id.spnThuTimeOff5);
        spnThuValue5 = (Spinner) view.findViewById(R.id.spnThuValue5);
        spnWedTimeOn5 = (Spinner) view.findViewById(R.id.spnWedTimeOn5);
        spnWedTimeOff5 = (Spinner) view.findViewById(R.id.spnWedTimeOff5);
        spnWedValue5 = (Spinner) view.findViewById(R.id.spnWedValue5);
        spnFriTimeOn5 = (Spinner) view.findViewById(R.id.spnFriTimeOn5);
        spnFriTimeOff5 = (Spinner) view.findViewById(R.id.spnFriTimeOff5);
        spnFriValue5 = (Spinner) view.findViewById(R.id.spnFriValue5);
        spnSatTimeOn5 = (Spinner) view.findViewById(R.id.spnSatTimeOn5);
        spnSatTimeOff5 = (Spinner) view.findViewById(R.id.spnSatTimeOff5);
        spnSatValue5 = (Spinner) view.findViewById(R.id.spnSatValue5);
        spnSunTimeOn5 = (Spinner) view.findViewById(R.id.spnSunTimeOn5);
        spnSunTimeOff5 = (Spinner) view.findViewById(R.id.spnSunTimeOff5);
        spnSunValue5 = (Spinner) view.findViewById(R.id.spnSunValue5);
        btnReset5 = (Button) view.findViewById(R.id.btnReset5);
        btnSetup5 = (Button) view.findViewById(R.id.btnSetup5);
        btnAuto5 = (Button) view.findViewById(R.id.btnAuto5);

        //Tạo arrayList cho spinner thời gian
        final ArrayList<String> arrayTime = new ArrayList<String>();
        arrayTime.add("None");
        arrayTime.add("00:00");
        arrayTime.add("00:30");
        arrayTime.add("01:00");
        arrayTime.add("01:30");
        arrayTime.add("02:00");
        arrayTime.add("02:30");
        arrayTime.add("03:00");
        arrayTime.add("03:30");
        arrayTime.add("04:00");
        arrayTime.add("04:30");
        arrayTime.add("05:00");
        arrayTime.add("05:30");
        arrayTime.add("06:00");
        arrayTime.add("06:30");
        arrayTime.add("07:00");
        arrayTime.add("07:30");
        arrayTime.add("08:00");
        arrayTime.add("08:30");
        arrayTime.add("09:00");
        arrayTime.add("09:30");
        arrayTime.add("10:00");
        arrayTime.add("10:30");
        arrayTime.add("11:00");
        arrayTime.add("11:30");
        arrayTime.add("12:00");
        arrayTime.add("12:30");
        arrayTime.add("13:00");
        arrayTime.add("13:30");
        arrayTime.add("14:00");
        arrayTime.add("14:30");
        arrayTime.add("15:00");
        arrayTime.add("15:30");
        arrayTime.add("16:00");
        arrayTime.add("16:30");
        arrayTime.add("17:00");
        arrayTime.add("17:30");
        arrayTime.add("18:00");
        arrayTime.add("18:30");
        arrayTime.add("19:00");
        arrayTime.add("19:30");
        arrayTime.add("20:00");
        arrayTime.add("20:30");
        arrayTime.add("21:00");
        arrayTime.add("21:30");
        arrayTime.add("22:00");
        arrayTime.add("22:30");
        arrayTime.add("23:00");
        arrayTime.add("23:30");

        final ArrayList<String> arrayBrightness = new ArrayList<String>();
        arrayBrightness.add("100%");
        arrayBrightness.add("90%");
        arrayBrightness.add("80%");
        arrayBrightness.add("70%");
        arrayBrightness.add("60%");
        arrayBrightness.add("50%");
        arrayBrightness.add("40%");
        arrayBrightness.add("30%");
        arrayBrightness.add("20%");
        arrayBrightness.add("10%");

        final ArrayList<String> arrayTemperature = new ArrayList<String>();
        arrayTemperature.add("16°C");
        arrayTemperature.add("17°C");
        arrayTemperature.add("18°C");
        arrayTemperature.add("19°C");
        arrayTemperature.add("20°C");
        arrayTemperature.add("21°C");
        arrayTemperature.add("22°C");
        arrayTemperature.add("23°C");
        arrayTemperature.add("24°C");
        arrayTemperature.add("25°C");
        arrayTemperature.add("26°C");
        arrayTemperature.add("27°C");
        arrayTemperature.add("28°C");
        arrayTemperature.add("29°C");
        arrayTemperature.add("30°C");

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
        ArrayAdapter arraytime = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item, arrayTime);
        ArrayAdapter arraybrightness = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, arrayBrightness);
        ArrayAdapter arraytemperature = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, arrayTemperature);
        ArrayAdapter arraychannel = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, arrayChannel);

        //Đổ dữ liệu từ arrayAdapter ra màn hình
        spnMonTimeOn1.setAdapter(arraytime);
        spnMonTimeOff1.setAdapter(arraytime);
        spnMonValue1.setAdapter(arraytemperature);
        spnTueTimeOn1.setAdapter(arraytime);
        spnTueTimeOff1.setAdapter(arraytime);
        spnTueValue1.setAdapter(arraytemperature);
        spnWedTimeOn1.setAdapter(arraytime);
        spnWedTimeOff1.setAdapter(arraytime);
        spnWedValue1.setAdapter(arraytemperature);
        spnThuTimeOn1.setAdapter(arraytime);
        spnThuTimeOff1.setAdapter(arraytime);
        spnThuValue1.setAdapter(arraytemperature);
        spnFriTimeOn1.setAdapter(arraytime);
        spnFriTimeOff1.setAdapter(arraytime);
        spnFriValue1.setAdapter(arraytemperature);
        spnSatTimeOn1.setAdapter(arraytime);
        spnSatTimeOff1.setAdapter(arraytime);
        spnSatValue1.setAdapter(arraytemperature);
        spnSunTimeOn1.setAdapter(arraytime);
        spnSunTimeOff1.setAdapter(arraytime);
        spnSunValue1.setAdapter(arraytemperature);

        spnMonTimeOn2.setAdapter(arraytime);
        spnMonTimeOff2.setAdapter(arraytime);
        spnMonValue2.setAdapter(arraychannel);
        spnTueTimeOn2.setAdapter(arraytime);
        spnTueTimeOff2.setAdapter(arraytime);
        spnTueValue2.setAdapter(arraychannel);
        spnWedTimeOn2.setAdapter(arraytime);
        spnWedTimeOff2.setAdapter(arraytime);
        spnWedValue2.setAdapter(arraychannel);
        spnThuTimeOn2.setAdapter(arraytime);
        spnThuTimeOff2.setAdapter(arraytime);
        spnThuValue2.setAdapter(arraychannel);
        spnFriTimeOn2.setAdapter(arraytime);
        spnFriTimeOff2.setAdapter(arraytime);
        spnFriValue2.setAdapter(arraychannel);
        spnSatTimeOn2.setAdapter(arraytime);
        spnSatTimeOff2.setAdapter(arraytime);
        spnSatValue2.setAdapter(arraychannel);
        spnSunTimeOn2.setAdapter(arraytime);
        spnSunTimeOff2.setAdapter(arraytime);
        spnSunValue2.setAdapter(arraychannel);

        spnMonTimeOn3.setAdapter(arraytime);
        spnMonTimeOff3.setAdapter(arraytime);
        //spnMonValue3.setAdapter(arraytemperature);
        spnTueTimeOn3.setAdapter(arraytime);
        spnTueTimeOff3.setAdapter(arraytime);
        //spnTueValue3.setAdapter(arraytemperature);
        spnWedTimeOn3.setAdapter(arraytime);
        spnWedTimeOff3.setAdapter(arraytime);
        //spnWedValue3.setAdapter(arraytemperature);
        spnThuTimeOn3.setAdapter(arraytime);
        spnThuTimeOff3.setAdapter(arraytime);
        //spnThuValue3.setAdapter(arraytemperature);
        spnFriTimeOn3.setAdapter(arraytime);
        spnFriTimeOff3.setAdapter(arraytime);
        //spnFriValue3.setAdapter(arraytemperature);
        spnSatTimeOn3.setAdapter(arraytime);
        spnSatTimeOff3.setAdapter(arraytime);
        //spnSatValue3.setAdapter(arraytemperature);
        spnSunTimeOn3.setAdapter(arraytime);
        spnSunTimeOff3.setAdapter(arraytime);
        //spnSunValue3.setAdapter(arraytemperature);

        spnMonTimeOn4.setAdapter(arraytime);
        spnMonTimeOff4.setAdapter(arraytime);
        spnMonValue4.setAdapter(arraybrightness);
        spnTueTimeOn4.setAdapter(arraytime);
        spnTueTimeOff4.setAdapter(arraytime);
        spnTueValue4.setAdapter(arraybrightness);
        spnWedTimeOn4.setAdapter(arraytime);
        spnWedTimeOff4.setAdapter(arraytime);
        spnWedValue4.setAdapter(arraybrightness);
        spnThuTimeOn4.setAdapter(arraytime);
        spnThuTimeOff4.setAdapter(arraytime);
        spnThuValue4.setAdapter(arraybrightness);
        spnFriTimeOn4.setAdapter(arraytime);
        spnFriTimeOff4.setAdapter(arraytime);
        spnFriValue4.setAdapter(arraybrightness);
        spnSatTimeOn4.setAdapter(arraytime);
        spnSatTimeOff4.setAdapter(arraytime);
        spnSatValue4.setAdapter(arraybrightness);
        spnSunTimeOn4.setAdapter(arraytime);
        spnSunTimeOff4.setAdapter(arraytime);
        spnSunValue4.setAdapter(arraybrightness);

        spnMonTimeOn5.setAdapter(arraytime);
        spnMonTimeOff5.setAdapter(arraytime);
        spnMonValue5.setAdapter(arraybrightness);
        spnTueTimeOn5.setAdapter(arraytime);
        spnTueTimeOff5.setAdapter(arraytime);
        spnTueValue5.setAdapter(arraybrightness);
        spnWedTimeOn5.setAdapter(arraytime);
        spnWedTimeOff5.setAdapter(arraytime);
        spnWedValue5.setAdapter(arraybrightness);
        spnThuTimeOn5.setAdapter(arraytime);
        spnThuTimeOff5.setAdapter(arraytime);
        spnThuValue5.setAdapter(arraybrightness);
        spnFriTimeOn5.setAdapter(arraytime);
        spnFriTimeOff5.setAdapter(arraytime);
        spnFriValue5.setAdapter(arraybrightness);
        spnSatTimeOn5.setAdapter(arraytime);
        spnSatTimeOff5.setAdapter(arraytime);
        spnSatValue5.setAdapter(arraybrightness);
        spnSunTimeOn5.setAdapter(arraytime);
        spnSunTimeOff5.setAdapter(arraytime);
        spnSunValue5.setAdapter(arraybrightness);

        /*--------------------------------------------------------------------------------*/
        /*--------------------------------------TB1---------------------------------------*/
        /*--------------------------------------------------------------------------------*/
        //Bắt sự kiện Button Reset
        btnReset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spnMonTimeOn1.setSelection(0);
                spnMonTimeOff1.setSelection(0);
                spnMonValue1.setSelection(0);
                spnTueTimeOn1.setSelection(0);
                spnTueTimeOff1.setSelection(0);
                spnTueValue1.setSelection(0);
                spnWedTimeOn1.setSelection(0);
                spnWedTimeOff1.setSelection(0);
                spnWedValue1.setSelection(0);
                spnThuTimeOn1.setSelection(0);
                spnThuTimeOff1.setSelection(0);
                spnThuValue1.setSelection(0);
                spnFriTimeOn1.setSelection(0);
                spnFriTimeOff1.setSelection(0);
                spnFriValue1.setSelection(0);
                spnSatTimeOn1.setSelection(0);
                spnSatTimeOff1.setSelection(0);
                spnSatValue1.setSelection(0);
                spnSunTimeOn1.setSelection(0);
                spnSunTimeOff1.setSelection(0);
                spnSunValue1.setSelection(0);
            }
        });

        //Bắt sự kiện Button Setup
        btnSetup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonTimeOn1 = spnMonTimeOn1.getSelectedItem().toString();
                MonTimeOff1 = spnMonTimeOff1.getSelectedItem().toString();
                MonValue1 = spnMonValue1.getSelectedItem().toString().replace("°C","");
                TueTimeOn1 = spnTueTimeOn1.getSelectedItem().toString();
                TueTimeOff1 = spnTueTimeOff1.getSelectedItem().toString();
                TueValue1 = spnTueValue1.getSelectedItem().toString().replace("°C","");
                WedTimeOn1 = spnWedTimeOn1.getSelectedItem().toString();
                WedTimeOff1 = spnWedTimeOff1.getSelectedItem().toString();
                WedValue1 = spnWedValue1.getSelectedItem().toString().replace("°C","");
                ThuTimeOn1 = spnThuTimeOn1.getSelectedItem().toString();
                ThuTimeOff1 = spnThuTimeOff1.getSelectedItem().toString();
                ThuValue1 = spnThuValue1.getSelectedItem().toString().replace("°C","");
                FriTimeOn1 = spnFriTimeOn1.getSelectedItem().toString();
                FriTimeOff1 = spnFriTimeOff1.getSelectedItem().toString();
                FriValue1 = spnFriValue1.getSelectedItem().toString().replace("°C","");
                SatTimeOn1 = spnSatTimeOn1.getSelectedItem().toString();
                SatTimeOff1 = spnSatTimeOff1.getSelectedItem().toString();
                SatValue1 = spnSatValue1.getSelectedItem().toString().replace("°C","");
                SunTimeOn1 = spnSunTimeOn1.getSelectedItem().toString();
                SunTimeOff1 = spnSunTimeOff1.getSelectedItem().toString();
                SunValue1 = spnSunValue1.getSelectedItem().toString().replace("°C","");
                //nối chuỗi dữ liệu Setup để gửi lên Firebase
                valueSetup1 = "$AM;1;"+MonTimeOn1+";"+MonTimeOff1+";"+MonValue1+";"+TueTimeOn1+";"+TueTimeOff1+";"+TueValue1+";"+WedTimeOn1+";"+WedTimeOff1+";"+WedValue1+";"+ThuTimeOn1+";"+ThuTimeOff1+";"+ThuValue1+";"+FriTimeOn1+";"+FriTimeOff1+";"+FriValue1+";"+SatTimeOn1+";"+SatTimeOff1+";"+SatValue1+";"+SunTimeOn1+";"+SunTimeOff1+";"+SunValue1+"#";
                sAM1.setValue(valueSetup1);
            }
        });

        //Bắt sự kiện Button Auto
        btnAuto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueAuto1.equals("0")){
                    AM1.setValue("1");
                }
                if(valueAuto1.equals("1")) {
                    AM1.setValue("0");
                }
            }
        });

        //Đọc trạng thái Auto từ Firebase
        AM1.addValueEventListener(new ValueEventListener() {
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
                Toast.makeText(getActivity(), "Read status of button Auto1 is failed", Toast.LENGTH_SHORT).show();
            }
        });

        //Đọc dữ liệu Setup từ Firebase
        sAM1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valueSetup1 = dataSnapshot.getValue(String.class);
                if(valueSetup1.startsWith("$") && valueSetup1.endsWith("#") ){
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+3, valueSetup1.length()-1);
                    MonTimeOff1 = valueSetup1.substring(0,valueSetup1.indexOf(";"));
                    valueSetup1= valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    MonTimeOff1 = valueSetup1.substring(0,valueSetup1.indexOf(";"));
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    MonValue1 = valueSetup1.substring(0,valueSetup1.indexOf(";")).concat("°C");
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    TueTimeOn1= valueSetup1.substring(0,valueSetup1.indexOf(";"));
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    TueTimeOff1 = valueSetup1.substring(0,valueSetup1.indexOf(";"));
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    TueValue1 = valueSetup1.substring(0,valueSetup1.indexOf(";")).concat("°C");
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    WedTimeOn1 = valueSetup1.substring(0,valueSetup1.indexOf(";"));
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    WedTimeOff1 = valueSetup1.substring(0,valueSetup1.indexOf(";"));
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    WedValue1 = valueSetup1.substring(0,valueSetup1.indexOf(";")).concat("°C");
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    ThuTimeOn1 = valueSetup1.substring(0,valueSetup1.indexOf(";"));
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    ThuTimeOff1 = valueSetup1.substring(0,valueSetup1.indexOf(";"));
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    ThuValue1= valueSetup1.substring(0,valueSetup1.indexOf(";")).concat("°C");
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    FriTimeOn1 = valueSetup1.substring(0,valueSetup1.indexOf(";"));
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    FriTimeOff1 = valueSetup1.substring(0,valueSetup1.indexOf(";"));
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    FriValue1 = valueSetup1.substring(0,valueSetup1.indexOf(";")).concat("°C");
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    SatTimeOn1 = valueSetup1.substring(0,valueSetup1.indexOf(";"));
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    SatTimeOff1 = valueSetup1.substring(0,valueSetup1.indexOf(";"));
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    SatValue1 = valueSetup1.substring(0,valueSetup1.indexOf(";")).concat("°C");
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    SunTimeOn1 = valueSetup1.substring(0,valueSetup1.indexOf(";"));
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    SunTimeOff1 = valueSetup1.substring(0,valueSetup1.indexOf(";"));
                    valueSetup1 = valueSetup1.substring(valueSetup1.indexOf(";")+1);
                    SunValue1 = valueSetup1.concat("°C");


                    spnMonTimeOn1.setSelection(getIndex(spnMonTimeOn1, MonTimeOn1));
                    spnMonTimeOff1.setSelection(getIndex(spnMonTimeOff1, MonTimeOff1));
                    spnMonValue1.setSelection(getIndex(spnMonValue1, MonValue1));
                    spnTueTimeOn1.setSelection(getIndex(spnTueTimeOn1, TueTimeOn1));
                    spnTueTimeOff1.setSelection(getIndex(spnTueTimeOff1, TueTimeOff1));
                    spnTueValue1.setSelection(getIndex(spnTueValue1, TueValue1));
                    spnWedTimeOn1.setSelection(getIndex(spnWedTimeOn1, WedTimeOn1));
                    spnWedTimeOff1.setSelection(getIndex(spnWedTimeOff1, WedTimeOff1));
                    spnWedValue1.setSelection(getIndex(spnWedValue1, WedValue1));
                    spnThuTimeOn1.setSelection(getIndex(spnThuTimeOn1, ThuTimeOn1));
                    spnThuTimeOff1.setSelection(getIndex(spnThuTimeOff1, ThuTimeOff1));
                    spnThuValue1.setSelection(getIndex(spnThuValue1, ThuValue1));
                    spnFriTimeOn1.setSelection(getIndex(spnFriTimeOn1, FriTimeOn1));
                    spnFriTimeOff1.setSelection(getIndex(spnFriTimeOff1, FriTimeOff1));
                    spnFriValue1.setSelection(getIndex(spnFriValue1, FriValue1));
                    spnSatTimeOn1.setSelection(getIndex(spnSatTimeOn1, SatTimeOn1));
                    spnSatTimeOff1.setSelection(getIndex(spnSatTimeOff1, SatTimeOff1));
                    spnSatValue1.setSelection(getIndex(spnSatValue1, SatValue1));
                    spnSunTimeOn1.setSelection(getIndex(spnSunTimeOn1, SunTimeOn1));
                    spnSunTimeOff1.setSelection(getIndex(spnSunTimeOff1, SunTimeOff1));
                    spnSunValue1.setSelection(getIndex(spnSunValue1, SunValue1));
                }
                else Toast.makeText(getActivity(), "Data setup 1 is error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getActivity(), "Read status of button Auto1 is failed", Toast.LENGTH_SHORT).show();
            }
        });

        /*--------------------------------------------------------------------------------*/
        /*--------------------------------------TB2---------------------------------------*/
        /*--------------------------------------------------------------------------------*/
        //Bắt sự kiện Button Reset
        btnReset2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spnMonTimeOn2.setSelection(0);
                spnMonTimeOff2.setSelection(0);
                spnMonValue2.setSelection(0);
                spnTueTimeOn2.setSelection(0);
                spnTueTimeOff2.setSelection(0);
                spnTueValue2.setSelection(0);
                spnWedTimeOn2.setSelection(0);
                spnWedTimeOff2.setSelection(0);
                spnWedValue2.setSelection(0);
                spnThuTimeOn2.setSelection(0);
                spnThuTimeOff2.setSelection(0);
                spnThuValue2.setSelection(0);
                spnFriTimeOn2.setSelection(0);
                spnFriTimeOff2.setSelection(0);
                spnFriValue2.setSelection(0);
                spnSatTimeOn2.setSelection(0);
                spnSatTimeOff2.setSelection(0);
                spnSatValue2.setSelection(0);
                spnSunTimeOn2.setSelection(0);
                spnSunTimeOff2.setSelection(0);
                spnSunValue2.setSelection(0);
            }
        });

        //Bắt sự kiện Button Setup
        btnSetup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonTimeOn2 = spnMonTimeOn2.getSelectedItem().toString();
                MonTimeOff2 = spnMonTimeOff2.getSelectedItem().toString();
                MonValue2 = spnMonValue2.getSelectedItem().toString();
                TueTimeOn2 = spnTueTimeOn2.getSelectedItem().toString();
                TueTimeOff2 = spnTueTimeOff2.getSelectedItem().toString();
                TueValue2 = spnTueValue2.getSelectedItem().toString();
                WedTimeOn2 = spnWedTimeOn2.getSelectedItem().toString();
                WedTimeOff2 = spnWedTimeOff2.getSelectedItem().toString();
                WedValue2 = spnWedValue2.getSelectedItem().toString();
                ThuTimeOn2 = spnThuTimeOn2.getSelectedItem().toString();
                ThuTimeOff2 = spnThuTimeOff2.getSelectedItem().toString();
                ThuValue2 = spnThuValue2.getSelectedItem().toString();
                FriTimeOn2 = spnFriTimeOn2.getSelectedItem().toString();
                FriTimeOff2 = spnFriTimeOff2.getSelectedItem().toString();
                FriValue2 = spnFriValue2.getSelectedItem().toString();
                SatTimeOn2 = spnSatTimeOn2.getSelectedItem().toString();
                SatTimeOff2 = spnSatTimeOff2.getSelectedItem().toString();
                SatValue2 = spnSatValue2.getSelectedItem().toString();
                SunTimeOn2 = spnSunTimeOn2.getSelectedItem().toString();
                SunTimeOff2 = spnSunTimeOff2.getSelectedItem().toString();
                SunValue2 = spnSunValue2.getSelectedItem().toString();
                //nối chuỗi dữ liệu Setup để gửi lên Firebase
                valueSetup2 = "$AM;2;"+MonTimeOn2+";"+MonTimeOff2+";"+MonValue2+";"+TueTimeOn2+";"+TueTimeOff2+";"+TueValue2+";"+WedTimeOn2+";"+WedTimeOff2+";"+WedValue2+";"+ThuTimeOn2+";"+ThuTimeOff2+";"+ThuValue2+";"+FriTimeOn2+";"+FriTimeOff2+";"+FriValue2+";"+SatTimeOn2+";"+SatTimeOff2+";"+SatValue2+";"+SunTimeOn2+";"+SunTimeOff2+";"+SunValue2+"#";
                sAM2.setValue(valueSetup2);
            }
        });

        //Bắt sự kiện Button Auto
        btnAuto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueAuto2.equals("0")){
                    AM2.setValue("1");
                }
                if(valueAuto2.equals("1")) {
                    AM2.setValue("0");
                }
            }
        });

        //Đọc trạng thái Auto từ Firebase
        AM2.addValueEventListener(new ValueEventListener() {
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
                Toast.makeText(getActivity(), "Read status of button Auto2 is failed", Toast.LENGTH_SHORT).show();
            }
        });

        //Đọc dữ liệu Setup từ Firebase
        sAM2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valueSetup2 = dataSnapshot.getValue(String.class);
                if(valueSetup2.startsWith("$") && valueSetup2.endsWith("#") ){
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+3, valueSetup2.length()-1);
                    MonTimeOn2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    MonTimeOff2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    MonValue2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    TueTimeOn2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    TueTimeOff2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    TueValue2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    WedTimeOn2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    WedTimeOff2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    WedValue2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    ThuTimeOn2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    ThuTimeOff2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    ThuValue2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    FriTimeOn2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    FriTimeOff2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    FriValue2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    SatTimeOn2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    SatTimeOff2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    SatValue2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    SunTimeOn2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    SunTimeOff2 = valueSetup2.substring(0,valueSetup2.indexOf(";"));
                    valueSetup2 = valueSetup2.substring(valueSetup2.indexOf(";")+1);
                    SunValue2 = valueSetup2;


                    spnMonTimeOn2.setSelection(getIndex(spnMonTimeOn2, MonTimeOn2));
                    spnMonTimeOff2.setSelection(getIndex(spnMonTimeOff2, MonTimeOff2));
                    spnMonValue2.setSelection(getIndex(spnMonValue2, MonValue2));
                    spnTueTimeOn2.setSelection(getIndex(spnTueTimeOn2, TueTimeOn2));
                    spnTueTimeOff2.setSelection(getIndex(spnTueTimeOff2, TueTimeOff2));
                    spnTueValue2.setSelection(getIndex(spnTueValue2, TueValue2));
                    spnWedTimeOn2.setSelection(getIndex(spnWedTimeOn2, WedTimeOn2));
                    spnWedTimeOff2.setSelection(getIndex(spnWedTimeOff2, WedTimeOff2));
                    spnWedValue2.setSelection(getIndex(spnWedValue2, WedValue2));
                    spnThuTimeOn2.setSelection(getIndex(spnThuTimeOn2, ThuTimeOn2));
                    spnThuTimeOff2.setSelection(getIndex(spnThuTimeOff2, ThuTimeOff2));
                    spnThuValue2.setSelection(getIndex(spnThuValue2, ThuValue2));
                    spnFriTimeOn2.setSelection(getIndex(spnFriTimeOn2, FriTimeOn2));
                    spnFriTimeOff2.setSelection(getIndex(spnFriTimeOff2, FriTimeOff2));
                    spnFriValue2.setSelection(getIndex(spnFriValue2, FriValue2));
                    spnSatTimeOn2.setSelection(getIndex(spnSatTimeOn2, SatTimeOn2));
                    spnSatTimeOff2.setSelection(getIndex(spnSatTimeOff2, SatTimeOff2));
                    spnSatValue2.setSelection(getIndex(spnSatValue2, SatValue2));
                    spnSunTimeOn2.setSelection(getIndex(spnSunTimeOn2, SunTimeOn2));
                    spnSunTimeOff2.setSelection(getIndex(spnSunTimeOff2, SunTimeOff2));
                    spnSunValue2.setSelection(getIndex(spnSunValue2, SunValue2));
                }
                else Toast.makeText(getActivity(), "Data setup 2 is error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getActivity(), "Read status of button Auto2 is failed", Toast.LENGTH_SHORT).show();
            }
        });
        /*--------------------------------------------------------------------------------*/
        /*--------------------------------------TB3---------------------------------------*/
        /*--------------------------------------------------------------------------------*/
        //Bắt sự kiện Button Reset
        btnReset3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spnMonTimeOn3.setSelection(0);
                spnMonTimeOff3.setSelection(0);
                //spnMonValue3.setSelection(0);
                spnTueTimeOn3.setSelection(0);
                spnTueTimeOff3.setSelection(0);
                //spnTueValue3.setSelection(0);
                spnWedTimeOn3.setSelection(0);
                spnWedTimeOff3.setSelection(0);
                //spnWedValue3.setSelection(0);
                spnThuTimeOn3.setSelection(0);
                spnThuTimeOff3.setSelection(0);
                //spnThuValue3.setSelection(0);
                spnFriTimeOn3.setSelection(0);
                spnFriTimeOff3.setSelection(0);
                //spnFriValue3.setSelection(0);
                spnSatTimeOn3.setSelection(0);
                spnSatTimeOff3.setSelection(0);
                //spnSatValue3.setSelection(0);
                spnSunTimeOn3.setSelection(0);
                spnSunTimeOff3.setSelection(0);
                //spnSunValue3.setSelection(0);
            }
        });

        //Bắt sự kiện Button Setup
        btnSetup3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonTimeOn3 = spnMonTimeOn3.getSelectedItem().toString();
                MonTimeOff3 = spnMonTimeOff3.getSelectedItem().toString();
                //MonValue3 = spnMonValue3.getSelectedItem().toString().replace("°C","");
                TueTimeOn3 = spnTueTimeOn3.getSelectedItem().toString();
                TueTimeOff3 = spnTueTimeOff3.getSelectedItem().toString();
                //TueValue3 = spnTueValue3.getSelectedItem().toString().replace("°C","");
                WedTimeOn3 = spnWedTimeOn3.getSelectedItem().toString();
                WedTimeOff3 = spnWedTimeOff3.getSelectedItem().toString();
                //WedValue3 = spnWedValue3.getSelectedItem().toString().replace("°C","");
                ThuTimeOn3 = spnThuTimeOn3.getSelectedItem().toString();
                ThuTimeOff3 = spnThuTimeOff3.getSelectedItem().toString();
                //ThuValue3 = spnThuValue3.getSelectedItem().toString().replace("°C","");
                FriTimeOn3 = spnFriTimeOn3.getSelectedItem().toString();
                FriTimeOff3 = spnFriTimeOff3.getSelectedItem().toString();
                //FriValue3 = spnFriValue3.getSelectedItem().toString().replace("°C","");
                SatTimeOn3 = spnSatTimeOn3.getSelectedItem().toString();
                SatTimeOff3 = spnSatTimeOff3.getSelectedItem().toString();
                //SatValue3 = spnSatValue3.getSelectedItem().toString().replace("°C","");
                SunTimeOn3 = spnSunTimeOn3.getSelectedItem().toString();
                SunTimeOff3 = spnSunTimeOff3.getSelectedItem().toString();
                //SunValue3 = spnSunValue3.getSelectedItem().toString().replace("°C","");
                //nối chuỗi dữ liệu Setup để gửi lên Firebase
                valueSetup3 = "$AM;3;"+MonTimeOn3+";"+MonTimeOff3+";"+TueTimeOn3+";"+TueTimeOff3+";"+WedTimeOn3+";"+WedTimeOff3+";"+ThuTimeOn3+";"+ThuTimeOff3+";"+FriTimeOn3+";"+FriTimeOff3+";"+SatTimeOn3+";"+SatTimeOff3+";"+SunTimeOn3+";"+SunTimeOff3+"#";
                sAM3.setValue(valueSetup3);
            }
        });

        //Bắt sự kiện Button Auto
        btnAuto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueAuto3.equals("0")){
                    AM3.setValue("1");
                }
                if(valueAuto3.equals("1")) {
                    AM3.setValue("0");
                }
            }
        });

        //Đọc trạng thái Auto từ Firebase
        AM3.addValueEventListener(new ValueEventListener() {
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
                Toast.makeText(getActivity(), "Read status of button Auto3 is failed", Toast.LENGTH_SHORT).show();
            }
        });

        //Đọc dữ liệu Setup từ Firebase
        sAM3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valueSetup3 = dataSnapshot.getValue(String.class);
                if(valueSetup3.startsWith("$") && valueSetup3.endsWith("#") ){
                    valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+3, valueSetup3.length()-1);
                    MonTimeOn3 = valueSetup3.substring(0,valueSetup3.indexOf(";"));
                    valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    MonTimeOff3 = valueSetup3.substring(0,valueSetup3.indexOf(";"));
                    valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    //MonValue3 = valueSetup3.substring(0,valueSetup3.indexOf(";")).concat("°C");
                    //valueSetup3 = valueSetup3.substring(valueSetu3.indexOf(";")+1);
                    TueTimeOn3 = valueSetup3.substring(0,valueSetup3.indexOf(";"));
                    valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    TueTimeOff3 = valueSetup3.substring(0,valueSetup3.indexOf(";"));
                    valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    //TueValue3 = valueSetup3.substring(0,valueSetup3.indexOf(";")).concat("°C");
                    //valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    WedTimeOn3 = valueSetup3.substring(0,valueSetup3.indexOf(";"));
                    valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    WedTimeOff3 = valueSetup3.substring(0,valueSetup3.indexOf(";"));
                    valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    //WedValue3 = valueSetup3.substring(0,valueSetup3.indexOf(";")).concat("°C");
                    //valueSetu3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    ThuTimeOn3 = valueSetup3.substring(0,valueSetup3.indexOf(";"));
                    valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    ThuTimeOff3 = valueSetup3.substring(0,valueSetup3.indexOf(";"));
                    valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    //ThuValue3 = valueSetup3.substring(0,valueSetup3.indexOf(";")).concat("°C");
                    //valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    FriTimeOn3 = valueSetup3.substring(0,valueSetup3.indexOf(";"));
                    valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    FriTimeOff3 = valueSetup3.substring(0,valueSetup3.indexOf(";"));
                    valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    //FriValue3 = valueSetup3.substring(0,valueSetup3.indexOf(";")).concat("°C");
                    //valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    SatTimeOn3 = valueSetup3.substring(0,valueSetup3.indexOf(";"));
                    valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    SatTimeOff3 = valueSetup3.substring(0,valueSetup3.indexOf(";"));
                    valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    //SatValue3 = valueSetup3.substring(0,valueSetup3.indexOf(";")).concat("°C");
                    //valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    SunTimeOn3 = valueSetup3.substring(0,valueSetup3.indexOf(";"));
                    valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    SunTimeOff3 = valueSetup3;
                    //SunTimeOff3 = valueSetup3.substring(0,valueSetup3.indexOf(";"));
                    //valueSetup3 = valueSetup3.substring(valueSetup3.indexOf(";")+1);
                    //SunValue3 = valueSetup3.concat("°C");


                    spnMonTimeOn3.setSelection(getIndex(spnMonTimeOn3, MonTimeOn3));
                    spnMonTimeOff3.setSelection(getIndex(spnMonTimeOff3, MonTimeOff3));
                    //spnMonValue3.setSelection(getIndex(spnMonValue3, MonValue3));
                    spnTueTimeOn3.setSelection(getIndex(spnTueTimeOn3, TueTimeOn3));
                    spnTueTimeOff3.setSelection(getIndex(spnTueTimeOff3, TueTimeOff3));
                    //spnTueValue3.setSelection(getIndex(spnTueValue3, TueDetai3));
                    spnWedTimeOn3.setSelection(getIndex(spnWedTimeOn3, WedTimeOn3));
                    spnWedTimeOff3.setSelection(getIndex(spnWedTimeOff3, WedTimeOff3));
                    //spnWedValue3.setSelection(getIndex(spnWedValue3, WedValue3));
                    spnThuTimeOn3.setSelection(getIndex(spnThuTimeOn3, ThuTimeOn3));
                    spnThuTimeOff3.setSelection(getIndex(spnThuTimeOff3, ThuTimeOff3));
                    //spnThuValue3.setSelection(getIndex(spnThuValue3, ThuValue3));
                    spnFriTimeOn3.setSelection(getIndex(spnFriTimeOn3, FriTimeOn3));
                    spnFriTimeOff3.setSelection(getIndex(spnFriTimeOff3, FriTimeOff3));
                    //spnFriValue3.setSelection(getIndex(spnFriValue3, FriValue3));
                    spnSatTimeOn3.setSelection(getIndex(spnSatTimeOn3, SatTimeOn3));
                    spnSatTimeOff3.setSelection(getIndex(spnSatTimeOff3, SatTimeOff3));
                    //spnSatValue3.setSelection(getIndex(spnSatValue3, SatValue3));
                    spnSunTimeOn3.setSelection(getIndex(spnSunTimeOn3, SunTimeOn3));
                    spnSunTimeOff3.setSelection(getIndex(spnSunTimeOff3, SunTimeOff3));
                    //spnSunValue3.setSelection(getIndex(spnSunDetai3, SunValueValueValue3));
                }
                else Toast.makeText(getActivity(), "Data setup 3 is error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getActivity(), "Read status of button Auto3 is failed", Toast.LENGTH_SHORT).show();
            }
        });

        /*--------------------------------------------------------------------------------*/
        /*--------------------------------------TB4---------------------------------------*/
        /*--------------------------------------------------------------------------------*/
        //Bắt sự kiện Button Reset
        btnReset4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spnMonTimeOn4.setSelection(0);
                spnMonTimeOff4.setSelection(0);
                spnMonValue4.setSelection(0);
                spnTueTimeOn4.setSelection(0);
                spnTueTimeOff4.setSelection(0);
                spnTueValue4.setSelection(0);
                spnWedTimeOn4.setSelection(0);
                spnWedTimeOff4.setSelection(0);
                spnWedValue4.setSelection(0);
                spnThuTimeOn4.setSelection(0);
                spnThuTimeOff4.setSelection(0);
                spnThuValue4.setSelection(0);
                spnFriTimeOn4.setSelection(0);
                spnFriTimeOff4.setSelection(0);
                spnFriValue4.setSelection(0);
                spnSatTimeOn4.setSelection(0);
                spnSatTimeOff4.setSelection(0);
                spnSatValue4.setSelection(0);
                spnSunTimeOn4.setSelection(0);
                spnSunTimeOff4.setSelection(0);
                spnSunValue4.setSelection(0);
            }
        });

        //Bắt sự kiện Button Setup
        btnSetup4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonTimeOn4 = spnMonTimeOn4.getSelectedItem().toString();
                MonTimeOff4 = spnMonTimeOff4.getSelectedItem().toString();
                MonValue4 = spnMonValue4.getSelectedItem().toString().replace("%","");
                TueTimeOn4 = spnTueTimeOn4.getSelectedItem().toString();
                TueTimeOff4 = spnTueTimeOff4.getSelectedItem().toString();
                TueValue4 = spnTueValue4.getSelectedItem().toString().replace("%","");
                WedTimeOn4 = spnWedTimeOn4.getSelectedItem().toString();
                WedTimeOff4 = spnWedTimeOff4.getSelectedItem().toString();
                WedValue4 = spnWedValue4.getSelectedItem().toString().replace("%","");
                ThuTimeOn4 = spnThuTimeOn4.getSelectedItem().toString();
                ThuTimeOff4 = spnThuTimeOff4.getSelectedItem().toString();
                ThuValue4 = spnThuValue4.getSelectedItem().toString().replace("%","");
                FriTimeOn4 = spnFriTimeOn4.getSelectedItem().toString();
                FriTimeOff4 = spnFriTimeOff4.getSelectedItem().toString();
                FriValue4 = spnFriValue4.getSelectedItem().toString().replace("%","");
                SatTimeOn4 = spnSatTimeOn4.getSelectedItem().toString();
                SatTimeOff4 = spnSatTimeOff4.getSelectedItem().toString();
                SatValue4 = spnSatValue4.getSelectedItem().toString().replace("%","");
                SunTimeOn4 = spnSunTimeOn4.getSelectedItem().toString();
                SunTimeOff4 = spnSunTimeOff4.getSelectedItem().toString();
                SunValue4 = spnSunValue4.getSelectedItem().toString().replace("%","");
                //nối chuỗi dữ liệu Setup để gửi lên Firebase
                valueSetup4 = "$AM;4;"+MonTimeOn4+";"+MonTimeOff4+";"+MonValue4+";"+TueTimeOn4+";"+TueTimeOff4+";"+TueValue4+";"+WedTimeOn4+";"+WedTimeOff4+";"+WedValue4+";"+ThuTimeOn4+";"+ThuTimeOff4+";"+ThuValue4+";"+FriTimeOn4+";"+FriTimeOff4+";"+FriValue4+";"+SatTimeOn4+";"+SatTimeOff4+";"+SatValue4+";"+SunTimeOn4+";"+SunTimeOff4+";"+SunValue4+"#";
                sAM4.setValue(valueSetup4);
            }
        });

        //Bắt sự kiện Button Auto
        btnAuto4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueAuto4.equals("0")){
                    AM4.setValue("1");
                }
                if(valueAuto4.equals("1")) {
                    AM4.setValue("0");
                }
            }
        });

        //Đọc trạng thái Auto từ Firebase
        AM4.addValueEventListener(new ValueEventListener() {
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
                Toast.makeText(getActivity(), "Read status of button Auto4 is failed", Toast.LENGTH_SHORT).show();
            }
        });

        //Đọc dữ liệu Setup từ Firebase
        sAM4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valueSetup4 = dataSnapshot.getValue(String.class);
                if(valueSetup4.startsWith("$") && valueSetup4.endsWith("#") ){
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+3, valueSetup4.length()-1);
                    MonTimeOn4 = valueSetup4.substring(0,valueSetup4.indexOf(";"));
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    MonTimeOff4 = valueSetup4.substring(0,valueSetup4.indexOf(";"));
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    MonValue4 = valueSetup4.substring(0,valueSetup4.indexOf(";")).concat("%");
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    TueTimeOn4 = valueSetup4.substring(0,valueSetup4.indexOf(";"));
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    TueTimeOff4 = valueSetup4.substring(0,valueSetup4.indexOf(";"));
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    TueValue4 = valueSetup4.substring(0,valueSetup4.indexOf(";")).concat("%");
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    WedTimeOn4 = valueSetup4.substring(0,valueSetup4.indexOf(";"));
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    WedTimeOff4 = valueSetup4.substring(0,valueSetup4.indexOf(";"));
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    WedValue4 = valueSetup4.substring(0,valueSetup4.indexOf(";")).concat("%");
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    ThuTimeOn4 = valueSetup4.substring(0,valueSetup4.indexOf(";"));
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    ThuTimeOff4 = valueSetup4.substring(0,valueSetup4.indexOf(";"));
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    ThuValue4 = valueSetup4.substring(0,valueSetup4.indexOf(";")).concat("%");
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    FriTimeOn4 = valueSetup4.substring(0,valueSetup4.indexOf(";"));
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    FriTimeOff4 = valueSetup4.substring(0,valueSetup4.indexOf(";"));
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    FriValue4 = valueSetup4.substring(0,valueSetup4.indexOf(";")).concat("%");
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    SatTimeOn4 = valueSetup4.substring(0,valueSetup4.indexOf(";"));
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    SatTimeOff4 = valueSetup4.substring(0,valueSetup4.indexOf(";"));
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    SatValue4 = valueSetup4.substring(0,valueSetup4.indexOf(";")).concat("%");
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    SunTimeOn4 = valueSetup4.substring(0,valueSetup4.indexOf(";"));
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    SunTimeOff4 = valueSetup4.substring(0,valueSetup4.indexOf(";"));
                    valueSetup4 = valueSetup4.substring(valueSetup4.indexOf(";")+1);
                    SunValue4 = valueSetup4.concat("%");


                    spnMonTimeOn4.setSelection(getIndex(spnMonTimeOn4, MonTimeOn4));
                    spnMonTimeOff4.setSelection(getIndex(spnMonTimeOff4, MonTimeOff4));
                    spnMonValue4.setSelection(getIndex(spnMonValue4, MonValue4));
                    spnTueTimeOn4.setSelection(getIndex(spnTueTimeOn4, TueTimeOn4));
                    spnTueTimeOff4.setSelection(getIndex(spnTueTimeOff4, TueTimeOff4));
                    spnTueValue4.setSelection(getIndex(spnTueValue4, TueValue4));
                    spnWedTimeOn4.setSelection(getIndex(spnWedTimeOn4, WedTimeOn4));
                    spnWedTimeOff4.setSelection(getIndex(spnWedTimeOff4, WedTimeOff4));
                    spnWedValue4.setSelection(getIndex(spnWedValue4, WedValue4));
                    spnThuTimeOn4.setSelection(getIndex(spnThuTimeOn4, ThuTimeOn4));
                    spnThuTimeOff4.setSelection(getIndex(spnThuTimeOff4, ThuTimeOff4));
                    spnThuValue4.setSelection(getIndex(spnThuValue4, ThuValue4));
                    spnFriTimeOn4.setSelection(getIndex(spnFriTimeOn4, FriTimeOn4));
                    spnFriTimeOff4.setSelection(getIndex(spnFriTimeOff4, FriTimeOff4));
                    spnFriValue4.setSelection(getIndex(spnFriValue4, FriValue4));
                    spnSatTimeOn4.setSelection(getIndex(spnSatTimeOn4, SatTimeOn4));
                    spnSatTimeOff4.setSelection(getIndex(spnSatTimeOff4, SatTimeOff4));
                    spnSatValue4.setSelection(getIndex(spnSatValue4, SatValue4));
                    spnSunTimeOn4.setSelection(getIndex(spnSunTimeOn4, SunTimeOn4));
                    spnSunTimeOff4.setSelection(getIndex(spnSunTimeOff4, SunTimeOff4));
                    spnSunValue4.setSelection(getIndex(spnSunValue4, SunValue4));
                }
                else Toast.makeText(getActivity(), "Data setup 4 is error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getActivity(), "Read status of button Auto4 is failed", Toast.LENGTH_SHORT).show();
            }
        });


        /*--------------------------------------------------------------------------------*/
        /*--------------------------------------TB5---------------------------------------*/
        /*--------------------------------------------------------------------------------*/
        //Bắt sự kiện Button Reset
        btnReset5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spnMonTimeOn5.setSelection(0);
                spnMonTimeOff5.setSelection(0);
                spnMonValue5.setSelection(0);
                spnTueTimeOn5.setSelection(0);
                spnTueTimeOff5.setSelection(0);
                spnTueValue5.setSelection(0);
                spnWedTimeOn5.setSelection(0);
                spnWedTimeOff5.setSelection(0);
                spnWedValue5.setSelection(0);
                spnThuTimeOn5.setSelection(0);
                spnThuTimeOff5.setSelection(0);
                spnThuValue5.setSelection(0);
                spnFriTimeOn5.setSelection(0);
                spnFriTimeOff5.setSelection(0);
                spnFriValue5.setSelection(0);
                spnSatTimeOn5.setSelection(0);
                spnSatTimeOff5.setSelection(0);
                spnSatValue5.setSelection(0);
                spnSunTimeOn5.setSelection(0);
                spnSunTimeOff5.setSelection(0);
                spnSunValue5.setSelection(0);
            }
        });

        //Bắt sự kiện Button Setup
        btnSetup5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonTimeOn5 = spnMonTimeOn5.getSelectedItem().toString();
                MonTimeOff5 = spnMonTimeOff5.getSelectedItem().toString();
                MonValue5 = spnMonValue5.getSelectedItem().toString().replace("%","");
                TueTimeOn5 = spnTueTimeOn5.getSelectedItem().toString();
                TueTimeOff5 = spnTueTimeOff5.getSelectedItem().toString();
                TueValue5 = spnTueValue5.getSelectedItem().toString().replace("%","");
                WedTimeOn5 = spnWedTimeOn5.getSelectedItem().toString();
                WedTimeOff5 = spnWedTimeOff5.getSelectedItem().toString();
                WedValue5 = spnWedValue5.getSelectedItem().toString().replace("%","");
                ThuTimeOn5 = spnThuTimeOn5.getSelectedItem().toString();
                ThuTimeOff5 = spnThuTimeOff5.getSelectedItem().toString();
                ThuValue5 = spnThuValue5.getSelectedItem().toString().replace("%","");
                FriTimeOn5 = spnFriTimeOn5.getSelectedItem().toString();
                FriTimeOff5 = spnFriTimeOff5.getSelectedItem().toString();
                FriValue5 = spnFriValue5.getSelectedItem().toString().replace("%","");
                SatTimeOn5 = spnSatTimeOn5.getSelectedItem().toString();
                SatTimeOff5 = spnSatTimeOff5.getSelectedItem().toString();
                SatValue5 = spnSatValue5.getSelectedItem().toString().replace("%","");
                SunTimeOn5 = spnSunTimeOn5.getSelectedItem().toString();
                SunTimeOff5 = spnSunTimeOff5.getSelectedItem().toString();
                SunValue5 = spnSunValue5.getSelectedItem().toString().replace("%","");
                //nối chuỗi dữ liệu Setup để gửi lên Firebase
                valueSetup5 = "$AM;5;"+MonTimeOn5+";"+MonTimeOff5+";"+MonValue5+";"+TueTimeOn5+";"+TueTimeOff5+";"+TueValue5+";"+WedTimeOn5+";"+WedTimeOff5+";"+WedValue5+";"+ThuTimeOn5+";"+ThuTimeOff5+";"+ThuValue5+";"+FriTimeOn5+";"+FriTimeOff5+";"+FriValue5+";"+SatTimeOn5+";"+SatTimeOff5+";"+SatValue5+";"+SunTimeOn5+";"+SunTimeOff5+";"+SunValue5+"#";
                sAM5.setValue(valueSetup5);
            }
        });

        //Bắt sự kiện Button Auto
        btnAuto5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueAuto5.equals("0")){
                    AM5.setValue("1");
                }
                if(valueAuto5.equals("1")) {
                    AM5.setValue("0");
                }
            }
        });

        //Đọc trạng thái Auto từ Firebase
        AM5.addValueEventListener(new ValueEventListener() {
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
                Toast.makeText(getActivity(), "Read status of button Auto5 is failed", Toast.LENGTH_SHORT).show();
            }
        });

        //Đọc dữ liệu Setup từ Firebase
        sAM5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valueSetup5 = dataSnapshot.getValue(String.class);
                if(valueSetup5.startsWith("$") && valueSetup5.endsWith("#") ){
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+3, valueSetup5.length()-1);
                    MonTimeOn5 = valueSetup5.substring(0,valueSetup5.indexOf(";"));
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    MonTimeOff5 = valueSetup5.substring(0,valueSetup5.indexOf(";"));
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    MonValue5 = valueSetup5.substring(0,valueSetup5.indexOf(";")).concat("%");
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    TueTimeOn5 = valueSetup5.substring(0,valueSetup5.indexOf(";"));
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    TueTimeOff5 = valueSetup5.substring(0,valueSetup5.indexOf(";"));
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    TueValue5 = valueSetup5.substring(0,valueSetup5.indexOf(";")).concat("%");
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    WedTimeOn5 = valueSetup5.substring(0,valueSetup5.indexOf(";"));
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    WedTimeOff5 = valueSetup5.substring(0,valueSetup5.indexOf(";"));
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    WedValue5 = valueSetup5.substring(0,valueSetup5.indexOf(";")).concat("%");
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    ThuTimeOn5 = valueSetup5.substring(0,valueSetup5.indexOf(";"));
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    ThuTimeOff5 = valueSetup5.substring(0,valueSetup5.indexOf(";"));
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    ThuValue5 = valueSetup5.substring(0,valueSetup5.indexOf(";")).concat("%");
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    FriTimeOn5 = valueSetup5.substring(0,valueSetup5.indexOf(";"));
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    FriTimeOff5 = valueSetup5.substring(0,valueSetup5.indexOf(";"));
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    FriValue5 = valueSetup5.substring(0,valueSetup5.indexOf(";")).concat("%");
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    SatTimeOn5 = valueSetup5.substring(0,valueSetup5.indexOf(";"));
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    SatTimeOff5 = valueSetup5.substring(0,valueSetup5.indexOf(";"));
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    SatValue5 = valueSetup5.substring(0,valueSetup5.indexOf(";")).concat("%");
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    SunTimeOn5 = valueSetup5.substring(0,valueSetup5.indexOf(";"));
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    SunTimeOff5 = valueSetup5.substring(0,valueSetup5.indexOf(";"));
                    valueSetup5 = valueSetup5.substring(valueSetup5.indexOf(";")+1);
                    SunValue5 = valueSetup5.concat("%");


                    spnMonTimeOn5.setSelection(getIndex(spnMonTimeOn5, MonTimeOn5));
                    spnMonTimeOff5.setSelection(getIndex(spnMonTimeOff5, MonTimeOff5));
                    spnMonValue5.setSelection(getIndex(spnMonValue5, MonValue5));
                    spnTueTimeOn5.setSelection(getIndex(spnTueTimeOn5, TueTimeOn5));
                    spnTueTimeOff5.setSelection(getIndex(spnTueTimeOff5, TueTimeOff5));
                    spnTueValue5.setSelection(getIndex(spnTueValue5, TueValue5));
                    spnWedTimeOn5.setSelection(getIndex(spnWedTimeOn5, WedTimeOn5));
                    spnWedTimeOff5.setSelection(getIndex(spnWedTimeOff5, WedTimeOff5));
                    spnWedValue5.setSelection(getIndex(spnWedValue5, WedValue5));
                    spnThuTimeOn5.setSelection(getIndex(spnThuTimeOn5, ThuTimeOn5));
                    spnThuTimeOff5.setSelection(getIndex(spnThuTimeOff5, ThuTimeOff5));
                    spnThuValue5.setSelection(getIndex(spnThuValue5, ThuValue5));
                    spnFriTimeOn5.setSelection(getIndex(spnFriTimeOn5, FriTimeOn5));
                    spnFriTimeOff5.setSelection(getIndex(spnFriTimeOff5, FriTimeOff5));
                    spnFriValue5.setSelection(getIndex(spnFriValue5, FriValue5));
                    spnSatTimeOn5.setSelection(getIndex(spnSatTimeOn5, SatTimeOn5));
                    spnSatTimeOff5.setSelection(getIndex(spnSatTimeOff5, SatTimeOff5));
                    spnSatValue5.setSelection(getIndex(spnSatValue5, SatValue5));
                    spnSunTimeOn5.setSelection(getIndex(spnSunTimeOn5, SunTimeOn5));
                    spnSunTimeOff5.setSelection(getIndex(spnSunTimeOff5, SunTimeOff5));
                    spnSunValue5.setSelection(getIndex(spnSunValue5, SunValue5));
                }
                else Toast.makeText(getActivity(), "Data setup 5 is error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getActivity(), "Read status of button Auto5 is failed", Toast.LENGTH_SHORT).show();
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



package com.example.aasthasona.gsf;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;


public class MainActivity extends Activity {


    protected TextView txtspchinpt;
    protected Button bttn;
    protected final int REQUEST_CODE=100;
    protected String lang="en-US";
    public ArrayList<String> result;
    protected EditText delay;
    protected Button dsend;
    public Button spchstp;
    protected Switch slgsw;
    protected EditText slgtxt1;
    protected EditText slgtxt2;
    private int a=0;
    protected Button slg;
    private String res;
    private int ww=0;


    public ListView avldevices;

    public BluetoothAdapter mBTAdapter;
    public BluetoothSocket mmSocket;
    public  OutputStream mmOutStream;
    public ArrayAdapter<String> mPairedDevicesArrayAdapter;
    private static final String IQI_UUID = "00001101-0000-1000-8000-00805f9b34fb";

    private Database_main db = new Database_main(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //database upload.

        Log.d("Insert", "Inserting..");
        db.putinformation(new VARIABLES("a", "7",null,null,null));
        db.putinformation(new VARIABLES("in","34",null,null,null));
        db.putinformation(new VARIABLES("be","24",null,null,null));
        db.putinformation(new VARIABLES("about","7","72",null,null));
        db.putinformation(new VARIABLES("above","7","72","7245",null));
        db.putinformation(new VARIABLES("across","7","71","7234",null));
        db.putinformation(new VARIABLES("after","7","712",null,null));
        db.putinformation(new VARIABLES("afternoon","7","712","7134",null));
        db.putinformation(new VARIABLES("afterward","7","712","1235",null));
        db.putinformation(new VARIABLES("again","7","7123",null,null));
        db.putinformation(new VARIABLES("against","7","7123","14",null));
        db.putinformation(new VARIABLES("almost","7","724","714",null));
        db.putinformation(new VARIABLES("already","7","724","7234",null));
        db.putinformation(new VARIABLES("also","7","724",null,null));
        db.putinformation(new VARIABLES("although","7","724","7135",null));
        db.putinformation(new VARIABLES("altogether","7","724","1234",null));
        db.putinformation(new VARIABLES("always","7","724","1235",null));
        db.putinformation(new VARIABLES("and","71245",null,null,null));
        db.putinformation(new VARIABLES("as","7345",null,null,null));
        db.putinformation(new VARIABLES("because","24","71",null,null));
        db.putinformation(new VARIABLES("before","24","712",null,null));
        db.putinformation(new VARIABLES("behind","24","723",null,null));
        db.putinformation(new VARIABLES("below","24","724",null,null));
        db.putinformation(new VARIABLES("beneath","24","7134",null,null));
        db.putinformation(new VARIABLES("beside","24","124",null,null));
        db.putinformation(new VARIABLES("between","24","1234",null,null));
        db.putinformation(new VARIABLES("beyond", "24","71345",null,null));
        db.putinformation(new VARIABLES("blind","72","724",null,null));
        db.putinformation(new VARIABLES("braille","72","7234","724",null));
        db.putinformation(new VARIABLES("but","72",null,null,null));
        db.putinformation(new VARIABLES("can","71",null,null,null));
        db.putinformation(new VARIABLES("child","75",null,null,null));
        db.putinformation(new VARIABLES("children","75","7134",null,null));
        db.putinformation(new VARIABLES("conceive","23","71","7245",null));
        db.putinformation(new VARIABLES("conceiving","23","71","7245","7123"));
        db.putinformation(new VARIABLES("deceive","713","71","7245",null));
        db.putinformation(new VARIABLES("deceiving","713","71","7245","7123"));
        db.putinformation(new VARIABLES("declare","713","71","724",null));
        db.putinformation(new VARIABLES("declaring","713","71","724","7123"));
        db.putinformation(new VARIABLES("do","713",null,null,null));
        db.putinformation(new VARIABLES("either","73","12",null,null));
        db.putinformation(new VARIABLES("enough","25",null,null,null));
        db.putinformation(new VARIABLES("every","73",null,null,null));
        db.putinformation(new VARIABLES("first","712","14",null,null));
        db.putinformation(new VARIABLES("for","712345",null,null,null));
        db.putinformation(new VARIABLES("friends","712","7234",null,null));
        db.putinformation(new VARIABLES("from","712",null,null,null));
        db.putinformation(new VARIABLES("go","7123",null,null,null));
        db.putinformation(new VARIABLES("good","7123","123",null,null));
        db.putinformation(new VARIABLES("great","7123","7234","1234",null));
        db.putinformation(new VARIABLES("have","723",null,null,null));
        db.putinformation(new VARIABLES("herself","723","71235","712",null));
        db.putinformation(new VARIABLES("him","723","714",null,null));
        db.putinformation(new VARIABLES("himself","723","714","712",null));
        db.putinformation(new VARIABLES("his","245",null,null,null));
        db.putinformation(new VARIABLES("immediate","12","714","714",null));
        db.putinformation(new VARIABLES("into","34","234",null,null));
        db.putinformation(new VARIABLES("it","24",null,null,null));
        db.putinformation(new VARIABLES("its","7145","124",null,null));
        db.putinformation(new VARIABLES("itself","7145","712",null,null));
        db.putinformation(new VARIABLES("just","123",null,null,null));
        db.putinformation(new VARIABLES("knowledge","74",null,null,null));
        db.putinformation(new VARIABLES("letter","724","7234",null,null));
        db.putinformation(new VARIABLES("like","724",null,null,null));
        db.putinformation(new VARIABLES("little","724","724",null,null));
        db.putinformation(new VARIABLES("more","714",null,null,null));
        db.putinformation(new VARIABLES("much", "714","75",null,null));
        db.putinformation(new VARIABLES("must","714","14",null,null));
        db.putinformation(new VARIABLES("myself","714","71345","712",null));
        db.putinformation(new VARIABLES("necessary","7134","73","71",null));
        db.putinformation(new VARIABLES("neither","7134","73","12",null));
        db.putinformation(new VARIABLES("not","7134",null,null,null));
        db.putinformation(new VARIABLES("o'clock","734","4","71",null));
        db.putinformation(new VARIABLES("of","72345",null,null,null));
        db.putinformation(new VARIABLES("oneself","3","734","712",null));
        db.putinformation(new VARIABLES("ourselves","7235","7234","7245","124"));
        db.putinformation(new VARIABLES("out","7235",null,null,null));
        db.putinformation(new VARIABLES("paid","7124","713",null,null));
        db.putinformation(new VARIABLES("people","7124",null,null,null));
        db.putinformation(new VARIABLES("perceive","7124","71235","71","7245"));
        db.putinformation(new VARIABLES("perhaps","7124","71235","723",null));
        db.putinformation(new VARIABLES("quick","71234","74",null,null));
        db.putinformation(new VARIABLES("quite","71234",null,null,null));
        db.putinformation(new VARIABLES("rather","7245",null,null,null));
        db.putinformation(new VARIABLES("receive","7234","71","7245",null));
        db.putinformation(new VARIABLES("receiving","7234","71","7245","7123"));
        db.putinformation(new VARIABLES("rejoice","7234","123","71",null));
        db.putinformation(new VARIABLES("rejoicing","7234","123","71","7123"));
        db.putinformation(new VARIABLES("said","124","713",null,null));
        db.putinformation(new VARIABLES("shall","715",null,null,null));
        db.putinformation(new VARIABLES("should","715","713",null,null));
        db.putinformation(new VARIABLES("so","124",null,null,null));
        db.putinformation(new VARIABLES("still","14",null,null,null));
        db.putinformation(new VARIABLES("such","124","75",null,null));
        db.putinformation(new VARIABLES("that","1234",null,null,null));
        db.putinformation(new VARIABLES("the","1245",null,null,null));
        db.putinformation(new VARIABLES("themselves","1245","714","7245","124"));
        db.putinformation(new VARIABLES("thyself","7135","71345","712",null));
        db.putinformation(new VARIABLES("to","234",null,null,null));
        db.putinformation(new VARIABLES("today","1234","713",null,null));
        db.putinformation(new VARIABLES("together","1234","7123","1234",null));
        db.putinformation(new VARIABLES("tomorrow","1234","714",null,null));
        db.putinformation(new VARIABLES("tonight","1234","7134",null,null));
        db.putinformation(new VARIABLES("us","745",null,null,null));
        db.putinformation(new VARIABLES("very","7245",null,null,null));
        db.putinformation(new VARIABLES("was","345",null,null,null));
        db.putinformation(new VARIABLES("by","345",null,null,null));
        db.putinformation(new VARIABLES("were","2345",null,null,null));
        db.putinformation(new VARIABLES("which","735",null,null,null));
        db.putinformation(new VARIABLES("will","1235",null,null,null));
        db.putinformation(new VARIABLES("with","12345",null,null,null));
        db.putinformation(new VARIABLES("would","1235","713",null,null));
        db.putinformation(new VARIABLES("you","71345",null,null,null));
        db.putinformation(new VARIABLES("your","71345","7234",null,null));
        db.putinformation(new VARIABLES("yourself","71345","7234","712",null));
        db.putinformation(new VARIABLES("yourselves","71345","7234","7245","124"));

        Log.d("completion","Insertion Complete!");
        //upgradation.

        db.upinfo(new VARIABLES("a", "a",null,null,null));
        db.upinfo(new VARIABLES("in","r",null,null,null));
        db.upinfo(new VARIABLES("be","p",null,null,null));
        db.upinfo(new VARIABLES("about","a","h",null,null));
        db.upinfo(new VARIABLES("above","a","h","T",null));
        db.upinfo(new VARIABLES("across","a","g","P",null));
        db.upinfo(new VARIABLES("after","a","t",null,null));
        db.upinfo(new VARIABLES("afternoon","a","t","N",null));
        db.upinfo(new VARIABLES("afterward","a","t","W",null));
        db.upinfo(new VARIABLES("again","a","M",null,null));
        db.upinfo(new VARIABLES("against","a","M","m",null));
        db.upinfo(new VARIABLES("almost","a","x","v",null));
        db.upinfo(new VARIABLES("already","a","x","P",null));
        db.upinfo(new VARIABLES("also","a","x",null,null));
        db.upinfo(new VARIABLES("although","a","x","S",null));
        db.upinfo(new VARIABLES("altogether","a","x","V",null));
        db.upinfo(new VARIABLES("always","a","x","W",null));
        db.upinfo(new VARIABLES("and","71245",null,null,null));
        db.upinfo(new VARIABLES("as","Q",null,null,null));
        db.upinfo(new VARIABLES("because","p","g",null,null));
        db.upinfo(new VARIABLES("before","p","t",null,null));
        db.upinfo(new VARIABLES("behind","p","y",null,null));
        db.upinfo(new VARIABLES("below","p","x",null,null));
        db.upinfo(new VARIABLES("beneath","p","N",null,null));
        db.upinfo(new VARIABLES("beside","p","E",null,null));
        db.upinfo(new VARIABLES("between","p","V",null,null));
        db.upinfo(new VARIABLES("beyond", "p","@",null,null));
        db.upinfo(new VARIABLES("blind","h","x",null,null));
        db.upinfo(new VARIABLES("braille","h","P","x",null));
        db.upinfo(new VARIABLES("but","h",null,null,null));
        db.upinfo(new VARIABLES("can","g",null,null,null));
        db.upinfo(new VARIABLES("child","i",null,null,null));
        db.upinfo(new VARIABLES("children","i","N",null,null));
        db.upinfo(new VARIABLES("conceive","o","g","T",null));
        db.upinfo(new VARIABLES("conceiving","o","g","T","M"));
        db.upinfo(new VARIABLES("deceive","u","g","T",null));
        db.upinfo(new VARIABLES("deceiving","u","g","T","M"));
        db.upinfo(new VARIABLES("declare","u","g","x",null));
        db.upinfo(new VARIABLES("declaring","u","g","x","M"));
        db.upinfo(new VARIABLES("do","u",null,null,null));
        db.upinfo(new VARIABLES("either","k","l",null,null));
        db.upinfo(new VARIABLES("enough","q",null,null,null));
        db.upinfo(new VARIABLES("every","k",null,null,null));
        db.upinfo(new VARIABLES("first","t","m",null,null));
        db.upinfo(new VARIABLES("for","$",null,null,null));
        db.upinfo(new VARIABLES("friends","t","P",null,null));
        db.upinfo(new VARIABLES("from","t",null,null,null));
        db.upinfo(new VARIABLES("go","M",null,null,null));
        db.upinfo(new VARIABLES("good","M","D",null,null));
        db.upinfo(new VARIABLES("great","M","P","V",null));
        db.upinfo(new VARIABLES("have","y",null,null,null));
        db.upinfo(new VARIABLES("herself","y","#","t",null));
        db.upinfo(new VARIABLES("him","y","v",null,null));
        db.upinfo(new VARIABLES("himself","y","v","t",null));
        db.upinfo(new VARIABLES("his","K",null,null,null));
        db.upinfo(new VARIABLES("immediate","l","v","v",null));
        db.upinfo(new VARIABLES("into","r","I",null,null));
        db.upinfo(new VARIABLES("it","p",null,null,null));
        db.upinfo(new VARIABLES("its","U","E",null,null));
        db.upinfo(new VARIABLES("itself","U","t",null,null));
        db.upinfo(new VARIABLES("just","D",null,null,null));
        db.upinfo(new VARIABLES("knowledge","j",null,null,null));
        db.upinfo(new VARIABLES("letter","x","P",null,null));
        db.upinfo(new VARIABLES("like","x",null,null,null));
        db.upinfo(new VARIABLES("little","x","x",null,null));
        db.upinfo(new VARIABLES("more","v",null,null,null));
        db.upinfo(new VARIABLES("much", "v","i",null,null));
        db.upinfo(new VARIABLES("must","v","m",null,null));
        db.upinfo(new VARIABLES("myself","v","@","t",null));
        db.upinfo(new VARIABLES("necessary","N","k","g",null));
        db.upinfo(new VARIABLES("neither","N","k","l",null));
        db.upinfo(new VARIABLES("not","N",null,null,null));
        db.upinfo(new VARIABLES("o'clock","A","e","g",null));
        db.upinfo(new VARIABLES("of","*",null,null,null));
        db.upinfo(new VARIABLES("oneself","d","A","t",null));
        db.upinfo(new VARIABLES("ourselves","R","P","T","E"));
        db.upinfo(new VARIABLES("out","R",null,null,null));
        db.upinfo(new VARIABLES("paid","O","u",null,null));
        db.upinfo(new VARIABLES("people","O",null,null,null));
        db.upinfo(new VARIABLES("perceive","O","#","g","T"));
        db.upinfo(new VARIABLES("perhaps","O","#","y",null));
        db.upinfo(new VARIABLES("quick","!","j",null,null));
        db.upinfo(new VARIABLES("quite","!",null,null,null));
        db.upinfo(new VARIABLES("rather","T",null,null,null));
        db.upinfo(new VARIABLES("receive","P","g","T",null));
        db.upinfo(new VARIABLES("receiving","P","g","T","M"));
        db.upinfo(new VARIABLES("rejoice","P","D","g",null));
        db.upinfo(new VARIABLES("rejoicing","P","D","g","M"));
        db.upinfo(new VARIABLES("said","E","u",null,null));
        db.upinfo(new VARIABLES("shall","w",null,null,null));
        db.upinfo(new VARIABLES("should","w","u",null,null));
        db.upinfo(new VARIABLES("so","E",null,null,null));
        db.upinfo(new VARIABLES("still","m",null,null,null));
        db.upinfo(new VARIABLES("such","E","i",null,null));
        db.upinfo(new VARIABLES("that","V",null,null,null));
        db.upinfo(new VARIABLES("the","Y",null,null,null));
        db.upinfo(new VARIABLES("themselves","Y","v","T","E"));
        db.upinfo(new VARIABLES("thyself","S","@","t",null));
        db.upinfo(new VARIABLES("to","I",null,null,null));
        db.upinfo(new VARIABLES("today","V","u",null,null));
        db.upinfo(new VARIABLES("together","V","M","V",null));
        db.upinfo(new VARIABLES("tomorrow","V","v",null,null));
        db.upinfo(new VARIABLES("tonight","V","N",null,null));
        db.upinfo(new VARIABLES("us","C",null,null,null));
        db.upinfo(new VARIABLES("very","T",null,null,null));
        db.upinfo(new VARIABLES("was","L",null,null,null));
        db.upinfo(new VARIABLES("by","L",null,null,null));
        db.upinfo(new VARIABLES("were","Z",null,null,null));
        db.upinfo(new VARIABLES("which","B",null,null,null));
        db.upinfo(new VARIABLES("will","W",null,null,null));
        db.upinfo(new VARIABLES("with","12345",null,null,null));
        db.upinfo(new VARIABLES("would","W","u",null,null));
        db.upinfo(new VARIABLES("you","@",null,null,null));
        db.upinfo(new VARIABLES("your","@","P",null,null));
        db.upinfo(new VARIABLES("yourself","@","P","t",null));
        db.upinfo(new VARIABLES("yourselves","@","P","T","E"));



        txtspchinpt = (TextView) findViewById(R.id.txtspchinpt);
        bttn = (Button) findViewById(R.id.bttn);
        spchstp = (Button) findViewById(R.id.stop);
        dsend = (Button) findViewById(R.id.button);
        delay = (EditText) findViewById(R.id.editText);
        avldevices = (ListView) findViewById(R.id.devices);
        slgsw = (Switch) findViewById(R.id.slandsw);
        slgtxt1 = (EditText) findViewById(R.id.slangtxt1);
        slgtxt2 = (EditText) findViewById(R.id.slangtxt2);

        spchstp.setVisibility(View.INVISIBLE);

        slgsw.setChecked(false);
        slgsw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    a=1;
                }
                else {
                    a=0;
                }
            }
        });

        if (a==0){
            slgtxt1.setEnabled(false);
            slgtxt2.setEnabled(false);
        }
        if (a==1){
            slgtxt2.setEnabled(true);
            slgtxt1.setEnabled(true);
        }



            }
    public void stop(View v){
        ww=1;
        spchstp.setVisibility(View.INVISIBLE);
        bttn.setVisibility(View.VISIBLE);
    }

    public void slang(View v){
        DATABASE_OP2 sdb = new DATABASE_OP2(this);
        int count = sdb.count();
        if (count<=10) {
            String b = slgtxt1.getText().toString();
            String c = slgtxt2.getText().toString();
            sdb.putinfo(new SLGVARIABLES(b, c));
        }
        else {
            Toast.makeText(getApplicationContext(),"Sorry,Database limit is 10 words only.",Toast.LENGTH_LONG).show();
        }
        }


    public void SPEECHSTART(View start){
        ww=0;
        spchstp.setVisibility(View.VISIBLE);
        bttn.setVisibility(View.INVISIBLE);
        speechInput();

    }

    public void RADIO(View view){
        boolean checked = ((RadioButton) view ).isChecked();
        switch (view.getId()) {
            case R.id.engus: {
                if (checked) {
                    lang = "en-US";
                }

                break;
            }
            case R.id.enguk: {
                if (checked) {
                    lang = "en-UK";
                }
                //eng uk.
                break;

            }
        }

    }

        private void speechInput() {
            Intent speech= new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            speech.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE,lang);
            speech.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS,true);
            speech.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS,5);
            speech.putExtra(RecognizerIntent.EXTRA_PROMPT, "We are listening...");

            try {
                startActivityForResult(speech, REQUEST_CODE);
            } catch (ActivityNotFoundException a) {
                Toast.makeText(getApplicationContext(), "Sorry! Your device doesn't support speech input", Toast.LENGTH_SHORT).show();

            }

        }

        @Override
        protected void onActivityResult(int requestcode,int resultcode,Intent data){
            super.onActivityResult(requestcode, resultcode, data);
            switch (requestcode){
                case REQUEST_CODE:

                    if (resultcode == RESULT_OK & null!=data) {
                        ArrayList<String>  tmps= data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        result = tmps;
                        res = result.get(0);
                        txtspchinpt.setText(result.get(0));
                        conversion();
                        if (ww==0){
                            speechInput();
                        }
                        }
                    break;
            }



        }


    public void BLUETOOTHSTART(View v) {

        mPairedDevicesArrayAdapter = new ArrayAdapter<>(this, R.layout.adapter_activity);

        mBTAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBTAdapter == null) {
            txtspchinpt.setText("DEVICE NOT SUPPORTED FOR BLUETOOTH CONNECTION");
            Log.d("rajat", "device not supported");
            return;
        }
        else {

            Log.d("rajat", "device supported");
        }

        if (mBTAdapter.isEnabled()) {
            Intent enableBTintent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBTintent, 1);

        }

        Log.d("rajat", "device is now enabled");


        Set<BluetoothDevice> paireddevices = mBTAdapter.getBondedDevices();
        if (paireddevices.size() > 0) {
            for (BluetoothDevice device : paireddevices)
                mPairedDevicesArrayAdapter.add(device.getName() + "\n" + device.getAddress());
        }
        avldevices.setVisibility(View.VISIBLE);
        avldevices.setAdapter(mPairedDevicesArrayAdapter);

        Log.d("rajat", "already paired devices now being shown");

        Intent discoverBT = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivity(discoverBT);

        mBTAdapter.startDiscovery();

        if (mBTAdapter.isDiscovering()) {
            Toast.makeText(getApplicationContext(), "MAKING YOUR DEVICE DISCOVERABLE", Toast.LENGTH_LONG).show();
        }



        Log.d("rajat", "discovering new devices");

        BroadcastReceiver mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                final BluetoothDevice device;
                if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                    device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    mPairedDevicesArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                    avldevices.setAdapter(mPairedDevicesArrayAdapter);
                }

            }
        };
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mReceiver, filter);

        Log.d("rajat", "all the devices must be populated by now");
        //onitemclicklistener.

        avldevices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String info= ((TextView)view).getText().toString();
                mBTAdapter.cancelDiscovery();
                String address= info.substring(info.length()-17);
                BluetoothDevice connect_device = mBTAdapter.getRemoteDevice(address);

                Log.d("rajat", connect_device.getName());
                Log.d("rajat", "this device has been selected");

                BluetoothSocket tmp=null;
                try{
                    Log.d("rajat", "connecting 1");
                    tmp= connect_device.createRfcommSocketToServiceRecord(UUID.fromString(IQI_UUID));
                    Log.d("rajat", "connecting 2");
                    mmSocket =tmp;


                    if (mmSocket == null) {
                        Log.d("rajat", "Couldn't establish connection with the device for some reason");
                        return;
                    }

                    if (mmSocket!=null){

                        Log.d("rajat", "connecting 3");
                        try {
                            mmSocket.connect();
                        }catch (IOException e){
                            Log.d("rajat","not connected.");
                            mmSocket.close();
                            mmSocket = null;
                            return;
                        }

                        Log.d("rajat", "device connection established");
                        avldevices.setVisibility(View.INVISIBLE);

                        OutputStream tmpOut =null;

                        try {
                            Log.d("rajat", "trying to establish output stream to the connected device");
                            tmpOut = mmSocket.getOutputStream();
                        } catch (IOException e){}


                        mmOutStream = tmpOut;

                        Log.d("rajat", "output stream established");
                    }
                }


                catch (IOException e){ }
            }
        });
    }

    public void delay(View v){ /*this method is for sending the time period(secs) for which the dots will be raised.*/
        delay.setText("");
        String d = delay.getText().toString();
        if (d.equals("100")){
            String f = "1";
            byte[] Dbytes = f.getBytes();
            try {
                mmOutStream.write(Dbytes);
            }catch (IOException e){}
        }
        else if (d.equals("200")){
            String f = "2";
            byte[] Dbytes = f.getBytes();
            try {
                mmOutStream.write(Dbytes);
            }catch (IOException e){}
        }
        else if (d.equals("300")){
            String f = "3";
            byte[] Dbytes = f.getBytes();
            try {
                mmOutStream.write(Dbytes);
            }catch (IOException e){}
        }
        else if (d.equals("400")){
            String f = "4";
            byte[] Dbytes = f.getBytes();
            try {
                mmOutStream.write(Dbytes);
            }catch (IOException e){}
        }
        else if (d.equals("500")){
            String f = "5";
            byte[] Dbytes = f.getBytes();
            try {
                mmOutStream.write(Dbytes);
            }catch (IOException e){}
        }
        else if (d.equals("600")){
            String f = "6";
            byte[] Dbytes = f.getBytes();
            try {
                mmOutStream.write(Dbytes);
            }catch (IOException e){}
        }
        else if (d.equals("700")){
            String f = "7";
            byte[] Dbytes = f.getBytes();
            try {
                mmOutStream.write(Dbytes);
            }catch (IOException e){}
        }
        else if (d.equals("800")){
            String f = "8";
            byte[] Dbytes = f.getBytes();
            try {
                mmOutStream.write(Dbytes);
            }catch (IOException e){}
        }
        else if (d.equals("900")){
            String f = "9";
            byte[] Dbytes = f.getBytes();
            try {
                mmOutStream.write(Dbytes);
            }catch (IOException e){}
        }
        else if (d.equals("950")){
            String f = "0";
            byte[] Dbytes = f.getBytes();
            try {
                mmOutStream.write(Dbytes);
            }catch (IOException e){}
        }
        else if (d.equals("1000")){
            String f = "%";
            byte[] Dbytes = f.getBytes();
            try {
                mmOutStream.write(Dbytes);
            }catch (IOException e){}
        }
        else if (d.equals("1050")){
            String f = "<";
            byte[] Dbytes = f.getBytes();
            try {
                mmOutStream.write(Dbytes);
            }catch (IOException e){}
        }
        else if (d.equals("1100")){
            String f = ">";
            byte[] Dbytes = f.getBytes();
            try {
                mmOutStream.write(Dbytes);
            }catch (IOException e){}
        }
        else if (d.equals("1150")){
            String f = ",";
            byte[] Dbytes = f.getBytes();
            try {
                mmOutStream.write(Dbytes);
            }catch (IOException e){}
        }
        else if (d.equals("1200")){
            String f = ".";
            byte[] Dbytes = f.getBytes();
            try {
                mmOutStream.write(Dbytes);
            }catch (IOException e){}
        }
        else {
            txtspchinpt.setText("not an option");
        }


    }

    void conversion(){

        Log.d("rajat","conversion start");

        int j,n=0,d;
        VARIABLES data;
        byte[] Dbytes;

        String cell1;
        String cell2;
        String cell3;
        String cell4;


        res = res.toLowerCase();
        res = res + " ";
        int l= res.length();

        char tmpArray[] = (res).toCharArray();

        Log.d("rajat","word filter");

        for (int i=0;i<l;i++){
          if (tmpArray[i] == ' '){
              char b[] = new char[i-n];
              for (j=0, d=n ; j< i-n ; d++, j++){
                  b[j] = tmpArray[d];
              }
              Log.d("rajat","word made");
              String c= new String(b);
               /* c contains string (converted from bso that it can be used to compare strings (database entries)*/
              if (c.equals("a") || c.equals("in") || c.equals("be") || c.equals("about") || c.equals("above") || c.equals("according") || c.equals("across") || c.equals("after") || c.equals("afternoon") || c.equals("afterward") || c.equals("again") || c.equals("almost") || c.equals("already") || c.equals("also") || c.equals("although") || c.equals("altogether") || c.equals("always") || c.equals("and") || c.equals("as") || c.equals("because") || c.equals("before") || c.equals("behind") || c.equals("below") || c.equals("beneath") || c.equals("beside") || c.equals("between") || c.equals("beyond") || c.equals("blind") || c.equals("blind") || c.equals("braille") || c.equals("but") || c.equals("can") || c.equals("child") || c.equals("children") || c.equals("conceive") || c.equals("conceiving") || c.equals("could") || c.equals("deceive") || c.equals("deceiving") || c.equals("declare") || c.equals("do") || c.equals("either") || c.equals("either") || c.equals("every") || c.equals("first") || c.equals("for") || c.equals("friend") || c.equals("from") || c.equals("from") || c.equals("go") || c.equals("good") || c.equals("great") || c.equals("have") || c.equals("herself") || c.equals("him") || c.equals("himself") || c.equals("his") || c.equals("immediate") || c.equals("into") || c.equals("it") || c.equals("its") || c.equals("itself") || c.equals("just") || c.equals("knowledge") || c.equals("letter") || c.equals("like") || c.equals("little") || c.equals("more") || c.equals("much") || c.equals("must") || c.equals("myself")|| c.equals("neither") || c.equals("not") || c.equals("o'clock") || c.equals("of") || c.equals("oneself") || c.equals("ourselves") || c.equals("out") || c.equals("paid") || c.equals("perceive") || c.equals("perhaps") || c.equals("quick") || c.equals("quite") || c.equals("rather") || c.equals("receive") || c.equals("receiving") || c.equals("rejoice") || c.equals("rejoicing") || c.equals("said") || c.equals("shall") || c.equals("should") || c.equals("so") || c.equals("still") || c.equals("such") || c.equals("that") || c.equals("the") || c.equals("themselves") || c.equals("thyself") || c.equals("to") || c.equals("today") || c.equals("together") || c.equals("tomorrow") || c.equals("tonight") || c.equals("us") || c.equals("very") || c.equals("was") || c.equals("by") || c.equals("were") || c.equals("which") || c.equals("will") || c.equals("with") || c.equals("would") || c.equals("you") || c.equals("your") || c.equals("yourself") || c.equals("yourselves")){

              data = db.readinfo(c);
              Log.d("rajat","database read");

                  n=(i+1);
                  Log.d("rajat","value found in database");
                  cell1 = data.getcell1();
                  Dbytes = cell1.getBytes();
                  try {
                      mmOutStream.write(Dbytes);
                  } catch (IOException e) {
                  }
                  cell2 = data.getCell2();
                  if (cell2 != null) {
                      Dbytes = cell2.getBytes();
                      try {
                          mmOutStream.write(Dbytes);
                      } catch (IOException e) {
                      }
                  }
                  cell3 = data.getCell3();
                  if (cell3 != null) {
                      Dbytes = cell3.getBytes();
                      try {
                          mmOutStream.write(Dbytes);
                      } catch (IOException e) {
                      }
                  }
                  cell4 = data.getCell4();
                  if (cell4 != null) {
                      Dbytes = cell4.getBytes();
                      try {
                          mmOutStream.write(Dbytes);
                      } catch (IOException e) {
                      }
                  }
              }
              else if (c.equalsIgnoreCase("perceiving")){
                  n=(i+1);
                  Log.d("rajat","perceiving");
                  cell1= "O";
                  Dbytes=cell1.getBytes();
                  try {
                      mmOutStream.write(Dbytes);
                  } catch (IOException e) {
                  }
                  cell2="#";
                  Dbytes = cell2.getBytes();
                  try {
                      mmOutStream.write(Dbytes);
                  } catch (IOException e) {
                      }
                  cell3="g";
                  Dbytes = cell3.getBytes();
                  try {
                      mmOutStream.write(Dbytes);
                  } catch (IOException e) {
                  }
                  cell4 = "T";
                  Dbytes=cell4.getBytes();
                  try {
                      mmOutStream.write(Dbytes);
                  } catch (IOException e) {
                  }
                  String cell5 = "M";
                  Dbytes=cell5.getBytes();
                  try {
                      mmOutStream.write(Dbytes);
                  } catch (IOException e) {
                  }
              }
              /* slang language.*/
              else if (a==1) {
                  Log.d("rajat","slang has to be checked");
                      DATABASE_OP2 sdb = new DATABASE_OP2(this);
                      SLGVARIABLES u = sdb.read(c);
                      String y = u.getContraction();
                      int le = y.length();
                      char slg[] = y.toCharArray();
                      n=(i+1);
                      for (int p = 0; p < le; p++) {

                          switch (slg[j]) {
                              case 'a': {
                                  if (slg[p++] == 'r') {
                                      cell1 = "G";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      p++;

                                  } else {
                                      cell1 = "a";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }

                                  }
                                  break;

                              }
                              case 'b': {
                                  if (slg[p++] == 'b') {
                                      cell1 = "p";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      p++;

                                  } else if (slg[p++] == 'e') {
                                      cell1 = "p";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      p++;
                                  } else {
                                      cell1 = "h";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }

                                  }
                                  break;
                              }
                              case 'c': {
                                  if (slg[p++] == 'h') {
                                      cell1 = "i";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      p++;

                                  } else if (slg[p++] == 'c') {
                                      cell1 = "o";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      p++;

                                  } else if (slg[p++] == 'o') {
                                      p++;
                                      if (slg[p++] == 'm') {
                                          cell1 = "s";
                                          Dbytes = cell1.getBytes();
                                          try {
                                              mmOutStream.write(Dbytes);
                                          } catch (IOException e) {
                                          }
                                          p++;
                                      } else if (slg[p++] == 'n') {
                                          cell1 = "o";
                                          Dbytes = cell1.getBytes();
                                          try {
                                              mmOutStream.write(Dbytes);
                                          } catch (IOException e) {
                                          }
                                          p++;
                                      }
                                  } else {
                                      cell1 = "g";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                  }
                                  break;
                              }
                              case 'd': {
                                  if (slg[p++] == 'd') {
                                      cell1 = "J";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      p++;
                                  } else {
                                      cell1 = "u";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                  }
                                  break;
                              }
                              case 'e': {
                                  if (slg[p++] == 'd') {
                                      cell1 = "7125";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      p++;
                                  } else if (slg[p++] == 'r') {
                                      cell1 = "#";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      p++;
                                  } else if (slg[p++] == 'n') {
                                      cell1 = "q";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      p++;
                                  } else if (slg[p++] == 'a') {
                                      cell1 = "c";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      p++;
                                  } else {
                                      cell1 = "k";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                  }
                                  break;
                              }
                              case 'f': {
                                  if (slg[p++] == 'f') {
                                      cell1 = "I";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      p++;
                                  } else {
                                      cell1 = "t";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                  }
                                  break;
                              }
                              case 'g': {
                                  if (slg[p++] == 'h') {
                                      cell1 = "z";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      p++;
                                  } else if (slg[p++] == 'g') {
                                      cell1 = "Z";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      p++;
                                  } else {
                                      cell1 = "M";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                  }
                                  break;
                              }

                              case 'h': {
                                  cell1 = "y";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                              case 'i': {
                                  if (slg[p++] == 'n') {
                                      int k = p + 2;
                                      if (slg[k] == 'g') {
                                          cell1 = "H";
                                          Dbytes = cell1.getBytes();
                                          try {
                                              mmOutStream.write(Dbytes);
                                          } catch (IOException e) {
                                          }
                                          p = k;
                                      } else {
                                          cell1 = "r";
                                          Dbytes = cell1.getBytes();
                                          try {
                                              mmOutStream.write(Dbytes);
                                          } catch (IOException e) {
                                          }
                                          p++;

                                      }
                                  }
                                  else {
                                      cell1 = "l";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }

                                  }
                                  break;
                              }
                              case 'j': {
                                  cell1 = "D";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                              case 'k': {
                                  cell1 = "j";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                              case 'l': {
                                  cell1 = "x";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                              case 'm': {
                                  cell1 = "v";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                              case 'n': {
                                  cell1 = "N";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                              case 'o': {
                                  if (slg[p++] == 'u') {
                                      cell1 = "R";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      p++;
                                  } else if (slg[p++] == 'w') {
                                      cell1 = "F";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      p++;

                                  } else {
                                      cell1 = "A";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                     }
                                  break;
                              }
                              case 'p': {
                                  cell1 = "O";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                              case 'q': {
                                  cell1 = "!";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                              case 'r': {
                                  cell1 = "P";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                              case 's': {
                                  if (slg[p++] == 'h') {
                                      cell1 = "w";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      p++;
                                  } else {
                                      cell1 = "E";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                  }
                                  break;
                              }
                              case 't': {
                                  cell1 = "V";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                              case 'u': {
                                  cell1 = "C";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                              case 'v': {
                                  cell1 = "T";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                              case 'w': {
                                  cell1 = "W";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                              case 'x': {
                                  cell1 = "U";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                              case 'y': {
                                  cell1 = "@";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                              case 'z': {
                                  cell1 = "Q";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                          }

                      }
                  }
                  else{Log.d("rajat","otherword");
                  for (j=0; j<i-n;j++) {
                      switch (b[j]) {
                          case 'a': {
                              if (j!=(i-n-1) && b[j++] == 'r') {
                                  cell1 = "G";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  j++;
                                  break;

                              } else {
                                  cell1 = "a";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }

                          }
                          case 'b': {
                              if (j!=(i-n-1) && b[j++] == 'b') {
                                  cell1 = "p";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  j++;
                                  break;
                              } else if(j!=(i-n-1) && b[j++]=='e'){
                                  cell1="p";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }j++;
                                  break;
                              }
                              else {
                                  cell1 = "h";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                          }
                          case 'c': {
                              if (j!=(i-n-1) && b[j++] == 'h') {
                                  cell1 = "i";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  j++;
                                  break;

                              } else if (j!=(i-n-1) && b[j++] == 'c') {
                                  cell1 = "o";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  j++;
                                  break;

                              } else if (j!=(i-n-1) && b[j++] == 'o') {
                                  j++;
                                  int o= (j);
                                  if (o!=(i-n-1) && b[j++] == 'm') {
                                      cell1 = "s";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      j++;
                                      break;
                                  } else if (o!=(i-n-1) && b[j++] == 'n') {
                                      cell1 = "o";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }
                                      j++;
                                      break;
                                  }
                              } else {
                                  cell1 = "g";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                          }
                          case 'd':{
                              if (j!=(i-n-1) && b[j++] == 'd'){
                                  cell1 = "J";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  j++;
                                  break;
                              }
                              else {
                                  cell1="u";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                          }
                          case 'e':{
                              if (j!=(i-n-1) && b[j++]=='d'){
                                  cell1="7125";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }j++;
                                  break;
                              }
                              else if (j!=(i-n-1) &&b[j++]=='r'){
                                  cell1="#";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }j++;
                                  break;
                              }
                              else if (j!=(i-n-1) && b[j++]=='n'){
                                  cell1="q";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }j++;
                                  break;
                              }
                              else if (j!=(i-n-1) && b[j++]=='a'){
                                  cell1="c";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }j++;
                                  break;
                              }
                              else{
                                  cell1="k";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                          }
                          case 'f':{
                              if (j!=(i-n-1) && b[j++]=='f'){
                                  cell1="I";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }j++;
                                  break;
                              }
                              else {
                                  cell1="t";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                          }
                          case 'g':{
                              if (j!=(i-n-1) && b[j++]=='h'){
                                  cell1="z";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }j++;
                                  break;
                              }
                                else if(j!=(i-n-1) && b[j++] == 'g') {
                                  cell1 = "Z";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  j++;
                                  break;
                              }

                              else {
                                  cell1="M";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                          }
                          case 'h':{
                              cell1="y";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case 'i':{
                              if (j!=(i-n-1) && b[j++]=='n'){
                                  int k = j+ 2;
                                  if (b[k]=='g'){
                                      cell1="H";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }j=k;
                                      break;
                                  }
                                  else {
                                      cell1="r";
                                      Dbytes = cell1.getBytes();
                                      try {
                                          mmOutStream.write(Dbytes);
                                      } catch (IOException e) {
                                      }j++;
                                      break;
                                  }
                              }
                              else if( j== 0 ) {
                                  cell1= "f";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }j++;
                                  cell2 = "l";
                                  Dbytes = cell2.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }j++;
                                  break;

                              }
                              else  {
                                  cell1 = "l";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                          }
                          case 'j':{
                              cell1 = "D";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case 'k':{
                              cell1="j";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case 'l':{
                              cell1="x";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case 'm':{
                              cell1="v";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case 'n':{
                              cell1="N";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case 'o':{
                              if (j!=(i-n-1) && b[j++]=='u'){
                                  cell1="R";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }j++;
                                  break;
                              }
                              else if (j!=(i-n-1) && b[j++]=='w'){
                                  cell1="F";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }j++;
                                  break;
                              }
                              else{
                                  cell1="A";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                          }
                          case 'p':{
                              cell1="O";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case 'q':{
                              cell1="!";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case 'r':{
                              cell1="P";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case 's':{
                              if (j!=(i-n-1) && b[j++]=='h'){
                                  cell1="w";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }j++;
                                  break;
                              }
                              else {
                                  cell1="E";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                          }
                          case 't':{
                              cell1="V";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case 'u':{
                              cell1="C";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case 'v':{
                              cell1="T";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case 'w':{
                              cell1="W";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case 'x':{
                              cell1="U";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case 'y':{
                              cell1="@";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case 'z':{
                              cell1="Q";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '/':{
                              cell1="m";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case ',':{
                              cell1="c";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '.':{
                              if (j!=(i-n-1) && b[j++]=='.'){
                              cell1="e";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              cell2="e";
                              Dbytes = cell2.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              cell3="e";
                              Dbytes = cell3.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                              }
                              else if (j == (i - n - 1)){ /* full stop*/

                                  cell1 = "J";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }
                              else { /* decimal point*/
                                  cell1= "n";
                                  Dbytes = cell1.getBytes();
                                  try {
                                      mmOutStream.write(Dbytes);
                                  } catch (IOException e) {
                                  }
                                  break;
                              }

                          }
                          case '?':{
                              cell1="K";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '$':{
                              cell1="J";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '!':{
                              cell1="I";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '-':{
                              cell1="s";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '#':{
                              cell1="X";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '’':{
                              cell1="e";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '_':{
                              cell1="s";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }

                              cell2="s";
                              Dbytes = cell2.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }

                              cell3="s";
                              Dbytes = cell3.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '>':{
                              cell1="b";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }

                              cell2="G";
                              Dbytes = cell2.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '<': {
                              cell1= "b";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }

                              cell2="z";
                              Dbytes = cell2.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '+':{
                              cell1="d";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }

                              cell2="I";
                              Dbytes = cell2.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '=':{
                              cell1="d";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }

                              cell2="Z";
                              Dbytes = cell2.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '@':{
                              cell1="b";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }

                              cell2="a";
                              Dbytes = cell2.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '€':{
                              cell1="b";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }

                              cell2="k";
                              Dbytes = cell2.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case 'æ':{
                              cell1="b";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }

                              cell2="n";
                              Dbytes = cell2.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }

                              cell3="a";
                              Dbytes = cell3.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;

                          }
                          case 'œ':{
                              cell1="b";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              cell2="n";
                              Dbytes = cell2.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              cell3="A";
                              Dbytes = cell3.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;

                          }
                          case '1':{
                              cell1="X";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }

                              cell2="a";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }break;
                          }
                          case '2':{
                              cell1="X";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              cell1="h";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '3':{
                              cell1="X";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              cell1="g";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '4': {
                              cell1 = "X";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              cell1="u";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '5': {
                              cell1="X";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              cell1="k";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '6':{
                              cell1="X";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              cell1="t";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '7':{
                              cell1="X";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              cell1="M";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '8':{
                              cell1="X";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              cell1="y";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '9':{
                              cell1="X";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              cell1="l";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          case '0':{
                              cell1="X";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              cell1="D";
                              Dbytes = cell1.getBytes();
                              try {
                                  mmOutStream.write(Dbytes);
                              } catch (IOException e) {
                              }
                              break;
                          }
                          default:{ break;}

                      }
                  }
                  n=(i+1);
                  }
              cell1 = "&";
              Dbytes = cell1.getBytes();
              try {
                  mmOutStream.write(Dbytes);
              } catch (IOException e) {
              }

              }

          }
        }

    }
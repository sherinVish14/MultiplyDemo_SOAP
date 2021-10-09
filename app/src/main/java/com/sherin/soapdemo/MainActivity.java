package com.sherin.soapdemo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sherin.soapdemo.globals.Constants;
import com.sherin.soapdemo.utils.NetworkUtils;
import com.sherin.soapdemo.utils.StringUtils;
import com.sherin.soapdemo.utils.UIUtils;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private static final String tag = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private EditText etConvert;
    private Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etConvert = (EditText) findViewById(R.id.etConvert);
        btnConvert = (Button) findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etConvert.getText()!=null && etConvert.getText().toString().length()>0) {
                    String toConvert = etConvert.getText().toString();

                    if (NetworkUtils.isConnectedToInternet(MainActivity.this)) {
                        // Using KSoap2 library
                      new AsyncTaskBraille().execute(toConvert);

                    }
                    else {
                        UIUtils.showSnackBar(MainActivity.this, "Please check your internet connection.");
                    }
                }
                else {
                    UIUtils.showSnackBar(MainActivity.this, "Please enter atleast 1 digit.");
                }
            }
        });

        UIUtils.showSnackBar(this, "Welcome");
    }

    protected void hideProgressDialog() {
        if (pDialog!=null) {
            pDialog.dismiss();
        }
    }

    private class AsyncTaskBraille extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = ProgressDialog.show(MainActivity.this,
                    "SOAP Demo",
                    "Processing...",
                    true);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i(tag, "API call completed");
            hideProgressDialog();

            if (StringUtils.hasValue(s)) {
                Log.i(tag, "Processing ...");
                Toast.makeText(MainActivity.this, "Result = "+s, Toast.LENGTH_SHORT).show();

            }

        }

        @Override
        protected String doInBackground(String... strings) {
            SoapObject request = new SoapObject(Constants.NAMESPACE, Constants.METHOD_NAME);
            request.addProperty("intA", strings[0]);
            request.addProperty("intB", "20");

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.implicitTypes = true;
            envelope.setOutputSoapObject(request);
            envelope.dotNet = true;

            HttpTransportSE httpTransportSE = new HttpTransportSE(Constants.API_BASE_URL);
            httpTransportSE.debug = true;

            try {
                httpTransportSE.call(Constants.SOAP_ACTION, envelope);
            } catch (IOException | XmlPullParserException e) {
                e.printStackTrace();
            }

            Object result = null;
            try {
                result = envelope.getResponse();
                Log.i(tag, String.valueOf(result));

            } catch (SoapFault soapFault) {
                soapFault.printStackTrace();
            }

            return result != null ? String.valueOf(result) : "";
        }
    }
}

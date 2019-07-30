package com.ta.drivingschoolinfo;


import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.ta.drivingschoolinfo.Adapter.adapter_home;
import com.ta.drivingschoolinfo.R;
import com.ta.drivingschoolinfo.upload;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class AdminActivity extends AppCompatActivity {

    Button btnLogOut;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    private static final int pilih_gambar = 1;
    private Button mpilihgambar;
    private Button muploadgambar;
    private TextView mlihathasilgambar;
    private EditText medittextnamalengkap;
    private EditText meditusia;
    private EditText meditalamatlengkap;
    private ImageView mphotodiri;
    private ProgressBar mProgressBar;
    private Uri mGambarUri;

    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;

    private StorageTask mUploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Button mpilihgambar = findViewById(R.id.pilihgambar);
        Button muploadgambar = findViewById(R.id.uploadgambar);
        mphotodiri = (ImageView) findViewById(R.id.mphotodiri);

        medittextnamalengkap = (EditText) findViewById(R.id.editText);
        meditusia = (EditText) findViewById(R.id.editText2);
        meditalamatlengkap = (EditText) findViewById(R.id.editText4);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mStorageRef = FirebaseStorage.getInstance().getReference("Photo");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Photo");

        btnLogOut = (Button) findViewById(R.id.sign_out);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(AdminActivity.this, LoginActivity.class);
                startActivity(I);

            }
        });

        mpilihgambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfilechooser();

            }
        });

        muploadgambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUploadTask != null && mUploadTask.isInProgress())
                {
                    Toast.makeText(AdminActivity.this,"Upload Sedang Berjalan", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    uploadFile();
                }

            }
        });



    }


    private void openfilechooser()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, pilih_gambar);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == pilih_gambar && resultCode == Activity.RESULT_OK
                && data != null && data.getData() != null) {
            mGambarUri = data.getData();
            Picasso.get().load(mGambarUri).fit().into(mphotodiri);
        }
    }

    private String getFileExtension(Uri uri)
    {
        ContentResolver cR = AdminActivity.this.getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadFile()
    {
        if (mGambarUri != null) {
            final StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(mGambarUri));

            mUploadTask = fileReference.putFile(mGambarUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Task<Uri>urlTask = taskSnapshot.getStorage().getDownloadUrl();
                            while (!urlTask.isSuccessful());
                            Uri downloadurl = urlTask.getResult();

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mProgressBar.setProgress(0);
                                }
                            }, 500);

                            Toast.makeText(AdminActivity.this, "Upload successful", Toast.LENGTH_LONG).show();
                            upload upload = new upload(medittextnamalengkap.getText().toString(),
                                    meditusia.getText().toString(),
                                    meditalamatlengkap.getText().toString(),
                                    downloadurl.toString());
                            String uploadId = mDatabaseRef.push().getKey();
                            mDatabaseRef.child(uploadId).setValue(upload);

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(AdminActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            mProgressBar.setProgress((int) progress);
                        }
                    });
        } else {
            Toast.makeText(AdminActivity.this, "Tidak Ada File", Toast.LENGTH_SHORT).show();
        }
    }
}
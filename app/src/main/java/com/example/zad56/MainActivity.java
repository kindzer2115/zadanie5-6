package com.example.zad56;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int liczbaPolubien = 0;
    private String ostatniZarejestrowanyEmail = "";
    private TextView licznikPolubien;
    private TextView obszarInformacji;
    private EditText poleEmail;
    private EditText poleHaslo;
    private EditText polePotwierdzHaslo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        licznikPolubien = findViewById(R.id.licznikPolubien);
        obszarInformacji = findViewById(R.id.obszarInformacji);
        poleEmail = findViewById(R.id.poleEmail);
        poleHaslo = findViewById(R.id.poleHaslo);
        polePotwierdzHaslo = findViewById(R.id.polePotwierdzHaslo);
        Button przyciskPolub = findViewById(R.id.przyciskPolub);
        Button przyciskUsunPolubienie = findViewById(R.id.przyciskUsunPolubienie);
        Button przyciskZapisz = findViewById(R.id.przyciskZapisz);
        Button przyciskPokazUczestnika = findViewById(R.id.przyciskPokazUczestnika);


        przyciskPolub.setOnClickListener(v -> {
            liczbaPolubien++;
            aktualizujWyswietlaniePolubien();
        });


        przyciskUsunPolubienie.setOnClickListener(v -> {
            if (liczbaPolubien > 0) {
                liczbaPolubien--;
                aktualizujWyswietlaniePolubien();
            }
        });


        przyciskZapisz.setOnClickListener(v -> {
            String email = poleEmail.getText().toString();
            String haslo = poleHaslo.getText().toString();
            String potwierdzHaslo = polePotwierdzHaslo.getText().toString();

            if (!email.contains("@")) {
                obszarInformacji.setText("Nieprawidłowy adres e-mail");
            } else if (!haslo.equals(potwierdzHaslo)) {
                obszarInformacji.setText("Hasła się różnią");
            } else {
                ostatniZarejestrowanyEmail = email;
                obszarInformacji.setText("Zarejestrowano: " + email);
            }
        });


        przyciskPokazUczestnika.setOnClickListener(v -> {
            if (!ostatniZarejestrowanyEmail.isEmpty()) {
                obszarInformacji.setText(ostatniZarejestrowanyEmail);
            }
        });
    }

    private void aktualizujWyswietlaniePolubien() {
        licznikPolubien.setText(liczbaPolubien + " polubień");
    }
}

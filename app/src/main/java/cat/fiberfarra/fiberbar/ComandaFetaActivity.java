package cat.fiberfarra.fiberbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ComandaFetaActivity extends AppCompatActivity {
    int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comanda_feta);

        // Declaring List Variable
        ArrayList<String> LlistaFrasesCelebres = new ArrayList<String>();

        // Adding item to List
        LlistaFrasesCelebres.add("Francisco José (Profe IDI): \"son mejores las parejas que los trios, en todos los sentidos\"");
        LlistaFrasesCelebres.add("Amador Millan (Profe SO): \"Lo siento, he perdido el control total del sistema operativo y se me ha bloqueado todo\"");
        LlistaFrasesCelebres.add("Kilian (profe lab CI): \"Si ves un agujero...\"");
        LlistaFrasesCelebres.add("Yolanda (profe SO) : \"Madre mia, se van a acabar las existencias de cerveza cuando volvamos a la normalidad\"");
        LlistaFrasesCelebres.add("Francesc Prats (profe FM): \"Escolta, et puc fer una pregunta íntima?\"");
        LlistaFrasesCelebres.add("Francesc Prats (profe FM): \"Jo profe que truco!\"");
        LlistaFrasesCelebres.add("Francesc Prats (profe FM): \"me caigo muerta como la Quki\"");
        LlistaFrasesCelebres.add("Francesc Prats (profe FM): \"Nen, digues-li al teu pare que el profe de mates s'ha fixat en tú, ja veuràs que content es posa...\"");
        LlistaFrasesCelebres.add("Francesc Prats (profe FM): \"Ara ve el moment gustós\"");
        LlistaFrasesCelebres.add("Francesc Prats (profe FM): \"Miénteme y dime que has estudiado FM\"");
        LlistaFrasesCelebres.add("Conrado Martinez (profe PRO2): \"\"Ahora deberias pensar: \"Que hace este haciendo preguntas dentro de un video si nadia puede responder?\" Bueno pues es lo mismo que pasa en clase, yo hago una pregunta y nadie responde\"");
        LlistaFrasesCelebres.add("Jordi Escayola (profe PE): \"Un niño muerto es caro, un niño tonto aun más\"");
        LlistaFrasesCelebres.add("Maria Teresa Abad (profe BD): \"Esto está un poco anticuado, debió hacerse antes de la ley del amtrimonio homosexual... bueno...\"");
        LlistaFrasesCelebres.add("Maria Teresa Abad (profe BD): \"Por donde meto mano\"");
        LlistaFrasesCelebres.add("Maria Teresa Abad (profe BD): \"Acabo con esto y vamos a lo que vamos\"");
        LlistaFrasesCelebres.add("Carlos Morata (profe SO): \"Ja no se restar un hexadecimal a aquestes hores\"");
        LlistaFrasesCelebres.add("Carlos Morata (profe SO): \"Cayetanos go home\"");
        LlistaFrasesCelebres.add("Francisco José (Profe IDI): \"Los diseñadores graficos estudiant mucho, nose como 6 meses o algo asi\"");


        Random rand = new Random();
        int rand_int1 = rand.nextInt(17);

        String message = LlistaFrasesCelebres.get(rand_int1);
        TextView mytextView = (TextView)findViewById(R.id.frase);
        mytextView.setText(message);

        String message2 = "número de comanda: "+ num;
        TextView mytextView2 = (TextView)findViewById(R.id.num_comanda);
        mytextView2.setText(message2);
    }
}
package co.edu.univalle.poe.mvc.controller;

import co.edu.univalle.poe.mvc.model.EstadoPartida;
import co.edu.univalle.poe.mvc.model.JuegoCraps;
import co.edu.univalle.poe.mvc.model.Lanzamiento;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CrapsController {

    private JuegoCraps juegoCraps;

    @FXML
    private ImageView imgDado1;

    @FXML
    private ImageView imgDado2;

    @FXML
    private Button btnLanzar;

    @FXML
    private Button btnNuevaPartida;

    @FXML
    private Label lblMensaje;

    @FXML
    private Label lblSuma;


    @FXML
    private void onLanzarDados(){
        //usar JuegoCraps
        Lanzamiento lanzamiento = juegoCraps.lanzarDados();
        int valorDado1 = lanzamiento.getDado1();
        int valorDado2 = lanzamiento.getDado2();
        int suma = lanzamiento.calcularSuma();

        //actualiza el resultado del lanzamiento en la vista
        lblSuma.setText(String.valueOf(suma));

        //actualiza imagenes de la vista  con el resultado del lanzamiento
        String rutaImagen = "/co/edu/univalle/poe/mvc/images/dado-" + valorDado1 + ".png";
        Image imagen = new Image(getClass().getResourceAsStream(rutaImagen));
        imgDado1.setImage(imagen);

        rutaImagen = "/co/edu/univalle/poe/mvc/images/dado-" + valorDado2 + ".png";
        imagen = new Image(getClass().getResourceAsStream(rutaImagen));
        imgDado2.setImage(imagen);

        actualizarEstadoPartida();
    }

    public CrapsController(){
        juegoCraps = new JuegoCraps();
    }

    private void actualizarEstadoPartida(){
        EstadoPartida estadoActual = juegoCraps.getEstadoPartida();
        switch (estadoActual){
            case GANADA: lblMensaje.setText("¡Ganaste la partida! Inicia una nueva para volver a jugar.");
                 btnLanzar.setDisable(true);
                 btnNuevaPartida.setDisable(false);
                break;
            case PERDIDA:
                lblMensaje.setText("Perdiste la partida. Inicia una nueva para intentarlo otra vez.");
                btnLanzar.setDisable(true);
                btnNuevaPartida.setDisable(false);
                break;
            case EN_CURSO:
                lblMensaje.setText("Punto establecido: " + juegoCraps.getPunto()
                                   + " Sigue lanzando. Ganas si repites el punto antes de obtener 7.");
                btnLanzar.setDisable(false);
                btnNuevaPartida.setDisable(true);
                break;
        }
    }
}

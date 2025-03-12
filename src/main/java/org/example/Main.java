package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Main {
    public static void main(String[] args) {


        Ruleta ruleta = new Ruleta();


        System.out.println("Estado inicial de la ruleta:");
        ruleta.mostrarEstado();


        for (int i = 0; i < 10; i++) {
            System.out.println("\nDisparo #" + (i + 1));
            if (ruleta.disparar()) {

                System.out.println("¡Juego terminado!");
                break;
            }
        }
    }


    public class Ruleta {

        private List<Integer> tambor;
        private int bala;
        private int posicionActual;
        private Random random;

        // Constructor Ruleta()
        public Ruleta() {
            this.tambor = new ArrayList<>();
            this.random = new Random();
            inicializarTambor();
            asignarBala();
            this.posicionActual = 0;
        }


        private void inicializarTambor() {
            for (int i = 0; i < 6; i++) {
                tambor.add(i);
            }
        }


        private void asignarBala() {
            this.bala = random.nextInt(tambor.size());
        }


        public boolean disparar() {

            posicionActual = (posicionActual + 1) % tambor.size();


            if (posicionActual == bala) {
                System.out.println("¡BANG! La bala está en la posición " + posicionActual);
                return true;
            } else {
                System.out.println("CLICK! No hay bala en la posición " + posicionActual);
                return false;
            }
        }


        public void mostrarEstado() {
            System.out.println("Estado actual de la ruleta:");
            System.out.println("Cámaras: " + tambor);
            System.out.println("Posición actual del tambor: " + posicionActual);
            System.out.println("Posición de la bala: " + bala);
        }


        public int getBala() {
            return bala;
        }


        public int getPosicionActual() {
            return posicionActual;
        }


        public List<Integer> getTambor() {
            return tambor;
        }


        public static void main(String[] args) {
            Ruleta ruleta = new Ruleta();
            ruleta.mostrarEstado();


            for (int i = 0; i < 10; i++) {
                if (ruleta.disparar()) {
                    break;
                }
            }
        }
    }
}

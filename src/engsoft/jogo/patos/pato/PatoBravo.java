package engsoft.jogo.patos.pato;

import engsoft.jogo.patos.comportamento.grasnar.PadraoGrasnar;
import engsoft.jogo.patos.comportamento.voar.VoaveisAsa;

/**
 * Mallard duck. Flies with wings and produces a more aggressive quack.
 */
public final class PatoBravo extends Pato implements PadraoGrasnar {

    public PatoBravo() {
        setComportamento(new VoaveisAsa());
    }

    @Override
    public String mostrar() {
        return "Eu sou o Pato Bravo.";
    }

    @Override
    public String grasnar() {
        return "Que-Que. Grrrrrrrrr.";
    }

}

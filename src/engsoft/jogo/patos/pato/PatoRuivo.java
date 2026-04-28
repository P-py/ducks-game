package engsoft.jogo.patos.pato;

import engsoft.jogo.patos.comportamento.grasnar.PadraoGrasnar;
import engsoft.jogo.patos.comportamento.voar.VoaveisAsa;

/**
 * Red duck. Flies with wings by default and quacks via {@link PadraoGrasnar}.
 */
public final class PatoRuivo extends Pato implements PadraoGrasnar {

    public PatoRuivo() {
        setComportamento(new VoaveisAsa());
    }

    @Override
    public String mostrar() {
        return "Eu sou o Pato Ruivo.";
    }

    @Override
    public String grasnar() {
        return "Que-Que.";
    }

}

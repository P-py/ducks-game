package engsoft.jogo.patos.pato;

import engsoft.jogo.patos.comportamento.pular.PuloAlto;
import engsoft.jogo.patos.comportamento.voar.VoaveisAsa;

/**
 * Athletic duck. Flies with wings and jumps high by default.
 */
public final class PatoAtleta extends Pato {

    public PatoAtleta() {
        setComportamento(new VoaveisAsa());
        setComportamentoPulo(new PuloAlto());
    }

    @Override
    public String mostrar() {
        return "Eu sou o Pato Atleta.";
    }

}

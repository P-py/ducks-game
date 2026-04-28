package engsoft.jogo.patos.pato;

import engsoft.jogo.patos.comportamento.pular.PuloDesordenado;
import engsoft.jogo.patos.comportamento.voar.VoaveisAsa;

/**
 * Crazy duck. Flies with wings and jumps in a chaotic, disordered pattern.
 */
public final class PatoLouco extends Pato {

    public PatoLouco() {
        setComportamento(new VoaveisAsa());
        setComportamentoPulo(new PuloDesordenado());
    }

    @Override
    public String mostrar() {
        return "Eu sou o Pato Louco.";
    }

}

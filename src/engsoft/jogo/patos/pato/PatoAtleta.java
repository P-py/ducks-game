package engsoft.jogo.patos.pato;

import engsoft.jogo.patos.comportamento.correr.CorrerRapido;
import engsoft.jogo.patos.comportamento.pular.PuloAlto;
import engsoft.jogo.patos.comportamento.voar.VoaveisAsa;

/**
 * Athletic duck. Flies with wings, jumps high and runs fast by default.
 */
public final class PatoAtleta extends Pato {

    public PatoAtleta() {
        setComportamento(new VoaveisAsa());
        setComportamentoPulo(new PuloAlto());
        setComportamentoCorrer(new CorrerRapido());
    }

    @Override
    public String mostrar() {
        return "Eu sou o Pato Atleta.";
    }

}

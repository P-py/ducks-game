package engsoft.jogo.patos.pato;

import engsoft.jogo.patos.comportamento.pular.PadraoPulaveis;
import engsoft.jogo.patos.comportamento.voar.PadraoVoaveis;

/**
 * Base abstract duck. Holds the flying and jumping strategies as fields so
 * concrete ducks can be configured at construction time and reconfigured at
 * runtime via the corresponding setters.
 */
public abstract class Pato {

    protected PadraoVoaveis comportamentoPato;
    protected PadraoPulaveis comportamentoPulo;

    /**
     * Returns a description identifying the concrete duck.
     *
     * @return a human-readable description of this duck
     */
    public abstract String mostrar();

    /**
     * Generic swimming behavior shared by every duck.
     *
     * @return a description of the swim
     */
    public String nadar() {
        return "Pato Nadando.";
    }

    /**
     * Replaces the current flying strategy.
     *
     * @param padrao the new flying strategy
     */
    public void setComportamento(final PadraoVoaveis padrao) {
        this.comportamentoPato = padrao;
    }

    /**
     * Replaces the current jumping strategy.
     *
     * @param padrao the new jumping strategy
     */
    public void setComportamentoPulo(final PadraoPulaveis padrao) {
        this.comportamentoPulo = padrao;
    }

    /**
     * Delegates flying to the configured {@link PadraoVoaveis}.
     *
     * @return the description produced by the current flying strategy
     */
    public String voar() {
        return comportamentoPato.voar();
    }

    /**
     * Delegates jumping to the configured {@link PadraoPulaveis}.
     *
     * @return the description produced by the current jumping strategy
     */
    public String pular() {
        return comportamentoPulo.pular();
    }

}

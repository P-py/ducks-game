package engsoft.jogo.patos;

import engsoft.jogo.patos.comportamento.pular.PadraoPulaveis;
import engsoft.jogo.patos.comportamento.pular.PuloCertinho;

/**
 * Rabbit. Reuses the jumping strategy via composition without inheriting from
 * {@code Pato}, illustrating that behavior reuse does not require a shared
 * base class.
 */
public final class Coelho {

    private PadraoPulaveis comportamentoPulo;

    public Coelho() {
        this.comportamentoPulo = new PuloCertinho();
    }

    /**
     * Returns a description identifying the rabbit.
     *
     * @return a human-readable description
     */
    public String mostrar() {
        return "Eu sou um Coelho!";
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
     * Delegates jumping to the configured {@link PadraoPulaveis}.
     *
     * @return the description produced by the current jumping strategy
     */
    public String pular() {
        return comportamentoPulo.pular();
    }

}

package engsoft.jogo.patos.pato;

import engsoft.jogo.patos.comportamento.correr.NaoCorre;
import engsoft.jogo.patos.comportamento.correr.PadraoCorreveis;
import engsoft.jogo.patos.comportamento.pular.NaoPula;
import engsoft.jogo.patos.comportamento.pular.PadraoPulaveis;
import engsoft.jogo.patos.comportamento.voar.NaoVoa;
import engsoft.jogo.patos.comportamento.voar.PadraoVoaveis;

/**
 * Base abstract duck. Holds the flying, jumping and running strategies as
 * fields so concrete ducks can be configured at construction time and
 * reconfigured at runtime via the corresponding setters.
 *
 * Fields default to null-object strategies so subclasses that do not opt into
 * a behavior still produce sensible output instead of NullPointerException.
 */
public abstract class Pato {

    protected PadraoVoaveis comportamentoPato = new NaoVoa();
    protected PadraoPulaveis comportamentoPulo = new NaoPula();
    protected PadraoCorreveis comportamentoCorrer = new NaoCorre();

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
     * Replaces the current running strategy.
     *
     * @param padrao the new running strategy
     */
    public void setComportamentoCorrer(final PadraoCorreveis padrao) {
        this.comportamentoCorrer = padrao;
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

    /**
     * Delegates running to the configured {@link PadraoCorreveis}.
     *
     * @return the description produced by the current running strategy
     */
    public String correr() {
        return comportamentoCorrer.correr();
    }

}

package engsoft.jogo.patos.comportamento.correr;

/**
 * Strategy contract for running. Any class wanting running behavior depends on
 * this interface rather than on a concrete implementation.
 */
public interface PadraoCorreveis {

    /**
     * Performs the run.
     *
     * @return a description of the run
     */
    String correr();

}

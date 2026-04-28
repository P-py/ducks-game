package engsoft.jogo.patos.comportamento.pular;

/**
 * Strategy contract for jumping. Any class wanting jumping behavior depends
 * on this interface rather than on a concrete implementation.
 */
public interface PadraoPulaveis {

    /**
     * Performs the jump.
     *
     * @return a description of the jump
     */
    String pular();

}

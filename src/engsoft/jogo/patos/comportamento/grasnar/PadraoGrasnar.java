package engsoft.jogo.patos.comportamento.grasnar;

/**
 * Strategy contract for quacking. Implemented directly by ducks that quack
 * and by standalone sound sources such as {@link Apito}.
 */
public interface PadraoGrasnar {

    /**
     * Produces the quacking sound.
     *
     * @return a description of the sound produced
     */
    String grasnar();

}

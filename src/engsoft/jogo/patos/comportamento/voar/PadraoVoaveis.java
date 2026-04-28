package engsoft.jogo.patos.comportamento.voar;

/**
 * Strategy contract for flying. Every flying behavior must describe itself
 * via {@link #voar()} and expose its speed via {@link #getVelocidade()}.
 */
public interface PadraoVoaveis {

    /**
     * Performs the flight.
     *
     * @return a description of the flight
     */
    String voar();

    /**
     * Returns the speed associated with this flying strategy.
     *
     * @return the speed in arbitrary units
     */
    double getVelocidade();

}

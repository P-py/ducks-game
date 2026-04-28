package engsoft.jogo.patos.comportamento.grasnar;

/**
 * Whistle. Implements the same quacking contract a duck does, demonstrating
 * that {@link PadraoGrasnar} is not tied to the duck hierarchy.
 */
public final class Apito implements PadraoGrasnar {

    @Override
    public String grasnar() {
        return "Queeeeee";
    }

}

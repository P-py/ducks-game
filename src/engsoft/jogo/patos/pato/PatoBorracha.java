package engsoft.jogo.patos.pato;

import engsoft.jogo.patos.comportamento.voar.NaoVoa;

/**
 * Rubber duck. Cannot fly and does not implement {@code PadraoGrasnar} —
 * illustrating that the Strategy pattern lets behaviors be opted into per
 * concrete class instead of forced by the base hierarchy.
 */
public final class PatoBorracha extends Pato {

    public PatoBorracha() {
        setComportamento(new NaoVoa());
    }

    @Override
    public String mostrar() {
        return "Olá, eu sou de Borracha.";
    }

}

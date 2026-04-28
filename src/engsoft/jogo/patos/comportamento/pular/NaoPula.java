package engsoft.jogo.patos.comportamento.pular;

/**
 * Null-object jumping strategy: the creature does not jump. Used as the default
 * so {@code Pato.pular()} can delegate uniformly even when a concrete duck
 * never opts into a jumping strategy.
 */
public final class NaoPula implements PadraoPulaveis {

    @Override
    public String pular() {
        return "Esse pato não pula.";
    }

}

package engsoft.jogo.patos.comportamento.correr;

/**
 * Null-object running strategy: the duck does not run. Acts as the safe default
 * so {@code Pato.correr()} can delegate uniformly even when a concrete duck
 * never opts into a running strategy.
 */
public final class NaoCorre implements PadraoCorreveis {

    @Override
    public String correr() {
        return "Esse pato não corre.";
    }

}

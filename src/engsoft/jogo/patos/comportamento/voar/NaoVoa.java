package engsoft.jogo.patos.comportamento.voar;

/**
 * Null-object flying strategy: the duck does not fly. Used by ducks that
 * cannot fly so the base class can still delegate uniformly.
 */
public final class NaoVoa implements PadraoVoaveis {

    private static final double VELOCIDADE = 0.0;

    @Override
    public String voar() {
        return "Esse pato não voa. Velocidade: " + getVelocidade();
    }

    @Override
    public double getVelocidade() {
        return VELOCIDADE;
    }

}

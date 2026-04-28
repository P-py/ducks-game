package engsoft.jogo.patos.comportamento.voar;

/**
 * Low-altitude flight at intermediate speed.
 */
public final class VoarRaso implements PadraoVoaveis {

    private static final double VELOCIDADE = 100.0;

    @Override
    public String voar() {
        return "Voando perto do chão. Velocidade: " + getVelocidade();
    }

    @Override
    public double getVelocidade() {
        return VELOCIDADE;
    }

}

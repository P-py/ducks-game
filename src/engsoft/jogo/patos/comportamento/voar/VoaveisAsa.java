package engsoft.jogo.patos.comportamento.voar;

/**
 * Standard wing-based flight at a moderate speed.
 */
public final class VoaveisAsa implements PadraoVoaveis {

    private static final double VELOCIDADE = 10.0;

    @Override
    public String voar() {
        return "Voando como um pássaro. Velocidade: " + getVelocidade();
    }

    @Override
    public double getVelocidade() {
        return VELOCIDADE;
    }

}

package engsoft.jogo.patos.comportamento.voar;

/**
 * Rocket-powered flight at very high speed.
 */
public final class VoarFoguete implements PadraoVoaveis {

    private static final double VELOCIDADE = 1000.0;

    @Override
    public String voar() {
        return "Voando como um foguete. Velocidade: " + getVelocidade();
    }

    @Override
    public double getVelocidade() {
        return VELOCIDADE;
    }

}

package engsoft.jogo.patos.comportamento.pular;

/**
 * Steady, well-behaved jumping strategy. Default jump used by {@code Coelho}.
 */
public final class PuloCertinho implements PadraoPulaveis {

    @Override
    public String pular() {
        return "Pulando certinho.";
    }

}

package engsoft.jogo.patos;

import engsoft.jogo.patos.comportamento.pular.PuloAlto;
import engsoft.jogo.patos.comportamento.pular.PuloDesordenado;
import engsoft.jogo.patos.comportamento.voar.VoarFoguete;
import engsoft.jogo.patos.comportamento.voar.VoarRaso;
import engsoft.jogo.patos.pato.Pato;
import engsoft.jogo.patos.pato.PatoAtleta;
import engsoft.jogo.patos.pato.PatoLouco;
import engsoft.jogo.patos.pato.PatoRuivo;

/**
 * Entry point. Demonstrates the Strategy pattern over flying and jumping
 * behaviors, plus composition reuse via {@link Coelho}.
 */
public final class Main {

    private Main() {
    }

    public static void main(final String[] args) {
        final Pato pato = new PatoRuivo();

        System.out.println(pato.mostrar());
        System.out.println(pato.nadar());
        System.out.println(pato.voar());

        pato.setComportamento(new VoarFoguete());
        System.out.println(pato.voar());

        pato.setComportamento(new VoarRaso());
        System.out.println(pato.voar());

        System.out.println();
        System.out.println("===== PARTE B - COMPORTAMENTO DE PULAR =====");

        final Pato atleta = new PatoAtleta();
        System.out.println(atleta.mostrar());
        System.out.println(atleta.pular());

        final Pato louco = new PatoLouco();
        System.out.println(louco.mostrar());
        System.out.println(louco.pular());

        System.out.println();
        System.out.println("--- Pato Atleta trocando de comportamento ---");
        atleta.setComportamentoPulo(new PuloDesordenado());
        System.out.println(atleta.mostrar());
        System.out.println(atleta.pular());

        System.out.println();
        System.out.println("===== PARTE C - COELHO PULA =====");

        final Coelho coelho = new Coelho();
        System.out.println(coelho.mostrar());
        System.out.println(coelho.pular());

        coelho.setComportamentoPulo(new PuloAlto());
        System.out.println("Coelho trocou de comportamento:");
        System.out.println(coelho.pular());
    }

}

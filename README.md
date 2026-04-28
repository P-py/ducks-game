# Jogo dos Patos — Padrão Strategy

Implementação em Java da clássica simulação de patos do livro
*Head First Design Patterns*, estendida com comportamentos de pulo e corrida e
com a classe `Coelho`, que reaproveita o mesmo mecanismo de pulo por composição
em vez de herança. Os campos de estratégia em `Pato` recebem por padrão objetos
nulos (`NaoVoa`, `NaoPula`, `NaoCorre`), garantindo que toda delegação seja
segura mesmo quando um pato não opta por um comportamento.

O código é a entrega de um exercício de POO (Profa. Andréia D. Leles)
abordando: classes abstratas, herança, polimorfismo, interfaces, composição,
delegação e programação voltada a interface.

## Compilar e executar

Sem ferramenta de build — apenas `javac`/`java` com JDK 23+.

```bash
javac -d bin $(find src -name "*.java")
java -cp bin engsoft.jogo.patos.Main
```

## Estrutura de pacotes

```
engsoft.jogo.patos                       Main (ponto de entrada) + Coelho
engsoft.jogo.patos.pato                  Pato abstrato + patos concretos
engsoft.jogo.patos.comportamento.voar    Estratégia de voo + implementações
engsoft.jogo.patos.comportamento.grasnar Estratégia de grasno + implementações
engsoft.jogo.patos.comportamento.pular   Estratégia de pulo + implementações
engsoft.jogo.patos.comportamento.correr  Estratégia de corrida + implementações
```

## Arquitetura

O padrão Strategy desacopla *o que um pato faz* de *como ele faz*. As
responsabilidades de voar, pular e correr são extraídas para interfaces
(`PadraoVoaveis`, `PadraoPulaveis`, `PadraoCorreveis`) com várias
implementações, e `Pato` mantém referências a elas como atributos. Os patos
concretos plugam as estratégias em seus construtores; os setters permitem
trocá-las em tempo de execução.

Os três campos de estratégia em `Pato` são inicializados com objetos nulos
(`NaoVoa`, `NaoPula`, `NaoCorre`). Isso garante que `voar()`, `pular()` e
`correr()` sejam sempre delegáveis com segurança, mesmo quando um pato
concreto não opta por aquele comportamento. Antes dessa correção, chamar
`pular()` em um `PatoBorracha`, `PatoBravo` ou `PatoRuivo` lançava
`NullPointerException`, porque esses patos nunca atribuíam
`comportamentoPulo` — o problema clássico de delegação sem default seguro.

`PadraoGrasnar` é implementada diretamente pelos patos que grasnam — ela
*não* é uma estratégia mantida por `Pato`, então patos que não grasnam
(`PatoBorracha`) simplesmente não a implementam. `Apito` implementa a
mesma interface para mostrar que o contrato não está atrelado à hierarquia
de patos.

`Coelho` **não** estende `Pato`. Ele possui um campo `PadraoPulaveis` e
delega `pular()` a esse objeto, reutilizando exatamente as mesmas
estratégias de pulo que os patos usam. Esse é o argumento central de
composição sobre herança: reaproveitar comportamento não exige um
supertipo comum.

## Diagrama de classes

```mermaid
classDiagram
    class Pato {
        <<abstract>>
        #PadraoVoaveis comportamentoPato
        #PadraoPulaveis comportamentoPulo
        #PadraoCorreveis comportamentoCorrer
        +mostrar()* String
        +nadar() String
        +voar() String
        +pular() String
        +correr() String
        +setComportamento(PadraoVoaveis)
        +setComportamentoPulo(PadraoPulaveis)
        +setComportamentoCorrer(PadraoCorreveis)
    }

    class PatoRuivo
    class PatoBravo
    class PatoBorracha
    class PatoAtleta
    class PatoLouco

    class PadraoVoaveis {
        <<interface>>
        +voar() String
        +getVelocidade() double
    }
    class VoaveisAsa
    class VoarFoguete
    class VoarRaso
    class NaoVoa

    class PadraoGrasnar {
        <<interface>>
        +grasnar() String
    }
    class Apito

    class PadraoPulaveis {
        <<interface>>
        +pular() String
    }
    class PuloAlto
    class PuloDesordenado
    class PuloCertinho
    class NaoPula

    class PadraoCorreveis {
        <<interface>>
        +correr() String
    }
    class CorrerRapido
    class CorrerLento
    class NaoCorre

    class Coelho {
        -PadraoPulaveis comportamentoPulo
        +mostrar() String
        +pular() String
        +setComportamentoPulo(PadraoPulaveis)
    }

    Pato <|-- PatoRuivo
    Pato <|-- PatoBravo
    Pato <|-- PatoBorracha
    Pato <|-- PatoAtleta
    Pato <|-- PatoLouco

    PadraoVoaveis <|.. VoaveisAsa
    PadraoVoaveis <|.. VoarFoguete
    PadraoVoaveis <|.. VoarRaso
    PadraoVoaveis <|.. NaoVoa

    PadraoGrasnar <|.. PatoRuivo
    PadraoGrasnar <|.. PatoBravo
    PadraoGrasnar <|.. Apito

    PadraoPulaveis <|.. PuloAlto
    PadraoPulaveis <|.. PuloDesordenado
    PadraoPulaveis <|.. PuloCertinho
    PadraoPulaveis <|.. NaoPula

    PadraoCorreveis <|.. CorrerRapido
    PadraoCorreveis <|.. CorrerLento
    PadraoCorreveis <|.. NaoCorre

    Pato o--> PadraoVoaveis : comportamentoPato
    Pato o--> PadraoPulaveis : comportamentoPulo
    Pato o--> PadraoCorreveis : comportamentoCorrer
    Coelho o--> PadraoPulaveis : comportamentoPulo
```

## Delegação em tempo de execução

Chamar `pato.voar()` não executa lógica de voo dentro de `Pato`. A chamada
é repassada para a instância de `PadraoVoaveis` que estiver atualmente em
`comportamentoPato`. A mesma indireção vale para o pulo e para a corrida.
É essa indireção que torna possível a troca de comportamento em tempo de
execução.

```mermaid
sequenceDiagram
    participant Cliente as Main
    participant Pato as Pato (PatoAtleta)
    participant EstratA as PuloAlto
    participant EstratB as PuloDesordenado

    Cliente->>Pato: pular()
    Pato->>EstratA: pular()
    EstratA-->>Pato: "Pulando bem alto!"
    Pato-->>Cliente: "Pulando bem alto!"

    Cliente->>Pato: setComportamentoPulo(new PuloDesordenado())
    Cliente->>Pato: pular()
    Pato->>EstratB: pular()
    EstratB-->>Pato: "Pulando de forma desordenada e caótica!"
    Pato-->>Cliente: "Pulando de forma desordenada e caótica!"
```

## O que foi feito

O exercício tem três partes. O repositório original já trazia a Parte A; as
Partes B e C foram adicionadas em cima dela.

### Parte A — hierarquia base

`Pato` abstrato com patos concretos (`PatoRuivo`, `PatoBravo`,
`PatoBorracha`), a estratégia `PadraoVoaveis` com quatro implementações e
`PadraoGrasnar` implementada pelos patos que grasnam e por `Apito`.

### Parte B — comportamento de pular

- **Interface:** `PadraoPulaveis` com `String pular()`.
- **Estratégias:** `PuloAlto`, `PuloDesordenado`.
- **Patos concretos:** `PatoAtleta` (usa `PuloAlto`) e `PatoLouco` (usa
  `PuloDesordenado`).
- **Modificação em `Pato`:** atributo `comportamentoPulo`, setter
  `setComportamentoPulo()` e método `pular()` que delega. Nenhuma outra
  classe existente foi alterada — adicionar novos estilos de pulo só exige
  novas implementações de `PadraoPulaveis` (princípio Aberto/Fechado).

### Parte B2 — comportamento de correr

- **Interface:** `PadraoCorreveis` com `String correr()`.
- **Estratégias:** `CorrerRapido`, `CorrerLento` e o objeto nulo `NaoCorre`.
- **Patos concretos:** `PatoAtleta` usa `CorrerRapido` por padrão; os demais
  herdam o objeto nulo `NaoCorre` definido em `Pato`.
- **Modificação em `Pato`:** atributo `comportamentoCorrer`, setter
  `setComportamentoCorrer()` e método `correr()` que delega. Igual à Parte B,
  novos estilos de corrida exigem apenas novas implementações de
  `PadraoCorreveis`.

### Parte C — Coelho via composição

`Coelho` fica em `engsoft.jogo.patos`, não estende `Pato` e possui um
`PadraoPulaveis`. Por padrão usa a estratégia `PuloCertinho`; o setter
permite trocar em tempo de execução para qualquer estratégia existente —
no demo a troca é para `PuloAlto`.

### Parte D — delegação segura via objeto nulo

`Pato` agora inicializa `comportamentoPato`, `comportamentoPulo` e
`comportamentoCorrer` com instâncias de `NaoVoa`, `NaoPula` e `NaoCorre`,
respectivamente. Isso elimina o risco de `NullPointerException` ao chamar
`voar()`, `pular()` ou `correr()` em patos que não plugam aquela estratégia
(como `PatoBorracha`), substituindo o erro por uma mensagem informativa do
tipo *"Esse pato não pula."* — aplicação direta do padrão Null Object.

## Boas práticas aplicadas no código

- Classes-folha (estratégias e patos concretos) marcadas como `final` para
  desencorajar herança não planejada.
- Parâmetros de método/construtor marcados como `final`.
- Números mágicos das velocidades extraídos para constantes
  `private static final` (ex.: `VELOCIDADE` em cada estratégia de voo).
- Javadoc com `@param` e `@return` em métodos públicos das interfaces e
  classes principais.
- Compilação limpa com `javac -Xlint:all` (sem avisos).
- Construtor privado em `Main` para sinalizar classe utilitária não
  instanciável.

## Saída da execução

Ao executar `Main`, a saída é:

```
===== PARTE A - COMPORTAMENTO DE VOAR =====
Eu sou o Pato Ruivo.
Pato Nadando.
Voando como um pássaro. Velocidade: 10.0
Voando como um foguete. Velocidade: 1000.0
Voando perto do chão. Velocidade: 100.0

===== PARTE B - COMPORTAMENTO DE PULAR =====
Eu sou o Pato Atleta.
Pulando bem alto!
Eu sou o Pato Louco.
Pulando de forma desordenada e caótica!

--- Pato Atleta trocando de comportamento ---
Eu sou o Pato Atleta.
Pulando de forma desordenada e caótica!

===== PARTE B2 - COMPORTAMENTO DE CORRER =====
Eu sou o Pato Atleta.
Correndo bem rápido!
Eu sou o Pato Louco.
Correndo bem rápido!

--- Pato Atleta trocando de comportamento ---
Eu sou o Pato Atleta.
Correndo devagar.

===== PARTE C - COELHO PULA =====
Eu sou um Coelho!
Pulando certinho.
Coelho trocou de comportamento:
Pulando bem alto!

===== PARTE D - DELEGAÇÃO SEGURA (NULL-OBJECT) =====
Olá, eu sou de Borracha.
Esse pato não voa. Velocidade: 0.0
Esse pato não pula.
Esse pato não corre.
```

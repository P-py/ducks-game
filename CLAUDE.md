# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Run

No build tool (no Maven/Gradle). Use `javac`/`java` directly with JDK 23+.

```bash
# Compile all sources
javac -d bin $(find src -name "*.java")

# Run
java -cp bin engsoft.jogo.patos.Main
```

## Architecture

This project is a Java implementation of the **Strategy pattern** applied to a duck simulation (from *Head First Design Patterns*).

**Package layout:**

```
engsoft.jogo.patos              → Main (entry point)
engsoft.jogo.patos.pato         → Abstract Pato + concrete ducks (PatoBorracha, PatoBravo, PatoRuivo)
engsoft.jogo.patos.comportamento.voar    → PadraoVoaveis interface + flying strategies
engsoft.jogo.patos.comportamento.grasnar → PadraoGrasnar interface + quacking strategies
```

**Key design decisions:**
- `Pato` (abstract) holds a `PadraoVoaveis comportamentoPato` field, delegating `voar()` to it. Flying behavior can be swapped at runtime via `setComportamento()`.
- Quacking (`PadraoGrasnar`) is a separate interface implemented directly by duck classes or standalone objects like `Apito`. Not all ducks quack — `PatoBorracha` does not implement it.
- Flying strategy classes (`VoarFoguete`, `VoarRaso`, `VoaveisAsa`, `NaoVoa`) are stateless except for an immutable `velocidade` field set in the constructor.

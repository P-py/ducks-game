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
engsoft.jogo.patos              → Main (entry point) + Coelho
engsoft.jogo.patos.pato         → Abstract Pato + concrete ducks (PatoBorracha, PatoBravo, PatoRuivo, PatoAtleta, PatoLouco)
engsoft.jogo.patos.comportamento.voar    → PadraoVoaveis interface + flying strategies (incl. NaoVoa null-object)
engsoft.jogo.patos.comportamento.grasnar → PadraoGrasnar interface + quacking strategies
engsoft.jogo.patos.comportamento.pular   → PadraoPulaveis interface + jumping strategies (incl. NaoPula null-object)
engsoft.jogo.patos.comportamento.correr  → PadraoCorreveis interface + running strategies (incl. NaoCorre null-object)
```

**Key design decisions:**
- `Pato` (abstract) holds three strategy fields — `comportamentoPato` (fly), `comportamentoPulo` (jump), `comportamentoCorrer` (run) — and delegates `voar()`, `pular()`, `correr()` to them. Each can be swapped at runtime via its setter.
- All three strategy fields default to null-object instances (`NaoVoa`, `NaoPula`, `NaoCorre`). This keeps delegation safe even when a concrete duck does not opt into a behavior — no NullPointerException, just a sensible "this duck does not X" message.
- Quacking (`PadraoGrasnar`) is a separate interface implemented directly by duck classes or standalone objects like `Apito`. Not all ducks quack — `PatoBorracha` does not implement it.
- Flying strategy classes (`VoarFoguete`, `VoarRaso`, `VoaveisAsa`, `NaoVoa`) expose a `getVelocidade()` alongside `voar()`. Jumping and running strategies are description-only.
- `Coelho` does not extend `Pato`; it composes a `PadraoPulaveis` directly, demonstrating that strategy reuse is decoupled from the class hierarchy.

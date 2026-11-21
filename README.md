# Padrão Observer - APOO

Repositório de apoio da disciplina de **Análise e Projeto Orientado a Objetos (APOO)**. O objetivo é mostrar, com exemplos pequenos em Java, o problema que o padrão de projeto **Observer** resolve e como aplicá-lo.

O conteúdo está dividido em duas partes:

1. **Exemplo guiado (`weather`)**: uma estação meteorológica implementada primeiro sem o padrão Observer e, em seguida, refatorada com ele.
2. **Exercício prático (`auction`)**: um sistema de leilão baseado em polling, que deve ser refatorado pelos alunos para usar Observer.

## O padrão Observer

O Observer define uma dependência um-para-muitos entre objetos: quando um objeto (o **sujeito**) muda de estado, todos os seus dependentes (os **observadores**) são notificados automaticamente.

Participantes principais:

| Papel | Responsabilidade |
|---|---|
| `Subject` | Mantém a lista de observadores e oferece operações para registrar, remover e notificar. |
| `Observer` | Interface com o método chamado na notificação (por exemplo, `update`). |
| Sujeito concreto | Guarda o estado de interesse e dispara a notificação quando ele muda. |
| Observador concreto | Implementa `Observer` e reage à mudança. |

Benefícios esperados:

- O sujeito depende apenas da abstração `Observer`, não das classes concretas (baixo acoplamento).
- Novos observadores podem ser adicionados sem alterar o sujeito (princípio aberto/fechado).
- Observadores podem ser registrados e removidos em tempo de execução, em qualquer quantidade.
- A notificação acontece no momento da mudança, sem consultas desnecessárias.

## Estrutura do repositório

```
src/
  weather/                 Exemplo guiado: estação meteorológica
    WeatherSensor.java
    PhoneDisplay.java
    ThermostatDisplay.java
    HeatAlert.java
    Main.java
  auction/                 Exercício prático: leilão
    Auction.java
    AuctionScreen.java
    OutbidNotifier.java
    BidHistory.java
    Main.java
    README.md              Enunciado do exercício
```

## Exemplo guiado: estação meteorológica

Um sensor de temperatura (`WeatherSensor`) precisa avisar três componentes sempre que a temperatura muda:

- `PhoneDisplay`: mostra a temperatura atual no celular.
- `ThermostatDisplay`: liga ou desliga o ar-condicionado acima de 28 °C.
- `HeatAlert`: emite um alerta de calor extremo a partir de 35 °C.

### Versão sem Observer

A versão atual em `src/weather` resolve o problema de forma direta, e é justamente isso que ela pretende evidenciar:

- `WeatherSensor` tem um atributo para **cada tipo concreto** de componente e um par de métodos `add`/`remove` para cada um.
- Adicionar um novo componente exige **alterar o `WeatherSensor`** (novo atributo, novos métodos e mais um `if` em `notifyDisplays`).
- Só é possível ter **um componente de cada tipo**, já que cada referência é um campo simples.
- O sensor está fortemente acoplado a todas as classes que dependem dele.

### Versão com Observer

A versão refatorada introduz uma interface comum para os componentes e faz o `WeatherSensor` manter uma lista de observadores, eliminando os problemas listados acima. Ela será adicionada ao repositório em uma próxima etapa.

## Exercício prático: leilão

Em `src/auction` há um sistema de leilão em que três participantes precisam reagir a cada novo lance aceito: o telão (`AuctionScreen`), o aviso por e-mail para quem foi superado (`OutbidNotifier`) e o histórico de lances (`BidHistory`).

Nesta versão, o `Auction` não avisa ninguém. Cada participante consulta o leilão periodicamente (**polling**), em intervalos diferentes, o que gera consultas à toa, atrasos e até perda de informação (lances que nunca chegam ao histórico, e-mails que não são enviados).

A tarefa é substituir o polling pelo padrão Observer. O enunciado completo, com perguntas de análise, requisitos e desafios extras, está em [`src/auction/README.md`](src/auction/README.md).

## Como executar

Requisito: JDK 8 ou superior.

Na raiz do repositório:

```bash
# Exemplo guiado
javac -d out src/weather/*.java
java -cp out weather.Main

# Exercício do leilão
javac -d out src/auction/*.java
java -cp out auction.Main
```

## Sugestão de roteiro de estudo

1. Rode o exemplo `weather` e leia o `WeatherSensor`. Liste o que precisaria mudar para adicionar um quarto componente.
2. Compare com a versão com Observer e identifique quais desses pontos deixaram de existir.
3. Rode o exercício `auction`, responda às perguntas do enunciado e implemente a refatoração.
4. Tente os desafios extras e discuta as variações do padrão (modelo push, em que o sujeito envia os dados ao observador, versus modelo pull, em que o observador consulta o sujeito).

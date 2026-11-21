# Exercício: de Polling para Observer

## Contexto

Este é um sistema de leilão simples. Quando alguém dá um lance maior que o atual, três participantes precisam reagir:

- **`AuctionScreen`**: o telão mostra o novo maior lance.
- **`OutbidNotifier`**: manda um e-mail para quem perdeu a liderança.
- **`BidHistory`**: registra todos os lances aceitos.

O problema é que o `Auction` **não avisa ninguém**. Cada participante precisa ficar perguntando ao leilão, de tempos em tempos, se algo mudou. Isso é **polling** (sondagem).

No `Main`, o tempo é simulado em rodadas, e cada participante consulta o leilão num intervalo diferente:

| Participante | Consulta o leilão |
|---|---|
| Telão | toda rodada |
| E-mail | a cada 2 rodadas |
| Histórico | a cada 3 rodadas |

## Como rodar

Na raiz do repositório:

```bash
javac -d out src/auction/*.java
java -cp out auction.Main
```

## Antes de começar

Rode o código, leia a saída e responda:

1. Quantas consultas terminaram em "nada mudou"?
2. Quantos lances foram aceitos? Quantos aparecem no histórico final?
3. Quem deveria ter recebido e-mail, e quando? Quem realmente recebeu?

## O que fazer

Substitua o polling pelo padrão **Observer**:

1. Os participantes não devem mais consultar o leilão. O `Auction` deve avisá-los **no momento** em que um lance é aceito.
2. `Auction` não pode conhecer as classes concretas (`AuctionScreen`, `OutbidNotifier`, `BidHistory`).
3. Deve ser possível registrar **quantos observadores quiser**, inclusive vários do mesmo tipo, e remover um observador específico.
4. Organize o projeto em pacotes/pastas (por exemplo, separando o domínio dos observadores). A estrutura é escolha sua.
5. Ajuste o `Main`: as rodadas e os `check()` não serão mais necessários.

**Resultado esperado:** nenhuma consulta à toa, nenhum atraso, todos os lances aceitos no histórico, e cada pessoa superada recebe o e-mail na hora.

## Desafios extras (opcional)

- Crie um `ReservePriceAlert`, que avisa quando o lance atinge um preço mínimo de reserva, **sem alterar a classe `Auction`**.
- Adicione um evento de **encerramento do leilão** que anuncia o vencedor.
- O observador deve receber os dados do lance como parâmetros ou consultar o `Auction` diretamente? Pense nos prós e contras de cada abordagem.

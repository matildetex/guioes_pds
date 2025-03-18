# Aula10 - Notes

## Behavioural Patterns-> Comportamentais

## Chain of Responsability (Ex1 and 2)
Padrão que permite a transposição de responsabilidades, até uma classe a aceitar, de forma dinâmica, sem um acoplamento rígido.Cada objeto nesta cadeia pode processar o pedido ou passar ao próximo.

**Exemplo:** Um tradutor que não sabe a linguagem do que foi inserido, vai percorrer todas as linguagens até encontrar uma que faça sentido, sendo passada por todos os objetos ou até ao objeto que a processe.


## Command (Ex3)
Padrão que permite encapsular uma solicitação como um objeto, separando a emissão do pedido de processamento, da processamento da solicitação.Este permite uma maneira mais fácil de manipular, armazenar ou processar solicitações, numa maneira mais eficiente e desacoplada do código.


**Exemplo:** Num controlo remoto de uma casa inteligente, cada botão representa um comando distinto, tal como a ação de ligar as luzes ou ajustar a temperatura, desacoplando o cliente do processamento da solicitação,por exemplo se se pressionar o botão para ligar as luzes da sala, o controlo remoto cria um objeto de comando para essa ação e envia-o para a lâmpada da sala.
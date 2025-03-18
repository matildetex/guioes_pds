# Aula05 - Notes

## Factory Pattern
**Centralizar criação de novos objetos**, ***sem especificar a classe concreta***, permitindo diferentes características, através de uma classe Factory (fábrica), e de um método create. <br/>

**Exemplo:** Num jogo com diferentes personagens, usar um método factory para criar os diferentes personagens.


## Abstract Factory Pattern

**Abstração do padrão de cima** (como se adicionar outro nível de fábrica), criando ***famílias de objetos relacionados sem especificar a classe concreta*** ou uma "família de fábricas"<br/>

**Exemplo:** Na criação de diferentes tipos de mobília (sofá, mesa) e estilos (victoriano, moderno), este pode ser usada para garantir que todos os objetos criados pertençam a uma mesma família.
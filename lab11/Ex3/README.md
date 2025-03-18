## Sistema de Controlo de Tráfego Aéreo

1. Num sistema de controlo aéreo, muitas vezes é dificil perceber que aviões já descolaram ou se preparam para deslocar, devido à larga extensão. De modo a evitar possíveius acidentes, muitos aviões comunicam com uma base que lhes pode dar permissão ou não para deslocar.

2. Iremos ter dois tipos de entidades:
    - Avião (avião normal que pede autorização à torre de controlo para descolar)
        -envia pedido de permissão para descolar (sendMessage)
        -recebe resposta se pode deslocar ou não (receiveMessage)
    
    **Notas:** Esta classe irá utilizar a classe AbstractAviao, que declara os métodos que esta possa usar, de modo a tormnar o código modular e permitir no futuro a adição de avionetas, por exemplo, ou outros.

    - Torre de Controlo (que avisa o avião se pode ou não descolar)
        -adiciona aviões à sua base (addPlane)
        -envia permissões (sendMessage)

    **Notas:** Esta classe irá implementar a classe IntTorreControloque declara os métodos que esta possa usar, de modo a tormnar o código modular e permitir no futuro a adição de avionetas, por exemplo, ou outros.

3. Para criar este problema recorremos:
    - i. slides anos anteriores;
    - ii. ao site https://refactoring.guru/design-patterns/mediator
    - iii. exercício feito na aula teórica
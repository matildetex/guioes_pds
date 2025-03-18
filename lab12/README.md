# Aula12 - Notes

## Behavioural Patterns-> Comportamentais

## Strategy (Ex1)
Padrão que permite a definição de diversos algoritmos e o uso destes de forma despercebida.

**Exemplo:** Num sistema de pagamentos online que tem várias opções de pagamento, cada método irá ter um algoritmo próprio para processar pagamento e interagir com o sistema bancário.


## Template Method (Ex2)
Padrão que permite passar responsabilidade de uma ação para uma subclasse.


**Exemplo:** Num café que tenho diferentes tipos de cafés (americano, expresso e capuccino) todos eles têm um diferente forma de serem preparados, mas vão ser todos entregues ao cliente e passar pelas mesmas ações.


## State (Ex3)
Padrão que permite associar estados e transformações, e alterar o seu comportamento em função destas.


**Exemplo:** Numa loja online, uma peça de roupa passa por diferentes estados até chegar ao cliente, desde VENDIDA até ENVIADA, dentro da sede da empresa.


## Visitor (Ex5)
Padrão que permite a distinção entre algoritmos e objetos nos quais operam.


**Exemplo:** Num carrinho de compras para calcular os diferentes preços de fruta e albuns. Se quisermos adicionar mais algum outro tipo conseguimos fazer isto sem alterar quase código nenhum,e assim facilitando a adição de novos produtos.
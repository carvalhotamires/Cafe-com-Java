# ☕ Cafe com Java: Demonstração de Design Patterns

Este projeto é uma aplicação de linha de comando desenvolvida em **Java Puro** para demonstrar a aplicação prática e coordenada de três Padrões de Projeto essenciais (GoF - Gang of Four): **Decorator**, **Factory Method** e **Strategy**.

O sistema simula a montagem interativa de um pedido de café, calculando o custo total e aplicando regras de desconto dinâmicas.

---

## 👥 Desenvolvedores

O projeto foi desenvolvido por:

* **Lanusse Silveira**
* **Lucivânia Ramiro**
* **Tamires Carvalho**

---

## 💡 Padrões de Projeto Implementados

O projeto foi arquitetado para resolver desafios comuns de flexibilidade e extensibilidade, utilizando um padrão de cada categoria principal:

### 1. 🏗️ Decorator (Estrutural)
Permite a adição dinâmica de novas responsabilidades (toppings) a um objeto sem modificar sua estrutura (Princípio Aberto/Fechado).

* **O que resolve:** Evita a criação de subclasses infinitas (ex: `CafeComLeiteComChantilly`).
* **Aplicação:** Combinação ilimitada de **Bebidas Base** (`CafeExpresso`) com **Adicionais** (`LeiteDecorator`, `CaldasDecorator`). O custo e a descrição são calculados de forma recursiva.

### 2. 🏭 Factory Method (Criacional)
Define uma interface para a criação de um objeto, mas deixa que as subclasses decidam qual classe instanciar.

* **O que resolve:** Remove o acoplamento forte (uso de `new ClasseConcreta()`) do código cliente (`MainApplication`).
* **Aplicação:** Criação das **Bebidas Base** (`CafeExpresso`, `ColdBrew`) usando uma fábrica, tornando o sistema extensível a novos tipos de café.

### 3. 🏃 Strategy (Comportamental)
Permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis.

* **O que resolve:** Elimina o uso de múltiplas instruções condicionais (`if/else` ou `switch`) para executar diferentes lógicas de negócio.
* **Aplicação:** Cálculo de **Descontos** (`DescontoMembro`, `SemDesconto`) aplicado ao pedido final. A regra de desconto pode ser alterada em tempo de execução.

---

## ⚙️ Arquitetura do Projeto

A estrutura de pacotes reflete a separação de responsabilidades de cada padrão:

└── com.girlscode.cafecomjava 
├── core/ # Contratos e Interfaces (Bebida, ICafeFactory, IDescontoStrategy) 
├── bebidas/ # Componentes Concretos (CafeExpresso, ColdBrew, etc.)
├── decorador/ # Decorator Abstrato e Concretos (LeiteDecorator, ToppingDecorator, etc.)
├── factory/ # Implementações do Factory Method (ExpressoFactory, FiltroFactory, etc.) 
├── strategy/ # Implementações dos Algoritmos de Desconto (DescontoMembro, SemDesconto) 
├── contexto/ # Contexto do Strategy (PedidoContext) 
└── MainApplication.java # Cliente/Demo (Integra todos os 3 padrões)

---

## ▶️ Como Executar

1.  **Requisitos:** Java 17+ e Maven.
2.  **Compilação:** Abra o terminal na raiz do projeto (`cafecomjava`) e execute:
    ```bash
    mvn clean install
    ```
3.  **Execução:**
    ```bash
    java -jar target/cafecomjava-0.0.1-SNAPSHOT.jar 
    # Ou execute diretamente pelo método main da MainApplication na sua IDE.
    ```

---

## 🎓 Demonstração (Exemplo de Saída)

O sistema guiará o usuário pela escolha da base (Factory), adição de *toppings* (Decorator) e aplicação de desconto (Strategy).

--- Bem vindo ao Café com Java ---
Escolha a sua bebida base: 
1 - Café Expresso (R$ 5.00)
2 - Café Filtrado (R$ 4.00)
3 - Café Descafeinado (R$ 7.50)
4 - ColdBrew (R$ 8.00)
Sua escolha: 2

Base escolhida: Café Filtrado

Adicione Toppings na sua bebiba:
1 - Leite (R$ 2.50)
2 - Chantilly (R$ 3.00)
3 - Calda (R$ 3.50)
4 - Xarope (R$ 5.00)
5 - Finalizar pedido
Opção: 1
Café Filtrado com Leite

Adicione Toppings na sua bebiba:
1 - Leite (R$ 2.50)
2 - Chantilly (R$ 3.00)
3 - Calda (R$ 3.50)
4 - Xarope (R$ 5.00)
5 - Finalizar pedido
Opção: 3
Café Filtrado com Leite + calda

Adicione Toppings na sua bebiba:
1 - Leite (R$ 2.50)
2 - Chantilly (R$ 3.00)
3 - Calda (R$ 3.50)
4 - Xarope (R$ 5.00)
5 - Finalizar pedido
Opção: 2
Café Filtrado com Leite + calda + Chantilly

Adicione Toppings na sua bebiba:
1 - Leite (R$ 2.50)
2 - Chantilly (R$ 3.00)
3 - Calda (R$ 3.50)
4 - Xarope (R$ 5.00)
5 - Finalizar pedido
Opção: 5
Finalizando pedido.

-------------------------------------------------------------------------
Pedido Finalizado com sucesso!
Descrição completa: Café Filtrado com Leite + calda + Chantilly
Custo Total: R$ 13,00
Você é cliente membro? (S/N)? S
-10% na sua conta. Desconto de Membro aplicado com sucesso!
Custo Final: R$ 11,70
-------------------------------------------------------------------------

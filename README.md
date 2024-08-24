# gestao_rodoviaria
O sistema permite a compra, reserva e liberação de assentos de ônibus. Ele inclui diversas funcionalidades, como a validação do número do assento, a detecção de assentos já ocupados ou disponíveis, e a notificação de eventos para diferentes visualizações.

- Sistema de Gestão de Rodoviária
Este é um sistema de gerenciamento de rodoviária implementado em Java, utilizando o padrão MVC (Model-View-Controller). O sistema permite a compra, reserva e liberação de assentos de ônibus. Ele inclui diversas funcionalidades, como a validação do número do assento, a detecção de assentos já ocupados ou disponíveis, e a notificação de eventos para diferentes visualizações.

- Funcionalidades
Compra de Passagens: Permite a compra de passagens para assentos disponíveis.

Reserva de Passagens: Permite reservar assentos que ainda estão livres.

Liberação de Assentos: Libera assentos que estavam reservados ou ocupados, tornando-os novamente disponíveis.

Notificação em Tempo Real: O sistema utiliza o padrão de observador para notificar diferentes visualizações (Painel e Quiosque) quando há uma alteração nos assentos.

Testes Automatizados: Testes unitários são fornecidos para garantir a integridade das funcionalidades principais do sistema.
Estrutura do Projeto

Modelos: Representam os dados e a lógica de negócio do sistema, como a classe Rodoviaria e Assento.

Controladores: Manipulam as interações entre o modelo e as visualizações, garantindo que a lógica de negócio seja aplicada corretamente.

Visualizações: Interfaces gráficas e textuais que exibem o status dos assentos e respondem às alterações no sistema.
Exceções: Exceções personalizadas para validações específicas, como assentos inválidos ou tentativas de liberar assentos já disponíveis.

- Tecnologias Utilizadas
Linguagem: Java
Padrões de Projeto: MVC, Observer
Bibliotecas: JUnit para testes automatizados

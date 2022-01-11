### TQI Evolution 2022 - Back-end

# Sistema de concessão de empréstimo

## O Desafio proposto

Uma empresa de empréstimo precisa criar um sistema de análise de crédito para fornecer aos seus clientes as seguintes funcionalidades:
i. Cadastro de clientes
    O cliente pode cadastrar: nome, e-mail, CPF, RG, endereço completo, renda e senha.
ii. Login
    A autenticação será realizada por e-mail e senha.
iii. Solicitação de empréstimo
    Para solicitar um empréstimo, precisamos do valor do empréstimo, data da primeira parcela e quantidade de parcelas.
    O máximo de parcelas será 60 e a data da primeira parcela deve ser no máximo 3 meses após o dia atual.
iv. Acompanhamento das solicitações de empréstimo
    O cliente pode visualizar a lista de empréstimos solicitados por ele mesmo e também os detalhes de um de seus empréstimos.
    Na listagem, devemos retornar no mínimo o código do empréstimo, o valor e a quantidade de parcelas.
    No detalhe do empréstimo, devemos retornar: código do empréstimo, valor, quantidade de parcelas, data da primeira parcela, e-mail do cliente e renda do cliente.


## **Visão geral do sistema**

Foi criado uma API para fazer o cadastramento de clientes e de concessão de empréstimos com as seguintes premissas:

    Quantidades de parcelas de empréstimo de no máximo 60 meses
    Data da primeira parcela no máximo 3 meses após a data corrente
    Validação de CPF

Observação: No implantando a interface de Login e também o detalhamento do empréstimo


## Pacotes utilizadas:

Banco de dados H2: Banco de dados completo, com a vantagem de rodar em memória
Spring Web: Dependência que adiciona Servlets e Portles na aplicação
Spring JPA: Dependência que adiciona funcionalidades do padrão JPA. 
Spring Security: Adiciona uma camada de segurança para a proteção de dados da API
Lombok: Melhora em muito a geração do código sem a necessidade de getters, setters etc..
Mapstruct: Realiza o mapeamento de objetos em entidades, e vice-versa.
Swagger: Toda a documentação da API e seus endpoints podem ser acessados por http://localhost:8080/swagger-ui/
Gerenciador de pacotes: graddle



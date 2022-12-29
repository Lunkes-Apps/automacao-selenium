Feature: Classificar triângulo

  COMO usuário
  QUERO obter a classificação de um triângulo
  PARA ter conhecimento desta informação

  Scenario Outline: Informar vértices que formam um triângulo '<tipo-triangulo>'
    Given que estou na tela principal
    When informo os vértices '<v-1>', '<v-2>' e '<v-3>'
    And clico no botao identificar
    Then é informado que se trata de um triângulo '<tipo-triangulo>'

    Examples:
      | tipo-triangulo | v-1 | v-2 | v-3 |
      | Equilátero     | 3   | 3   | 3   |
      | Isósceles      | 2   | 2   | 3   |
      | Escaleno       | 2   | 3   | 4   |

  Scenario: Informar vértices que não possibilita um triangulo
    Given que estou na tela principal
    When informo os vértices '2', '1' e '10'
    And clico no botao identificar
    Then deve ser informado que o triangulo não é possíve


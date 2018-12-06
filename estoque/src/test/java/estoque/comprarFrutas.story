Scenario: Comprar manga

Given estou na lista de compras
When seleciono o produto 'Manga'
And informo a quantidade '10'
And informo o valor unitário '5' reais
And confirmo a compra
Then terei de pagar '50' reais

Scenario: Comprar jaca

Given estou na lista de compras
When seleciono o produto 'Jaca'
And informo a quantidade '32'
And informo o valor unitário '2' reais
And confirmo a compra
Then terei de pagar '64' reais
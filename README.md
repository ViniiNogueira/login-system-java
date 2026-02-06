# Sistema de Login em Java com Hash SHA-256

Este projeto é um estudo pratico com foco em:
- Lógica de programação
- Validação de e-mail e senha
- Aplicação de hash básico (SHA-256)
  
## Objetivo
- Treinar conceitos fundamentais da linguagem Java e entender, na prática, como funciona o processo de validação de dados e hash de senha, sem uso de frameworks ou Maven
- Nao implementei banco de dados


## Tecnologias utilizadas
- Java jdk 21
- IntelliJ IDEA
- Biblioteca padrão do Java (`java.security.MessageDigest`)

## Funcionalidades
- Validação de e-mail (estrutura básica com `@` e `.`)
- Validação de senha com regras:
  - Mínimo de 8 caracteres
  - Pelo menos 1 número
  - Pelo menos 1 letra
  - Pelo menos 1 caractere especial
- Geração de hash da senha utilizando SHA-256
- Conversão do hash para hexadecimal para visualização

### Observações
- O hash da senha é exibido apenas para fins de estudo e entendimento do processo
- a senha não deve ser exibida em aplicações reais
- Não foi utilizado salt ou algoritmos específicos para senha (como BCrypt), pois o foco é aprendizado inicial, futuramente posso criar novos projetos utilizandos tais tecnologias

## Conceitos aprendidos
- Uso de `Scanner`
- Uso de `MessageDigest`
- Conversão de `byte[]` para String hexadecimal
- Tratamento de exceções com `try/catch`

----------------
## Contato e Feedback
Este projeto faz parte do meu aprendizado contínuo. **Aceito críticas construtivas e dicas de melhoria!** Se você viu algo que pode ser otimizado no código ou na estrutura, sinta-se à vontade para entrar em contato. Toda ajuda é bem-vinda para o meu crescimento como desenvolvedor.  
Muito Obriagdo!

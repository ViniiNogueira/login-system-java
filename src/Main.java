import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // pedir o email do usuario
        // validar (e alguma forma)
        // se o email tiver correto pede senha
        // valida senha
        // concede acesso ou nega!

        Scanner scanner = new Scanner(System.in);
        String email;
        String senha = "";


            System.out.println("Seja bem vindo!");
            System.out.println("Sistema de Login");
            System.out.println("Digite seu e-mail:");
            email = scanner.nextLine();

            //tentar escrevre quando da erro pra n ficar confuso

            if (!email.contains("@") || !email.contains(".")) {
                System.out.println("email ivalido, tente novamente");

                // valida se o @ é o 1 item
            } else if (email.indexOf('@') == 0) {
                System.out.println("email invalido , nao é correto comecar com @");

                // usa o length para saber o tamanho e compara pra saber se o arroba é o ultimo item =
            } else if (email.length() - 1 == email.indexOf('@')) {
                System.out.println("email invalido , o @ nao pode ser o ultimo item do email");

                // tem q ver se o ponto vem depois ou antes do @
                // comparar posicao do @ com do .
                // se poosicao do . for menor q a do @ da invalido
            } else if (email.indexOf('@') >= email.indexOf('.')) {
                System.out.println("email invalido, estrutura incorreta");
            } else {
                System.out.println("prossiga para a senha");
            }

            System.out.println("=======================");
            System.out.println("digite sua senha:");
            System.out.println("sua senha precisa ter pelo menos 8 caracteres, 1 numero e 1 caractere especial");

            //verificar se é maior q 8 digitos
            // usar o isDigit pra saber se tem numero
            // usar o isLetter pra saber se tem Letra
            // tem q usar separado pq só funciona com char e nao com string

            senha = scanner.nextLine();
            if (senha.length() < 8) {
                System.out.println("senha fraca");
            } else {
                boolean SenhaValida = false;
                boolean TemNumero = false;
                boolean TemLetra = false;
                boolean TemSimbolo = false;

                for (int i = 0; i < senha.length(); i++) {
                    char unidades = senha.charAt(i);

                    if (Character.isDigit(unidades)) {
                        TemNumero = true;
                    } else if (Character.isLetter(unidades)) {
                        TemLetra = true;
                    } else if (!Character.isDigit(unidades) && !Character.isLetter(unidades)) {
                        TemSimbolo = true;
                        //avalia se a senha é valida
                    }
                }
                if (!TemNumero) {
                    System.out.println("sua senha n tem numeros");
                } else if (!TemLetra) {
                    System.out.println("sua senha n tem letras");
                } else if (!TemSimbolo) {
                    System.out.println("sua senha precisa de um caractere especial");
                } else {
                    System.out.println("Senha valida!");
                }

                // senha valida
                SenhaValida = TemNumero && TemLetra && TemSimbolo && senha.length() >= 8;


                    //hash dos criakk
                if (SenhaValida){
                    try {
                        //tipo de hash usado (usei ele pois nao estou usadno maven)
                        MessageDigest md = MessageDigest.getInstance("SHA-256");

                        //convertendo para um array de byte
                        byte[] senhaBytes = senha.getBytes();
                        md.update(senhaBytes);


                        byte[] hashbytes = md.digest();

                        // transformando em string pra poder printar (é só um estudo ent n tem problema de mostrar)
                        StringBuilder Stringhexadecimal = new StringBuilder();

                        // loop pra transformar
                        for (byte b : hashbytes){
                            String hexa = Integer.toHexString(0xff & b);

                            if (hexa.length() == 1){
                                Stringhexadecimal.append('0');
                            }
                            Stringhexadecimal.append(hexa);
                        }

                        String FinalHash = Stringhexadecimal.toString();


                        System.out.println("==============");
                        System.out.println("Teste de hash em java: ");
                        System.out.println("hash de senha:" + FinalHash);


                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
    }
}
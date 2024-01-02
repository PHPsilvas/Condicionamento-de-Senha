import java.util.Scanner;



public class App {
    static int caracteres(char[] m){

        int contador = 0;
        for (int i = 0; i < m.length; i ++)
           contador ++;

        return contador;
        }

    static boolean maiúscula(char[] m){
        for (int i = 0; i < m.length; i ++){
            if(m[i]>= 65 && m[i]<=90){
                return true;
            }
        }
        return false;
    }
    static boolean minúscula(char[] m){
        for (int i = 0; i < m.length; i ++){
            if(m[i]>= 97 && m[i]<=122){
                return true;
            }
        }
        return false;
    }

    static boolean caracterEspecial(char[] m){

        for (int i = 0; i < m.length; i ++){ 
            if( (m[i]>=33 && m[i]<=47 ) || (m[i]>=58 && m[i]<=64) || (m[i]>=91 && m[i]<=96) ){
                return true;
            }
        }
        return false;
    }
    static boolean number(char[] m){
        for (int i = 0; i < m.length; i ++){
            if(m[i]>= 48 && m[i]<=57){
                return true;
            }
        }
        return false;
    }

    static String senhaCerta(String senha){
        int cond1 =0; 
        try (Scanner in = new Scanner(System.in)) {
            char[] aux = senha.toCharArray();
            System.out.println("");
            //numero de caracteres
            if(caracteres(aux)<6){
                cond1++;
                System.out.println("-A senha precisa ter pelo menos 6 caracteres!");
            }
            //Caractere especial
            if(!caracterEspecial(aux)){
                cond1++;
                System.out.println("-A senha precisa ter pelo menos 1 caractere especial! Ex:!,?,#,$,etc.");
            }
            //Numero
            if(!number(aux)){
                cond1++;
                System.out.println("-A senha precisa ter pelo menos 1 número!");
            }
            //Letra maiúscula
            if(!maiúscula(aux)){
                cond1++;
                System.out.println("-A senha precisa ter pelo menos 1 letra Maiúscula!");
            }
            //Letra minúscula
            if(!minúscula(aux)){
                cond1++;
                System.out.println("-A senha precisa ter pelo menos 1 letra Minúscula!");
            }

            if(cond1!=0){
                System.out.println("\nPor favor, digite outra senha:");
                senha = in.nextLine();
                return senhaCerta(senha);
            }
        }
        return senha;
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
            System.out.println("Digite sua senha:");
            String senha = in.nextLine();

            senha = senhaCerta(senha);
        
        System.out.println("A senha foi cadastrada com sucesso! Quer saber a senha? s/n");

        
         
    }
}

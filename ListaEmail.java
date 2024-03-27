
import java.util.Scanner;


class Node{//Definição da classe Node, que representa cada nó(email)
    String email;//Valor armazenado no nó (email)
    Node proximo;//Referência para o próximo nó na lista (ponteiro)
    

    
    public Node(String data){ //Construtor que inicializa um novo nó com o valor fornecido
        this.email = data;
        this.proximo = null;//Inicialmente, não há próximo nó
    }
}



public class ListaEmail{ //Definição da classe ListaEmail,com os métodos para manipular a lista encadeada

    
    private Node inicio; //Referência para o primeiro nó da lista (inicio)

    
    public ListaEmail(){//Construtor que inicializa uma lista de emails vazia 
        this.inicio = null;
    }

//--------------------------------MÉTODO PARA ADICIOINAR UM NOVO EMAIL------------------------------------
    
    public void addEmail(String novoEmail){ 

        Node newNode = new Node(novoEmail);//Cria um novo nó com o nome do email(objeto email criado)

        if (inicio == null){
            inicio = newNode;//Se a lista estiver vazia, define o novo nó como inicio ( inicio aponta para newNode [inicio ----> newNode] )

        }else{
            Node atual = inicio; //atual tambem aponta para newNode (atual ----> newNode)
            
            //Percorre a lista até encontrar o último nó
            while (atual.proximo != null) { //de primeira esse loop não é executado pois próximo ainda é null.
                atual = atual.proximo;
            }
            
            atual.proximo = newNode;//Adiciona o novo nó após o último nó
        }
    }

//---------------------MÉTODO PARA EXIBIR A LISTA DE EMAILS-----------------------------------------------

 public void exibirLista(){

    Node atual = inicio;
    if (atual == null){
        System.out.println("Lista de email vazia");//mensagem exibida se a lista estiver vazia
    } else{
        System.out.print("Emails@: ");
        //Percorre a lista e exibe o nome de cada email em linha
        while (atual != null) {
            System.out.print(atual.email + ", ");
            atual = atual.proximo;//Move para o próximo nó na lista
            
        }
        System.out.println();//Pula para a próxima linha após imprimir todos os emails
    }
}

//---------------------MÉTODO PARA REMOVER EMAILS------------------------------------------------------------
   
    public void removeEmail(String deleteEmail){
        
    //Verifica se a lista está vazia
    if (inicio == null){
        System.out.println("Lista vazia, nada para remover!");
        return;
    }

    //Verifica se o email que irá ser removido está no inicio da lista
    if (inicio.email.equals(deleteEmail)){
        inicio = inicio.proximo; //Remove o inicio da lista
        return;
    }

    //Começa a busca pelo email que será removido a partir do segundo nó
    Node atual = inicio;
    while (atual.proximo != null){

        //Verifica se o próximo email na lista é o que será removido
        if (atual.proximo.email.equals(deleteEmail)){
            atual.proximo = atual.proximo.proximo;//Remove o nó da lista
            return;
        }
        atual = atual.proximo;//Move para o próximo nó na lista
    }

    //Se o email não foi encontrado na lista, exibe uma mensagem
    System.out.println("O email \"" + deleteEmail + "\" não está na lista.");
}

//---------------------MÉTODO PARA VERIFICAR SE UM EMAIL ESTÁ NA LISTA---------------------------------------
    
    public boolean vericaEmailNaLista(String verificaEmailNaLista){
        Node atual = inicio;
        while (atual != null){
            if (atual.email.equals(verificaEmailNaLista)){
                return true;//Retorna true se o email for encontrado
            }
            atual = atual.proximo;//Move para o próximo nó na lista
        }
        return false;//Retorna false se o email não for encontrado
    }




//==============================//Método main\\================================
    
    public static void main(String[] args){

        ListaEmail meusEmails = new ListaEmail();
        Scanner scanner = new Scanner(System.in);

        System.err.println("");
        System.err.println("LISTA DE EMAIL@:");
        System.err.println("");
        System.out.println("[ADICIONAR E-MAIL] Digite o email@ para adicionar, ou 'x' para sair:");

        while (true){
            String novoEmail = scanner.nextLine(); 
            if (novoEmail.equals("x")){
                break;
            }
            System.err.println("------------------------------------------------------------");
            meusEmails.addEmail(novoEmail);
            meusEmails.exibirLista();
            System.err.println("------------------------------------------------------------");
            System.out.println("\nDigite o @email para adicionar, ou 'x' para sair:");
        }

//-----------------------------------------------------------------------------------------------------------------------

        while (true){
            //------Solicita ao usuário que digite o email que deseja remover ou 'x' para sair------:
            System.out.println("\n[REMOVER E-MAIL] Digite o nome do email que deseja REMOVER, ou 'x' para sair:");
            String emailParaRemover = scanner.nextLine();
        
            //Verifica se o usuário digitou 'x' para sair do loop
            if (emailParaRemover.equals("x")) {
                break;
            }
        
        
            //Exibe uma mensagem informando se o email foi removida com sucesso ou não
            if (meusEmails.vericaEmailNaLista(emailParaRemover)) {
                
                meusEmails.removeEmail(emailParaRemover);//Remove o email da lista
                System.out.println("O E-mail@  \"" + emailParaRemover + "\" foi removida com sucesso.");
                System.err.println("------------------------------------------------------------");
            }else{
                
                System.out.println("O E-mail@ \"" + emailParaRemover + "\" não foi encontrada na lista de E-MAIL.");
                System.err.println("------------------------------------------------------------");
            }
        
            
            meusEmails.exibirLista();//Exibe a lista após a remoção
        
            //Exibe uma mensagem indicando que o usuário pode digitar o nome do proximo email para remover, ou 'x' para sair.
            System.err.println("------------------------------------------------------------");
        }
        scanner.close();
    }

    
    
}

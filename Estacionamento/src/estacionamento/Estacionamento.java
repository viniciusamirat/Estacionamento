/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estacionamento;

import static estacionamento.Biblioteca.Disponivel;
import static estacionamento.Biblioteca.pesquisa;
import static estacionamento.Biblioteca.separador;
import java.util.Scanner;

/**
 *
 * @author Vinícius Amirat
 */
public class Estacionamento {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner carro = new Scanner(System.in);
        Scanner num = new Scanner(System.in);
        boolean dispo;
        
        int contador = 0, opcao, lotado = 0;
        String vagas[][] = new String[5][2];
        String cor, placa;
        
        System.out.println("---ESTACIONAMENTO---\n");
        
        while (contador == 0){
            System.out.println("-1 Número total de vagas.\n"
                    + "-2 Vagas disponíveis e ocupadas.\n"
                    + "-3 Estacionar.\n"
                    + "-4 Retirar carro.\n"
                    + "-5 Sair.");
            System.out.print("Digite a opção escolhida: ");
            opcao = num.nextInt();
            
            separador();
            
            switch (opcao){
                //total de vagas
                case 1:
                    System.out.println("Total de vagas: " + vagas.length);
                    separador();
                break;
                //vagas disponíveis ou indiponíveis
                case 2:
                    for (int c = 0;c<=vagas.length-1;c++){
                        dispo = Disponivel(vagas[c][0]);
                        if (dispo == true){
                            System.out.println("Vaga " + (c+1) + ": DISPONÍVEL!");
                        } else {
                            System.out.print("Vaga " + (c+1) + ": Ocupada pelo"
                                    + " carro " + vagas[c][0] + " de"
                                            + " placa " + vagas[c][1] + "!\n");
                        }
                    }
                    separador();
                break;
                //estacionar
                case 3:
                    //verifica se o estacionamento está lotado
                    if (lotado == vagas.length){
                        System.out.println("Todas as vagas estão ocupadas, "
                                + "volte mais tarde...");
                        separador();
                    } else {
                        int i = 0;
                        while(i == 0){
                            System.out.print("Digite o número da vaga que você deseja"
                                + " estacionar: ");
                            opcao = num.nextInt();
                            opcao--;
                            
                            //verifica se a vaga escolhida está ocupada
                            if (vagas[opcao][0] != null){
                                separador();
                                System.out.println("Vaga indisponível. Escolha outra!");
                                separador();
                            } else {
                                i = 1; //sai do looping de selecionar a vaga
                            }
                        }

                        System.out.print("Digite a cor do carro: ");
                        cor = carro.nextLine();

                        System.out.print("Digite a placa do carro: ");
                        placa = carro.nextLine();
                        
                        //verifica se a placa já está no estacionamento
                        boolean existe = false;
                        for (int c =0;c<=vagas.length-1;c++){
                            if (pesquisa(vagas[c][1], placa) == 1){
                                System.out.println("Essa placa já está no"
                                        + " estacionamento!");
                                existe = true;
                                separador();
                                break;
                            }
                        }
                        
                        //estaciona o carro se ele já não estiver no estacionamento
                        if (existe == false){
                            vagas[opcao][0] = cor;
                            vagas[opcao][1] = placa;

                            System.out.println("\nCARRO ESTACIONADO!");
                            separador();

                            lotado++;
                        }
                    }
                break;
                //retirar carro
                case 4:
                    boolean existe = false;
                    System.out.print("Digite a placa do seu carro: ");
                    placa = carro.nextLine();
                    
                    //verifica se o carro está no estacionamento
                    for (int c =0;c<=vagas.length-1;c++){
                        if (pesquisa(vagas[c][1], placa) == 1){
                            vagas[c][0] = null;
                            vagas[c][1] = null;
                            existe = true;
                            
                            System.out.println("\nCARRO RETIRADO!");
                            lotado--;
                            separador();
                            break;
                        }
                    }
                    
                    //exibe na tela se não estiver
                    if (existe == false){
                        separador();
                        System.out.println("A placa digitada não existe!");
                        separador();
                    }
                break;
                //sair
                case 5:
                    System.exit(0);
                break;
                //caso o usuário digite uma opção que não existe
                default:
                    System.out.println("Digite uma opção válida!!!");
                    
                    separador();
                break;
            }
        }
    }
}

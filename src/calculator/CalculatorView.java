
package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class CalculatorView extends JFrame{
    private JPanel container = new JPanel();
    //Tableau stockant les éléments à afficher dans la calculatrice
    String[] tab_string = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "=", "C", "+", "-", "*", "/"};
    //Un bouton par élément à afficher
    JButton[] tab_button = new JButton[tab_string.length];
    public JLabel ecran = new JLabel();
    private Dimension dim = new Dimension(50, 40);
    private Dimension dim2 = new Dimension(50, 31);
    private double chiffre1;
    private boolean clicOperateur = false, update = false;
    private String operateur = "";

    public CalculatorView(){
        this.setSize(260, 280);
        this.setTitle("Calculette");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        //On initialise le conteneur avec tous les composants
        initComposant();
        //On ajoute le conteneur
        this.setContentPane(container);
        this.setVisible(true);
    }

    private void initComposant(){
        //On définit la police d'écriture à utiliser
        Font police = new Font("Arial", Font.BOLD, 20);
        ecran = new JLabel("0");
        ecran.setFont(police);
        //On aligne les informations à droite dans le JLabel
        ecran.setHorizontalAlignment(JLabel.RIGHT);
        ecran.setPreferredSize(new Dimension(220, 20));
        JPanel operateur = new JPanel();      
        operateur.setPreferredSize(new Dimension(55, 225));
        JPanel chiffre = new JPanel();
        chiffre.setPreferredSize(new Dimension(165, 225));
        JPanel panEcran = new JPanel();
        panEcran.setPreferredSize(new Dimension(220, 30));

        //On parcourt le tableau initialisé
        //afin de créer nos boutons
        for(int i = 0; i < tab_string.length; i++){
            tab_button[i] = new JButton(tab_string[i]);
            tab_button[i].setPreferredSize(dim);
            switch(i){
                //Pour chaque élément situé à la fin du tableau
                //et qui n'est pas un chiffre
                //on définit le comportement à avoir grâce à un listener
                case 11 :
                chiffre.add(tab_button[i]);
                
                break;
                case 12 :
                tab_button[i].setForeground(Color.red);
                
                operateur.add(tab_button[i]);
                break;
                case 13 :
                tab_button[i].setPreferredSize(dim2);
                operateur.add(tab_button[i]);
                break;
                case 14 :
                tab_button[i].setPreferredSize(dim2);
                operateur.add(tab_button[i]);
                break;	
                case 15 :	
                tab_button[i].setPreferredSize(dim2);
                operateur.add(tab_button[i]);
                break;
                case 16 :
                tab_button[i].setPreferredSize(dim2);
                operateur.add(tab_button[i]);
                break;
                default :
                //Par défaut, ce sont les premiers éléments du tableau
                //donc des chiffres, on affecte alors le bon listener
                chiffre.add(tab_button[i]);
                break;
            }
        }
        panEcran.add(ecran);
        panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
        container.add(panEcran, BorderLayout.NORTH);
        container.add(chiffre, BorderLayout.CENTER);
        container.add(operateur, BorderLayout.EAST);
        
        
    }
     public void addListener(ActionListener a){
        for(int i=0;i<tab_button.length;i++){
            tab_button[i].addActionListener(a);
        }
    }

}

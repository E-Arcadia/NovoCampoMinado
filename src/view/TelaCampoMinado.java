package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controle.Jogo;
import sun.reflect.generics.tree.Tree;

public class TelaCampoMinado extends JFrame implements ActionListener {

	private int quantidadeLinhas;
	private int quantidadeColunas;
	private Jogo jogo;

	public TelaCampoMinado() {
		super("Tela Campo Minado");
		quantidadeLinhas = perguntaQuantas("Quantas Linhas de 5 a 20?");
		quantidadeColunas = perguntaQuantas("Quantas Colunas de 5 a 20?");

		jogo = new Jogo(this, quantidadeLinhas, quantidadeColunas);
		add(jogo.getPainelCampoMinado());

		System.out.println(quantidadeLinhas + " - " + quantidadeColunas);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private int perguntaQuantas(String string) {
		boolean repete;
		int tamanhoSolicitado = 0;
		do {
			String valorInformado = JOptionPane.showInputDialog(string);
			try {
				tamanhoSolicitado = Integer.parseInt(valorInformado);
				repete = false;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valor inválido");
				repete = true;
			}

			if (tamanhoSolicitado < 5 || tamanhoSolicitado > 20) {
				JOptionPane.showMessageDialog(null, "Valor improprio.");
				repete = true;
			}
		} while (repete);
		return tamanhoSolicitado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton jButton = (JButton) e.getSource();
		if (jButton.getBackground() == Color.YELLOW)
			jButton.setBackground(Color.GREEN);
		else
			jButton.setBackground(Color.YELLOW);
		
		jogo.marcaEntorno(e.getActionCommand());
			
		
	}

}














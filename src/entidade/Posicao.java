package entidade;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Posicao {

	private int linha;
	private int coluna;
	private boolean bomba;
	private boolean clicado;
	private JButton jButton;
	

	public Posicao(ActionListener actionListener,int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		this.bomba = false;
		this.clicado = false;
		jButton = new JButton(linha + "," + coluna);
		jButton.setActionCommand(linha + ":" + coluna);
		jButton.setToolTipText(linha + "," + coluna);
		jButton.addActionListener(actionListener);
	}


	public Component getjButton() {
		return jButton;
	}



}

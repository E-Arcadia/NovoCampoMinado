package entidade;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Posicao {

	private int linha;
	private int coluna;
	private boolean bomba;
	private boolean clicado;
	private JButton jButton;
	private static Image imagemMenor = null;
	

	public Posicao(ActionListener actionListener,int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		this.bomba = false;
		this.clicado = false;
		jButton = new JButton(linha + "," + coluna);
		jButton.setActionCommand(linha + ":" + coluna);
		jButton.setToolTipText(linha + "," + coluna);
		jButton.addActionListener(actionListener);
		if (this.imagemMenor == null){
			Image imagem = null;
			try {
				imagem = ImageIO.read(getClass().getResource("../imagens/bomba.jpg"));
				imagemMenor = imagem.getScaledInstance(25, 20, Image.SCALE_SMOOTH);
			} catch (IOException e) {
				System.out.println("ERRO ao carregar icon!!!");
			}
		}
	}


	public Component getjButton() {
		return jButton;
	}


	public boolean isBomba() {
		return bomba;
	}


	public void setBomba() {
		this.bomba = true;
		jButton.setText("");
//		jButton.setForeground(Color.RED);
		jButton.setIcon(new ImageIcon(imagemMenor));
		
	}



}

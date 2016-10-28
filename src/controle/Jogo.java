package controle;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import entidade.Posicao;

public class Jogo {

	private Posicao arrayDePosicoes[][];
	private int quantidadeLinhas;
	private int quantidadeColunas;
	private JPanel painelCampoMinado;
	private ActionListener actionListener;

	public Jogo(ActionListener actionListener, int quantidadeLinhas, int quantidadeColunas) {
		this.actionListener = actionListener;
		this.quantidadeLinhas = quantidadeLinhas;
		this.quantidadeColunas = quantidadeColunas;
		arrayDePosicoes = new Posicao[quantidadeLinhas][quantidadeColunas];
		painelCampoMinado = new JPanel(new GridLayout(quantidadeLinhas, quantidadeColunas));
		criaAsPosicoes();

	}

	private void criaAsPosicoes() {
		for (int linha = 0; linha < quantidadeLinhas; linha++)
			for (int coluna = 0; coluna < quantidadeColunas; coluna++) {
				arrayDePosicoes[linha][coluna] = new Posicao(actionListener, linha, coluna);
				painelCampoMinado.add(arrayDePosicoes[linha][coluna].getjButton());
			}
	}

	public JPanel getPainelCampoMinado() {
		return painelCampoMinado;
	}

	public void marcaEntorno(String coordenadaString) {
		String[] coordenada = coordenadaString.split(":");
		int linha = Integer.parseInt(coordenada[0]);
		int coluna = Integer.parseInt(coordenada[1]);

		// -1L -1C | -1L C | -1L +1C
		// L -1C | L C | L +1C
		// +1L -1C | +1L C | +1L +1C

		arrayDePosicoes[linha - 1][coluna - 1].getjButton().setBackground(Color.GRAY);
		arrayDePosicoes[linha - 1][coluna].getjButton().setBackground(Color.GRAY);
		arrayDePosicoes[linha - 1][coluna + 1].getjButton().setBackground(Color.GRAY);

		arrayDePosicoes[linha][coluna - 1].getjButton().setBackground(Color.GRAY);
		arrayDePosicoes[linha][coluna + 1].getjButton().setBackground(Color.GRAY);

		arrayDePosicoes[linha + 1][coluna - 1].getjButton().setBackground(Color.GRAY);
		arrayDePosicoes[linha + 1][coluna].getjButton().setBackground(Color.GRAY);
		arrayDePosicoes[linha + 1][coluna + 1].getjButton().setBackground(Color.GRAY);

	}

}

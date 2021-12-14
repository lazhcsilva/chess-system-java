package chess;

import boardgame.Position;

public class ChessPosition {

	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	/*
	 
	 Neste metódo, para encontrar a posição da linha e colunca corretos, será feita da seguinte maneira
	 Linha = subtrair o valor 8, do valor da linha.
	 Coluna = subtrair a coluna do valor unicode 'a', obtendo assim o valor da posição exata da coluna.
	  
	 */
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	/*
	 
	 Implementando a operação inversa, convertendo para uma posição de xadrez 
	 
	 */
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
	
}

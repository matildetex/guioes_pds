import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JogoGalo implements JGaloInterface {

    private char matriz_galo[][];
    private char current_player;
    private int jogadas;

    public JogoGalo(char arg) { // caso sejam passados argumentos
        this.matriz_galo = new char[3][3];
        for (int l = 0; l < matriz_galo.length; l++) {
            for (int c = 0; c < matriz_galo.length; c++) {
                this.matriz_galo[l][c] = ' ';
            }
        }
        this.current_player = arg;
    }

    public JogoGalo() { // caso não sejam passados argumentos
        System.out.println("Não é uma jogada válida.\n");
    }

    public char getActualPlayer() {
        return this.current_player;
    }

    public boolean setJogada(int lin, int col) {

        this.matriz_galo[lin - 1][col - 1] = this.current_player;
        if (this.current_player == 'X') { // mudar de player
            this.current_player = 'O';
        } else {
            this.current_player = 'X';
        }
        this.jogadas++;
        return true;
    }

    public boolean isFinished() {

        if (this.jogadas == 9 || checkResult() != ' ') { // se já foram feitas 9 jogadas ou se já algum dos jogadores ganhou
            return true;
        } else {
            return false;
        }
    }

    public char checkResult() {

        char result = ' '; // empate

        // verificar se alguma coluna está preenchida com o mesmo caracter e que não é vazia
        for (int c = 0; c < 3; c++) {
            if (this.matriz_galo[0][c] == this.matriz_galo[1][c] && this.matriz_galo[1][c] == this.matriz_galo[2][c] && this.matriz_galo[0][c] != ' ') {
                result = this.matriz_galo[0][c];
            }
        }

        // verificar se alguma linha está preenchida com o mesmo caracter e que não é vazia
        for (int l = 0; l < this.matriz_galo.length; l++) {
            if (this.matriz_galo[l][0] == this.matriz_galo[l][1] && this.matriz_galo[l][1] == this.matriz_galo[l][2] && this.matriz_galo[l][0] != ' ') {
                result = this.matriz_galo[l][0];
            }
        }

        // verificar se alguma diagonal está preenchida com o mesmo caracter e que não é vazia
        if (this.matriz_galo[0][0] == this.matriz_galo[1][1] && this.matriz_galo[1][1] == this.matriz_galo[2][2] && this.matriz_galo[0][0] != ' ') {
            result = this.matriz_galo[0][0];
        } else if (this.matriz_galo[2][0] == this.matriz_galo[1][1] && this.matriz_galo[1][1] == this.matriz_galo[0][2] && this.matriz_galo[2][0] != ' ') {
            result = this.matriz_galo[2][0];
        }

        return result;
    }
}

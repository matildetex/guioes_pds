package JGalo;
public class PlayJGalo implements JGaloInterface {
    private char[][] board;
    private char actualPlayer;
    private int plays;

    public PlayJGalo(){
        this.board = new char[3][3];
        this.actualPlayer = 'X';
        this.plays = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.board[i][j] = 0;
            }
        }
    }
    
    public char getActualPlayer(){
        return this.actualPlayer;
    }

    public boolean setJogada(int lin, int col){
        this.board[lin-1][col-1] = this.actualPlayer;
        this.plays++;
        return true;
    }

    public boolean isFinished(){
        if(this.plays == 9 || checkResult() != ' ' ){
            return true;
        }
        else{
            this.actualPlayer = getActualPlayer() == 'X' ? 'O' : 'X';
            return false;
        }
    }

    public char checkResult(){
        char actualResult = ' ';

        if(checkDiagonal()){
            actualResult = board[1][1];
        }
        else{
            actualResult = checkColumnsOrLines();
        }

        return actualResult;

    }

    private char checkColumnsOrLines(){
        for(int i = 0;i < 3;i++){
            if((this.board[i][0] == this.board[i][1] && this.board[i][0] == this.board[i][2]) && this.board[i][0] != 0){
                return this.board[i][0];
            }
            if((this.board[0][i] == this.board[1][i] && this.board[0][i] == this.board[2][i]) && this.board[0][i] != 0){
                return this.board[0][i];
            }
        }
        return ' ';
    }

    private boolean checkDiagonal(){
        if((this.board[0][0] != 0) && ((this.board[0][0] == this.board[1][1]) && (this.board[0][0]== this.board[2][2]))){
            return true;
        }
        else if((this.board[2][0] != 0) && ((this.board[2][0] == this.board[1][1]) && (this.board[2][0]== this.board[0][2]))){
            return true;
        }
        return false;
    }

}

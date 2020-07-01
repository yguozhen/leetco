package binarySearch;

public class M_419BattleshipsInaBoard {

    //solution1 change "X" to "." in board
    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(board[i][j] == 'X'){
                    board[i][j] = '.';
                    int temp1 = i;
                    int temp2 = j;
                    while(i < board.length && j < board[0].length){
                        if(i + 1 < board.length && board[i + 1][j] == 'X'){
                            i = i + 1;
                            board[i][j] = '.';
                            continue;
                        }
                        else if(j + 1 < board[0].length && board[i][j + 1] == 'X'){
                            j = j + 1;
                            board[i][j] = '.';
                            continue;
                        }
                        else {
                            count ++;
                            break;
                        }

                    }
                    i = temp1;
                    j = temp2;
                }
            }
        }
        return count;
    }

    //solution2 without change the value in board
    public int countBattleships2(char[][] board) {
        if(board == null){
            return 0;
        }
        int res = 0;
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(i + 1 < board.length && board[i + 1][j] == 'X'){
                    continue;
                }
                if(j + 1 < board[0].length && board[i][j + 1] == 'X'){
                    continue;
                }
                res ++;
            }
        }
        return res;
    }
}

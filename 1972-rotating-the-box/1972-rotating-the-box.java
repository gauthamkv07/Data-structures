class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] res = new char[n][m];

        for (int i = 0; i < m; i++) {
            int col = m - i - 1;
            int pos = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    res[pos][col] = '#';
                    pos--;
                } else if (box[i][j] == '*') {
                    pos = j;
                    res[pos][col] = '*';
                    pos--;
                }
            }
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (res[i][j] != '*' && res[i][j] != '#')
                    res[i][j] = '.';

        return res;
    }
}
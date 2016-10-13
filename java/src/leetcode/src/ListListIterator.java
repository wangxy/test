/**
 * Created by xwang on 5/12/16.
 */
public class ListListIterator {

    int curRow;
    int curColumn;

    int[][] data;
    ListListIterator(int[][] input) {
        curRow = 0;
        curColumn = -1;
        data = input;
    }

    public boolean hasNext() {
        return hasMoreCurRow() || hasMoreRows();
    }

    private boolean hasMoreCurRow(){
        int curRowLen = data[curRow].length;
        return curRowLen > curColumn + 1;
    }

    private boolean hasMoreRows() {
        int cur = curRow + 1;
        while (cur < data.length) {
            if (data[cur].length > 0) {
                return true;
            }
            cur++;
        }
        return false;
    }

    private int findNextRow() {
        int cur = curRow + 1;
        while(cur < data.length) {
            if (data[cur].length > 0) {
                return cur;
            }
            cur++;
        }
        return -1;
    }

    // remove the current element
    public void remove(){
        int[] newRow = new int[data[curRow].length - 1];
        int index = 0;
        for (int i = 0; i < data[curRow].length; i++){
            if (i != curColumn) {
                newRow[index] = data[curRow][i];
                index++;
            }
        }
        data[curRow] = newRow;
        // adjust cursor
        curColumn--;
        if (curColumn < 0) {
            int prevRow = findPrevRow();
            if (prevRow >= 0) {
                curRow = prevRow;
                curColumn = data[curRow].length - 1;
            }
        }

    }

    private int findPrevRow(){
        int cur = curRow - 1;
        while (cur >= 0) {
            if (data[cur].length > 0) {
                return cur;
            }
            cur--;
        }
        return -1;
    }

    public int next(){
        if (hasMoreCurRow()) {
            curColumn++;
            return data[curRow][curColumn];
        }

        if (hasMoreRows()) {
            curRow = findNextRow();
            curColumn = 0;
            return data[curRow][curColumn];
        }

        return -1;

    }

    public void reset(){
        this.curRow = 0;
        this.curColumn = -1;
    }

    public static void main(String[] args){
        int[][] input = {{1}, {}, {2, 3, 4}};
        ListListIterator iter = new ListListIterator(input);
        while (iter.hasNext()) {
            int val = iter.next();
            System.out.println(val);
            if (val == 2) {
                iter.remove();
            }
        }
        iter.reset();
        while (iter.hasNext()) {
            int val = iter.next();
            System.out.println(val);
        }

        System.out.println(Math.pow(2, 3));

    }
}

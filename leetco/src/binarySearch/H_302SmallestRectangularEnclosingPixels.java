package binarySearch;

public class H_302SmallestRectangularEnclosingPixels {
    //solution1 brute o(mn)
    public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0){
            return 0;
        }
        int high = x, low = x, left = y, right = y;
        for(int i = 0; i < image.length; i ++){
            for(int j = 0; j <image[0].length; j ++){
                if(image[i][j] == '1'){
                    high = Math.min(high, i);
                    low = Math.max(low, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }
        return (low - high + 1)*(right - left + 1);
    }

    //solution2 o(mlogn + nlogm) binary search
    public int minArea2(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int left = searchColumns(image, 0, y, 0, m, true);
        int right = searchColumns(image, y + 1, n, 0, m, false);
        int top = searchRows(image, 0, x, left, right, true);
        int bottom = searchRows(image, x + 1, m, left, right, false);
        return (right - left) * (bottom - top);
    }
    private int searchColumns(char[][] image, int i, int j, int top, int bottom, boolean whiteToBlack) {
        while (i != j) {
            int k = top, mid = (i + j) / 2;
            while (k < bottom && image[k][mid] == '0') ++k;
            if (k < bottom == whiteToBlack) // k < bottom means the column mid has black pixel
                j = mid; //search the boundary in the smaller half
            else
                i = mid + 1; //search the boundary in the greater half
        }
        return i;
    }
    private int searchRows(char[][] image, int i, int j, int left, int right, boolean whiteToBlack) {
        while (i != j) {
            int k = left, mid = (i + j) / 2;
            while (k < right && image[mid][k] == '0') ++k;
            if (k < right == whiteToBlack) // k < right means the row mid has black pixel
                j = mid;
            else
                i = mid + 1;
        }
        return i;
    }
}

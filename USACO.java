import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class USACO{
	public static int bronze(String filename) throws FileNotFoundException{
		File input = new File(filename);
		Scanner sys = new Scanner(input);
		int r = Integer.parseInt(sys.next());
		int c = Integer.parseInt(sys.next());
		int e = Integer.parseInt(sys.next());
		int n = Integer.parseInt(sys.next());
		int tot = 0;
		int [][] farm = new int[r][c];
		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++){
				farm[i][j] = Integer.parseInt(sys.next());
			}
		}
		//initializes the array
		while(sys.hasNextLine()){
			int rs = Integer.parseInt(sys.next()) - 1;
			int cs = Integer.parseInt(sys.next()) - 1;
			int ds = Integer.parseInt(sys.next());
			int max = farm[rs][cs];
			for(int k = 0; k <= 2; k++){
				for(int l = 0; l <= 2; l++){
					if(rs + k < r && cs + l < c){
						if(farm[rs + k][cs + l] > max) max = farm[rs + k][cs + l];
					}
				}
			}
			int depth = max - ds;
			for(int m = 0; m <= 2; m++){
				for(int p = 0; p <= 2; p++){
					if(rs + m < r && cs + p < c){//find the squares in bound
						if(farm[rs + m][cs + p] > depth){
							farm[rs + m][cs + p] = depth;
						}
					}
				}
			}
		}

		for(int a = 0; a < r; a++){
			for(int b = 0; b < c; b++){
				if(farm[a][b] < e){
					tot += e - farm[a][b];
				}
			}
		}
		int result = tot * 72 * 72;
		return result;
	}
}

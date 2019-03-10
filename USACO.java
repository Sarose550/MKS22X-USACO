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
	public static int silver(String filename) throws FileNotFoundException{
		File input = new File(filename);
		Scanner sys = new Scanner(input);
		int n = Integer.parseInt(sys.next());
		int m = Integer.parseInt(sys.next());
		int t = Integer.parseInt(sys.next());
		char[][] farm = new char[n][m];
		int[][][] info = new int[n][m][2];
		for(int i = 0; i < n; i++){
			String row = sys.next();
			for(int j = 0; j < m; j++){
				farm[i][j] = row.charAt(j);
			}
		}
		int r1 = Integer.parseInt(sys.next()) - 1;
		int c1 = Integer.parseInt(sys.next()) - 1;
		int r2 = Integer.parseInt(sys.next()) - 1;
		int c2 = Integer.parseInt(sys.next()) - 1;
		info[r1][c1][0] = 1;
		for(int x = 0; x < t; x++){
			for(int a = 0; a < n; a++){
				for(int b = 0; b < m; b++){
					if(!(farm[a][b] == '*')){//don't spread path counts to trees so they're always 0
						for(int y = -1; y <= 1; y++){
							for(int z = -1; z <= 1; z++){
								if(y * z == 0 && (y + z != 0)){
									if(a + y < n && a + y >= 0 && b + z < m && b + z >= 0){//all the neighboring squares in bounds
										info[a][b][1] += info[a + y][b + z][0];// add the previous path counts of all the neighboring squares
									}
								}
							}
						}
					}
				}
			}
			for(int c = 0; c < n; c++){
				for(int d = 0; d < m; d++){
					info[c][d][0] = info[c][d][1];
					info[c][d][1] = 0;
				}
			}
		}
		return info[r2][c2][0];
	}
}

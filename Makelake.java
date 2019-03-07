import java.util.Scanner;
public class Makelake{
	public static void main(String[] args){
		new Makelake().run();
	}

	private void run(){
		Scanner sys = new Scanner("Makelake.java");
		while(sys.hasNext()){
			System.out.println(sys.next());
		}
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
			int rs = Integer.parseInt(sys.next());
			int cs = Integer.parseInt(sys.next());
			int ds = Integer.parseInt(sys.next());
			int max = farm[rs][cs];
			for(int k = -1; k <= 1; k++){
				for(int l = -1; l <= l; l++){
					if(rs + k < r && cs + l < c){
						if(farm[rs + k][cs + l] > max) max = farm[rs + k][cs + l];
					}
				}
				int depth = max - ds;
				for(int m = -1; m <= 1; m++){
					for(int p = -1; p <= 1; p++){
						if(rs + m < r && cs + p < c){
							if(farm[rs + m][cs + p] > depth){
								tot += farm[rs + m][cs + p] - depth;
								farm[rs + m][cs + p] = depth;
							}
						}
					}
				}
			}
			int result = tot * 72 * 72;
			System.out.println(result);
		}
	}
}

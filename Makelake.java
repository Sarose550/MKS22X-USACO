import java.util.Scanner;
public class Makelake{
	public static void main(String[] args){
		new Makelake().run();
	}

	private void run(){
		Scanner sys = new Scanner("makelake.in");
		int r = Integer.parseInt(sys.next());
		int c = Integer.parseInt(sys.next());
		int e = Integer.parseInt(sys.next());
		int n = Integer.parseInt(sys.next());
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
			
		}
	}
}

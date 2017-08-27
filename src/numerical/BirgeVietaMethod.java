package numerical;
import java.util.*;

public class BirgeVietaMethod {

	public static void main(String[] args) {
		new BirgeVietaMethod().start();

	}

	private void start() {
		Scanner r = new Scanner(System.in);
		int n ;
		float initial = 1;
		float[][] mat; 
		float tolerance = (float) 0.0001 ;
		float Fr = 1 ;
		n = r.nextInt();
		mat = new float[n+1][3];
		for(int i=0 ; i<=n ; i++){
			mat[i][0] = r.nextFloat();
		}
		initial = r.nextFloat();
		
		while( Math.abs(Fr) > 0.0001 ){
			
			
			mat[0][1] = mat[0][0];
			mat[0][2] = mat[0][0];
			for(int i=1 ;i<n ; i++){
				mat[i][1] = mat[i-1][1]*initial + mat[i][0]; 
				mat[i][2] = mat[i-1][2]*initial + mat[i][1];	
			}
			mat[n][1] = mat[n-1][1]*initial + mat[n][0];
			initial = initial - (mat[n][1] / mat[n-1][2]);
			Fr = 0 ;
			for(int i=0 ; i<=n ; i++){
				Fr += Math.pow(initial, n-i) * mat[i][0];
			}
			
			System.out.println("a     b     c");
			for(int i=0 ; i<=n ; i++){
				
				System.out.println(mat[i][0]+"  "+mat[i][1]+"  "+mat[i][2]);
			}
			
			System.out.println("new R = "+initial);
			System.out.println("f(x) = "+Fr);
			System.out.println();
			System.out.println();
		}
		
		
	}

}

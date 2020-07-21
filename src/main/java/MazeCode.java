public class MazeCode {
    static int N;
    static int M;


    static void printSolution(int solution[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                System.out.print(
                        " " + solution[i][j] + " ");
            System.out.println();
        }
    }

    boolean solveMaze(int maze[][])
    {
        int solution[][] = new int[N][M];

        findoptimalPath(maze,solution,0,0,N,M,Integer.MAX_VALUE, 0);
        printSolution(solution);
        return true;
    }


    private static int min(int first,int second){
        if (first<second)
            return first;
        else
            return second;
    }


    private static boolean isSafe(int maze[][], int solution[][], int x, int y)
    {
        return !(maze[x][y] == -1|| solution[x][y] != 0);
    }

    // if it is out of box return false
    private static boolean isValid(int x, int y)
    {
        return (x < N && y < M && x >= 0 && y >= 0);
    }

    public static int findoptimalPath(int maze[][],int solution[][],int i,int j, int n,int m , int minPath, int dist){
        if(i==n && j==m){
            System.out.println(min(dist,minPath));
            return min(dist,minPath);
        }
        solution[i][j]=1;



        if(isValid(i+1,j+1) && isSafe(maze,solution,i+1,j+1)){

            minPath=findoptimalPath(maze,solution,i+1 ,j+1,n,m,minPath,dist+1);
            solution[i+1][j+1]=1;
        }

        else if(isValid(i+1,j) && isSafe(maze,solution,i+1,j)){

            minPath=findoptimalPath(maze,solution,i+1 ,j,n,m,minPath,dist+1);
            solution[i+1][j]=1;
        }

        else if(isValid(i,j+1)&& isSafe(maze,solution,i,j+1)){
            minPath=findoptimalPath(maze,solution,i ,j+1,n,m,minPath,dist+1);
            solution[i][j+1]=1;
        }

//        else if(isValid(i,j-1)&& isSafe(maze,solution,i,j-1)){
//            minPath=findoptimalPath(maze,solution,i ,j-1,n,m,minPath,dist+1);
//            solution[i][j-1]=1;
//        }

//        else if(isValid(i-1,j)&& isSafe(maze,solution,i-1,j)){
//            minPath=findoptimalPath(maze,solution,i-1 ,j,n,m,minPath,dist+1);
//            solution[i-1][j]=1;
//        }


        solution[i][j]=1;
        return minPath;

    }

    public static void main(String args[])
    {
        MazeCode mouse = new MazeCode();
        int maze[][] = { { 0, 0, 0, 0, -1 },
                { 0, -1, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0,0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 }
        };

        N = maze.length;
        M = maze[0].length;
        mouse.solveMaze(maze);

    }
}

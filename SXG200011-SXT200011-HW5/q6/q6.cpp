// using floyd warshal algo.
#include <bits/stdc++.h>
using namespace std;

#define V 7

#define INF 99999

void printSolution(int dist[][V]);

void floydWarshall(int dist[][V])
{
	
	int i, j, k;
	for (k = 0; k < V; k++) {
		for (i = 0; i < V; i++) {
			for (j = 0; j < V; j++) {
				if (dist[i][j] > (dist[i][k] + dist[k][j])
					&& (dist[k][j] != INF
						&& dist[i][k] != INF))
					dist[i][j] = dist[i][k] + dist[k][j];
			}
		}
	}

	printSolution(dist);
}

void printSolution(int dist[][V])
{
	cout << "The following list shows the stations reachable using no more than four links. \n";
	for (int i = 0; i < V; i++) {
        cout<< "Station " << i+1 << ": ";
		for (int j = 0; j < V; j++) {
			if (dist[i][j] <= 4 && i!=j)
				cout << j+1 << " ";
				
		}
		cout << endl;
	}
}

int main()
{
	int graph[V][V] = { 
        { 0, 1, INF, INF, INF, INF, INF },
        { 1, 0, INF, INF, 1, INF, INF },
        { INF, INF, 0, 1, INF, 1, 1 },
        { INF, INF, 1, 0, INF, INF, INF },
        { INF, 1, INF, INF, 0, 1, INF },
        { INF, INF, 1, INF, 1, 0, INF },
        { INF, INF, 1, INF, INF, INF, 0 },		 
        };

	floydWarshall(graph);
	return 0;
}
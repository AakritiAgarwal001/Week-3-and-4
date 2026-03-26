class Client {
    String name;
    int riskScore;
    double balance;

    Client(String name, int riskScore, double balance) {
        this.name = name; this.riskScore = riskScore; this.balance = balance;
    }
    public String toString() { return name + "(" + riskScore + ")"; }
}

public class Questions {
    public static void sortAndRank(Client[] clients) {
        // Bubble Sort ASC for visualization
        int n = clients.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (clients[j].riskScore > clients[j + 1].riskScore) {
                    Client temp = clients[j];
                    clients[j] = clients[j + 1];
                    clients[j + 1] = temp;
                }
            }
        }

        // Insertion Sort DESC + Balance (Primary: Risk DESC, Secondary: Balance DESC)
        for (int i = 1; i < n; i++) {
            Client key = clients[i];
            int j = i - 1;
            while (j >= 0 && (clients[j].riskScore < key.riskScore ||
                    (clients[j].riskScore == key.riskScore && clients[j].balance < key.balance))) {
                clients[j + 1] = clients[j];
                j--;
            }
            clients[j + 1] = key;
        }

        System.out.print("Top Risks: ");
        for (int i = 0; i < Math.min(3, clients.length); i++) System.out.print(clients[i] + " ");
    }
}

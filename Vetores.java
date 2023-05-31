import java.util.Random;

// Definição da classe que representa um nó da lista duplamente encadeada
class Vetores {
    int data;
    Vetores prev;
    Vetores next;

    public Vetores(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// Definição da classe que representa a lista duplamente encadeada
class ListaDuplamenteEncadeada {
    Vetores head;

    public void inserir(int data) {
        Vetores newVetores=new Vetores(data);

        if (head == null) {
            head = newVetores;
        } else if (data <= head.data) {
            newVetores.next = head;
            head.prev = newVetores;
            head = newVetores;
        } else {
            Vetores current = head;

            while (current.next != null && current.next.data < data) {
                current = current.next;
            }

            newVetores.next = current.next;
            newVetores.prev = current;
            if (current.next != null) {
                current.next.prev = newVetores;
            }
            current.next = newVetores;
        }
    }

    public void removerPrimos() {
        Vetores current = head;

        while (current != null) {
            if (ehPrimo(current.data)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
            }
            current = current.next;
        }
    }

    private boolean ehPrimo(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public void imprimirOrdemCrescente() {
        Vetores current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void imprimirOrdemDecrescente() {
        Vetores current = head;
        while (current != null && current.next != null) {
            current = current.next;
        }

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}

